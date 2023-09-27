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
public void testCheckFailed_whenFailedFlagIsTrue_cancelsAllActiveStages() throws Exception {
    int size = 10;
    List<Stage<?>> sources = mock(List.class);
    when(sources.iterator()).thenReturn(new Iterator<Stage<?>>() {
        @Override
        public boolean hasNext() {
            return count < size;
        }
        @Override
        public Stage<?> next() {
            count++;
            return mock(Stage.class);
        }
    });
    doNothing().when(sources).cancel();
    CollectHelper helper = spy(new CollectHelper(size, null, sources));
    helper.setFailed(true);
    helper.checkFailed();
    verify(helper, times(size)).cancel();
}
}