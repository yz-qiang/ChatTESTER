package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testDeepClone
public class TTT_testDeepClone {
@Test
public void testDeepClone() throws Exception {
    Integer[][][] arr = {{1, 2}, {3, 4}};
    Object[] objArr = {new Object[] {arr}, strArr};
    Object clonedObj = ArrayUtil.deepClone(Arrays.asList(objArr));
    assertEquals(objArr.length, clonedObj.length);
    for (int i = 0; i < objArr.length; i++) {
        assertTrue(clonedObj[i].equals(objArr[i]));
    }
    arr[0][0] = -1;
    assertNotEquals(objArr[0], clonedObj[0]);
}
}