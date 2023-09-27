package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
import cn.xdean.jex.lang.collection.ArrayUtil;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
public class TTT_testCompare {
    @Test
    public void testCompare() {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        assertEquals(0, ArrayUtil.compare(array1, array2));
        String[] array3 = {"apple", "banana"};
        String[] array4 = {"orange", "grape"};
        assertNotEquals(0, ArrayUtil.compare(array3, array4));
        Object[] array5 = null;
        Object[] array6 = {};
        try {
            ArrayUtil.compare(array5, array6);
            fail();
        } catch (IllegalArgumentException e) {
        }
        Object[] array7 = {};
        Object[] array8 = {};
        assertEquals(0, ArrayUtil.compare(array7, array8));
    }
}