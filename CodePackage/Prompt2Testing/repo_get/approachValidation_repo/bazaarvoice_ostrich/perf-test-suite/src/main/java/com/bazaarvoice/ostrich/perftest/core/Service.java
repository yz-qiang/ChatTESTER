package com.bazaarvoice.ostrich.perftest.core;

/**
 * A simple service interface that specifies the input and output type of the service
 *
 * @param <W> the input work
 * @param <R> the output result
 */
public interface Service<W, R> {

    /**
     * defines the actual process of the service that takes in the input and returns the output
     *
     * @param work the input
     * @return the output of the precess
     */
    public R process(W work);

    /**
     * initializer for the service
     */
    void initialize();

    /**
     * destroyer of the service, to clean up resources gracefully
     */
    void destroy();

}


