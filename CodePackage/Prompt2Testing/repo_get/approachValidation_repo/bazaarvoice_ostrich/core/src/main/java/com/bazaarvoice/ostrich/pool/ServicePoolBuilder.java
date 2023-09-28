package com.bazaarvoice.ostrich.pool;

import com.bazaarvoice.ostrich.HostDiscovery;
import com.bazaarvoice.ostrich.HostDiscoverySource;
import com.bazaarvoice.ostrich.LoadBalanceAlgorithm;
import com.bazaarvoice.ostrich.RetryPolicy;
import com.bazaarvoice.ostrich.ServiceFactory;
import com.bazaarvoice.ostrich.healthcheck.ExponentialBackoffHealthCheckRetryDelay;
import com.bazaarvoice.ostrich.healthcheck.HealthCheckRetryDelay;
import com.bazaarvoice.ostrich.loadbalance.RandomAlgorithm;
import com.bazaarvoice.ostrich.partition.IdentityPartitionFilter;
import com.bazaarvoice.ostrich.partition.PartitionFilter;
import com.bazaarvoice.ostrich.partition.PartitionKey;
import com.codahale.metrics.MetricRegistry;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.base.Ticker;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

public class ServicePoolBuilder<S> {
    private static final int DEFAULT_NUM_HEALTH_CHECK_THREADS = 1;
    private static final HealthCheckRetryDelay DEFAULT_HEALTH_CHECK_RETRY_POLICY = new ExponentialBackoffHealthCheckRetryDelay(100, 10_000, TimeUnit.MILLISECONDS);

    private final Class<S> _serviceType;
    private final List<HostDiscoverySource> _hostDiscoverySources = Lists.newArrayList();
    private boolean _closeHostDiscovery;
    private ServiceFactory<S> _serviceFactory;
    private String _serviceName;
    private ScheduledExecutorService _healthCheckExecutor;
    private ServiceCachingPolicy _cachingPolicy;
    private PartitionFilter _partitionFilter = new IdentityPartitionFilter();
    private PartitionContextSupplier _partitionContextSupplier = new EmptyPartitionContextSupplier();
    private LoadBalanceAlgorithm _loadBalanceAlgorithm = new RandomAlgorithm();
    private MetricRegistry _metrics;
    private ExecutorService _asyncExecutor;
    private HealthCheckRetryDelay _healthCheckRetryDelay = DEFAULT_HEALTH_CHECK_RETRY_POLICY;

    public static <S> ServicePoolBuilder<S> create(Class<S> serviceType) {
        return new ServicePoolBuilder<>(serviceType);
    }

    private ServicePoolBuilder(Class<S> serviceType) {
        _serviceType = checkNotNull(serviceType);
    }

    /**
     * Adds a {@link HostDiscoverySource} instance to the builder.  Multiple instances of {@code HostDiscoverySource}
     * may be specified.  The service pool will query the sources in the order they were registered and use the first
     * non-null {@link HostDiscovery} returned for the service name provided by the
     * {@link ServiceFactory#getServiceName()} method of the factory configured by {@link #withServiceFactory}.
     * <p>
     * Note that using this method will cause the ServicePoolBuilder to call
     * {@link HostDiscoverySource#forService(String serviceName)} when {@link #build()} is called and pass the returned
     * {@link HostDiscovery} to the new {@code ServicePool}.  Subsequently calling {@link ServicePool#close()} will in
     * turn call {@link HostDiscovery#close()} on the passed instance.
     *
     * @param hostDiscoverySource a host discovery source to use to find the {@link HostDiscovery} when constructing
     * the {@link ServicePool}
     * @return this
     */
    public ServicePoolBuilder<S> withHostDiscoverySource(HostDiscoverySource hostDiscoverySource) {
        checkNotNull(hostDiscoverySource);
        return withHostDiscovery(hostDiscoverySource, true);
    }

