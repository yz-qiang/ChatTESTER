package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.ObjectInfo;

public interface ObjectListHandler {

    boolean handleObject(ObjectInfo info);

}
