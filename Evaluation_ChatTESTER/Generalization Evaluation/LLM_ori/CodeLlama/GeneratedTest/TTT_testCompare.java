package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
public class TTT_testCompare {
@Test
public void testCompare_sameLengthDifferentValues() {
    Integer[] array1 = {1, 2, 3};
    Integer[] array2 = {4, 5, 6};
    assertEquals(-1, ArrayUtil.compare(array1, array2));
}
@Test
public void testCompare_differentLengths() {
    Integer[] array1 = {1, 2, 3};
    Integer[] array2 = {4, 5};
    try {
        ArrayUtil.compare(array1, array2);
        fail();
    } catch (IllegalArgumentException e) {
    }
}
@Test
public void testCompare_nullValueInFirstArray() {
    Integer[] array1 = {1, null, 3};
    Integer[] array2 = {4, 5, 6};
    try {
        ArrayUtil.compare(array1, array2);
        fail();
    } catch (NullPointerException e) {
    }
}
@Test
public void testCompare_nullValueInSecondArray() {
    Integer[] array1 = {1, 2, 3};
    Integer[] array2 = {4, null, 6};
    try {
        ArrayUtil.compare(array1, array2);
        fail();
    } catch (NullPointerException e) {
    }
}
@Test
public void testCompare_equalArrays() {
    Integer[] array1 = {1, 2, 3};
    Integer[] array2 = {1, 2, 3};
    assertEquals(0, ArrayUtil.compare(array1, array2));
}
}