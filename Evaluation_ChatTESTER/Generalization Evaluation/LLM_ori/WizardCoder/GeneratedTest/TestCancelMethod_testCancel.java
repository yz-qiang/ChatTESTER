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
public 
class TestCancelMethod_testCancel extends AbstractTestSupport{
    @Test
    public void when_cancelCalledAndNotPendingStateThenFalseIsReturned(){
        Completable completableSpy = spy(createDefaultCompletable());
        doReturn(-1).when(completableSpy).getState();
        assertThat(completableSpy.cancel()).isFalse();
    }
    private Completable createDefaultCompletable(){
        return mock(Completable.class); 
    }
}
interface Completable<T> {
  default T getResultOrBlockUntilSet() throws InterruptedException {
      throw new UnsupportedOperationException("not implemented"); 
  };
  int getState();
  boolean cancel();
};  
abstract class AbstractTestSupport implements AutoCloseable {}