package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntLongEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntLongSortedVectorTest###testGetWithNoZeroValues
public class TTT_testGetWithNoZeroValues {
@Test
public void testGetWithNoZeroValues() {
    int[] indices = {1, 2, 3, 4};
    long[] data = {5L, 6L, 7L, 8L};
    IntLongSortedVector vec = new IntLongSortedVector(indices, data);
    IntLongSortedVector result = IntLongSortedVector.getWithNoZeroValues(vec);
    assertEquals(result.size(), 3);
    assertTrue(result.containsKey(1));
    assertTrue(result.containsKey(2));
    assertFalse(result.containsKey(3));
    assertTrue(result.containsValue(5L));
    assertTrue(result.containsValue(6L));
    assertFalse(result.containsValue(7L));
}
}