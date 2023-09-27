package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntDoubleEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntDoubleSortedVectorTest###testGetWithNoZeroValues
public class TestIntDoubleSortedVector_testGetWithNoZeroValues {
    private static IntDoubleSortedVector vec1;
    private static IntDoubleSortedVector expectedResult;
    @BeforeClass
    public static void setUp(){
        int[] indices = IntArrays.range(5);
        double[] values = {2.34, 0.6789, 0.0, 0.0, 1.23, 0.0};
        vec1 = new IntDoubleSortedVector(indices, values);
        expectedResult = new IntDoubleSortedVector(new int[]{0}, new double[]{2.34});
    }
    @Test
    public void testGetWithNoZeroValues() {
        assertEquals("The result should be as expected", expectedResult, IntDoubleSortedVector.getWithNoZeroValues(vec1, Primitives.EPS));
    }
}