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
public class TTT_testBorrow {
@Test
public void testBorrow() throws Exception {
    Supplier<Stage<String>> mockSetup = mock(Supplier.class);
    ManagedOptions mockOptions = mock(ManagedOptions.class);
    when(mockSetup.get()).thenReturn(null);
    when(mockOptions.isCaptureStack()).thenReturn(true);
    ConcurrentManaged<String> cm = new ConcurrentManaged<>(null, mockOptions, mockSetup, null, null, null, null);
    assertThat(cm.borrow(), isInvalid());
    String expectedValue = "test";
    cm.reference.set(expectedValue);
    Borrowed<String> actualBorrowed = cm.borrow();
    assertThat(actualBorrowed, isValid());
    assertThat(actualBorrowed.getValue(), equalTo(expectedValue));
    StackTraceElement[] expectedStackTrace = Thread.currentThread().getStackTrace();
    assertThat(actualBorrowed.getStackTrace(), arrayContainingInAnyOrder(expectedStackTrace));
}
}