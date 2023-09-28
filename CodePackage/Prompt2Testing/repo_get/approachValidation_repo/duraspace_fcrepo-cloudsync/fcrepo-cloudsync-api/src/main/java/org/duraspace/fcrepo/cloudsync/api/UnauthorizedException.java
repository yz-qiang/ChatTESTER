package org.duraspace.fcrepo.cloudsync.api;

public class UnauthorizedException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String message) {
	    super(message);
    }

	public UnauthorizedException(String message, Throwable cause) {
	    super(message, cause);
    }

}