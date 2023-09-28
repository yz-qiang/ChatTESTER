package com.bazaarvoice.ostrich.healthcheck;

import com.bazaarvoice.ostrich.HealthCheckResult;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Retry policy that always returns the same value.
 */
public class FixedHealthCheckRetryDelay implements HealthCheckRetryDelay {
    public static final FixedHealthCheckRetryDelay ZERO = new FixedHealthCheckRetryDelay(0, TimeUnit.MILLISECONDS);

    private final long _retryMillis;

    public FixedHealthCheckRetryDelay(long duration, TimeUnit unit) {
        checkArgument(duration >= 0);
        checkNotNull(unit);

        _retryMillis = unit.toMillis(duration);
    }

    @Override
    public long getDelay(int numAttempts, HealthCheckResult result) {
        return _retryMillis;
    }
}
