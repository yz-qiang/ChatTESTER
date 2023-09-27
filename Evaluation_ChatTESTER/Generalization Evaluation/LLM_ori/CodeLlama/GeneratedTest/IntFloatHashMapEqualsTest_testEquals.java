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
        map1.put(1, 1f);
        map1.put(2, 2f);
        map1.put(3, 3f);
        map2 = new IntFloatHashMap();
        map2.put(4, 4f);
        map2.put(5, 5f);
        map2.put(6, 6f);
    }
    @Test
    public void testEqualMaps() {
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentKeys() {
        map2.remove(4);
        map2.put(7, 7f);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalMapsDifferentValues() {
        map2.put(4, 8f);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testNullMap() {
        assertFalse(map1.equals(null));
    }
}