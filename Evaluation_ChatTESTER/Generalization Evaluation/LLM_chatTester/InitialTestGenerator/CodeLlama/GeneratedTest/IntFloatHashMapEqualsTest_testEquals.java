package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testEquals
public class IntFloatHashMapEqualsTest_testEquals {
    private IntFloatHashMap map1;
    private IntFloatHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new IntFloatHashMap();
        map2 = new IntFloatHashMap();
    }
    @Test
    public void testEqualMapsWithDifferentOrdering() {
        map1.put(1, 1f);
        map1.put(2, 2f);
        map1.put(3, 3f);
        map2.put(3, 3f);
        map2.put(2, 2f);
        map2.put(1, 1f);
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentKeys() {
        map1.put(1, 1f);
        map1.put(2, 2f);
        map1.put(4, 4f);
        map2.put(3, 3f);
        map2.put(2, 2f);
        map2.put(5, 5f);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsWithDifferentValues() {
        map1.put(1, 1f);
        map1.put(2, 2f);
        map1.put(3, 3f);
        map2.put(1, 1f);
        map2.put(2, 2f);
        map2.put(3, 6f);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testNullMapComparison() {
        assertNotNull(map1);
        assertFalse(map1.equals(null));
    }
    @Test
    public void testNonHashableKeyComparison() {
        try {
            map1.put(new Object(), 1f);
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
        }
    }
}