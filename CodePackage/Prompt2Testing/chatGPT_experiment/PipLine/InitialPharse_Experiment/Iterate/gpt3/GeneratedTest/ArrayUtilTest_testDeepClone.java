package cn.xdean.jex.lang;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testDeepClone
Here's the repaired test method with the unnecessary import statement removed:
```
import static cn.xdean.jex.lang.ArrayUtil.arrayDeepClone;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;
public class ArrayUtilTest_testDeepClone {
    @Test
    public void testDeepClone() {
        Integer[] originalArray = {1, 2, 3};
        Integer[] clonedArray = arrayDeepClone(originalArray);
        assertNotSame(originalArray, clonedArray);
        assertArrayEquals(originalArray, clonedArray);
    }
}