    /**
     * Adds a {@link HostDiscovery} instance to the builder.  The service pool will use this {@code HostDiscovery}
     * instance unless a preceding {@link HostDiscoverySource} provides a non-null instance of {@code HostDiscovery} for
     * a given service name.
     * <p>
     * Once this method is called, any subsequent calls to host discovery-related methods on this builder instance are
     * ignored (because this non-null discovery will always be returned).
     * <p>
     * Note that callers of this method are responsible for calling {@link HostDiscovery#close} on the passed instance.
     *
     * @param hostDiscovery the host discovery instance to use in the built {@link ServicePool}
     * @return this
     */
    public ServicePoolBuilder<S> withHostDiscovery(final HostDiscovery hostDiscovery) {
        checkNotNull(hostDiscovery);
        HostDiscoverySource hostDiscoverySource = new HostDiscoverySource() {
            @Override
            public HostDiscovery forService(String serviceName) {
                return hostDiscovery;
            }
        };
        return withHostDiscovery(hostDiscoverySource, false);
    }

    private ServicePoolBuilder<S> withHostDiscovery(HostDiscoverySource source, boolean close) {
        _hostDiscoverySources.add(close
                ? new ClosingHostDiscoverySource(source)
                : source);
        return this;
    }

    /**
     * Adds a {@code ServiceFactory} instance to the builder.  The {@code ServiceFactory#configure} method will be
     * called at this time to allow the {@code ServiceFactory} to set service pool settings on the builder.
     * <p>
     * @param serviceFactory the ServiceFactory to use
     * @return this
     */
    public ServicePoolBuilder<S> withServiceFactory(ServiceFactory<S> serviceFactory) {
        checkNotNull(serviceFactory);
        checkArgument(!Strings.isNullOrEmpty(serviceFactory.getServiceName()), "Service name must be configured");

        _serviceFactory = serviceFactory;
        _serviceName = serviceFactory.getServiceName();
        _serviceFactory.configure(this);
        return this;
    }

    /**
     * Adds a {@code ScheduledExecutorService} instance to the builder for use in executing health checks.
     * <p/>
     * Adding an executor is optional.  If one isn't specified then one will be created and used automatically.
     *
     * @param executor The {@code ScheduledExecutorService} to use
     * @return this
     */
    public ServicePoolBuilder<S> withHealthCheckExecutor(ScheduledExecutorService executor) {
        _healthCheckExecutor = checkNotNull(executor);
        return this;
    }

    /**
     * Adds an {@code ExecutorService} instance to the builder for use in executing asynchronous requests. The executor
     * is not used unless an asynchronous pool is built with the {@link #buildAsync} method.
     * <p/>
     * Adding an executor is optional.  If one isn't specified then one will be created and used automatically when
     * {@code buildAsync} is called.
     *
     * @param executor The {@code ExecutorService} to use
     * @return this
     */
    public ServicePoolBuilder<S> withAsyncExecutor(ExecutorService executor) {
        _asyncExecutor = checkNotNull(executor);
        return this;
    }

    /**
     * Enables caching of service instances in the built {@link ServicePool}.
     * <p/>
     * Specifying a caching policy is optional.  If one isn't specified then a default one that doesn't cache service
     * instances will be created and used automatically.
     *
     * @param policy The {@link ServiceCachingPolicy} to use
     * @return this
     */
    public ServicePoolBuilder<S> withCachingPolicy(ServiceCachingPolicy policy) {
        _cachingPolicy = checkNotNull(policy);
        return this;
    }

    /**
     * Uses the specified partition filter on every service pool operation to narrow down the set of end points that
     * may be used to service a particular request.
     *
     * @param partitionFilter The {@link PartitionFilter} to use
     * @return  this
     */
    public ServicePoolBuilder<S> withPartitionFilter(PartitionFilter partitionFilter) {
        _partitionFilter = checkNotNull(partitionFilter);
        return this;
    }

