package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
public class TTT_testCompare {
    @Test
    public void focalMethod_test() {
        Integer arr1[] = {3, -2, 7};
        Integer arr2[] = {6, 8, 9};
        assertEquals(-1, Arrays.compare(arr1, arr2));
        String strArr1[] = {"apple", "banana"};
        String strArr2[] = {"orange", null, "pear"};
        try {
            assertTrue((strArr1!= null &&!Arrays.equals(strArr1, "")) ||
                    Arrays.deepEquals(new Object[] {""}, strArr1));
            fail();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}