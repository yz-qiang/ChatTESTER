package org.duraspace.fcrepo.cloudsync.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import org.duraspace.fcrepo.cloudsync.api.AlreadyInitializedException;
import org.duraspace.fcrepo.cloudsync.api.CloudSyncService;
import org.duraspace.fcrepo.cloudsync.api.NameConflictException;
import org.duraspace.fcrepo.cloudsync.api.ObjectSet;
import org.duraspace.fcrepo.cloudsync.api.ObjectStore;
import org.duraspace.fcrepo.cloudsync.api.ProviderAccount;
import org.duraspace.fcrepo.cloudsync.api.ResourceInUseException;
import org.duraspace.fcrepo.cloudsync.api.ResourceNotFoundException;
import org.duraspace.fcrepo.cloudsync.api.ServiceInfo;
import org.duraspace.fcrepo.cloudsync.api.ServiceInit;
import org.duraspace.fcrepo.cloudsync.api.Space;
import org.duraspace.fcrepo.cloudsync.api.Task;
import org.duraspace.fcrepo.cloudsync.api.TaskLog;
import org.duraspace.fcrepo.cloudsync.api.UnauthorizedException;
import org.duraspace.fcrepo.cloudsync.api.User;
import org.duraspace.fcrepo.cloudsync.service.backend.TaskManager;
import org.duraspace.fcrepo.cloudsync.service.dao.DuraCloudDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectSetDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectStoreDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ServiceInfoDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskLogDao;
import org.duraspace.fcrepo.cloudsync.service.dao.UserDao;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;

public class CloudSyncServiceImpl implements CloudSyncService {

    private static final Logger logger = LoggerFactory.getLogger(CloudSyncServiceImpl.class);

    private final JdbcTemplate db;

    private final ServiceInfoDao serviceInfoDao;
    private final UserDao userDao;
    private final TaskDao taskDao;
    private final ObjectSetDao objectSetDao;
    private final ObjectStoreDao objectStoreDao;
    private final TaskLogDao taskLogDao;
    private final DuraCloudDao duraCloudDao;

    private final TaskManager taskManager;

    public CloudSyncServiceImpl(DataSource dataSource,
                                PlatformTransactionManager txMan,
                                HttpClientConfig httpClientConfig) {
        db = new JdbcTemplate(dataSource);
        TransactionTemplate tt = new TransactionTemplate(txMan);

        userDao = new UserDao(db, tt);
        serviceInfoDao = new ServiceInfoDao(db, userDao);
        objectSetDao = new ObjectSetDao(db);
        objectStoreDao = new ObjectStoreDao(db);
        taskDao = new TaskDao(db, tt, objectSetDao, objectStoreDao);
        taskLogDao = new TaskLogDao(db);
        duraCloudDao = new DuraCloudDao();

        if (db.queryForInt("SELECT COUNT(*) FROM sys.systables WHERE tablename = 'CLOUDSYNC'") == 0) {
            initDb();
        }
        logger.info("Service startup complete. Ready to handle requests.");

        taskManager = new TaskManager(taskDao, taskLogDao, objectSetDao, objectStoreDao, httpClientConfig);
        taskManager.start();
    }

    @PreDestroy
    public void close() {
        taskManager.shutdown();
    }

    private void initDb() {
        logger.info("First run detected. Creating database tables.");
        db.execute("create table CloudSync(schemaVersion int)");
        db.update("insert into CloudSync values (1)");
        serviceInfoDao.initDb();
        userDao.initDb();
        objectSetDao.initDb();
        objectStoreDao.initDb();
        taskDao.initDb();
        taskLogDao.initDb();
    }

    // -----------------------------------------------------------------------
    //                             ServiceInfo
    // -----------------------------------------------------------------------

    @Override
    public ServiceInfo getServiceInfo() {
        return serviceInfoDao.getServiceInfo();
    }

    @Override
    public ServiceInfo initialize(ServiceInit serviceInit)
            throws AlreadyInitializedException {
        if (getServiceInfo().isInitialized()) {
            throw new AlreadyInitializedException();
        }
        User user = new User();
        user.setAdmin(true);
        user.setEnabled(true);
        user.setName(serviceInit.getInitialAdminUsername());
        user.setPassword(serviceInit.getInitialAdminPassword());
        try {
            userDao.createUser(user);
        } catch (UnauthorizedException wontHappen) {
            throw new RuntimeException(wontHappen);
        }
        serviceInfoDao.setInitialized();
        return getServiceInfo();
    }

    // -----------------------------------------------------------------------
    //                                Users
    // -----------------------------------------------------------------------

