package edu.jhu.prim.vector;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
import edu.jhu.prim.map.IntLongEntry;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.junit.BeforeClass;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/vector/IntLongSortedVectorTest###testGetWithNoZeroValues
public class TestIntLongSortedVector_testGetWithNoZeroValues {
    private static List<Integer> indices;
    private static List<Long> values;
    private static IntLongSortedVector sortedVector;
    @BeforeClass
    public static void setUp(){
        indices = new ArrayList<>();
        values = new ArrayList<>();
        indices.add(1);
        indices.add(2);
        indices.add(3);
        indices.add(4);
        indices.add(5);
        values.add((long) 0);
        values.add((long) 0);
        values.add((long) 6);
        values.add((long) 7);
        values.add((long) 8);
        sortedVector = new IntLongSortedVector(indices.stream().mapToInt(Integer::valueOf).toArray(), values.stream().mapToLong(Long::valueOf).toArray());
    }
    @Test
    public void testGetWithNoZeroValues() {
        IntLongSortedVector result = IntLongSortedVector.getWithNoZeroValues(sortedVector);
        Iterator<IntLongEntry> iterator = result.iterator();
        while (iterator.hasNext()) {
             assertNotEquals(0L, iterator.next().getValue());
        }
    }
}