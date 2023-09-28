package com.bazaarvoice.ostrich;

/**
 * The Multi threaded service factory creates thread safe service instances
 *
 * This applies to heavy weight clients, such as {@code HttpClient},
 * {@code JestClient}, {@code ElasticSearchClient}, etc.
 *
 * @param <S>  the type parameter for the service
 */
public interface MultiThreadedServiceFactory<S> extends ServiceFactory<S> {
}
