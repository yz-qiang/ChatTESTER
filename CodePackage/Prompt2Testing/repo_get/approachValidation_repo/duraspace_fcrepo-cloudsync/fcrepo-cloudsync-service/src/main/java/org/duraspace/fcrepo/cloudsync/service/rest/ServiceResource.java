package org.duraspace.fcrepo.cloudsync.service.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.duraspace.fcrepo.cloudsync.api.AlreadyInitializedException;
import org.duraspace.fcrepo.cloudsync.api.CloudSyncService;
import org.duraspace.fcrepo.cloudsync.api.ServiceInfo;
import org.duraspace.fcrepo.cloudsync.api.ServiceInit;

@Path("service")
public class ServiceResource extends AbstractResource {
   
    public static final String SERVICEINFO_JSON =
            "application/vnd.fcrepo-cloudsync.serviceinfo+json";
    
    public static final String SERVICEINFO_XML =
            "application/vnd.fcrepo-cloudsync.serviceinfo+xml";
    
    public static final String SERVICEINIT_JSON =
            "application/vnd.fcrepo-cloudsync.serviceinit+json";
    
    public static final String SERVICEINIT_XML =
            "application/vnd.fcrepo-cloudsync.serviceinit+xml";
    
    public ServiceResource(CloudSyncService service) {
        super(service);
    }

    @GET
    @Path("/")
    @Produces({JSON, XML, SERVICEINFO_JSON, SERVICEINFO_XML})
    @Descriptions({
        @Description(value = "Gets the Service Info", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public ServiceInfo getServiceInfo(@Context UriInfo uriInfo,
                                      @Context HttpServletRequest req) {
        ServiceInfo serviceInfo = service.getServiceInfo();
        serviceInfo.setCurrentUserUri(URIMapper.getUri(uriInfo, req, "users/current"));
        serviceInfo.setObjectSetsUri(URIMapper.getUri(uriInfo, req, "objectSets"));
        serviceInfo.setObjectStoresUri(URIMapper.getUri(uriInfo, req, "objectStores"));
        serviceInfo.setProviderAccountsUri(URIMapper.getUri(uriInfo, req, "duracloud/providerAccounts"));
        serviceInfo.setSpacesUri(URIMapper.getUri(uriInfo, req, "duracloud/spaces"));
        serviceInfo.setTaskLogsUri(URIMapper.getUri(uriInfo, req, "taskLogs"));
        serviceInfo.setTasksUri(URIMapper.getUri(uriInfo, req, "tasks"));
        serviceInfo.setUsersUri(URIMapper.getUri(uriInfo, req, "users"));
        return serviceInfo;
    }

    @POST
    @Path("/")
    @Consumes({SERVICEINIT_JSON, SERVICEINIT_XML})
    @Produces({JSON, XML, SERVICEINFO_JSON, SERVICEINFO_XML})
    @Descriptions({
        @Description(value = "Updates the Service Info", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public ServiceInfo updateServiceInfo(ServiceInit serviceInit) {
        try {
            return service.initialize(serviceInit);
        } catch (AlreadyInitializedException e) {
            throw new WebApplicationException(e, Response.Status.CONFLICT);
        }
    }

}
