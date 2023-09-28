package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.Task;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectSetDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectStoreDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskDao;
import com.github.cwilper.fcrepo.dto.core.io.DateUtil;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;

public abstract class TaskRunner extends Thread {

    private final Logger logger = LoggerFactory.getLogger(TaskRunner.class);

    protected final Task task;
    protected final TaskDao taskDao;
    protected final ObjectSetDao objectSetDao;
    protected final ObjectStoreDao objectStoreDao;
    protected final PrintWriter logWriter;
    protected final TaskCompletionListener completionListener;

    protected boolean pauseRequested;
    protected boolean resumeRequested;
    protected boolean cancelRequested;

    protected TaskRunner(Task task,
                         TaskDao taskDao,
                         ObjectSetDao objectSetDao,
                         ObjectStoreDao objectStoreDao,
                         PrintWriter logWriter,
                         TaskCompletionListener completionListener) {
        this.task = task;
        this.taskDao = taskDao;
        this.objectSetDao = objectSetDao;
        this.objectStoreDao = objectStoreDao;
        this.logWriter = logWriter;
        this.completionListener = completionListener;
    }

    public static final TaskRunner getInstance(Task task,
                                               TaskDao taskDao,
                                               ObjectSetDao objectSetDao,
                                               ObjectStoreDao objectStoreDao,
                                               PrintWriter logWriter,
                                               TaskCompletionListener completionListener,
                                               HttpClientConfig httpClientConfig) {
        if (task.getType() != null && task.getType().length() > 0) {
            if (task.getType().equals("list")) {
                return new ListTaskRunner(task, taskDao, objectSetDao, objectStoreDao, logWriter, completionListener, httpClientConfig);
            } else if (task.getType().equals("copy")) {
                return new CopyTaskRunner(task, taskDao, objectSetDao, objectStoreDao, logWriter, completionListener, httpClientConfig);
            } else {
                throw new IllegalArgumentException("Unrecognized Task type: " + task.getType());
            }
        } else {
            throw new IllegalArgumentException("Task type not specified");
        }
    }

    @Override
    public final void run() {
        Date completionDate = null;
        String resultType = null;
        try {
            logger.info("Task " + task.getId() + " started (" + task.getName() + ")");
            pauseOrCancelIfRequested();
            runTask();
            pauseOrCancelIfRequested();
            logger.info("Task " + task.getId() + " succeeded (" + task.getName() + ")");
            completionDate = completionListener.taskSucceeded(task);
            resultType = "succeeded";
        } catch (TaskCanceledException e) {
            logger.info("Task " + task.getId() + " canceled (" + task.getName() + ")");
            completionDate = completionListener.taskCanceled(task);
            resultType = "canceled";
        } catch (Throwable th) {
            logger.info("Task " + task.getId() + " failed (" + task.getName() + ")");
            completionDate = completionListener.taskFailed(task, th);
            resultType = "failed";
            logWriter.print("ERROR: ");
            th.printStackTrace(logWriter);
        } finally {
            logWriter.println("# Finished (" + resultType + ") at " + DateUtil.toString(completionDate));
            logWriter.close();
        }
    }

    protected abstract void runTask() throws Exception;

    protected void pauseOrCancelIfRequested() throws TaskCanceledException {
        if (cancelRequested) {
            throw new TaskCanceledException();
        } else if (pauseRequested) {
            taskDao.setTaskState(task.getId(), Task.PAUSED);
            logger.info("Task " + task.getId() + " paused (" + task.getName() + ")");
            logWriter.println("# Paused at " + DateUtil.toString(new Date()));
            while (!resumeRequested) {
                if (cancelRequested) {
                    throw new TaskCanceledException();
                }
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                }
            }
            taskDao.setTaskState(task.getId(), Task.RUNNING);
            logger.info("Task " + task.getId() + " resumed (" + task.getName() + ")");
            logWriter.println("# Resumed at " + DateUtil.toString(new Date()));
            pauseRequested = false;
            resumeRequested = false;
        }
    }

    public Task getTask() {
        return task;
    }

    public void requestPause() {
        pauseRequested = true;
        resumeRequested = false;
        cancelRequested = false;
    }

    public void requestResume() {
        pauseRequested = false;
        resumeRequested = true;
        cancelRequested = false;
    }

    public void requestCancel() {
        pauseRequested = false;
        resumeRequested = false;
        cancelRequested = true;
    }

    public abstract Set<String> getRelatedSetIds();

    public abstract Set<String> getRelatedStoreIds();
}
