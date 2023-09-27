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
public class TTT_testWhenDone {
@Test
public void testWhenDone() throws Exception {
    Caller caller = Mockito.mock(Caller.class);
    Runnable finishable = Mockito.mock(Runnable.class);
    ArgumentCaptor<Runnable> argumentCaptor = ArgumentCaptor.forClass(Runnable.class);
    ConcurrentCompletable completable = new ConcurrentCompletable(caller);
    assertTrue(completable.add(finishable));
    verify(caller).execute(argumentCaptor.capture());
    assertEquals(finishable, argumentCaptor.getValue());
    assertTrue(completable.add(finishable));
    verify(caller, times(2)).execute(argumentCaptor.capture());
    assertEquals(finishable, argumentCaptor.getValue());
}
}