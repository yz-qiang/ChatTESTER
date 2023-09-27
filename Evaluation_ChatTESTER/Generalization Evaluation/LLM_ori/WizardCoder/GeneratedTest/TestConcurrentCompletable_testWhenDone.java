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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testWhenDone
public 
class TestConcurrentCompletable_testWhenDone extends BaseTestCase{
    @Test
    void should_call_whenDone() throws Exception {
        Consumer consumer1 = mock(Consumer.class),
                consumer2 = mock(Consumer.class);
        Function function = () -> "result";
        doAnswer((invoc)-> invoc.<Runnable>getArguments()[0].run()).when(consumer1).accept(any());
        doAnswer((invoc)-> invoc.<Runnable>getArguments()[0].run()).when(consumer2).accept(any());
       ConcurrentCompletable completable = spy(new ConcurrentCompletable(()->{},null){});
        InOrder orderVerifier= inOrder(completable,"callback");
        completable
           .whenDone(()-> System.out.println("done"))
           .thenApplyAsync(value-> value + "_async")
           .exceptionally(ex-> ex.getMessage())
            ;
        verifyZeroInteractions(completable);
        completable.run();
        Thread.sleep(50L);  
        assertThatCode(() -> verifyNoMoreInteractions(completable)).doesNotThrowAnyException();  
        argumentCaptureAndAssertion(orderVerifier, completer -> verify(completablerunner).complete(),"done",true );
    }
    private <T> T argumentCaptureAndAssertion(InOrder verifier, Supplier supplier, Object expectedValue, boolean checkNullability )throws InterruptedException{
    	verifier.verify(supplier);
    	 ArgumentCaptor captor = ArgumentCaptor.forClass(Object[].class); 
    	if(!checkNullability ){
	    	assertThat(((Object[])captor.getValue())[0]).isEqualToIgnoringCase(expectedValue);
	    }else{
	        assertFalse(Arrays.asList((((Object[])captor.getValue()))[0],"" ).contains("")) ; 
	    }    	     	    	  
	return ((T)(captor.getAllValues().stream().findFirst().orElseGet(() -> Arrays.asList("", "").toArray()))); 
    }
}