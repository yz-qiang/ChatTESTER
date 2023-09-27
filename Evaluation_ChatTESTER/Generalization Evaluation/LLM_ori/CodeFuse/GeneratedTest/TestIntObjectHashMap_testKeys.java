package edu.jhu.prim.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.jhu.prim.util.IntJUnitUtils;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/IntObjectHashMapTest###testKeys
public class TestIntObjectHashMap_testKeys {
    private IntObjectHashMap hashMap;
    @Before
    public void setUp(){
       hashMap = new IntObjectHashMap();
   }
    @Test
    public void testKeysMethodWithEmptyHashmap() {
        assertArrayEquals("The array should contain no elements", new int[]{}, hashMap.keys());
    }
    @Test
    public void testKeysMethodWithNonEmptyHashmap() {
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(3,"three");
        int[] expectedOutput = {1,2,3};
        Arrays.sort(expectedOutput);
        assertArrayEquals("The array should contain all added elements in sorted order", expectedOutput,hashMap.keys());
    }
    @Test
    public void testKeysMethodWithDuplicateElementsInHashmap() {
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(1,"duplicateOne");
        int[] expectedOutput = {1,2};
        Arrays.sort(expectedOutput);
        assertArrayEquals("The array should not have duplicate elements", expectedOutput,hashMap.keys());
    }
}