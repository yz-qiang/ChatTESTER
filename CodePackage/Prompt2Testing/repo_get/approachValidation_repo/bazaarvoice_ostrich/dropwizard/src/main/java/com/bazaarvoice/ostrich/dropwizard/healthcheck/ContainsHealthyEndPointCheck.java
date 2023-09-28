package com.bazaarvoice.ostrich.dropwizard.healthcheck;

import com.bazaarvoice.ostrich.HealthCheckResult;
import com.bazaarvoice.ostrich.HealthCheckResults;
import com.bazaarvoice.ostrich.ServicePool;
import com.bazaarvoice.ostrich.pool.ServicePoolProxies;
import com.codahale.metrics.health.HealthCheck;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple health check that verifies a pool has a healthy end point. Will perform a health check on at least one end
 * point, so beware the possibility of overloading your services with health checks if this is run excessively.
 */
public class ContainsHealthyEndPointCheck extends HealthCheck {
    private final ServicePool<?> _pool;

    private ContainsHealthyEndPointCheck(ServicePool<?> pool) {
        _pool = checkNotNull(pool);
    }

    /**
     * Returns a newly constructed health check for the given pool that will show as healthy if it has at least one
     * healthy end point.
     *
     * @param pool The {@code ServicePool} to look for healthy end points in.
     */
    public static ContainsHealthyEndPointCheck forPool(ServicePool<?> pool) {
        return new ContainsHealthyEndPointCheck(pool);
    }

    /**
     * Returns a newly constructed health check for the pool of the given proxy that will show as healthy if
     * it has at least one healthy end point.
     *
     * @param proxy The {@code ServicePoolProxy} containing the service pool to look for valid end points in.
     */
    public static ContainsHealthyEndPointCheck forProxy(Object proxy) {
        return new ContainsHealthyEndPointCheck(ServicePoolProxies.getPool(proxy));
    }

    @Override
    public Result check() throws Exception {
        HealthCheckResults results = _pool.checkForHealthyEndPoint();
        boolean healthy = results.hasHealthyResult();
        HealthCheckResult healthyResult = results.getHealthyResult();

        // Get stats about any failed health checks
        int numUnhealthy = 0;
        long totalUnhealthyResponseTimeInMicros = 0;
        for (HealthCheckResult unhealthy : results.getUnhealthyResults()) {
            ++numUnhealthy;
            totalUnhealthyResponseTimeInMicros += unhealthy.getResponseTime(TimeUnit.MICROSECONDS);
        }

        if (!healthy && numUnhealthy == 0) {
            return Result.unhealthy("No end points.");
        }

        String unhealthyMessage = numUnhealthy + " failures in " + totalUnhealthyResponseTimeInMicros + "us";
        if (!healthy) {
            return Result.unhealthy(unhealthyMessage);
        }
        return Result.healthy(healthyResult.getEndPointId() + " succeeded in " +
                healthyResult.getResponseTime(TimeUnit.MICROSECONDS) + "us; " + unhealthyMessage);
    }
}
