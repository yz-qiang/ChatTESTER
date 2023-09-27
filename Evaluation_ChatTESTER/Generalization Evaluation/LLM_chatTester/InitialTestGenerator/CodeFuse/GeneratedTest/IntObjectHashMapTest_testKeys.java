package edu.jhu.prim.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.jhu.prim.util.IntJUnitUtils;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/IntObjectHashMapTest###testKeys
public class IntObjectHashMapTest_testKeys {
    private IntObjectHashMap intObjMap;
    @Before
    public void setUp(){
          intObjMap = new IntObjectHashMap();
    }
    @Test
    public void testKeysMethodWithEmptyHashmap() {
        assertArrayEquals("Expected empty keyset", new int[]{}, intObjMap.keys());
    }
    @Test
    public void testKeysMethodWithNonEmptyHashmap() {
        intObjMap.put(1,"One");
        intObjMap.put(2,"Two");
        intObjMap.put(3,"Three");
        intObjMap.put(4,"Four");
        intObjMap.remove(2);
        int[] expectedKeys = {1,3};
        assertArrayEquals("Expected non-empty keyset", expectedKeys, intObjMap.keys());
    }
    @Test
    public void testKeysMethodWithNullValuesInHashMap() {
        intObjMap.put(5,null);
        intObjMap.put(6,null);
        int[] expectedKeys = {5,6};
        assertArrayEquals("Expected keyset with null value", expectedKeys, intObjMap.keys());
    }
    @Test
    public void testKeysMethodWithDuplicateKeyValuePairs() {
        intObjMap.put(7,"Seven");
        intObjMap.put(8,"Eight");
        intObjMap.put(9,"Nine");
        intObjMap.put(7,"Seven");
        int[] expectedKeys = {7,8,9};
        assertArrayEquals("Expected keyset with duplicate entries", expectedKeys, intObjMap.keys());
    }
}