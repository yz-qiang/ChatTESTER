package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntSortedMapTest###testRemove
public class TestIntIntIntSortedMap_testRemove {
    private IntIntSortedMap map;
    @Before
    public void setUp(){
        map = new IntIntSortedMap();
    }
    @Test
    public void testRemoveWithValidIdx() {
        map.put(1, 5);
        map.put(3, 7);
        map.put(4, 9);
        map.put(6, 8);
        map.remove(3);
        assertFalse(map.containsKey(3));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistingElement() {
        map.remove(2);
    }
    @Test
    public void testEmptyMapAfterRemoval() {
        map.put(1, 5);
        map.remove(1);
        assertTrue(map.isEmpty());
    }
    @Test
    public void testMultipleElementsRemoved() {
        map.put(1, 5);
        map.put(3, 7);
        map.put(4, 9);
        map.put(6, 8);
        map.remove(3);
        map.remove(6);
        assertFalse(map.containsKey(3));
        assertFalse(map.containsKey(6));
    }
}