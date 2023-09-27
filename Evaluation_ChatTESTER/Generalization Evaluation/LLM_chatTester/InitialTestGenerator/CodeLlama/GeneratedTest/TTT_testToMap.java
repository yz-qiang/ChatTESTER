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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArrayUtilsTest###testToMap
public class TTT_testToMap {
@Test
public void testToMap() {
    Object[] validInputs = new Object[]{new String[]{"key", "value"}, new Integer[]{1, 2}, new Double[]{3.4, 5.6}};
    Map<String, String> expectedOutput = new HashMap<>();
    expectedOutput.put("key", "value");
    assertEquals(expectedOutput, ArrayUtils.toMap(validInputs));
    try {
        ArrayUtils.toMap(null);
        fail("Expected NullPointerException when passing null argument.");
    } catch (NullPointerException e) {}
    try {
        ArrayUtils.toMap(new Object[]{});
        fail("Expected IllegalArgumentException when passing empty array.");
    } catch (IllegalArgumentException e) {}
    try {
        ArrayUtils.toMap(new Object[]{new Object(){}});
        fail("Expected IllegalArgumentException when passing non-array element.");
    } catch (IllegalArgumentException e) {}
    try {
        ArrayUtils.toMap(new Object[]{new Object[]{}});
        fail("Expected IllegalArgumentException when passing array element with length less than 2.");
    } catch (IllegalArgumentException e) {}
}
}