package com.bazaarvoice.ostrich.examples.dictionary.service;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
public class ToggleHealthResource {
    @GET
    @Timed
    @Path("/{status}")
    public int toggle(@PathParam("status") int status) {
        DictionaryService.STATUS_OVERRIDE = Response.Status.fromStatusCode(status);
        return DictionaryService.STATUS_OVERRIDE.getStatusCode();
    }
}
