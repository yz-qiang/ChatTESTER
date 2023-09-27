package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testHashCode
public class IntFloatHashMapTest_testHashCode {
    private IntFloatHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntFloatHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(0, map.hashCode());
        map.put(1, 2f);
        map.put(2, 4f);
        map.put(3, 6f);
        int expectedHashCode = 17;
        for (int i = 0; i < map.getKeys().length; i++) {
            int key = map.getKeys()[i];
            float value = map.getValue(key);
            expectedHashCode = 37 * expectedHashCode + Primitives.hashOfInt(key);
            expectedHashCode = 37 * expectedHashCode + Primitives.hashOfFloat(value);
        }
        assertEquals(expectedHashCode, map.hashCode());
    }
}