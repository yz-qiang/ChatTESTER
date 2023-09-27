package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
import edu.jhu.prim.map.IntIntIntHashMap;
import edu.jhu.prim.map.IntIntIntMap;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testHashCode
public class TestIntIntHashmap_testHashCode {
    private IntIntMap map;
    @Before
    public void setUp(){
        map = new IntIntMap();
    }
    @Test
    public void testHashcodeMethod() {
        assertEquals(0, map.hashCode()); 
        map.put(1,2);
        assertNotEquals(0, map.hashCode()); 
        map.put(5,6);
        assertNotEquals(0, map.hashCode()); 
        map.remove(1);
        assertNotEquals(0, map.hashCode()); 
        map.clear();
        assertEquals(0, map.hashCode()); 
    }
}