    /**
     * Makes the built proxy generate partition context based on the {@link PartitionKey} annotation
     * on method arguments in class {@code S}.
     * <p>
     * If {@code S} is not annotated, or annotated differently than desired, consider using
     * {@link #withPartitionContextAnnotationsFrom(Class)} instead.
     * <p>
     * NOTE: This is only useful if building a proxy with {@link #buildProxy(com.bazaarvoice.ostrich.RetryPolicy)}.  If
     * partition context is necessary with a normal service pool, then can be provided directly by calling
     * {@link com.bazaarvoice.ostrich.ServicePool#execute(com.bazaarvoice.ostrich.PartitionContext,
     * com.bazaarvoice.ostrich.RetryPolicy, com.bazaarvoice.ostrich.ServiceCallback)}.
     *
     * @return this
     */
    public ServicePoolBuilder<S> withPartitionContextAnnotations() {
        return withPartitionContextAnnotationsFrom(_serviceType);
    }

    /**
     * Uses {@link PartitionKey} annotations from the specified class to generate partition context in the built proxy.
     * <p>
     * NOTE: This is only useful if building a proxy with {@link #buildProxy(com.bazaarvoice.ostrich.RetryPolicy)}.  If
     * partition context is necessary with a normal service pool, then can be provided directly by calling
     * {@link com.bazaarvoice.ostrich.ServicePool#execute(com.bazaarvoice.ostrich.PartitionContext,
     * com.bazaarvoice.ostrich.RetryPolicy, com.bazaarvoice.ostrich.ServiceCallback)}.
     *
     * @param annotatedServiceClass A service class with {@link PartitionKey} annotations.
     * @return this
     */
    public ServicePoolBuilder<S> withPartitionContextAnnotationsFrom(Class<? extends S> annotatedServiceClass) {
        checkNotNull(annotatedServiceClass);
        _partitionContextSupplier = new AnnotationPartitionContextSupplier(_serviceType, annotatedServiceClass);
        return this;
    }

    /**
     * Sets the {@code LoadBalanceAlgorithm} that should be used for this service.
     *
     * @param algorithm A load balance algorithm to choose between available end points for the service.
     * @return this
     */
    public ServicePoolBuilder<S> withLoadBalanceAlgorithm(LoadBalanceAlgorithm algorithm) {
        _loadBalanceAlgorithm = checkNotNull(algorithm);
        return this;
    }

    /** Sets the {@code MetricRegistry} that should be used for this service.
     *
     * @param metrics The metric registry to use.
     * @return this
     */
    public ServicePoolBuilder<S> withMetricRegistry(MetricRegistry metrics) {
        _metrics = checkNotNull(metrics);
        return this;
    }

    /**
     * Sets the {@code HealthCheckRetryPolicy} that should be used for this service.
     *
     * @param healthCheckRetryDelay retry policy to use
     * @return this
     */
    public ServicePoolBuilder<S> withHealthCheckRetryPolicy(HealthCheckRetryDelay healthCheckRetryDelay) {
        _healthCheckRetryDelay = checkNotNull(healthCheckRetryDelay);
        return this;
    }

    /**
     * Builds a {@code com.bazaarvoice.ostrich.ServicePool}.
     *
     * @return The {@code com.bazaarvoice.ostrich.ServicePool} that was constructed.
     */
    public com.bazaarvoice.ostrich.ServicePool<S> build() {
        return buildInternal();
    }

    /**
     * Builds a {@code com.bazaarvoice.ostrich.AsyncServicePool}.
     *
     * @return The {@code com.bazaarvoice.ostrich.AsyncServicePool} that was constructed.
     */
    public com.bazaarvoice.ostrich.AsyncServicePool<S> buildAsync() {
        ServicePool<S> pool = buildInternal();

        boolean shutdownAsyncExecutorOnClose = (_asyncExecutor == null);
        if (_asyncExecutor == null) {
            ThreadFactory threadFactory = new ThreadFactoryBuilder()
                    .setNameFormat(_serviceName + "-AsyncExecutorThread-%d")
                    .setDaemon(true)
                    .build();
            _asyncExecutor = Executors.newCachedThreadPool(threadFactory);
        }

        return new AsyncServicePool<>(Ticker.systemTicker(), pool, true, _asyncExecutor,
                shutdownAsyncExecutorOnClose, _metrics);
    }

