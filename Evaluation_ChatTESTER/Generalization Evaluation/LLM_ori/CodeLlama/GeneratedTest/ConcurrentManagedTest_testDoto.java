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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testDoto
public class ConcurrentManagedTest_testDoto {
    @Test
    public void testDoto() throws Exception {
        Caller caller = mock(Caller.class);
        ManagedOptions options = mock(ManagedOptions.class);
        when(options.isCaptureStack()).thenReturn(true);
        when(options.isTracing()).thenReturn(false);
        Supplier<? extends Stage<String>> setup = () -> new ImmediateSuccess<>("hello");
        Completable<Void> startFuture = new Completable<>();
        Completable<Void> zeroLeaseFuture = new Completable<>();
        Completable<String> stopReferenceFuture = new Completable<>();
        Stage<Void> stopFuture = new ImmediateSuccess<>(null);
        ConcurrentManaged managed = new ConcurrentManaged(caller, options, setup, startFuture, zeroLeaseFuture, stopReferenceFuture, stopFuture);
        Function<String, Stage<Integer>> function = s -> new ImmediateSuccess<>(10);
        Stage<Integer> result = managed.doto(function);
        assertTrue(result instanceof ImmediateSuccess);
        assertEquals((int) ((ImmediateSuccess<Integer>) result).getValue(), 10);
        function = s -> new ImmediateFailed<>(caller, new RuntimeException("error"));
        result = managed.doto(function);
        assertTrue(result instanceof ImmediateFailed);
        assertEquals(((ImmediateFailed<Integer>) result).getCause().getMessage(), "error");
        function = s -> new CancelledStage<>(caller);
        result = managed.doto(function);
        assertTrue(result instanceof CancelledStage);
    }
}