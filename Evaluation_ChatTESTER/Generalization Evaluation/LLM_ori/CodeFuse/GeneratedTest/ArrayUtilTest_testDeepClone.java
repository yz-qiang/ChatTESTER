package cn.xdean.jex.lang;
import org.junit.Test;
import static cn.xdean.jex.lang.collection.ArrayUtil.*;
import static org.junit.Assert.*;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/lang/ArrayUtilTest###testDeepClone
public class ArrayUtilTest_testDeepClone {
    @Test
    public void testDeepClone(){
        Integer[] arr1 = {1,2,3};
        String[] arr2 = {"a","b"};
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        Object[] arr3 = {arr1,list,"c", "d"};
        try{
            assertTrue(Arrays.equals((Integer[]) ArrayUtil.deepClone(arr1), arr1));
            assertEquals(ArrayUtil.deepClone("test"), "test");
            assertTrue(Arrays.equals((String[]) ArrayUtil.deepClone(arr2), arr2));
            Object[] clonedArr3 = (Object[]) ArrayUtil.deepClone(arr3);
            assertNotSame(clonedArr3[0], arr1);
            assertNotSame(clonedArr3[1], list);
            assertEquals(clonedArr3[2], "c");
            assertEquals(clonedArr3[3], "d");
            assertFalse(clonedArr3[1] instanceof ArrayList<?>);
        }catch(Exception e){
           fail();
       }
   }
}