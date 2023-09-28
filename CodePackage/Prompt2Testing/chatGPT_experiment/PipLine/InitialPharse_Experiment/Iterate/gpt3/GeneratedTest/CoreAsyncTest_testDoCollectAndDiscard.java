package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoCollectAndDiscard
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
public class CoreAsyncTest_testDoCollectAndDiscard {
    @Mock
    private Stage<Object> stage1;
    @Mock
    private Stage<Object> stage2;
    @Mock
    private Stage<Object> stage3;
    @Mock
    private Completable<Void> completable;
    @Mock
    private CollectAndDiscardHelper helper;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private CoreAsync coreAsync; 
    @Before
    public void setUp() {
        ExecutorService executor = mock(ExecutorService.class);
        coreAsync = new CoreAsync(executor); 
    }
    @Test
    public void testDoCollectAndDiscard() throws Exception {
        List<Stage<?>> stages = ImmutableList.of(stage1, stage2, stage3);
        when(completable()).thenReturn(completable);
        when(helper.getRemaining()).thenReturn(0);
        coreAsync.collectAndDiscard(stages);
        verify(stage1).handle(helper);
        verify(stage2).handle(helper);
        verify(stage3).handle(helper);
        verify(completable).bind(anyCollection());
    }
}