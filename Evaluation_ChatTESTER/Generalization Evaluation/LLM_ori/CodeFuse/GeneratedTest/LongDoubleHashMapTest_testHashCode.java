package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testHashCode
public class LongDoubleHashMapTest_testHashCode {
    private LongDoubleHashMap map;
    @Before
    public void setUp(){
        map = new LongDoubleHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(0, map.hashCode());
        map.put(1L, 2.5);
        map.put(2L, 4.8);
        map.put(3L, 6.9);
        assertNotEquals(0, map.hashCode());
    }
}