package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import edu.jhu.prim.map.IntDoubleSortedMap;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleSortedMapTest###testRemove
public class TestIntDoubleSortedMap_testRemove {
    private IntDoubleSortedMap map;
    @Before
    public void setUp(){
        map = new IntDoubleSortedMap();
    }
    @Test
    public void testRemoveExistingElement() {
        map.put(1, 3.5);
        map.put(2, 4.6);
        map.put(3, 7.8);
        map.put(4, 9.0);
        map.remove(2);
        assertFalse(map.containsKey(2));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistentElement() {
        map.remove(5);
    }
    @Test
    public void testEmptyMapAfterRemoval() {
        map.put(1, 3.5);
        map.remove(1);
        assertTrue(map.isEmpty());
    }
    @Test
    public void testMultipleElementsRemoved() {
        map.put(1, 3.5);
        map.put(2, 4.6);
        map.put(3, 7.8);
        map.put(4, 9.0);
        map.remove(2);
        map.remove(4);
        assertFalse(map.containsKey(2));
        assertFalse(map.containsKey(4));
    }
}