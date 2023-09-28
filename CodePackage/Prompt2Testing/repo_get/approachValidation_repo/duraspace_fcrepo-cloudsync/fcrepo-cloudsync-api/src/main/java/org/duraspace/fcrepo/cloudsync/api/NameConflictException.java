package org.duraspace.fcrepo.cloudsync.api;

public class NameConflictException extends Exception {

	private static final long serialVersionUID = 1L;

	public NameConflictException(String message) {
        super(message);
    }

    public NameConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
