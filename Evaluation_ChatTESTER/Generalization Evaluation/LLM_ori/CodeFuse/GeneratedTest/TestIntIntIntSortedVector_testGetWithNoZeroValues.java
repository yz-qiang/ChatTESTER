package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntIntEntry;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntIntSortedVectorTest###testGetWithNoZeroValues
public class TestIntIntIntSortedVector_testGetWithNoZeroValues {
    private static IntIntSortedVector sortedVector;
    @BeforeClass
    public static void setUp(){
    }
    @Test
    public void testGetWithNoZeroValues() {
        IntIntSortedVector inputVector = new IntIntSortedVector(new int[]{1,2,3,4,5});
        IntIntSortedVector result = IntIntSortedVector.getWithNoZeroValues(inputVector);
        assertEquals("The size should be same as original", inputVector.size(),result.size());
        Iterator<IntEntry> iterator = result.iterator();
        while(iterator.hasNext()) {
             IntEntry entry = iterator.next();
             assertNotSame("There should not be zero values in the output vector", Primitives.zero,entry.getValue());
        }
    }
}