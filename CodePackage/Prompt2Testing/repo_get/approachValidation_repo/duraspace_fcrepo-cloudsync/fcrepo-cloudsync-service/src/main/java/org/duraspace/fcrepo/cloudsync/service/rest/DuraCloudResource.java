package org.duraspace.fcrepo.cloudsync.service.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.duraspace.fcrepo.cloudsync.api.CloudSyncService;
import org.duraspace.fcrepo.cloudsync.api.ProviderAccount;
import org.duraspace.fcrepo.cloudsync.api.Space;

@Path("duracloud")
public class DuraCloudResource extends AbstractResource {
    
    public static final String PROVIDERACCOUNTS_JSON =
            "application/vnd.fcrepo-cloudsync.provideraccounts+json";

    public static final String PROVIDERACCOUNTS_XML =
            "application/vnd.fcrepo-cloudsync.provideraccounts+xml";

    public static final String SPACES_JSON =
            "application/vnd.fcrepo-cloudsync.spaces+json";

    public static final String SPACES_XML =
            "application/vnd.fcrepo-cloudsync.spaces+xml";

    public DuraCloudResource(CloudSyncService service) {
        super(service);
    }

    @GET
    @Path("/providerAccounts")
    @Produces({JSON, XML, PROVIDERACCOUNTS_JSON, PROVIDERACCOUNTS_XML})
    @Descriptions({
            @Description(value = "Lists the Storage Provider Accounts configured for a DuraCloud Instance", target = DocTarget.METHOD),
            @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<ProviderAccount> listProviderAccounts(
            @QueryParam("url") String url,
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        return service.listProviderAccounts(url, username, password);
    }

    @GET
    @Path("/spaces")
    @Produces({JSON, XML, SPACES_JSON, SPACES_XML})
    @Descriptions({
        @Description(value = "Lists the Spaces available within a Storage Provider Account on a DuraCloud Instance", target = DocTarget.METHOD),
        @Description(value = STATUS_200_OK, target = DocTarget.RESPONSE)
    })
    public List<Space> listSpaces(
            @QueryParam("url") String url,
            @QueryParam("username") String username,
            @QueryParam("password") String password,
            @QueryParam("providerAccountId") String providerAccountId) {
        return service.listSpaces(url, username, password, providerAccountId);
    }

}
