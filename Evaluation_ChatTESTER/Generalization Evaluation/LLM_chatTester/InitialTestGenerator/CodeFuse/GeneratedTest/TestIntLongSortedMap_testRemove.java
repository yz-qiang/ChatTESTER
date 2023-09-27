package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongSortedMapTest###testRemove
public class TestIntLongSortedMap_testRemove {
    private IntLongSortedMap map;
    @Before
    public void setUp(){
        map = new IntLongSortedMap();
    }
    @Test
    public void testRemoveWithValidIdx() {
        map.put(1, 5L);
        map.put(3, 7L);
        map.put(4, 9L);
        map.put(6, 8L);
        map.remove(3);
        assertFalse(map.containsKey(3));
        assertNull(map.getValue(3));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistingElement() {
        map.remove(-1);
    }
    @Test
    public void testEmptyMapAfterRemoval() {
        map.put(1, 5L);
        map.remove(1);
        assertTrue(map.isEmpty());
    }
    @Test
    public void testMultipleElementsRemoved() {
        map.put(1, 5L);
        map.put(3, 7L);
        map.put(4, 9L);
        map.put(6, 8L);
        map.remove(3);
        map.remove(6);
        assertFalse(map.containsKey(3));
        assertFalse(map.containsKey(6));
        assertNull(map.getValue(3));
        assertNull(map.getValue(6));
    }
}