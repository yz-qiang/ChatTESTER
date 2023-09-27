package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toDouble;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toLong;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/LongDoubleHashMapTest###testHashCode
public class LongDoubleHashMapTest_testHashCode {
	private static LongDoubleHashMap map;
	@BeforeClass
	public void setUp() throws Exception {
		map = new LongDoubleHashMap();
	}
	@Test
	public void testHashCode() {
		long key1 = 123456L;
		double value1 = 123.456D;
		long key2 = 987654L;
		double value2 = 987.654D;
		map.put(key1, value1);
		map.put(key2, value2);
		int actualHashCode = map.hashCode();
		int expectedHashCode = 37 * (Primitives.hashOfLong(key1) + Primitives.hashOfDouble(value1)) + 37 * (Primitives.hashOfLong(key2) + Primitives.hashOfDouble(value2));
		assertEquals(expectedHashCode, actualHashCode);
	}
}