package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.Task;
import org.duraspace.fcrepo.cloudsync.api.TaskLog;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectSetDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectStoreDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskLogDao;
import com.github.cwilper.fcrepo.dto.core.io.DateUtil;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This Thread is responsible for managing the execution of tasks.
 *
 * <h2>Signals and State Transitions</h2>
 *
 * <ul>
 *   <li> For tasks in the "starting" state, spin up an appropriate
 *        TaskRunner and move to the "running" state in the database.</li>
 *   <li> For tasks in the "pausing" state, set a flag with the
 *        appropriate TaskRunner, requesting that it pause itself.
 *        Give the task some way to signal that it is actually paused,
 *        during which, among other things, the state in the database is set
 *        to "paused".</li>
 *   <li> For tasks in the "resuming" state, notify() the appropriate
 *        TaskRunner and move the state to "running" in the database.</li>
 *   <li> For tasks in the "canceling" state, set a flag with the
 *        appropriate TaskRunner, requesting that it cancel itself.
 *        Give the task some way to signal its completion, during which,
 *        among other things, the state in the database is set to idle.</li>
 * </ul>
 *
 * Note: The requestPause() and requestCancel() methods of a TaskRunner
 * may be called multiple times in a row. Implementations should ensure these
 * are not expensive calls to make. In addition, requestCancel() may be
 * called immediately after requestPause(), before pausing actually occurs.
 * TaskRunners should be smart enough to assume the request to Pause has
 * been overridden by the request to cancel.
 *
 * <h2>TaskManager Lifecycle</h2>
 *
 * The requestShutdown() method of this class is expected to be called from
 * the Servlet Context Listener. The method will loop until all tasks
 * are in the idle state, then signal to the TaskManager thread to complete.
 * If any tasks are not in the idle state, they will be set to "canceling".
 */
public class TaskManager extends Thread implements TaskCompletionListener {

    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);

    private static final int POLL_SECONDS = 5;

    private final TaskDao taskDao;
    private final TaskLogDao taskLogDao;
    private final ObjectSetDao objectSetDao;
    private final ObjectStoreDao objectStoreDao;
    private final HttpClientConfig httpClientConfig;

    private final Map<String, TaskRunner> runners;

    private boolean shutdownRequested;

    public TaskManager(TaskDao taskDao,
                       TaskLogDao taskLogDao,
                       ObjectSetDao objectSetDao,
                       ObjectStoreDao objectStoreDao,
                       HttpClientConfig httpClientConfig) {
        this.taskDao = taskDao;
        this.taskLogDao = taskLogDao;
        this.objectSetDao = objectSetDao;
        this.objectStoreDao = objectStoreDao;
        this.httpClientConfig = httpClientConfig;
        this.runners = new HashMap<String, TaskRunner>();
    }

    // Main loop -- Task State Transition
    private synchronized void mainLoop() {
        for (Task task: taskDao.listTasks()) {
            if (task.getState().equals(Task.STARTING)) {
                startTask(task);
            } else if (task.getState().equals(Task.PAUSING)) {
                pauseTask(task);
            } else if (task.getState().equals(Task.RESUMING)) {
                resumeTask(task);
            } else if (task.getState().equals(Task.CANCELING)) {
                cancelTask(task);
            }
        }
        try {
            wait(POLL_SECONDS * 1000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        cleanup(true); // in case of unclean shutdown
        while (!shutdownRequested) {
            mainLoop();
        }
        cleanup(false);
    }

    // Cancel any non-idle tasks and wait for them to go idle
    private void cleanup(boolean atStartup) {
        boolean allTasksIdle = false;
        while (!allTasksIdle) {
            int activeCount = 0;
            for (Task task: taskDao.listTasks()) {
                if (!task.getState().equals(Task.IDLE)) {
                    activeCount++;
                    if (!task.getState().equals(Task.CANCELING)) {
                        logger.info("Auto-canceling task " + task.getId() + " (" + task.getName() + ")");
                        taskDao.setTaskState(task.getId(), Task.CANCELING);
                        task.setState(Task.CANCELING);
                    }
                    if (atStartup) {
                        // We're cleaning up after an unclean shutdown.
                        // Since the TaskRunner isn't actually running, we make
                        // the direct call here to clean up the state in the
                        // database, marking it as canceled.
                        taskCanceled(task);
                    } else {
                        // In the normal case, the TaskRunner is running in a
                        // separate thread and we just need to request that
                        // it cancel at the next available opportunity.
                        cancelTask(task);
                    }
                }
            }
            if (activeCount == 0 || atStartup) {
                allTasksIdle = true;
            } else {
                logger.info("Waiting for " + activeCount + " task(s) to go idle.");
                sleepSeconds(1);
            }
        }
    }

    private void startTask(Task task) {
        String taskLogId = taskLogDao.start(task.getId());

        PrintWriter logWriter = taskLogDao.getContentWriter(taskLogId);

        Date startDate = taskLogDao.getTaskLog(taskLogId).getStartDate();
        logWriter.println("# Started at " + DateUtil.toString(startDate));

        TaskRunner runner = TaskRunner.getInstance(task, taskDao, objectSetDao, objectStoreDao, logWriter, this, httpClientConfig);
        synchronized (runners) {
            runners.put(task.getId(), runner);
        }
        runner.start();

        task.setActiveLogId(taskLogId);
        taskDao.setActiveLogId(task.getId(), task.getActiveLogId());

        taskDao.setTaskState(task.getId(), Task.RUNNING);
    }

    private void pauseTask(Task task) {
        synchronized (runners) {
            TaskRunner runner = runners.get(task.getId());
            if (runner != null) {
                runner.requestPause();
            }
        }
    }

    private void resumeTask(Task task) {
        synchronized (runners) {
            TaskRunner runner = runners.get(task.getId());
            if (runner != null) {
                runner.requestResume();
            }
        }
    }

    private void cancelTask(Task task) {
        synchronized (runners) {
            TaskRunner runner = runners.get(task.getId());
            if (runner != null) {
                runner.requestCancel();
                // might as well remove it?
                runners.remove(task.getId());
            }
        }
    }

    public void shutdown() {
        shutdownRequested = true;
        logger.info("Shutdown requested.");
        synchronized (this) {
            notifyAll();
        }
        while (isAlive()) {
            sleepSeconds(1);
        }
        logger.info("All tasks idle.");
    }

    private static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public Date taskSucceeded(Task task) {
        taskDao.goIdle(task.getId());
        return taskLogDao.finish(task.getActiveLogId(), TaskLog.SUCCEEDED);
    }

    @Override
    public Date taskFailed(Task task, Throwable cause) {
        taskDao.goIdle(task.getId());
        return taskLogDao.finish(task.getActiveLogId(), TaskLog.FAILED);
    }

    @Override
    public Date taskCanceled(Task task) {
        taskDao.goIdle(task.getId());
        return taskLogDao.finish(task.getActiveLogId(), TaskLog.CANCELED);
    }
}
