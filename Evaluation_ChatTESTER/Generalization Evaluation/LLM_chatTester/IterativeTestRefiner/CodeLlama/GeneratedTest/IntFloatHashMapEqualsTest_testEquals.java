package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import org.junit.Before;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntFloatHashMapTest###testEquals
public class IntFloatHashMapEqualsTest_testEquals {
@Test
public void testNonHashableKeyComparison() {
    try {
        IntFloatHashMap map1 = new IntFloatHashMap();
        map1.put(1, 1f);
        fail("Expected UnsupportedOperationException");
    } catch (UnsupportedOperationException e) {
    }
}
}