package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testToStringTracing
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentManagedTest_testToStringTracing {
    @Mock
    private ValidBorrowed validBorrowed1;
    @Mock
    private ValidBorrowed validBorrowed2;
    @Mock
    private ValidBorrowed validBorrowed3;
    private ConcurrentManaged<String> concurrentManaged;
    @Before
    public void setUp() {
        concurrentManaged = new ConcurrentManaged<>(null, null, null, null, null, null, null);
    }
    @Test
    public void testToStringTracing() {
        List<ValidBorrowed> traces = ImmutableList.of(validBorrowed1, validBorrowed2, validBorrowed3);
        String expected = "Managed(INITIALIZED, null:\n" +
                validBorrowed1.toString() +
                validBorrowed2.toString() +
                validBorrowed3.toString() +
                ")";
        String actual = concurrentManaged.toStringTracing(null, traces);
        assertEquals(expected, actual);
    }
}