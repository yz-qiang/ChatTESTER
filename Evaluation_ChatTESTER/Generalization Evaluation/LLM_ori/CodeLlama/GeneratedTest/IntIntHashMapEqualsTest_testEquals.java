package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testEquals
public class IntIntHashMapEqualsTest_testEquals {
    private IntIntHashMap map1;
    private IntIntHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new IntIntHashMap();
        map1.put(1, 2);
        map1.put(3, 4);
        map1.put(5, 6);
        map2 = new IntIntHashMap();
        map2.put(7, 8);
        map2.put(9, 10);
        map2.put(11, 12);
    }
    @Test
    public void testEqualMaps() {
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentKeys() {
        map2.remove(7);
        map2.put(13, 14);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentValues() {
        map2.put(7, 15);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testNullMap() {
        assertFalse(map1.equals(null));
    }
}