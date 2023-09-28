package com.bazaarvoice.ostrich.dropwizard.healthcheck;

import com.bazaarvoice.ostrich.ServicePool;
import com.bazaarvoice.ostrich.pool.ServicePoolProxies;
import com.codahale.metrics.health.HealthCheck;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple health check that verifies a pool has at least one valid endpoint. This class will not execute a
 * health check directly, rather it accesses a cached count in the ServicePool via {@link com.bazaarvoice.ostrich.ServicePool#getNumValidEndPoints()},
 * so you will not overload your dependencies with health checks if this is run excessively.
 */
public class ContainsValidEndPointCheck extends HealthCheck {
    private final ServicePool<?> _pool;

    protected ContainsValidEndPointCheck(ServicePool<?> pool) {
        _pool = checkNotNull(pool);
    }

    /**
     * Returns a newly constructed health check for the given pool that will show as healthy if it has at least one valid end point.
     *
     * @param pool The {@code ServicePool} to look for valid end points in.
     */
    public static ContainsValidEndPointCheck forPool(ServicePool<?> pool) {
        return new ContainsValidEndPointCheck(pool);
    }

    /**
     * Returns a newly constructed health check for the pool of the given proxy that will show as healthy if it has at
     * least one valid end point.
     *
     * @param proxy The {@code ServicePoolProxy} containing the service pool to look for valid end points in.
     */
    public static ContainsValidEndPointCheck forProxy(Object proxy) {
        return new ContainsValidEndPointCheck(ServicePoolProxies.getPool(proxy));
    }

    @Override
    protected Result check() throws Exception {
        int numValidEndPoints = _pool.getNumValidEndPoints();
        int numBadEndPoints = _pool.getNumBadEndPoints();

        if (numValidEndPoints == 0 && numBadEndPoints == 0) {
            return Result.unhealthy("No end points.");
        }

        String message = String.format("%d healthy instances; %d unhealthy instances", numValidEndPoints, numBadEndPoints);
        return numValidEndPoints == 0
                ? Result.unhealthy(message)
                : Result.healthy(message);
    }
}
