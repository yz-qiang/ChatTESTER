package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.Task;

import java.util.Date;

public interface TaskCompletionListener {

    Date taskSucceeded(Task task);
    Date taskFailed(Task task, Throwable cause);
    Date taskCanceled(Task task);

}
