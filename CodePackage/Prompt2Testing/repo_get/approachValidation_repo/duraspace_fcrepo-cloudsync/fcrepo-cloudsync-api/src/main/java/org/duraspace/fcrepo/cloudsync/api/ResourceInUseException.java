package org.duraspace.fcrepo.cloudsync.api;

public class ResourceInUseException extends Exception {

	private static final long serialVersionUID = 1L;

	public ResourceInUseException(String message) {
        super(message);
    }

    public ResourceInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
