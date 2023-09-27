package edu.jhu.prim.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.jhu.prim.util.IntJUnitUtils;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/IntObjectHashMapTest###testKeys
public class TTT_testKeys {
@Test
public void testKeys() {
    IntObjectHashMap map = new IntObjectHashMap();
    map.put("a", "apple");
    map.put("b", "ball");
    map.put("c", "cat");
    int[] actualKeys = map.keys();
    assertArrayEquals(new int[]{1, 2, 3}, actualKeys);
}
}