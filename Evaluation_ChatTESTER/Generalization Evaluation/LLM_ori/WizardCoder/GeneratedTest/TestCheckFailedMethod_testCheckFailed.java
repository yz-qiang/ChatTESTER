package eu.toolchain.concurrent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CollectHelperTest###testCheckFailed
@RunWith(MockitoJUnitRunner.class) 
public final class TestCheckFailedMethod_testCheckFailed {
    private List<Stage<?>> stages;
    @Mock 
    public Iterator iterator;
    @Before  
    public void setUp(){
        stages= ImmutableList.<Stage<?>>of(new Mock(), new Mock()); 
        when(stages.iterator()).thenReturn(this.iterator);   
    }
  @Test
  public void should_CancelAllSourcesWhenCalledOnceAndFailTheTargetWithExceptionMessage() throws Exception{ 
      doThrow(IllegalStateException::new).when((Completable)(stages)).completeExceptionally(anyString());
      try {
          collect().checkFailed();
           failBecauseExceptionWasNotThrown(IllegalStateException.class);
      } catch (AssertionError e){
         assertThat(((Throwable)e.getCause())).hasMessageContainingIgnoringCase("cancelled by downstream failure."); 
         verify(stages,(atLeastOnce())).cancel();         
      }
  }
  protected <U> CollectorBuilderImpl<U> collect() {
      int bufferSize = Integer.MAX_VALUE / 2 + 1;
      return new CollectorBuilderImpl<>(bufferSize, ArrayList::new, stages, spy(Completable.class));
  }
}