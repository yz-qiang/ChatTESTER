package eu.toolchain.concurrent;
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CollectHelperTest###testCheckFailed
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class CollectHelperTest_testCheckFailed {
    @Mock
    private Stage<?> mockStage;
    @Before
    public void setUp() {
    }
    @Test
    public void testCheckFailed() {
        CollectHelper collectHelper = new CollectHelper(1, null, ImmutableList.of(mockStage), null);
        collectHelper.failed.set(false);
        collectHelper.checkFailed();
        verify(mockStage, times(1)).cancel();
        assertNull(collectHelper.sources);
        assertEquals(true, collectHelper.failed.get());
    }
}