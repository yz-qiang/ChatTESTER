package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testEquals
public class LongDoubleHashMapTest_testEquals {
    private LongDoubleHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new LongDoubleHashMap();
    }
    @Test
    public void testEqualsWithSameObjectsReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfTheSameTypeReturnFalse() {
        LongDoubleHashMap anotherHashmap = new LongDoubleHashMap();
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithNullReturnFalse() {
        assertFalse(hashMap.equals(null));
    }
    @Test
    public void testEqualsWithNonLongDoubleHashMapReturnFalse() {
        Object nonLongDoubleHashMapObj = "Not a LongDoubleHashMap";
        assertFalse(hashMap.equals(nonLongDoubleHashMapObj));
    }
    @Test
    public void testEqualsWithEmptyMapsReturnTrue() {
        LongDoubleHashMap emptyHashMap = new LongDoubleHashMap();
        assertTrue(emptyHashMap.equals(new LongDoubleHashMap()));
    }
    @Test
    public void testEqualsWithEqualValuesAndStatesReturnTrue() {
        LongDoubleHashMap map1 = new LongDoubleHashMap();
        map1.put(1L, 2.5);
        map1.put(3L, 4.6);
        LongDoubleHashMap map2 = new LongDoubleHashMap();
        map2.put(1L, 2.5);
        map2.put(3L, 4.6);
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testEqualsWithUnequalValuesReturnFalse() {
        LongDoubleHashMap map1 = new LongDoubleHashMap();
        map1.put(1L, 2.5);
        map1.put(3L, 4.6);
        LongDoubleHashMap map2 = new LongDoubleHashMap();
        map2.put(1L, 2.5);
        map2.put(3L, 7.8);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithMissingEntryInOneMapReturnFalse() {
        LongDoubleHashMap map1 = new LongDoubleHashMap();
        map1.put(1L, 2.5);
        LongDoubleHashMap map2 = new LongDoubleHashMap();
        map2.put(1L, 2.5);
        map2.put(3L, 4.6);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithExtraEntryInOneMapReturnFalse() {
        LongDoubleHashMap map1 = new LongDoubleHashMap();
        map1.put(1L, 2.5);
        map1.put(3L, 4.6);
        map1.put(5L, 9.0);
        LongDoubleHashMap map2 = new LongDoubleHashMap();
        map2.put(1L, 2.5);
        map2.put(3L, 4.6);
        assertFalse(map1.equals(map2));
    }
}