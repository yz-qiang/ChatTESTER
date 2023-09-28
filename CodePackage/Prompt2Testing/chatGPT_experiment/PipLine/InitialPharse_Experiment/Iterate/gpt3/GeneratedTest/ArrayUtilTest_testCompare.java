package cn.xdean.jex.lang;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
public class ArrayUtilTest_testCompare {
    @Test
    public void testCompare() {
        Integer[] a = {1, 2, 3};
        Integer[] b = {1, 2, 3};
        Integer[] c = {1, 2, 4};
        Integer[] d = {1, 2};
        assertEquals(0, compare(a, b));
        assertTrue(compare(a, c) < 0);
        assertTrue(compare(c, a) > 0);
        try {
            compare(a, d);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
}