    /**
     * Builds a dynamic proxy that wraps a {@code ServicePool} and implements the service interface directly.  This is
     * appropriate for stateless services where it's sensible for the same retry policy to apply to every method.
     * <p/>
     * It is the caller's responsibility to shutdown the service pool when they're done with it by casting the proxy
     * to {@link java.io.Closeable} and calling the {@link java.io.Closeable#close()} method.
     *
     * @param retryPolicy The retry policy to apply for every service call.
     * @return The dynamic proxy instance that implements the service interface {@code S} and the
     *         {@link java.io.Closeable} interface.
     */
    public S buildProxy(RetryPolicy retryPolicy) {
        return ServicePoolProxy.create(_serviceType, retryPolicy, build(), _partitionContextSupplier, true);
    }

    @VisibleForTesting
    ServicePool<S> buildInternal() {
        checkNotNull(_serviceFactory);
        checkNotNull(_metrics);

        HostDiscovery hostDiscovery = findHostDiscovery(_serviceName);

        boolean shutdownHealthCheckExecutorOnClose = (_healthCheckExecutor == null);

        try {
            if (_cachingPolicy == null) {
                _cachingPolicy = ServiceCachingPolicyBuilder.NO_CACHING;
            }

            if (_healthCheckExecutor == null) {
                _healthCheckExecutor = Executors.newScheduledThreadPool(DEFAULT_NUM_HEALTH_CHECK_THREADS,
                        new ThreadFactoryBuilder()
                                .setNameFormat(_serviceName + "-HealthCheckThread-%d")
                                .setDaemon(true)
                                .build());
            }

            ServicePool<S> servicePool = new ServicePool<>(Ticker.systemTicker(), hostDiscovery, _closeHostDiscovery,
                    _serviceFactory, _cachingPolicy, _partitionFilter, _loadBalanceAlgorithm, _healthCheckExecutor,
                    shutdownHealthCheckExecutorOnClose, _healthCheckRetryDelay, _metrics);

            _closeHostDiscovery = false;

            return servicePool;
        } catch (Throwable t) {
            if (shutdownHealthCheckExecutorOnClose && _healthCheckExecutor != null) {
                _healthCheckExecutor.shutdownNow();
                _healthCheckExecutor = null;
            }

            try {
                if (_closeHostDiscovery) {
                    hostDiscovery.close();
                }
            } catch (IOException e) {
                // NOP
            } finally {
                _closeHostDiscovery = false;
            }

            Throwables.throwIfUnchecked(t);
            throw new RuntimeException(t);
        }
    }

    private HostDiscovery findHostDiscovery(String serviceName) {
        for (HostDiscoverySource source : _hostDiscoverySources) {
            HostDiscovery hostDiscovery = source.forService(serviceName);
            if (hostDiscovery != null) {
                return hostDiscovery;
            }
        }
        throw new IllegalStateException(format("No HostDiscovery found for service: %s", serviceName));
    }

    private class ClosingHostDiscoverySource implements HostDiscoverySource {
        private HostDiscoverySource _wrappedSource;

        public ClosingHostDiscoverySource(HostDiscoverySource wrappedSource) {
            _wrappedSource = wrappedSource;
        }

        @Override
        public HostDiscovery forService(String serviceName) {
            HostDiscovery hostDiscovery = _wrappedSource.forService(serviceName);
            if (hostDiscovery != null) {
                _closeHostDiscovery = true;
            }
            return hostDiscovery;
        }
    }
}
