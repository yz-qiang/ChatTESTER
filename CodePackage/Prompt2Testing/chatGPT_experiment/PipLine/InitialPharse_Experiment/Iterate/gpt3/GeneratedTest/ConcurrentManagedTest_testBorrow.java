package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testBorrow
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
public class ConcurrentManagedTest_testBorrow {
    @Mock
    private Caller caller;
    @Mock
    private ManagedOptions options;
    @Mock
    private Supplier<? extends Stage<T>> setup;
    @Mock
    private Completable<Void> startFuture;
    @Mock
    private Completable<Void> zeroLeaseFuture;
    @Mock
    private Completable<T> stopReferenceFuture;
    @Mock
    private Stage<Void> stopFuture;
    private ConcurrentManaged<T> concurrentManaged;
    @Before
    public void setUp() {
        concurrentManaged = new ConcurrentManaged<>(caller, options, setup, startFuture, zeroLeaseFuture, stopReferenceFuture, stopFuture);
    }
    @Test
    public void testBorrow() {
        T value = mock(T.class);
        ValidBorrowed<T> expectedBorrowed = new ValidBorrowed<>(value, new StackTraceElement[0]);
        AtomicReference<T> reference = new AtomicReference<>(value);
        concurrentManaged.reference = reference;
        concurrentManaged.traces = Collections.newSetFromMap(new ConcurrentHashMap<ValidBorrowed<T>, Boolean>());
        Borrowed<T> actualBorrowed = concurrentManaged.borrow();
        assertEquals(expectedBorrowed, actualBorrowed);
        assertTrue(concurrentManaged.traces.contains(expectedBorrowed));
    }
}