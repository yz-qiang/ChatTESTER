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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/ConcurrentCompletableTest###testComplete
@RunWith(PowerMockRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConcurrentCompletable_testComplete {
    @Mock
    private Supplier<Object> supplier;
    @InjectMocks
    private ConcurrentCompletable completableUnderTest;
    @Before
    public void setUp() {
        when(supplier.get()).thenReturn("Hello");
        doAnswer((invocationOnMock -> {
            ((Runnable) invocationOnMock.getArguments()[0]).run();
            return VoidTypeWrapper.VOID;
        })).when(completableFuture).postComplete();
    }
    @Test
    public void shouldSetCompletionStatusAndStoreResultWhenCompletedSuccessfully() throws Exception {
        assertTrue(completableUnderTest.isPending());
        assertFalse(completableUnderTest.isDone());
        completableUnderTest.completeWith(() -> "World!");
        verifyZeroInteractions(supplier);
        assertEquals("\"World!\"", String.valueOf(completableUnderTest.blockingGet()));
        assertNotEquals("", String.valueOf(completableUnderTest.getResultOrErrorIfFailedBlocking()));
        assertThat(completableUnderTest.getState(), equalTo(COMPLETED));
        assertTrue(completableUnderTest.isDone());
        assertFalse(completableUnderTest.isCancelled());
        verifyNoMoreInteractions(completableFuture);
    }
}