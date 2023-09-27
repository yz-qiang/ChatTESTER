package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testHashCode
public class IntIntHashMapTest_testHashCode {
    private IntIntHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntIntHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(0, map.hashCode());
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        int expectedHashCode = 17;
        for (int i : map.getKeys()) {
            expectedHashCode = 37 * expectedHashCode + Primitives.hashOfInt(i);
        }
        assertEquals(expectedHashCode, map.hashCode());
    }
}