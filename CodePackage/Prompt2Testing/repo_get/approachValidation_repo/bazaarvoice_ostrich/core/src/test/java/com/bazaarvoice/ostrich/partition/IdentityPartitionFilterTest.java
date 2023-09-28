package com.bazaarvoice.ostrich.partition;

import com.bazaarvoice.ostrich.PartitionContext;
import com.bazaarvoice.ostrich.ServiceEndPoint;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

public class IdentityPartitionFilterTest {
    @SuppressWarnings("unchecked")
    @Test
    public void testIdentityFilter() {
        Iterable<ServiceEndPoint> iterable = mock(Iterable.class);
        IdentityPartitionFilter filter = new IdentityPartitionFilter();

        assertSame(iterable, filter.filter(iterable, mock(PartitionContext.class)));
    }
}
