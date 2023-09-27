package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Test;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntSortedMapTest###testRemove
public class TestClass_testRemove {
    @Before
    public void setUp(){
    }
    @After
    public void tearDown(){
    }
    @Test
    public void testRemoveMethodWithValidInput(){
        IntIntSortedMap myMap = new IntIntSortedMap();
        myMap.remove(5);
        assertTrue(myMap.containsKey(idx));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testRemoveMethodWithInvalidInput(){
        IntSortedMap myMap = new IntIntSortedMap();
        myMap.remove(-1);
    }
    private boolean containsKey(int idx){
        Iterator itr = myMap.keySet().iterator();
        while(itr.hasNext()) {
            Integer currentIdx = itr.next();
            if(currentIdx == idx) return true;
        }
        return false;
    }
}