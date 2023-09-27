package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testEquals
public class TestIntIntHashMap_testEquals {
    private IntIntHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntIntHashMap();
    }
    @Test
    public void testEqualsWithSameObjectsReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfTheSameTypeAndEqualValuesReturnTrue() {
        IntIntHashMap anotherHashmap = new IntIntHashMap(hashMap);
        assertTrue(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithNullReturnFalse() {
        assertNotNull(hashMap);
        assertFalse(hashMap.equals(null));
    }
    @Test
    public void testEqualsWithDifferentTypesReturnFalse() {
        Object someOtherObj = "Some string";
        assertFalse(hashMap.equals(someOtherObj));
    }
    @Test
    public void testEqualsWithUnequalNumberOfElementsReturnFalse() {
        IntIntHashMap map2 = new IntIntHashMap();
        map2.put(1, 5);
        assertFalse(hashMap.equals(map2));
    }
    @Test
    public void testEqualsWithNonMatchingKeysReturnFalse() {
        IntIntHashMap map3 = new IntIntHashMap();
        map3.put(1, 6);
        assertFalse(hashMap.equals(map3));
    }
    @Test
    public void testEqualsWithNonMatchingValuesReturnFalse() {
        IntIntHashMap map4 = new IntIntHashMap();
        map4.put(1, 7);
        assertFalse(hashMap.equals(map4));
    }
    @Test
    public void testEqualsWithAllMatchingValuesReturnTrue() {
        IntIntHashMap map5 = new IntIntHashMap();
        map5.put(1, 8);
        assertTrue(hashMap.equals(map5));
    }
}