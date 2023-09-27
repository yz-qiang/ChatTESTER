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
public class TTT_testCheckFailed {
@Test
public void testCheckFailed() throws Exception {
    List<Stage<?>> sources = ImmutableList.of(mock(Stage.class), mock(Stage.class));
    Completable<? super U> target = mock(Completable.class);
    CollectHelper helper = spy(new CollectHelper(2, null, sources, target));
    doReturn(true).when(helper).isDone();
    doNothing().when(sources.get(0)).cancel();
    doNothing().when(sources.get(1)).cancel();
    helper.checkFailed();
    verify(sources.get(0), times(1)).cancel();
    verify(sources.get(1), times(1)).cancel();
    assertTrue(helper.isDone());
}
}