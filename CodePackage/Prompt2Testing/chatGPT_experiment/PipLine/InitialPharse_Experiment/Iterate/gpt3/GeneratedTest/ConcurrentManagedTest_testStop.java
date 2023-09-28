package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testStop
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentManagedTest_testStop {
    @Mock
    private Caller caller;
    @Mock
    private ManagedOptions options;
    @Mock
    private Supplier<? extends Stage<Object>> setup;
    @Mock
    private Completable<Void> startFuture;
    @Mock
    private Completable<Void> zeroLeaseFuture;
    @Mock
    private Completable<Object> stopReferenceFuture;
    @Mock
    private Stage<Void> stopFuture;
    private ConcurrentManaged<Object> concurrentManaged;
    @Before
    public void setUp() {
        concurrentManaged = new ConcurrentManaged<>(caller, options, setup, startFuture, zeroLeaseFuture, stopReferenceFuture, stopFuture);
    }
    @Test
    public void testStop() {
        AtomicReference<ConcurrentManaged.ManagedState> state = spy(new AtomicReference<>(ConcurrentManaged.ManagedState.STARTED));
        AtomicReference<Object> reference = spy(new AtomicReference<>());
        concurrentManaged.reference.getAndSet(reference.get());
        when(state.compareAndSet(ConcurrentManaged.ManagedState.STARTED, ConcurrentManaged.ManagedState.STOPPED)).thenReturn(true);
        Object expectedReference = mock(Object.class);
        when(reference.getAndSet(null)).thenReturn(expectedReference);
        doNothing().when(stopReferenceFuture).complete(expectedReference);
        doNothing().when(concurrentManaged).release();
        Stage<Void> result = concurrentManaged.stop();
        verify(state, times(1)).compareAndSet(ConcurrentManaged.ManagedState.STARTED, ConcurrentManaged.ManagedState.STOPPED);
        verify(reference, times(1)).getAndSet(null);
        verify(stopReferenceFuture, times(1)).complete(expectedReference);
        verify(concurrentManaged, times(1)).release();
        assertEquals(stopFuture, result);
    }
}