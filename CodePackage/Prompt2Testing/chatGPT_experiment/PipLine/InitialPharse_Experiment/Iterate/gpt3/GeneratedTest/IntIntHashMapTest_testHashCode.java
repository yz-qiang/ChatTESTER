package edu.jhu.prim.map;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testHashCode
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class IntIntHashMapTest_testHashCode {
    @Test
    public void testHashCode() {
        IntIntHashMap map1 = new IntIntHashMap();
        map1.put(1, 10);
        map1.put(2, 20);
        map1.put(3, 30);
        IntIntHashMap map2 = new IntIntHashMap();
        map2.put(3, 30);
        map2.put(2, 20);
        map2.put(1, 10);
        assertEquals(map1.hashCode(), map2.hashCode());
        IntIntHashMap map3 = new IntIntHashMap();
        map3.put(1, 10);
        map3.put(2, 20);
        map3.put(4, 40);
        assertEquals(false, map1.hashCode() == map3.hashCode());
    }
}