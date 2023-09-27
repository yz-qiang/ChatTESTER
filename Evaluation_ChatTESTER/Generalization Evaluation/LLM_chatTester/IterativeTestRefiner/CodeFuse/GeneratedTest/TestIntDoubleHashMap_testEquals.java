package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
import edu.jhu.prim.map.IntDoubleHashMap;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testEquals
public class TestIntDoubleHashMap_testEquals {
    private IntDoubleHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntDoubleHashMap();
    }
    @Test
    public void testEqualsWithSameObjectsReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfSameTypeAndEqualValuesReturnFalse() {
        IntDoubleHashMap anotherHashmap = new IntDoubleHashMap();
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
        IntDoubleHashMap emptyHashMap = new IntDoubleHashMap();
        assertTrue(emptyHashMap.equals(new IntDoubleHashMap());
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningTrueWhenAllKeysHaveMatchedPairsInBothMaps() {
        IntDoubleHashMap map1 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.5,4});
        IntDoubleHashMap map2 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.5,4});
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfOneKeyIsMissingFromSecondMap() {
        IntDoubleHashMap map1 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.5,4});
        IntDoubleHashMap map2 = new IntDoubleHashMap(new int[]{1}, new double[]{3.5});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfValueDoesntMatchForCorrespondingKey() {
        IntDoubleHashMap map1 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.5,4});
        IntDoubleHashMap map2 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.6,4});
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualsWithNonEmptyMapsReturningFalseIfOrderOfElementsAreDifferent() {
        IntDoubleHashMap map1 = new IntDoubleHashMap(new int[]{1,2}, new double[]{3.5,4});
        IntDoubleHashMap map2 = new IntDoubleHashMap(new int[]{2,1}, new double[]{4,3.5});
        assertFalse(map1.equals(map2));
    }
}