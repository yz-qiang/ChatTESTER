package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntFloatEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntFloatSortedVectorTest###testGetWithNoZeroValues
public class TestIntFloatSortedVector_testGetWithNoZeroValues {
    private static IntFloatSortedVector vector1;
    private static IntFloatSortedVector vector2;
    private static Float threshold;
    @BeforeClass
    public static void setUp(){
        int[] indices = {1,3,5};
        float[] values = {1f, 0f, 4f, 6f, 7f, 8f, 9f};
        vector1 = new IntFloatSortedVector(indices,values);
        threshold = 0f;
    }
    @Test
    public void testGetWithNoZeroValues() {
        IntFloatSortedVector result = IntFloatSortedVector.getWithNoZeroValues(vector1,threshold);
        assertEquals("The size should be reduced", 3,result.size());
        Iterator<IntFloatEntry> itr = result.iterator();
        while(itr.hasNext()) {
           IntFloatEntry entry = itr.next();
           assertNotSame("There should not be any zeros in the returned vector", 0f,(float)entry.getValue(),threshold);
        }
    }
}