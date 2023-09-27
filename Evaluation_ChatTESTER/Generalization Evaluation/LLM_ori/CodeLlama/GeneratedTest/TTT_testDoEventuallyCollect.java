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
public class TTT_testDoEventuallyCollect {
@Test
public void testDoEventuallyCollect() throws Exception {
    ExecutorService executor = mock(ExecutorService.class);
    Caller caller = mock(Caller.class);
    Completable<String> stage = new Completable<>();
    List<Callable<Stage<Integer>>> tasks = Arrays.asList(
        () -> completedStage(1),
        () -> failedStage(new RuntimeException("Failed")),
        () -> cancelledStage());
    Consumer<Integer> consumer = i -> System.out.println("Received value: " + i);
    Supplier<String> supplier = () -> "Hello";
    int parallelism = 2;
    when(executor.submit((Runnable) any())).thenReturn(null);
    when(caller.get()).thenReturn(stage);
    Stage<String> result = coreAsync.doEventuallyCollect(tasks, consumer, supplier, parallelism);
    verify(executor, times(parallelism)).submit((Runnable) any());
    verify(caller, never()).get();
    assertThat(result, instanceOf(Completable.class));
    assertThat(result.isDone(), equalTo(false));
    assertThat(result.isCancelled(), equalTo(false));
    assertThat(result.isCompletedExceptionally(), equalTo(true));
    assertThat(result.exception().getMessage(), containsString("Failed"));
}
}