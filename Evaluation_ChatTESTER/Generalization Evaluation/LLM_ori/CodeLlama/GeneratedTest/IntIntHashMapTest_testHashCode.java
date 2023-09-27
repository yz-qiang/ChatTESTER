package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testHashCode
public class IntIntHashMapTest_testHashCode {
    private IntIntHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntIntHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(map.hashCode(), 0);
        map.put(1, 2);
        assertEquals(map.hashCode(), 49);
        map.put(2, 3);
        assertEquals(map.hashCode(), 85);
        map.remove(1);
        assertEquals(map.hashCode(), 64);
        try {
            map.get(-1);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }
}