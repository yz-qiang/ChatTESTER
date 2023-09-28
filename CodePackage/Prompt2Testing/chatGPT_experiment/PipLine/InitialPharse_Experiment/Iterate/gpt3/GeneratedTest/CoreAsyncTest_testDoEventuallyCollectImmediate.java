package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoEventuallyCollectImmediate
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;
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
@RunWith(MockitoJUnitRunner.class)
public class CoreAsyncTest_testDoEventuallyCollectImmediate {
    @Mock
    private ExecutorService executorService;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private CoreAsync coreAsync;
    @Before
    public void setUp() {
        coreAsync = CoreAsync.builder().executor(executorService).build();
    }
    @Test
    public void testDoEventuallyCollectImmediate() throws Exception {
        Callable<Stage<String>> callable1 = () -> coreAsync.completed("result1");
        Callable<Stage<String>> callable2 = () -> coreAsync.completed("result2");
        Collection<Callable<? extends Stage<? extends String>>> callables = ImmutableList.of(callable1, callable2);
        Consumer<String> consumer = s -> assertNotNull(s);
        Supplier<List<String>> supplier = ArrayList::new;
        Stage<List<String>> stage = coreAsync.eventuallyCollect(callables, consumer, supplier, 2);
        assertNotNull(stage);
        assertTrue(stage.toCompletableFuture().isDone());
        assertEquals(2, stage.toCompletableFuture().get().size());
        assertEquals("result1", stage.toCompletableFuture().get().get(0));
        assertEquals("result2", stage.toCompletableFuture().get().get(1));
    }
}