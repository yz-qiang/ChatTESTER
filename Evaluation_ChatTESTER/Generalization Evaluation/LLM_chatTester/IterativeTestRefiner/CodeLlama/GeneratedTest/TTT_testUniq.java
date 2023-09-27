package edu.jhu.prim.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Arrays;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
public class TTT_testUniq {
    @Test
    public void testUniq() {
        LongArrayList list = new LongArrayList();
        list.addAll(Arrays.asList(new Long[]{1L, 2L, 3L, 4L, 5L, 6L}));
        list.addAll(Arrays.asList(new Long[]{1L, 2L, 3L, 4L, 5L, 6L}));
        list.uniq();
        assertEquals(list.size(), 6);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(!list.containsDuplicates());
        }
    }
}