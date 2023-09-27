package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
public class TestIntLongHashMap_testHashCode {
    private IntLongHashMap map;
    @Before
    public void setUp(){
        map = new IntLongHashMap();
    }
    @Test
    public void testHashCodeWithEmptyMap() {
        assertEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithOneEntry() {
        map.put(1, 2l);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithMultipleEntries() {
        map.put(1, 2l);
        map.put(2, 4l);
        map.put(3, 6l);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithDuplicateKeysAndValues() {
        map.put(1, 2l);
        map.put(1, 2l);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithNegativeValue() {
        map.put(-1, -2l);
        assertNotEquals(0, map.hashCode());
    }
    @Test
    public void testHashCodeWithNullKey() {
        try{
            map.put(null, 2l);
            fail("Expected NullPointerException not thrown.");
        } catch(NullPointerException e){
       }
   }
}