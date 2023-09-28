package com.bazaarvoice.ostrich.discovery.zookeeper;

import com.bazaarvoice.curator.recipes.NodeDiscovery;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.io.Closeables;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.utils.ZKPaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ZooKeeperServiceDiscoveryTest {
    private ZooKeeperServiceDiscovery _discovery;
    private NodeDiscovery<String> _nodeDiscovery;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() throws Exception {
        _nodeDiscovery = mock(NodeDiscovery.class);
        _discovery = new ZooKeeperServiceDiscovery(_nodeDiscovery);
    }

    @After
    public void teardown() throws Exception {
        Closeables.close(_discovery, true);
    }

    @Test(expected = NullPointerException.class)
    public void testNullCurator() {
        new ZooKeeperServiceDiscovery((CuratorFramework) null);
    }

    @Test
    public void testNoServices() {
        setServices();
        assertEquals(0, Iterables.size(_discovery.getServices()));
    }

    @Test
    public void testOneService() {
        setServices("service");

        Iterable<String> services = _discovery.getServices();
        assertEquals(1, Iterables.size(services));
        assertEquals("service", Iterables.get(services, 0));
    }

    @Test
    public void testMultipleServices() {
        setServices("service1", "service2");

        Iterable<String> services = _discovery.getServices();
        assertEquals(2, Iterables.size(services));
        assertTrue(Iterables.contains(services, "service1"));
        assertTrue(Iterables.contains(services, "service2"));
    }

    @Test
    public void testClosesNodeDiscovery() throws IOException {
        _discovery.close();
        verify(_nodeDiscovery).close();
    }

    @Test
    public void testServiceNameParser() {
        String path = ZKPaths.makePath(ZooKeeperServiceDiscovery.ROOT_SERVICES_PATH, "service");

        String service = ZooKeeperServiceDiscovery.SERVICE_NAME_PARSER.parse(path, null);
        assertEquals("service", service);
    }

    private void setServices(String... services) {
        Map<String, String> serviceMap = Maps.newHashMap();
        for (String service : services) {
            serviceMap.put(service, service);
        }

        when(_nodeDiscovery.getNodes()).thenReturn(serviceMap);
    }
}
