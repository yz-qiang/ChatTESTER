package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testHashCode
public class IntFloatHashMapTest_testHashCode {
    private IntFloatHashMap map;
    @Before
    public void setUp() throws Exception {
        map = new IntFloatHashMap();
        map.put(1, 2f);
        map.put(2, 4f);
        map.put(3, 6f);
    }
    @Test
    public void testHashCode() {
        assertEquals(map.hashCode(), 985);
    }
}