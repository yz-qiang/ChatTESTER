package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testEquals
public class TestIntLongHashMap_testEquals {
    private IntLongHashMap map1;
    private IntLongHashMap map2;
    @Before
    public void setUp(){
        map1 = new IntLongHashMap();
        map1.put(1, 5L);
        map1.put(3, 7L);
        map1.put(4, 9L);
        map1.put(6, 8L);
        map2 = new IntLongHashMap();
        map2.put(1, 5L);
        map2.put(3, 7L);
        map2.put(4, 9L);
        map2.put(6, 8L);
    }
    @Test
    public void testEqualsMethod() {
        assertTrue(map1.equals(map2));
    }
}