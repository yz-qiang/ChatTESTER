package org.duraspace.fcrepo.cloudsync.service.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import org.duraspace.fcrepo.cloudsync.api.NameConflictException;
import org.duraspace.fcrepo.cloudsync.api.ResourceInUseException;
import org.duraspace.fcrepo.cloudsync.api.ResourceNotFoundException;
import org.duraspace.fcrepo.cloudsync.api.Task;
import org.duraspace.fcrepo.cloudsync.service.util.PATCH;

@Path("tasks")
public class TaskResource extends AbstractResource {
    
    public static final String TASK_JSON =
            "application/vnd.fcrepo-cloudsync.task+json";

    public static final String TASK_XML =
            "application/vnd.fcrepo-cloudsync.task+xml";

    public static final String TASKS_JSON =
            "application/vnd.fcrepo-cloudsync.tasks+json";

    public static final String TASKS_XML =
            "application/vnd.fcrepo-cloudsync.tasks+xml";

    public TaskResource(CloudSyncService service) {
        super(service);
    }

    @POST
    @Path("/")
    @Consumes({TASK_JSON, TASK_XML})
    @Produces({JSON, XML, TASK_JSON, TASK_XML})
    @Descriptions({
        @Description(value = "Creates a task", target = DocTarget.METHOD),
        @Description(value = STATUS_201_CREATED, target = DocTarget.RESPONSE)
    })
    public Response createTask(@Context UriInfo uriInfo,
                               @Context HttpServletRequest req,
                               Task task) {
        try {
            Task newTask = service.createTask(task);
            setUris(uriInfo, req, newTask);
            return Response.created(newTask.getUri()).entity(newTask).build();
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @GET
    @Path("/")
    @Produces({JSON, XML, TASKS_JSON, TASKS_XML})
    @Descriptions({
        @Description(value = "Lists all tasks", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<Task> listTasks(@Context UriInfo uriInfo,
                                @Context HttpServletRequest req) {
        List<Task> tasks = service.listTasks();
        for (Task task: tasks) {
            setUris(uriInfo, req, task);
        }
        return tasks;
    }

    @GET
    @Path("{id}")
    @Produces({JSON, XML, TASK_JSON, TASK_XML})
    @Descriptions({
        @Description(value = "Gets a task", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public Task getTask(@Context UriInfo uriInfo,
                        @Context HttpServletRequest req,
                        @PathParam("id") String id) {
        try {
            Task task = service.getTask(id);
            setUris(uriInfo, req, task);
            return task;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @PATCH
    @Path("{id}")
    @Consumes({TASK_JSON, TASK_XML})
    @Produces({JSON, XML, TASK_JSON, TASK_XML})
    @Descriptions({
        @Description(value = "Updates a task", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public Task updateTask(@Context UriInfo uriInfo,
                           @Context HttpServletRequest req,
                           @PathParam("id") String id,
                           Task task) {
        try {
            Task updatedTask = service.updateTask(id, task);
            setUris(uriInfo, req, updatedTask);
            return updatedTask;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @DELETE
    @Path("{id}")
    @Descriptions({
        @Description(value = "Deletes a task", target = DocTarget.METHOD),
        @Description(value = STATUS_204_NO_CONTENT, target = DocTarget.RESPONSE)
    })
    public void deleteTask(@PathParam("id") String id) {
        try {
            service.deleteTask(id);
        } catch (ResourceInUseException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    private void setUris(UriInfo uriInfo, HttpServletRequest req, Task task) {
        task.setUri(URIMapper.getUri(uriInfo, req, "tasks/" + task.getId()));
        if (task.getActiveLogId() != null && !task.getActiveLogId().equals("0")) {
            task.setActiveLogUri(URIMapper.getUri(uriInfo, req, "taskLogs/" + task.getActiveLogId()));
        }
        task.setActiveLogId(null);
        task.setId(null);
    }
}
