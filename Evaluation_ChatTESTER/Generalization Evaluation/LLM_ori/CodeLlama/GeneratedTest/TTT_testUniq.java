package edu.jhu.prim.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/list/LongArrayListTest###testUniq
public class TTT_testUniq {
@Test
public void testUniq() {
    LongArrayList list = new LongArrayList();
    list.addAll(Arrays.asList(new Long[]{1L, 2L, 3L, 4L, 5L}));
    list.uniq();
    assertEquals(list.size(), 5);
    assertTrue(list.contains(1L));
    assertTrue(list.contains(2L));
    assertFalse(list.contains(3L));
    assertTrue(list.contains(4L));
    assertTrue(list.contains(5L));
}
}