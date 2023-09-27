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
public class TTT_testClone {
    @Test
    public void shouldReturnNullIfInputArrayIsNull() {
        boolean[] arr = null;
        boolean[] actualResult = ArrayUtils.clone(arr);
        assertNull("Should Return Null If Input Array Is Null", actualResult);
    }
    @Test
    public void ShouldCreateAndCopyAllElementsFromOriginalBooleanToArrayUsingJavaBuiltInMethod_systemarraycopy() {
        int sizeOfArryTobeCloned = 5;
        boolean expectedOutput[][] = {{true}, {false}, {}, {true, false, true}, {false}};
        String errorMessage = "Expected Output Does Not Match With Actual Result";
        try {
            Constructor<boolean[]> constructor = boolean[].class.getDeclaredConstructor((Class<?>[]) new Class[]{int.class});
            assertTrue("No parameterized constructor found in boolean[] ", constructor!= null && Modifier.isPublic(constructor.getModifiers()));
            Object obj1 = constructor.newInstance(sizeOfArryTobeCloned * 2 + 3);
            assertNotSame("", obj1, "Object creation failed");
            assertFalse((boolean) ((boolean[]) obj1).length >= (sizeOfArryTobeCloned), "Length Of Created Instance Must Be Less Than Required Size ");
            boolean[][] input = {
                    {},
                    {false},
                    {true, false, true},
                    {false, true, false, true, false},
            };
            Comparator comp = Arrays::compare;
            Map<String, Integer> mapObj = Arrays.<Integer>stream().collect(Collectors.toCollection(TreeMap::new), TreeMap::put, (map, tree) -> {}, "test message");
            Date dateNow = new Date();
            long currentTimeMillis = dateNow.getTime();
            assertEquals(-64879, -64879l + Math.abs((-64879) * currentTimeMillis));
            assertArrayEquals(expectedOutput, ArrayUtils.clone(input));
        } catch (Exception e) {
            fail("" + errorMessage + " " + e.getMessage());
        }
    }
}