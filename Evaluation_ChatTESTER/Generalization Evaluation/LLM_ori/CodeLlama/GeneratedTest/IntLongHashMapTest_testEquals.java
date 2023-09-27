package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testEquals
public class IntLongHashMapTest_testEquals {
    private IntLongHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntLongHashMap();
        map.put(123456789, 987654321);
        map.put(987654321, 123456789);
    }
    @Test
    public void testEquals() {
        IntLongHashMap otherMap = new IntLongHashMap();
        assertTrue(map.equals(otherMap));
        Object otherObj = new Object();
        assertFalse(map.equals(otherObj));
        assertTrue(map.equals(map));
        IntLongHashMap modifiedCopy = new IntLongHashMap(map);
        modifiedCopy.remove(123456789);
        assertFalse(map.equals(modifiedCopy));
    }
}