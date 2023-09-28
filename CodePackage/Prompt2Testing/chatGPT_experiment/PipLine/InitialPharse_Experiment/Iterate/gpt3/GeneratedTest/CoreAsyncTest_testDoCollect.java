package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoCollect
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
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
@RunWith(MockitoJUnitRunner.class)
public class CoreAsyncTest_testDoCollect {
    @Mock
    private Stage<String> stage1;
    @Mock
    private Stage<Integer> stage2;
    @Mock
    private Function<Collection<Object>, String> collector;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private CoreAsync coreAsync;
    @Before
    public void setUp() {
        coreAsync = CoreAsync.builder().build(); 
    }
    @Test
    public void testDoCollect() throws Exception {
        final List<Stage<? extends Object>> stages = ImmutableList.of(stage1, stage2);
        final String expectedResult = "result";
        final Collection<Object> collectedResults = new ArrayList<>();
        collectedResults.add("stringResult");
        collectedResults.add(123);
        when(collector.apply(anyCollection())).thenReturn(expectedResult);
        final Completable<String> completable = coreAsync.<String, String>doCollect(stages, collector::apply);
        verify(stage1).handle(any());
        verify(stage2).handle(any());
        final InOrder inOrder = inOrder(stage1, stage2, collector);
        final CollectHelper<Object, String> collectHelper = new CollectHelper<>(2, collector, stages, completable);
        collectHelper.completed(0, "stringResult");
        inOrder.verify(collector, never()).apply(anyCollection());
        inOrder.verify(stage2).handle(eq(collectHelper));
        collectHelper.completed(1, 123);
        inOrder.verify(collector).apply(collectedResults);
        assertEquals(expectedResult, completable.get());
    }
}