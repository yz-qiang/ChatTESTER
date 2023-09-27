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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CoreAsyncTest###testDoEventuallyCollectImmediate
public class TTT_testDoEventuallyCollectImmediate {
@Test
public void testDoEventuallyCollectImmediate() throws Exception {
    ExecutorService executor = mock(ExecutorService.class);
    when(executor.submit((Runnable) any())).thenReturn(null);
    when(executor.invokeAll((Collection<Callable>) any(), eq(10), eq(TimeUnit.SECONDS))).thenReturn(new Future[] {});
    List<Callable<String>> callables = ImmutableList.<Callable<String>>builder().add(() -> "Hello").add(() -> "World").build();
    Consumer<String> consumer = s -> System.out.println("Received string: " + s);
    Supplier<Integer> supplier = () -> 42;
    Stage<Integer> result = CoreAsync.doEventuallyCollectImmediate(callables, consumer, supplier);
    verify(executor, times(2)).submit((Runnable) any());
    verify(executor, never()).invokeAll((Collection<Callable>) any(), eq(10), eq(TimeUnit.SECONDS));
    assertThat(result.get(), equalTo(supplier.get()));
}
}