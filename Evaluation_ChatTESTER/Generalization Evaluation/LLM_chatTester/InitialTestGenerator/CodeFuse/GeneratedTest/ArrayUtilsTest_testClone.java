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
    @Test
    public void testCloneBooleanArray(){
        assertNull("The output should be null when input is null", ArrayUtils.clone((boolean[])null));
        boolean[] emptyArr = {};
        assertArrayEquals("Empty arrays are equal after cloning", emptyArr, ArrayUtils.clone(emptyArr));
        boolean[] arr = {true, false};
        assertArrayEquals("Non-empty arrays are not equal after cloning", arr, ArrayUtils.clone(arr));
    }
}