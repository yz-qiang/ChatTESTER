package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleSortedMapTest###testRemove
public class TestIntDoubleSortedMap_testRemove {
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
    public void testRemoveMethodWithValidInput(){
        IntDoubleSortedMap idm = new IntDoubleSortedMap();
        idm.addElement(1, 3.5);
        idm.addElement(2, 4.6);
        idm.addElement(3, 7.8);
        idm.remove(2);
        assertFalse(idm.containsKey(2));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveMethodWithInvalidInput(){
        IntDoubleSortedMap idm = new IntDoubleSortedMap();
        idm.remove(9);
    }
    private void addElement(int key, double value){
        int[] keys = new int[]{key};
        double[] vals = new double[]{value};
        IntDoubleSortedMap idm = new IntDoubleSortedMap(keys,vals);
        idm.put(key, value);
    }
    private boolean containsKey(int key){
        return Arrays.binarySearch(idm.indices, 0, idm.used, key) >= 0;
    }
}