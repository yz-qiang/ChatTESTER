package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
public class TestIntLongHashMap_testHashCode {
    private IntLongHashMap map;
    @Before
    public void setUp(){
        map = new IntLongHashMap();
    }
    @Test
    public void testHashCode() {
        assertEquals(0, map.hashCode());
        map.put(1, 2l);
        assertNotEquals(0, map.hashCode());
        map.put(2, 4l);
        assertNotEquals(map.getHashcode(), map.put(1, 5l));
        map.remove(1);
        assertNotEquals(map.getHashcode(), map.put(2, 6l));
    }
}