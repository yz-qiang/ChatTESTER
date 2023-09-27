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
    public void testEqualsWithDifferentObjectsOfSameTypeAndEqualValuesReturnFalse() {
        IntIntHashMap anotherHashmap = new IntIntHashMap();
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithNullReturnFalse() {
        assertFalse(hashMap.equals(null));
    }
    @Test
    public void testEqualsWithDifferentTypesReturnFalse() {
        Object someOtherObj = new Object();
        assertFalse(hashMap.equals(someOtherObj));
    }
    @Test
    public void testEqualsWithEmptyMapsReturnTrue() {
        IntIntHashMap emptyHashMap = new IntIntHashMap();
        assertTrue(emptyHashMap.equals(new IntIntHashMap());
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningTrueWhenAllKeysMatched() {
        IntIntHashMap map1 = new IntIntHashMap(new int[]{1,2}, new int[]{3,4});
        IntIntHashMap map2 = new IntIntHashMap(new int[]{1,2}, new int[]{3,4});
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfNotAllKeysMatched() {
        IntIntHashMap map1 = new IntIntHashMap(new int[]{1,2}, new int[]{3,5});
        IntIntHashMap map2 = new IntIntHashMap(new int[]{1,2}, new int[]{3,4});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfOneKeyMissingInSecondMap() {
        IntIntHashMap map1 = new IntIntHashMap(new int[]{1,2}, new int[]{3,4});
        IntIntHashMap map2 = new IntIntHashMap(new int[]{1}, new int[]{3});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfExtraKeyInFirstMap() {
        IntIntHashMap map1 = new IntIntHashMap(new int[]{1,2,3}, new int[]{3,4,6});
        IntIntHashMap map2 = new IntIntHashMap(new int[]{1,2}, new int[]{3,4});
        assertFalse(map1.equals(map2));
    }
}