package com.bazaarvoice.ostrich.perftest.core;

/**
 * This interface wraps around a result object or an exception if the result is not available
 *
 * @param <R> the actual result object type
 */
public interface Result<R> {

    /**
     * Tells whether or not the result has error
     *
     * @return true if the result contains error (exception)
     */
    boolean hasError();

    /**
     * getter for the exception if result is not available
     *
     * @return an exception if the result has error, null otherwise
     */
    Exception getException();

    /**
     * getter for the result object
     *
     * @return the result of type <R> if available, null otherwise
     */
    R getResult();
}
