package com.bazaarvoice.ostrich.metrics;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InstanceMetricsTest {
    private static final Service INSTANCE_ONE = new Service();
    private static final Service INSTANCE_TWO = new Service();

    private final MetricRegistry _registry = new MetricRegistry();
    private final Collection<Metrics.InstanceMetrics> _created = Lists.newArrayList();

    @After
    public void teardown() {
        for (Metrics.InstanceMetrics metrics : _created) {
            metrics.close();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testNullRegistry() {
        Metrics.forInstance(null, INSTANCE_ONE, "serviceName");
    }

    @Test(expected = NullPointerException.class)
    public void testNullInstance() {
        Metrics.forInstance(_registry, null, "serviceName");
    }

    @Test(expected = NullPointerException.class)
    public void testNullServiceName() {
        Metrics.forInstance(_registry, INSTANCE_ONE, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyServiceName() {
        Metrics.forInstance(_registry, INSTANCE_ONE, "");
    }

    @Test
    public void testIncrementsInstanceCount() {
        Metrics.InstanceMetrics metrics = newMetrics(INSTANCE_ONE, "serviceName");
        assertEquals(1, getInstanceCount(metrics));
    }

    @Test
    public void testInstanceCounterReusedWithSameTypes() {
        Metrics.InstanceMetrics metrics1 = newMetrics(INSTANCE_ONE, "serviceName");
        Metrics.InstanceMetrics metrics2 = newMetrics(INSTANCE_TWO, "serviceName");
        assertEquals(2, getInstanceCount(metrics1));
        assertEquals(2, getInstanceCount(metrics2));
    }

    @Test
    public void testInstanceCounterNotReusedWithDifferentTypes() {
        Metrics.InstanceMetrics metrics1 = newMetrics(INSTANCE_ONE, "serviceName");
        Metrics.InstanceMetrics metrics2 = newMetrics(new Object(), "serviceName");
        assertEquals(1, getInstanceCount(metrics1));
        assertEquals(1, getInstanceCount(metrics2));
    }

    @Test
    public void testCloseDecrementsInstanceCounter() {
        Metrics.InstanceMetrics metrics = newMetrics(INSTANCE_ONE, "serviceName");
        metrics.close();

        assertEquals(0, getInstanceCount(metrics));
    }

    @Test
    public void testCloseKeepsInstanceCounter() {
        Metrics.InstanceMetrics metrics1 = newMetrics(INSTANCE_ONE, "serviceName");
        Metrics.InstanceMetrics metrics2 = newMetrics(INSTANCE_TWO, "serviceName");
        metrics2.close();

        assertEquals(1, getInstanceCount(metrics1));
    }

    @Test
    public void testCloseUnregistersInstanceCounter() {
        Metrics.InstanceMetrics metrics = newMetrics(INSTANCE_ONE, "serviceName");
        metrics.close();

        assertNotRegistered(metrics, "num-instances");
    }

    private Metrics.InstanceMetrics newMetrics(Object instance, String serviceName) {
        Metrics.InstanceMetrics metrics = Metrics.forInstance(_registry, instance, serviceName);
        _created.add(metrics);
        return metrics;
    }

    private long getInstanceCount(Metrics.InstanceMetrics metrics) {
        return metrics.getInstanceCounter().getCount();
    }

    private void assertNotRegistered(Metrics.InstanceMetrics metrics, String name) {
        String metricName = metrics.name(name);
        Metric metric = _registry.getMetrics().get(metricName);
        assertNull(metric);
    }

    // Dummy class for testing.
    private static class Service {}
}
