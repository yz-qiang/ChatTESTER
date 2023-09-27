package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testCompare
public class ArrayUtilTest_testCompare {
    @Test
    public void testCompareEqualLengthDifferentValues(){
        Integer[] arr1 = {2,3};
        Integer[] arr2 = {4,5};
        assertTrue(ArrayUtil.compare(arr1, arr2) > 0); 
    }
    @Test
    public void testSameValueInBothArrays(){
        String[] arr1 = {"hello", "world"};
        String[] arr2 = {"hello", "world"};
        assertEquals(0, ArrayUtil.compare(arr1, arr2)); 
    }
    @Test(expected=IllegalArgumentException.class)
    public void testUnequalLength(){
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {1,2,3,4};
        ArrayUtil.compare(arr1, arr2); 
    }
}