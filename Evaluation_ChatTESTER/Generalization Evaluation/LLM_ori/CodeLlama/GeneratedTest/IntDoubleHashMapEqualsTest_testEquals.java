package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testEquals
public class IntDoubleHashMapEqualsTest_testEquals {
    private IntDoubleHashMap map1;
    private IntDoubleHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new IntDoubleHashMap();
        map1.put(1, 1.5);
        map1.put(2, 2.5);
        map1.put(3, 3.5);
        map2 = new IntDoubleHashMap();
        map2.put(4, 4.5);
        map2.put(5, 5.5);
        map2.put(6, 6.5);
    }
    @Test
    public void testEqualMaps() {
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentKeys() {
        map2.remove(4);
        map2.put(7, 7.5);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentValues() {
        map2.put(4, 4.6);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testNullMap() {
        assertFalse(map1.equals(null));
    }
}