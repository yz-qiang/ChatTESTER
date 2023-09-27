package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testEquals
public class LongDoubleHashMapEqualsTest_testEquals {
    private LongDoubleHashMap map1;
    private LongDoubleHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new LongDoubleHashMap();
        map1.put(1L, 1.5D);
        map1.put(2L, 2.5D);
        map1.put(3L, 3.5D);
        map2 = new LongDoubleHashMap();
        map2.put(4L, 4.5D);
        map2.put(5L, 5.5D);
        map2.put(6L, 6.5D);
    }
    @Test
    public void testEqualMaps() {
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentContents() {
        map2.put(7L, 7.5D);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentSizes() {
        map2.remove(6L);
        assertFalse(map1.equals(map2));
    }
}