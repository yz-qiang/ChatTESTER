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
public void testToMap() throws Exception {
    String[] keys = {"key1", "key2"};
    Integer[] values = {1, 2};
    Object[] input = {keys, values};
    Map<String, Integer> expectedOutput = new HashMap<>();
    expectedOutput.put("key1", 1);
    expectedOutput.put("key2", 2);
    Map<String, Integer> actualOutput = ArrayUtils.toMap(input);
    assertEquals(expectedOutput, actualOutput);
    assertEquals(2, actualOutput.size());
    assertTrue(actualOutput.containsKey("key1"));
    assertTrue(actualOutput.containsValue(1));
    assertTrue(actualOutput.containsKey("key2"));
    assertTrue(actualOutput.containsValue(2));
}
}