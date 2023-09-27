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
    LongDoubleSortedMap map = new LongDoubleSortedMap();
    map.put(1L, 1.5D);
    map.put(3L, 3.7D);
    map.put(4L, 4.8D);
    map.put(6L, 6.9D);
    map.remove(3L);
    assertEquals(map.size(), 3);
    assertEquals(map.get(1L), 1.5D);
    assertEquals(map.get(4L), 4.8D);
    assertEquals(map.get(6L), 6.9D);
    try {
        map.remove(10L);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}