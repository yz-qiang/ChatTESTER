package com.bazaarvoice.ostrich.exceptions;

/**
 * An exception indicating a {@link com.bazaarvoice.ostrich.LoadBalanceAlgorithm} chose {@code null} rather than one of the
 * provided end points.
 */
public class NoSuitableHostsException extends DiscoveryException {
    private static final long serialVersionUID = 0;

    public NoSuitableHostsException() {
        super();
    }

    public NoSuitableHostsException(String message) {
        super(message);
    }

    public NoSuitableHostsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuitableHostsException(Throwable cause) {
        super(cause);
    }
}
