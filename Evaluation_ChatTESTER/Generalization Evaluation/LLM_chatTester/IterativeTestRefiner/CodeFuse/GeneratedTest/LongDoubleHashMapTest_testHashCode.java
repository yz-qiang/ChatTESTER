package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testHashCode
public class LongDoubleHashMapTest_testHashCode {
    private LongDoubleHashMap map;
    @Before
    public void setUp(){
        map = new LongDoubleHashMap(); 
    }
    @Test
    public void testHashCode() {
        int expectedHashCode = 12345; 
        int actualHashCode = map.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }
}