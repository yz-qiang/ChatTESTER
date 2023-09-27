package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntFloatEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntFloatSortedVectorTest###testGetWithNoZeroValues
public class TTT_testGetWithNoZeroValues {
@Test
public void testGetWithNoZeroValues() {
    IntFloatSortedVector vec1 = new IntFloatSortedVector(new int[]{1, 2, 3}, new float[]{1.5f, 0.0f, 3.7f});
    assertEquals("Original vector has incorrect size", 3, vec1.size());
    assertTrue("Original vector contains non-zero elements", Primitives.isZero(vec1.get(1)));
    IntFloatSortedVector result = IntFloatSortedVector.getWithNoZeroValues(vec1, 0.1f);
    assertNotNull("Resulting vector is null", result);
    assertEquals("Resulting vector has incorrect size", 2, result.size());
    assertFalse("Resulting vector still contains zero element", Primitives.isZero(result.get(1)));
}
}