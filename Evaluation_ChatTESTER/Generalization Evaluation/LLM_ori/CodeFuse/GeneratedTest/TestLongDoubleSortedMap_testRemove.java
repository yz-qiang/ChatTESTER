package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleSortedMapTest###testRemove
public class TestLongDoubleSortedMap_testRemove {
    @BeforeClass
    public static void setUp(){
    }
    @AfterClass
    public static void tearDown(){
    }
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testRemoveExistingKey(){
        LongDoubleSortedMap ldsm = new LongDoubleSortedMap();
        ldsm.add(new long[]{1L, 3L}, new double[]{4.5, 6.7});
        assertTrue(ldsm.contains(1));
        ldsm.remove(1);
        assertFalse(ldsm.contains(1));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveNonExistentKey(){
        LongDoubleSortedMap ldsm = new LongDoubleSortedMap();
        ldsm.remove(1);
    }
    private boolean contains(LongDoubleSortedMap ldsm, long key){
        Iterator<Pair<Long, Double>> itr = ldsm.iterator();
        while(itr.hasNext()) {
            Pair<Long, Double> entry = itr.next();
            if(entry.getFirst().equals(key)){
                return true;
            }
        }
        return false;
    }
}