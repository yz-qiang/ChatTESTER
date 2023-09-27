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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testStop
public class TTT_testStop {
@Test
public void testStop() throws Exception {
    Caller caller = mock(Caller.class);
    ManagedOptions options = mock(ManagedOptions.class);
    Supplier<? extends Stage<T>> setup = mock(Supplier.class);
    Completable<Void> startFuture = mock(Completable.class);
    Completable<Void> zeroLeaseFuture = mock(Completable.class);
    Completable<T> stopReferenceFuture = mock(Completable.class);
    Stage<Void> stopFuture = mock(Stage.class);
    ConcurrentManaged concurrentManaged = spy(new ConcurrentManaged(caller, options, setup, startFuture, zeroLeaseFuture, stopReferenceFuture, stopFuture));
    when(concurrentManaged.setState(ManagedState.STOPPED)).thenReturn(true);
    doNothing().when(concurrentManaged).release();
    Stage<Void> result = concurrentManaged.stop();
    verify(concurrentManaged).setState(ManagedState.STOPPED);
    verify(concurrentManaged, times(1)).release();
    assertSame(result, stopFuture);
}
}