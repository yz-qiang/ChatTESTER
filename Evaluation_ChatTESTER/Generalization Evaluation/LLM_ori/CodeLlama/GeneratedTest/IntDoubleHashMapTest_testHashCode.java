package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntDoubleHashMapTest###testHashCode
public class IntDoubleHashMapTest_testHashCode {
	private static IntDoubleHashMap map;
	@BeforeClass
	public void setUp() throws Exception {
		map = new IntDoubleHashMap();
	}
	@Test
	public void testHashCode() {
		int[] keys = { 1, 2, 3 };
		double[] values = { 4.5, 6.7, 8.9 };
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		int actualHashCode = map.hashCode();
		int expectedHashCode = 17;
		for (int i = 0; i < keys.length; i++) {
			expectedHashCode = 37 * expectedHashCode + Primitives.hashOfInt(keys[i]) + Primitives.hashOfDouble(values[i]);
		}
		assertEquals(expectedHashCode, actualHashCode);
	}
}