package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
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
        Iterator<Pair<Long, Double>> iter = ldsm.entrySet().iterator();
        while(iter.hasNext()) {
            Pair<Long, Double> entry = iter.next();
            assertNotNull(entry);
            switch((long)entry.key){
                case 1L :
                    assertEquals(new Double(3.5), entry.value);
                    break;
                case 3L :
                    assertEquals(new Double(7.8), entry.value);
                    break;
                case 4L :
                    assertEquals(new Double(9.0), entry.value);
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