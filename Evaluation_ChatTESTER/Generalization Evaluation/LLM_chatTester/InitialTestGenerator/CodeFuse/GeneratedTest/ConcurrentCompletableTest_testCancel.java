package eu.toolchain.concurrent;
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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testCancel
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentCompletableTest_testCancel {
    @Mock private Caller mockCaller;
    @InjectMocks private ConcurrentCompletable concurrentCompletable;
    @Spy private CompletionStage completionStage;
    @Rule public ExpectedException exception = ExpectedException.none();
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(completionStage.getState()).thenReturn(ConcurrentCompletable.PENDING);
    }
    @Test
    public void shouldCancelTaskWhenNotAlreadyCompletedOrCanceled() throws Exception{
        doReturn("testResult").when(completionStage).complete(any());
        assertTrue(concurrentCompletable.cancel());
        verify(completionStage, times(1)).setState(ConcurrentCompletable.CANCELLED);
        verify(completionStage, never()).postComplete();
    }
    @Test
    public void shouldFailToCancelIfAlreadyCompleted() throws Exception{
        when(completionStage.getState()).thenReturn(ConcurrentCompletable.COMPLETED);
        assertFalse(concurrentCompletable.cancel());
        verify(completionStage, never()).setState(ConcurrentCompletable.CANCELLED);
        verify(completionStage, never()).postComplete();
    }
    @Test
    public void shouldPostCompleteAfterCancelling() throws Exception{
        doNothing().when(completionStage).postComplete();
        doReturn(true).when(completionStage).cancel();
        concurrentCompletable.cancel();
        verify(completionStage, times(1)).postComplete();
    }
    @Test
    public void shouldNotifyCallbacksOfCompletion() throws Exception{
        Consumer<Object> consumer = mock(Consumer.class);
        Supplier<Boolean> supplier = mock(Supplyier.class);
        Function<Object, Boolean> function = mock(Function.class);
        concurrentCompletable.addListener(consumer);
        concurrentCompletable.addListener(supplier);
        concurrentCompletable.addListener(function);
        concurrentCompletable.cancel();
        InOrder inOrder = inOrder(consumer, supplier, function);
        inOrder.verify(consumer).accept(any());
        inOrder.verify(supplier).apply(any());
        inOrder.verify(function).apply(any());
    }
    @Test
    public void shouldPropagateExceptionFromRunnable() throws Exception{
        RuntimeException expectedException = new RuntimeException("expected");
        doThrow(expectedException).when(completionStage).execute();
        try {
            concurrentCompletable.cancel();
            fail("Should have thrown exception");
        } catch (RuntimeException e){
            assertThat(e, is(expectedException));
        }
    }
}