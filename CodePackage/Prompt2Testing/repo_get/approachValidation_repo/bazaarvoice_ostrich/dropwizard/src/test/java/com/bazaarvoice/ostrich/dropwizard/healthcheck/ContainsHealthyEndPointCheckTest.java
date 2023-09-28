package com.bazaarvoice.ostrich.dropwizard.healthcheck;

import com.bazaarvoice.ostrich.HealthCheckResult;
import com.bazaarvoice.ostrich.HealthCheckResults;
import com.bazaarvoice.ostrich.ServicePool;
import com.codahale.metrics.health.HealthCheck;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
public class ContainsHealthyEndPointCheckTest {
    private static final HealthCheckResult HEALTHY = mock(HealthCheckResult.class);
    private static final HealthCheckResult UNHEALTHY = mock(HealthCheckResult.class);

    private final ServicePool<Service> _pool = mock(ServicePool.class);
    private final HealthCheckResults _results = mock(HealthCheckResults.class);

    private HealthCheck _check;

    @Before
    public void setup() {
        when(HEALTHY.isHealthy()).thenReturn(true);
        when(UNHEALTHY.isHealthy()).thenReturn(false);

        // Default to empty results.
        when(_pool.checkForHealthyEndPoint()).thenReturn(_results);
        when(_results.getHealthyResult()).thenReturn(null);
        when(_results.getUnhealthyResults()).thenReturn(Collections.<HealthCheckResult>emptyList());
        when(_results.hasHealthyResult()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return _results.getHealthyResult() != null;
            }
        });
        when(_results.getAllResults()).thenAnswer(new Answer<Iterable<HealthCheckResult>>() {
            @Override
            public Iterable<HealthCheckResult> answer(InvocationOnMock invocationOnMock) throws Throwable {
                return Iterables.concat(ImmutableList.of(_results.getHealthyResult()), _results.getUnhealthyResults());
            }
        });

        _check = ContainsHealthyEndPointCheck.forPool(_pool);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPool() {
        ContainsHealthyEndPointCheck.forPool(null);
    }

    @Test
    public void testEmptyResult() {
        assertFalse(_check.execute().isHealthy());
    }

    @Test
    public void testOnlyUnhealthyResult() {
        when(_results.getUnhealthyResults()).thenReturn(ImmutableList.of(UNHEALTHY));

        assertFalse(_check.execute().isHealthy());
    }

    @Test
    public void testOnlyHealthyResult() {
        when(_results.getHealthyResult()).thenReturn(HEALTHY);

        assertTrue(_check.execute().isHealthy());
    }

    @Test
    public void testBothResults() {
        when(_results.getHealthyResult()).thenReturn(HEALTHY);
        when(_results.getUnhealthyResults()).thenReturn(ImmutableList.of(UNHEALTHY));

        assertTrue(_check.execute().isHealthy());
    }

    interface Service {}
}
