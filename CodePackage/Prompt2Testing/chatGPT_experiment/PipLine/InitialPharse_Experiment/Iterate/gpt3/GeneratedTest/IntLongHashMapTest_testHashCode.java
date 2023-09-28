package edu.jhu.prim.map;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
import org.junit.Assert;
import org.junit.Test;
public class IntLongHashMapTest_testHashCode {
    @Test
    public void testHashCode() {
        IntLongHashMap map1 = new IntLongHashMap();
        map1.put(1, 100L);
        map1.put(2, 200L);
        map1.put(3, 300L);
        IntLongHashMap map2 = new IntLongHashMap();
        map2.put(1, 100L);
        map2.put(2, 200L);
        map2.put(3, 300L);
        Assert.assertEquals(map1.hashCode(), map2.hashCode());
        IntLongHashMap map3 = new IntLongHashMap();
        map3.put(1, 100L);
        map3.put(2, 200L);
        map3.put(4, 400L);
        Assert.assertNotEquals(map1.hashCode(), map3.hashCode());
    }
}