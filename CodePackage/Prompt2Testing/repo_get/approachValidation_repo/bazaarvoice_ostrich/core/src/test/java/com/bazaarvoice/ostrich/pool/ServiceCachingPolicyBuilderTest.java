package com.bazaarvoice.ostrich.pool;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ServiceCachingPolicyBuilderTest {
    @Test
    public void testCacheExhaustionActionSet() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withCacheExhaustionAction(ServiceCachingPolicy.ExhaustionAction.GROW);

        assertEquals(ServiceCachingPolicy.ExhaustionAction.GROW, builder.build().getCacheExhaustionAction());
    }

    @Test
    public void testUseMultiThreadedClientPolicy() {
        ServiceCachingPolicy cachingPolicy = ServiceCachingPolicyBuilder.getMultiThreadedClientPolicy();

        assertEquals(true, cachingPolicy.useMultiThreadedClientPolicy());
    }

    @Test
    public void testDefaultMultiThreadedClientPolicy() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();

        assertEquals(false, builder.build().useMultiThreadedClientPolicy());
    }
    
    @Test
    public void testMaxNumServiceInstancesSet() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxNumServiceInstances(1);

        assertEquals(1, builder.build().getMaxNumServiceInstances());
    }
    
    @Test
    public void testMaxNumServiceInstancesPerEndPointSet() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxNumServiceInstancesPerEndPoint(1);

        assertEquals(1, builder.build().getMaxNumServiceInstancesPerEndPoint());
    }
    
    @Test
    public void testMinIdleTimeBeforeEvictionSet() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxServiceInstanceIdleTime(10, TimeUnit.SECONDS);

        assertEquals(10, builder.build().getMaxServiceInstanceIdleTime(TimeUnit.SECONDS));
    }

    @Test(expected = NullPointerException.class)
    public void testNullExhaustionAction() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withCacheExhaustionAction(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidMaxNumServiceInstances() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxNumServiceInstances(-1);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidMaxNumServiceInstancesPerEndPoint() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxNumServiceInstancesPerEndPoint(-1);
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidMaxServiceInstanceIdleTime() {
        ServiceCachingPolicyBuilder builder = new ServiceCachingPolicyBuilder();
        builder.withMaxServiceInstanceIdleTime(0, TimeUnit.MILLISECONDS);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testUseMultiThreadedClientPolicyWithMaxNumServiceInstancesPerEndPoint() {
        ServiceCachingPolicy cachingPolicy = ServiceCachingPolicyBuilder.getMultiThreadedClientPolicy();
        assertEquals(1, cachingPolicy.getMaxNumServiceInstancesPerEndPoint());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testUseMultiThreadedClientPolicyWithMaxServiceInstanceIdleTime() {
        ServiceCachingPolicy cachingPolicy = ServiceCachingPolicyBuilder.getMultiThreadedClientPolicy();
        assertEquals(1, cachingPolicy.getMaxServiceInstanceIdleTime(TimeUnit.SECONDS));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testUseMultiThreadedClientPolicyWithMaxNumServiceInstances() {
        ServiceCachingPolicy cachingPolicy = ServiceCachingPolicyBuilder.getMultiThreadedClientPolicy();
        assertEquals(1, cachingPolicy.getMaxNumServiceInstances());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testUseMultiThreadedClientPolicyWithCacheExhaustionAction() {
        ServiceCachingPolicy cachingPolicy = ServiceCachingPolicyBuilder.getMultiThreadedClientPolicy();
        assertEquals(ServiceCachingPolicy.ExhaustionAction.GROW, cachingPolicy.getCacheExhaustionAction());
    }
}
