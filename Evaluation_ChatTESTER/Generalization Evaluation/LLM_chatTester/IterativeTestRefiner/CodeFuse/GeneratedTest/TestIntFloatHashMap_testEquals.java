package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
import edu.jhu.prim.map.IntFloatHashMap;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testEquals
public class TestIntFloatHashMap_testEquals {
    private IntFloatHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntFloatHashMap();
    }
    @Test
    public void testEqualsWithSameObjectsReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfSameTypeAndEqualValuesReturnFalse() {
        IntFloatHashMap anotherHashmap = new IntFloatHashMap();
        assertNotNull(anotherHashmap);
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfDifferentTypesReturnFalse() {
        Object someOtherObj = new Object();
        assertFalse(hashMap.equals(someOtherObj));
    }
    @Test
    public void testEqualsWithEmptyMapsReturnTrue() {
        IntFloatHashMap emptyHashMap = new IntFloatHashMap();
        assertTrue(emptyHashMap.equals(new IntFloatHashMap()));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningTrueWhenAllKeysHaveMatchedPairsInBothMaps() {
        IntFloatHashMap map1 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,4f});
        IntFloatHashMap map2 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,4f});
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfOneKeyIsMissingFromSecondMap() {
        IntFloatHashMap map1 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,4f});
        IntFloatHashMap map2 = new IntFloatHashMap(new int[]{1}, new float[]{3f});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfValueDoesntMatchForCorrespondingKey() {
        IntFloatHashMap map1 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,5f});
        IntFloatHashMap map2 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,4f});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfNumberOfElementsAreDifferent() {
        IntFloatHashMap map1 = new IntFloatHashMap(new int[]{1,2}, new float[]{3f,4f});
        IntFloatHashMap map2 = new IntFloatHashMap(new int[]{1,2,3}, new float[]{3f,4f,6f});
        assertFalse(map1.equals(map2));
    }
}