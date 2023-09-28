package com.bazaarvoice.ostrich.metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ClassMetricsTest {
    private final MetricRegistry _registry = new MetricRegistry();
    private final Metrics.ClassMetrics _metrics = Metrics.forClass(_registry, Service.class);

    @After
    public void teardown() {
        _metrics.close();
    }

    @Test(expected = NullPointerException.class)
    public void testNullRegistry() {
        Metrics.forClass(null, Service.class);
    }

    @Test(expected = NullPointerException.class)
    public void testNullDomain() {
        Metrics.forClass(_registry, null);
    }

    @Test
    public void testNamesWithDifferentServiceNames() {
        String name1 = _metrics.name("serviceName1", "name");
        String name2 = _metrics.name("serviceName2", "name");
        assertNotEquals(name1, name2);
    }

    @Test
    public void testNamesWithIdenticalServiceNames() {
        String name1 = _metrics.name("serviceName", "name");
        String name2 = _metrics.name("serviceName", "name");
        assertEquals(name1, name2);
    }

    @Test(expected = NullPointerException.class)
    public void testNullGauge() {
        _metrics.gauge("serviceName", "name", null);
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NullPointerException.class)
    public void testNewGaugeNullServiceName() {
        _metrics.gauge(null, "name", mock(Gauge.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = IllegalArgumentException.class)
    public void testNewGaugeEmptyServiceName() {
        _metrics.gauge("", "name", mock(Gauge.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NullPointerException.class)
    public void testNewGaugeNullName() {
        _metrics.gauge("serviceName", null, mock(Gauge.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = IllegalArgumentException.class)
    public void testNewGaugeEmptyName() {
        _metrics.gauge("serviceName", "", mock(Gauge.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testNewGauge() {
        _metrics.gauge("serviceName", "name", mock(Gauge.class));
        assertRegistered("serviceName", "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewCounterNullServiceName() {
        _metrics.counter(null, "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewCounterNullName() {
        _metrics.counter("serviceName", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewCounterEmptyServiceName() {
        _metrics.counter("", "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewCounterEmptyName() {
        _metrics.counter("serviceName", "");
    }

    @Test
    public void testNewCounter() {
        _metrics.counter("serviceName", "name");
        assertRegistered("serviceName", "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewHistogramNullServiceName() {
        _metrics.histogram(null, "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewHistogramNullName() {
        _metrics.histogram("serviceName", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewHistogramEmptyServiceName() {
        _metrics.histogram("", "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewHistogramEmptyName() {
        _metrics.histogram("serviceName", "");
    }

    @Test
    public void testNewHistogram() {
        _metrics.histogram("serviceName", "name");
        assertRegistered("serviceName", "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewMeterNullServiceName() {
        _metrics.meter(null, "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewMeterNullName() {
        _metrics.meter("serviceName", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewMeterEmptyServiceName() {
        _metrics.meter("", "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewMeterEmptyName() {
        _metrics.meter("serviceName", "");
    }

    @Test
    public void testNewMeter() {
        _metrics.meter("serviceName", "name");
        assertRegistered("serviceName", "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewTimerNullServiceName() {
        _metrics.timer(null, "name");
    }

    @Test(expected = NullPointerException.class)
    public void testNewTimerNullName() {
        _metrics.timer("serviceName", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewTimerEmptyServiceName() {
        _metrics.timer("", "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewTimerEmptyName() {
        _metrics.timer("serviceName", "");
    }

    @Test
    public void testNewTimer() {
        _metrics.timer("serviceName", "name");
        assertRegistered("serviceName", "name");
    }

    @Test
    public void testCloseUnregisters() {
        _metrics.counter("serviceName", "name");
        assertRegistered("serviceName", "name");

        _metrics.close();
        assertNotRegistered("serviceName", "name");
    }

    @Test
    public void testPathologicalServiceName() {
        // ,=:*? and newline are invalid characters in a JMX ObjectName. Backslash and quote need to be escaped.
        String serviceName = "\"\\,:=?*\n";
        _metrics.name(serviceName, "name");
    }

    @Test
    public void testPathologicalName() {
        // ,=:*? and newline are invalid characters in a JMX ObjectName. Backslash and quote need to be escaped.
        String name = "\"\\,:=?*\n";
        _metrics.name("serviceName", name);
    }

    private void assertRegistered(String serviceName, String name) {
        String metricName = _metrics.name(serviceName, name);
        Metric metric = _registry.getMetrics().get(metricName);
        assertNotNull(metric);
    }

    private void assertNotRegistered(String serviceName, String name) {
        String metricName = _metrics.name(serviceName, name);
        Metric metric = _registry.getMetrics().get(metricName);
        assertNull(metric);
    }

    private static <T> void assertNotEquals(T a, T b) {
        assertThat(a, not(equalTo(b)));
    }

    // Dummy class for testing.
    private static class Service {}
}
