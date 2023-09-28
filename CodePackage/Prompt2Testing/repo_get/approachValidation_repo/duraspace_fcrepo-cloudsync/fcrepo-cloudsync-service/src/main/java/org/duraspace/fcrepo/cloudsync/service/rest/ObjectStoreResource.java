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
import org.duraspace.fcrepo.cloudsync.api.ObjectStore;
import org.duraspace.fcrepo.cloudsync.api.ResourceInUseException;
import org.duraspace.fcrepo.cloudsync.api.ResourceNotFoundException;

@Path("objectStores")
public class ObjectStoreResource extends AbstractResource {
    
    public static final String OBJECTSTORE_JSON =
            "application/vnd.fcrepo-cloudsync.objectstore+json";

    public static final String OBJECTSTORE_XML =
            "application/vnd.fcrepo-cloudsync.objectstore+xml";

    public static final String OBJECTSTORES_JSON =
            "application/vnd.fcrepo-cloudsync.objectstores+json";

    public static final String OBJECTSTORES_XML =
            "application/vnd.fcrepo-cloudsync.objectstores+xml";

    public ObjectStoreResource(CloudSyncService service) {
        super(service);
    }

    @POST
    @Path("/")
    @Consumes({OBJECTSTORE_JSON, OBJECTSTORE_XML})
    @Produces({JSON, XML, OBJECTSTORE_JSON, OBJECTSTORE_XML})
    @Descriptions({
        @Description(value = "Creates an object store", target = DocTarget.METHOD),
        @Description(value = STATUS_201_CREATED, target = DocTarget.RESPONSE)
    })
    public Response createObjectStore(@Context UriInfo uriInfo,
                                      @Context HttpServletRequest req,
                                      ObjectStore objectStore) {
        try {
            ObjectStore newObjectStore = service.createObjectStore(objectStore);
            setUri(uriInfo, req, newObjectStore);
            return Response.created(newObjectStore.getUri()).entity(newObjectStore).build();
        } catch (NameConflictException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

    @GET
    @Path("/")
    @Produces({JSON, XML, OBJECTSTORES_JSON, OBJECTSTORES_XML})
    @Descriptions({
        @Description(value = "Lists all object stores", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<ObjectStore> listObjectStores(@Context UriInfo uriInfo,
                                              @Context HttpServletRequest req) {
        List<ObjectStore> objectStores = service.listObjectStores();
        for (ObjectStore objectStore: objectStores) {
            setUri(uriInfo, req, objectStore);
        }
        return objectStores;
    }

    @GET
    @Path("{id}")
    @Produces({JSON, XML, OBJECTSTORE_JSON, OBJECTSTORE_XML})
    @Descriptions({
            @Description(value = "Gets an object store", target = DocTarget.METHOD),
            @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public ObjectStore getObjectStore(@Context UriInfo uriInfo,
                                      @Context HttpServletRequest req,
                                      @PathParam("id") String id) {
        try {
            ObjectStore objectStore = service.getObjectStore(id);
            setUri(uriInfo, req, objectStore);
            return objectStore;
        } catch (ResourceNotFoundException e) {
            throw new WebApplicationException(e, Response.Status.NOT_FOUND);
        }
    }

    @DELETE
    @Path("{id}")
    @Descriptions({
        @Description(value = "Deletes an object store", target = DocTarget.METHOD),
        @Description(value = STATUS_204_NO_CONTENT, target = DocTarget.RESPONSE)
    })
    public void deleteObjectStore(@PathParam("id") String id) {
        try {
            service.deleteObjectStore(id);
        } catch (ResourceInUseException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }
    
    private void setUri(UriInfo uriInfo, HttpServletRequest req, ObjectStore objectStore) {
        objectStore.setUri(URIMapper.getUri(uriInfo, req, "objectStores/" + objectStore.getId()));
        objectStore.setId(null);
    }
}
