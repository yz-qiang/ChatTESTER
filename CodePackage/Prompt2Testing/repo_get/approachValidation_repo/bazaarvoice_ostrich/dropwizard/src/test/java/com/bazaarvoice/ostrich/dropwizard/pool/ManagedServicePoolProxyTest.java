package com.bazaarvoice.ostrich.dropwizard.pool;

import com.bazaarvoice.ostrich.ServicePool;
import com.bazaarvoice.ostrich.pool.ServicePoolProxyHelper;
import io.dropwizard.lifecycle.Managed;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class ManagedServicePoolProxyTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        new ManagedServicePoolProxy(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotProxy() {
        new ManagedServicePoolProxy(mock(Service.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testStart() throws Exception {
        ServicePool<Service> pool = mock(ServicePool.class);
        Service service = ServicePoolProxyHelper.createMock(Service.class, pool);
        Managed managed = new ManagedServicePoolProxy(service);

        managed.start();
        verifyZeroInteractions(pool);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testStop() throws Exception {
        ServicePool<Service> pool = mock(ServicePool.class);
        Service service = ServicePoolProxyHelper.createMock(Service.class, pool);
        Managed managed = new ManagedServicePoolProxy(service);

        managed.stop();
        verify(pool).close();
        verifyNoMoreInteractions(pool);
    }

    // A dummy interface for testing...
    private static interface Service {}
}
