package eu.toolchain.concurrent;
import static eu.toolchain.concurrent.CoreAsync.buildCollectedException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoCollect
@RunWith(MockitoJUnitRunner.class) 
public class TestDoCollectMethod_testDoCollect {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private ExecutorService executor; 
    private List<Stage<String>> inputStages; 
    @Before  
    public void setUp() throws Exception{
        this.executor = spy(Executors.newFixedThreadPool(2)); 
        when(this.executor.<Void>submit((Runnable) any())).thenAnswer(new Answer<Future>() {
            int count=0; 
            @Override
            public Future answer(InvocationOnMock invocation) throws Throwable {
                if (++count ==1){
                    throw buildCollectedException("Error submitting stage"); 
                } else {
                   return null;   
                }                
            };            
        });
        String[] inputs={"inputA", "inputB"};        
        ArrayList<Stage<String>> listInputStgages = Lists.newArrayListWithCapacity(inputs.length);         
        for (int i = 0 ;i<inputs.length;++i ){
           listInputStgages.add(createStubbedStage());           
        }       
       Collections.shuffle(listInputStgages);
       this.inputStages = ImmutableList.copyOf(listInputStgages);    
    }
  protected Stage createStubbedStage(){
      Callable<Object> callableResult = () -> Thread.currentThread().getName()+"_output"; 
      Supplier<Boolean> supplierIsDone =()-> true;
      Consumer consumerHandleSuccess=(result)->{};          
      Runnable runnableHandleFailure=()->{};             
      Stage result = mock(Stage.class);              
      when(result.isReady()).thenReturn(supplierIsDone.get());               
      when(result.getOutputOrWait(() -> {})).thenReturn("");                   
      when(result.handle((Consumer<Object>) any()))
         .thenCallRealMethod()
         .thenAnswer((Answer<Void>) invocation -> {
              Object arg = ((Consumer[]) invocation.getArguments())[0].accept(callableResult.call());                  
              verify(consumerHandleSuccess).accept(arg);                    
              return null;} );                 
      when(result.handleError(runnableHandleFailure))
         .thenCallRealMethod()
         .thenRun(runnableHandleFailure::run);                     
      return result; 
  }
  @Test
  public void shouldPropagateSubmissionExceptionsUntilFirstSuccessfulExecutionOrAllFailedAttemptsAreExhausted() throws InterruptedException{
      try{
         coreAsyncInstanceToTest.doCollect(this.inputStages,(collectionOfOutputs)->"combinedOutput").awaitCompletion(); 
         failBecauseExceptionWasNotThrown(ExecutionException.class); 
      } catch (ExecutionException e){
         assertThat(((CombinedCollectorExceptionHandler)e.getCause()).getMessage())
            .containsIgnoringCase("error")
            .containsIgnoringCase("submission")
            .containsIgnoringCase("stage"); 
      } finally {
         shutdownExecutorAndAwaitTerminationIfNecessary(); 
      }
  }
  private synchronized void shutdownExecutorAndAwaitTerminationIfNecessary() throws InterruptedException{
      boolean terminatedSuccessfully = false; 
      while(!terminatedSuccessfully &&!Thread.interrupted()){
          try{
              TimeUnit.SECONDS.sleep(5); 
              terminatedSuccessfully = this.executor.shutdownNow().isEmpty(); 
          }catch(InterruptedException ignore){}
      }
  }
}