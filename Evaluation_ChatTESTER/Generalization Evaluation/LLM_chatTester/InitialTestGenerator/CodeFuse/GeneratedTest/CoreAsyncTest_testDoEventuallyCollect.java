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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoEventuallyCollect
@RunWith(MockitoJUnitRunner.class)
public class CoreAsyncTest_testDoEventuallyCollect {
    @Mock
    private ExecutorService mockExecutor;
    @Mock
    private Caller mockCaller;
    @InjectMocks
    @Spy
    private CoreAsync coreAsync;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testDoEventuallyCollect() throws InterruptedException {
        List<Callable<Stage<String>> taskList = new ArrayList<>();
        taskList.add(() -> {return new Stage<>("Task1");});
        taskList.add(() -> {throw new RuntimeException("Error occurred while executing Task2")});
        taskList.add(() -> {return new Stage<>("Task3");});
        Supplier<Integer> supplier = () -> Integer::valueOf;
        int parallelism = 5;
        InOrder order = inOrder(mockExecutor, mockCaller);
        Future future1 = mock(Future.class);
        Future future2 = mock(Future.class);
        Future future3 = mock(Future.class);
        when(mockExecutor.submit(any()).thenReturn(future1, future2, future3);
        ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
        doNothing().when(mockExecutor).execute(runnableCaptor.capture());
        Runnable capturedRunnable = runnableCaptor.getValue();
        capturedRunnable.run();
        verify(mockExecutor, times(taskList.size())).submit(any());
        assertEquals(parallelism, taskList.size(), "Number of submitted tasks should match parallelism value.");
        verify(mockExecutor, times(taskList.size())).submit(any());
        verify(mockCaller, times(1)).execute(any());
        verify(consumer, times(taskList.size())).accept(any());
        verify(supplier, times(1)).get();
        assertTrue(stage.isDone());
    }
}