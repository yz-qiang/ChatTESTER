package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testEquals
public class IntDoubleHashMapEqualsTest_testEquals {
    private IntDoubleHashMap map1;
    private IntDoubleHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new IntDoubleHashMap();
        map2 = new IntDoubleHashMap();
    }
    @Test
    public void testEqualMapsWithDifferentOrdering() {
        map1.put(1, 1.5);
        map1.put(3, 4.8);
        map1.put(7, 9.6);
        map2.put(7, 9.6);
        map2.put(3, 4.8);
        map2.put(1, 1.5);
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentKeys() {
        map1.put(1, 1.5);
        map1.put(3, 4.8);
        map1.put(7, 9.6);
        map2.put(7, 9.6);
        map2.put(3, 4.8);
        map2.put(2, 1.5);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentValues() {
        map1.put(1, 1.5);
        map1.put(3, 4.8);
        map1.put(7, 9.6);
        map2.put(7, 9.6);
        map2.put(3, 4.8);
        map2.put(1, 2.5);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testNullMapComparison() {
        assertNotNull(map1);
        assertFalse(map1.equals(null));
    }
    @Test
    public void testSelfEquality() {
        assertTrue(map1.equals(map1));
    }
    @Test
    public void testOtherTypeEquality() {
        Object o = new Object();
        assertFalse(map1.equals(o));
    }
}