package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import edu.jhu.prim.map.IntFloatSortedMap;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatSortedMapTest###testRemove
public class TestIntFloatSortedMap_testRemove {
    private IntFloatSortedMap map;
    @Before
    public void setUp(){
        map = new IntFloatSortedMap();
    }
    @Test
    public void testRemoveExistingElement() {
        map.put(1, 3f);
        map.put(5, 7f);
        map.put(9, 8f);
        map.put(4, 6f);
        map.remove(5);
        assertFalse(map.containsKey(5));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistentElement() {
        map.remove(-1);
    }
    @Test
    public void testEmptyMapAfterRemoval() {
        map.put(1, 3f);
        map.remove(1);
        assertTrue(map.isEmpty());
    }
    @Test
    public void testMultipleElementsRemoved() {
        map.put(1, 3f);
        map.put(5, 7f);
        map.put(9, 8f);
        map.put(4, 6f);
        map.remove(5);
        map.remove(1);
        assertFalse(map.containsKey(5));
        assertFalse(map.containsKey(1));
    }
}