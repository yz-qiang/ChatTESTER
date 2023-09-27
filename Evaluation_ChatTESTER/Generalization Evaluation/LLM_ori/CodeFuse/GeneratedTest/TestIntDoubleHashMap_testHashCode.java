package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testHashCode
public class TestIntDoubleHashMap_testHashCode {
    private IntDoubleHashMap map;
    @Before
    public void setUp(){
          map = new IntDoubleHashMap();
    }
    @Test
    public void testHashCodeWithEmptyMap() {
        assertEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithOneEntry() {
        map.put(1,2.5);
        assertNotEquals(0,map.hashCode());
    }
    @Test
    public void testHashCodeWithMultipleEntries() {
        map.put(1,2.5);
        map.put(2,4.8);
        map.put(3,-6.9);
        assertNotEquals(0,map.hashCode());
    }
    @Test
    public void testHashCodeWithDifferentOrdering() {
        map.put(1,2.5);
        map.put(2,4.8);
        map.put(3,-6.9);
        map.put(2,4.8);
        map.put(1,2.5);
        assertEquals(map.hashCode(), map.hashCode());
    }
}