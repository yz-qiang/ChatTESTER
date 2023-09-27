package eu.toolchain.concurrent;
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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testToStringTracing
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentManagedTest_testToStringTracing {
    @Mock private Caller mockCaller;
    @Mock private ManagedOptions mockOptions;
    @Mock private Supplier<Stage<Object> mockSetup;
    @Mock private Completable<Void> mockStartFuture;
    @Mock private Completable<Void> mockZeroLeaseFuture;
    @Mock private Completable<Object> mockStopReferenceFuture;
    @Mock private Stage<Void> mockStopFuture;
    private ConcurrentManaged concurrentManaged;
    @Before
    public void setUp() throws Exception {
        when(mockOptions.isCaptureStack()).thenReturn(true);
        concurrentManaged = spy(new ConcurrentManaged(mockCaller, mockOptions, mockSetup, mockStartFuture, mockZeroLeaseFuture, mockStopReferenceFuture, mockStopFuture));
    }
    @Test
    public void testToStringTracingWhenTracingEnabled() {
        String expectedOutput = "Managed(INITIALIZED,\n" +
                            "Trace[0]: Borrowed by thread=Thread-1\n" +
                            ")";
        doReturn(Collections.singletonList(new ValidBorrowed("thread-1")).toArray(new ValidBorrowed[]{})).when(traces).toArray(any(ValidBorrowed[]::new);
        assertEquals(expectedOutput, concurrentManaged.toStringTracing(reference, traces));
    }
    @Test
    public void testToStringTracingWhenTracingDisabled() {
        when(mockOptions.isTracing()).thenReturn(false);
        String expectedOutput = "Managed(INITIALIZED, )";
        assertEquals(expectedOutput, concurrentManaged.toStringTracing(reference, null);
    }
    @Test
    public void testToStringTracingEmptyTraces() {
        when(mockOptions.isTracing()).thenReturn(true);
        String expectedOutput = "Managed(INITIALIZED, )";
        assertEquals(expectedOutput, concurrentManaged.toStringTracing(reference, ImmutableList.<ValidBorrowed>of().asList()));
    }
    @Test
    public void testToStringTracingMultipleTraces() {
        when(mockOptions.isTracing()).thenReturn(true);
        doReturn(Arrays.asList(new ValidBorrowed("thread-1"), new ValidBorrowed("thread-2")).toArray(new ValidBorrowed[]{}).when(traces).toArray(any(ValidBorrowed[]::new);
        String expectedOutput = "Managed(INITIALIZED,\n" +
                           "Trace[0]: Borrowed by thread=Thread-1\n" +
                           "Trace[1]: Borrowed by thread=Thread-2\n" +
                           ")";
        assertEquals(expectedOutput, concurrentManaged.toStringTracing(reference, traces));
    }
}