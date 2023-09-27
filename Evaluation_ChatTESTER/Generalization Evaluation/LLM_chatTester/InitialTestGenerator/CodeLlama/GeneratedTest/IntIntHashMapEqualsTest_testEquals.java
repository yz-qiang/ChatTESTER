package edu.jhu.prim.map;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static edu.jhu.prim.Primitives.toInt;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import edu.jhu.prim.Primitives;
// original test path: mgormley_prim###mgormley_prim/src/test/java_generated/edu/jhu/prim/map/IntIntHashMapTest###testEquals
public class IntIntHashMapEqualsTest_testEquals {
	private IntIntHashMap map1;
	private IntIntHashMap map2;
	private IntIntHashMap map3;
	@Before
	public void setUp() throws Exception {
		map1 = new IntIntHashMap();
		map2 = new IntIntHashMap();
		map3 = new IntIntHashMap();
	}
	@Test
	public void testEqualMapsWithDifferentOrder() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		map2.put(2, 4);
		map2.put(1, 2);
		map2.put(3, 6);
		assertTrue(map1.equals(map2));
	}
	@Test
	public void testUnequalMapsWithDifferentKeys() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		map2.put(2, 4);
		map2.put(5, 8);
		map2.put(3, 6);
		assertFalse(map1.equals(map2));
	}
	@Test
	public void testUnequalMapsWithDifferentValues() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		map2.put(1, 2);
		map2.put(2, 7);
		map2.put(3, 6);
		assertFalse(map1.equals(map2));
	}
	@Test
	public void testNullMap() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		assertFalse(map1.equals(null));
	}
	@Test
	public void testSelfEquality() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		assertTrue(map1.equals(map1));
	}
	@Test
	public void testOtherTypeOfObject() {
		map1.put(1, 2);
		map1.put(2, 4);
		map1.put(3, 6);
		String stringObj = "This is a String object";
		assertFalse(map1.equals(stringObj));
	}
}