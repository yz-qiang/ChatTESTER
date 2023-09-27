package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest###testRemove
public class TTT_testRemove {
@Test
public void testRemove() {
    LongDoubleSortedMap map = new LongDoubleSortedMap(new long[]{1L, 3L}, new double[]{4.5D, 6.7D});
    assertTrue(map.containsKey(1L));
    map.remove(1L);
    assertFalse(map.containsKey(1L));
    try {
        map.remove(2L);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
    map = new LongDoubleSortedMap();
    try {
        map.remove(1L);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}