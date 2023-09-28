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
import org.duraspace.fcrepo.cloudsync.api.UnauthorizedException;
import org.duraspace.fcrepo.cloudsync.api.User;
import org.duraspace.fcrepo.cloudsync.service.util.PATCH;

@Path("users")
public class UserResource extends AbstractResource {
    
    public static final String USER_JSON =
            "application/vnd.fcrepo-cloudsync.user+json";

    public static final String USER_XML =
            "application/vnd.fcrepo-cloudsync.user+xml";

    public static final String USERS_JSON =
            "application/vnd.fcrepo-cloudsync.users+json";

    public static final String USERS_XML =
            "application/vnd.fcrepo-cloudsync.users+xml";

    public UserResource(CloudSyncService service) {
        super(service);
    }

    @POST
    @Path("/")
    @Consumes({USER_JSON, USER_XML})
    @Produces({JSON, XML, USER_JSON, USER_XML})
    @Descriptions({
        @Description(value = "Creates a user", target = DocTarget.METHOD),
        @Description(value = STATUS_201_CREATED, target = DocTarget.RESPONSE)
    })
    public Response createUser(@Context UriInfo uriInfo,
                               @Context HttpServletRequest req,
                               User user) {
        try {
            User newUser = service.createUser(user);
            setUri(uriInfo, req, newUser);
            return Response.created(user.getUri()).entity(newUser).build();
        } catch (UnauthorizedException e) {
            throw new WebApplicationException(e, Response.Status.FORBIDDEN);
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }
    
    @GET
    @Path("/")
    @Produces({JSON, XML, USERS_JSON, USERS_XML})
    @Descriptions({
        @Description(value = "Lists all users", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<User> listUsers(@Context UriInfo uriInfo,
                                @Context HttpServletRequest req) {
        List<User> users = service.listUsers();
        for (User user: users) {
            setUri(uriInfo, req, user);
        }
        return users;
    }

    @GET
    @Path("{id}")
    @Produces({JSON, XML, USER_JSON, USER_XML})
    @Descriptions({
            @Description(value = "Gets a user", target = DocTarget.METHOD),
            @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public User getUser(@Context UriInfo uriInfo,
                        @Context HttpServletRequest req,
                        @PathParam("id") String id) {
        try {
            User user = service.getUser(id);
            setUri(uriInfo, req, user);
            return user;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Path("current")
    @Produces({JSON, XML, USER_JSON, USER_XML})
    @Descriptions({
        @Description(value = "Gets the currently logged in user", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public Response getCurrentUser(@Context UriInfo uriInfo,
                               @Context HttpServletRequest req) {
        User user = service.getCurrentUser();
        setUri(uriInfo, req, user);
        return Response.ok(user).contentLocation(user.getUri()).build();
    }

    @PATCH
    @Path("{id}")
    @Consumes({USER_JSON, USER_XML})
    @Produces({JSON, XML, USER_JSON, USER_XML})
    @Descriptions({
        @Description(value = "Updates a user", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public User updateUser(@Context UriInfo uriInfo,
                           @Context HttpServletRequest req,
                           @PathParam("id") String id,
                           User user) {
        try {
            User updatedUser = service.updateUser(id, user);
            setUri(uriInfo, req, updatedUser);
            return updatedUser;
        } catch (UnauthorizedException e) {
            throw new WebApplicationException(e, Response.Status.FORBIDDEN);
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @DELETE
    @Path("{id}")
    @Descriptions({
        @Description(value = "Deletes a user", target = DocTarget.METHOD),
        @Description(value = STATUS_204_NO_CONTENT, target = DocTarget.RESPONSE)
    })
    public void deleteUser(@PathParam("id") String id) {
        try {
            service.deleteUser(id);
        } catch (UnauthorizedException e) {
            throw new WebApplicationException(e, Response.Status.FORBIDDEN);
        } catch (ResourceInUseException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    private void setUri(UriInfo uriInfo, HttpServletRequest req, User user) {
        user.setUri(URIMapper.getUri(uriInfo, req, "users/" + user.getId()));
        user.setId(null);
    }

}
