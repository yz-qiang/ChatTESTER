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
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static List<Integer> expectedOutput = new ArrayList<>();
    @BeforeClass
    public static void setUp(){
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        list1.add(0);
        list1.add(8);
        list1.add(0);
        list1.add(6);
        list1.add(4);
        list1.add(0);
        list1.add(2);
        list1.add(0);
        list1.add(1);
        list1.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list2.add(0);
        expectedOutput.add(3);
        expectedOutput.add(5);
        expectedOutput.add(7);
        expectedOutput.add(9);
        expectedOutput.add(8);
        expectedOutput.add(6);
        expectedOutput.add(4);
        expectedOutput.add(2);
        expectedOutput.add(1);
    }
    @Test
    public void testGetWithNoZeroValues() {
        int[] arr1 = Primitives.toPrimitive(list1.stream().mapToInt(Integer::intValue).toArray(), null);
        int[] arr2 = Primitives.toPrimitive(list2.stream().mapToInt(Integer::intValue).toArray(), null);
        IntIntSortedVector vec1 = new IntIntSortedVector(arr1);
        IntIntSortedVector vec2 = new IntIntSortedVector(arr2);
        IntIntSortedVector result1 = IntIntSortedVector.getWithNoZeroValues(vec1);
        IntIntSortedVector result2 = IntIntSortedVector.getWithNoZeroValues(vec2);
        assertEquals("The size should be equal", expectedOutput.size(), result1.used());
        Iterator<Integer> itr = expectedOutput.iterator();
        for(int i=0; i<result1.used(); i++){
            assertTrue("Element at position "+i+" does not match", itr.next() == result1.valueAt(i));
        }
        assertEquals("The size should be equal", 0, result2.used());
    }
}