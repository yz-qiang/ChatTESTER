package com.bazaarvoice.ostrich.perftest.core;

/**
 * A factory to create a result object form an actual result object or an exception
 *
 * @param <T> the result object type
 */
public interface ResultFactory<T> {

    /**
     * Creates a result object wrapper with an actual result
     *
     * @param result the actual result
     * @return Wrapped result object
     */
    Result<T> createResponse(T result);

    /**
     * Create a result object wrapper with an exception
     *
     * @param error the exception
     * @return Wrapped result object
     */
    Result<T> createResponse(Exception error);
}
