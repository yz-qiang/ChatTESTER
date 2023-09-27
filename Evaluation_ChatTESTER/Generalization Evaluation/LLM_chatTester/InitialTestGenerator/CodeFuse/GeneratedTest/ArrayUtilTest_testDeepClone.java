package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testDeepClone
public class ArrayUtilTest_testDeepClone {
    @Test
    public void testDeepClone(){
        assertNull(deepClone(null));
        Integer[] emptyArr = {};
        assertTrue(isEmpty(deepClone(emptyArr));
        String[] singleElementArr = {"Hello"};
        String[] cloneSingleElementArr = deepClone(singleElementArr);
        assertEquals("Hello", cloneSingleElementArr[0]);
        Integer[][][] multiDimensionArr = {{1,2},{3,4}};
        Integer[][][] cloneMultiDimensionArr = deepClone(multiDimensionArr);
        assertNotSame(multiDimensionArr,cloneMultiDimensionArr);
        assertEquals(multiDimensionArr[0][0], cloneMultiDimensionArr[0][0]);
        assertEquals(multiDimensionArr[0][1], cloneMultiDimensionArr[0][1]);
        assertEquals(multiDimensionArr[1][0], cloneMultiDimensionArr[1][0]);
        assertEquals(multiDimensionArr[1][1], cloneMultiDimensionArr[1][1]);
   }
}