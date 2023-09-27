package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testHashCode
public class TTT_testHashCode {
@Test
public void testHashCode() {
    LongDoubleHashMap map1 = new LongDoubleHashMap(new long[]{1L, 2L}, new double[]{4.5D, 6.7D});
    LongDoubleHashMap map2 = new LongDoubleHashMap(new long[]{2L, 1L}, new double[]{6.7D, 4.5D});
    assertEquals(map1.hashCode(), map2.hashCode());
}
}