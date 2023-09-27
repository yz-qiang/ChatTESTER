package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArrayUtilsTest###testClone
public class ArrayUtilsTest_testClone {
    private static ArrayUtils arrayUtils;
    @BeforeClass
    public static void setUp(){
         arrayUtils = new ArrayUtils();
    }
    @Test
    public void testCloneWithNullInput(){
        assertNull("The output should be null", arrayUtils.clone((boolean[])null));
    }
    @Test
    public void testCloneWithEmptyArray(){
        boolean[] emptyArr = {};
        boolean[] clonedArr = arrayUtils.clone(emptyArr);
        assertNotNull("Output should not be null",clonedArr);
        assertEquals("Length of both arrays should match", emptyArr.length, clonedArr.length);
        assertNotSame("Both arrays should have different references", emptyArr, clonedArr);
    }
    @Test
    public void testCloneWithAllTrueValues(){
        boolean[] arr = {true, true};
        boolean[] clonedArr = arrayUtils.clone(arr);
        assertNotNull("Output should not be null",clonedArr);
        assertEquals("Length of both arrays should match", arr.length, clonedArr.length);
        assertNotSame("Both arrays should have different references", arr, clonedArr);
        assertArrayEquals("Contents of both arrays should match", arr, clonedArr);
    }
    @Test
    public void testCloneWithAllFalseValues(){
        boolean[] arr = {false, false};
        boolean[] clonedArr = arrayUtils.clone(arr);
        assertNotNull("Output should not be null",clonedArr);
        assertEquals("Length of both arrays should match", arr.length, clonedArr.length);
        assertNotSame("Both arrays should have different references", arr, clonedArr);
        assertArrayEquals("Contents of both arrays should match", arr, clonedArr);
    }
    @Test
    public void testCloneWithMixedValues(){
        boolean[] arr = {true, false, true, false, true};
        boolean[] clonedArr = arrayUtils.clone(arr);
        assertNotNull("Output should not be null",clonedArr);
        assertEquals("Length of both arrays should match", arr.length, clonedArr.length);
        assertNotSame("Both arrays should have different references", arr, clonedArr);
        assertArrayEquals("Contents of both arrays should match", arr, clonedArr);
    }
}