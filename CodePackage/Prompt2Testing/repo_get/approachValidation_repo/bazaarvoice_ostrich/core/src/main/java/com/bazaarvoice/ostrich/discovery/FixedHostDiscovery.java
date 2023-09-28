package com.bazaarvoice.ostrich.discovery;

import com.bazaarvoice.ostrich.HostDiscovery;
import com.bazaarvoice.ostrich.ServiceEndPoint;
import com.google.common.collect.ImmutableSet;

import java.io.IOException;
import java.util.Set;

/**
 * Hard-coded list of service end points.  Useful in cross data-center configurations where ZooKeeper is not
 * appropriate and for testing in local environments that don't need to use ZooKeeper.
 */
public class FixedHostDiscovery implements HostDiscovery {
    private final Set<ServiceEndPoint> _endPoints;

    public FixedHostDiscovery(ServiceEndPoint... endPoints) {
        _endPoints = ImmutableSet.copyOf(endPoints);
    }

    public FixedHostDiscovery(Iterable<ServiceEndPoint> endPoints) {
        _endPoints = ImmutableSet.copyOf(endPoints);
    }

    @Override
    public Iterable<ServiceEndPoint> getHosts() {
        return _endPoints;
    }

    @Override
    public void addListener(EndPointListener listener) {
        // Nothing to do, end point collection never changes.
    }

    @Override
    public void removeListener(EndPointListener listener) {
        // Nothing to do, end point collection never changes.
    }

    @Override
    public void close() throws IOException {
        // Nothing to do
    }
}
