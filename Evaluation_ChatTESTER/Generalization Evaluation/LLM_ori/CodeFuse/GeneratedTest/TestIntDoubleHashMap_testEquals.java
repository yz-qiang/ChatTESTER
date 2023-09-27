package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testEquals
public class TestIntDoubleHashMap_testEquals {
    private IntDoubleHashMap hashMap;
    @Before
    public void setUp(){
        hashMap = new IntDoubleHashMap();
    }
    @Test
    public void testEqualsWithSameValuesAndStatesShouldReturnTrue() {
        IntDoubleHashMap map2 = new IntDoubleHashMap();
        map2.put(1, 3.5);
        map2.put(2, 4.6);
        map2.put(3, 7.8);
        assertTrue(hashMap.equals(map2));
    }
    @Test
    public void testEqualsWithDifferentValuesButNotStatesShouldReturnFalse() {
        IntDoubleHashMap map2 = new IntDoubleHashMap();
        map2.put(1, 3.5);
        map2.put(2, 4.6);
        map2.put(3, 9.8);
        assertFalse(hashMap.equals(map2));
    }
    @Test
    public void testEqualsWithDifferentKeysAndStatesShouldReturnFalse() {
        IntDoubleHashMap map2 = new IntDoubleHashMap();
        map2.put(1, 3.5);
        map2.put(2, 4.6);
        map2.put(4, 7.8);
        assertFalse(hashMap.equals(map2));
    }
    @Test
    public void testEqualsWithNullValueShouldReturnFalse() {
        Object obj = null;
        assertFalse(hashMap.equals(obj));
    }
    @Test
    public void testEqualsWithWrongTypeOfObjectShouldReturnFalse() {
        String strObj = "test";
        assertFalse(hashMap.equals(strObj));
    }
}