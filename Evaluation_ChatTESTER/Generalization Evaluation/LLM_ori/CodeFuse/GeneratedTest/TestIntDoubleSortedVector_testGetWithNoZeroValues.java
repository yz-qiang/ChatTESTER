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
    private static IntDoubleSortedVector vec2;
    private static Double threshold;
    @BeforeClass
    public static void setUp(){
        int[] indices = {1,3,5};
        double[] values = {1.0, 0.0, 4.0, 6.0};
        vec1 = new IntDoubleSortedVector(indices,values);
        threshold = 0.0;
    }
    @Test
    public void testGetWithNoZeroValues(){
        IntDoubleSortedVector result = IntDoubleSortedVector.getWithNoZeroValues(vec1,threshold);
        assertEquals("The size should be 2", 2,result.size());
        Iterator<IntDoubleEntry> itr = result.iterator();
        while(itr.hasNext()) {
             IntDoubleEntry entry = itr.next();
             assertNotSame("There should not be any zeros in the returned vector", 0.0,entry.getValue(), Primitives.EPS);
        }
    }
}