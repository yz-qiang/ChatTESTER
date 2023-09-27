package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testEquals
public class IntLongHashMapEqualsTest_testEquals {
    private IntLongHashMap map1;
    private IntLongHashMap map2;
    @Before
    public void setUp() throws Exception {
        map1 = new IntLongHashMap();
        map2 = new IntLongHashMap();
    }
    @Test
    public void testEqualEmptyMaps() {
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalEmptyAndNonemptyMaps() {
        map1.put(1, 1L);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalDifferentKeyValuePairs() {
        map1.put(1, 1L);
        map2.put(2, 2L);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testEqualWithDuplicateKeys() {
        map1.put(1, 1L);
        map1.put(1, 2L);
        map2.put(1, 2L);
        map2.put(1, 3L);
        assertTrue(map1.equals(map2));
    }
    @Test
    public void testUnequalWithMissingEntryInOneMap() {
        map1.put(1, 1L);
        map2.put(1, 1L);
        map2.put(2, 2L);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalWithDifferentValuesForSameKey() {
        map1.put(1, 1L);
        map2.put(1, 2L);
        assertFalse(map1.equals(map2));
    }
    @Test
    public void testUnequalWithDifferentNumberOfEntries() {
        map1.put(1, 1L);
        map1.put(2, 2L);
        map2.put(1, 1L);
        assertFalse(map1.equals(map2));
    }
}