    @Override
    public User createUser(User user) throws UnauthorizedException, NameConflictException {
        try {
            return userDao.createUser(user);
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("User name is already in use", e);
        }
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUser(String id) throws ResourceNotFoundException {
        User result = userDao.getUser(id);
        if (result == null) {
            throw new ResourceNotFoundException("No such user: " + id);
        }
        return result;
    }

    @Override
    public User getCurrentUser() {
        return userDao.getCurrentUser();
    }

    @Override
    public User updateUser(String id, User user)
            throws UnauthorizedException, ResourceNotFoundException, NameConflictException {
        try {
            User result = userDao.updateUser(id, user);
            if (result == null) {
                throw new ResourceNotFoundException("No such user: " + id);
            }
            return result;
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("User name is already in use", e);
        }
    }

    @Override
    public void deleteUser(String id) throws UnauthorizedException, ResourceInUseException {
        if (!id.equals(getCurrentUser().getId())) {
            userDao.deleteUser(id);
        } else {
            throw new ResourceInUseException("You can't delete yourself");
        }
    }

    // -----------------------------------------------------------------------
    //                                Tasks
    // -----------------------------------------------------------------------

    @Override
    public Task createTask(Task task) throws NameConflictException {
        try {
            return taskDao.createTask(task);
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("Task name is already in use", e);
        }
    }

    @Override
    public List<Task> listTasks() {
        return taskDao.listTasks();
    }

    @Override
    public Task getTask(String id) throws ResourceNotFoundException {
        Task result = taskDao.getTask(id);
        if (result == null) {
            throw new ResourceNotFoundException("No such task: " + id);
        }
        return result;
    }

    @Override
    public Task updateTask(String id, Task task)
            throws ResourceNotFoundException, NameConflictException {
        try {
            Task result = taskDao.updateTask(id, task);
            if (result == null) {
                throw new ResourceNotFoundException("No such task: " + id);
            }
            return result;
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("Task name is already in use", e);
        }
    }

    @Override
    public void deleteTask(String id) throws ResourceInUseException {
        if (taskDao.getTask(id).getState().equals(Task.IDLE)) {
            try {
                taskDao.deleteTask(id);
            } catch (DataIntegrityViolationException e) {
                throw new ResourceInUseException("Task cannot be deleted; it is being used by a task log", e);
            }
        } else {
            throw new ResourceInUseException("Task cannot be deleted while active");
        }
    }

    // -----------------------------------------------------------------------
    //                             Object Sets
    // -----------------------------------------------------------------------

    @Override
    public ObjectSet createObjectSet(ObjectSet objectSet)
            throws NameConflictException {
        try {
            return objectSetDao.createObjectSet(objectSet);
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("Object set name is already in use", e);
        }
    }

    @Override
    public List<ObjectSet> listObjectSets() {
        return objectSetDao.listObjectSets();
    }

    @Override
    public ObjectSet getObjectSet(String id) throws ResourceNotFoundException {
        ObjectSet result = objectSetDao.getObjectSet(id);
        if (result == null) {
            throw new ResourceNotFoundException("No such object set: " + id);
        }
        return result;
    }

    
    @Override
    public ObjectSet updateObjectSet(String id, ObjectSet objectSet)
            throws ResourceNotFoundException, NameConflictException {
        try {
            ObjectSet result = objectSetDao.updateObjectSet(id, objectSet);
            if (result == null) {
                throw new ResourceNotFoundException("No such user: " + id);
            }
            return result;
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("Set name is already in use", e);
        }
    }

    @Override
    public void deleteObjectSet(String id) throws ResourceInUseException {
        try {
            objectSetDao.deleteObjectSet(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceInUseException("Object set is currently being used by a task", e);
        }
    }

    // -----------------------------------------------------------------------
    //                            Object Stores
    // -----------------------------------------------------------------------

    @Override
    public ObjectStore createObjectStore(ObjectStore objectStore)
            throws NameConflictException {
        try {
            return objectStoreDao.createObjectStore(objectStore);
        } catch (DuplicateKeyException e) {
            throw new NameConflictException("Object store name is already in use", e);
        }
    }

    @Override
    public List<ObjectStore> listObjectStores() {
        return objectStoreDao.listObjectStores();
    }

    @Override
    public ObjectStore getObjectStore(String id) throws ResourceNotFoundException {
        ObjectStore result = objectStoreDao.getObjectStore(id);
        if (result == null) {
            throw new ResourceNotFoundException("No such object store: " + id);
        }
        return result;
    }

    @Override
    public void deleteObjectStore(String id) throws ResourceInUseException {
        try {
            objectStoreDao.deleteObjectStore(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceInUseException("Object store is currently being used by a task", e);
        }
    }

    // -----------------------------------------------------------------------
    //                              Task Logs
    // -----------------------------------------------------------------------

    @Override
    public List<TaskLog> listTaskLogs() {
        return taskLogDao.listTaskLogs();
    }

    @Override
    public TaskLog getTaskLog(String id) throws ResourceNotFoundException {
        TaskLog result = taskLogDao.getTaskLog(id);
        if (result == null) {
            throw new ResourceNotFoundException("No such task log: " + id);
        }
        return result;
    }

    @Override
    public InputStream getTaskLogContent(String id) throws ResourceNotFoundException {
        try {
            return taskLogDao.getTaskLogContent(id);
        } catch (FileNotFoundException e) {
            throw new ResourceNotFoundException("No such task log: " + id, e);
        }
    }

    @Override
    public void deleteTaskLog(String id) {
        // TODO: throw ResourceInUseException if task log is still being written
        taskLogDao.deleteTaskLog(id);
    }

    // -----------------------------------------------------------------------
    //                               DuraCloud
    // -----------------------------------------------------------------------

    @Override
    public List<ProviderAccount> listProviderAccounts(String url,
                                               String username,
                                               String password) {
        return duraCloudDao.listProviderAccounts(url, username, password);
    }

    @Override
    public List<Space> listSpaces(String url,
                           String username,
                           String password,
                           String providerAccountId) {
        return duraCloudDao.listSpaces(url, username, password, providerAccountId);
    }
}
