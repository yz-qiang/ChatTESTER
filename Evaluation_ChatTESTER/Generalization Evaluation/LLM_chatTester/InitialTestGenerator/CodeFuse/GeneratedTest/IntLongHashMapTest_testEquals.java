package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testEquals
public class IntLongHashMapTest_testEquals {
    private IntLongHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntLongHashMap();
        hashMap.put(1, 2l);
        hashMap.put(3, 4l);
        hashMap.put(5, 6l);
    }
    @Test
    public void testEqualsWithSameObjectsReturnTrue() {
        assertTrue(hashMap.equals(hashMap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfSameTypeAndEqualValuesReturnTrue() {
        IntLongHashMap anotherHashmap = new IntLongHashMap(new int[]{1,3,5}, new long[]{2,4,6});
        assertTrue(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithDifferentObjectsOfSameTypeButUnequalValuesReturnFalse() {
        IntLongHashMap anotherHashmap = new IntLongHashMap(new int[]{1,3,5}, new long[]{2,7,6});
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithNullReturnFalse() {
        assertNotNull(hashMap);
        assertFalse(hashMap.equals(null));
    }
    @Test
    public void testEqualsWithDifferentTypesReturnFalse() {
        String str = "";
        assertFalse(hashMap.equals(str));
    }
    @Test
    public void testEqualsWithEmptyMapsReturnTrue() {
        IntLongHashMap emptyHashMap = new IntLongHashMap();
        assertTrue(emptyHashMap.equals(new IntLongHashMap()));
    }
    @Test
    public void testEqualsWithNonFullStatesReturnFalse() {
        IntLongHashMap nonFullHashMap = new IntLongHashMap(new int[]{1,3}, new long[]{2,4});
        assertFalse(nonFullHashMap.equals(hashMap));
    }
}