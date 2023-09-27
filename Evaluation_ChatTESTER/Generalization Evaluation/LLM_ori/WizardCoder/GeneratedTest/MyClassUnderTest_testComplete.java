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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testComplete
public 
class MyClassUnderTest_testComplete extends ConcurrentCompletable<String> {} 
@RunWith(MockitoJUnitRunner.class) 
public class TestMyClassUnderTest_testComplete {
    @Mock
    private Consumer<? super String> callbackA;
    @Mock 
    private Function<? super Integer, Boolean> conditionB;
   @InjectMocks 
   private MyClassUnderTest_testComplete myObjectToTest = new MyClassUnderTest_testComplete() {};  
  @Test
  public void should_setInternalVariablesCorrectlyWhenSuccess(){
      assertThatCode(() ->{
          doCallRealMethod().when(myObjectToTest).postComplete();
          assertTrue("Should be able to set value",
                  myObjectToTest.complete("value"));
              verifyNoMoreInteractionsWithMocks();
       }).doesNotThrowAnyException();
       assertEquals("", "value"); 
       assertFalse("" + myObjectToTest.isCancelled(), 
                myObjectToTest.isCancelled());
       assertCallbacksAreCalledOnceAndOnlyOnce();       
  }
  protected InOrder getOrderedCallsForCallbackList() throws Exception { 
      ArgumentCaptor captor = ArgumentCaptor.forClass((Class)Runnable[].class);      
      verify(callbackA).accept(captor.capture());     
      List listCapturedValues= Arrays.asList(((Runnable[])captor.getValue()));   
      Collections.reverse(listCapturedValues);
      return inOrder(listCapturedValues.toArray());        
  }
  protected void assertCallbacksAreCalledOnceAndOnlyOnce()throws Exception{
      try{
         getOrderedCallsForCallbackList().verifyAll();
      }catch(WantedButNotInvoked e){ 
         fail("Some Callback was not invoked at least once.");          
      } catch(VerificationInOrderFailure f){           
            throw new AssertionError((""
                    +" Some Callback was called more than expected or some call didnt happen."+f), f);            
      }finally{             
          reset(callbackA);              
      }               
  }
}