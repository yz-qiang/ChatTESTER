package org.duraspace.fcrepo.cloudsync.service.rest;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;

public final class URIMapper {
    
    private URIMapper() { }
   
    /**
     * Gets a full URI for the given path, based on the request URI.
     */
    public static URI getUri(UriInfo uriInfo,
                             HttpServletRequest req,
                             String path) {
        String suffix = "";
        if (req.getRequestURI().endsWith(".json")) {
            suffix = ".json";
        } else if (req.getRequestURI().endsWith(".xml")) {
            suffix = ".xml";
        }
        return URI.create(uriInfo.getBaseUri() + "/" + path + suffix);
    }    
    
    /**
     * Gets the id for the given task, set, store, user, or taskLog URI.
     */
    public static String getId(URI uri) {
        String s = uri.toString();
        return s.substring(s.lastIndexOf("/") + 1);
    }
}
