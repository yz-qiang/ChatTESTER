package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatSortedMapTest###testRemove
public class TestIntFloatSortedMap_testRemove {
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
        IntFloatSortedMap myMap = new IntFloatSortedMap();
        myMap.addElement(1, 3.5f);
        myMap.addElement(2, 4.6f);
        myMap.addElement(3, 7.8f);
        myMap.remove(2);
        assertFalse(myMap.containsKey(2));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveMethodWithInvalidInput(){
        IntFloatSortedMap myMap = new IntFloatSortedMap();
        myMap.remove(1);
    }
    private void addElement(int key, float value){
    }
    private boolean containsKey(int key){
    }
}