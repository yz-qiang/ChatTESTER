package org.duraspace.fcrepo.cloudsync.service.backend;

import java.io.PrintWriter;
import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.duraspace.fcrepo.cloudsync.api.ObjectInfo;
import org.duraspace.fcrepo.cloudsync.api.Task;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectSetDao;
import org.duraspace.fcrepo.cloudsync.service.dao.ObjectStoreDao;
import org.duraspace.fcrepo.cloudsync.service.dao.TaskDao;
import org.duraspace.fcrepo.cloudsync.service.rest.URIMapper;
import org.duraspace.fcrepo.cloudsync.service.util.JSON;
import org.duraspace.fcrepo.cloudsync.service.util.StringUtil;
import com.github.cwilper.fcrepo.dto.core.ControlGroup;
import com.github.cwilper.fcrepo.dto.core.Datastream;
import com.github.cwilper.fcrepo.dto.core.FedoraObject;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;

public class CopyTaskRunner extends TaskRunner implements ObjectListHandler {

    private final String setId;
    private final String queryStoreId;
    private final String sourceStoreId;
    private final String destStoreId;
    private final boolean overwrite;
    private final boolean includeManaged;
    private final boolean copyExternal;
    private final boolean copyRedirect;

    private final Set<String> relatedSetIds = new HashSet<String>();
    private final Set<String> relatedStoreIds = new HashSet<String>();

    private final HttpClientConfig httpClientConfig;

    private StoreConnector queryConnector;
    private StoreConnector sourceConnector;
    private StoreConnector destConnector;

    private TaskCanceledException canceledException;

    public CopyTaskRunner(Task task,
                          TaskDao taskDao,
                          ObjectSetDao objectSetDao,
                          ObjectStoreDao objectStoreDao,
                          PrintWriter logWriter,
                          TaskCompletionListener completionListener,
                          HttpClientConfig httpClientConfig) {
        super(task, taskDao, objectSetDao, objectStoreDao, logWriter,
                completionListener);
        Map<String, String> map = JSON.getMap(JSON.parse(task.getData()));
        setId = URIMapper.getId(URI.create(map.get("setUri")));
        queryStoreId = URIMapper.getId(URI.create(map.get("queryStoreUri")));
        sourceStoreId = URIMapper.getId(URI.create(map.get("sourceStoreUri")));
        destStoreId = URIMapper.getId(URI.create(map.get("destStoreUri")));
        overwrite = StringUtil.validate("overwrite",
                map.get("overwrite"),
                new String[] { "true", "false" }).equals("true");
        includeManaged = StringUtil.validate("includeManaged",
                map.get("includeManaged"),
                new String[] { "true", "false" }).equals("true");
        copyExternal = StringUtil.validate("copyExternal",
                map.get("copyExternal"),
                new String[] { "true", "false" }).equals("true");
        copyRedirect = StringUtil.validate("copyRedirect",
                map.get("copyRedirect"),
                new String[] { "true", "false" }).equals("true");  
        relatedSetIds.add(setId);
        relatedStoreIds.add(queryStoreId);
        relatedStoreIds.add(sourceStoreId);
        relatedStoreIds.add(destStoreId);
        this.httpClientConfig = httpClientConfig;
    }

    @Override
    public void runTask() throws Exception {
        queryConnector = StoreConnector.getInstance(
                objectStoreDao.getObjectStore(queryStoreId), httpClientConfig);
        sourceConnector = StoreConnector.getInstance(
                objectStoreDao.getObjectStore(sourceStoreId), httpClientConfig);
        destConnector = StoreConnector.getInstance(
                objectStoreDao.getObjectStore(destStoreId), httpClientConfig);
        try {
            ObjectQuery query = new ObjectQuery(
                    objectSetDao.getObjectSet(setId));
            queryConnector.listObjects(query, this);
            if (canceledException != null) {
                throw canceledException;
            }
        } finally {
            queryConnector.close();
            sourceConnector.close();
            destConnector.close();
        }
    }

    @Override
    public Set<String> getRelatedSetIds() {
        return relatedSetIds;
    }

    @Override
    public Set<String> getRelatedStoreIds() {
        return relatedStoreIds;
    }

    // ObjectListHandler

    @Override
    public boolean handleObject(ObjectInfo info) {
        logWriter.print("Copying " + info.getPid() + "..");
        try {
            pauseOrCancelIfRequested();
            doCopy(info.getPid());
            pauseOrCancelIfRequested();
            return true;
        } catch (TaskCanceledException e) {
            canceledException = e;
            return false;
        }
    }

    private void doCopy(String pid) {
        FedoraObject o = sourceConnector.getObject(pid);
        if (o != null) {
            if (!includeManaged && countManagedDatastreams(o) > 0) {
                logWriter.println("SKIPPED (has managed datastream(s))");
            } else {
                boolean existed = destConnector.putObject(o, sourceConnector,
                        overwrite, copyExternal, copyRedirect);
                if (existed) {
                    if (overwrite) {
                        logWriter.println("REPLACED (exists in destination)");
                    } else {
                        logWriter.println("SKIPPED (exists in destination)");
                    }
                } else {
                    logWriter.println("OK (new in destination)");
                }
            }                
        } else {
            logWriter.println("SKIPPED (does not exist in source)");
        }
    }

    private static int countManagedDatastreams(FedoraObject o) {
        int count = 0;
        for (Datastream ds: o.datastreams().values()) {
            if (ds.controlGroup().equals(ControlGroup.MANAGED)) {
                count++;
            }
        }
        return count;
    }

}
