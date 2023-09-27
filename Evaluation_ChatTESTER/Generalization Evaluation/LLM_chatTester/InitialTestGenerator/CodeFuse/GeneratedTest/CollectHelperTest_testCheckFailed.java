package eu.toolchain.concurrent;
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
// original test path: udoprog_tiny-async-java###udoprog_tiny-async-java/tiny-async-core/src/test/java/eu/toolchain/concurrent/CollectHelperTest###testCheckFailed
@RunWith(MockitoJUnitRunner.class)
public class CollectHelperTest_testCheckFailed {
    @Mock private Stage mockStage1;
    @Mock private Stage mockStage2;
    @Mock private Stage mockStage3;
    @Mock private Completable completableTarget;
    private List<Stage<?>> stageList;
    private CollectHelper helper;
    @Before
    public void setUp(){
        stageList = ImmutableList.of(mockStage1, mockStage2, mockStage3);
        helper = spy(new CollectHelper(stageList.size(), any(Function.class), stageList, completableTarget));
    }
    @Test
    public void testCheckFailed() throws Exception{
        doReturn(true).when(helper).failed.getAndSet(true);
        doNothing().when(mockStage1).cancel();
        doNothing().when(mockStage2).cancel();
        doNothing().when(mockStage3).cancel();
        helper.checkFailed();
        verify(mockStage1, times(1)).cancel();
        verify(mockStage2, times(1)).cancel();
        verify(mockStage3, times(1)).cancel();
        assertNull(helper.sources);
    }
}