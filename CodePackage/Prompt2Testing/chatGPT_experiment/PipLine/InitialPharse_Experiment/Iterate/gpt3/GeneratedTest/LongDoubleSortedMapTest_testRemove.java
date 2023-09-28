package edu.jhu.prim.map;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest###testRemove
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
public class LongDoubleSortedMapTest_testRemove {
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingKey() {
        LongDoubleSortedMap map = new LongDoubleSortedMap(new long[]{1, 2, 3}, new double[]{1.0, 2.0, 3.0});
        map.remove(4);
    }
    @Test
    public void testRemoveExistingKey() {
        LongDoubleSortedMap map = new LongDoubleSortedMap(new long[]{1, 2, 3}, new double[]{1.0, 2.0, 3.0});
        map.remove(2);
        assertEquals(2, map.size());
        Iterator<Long> iter = map.keySet().iterator();
        assertEquals(1L, (long) iter.next());
        assertEquals(3L, (long) iter.next());
    }
}