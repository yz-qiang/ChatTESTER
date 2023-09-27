package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toLong;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntLongHashMapTest###testHashCode
public class IntLongHashMapTest_testHashCode {
	private IntLongHashMap map;
	@Before
	public void setUp() throws Exception {
		map = new IntLongHashMap();
	}
	@Test
	public void testHashCode() {
		assertEquals(0, map.hashCode());
		map.put(123456789, 987654321L);
		map.put(-123456789, -987654321L);
		map.put(Integer.MAX_VALUE, Long.MIN_VALUE);
		map.put(Integer.MIN_VALUE, Long.MAX_VALUE);
		long expectedHashCode = 0;
		for (int i : map.getKeys()) {
			expectedHashCode ^= (i & 0xFFFFFFFFL) | ((i >>> 32) & 0xFFFFFFFFL);
		}
		for (long l : map.getValues()) {
			expectedHashCode ^= (l & 0xFFFFFFFFL) | ((l >>> 32) & 0xFFFFFFFFL);
		}
		assertEquals(expectedHashCode, map.hashCode());
	}
}