package org.duraspace.fcrepo.cloudsync.service.rest;

import javax.ws.rs.core.MediaType;

import org.duraspace.fcrepo.cloudsync.api.CloudSyncService;

abstract class AbstractResource {

    protected static final String JSON = MediaType.APPLICATION_JSON;
    protected static final String TEXT = MediaType.TEXT_PLAIN;
    protected static final String XML = MediaType.APPLICATION_XML;

    protected static final String STATUS_200_OK = "Status: 200 OK";
    protected static final String STATUS_201_CREATED = "Status: 201 Created";
    protected static final String STATUS_204_NO_CONTENT = "Status: 204 No Content";

    protected final CloudSyncService service;

    AbstractResource(CloudSyncService service) {
        this.service = service;
    }
    
}
