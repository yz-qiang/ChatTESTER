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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentManagedTest###testBorrow
public class ConcurrentManagedTest_testBorrow {
    @Test
    public void testBorrow() throws Exception {
        Caller caller = mock(Caller.class);
        ManagedOptions options = mock(ManagedOptions.class);
        Supplier supplier = mock(Supplier.class);
        Completable completable = mock(Completable.class);
        Stage stage = mock(Stage.class);
        StackTraceElement[] stackTraceElements = new StackTraceElement[]{};
        ConcurrentManaged concurrentManaged = new ConcurrentManaged(caller, options, supplier, completable, completable, completable, stage);
        when(supplier.get()).thenReturn(stage);
        doReturn(stackTraceElements).when(options).getStackTrace();
        doReturn(true).when(completable).complete();
        doReturn(false).when(completable).cancelled();
        doReturn(null).when(completable).exception();
        Borrowed<String> result = concurrentManaged.borrow();
        verify(supplier).get();
        verify(options).getStackTrace();
        verify(completable).complete();
        verify(completable).cancelled();
        verify(completable).exception();
        assertEquals("expectedValue", result.getValue());
        assertEquals(1, result.getTraces().size());
        assertEquals(stackTraceElements, result.getTraces().get(0));
    }
}