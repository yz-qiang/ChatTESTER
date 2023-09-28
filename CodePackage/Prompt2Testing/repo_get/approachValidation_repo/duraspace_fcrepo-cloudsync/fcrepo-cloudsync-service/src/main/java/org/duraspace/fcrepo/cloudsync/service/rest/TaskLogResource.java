package org.duraspace.fcrepo.cloudsync.service.rest;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.duraspace.fcrepo.cloudsync.api.CloudSyncService;
import org.duraspace.fcrepo.cloudsync.api.ResourceInUseException;
import org.duraspace.fcrepo.cloudsync.api.ResourceNotFoundException;
import org.duraspace.fcrepo.cloudsync.api.TaskLog;

@Path("taskLogs")
public class TaskLogResource extends AbstractResource {

    public static final String TASKLOG_JSON =
            "application/vnd.fcrepo-cloudsync.tasklog+json";

    public static final String TASKLOG_XML =
            "application/vnd.fcrepo-cloudsync.tasklog+xml";

    public static final String TASKLOGS_JSON =
            "application/vnd.fcrepo-cloudsync.tasklogs+json";

    public static final String TASKLOGS_XML =
            "application/vnd.fcrepo-cloudsync.tasklogs+xml";

    public TaskLogResource(CloudSyncService service) {
        super(service);
    }

    @GET
    @Path("/")
    @Produces({JSON, XML, TASKLOGS_JSON, TASKLOGS_XML})
    @Descriptions({
        @Description(value = "Lists all task logs", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<TaskLog> listTaskLogs(@Context UriInfo uriInfo,
                                      @Context HttpServletRequest req) {
        List<TaskLog> taskLogs = service.listTaskLogs();
        for (TaskLog taskLog: taskLogs) {
            setUris(uriInfo, req, taskLog);
        }
        return taskLogs;
    }

    @GET
    @Path("{id}")
    @Produces({JSON, XML, TASKLOG_JSON, TASKLOG_XML})
    @Descriptions({
            @Description(value = "Gets a task log", target = DocTarget.METHOD),
            @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public TaskLog getTaskLog(@Context UriInfo uriInfo,
                              @Context HttpServletRequest req,
                              @PathParam("id") String id) {
        try {
            TaskLog taskLog = service.getTaskLog(id);
            setUris(uriInfo, req, taskLog);
            return taskLog;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("{id}/content")
    @Produces({TEXT})
    @Descriptions({
        @Description(value = "Gets a task log's content", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public InputStream getTaskLogContent(@PathParam("id") String id) {
        try {
            return service.getTaskLogContent(id);
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @DELETE
    @Path("{id}")
    @Descriptions({
        @Description(value = "Deletes a task log", target = DocTarget.METHOD),
        @Description(value = STATUS_204_NO_CONTENT, target = DocTarget.RESPONSE)
    })
    public void deleteTaskLog(@PathParam("id") String id) {
        try {
            service.deleteTaskLog(id);
        } catch (ResourceInUseException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }
    
    private void setUris(UriInfo uriInfo, HttpServletRequest req, TaskLog taskLog) {
        URI uri = URIMapper.getUri(uriInfo, req, "taskLogs/" + taskLog.getId());
        taskLog.setUri(uri);
        taskLog.setTaskUri(URIMapper.getUri(uriInfo, req, "tasks/" + taskLog.getTaskId()));
        taskLog.setContentUri(URI.create(uri + "/content"));
        taskLog.setId(null);
        taskLog.setTaskId(null);
    }
}
