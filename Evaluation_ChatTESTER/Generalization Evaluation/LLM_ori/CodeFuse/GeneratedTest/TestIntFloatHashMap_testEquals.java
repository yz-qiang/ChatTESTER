package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testEquals
public class TestIntFloatHashMap_testEquals {
    private IntFloatHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntFloatHashMap();
    }
    @Test
    public void testEqualsWithSameValuesAndStates() {
        hashMap.put(1, 2f);
        hashMap.put(3, 4f);
        hashMap.put(5, 6f);
        IntFloatHashMap anotherHashmap = new IntFloatHashMap(hashMap);
        assertTrue(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithDifferentValues() {
        hashMap.put(1, 2f);
        hashMap.put(3, 4f);
        hashMap.put(5, 6f);
        IntFloatHashMap anotherHashmap = new IntFloatHashMap();
        anotherHashmap.put(1, 2f);
        anotherHashmap.put(3, 7f);
        anotherHashmap.put(5, 8f);
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithMissingValue() {
        hashMap.put(1, 2f);
        hashMap.put(3, 4f);
        hashMap.put(5, 6f);
        IntFloatHashMap anotherHashmap = new IntFloatHashMap();
        anotherHashmap.put(1, 2f);
        anotherHashmap.put(3, 4f);
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithExtraKeyInOther() {
        hashMap.put(1, 2f);
        hashMap.put(3, 4f);
        hashMap.put(5, 6f);
        IntFloatHashMap anotherHashmap = new IntFloatHashMap();
        anotherHashmap.put(1, 2f);
        anotherHashmap.put(3, 4f);
        anotherHashmap.put(5, 6f);
        anotherHashmap.put(9, 10f);
        assertFalse(hashMap.equals(anotherHashmap));
    }
    @Test
    public void testEqualsWithNullInput() {
        hashMap.put(1, 2f);
        hashMap.put(3, 4f);
        hashMap.put(5, 6f);
        assertNotNull(hashMap.equals(null));
    }
}