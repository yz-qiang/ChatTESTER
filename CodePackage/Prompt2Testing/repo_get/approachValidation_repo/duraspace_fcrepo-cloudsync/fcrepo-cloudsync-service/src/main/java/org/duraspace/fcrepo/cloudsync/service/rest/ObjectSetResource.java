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
import org.duraspace.fcrepo.cloudsync.api.ObjectSet;
import org.duraspace.fcrepo.cloudsync.api.ResourceInUseException;
import org.duraspace.fcrepo.cloudsync.api.ResourceNotFoundException;
import org.duraspace.fcrepo.cloudsync.service.util.PATCH;

@Path("objectSets")
public class ObjectSetResource extends AbstractResource {
    
    public static final String OBJECTSET_JSON =
            "application/vnd.fcrepo-cloudsync.objectset+json";

    public static final String OBJECTSET_XML =
            "application/vnd.fcrepo-cloudsync.objectset+xml";

    public static final String OBJECTSETS_JSON =
            "application/vnd.fcrepo-cloudsync.objectsets+json";

    public static final String OBJECTSETS_XML =
            "application/vnd.fcrepo-cloudsync.objectsets+xml";

    public ObjectSetResource(CloudSyncService service) {
        super(service);
    }

    @POST
    @Path("/")
    @Consumes({OBJECTSET_JSON, OBJECTSET_XML})
    @Produces({JSON, XML, OBJECTSET_JSON, OBJECTSET_XML})
    @Descriptions({
        @Description(value = "Creates an object set", target = DocTarget.METHOD),
        @Description(value = STATUS_201_CREATED, target = DocTarget.RESPONSE)
    })
    public Response createObjectSet(@Context UriInfo uriInfo,
                                    @Context HttpServletRequest req,
                                    ObjectSet objectSet) {
        try {
            ObjectSet newObjectSet = service.createObjectSet(objectSet);
            setUri(uriInfo, req, newObjectSet);
            return Response.created(newObjectSet.getUri()).entity(newObjectSet).build();
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @PATCH
    @Path("{id}")
    @Consumes({OBJECTSET_JSON, OBJECTSET_XML})
    @Produces({JSON, XML, OBJECTSET_JSON, OBJECTSET_XML})
    @Descriptions({
        @Description(value = "Updates an object set", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public ObjectSet updateObjectSet(@Context UriInfo uriInfo,
            @Context HttpServletRequest req,
            @PathParam("id") String id,
            ObjectSet objectSet) {
        try {
            ObjectSet updatedObjectSet = service.updateObjectSet(id, objectSet);
            setUri(uriInfo, req, updatedObjectSet);
            return updatedObjectSet;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @GET
    @Path("/")
    @Produces({JSON, XML, OBJECTSETS_JSON, OBJECTSETS_XML})
    @Descriptions({
        @Description(value = "Lists all object sets", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<ObjectSet> listObjectSets(@Context UriInfo uriInfo,
                                          @Context HttpServletRequest req) {
        List<ObjectSet> objectSets = service.listObjectSets();
        for (ObjectSet objectSet: objectSets) {
            setUri(uriInfo, req, objectSet);
        }
        return objectSets;
    }

    @GET
    @Path("{id}")
    @Produces({JSON, XML, OBJECTSET_JSON, OBJECTSET_XML})
    @Descriptions({
        @Description(value = "Gets an object set", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public ObjectSet getObjectSet(@Context UriInfo uriInfo,
                                  @Context HttpServletRequest req,
                                  @PathParam("id") String id) {
        try {
            ObjectSet objectSet = service.getObjectSet(id);
            setUri(uriInfo, req, objectSet);
            return objectSet;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @DELETE
    @Path("{id}")
    @Descriptions({
        @Description(value = "Deletes an object set", target = DocTarget.METHOD),
        @Description(value = STATUS_204_NO_CONTENT, target = DocTarget.RESPONSE)
    })
    public void deleteObjectSet(@PathParam("id") String id) {
        try {
            service.deleteObjectSet(id);
        } catch (ResourceInUseException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    private void setUri(UriInfo uriInfo, HttpServletRequest req, ObjectSet objectSet) {
        objectSet.setUri(URIMapper.getUri(uriInfo, req, "objectSets/" + objectSet.getId()));
        objectSet.setId(null);
    }
}
