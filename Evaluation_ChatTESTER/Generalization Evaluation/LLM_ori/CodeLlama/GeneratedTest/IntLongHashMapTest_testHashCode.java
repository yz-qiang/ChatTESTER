package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
public class IntLongHashMapTest_testHashCode {
    private IntLongHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntLongHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(map.hashCode(), 0);
        map.put(123456789, 987654321);
        assertEquals(map.hashCode(), 123456789 ^ 987654321);
        map.clear();
        assertEquals(map.hashCode(), 0);
        try {
            map.put(-1, Long.MAX_VALUE);
            fail("Expected exception when putting negative key");
        } catch (IllegalArgumentException e) {
        }
        try {
            map.put(Integer.MIN_VALUE, Long.MIN_VALUE);
            fail("Expected exception when putting minimum integer value as key");
        } catch (IllegalArgumentException e) {
        }
        try {
            map.put(Integer.MAX_VALUE, Long.MAX_VALUE);
            fail("Expected exception when putting maximum integer value as key");
        } catch (IllegalArgumentException e) {
        }
    }
}