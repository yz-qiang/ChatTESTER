package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import edu.jhu.prim.map.LongDoubleSortedMap;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.Pair;
import java.util.Map;
import java.util.Map.Entry;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest###testRemove
public class LongDoubleSortedMapTest_testRemove {
    private LongDoubleSortedMap ldsm;
    @Before
    public void setUp(){
        ldsm = new LongDoubleSortedMap();
    }
    @Test
    public void testRemoveExistingElement() {
        ldsm.put(1L, 3.5);
        ldsm.put(2L, 4.6);
        ldsm.put(3L, 7.8);
        ldsm.put(4L, 9.0);
        ldsm.remove(2L);
        assertFalse(ldsm.containsKey(2L));
        assertEquals(2, ldsm.size());
        Iterator<Entry<Long, Double>> iter = ldsm.entrySet().iterator();
        while(iter.hasNext()) {
            Entry<Long, Double> entry = iter.next();
            assertNotNull(entry);
            switch((long)entry.getKey()){
                case 1L :
                    assertEquals(new Double(3.5), entry.getValue());
                    break;
                case 3L :
                    assertEquals(new Double(7.8), entry.getValue());
                    break;
                case 4L :
                    assertEquals(new Double(9.0), entry.getValue());
                    break;
                default: fail("Unexpected element found in map.");
            }
        }
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistentElement() {
        ldsm.remove(5L);
    }
}