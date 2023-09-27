package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
import edu.jhu.prim.map.LongDoubleHashMap;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testEquals
public class LongDoubleHashMapTest_testEquals {
    private LongDoubleHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new LongDoubleHashMap();
        hashMap.put(1L, 2.5);
        hashMap.put(3L, 4.6);
        hashMap.put(7L, 8.9);
    }
    @Test
    public void testEqualsMethodWithSameObjectsShouldReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsMethodWithDifferentObjectsButEqualValuesAndStatesShouldReturnTrue() {
        LongDoubleHashMap mapCopy = new LongDoubleHashMap(hashMap);
        assertTrue(hashMap.equals(mapCopy));
    }
    @Test
    public void testEqualsMethodWithDifferentObjectsAndDifferentValuesShouldReturnFalse() {
        LongDoubleHashMap differentValueMap = new LongDoubleHashMap();
        differentValueMap.put(1L, 2.5);
        differentValueMap.put(3L, 4.6);
        differentValueMap.put(7L, 8.9);
        differentValueMap.put(10L, 111.0);
        assertFalse(hashMap.equals(differentValueMap));
    }
    @Test
    public void testEqualsMethodWithDifferentObjectsAndDifferentKeysShouldReturnFalse() {
        LongDoubleHashMap differentKeyMap = new LongDoubleHashMap();
        differentKeyMap.put(1L, 2.5);
        differentKeyMap.put(4L, 4.6);
        differentKeyMap.put(7L, 8.9);
        assertFalse(hashMap.equals(differentKeyMap));
    }
    @Test
    public void testEqualsMethodWithNullShouldReturnFalse() {
        assertNotNull(hashMap.equals(null));
    }
}