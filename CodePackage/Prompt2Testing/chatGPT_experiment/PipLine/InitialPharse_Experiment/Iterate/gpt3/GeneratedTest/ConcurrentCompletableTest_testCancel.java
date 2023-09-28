package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testCancel
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentCompletableTest_testCancel {
    @Mock
    private Caller caller;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private ConcurrentCompletable completable;
    @Before
    public void setUp() {
        completable = new ConcurrentCompletable(caller);
    }
    @Test
    public void cancel_shouldReturnTrueAndSetStateToCancelledAndResultToCancel_whenStateIsPending() {
        completable.state.set(ConcurrentCompletable.PENDING);
        boolean result = completable.cancel();
        assertTrue(result);
        assertEquals(ConcurrentCompletable.CANCELLED, completable.state.get());
        assertEquals(ConcurrentCompletable.CANCEL, completable.result);
    }
    @Test
    public void cancel_shouldReturnFalse_whenStateIsNotPending() {
        completable.state.set(ConcurrentCompletable.CANCELLED);
        boolean result = completable.cancel();
        assertFalse(result);
        assertEquals(ConcurrentCompletable.CANCELLED, completable.state.get());
        assertEquals(null, completable.result);
    }
    @Test
    public void cancel_shouldPostComplete() {
        completable.state.set(ConcurrentCompletable.PENDING);
        doNothing().when(completable).postComplete();
        completable.cancel();
        verify(completable, times(1)).postComplete();
    }
}