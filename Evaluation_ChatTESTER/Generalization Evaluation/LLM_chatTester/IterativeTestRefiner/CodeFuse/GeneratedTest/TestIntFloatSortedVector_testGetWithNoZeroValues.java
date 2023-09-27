package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toFloat;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntFloatEntry;
import org.junit.BeforeClass;
import edu.jhu.prim.vector.IntFloatSortedVector;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntFloatSortedVectorTest###testGetWithNoZeroValues
public class TestIntFloatSortedVector_testGetWithNoZeroValues {
    private static IntFloatSortedVector sortedVector;
    @BeforeClass
    public static void setUp(){
        int[] indices = {1,2,3};
        float[] values = {5f,6f,7f};
        sortedVector = new IntFloatSortedVector(indices,values);
    }
    @Test
    public void testGetWithNoZeroValues() {
        float threshold = 4f;
        IntFloatSortedVector result = IntFloatSortedVector.getWithNoZeroValues(sortedVector,threshold);
        assertEquals("The size should not change", 2,result.size());
        Iterator<IntFloatEntry> itr = result.iterator();
        while(itr.hasNext()) {
             IntFloatEntry entry = itr.next();
             assertTrue("All values in the returned vector should be greater than the threshold",entry.getValue() > threshold);
        }
    }
}