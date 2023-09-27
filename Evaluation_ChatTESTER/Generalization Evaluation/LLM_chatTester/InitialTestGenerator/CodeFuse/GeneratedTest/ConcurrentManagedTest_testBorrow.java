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
@RunWith(MockitoJUnitRunner.class)
public class ConcurrentManagedTest_testBorrow {
    @Mock
    private Caller mockCaller;
    @Mock
    private Supplier<Stage<String>> mockSetup;
    @Mock
    private Completable<Void> mockStartFuture;
    @Mock
    private Completable<Void> mockZeroLeaseFuture;
    @Mock
    private Completable<String> mockStopReferenceFuture;
    @Mock
    private Stage<Void> mockStopFuture;
    @InjectMocks
    private ConcurrentManaged concurrentManaged;
    @Before
    public void setUp(){
         MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testBorrowWhenReferenceIsNotNull() throws Exception{
        String expectedValue = "test";
        doReturn("test").when(mockSetup).get();
        when(mockZeroLeaseFuture.join()).thenReturn(null);
        when(mockStopReferenceFuture.join()).thenReturn(expectedValue);
        when(mockStopFuture.join()).thenReturn(null);
        Borrowed<String> result = concurrentManaged.borrow();
        assertNotNull(result);
        assertEquals(expectedValue, result.getValue());
    }
    @Test
    public void testBorrowWhenReferenceIsNull() throws Exception{
        doReturn(null).when(mockSetup).get();
        when(mockZeroLeaseFuture.join()).thenReturn(null);
        when(mockStopReferenceFuture.join()).thenReturn(null);
        when(mockStopFuture.join()).thenReturn(null);
        Borrowed<String> result = concurrentManaged.borrow();
        assertNull(result);
    }
    @Test
    public void testBorrowWhenTracingEnabled() throws Exception{
        String expectedValue = "test";
        doReturn(expectedValue).when(mockSetup).get();
        when(mockZeroLeaseFuture.join()).thenReturn(null);
        when(mockStopReferenceFuture.join()).thenReturn(expectedValue);
        when(mockStopFuture.join()).thenReturn(null);
        when(mockCaller.isTracing()).thenReturn(true);
        Borrowed<String> result = concurrentManaged.borrow();
        assertNotNull(result);
        assertEquals(expectedValue, result.getValue());
        verify(concurrencyManager, times(1)).retain();
        verify(concurrencyManager, never()).release();
        verify(concurrencyManager, times(1)).getStackTrace();
    }
    @Test
    public void testBorrowWhenTracingDisabled() throws Exception{
        String expectedValue = "test";
        doReturn(expectedValue).when(mockSetup).get();
        when(mockZeroLeaseFuture.join()).thenReturn(null);
        when(mockStopReferenceFuture.join()).thenReturn(expectedValue);
        when(mockStopFuture.join()).thenReturn(null);
        when(mockCaller.isTracing()).thenReturn(false);
        Borrowed<String> result = concurrentManaged.borrow();
        assertNotNull(result);
        assertEquals(expectedValue, result.getValue());
        verify(concurrencyManager, times(0)).retain();
        verify(concurrencyManager, times(0)).release();
        verify(concurrencyManager, times(0)).getStackTrace();
    }
}