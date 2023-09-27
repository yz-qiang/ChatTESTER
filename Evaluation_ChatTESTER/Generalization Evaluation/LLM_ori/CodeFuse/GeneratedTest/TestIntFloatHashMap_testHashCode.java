package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testHashCode
public class TestIntFloatHashMap_testHashCode {
    private IntFloatHashMap map;
    @Before
    public void setUp(){
          map = new IntFloatHashMap();
    }
    @Test
    public void testHashCodeWithEmptyMap() {
        assertEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithOneEntry() {
        map.put(123456, 98.7f);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithMultipleEntries() {
        map.put(123456, 98.7f);
        map.put(67890, 12.3f);
        map.put(-1234, 56.7f);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithDifferentOrdering() {
        map.put(123456, 98.7f);
        map.put(67890, 12.3f);
        map.put(-1234, 56.7f);
        map.put(67890, 12.3f);
        map.put(123456, 98.7f);
        assertNotEquals(map.hashCode(), map.clone().hashCode());
    }
}