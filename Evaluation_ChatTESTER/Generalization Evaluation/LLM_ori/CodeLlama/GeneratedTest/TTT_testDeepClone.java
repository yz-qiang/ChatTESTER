package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testDeepClone
public class TTT_testDeepClone {
@Test
public void testDeepClone() {
    Integer[][] original = {{1, 2}, {3, 4}};
    Integer[][] cloned = (Integer[][]) ArrayUtil.deepClone(original);
    assertEquals(original.length, cloned.length);
    for (int i = 0; i < original.length; i++) {
        assertTrue(Arrays.equals(original[i], cloned[i]));
    }
}
}