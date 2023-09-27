package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.BeforeClass;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testHashCode
public class IntDoubleHashMapTest_testHashCode {
    private static IntDoubleHashMap map;
    @BeforeClass
    public void setUp() throws Exception {
        map = new IntDoubleHashMap();
        map.put(1, 2.5);
        map.put(2, 4.6);
        map.put(3, 8.9);
    }
    @Test
    public void testHashCode() {
        int actual = map.hashCode();
        int expected = 17 + 37 * (1 ^ 2) + 37 * (2 ^ 4) + 37 * (3 ^ 8);
        assertEquals(expected, actual);
    }
}