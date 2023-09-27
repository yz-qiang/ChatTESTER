package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/CharSetTest###testGetInstance
public class CharSetTest_testGetInstance {
    private static CharSet charSet;
    @BeforeClass
    public static void setup() {
        charSet = CharSet.getInstance("a", "b");
    }
    @Test
    public void testGetInstanceWithValidInput() {
        assertNotNull(charSet);
        assertEquals(2, charSet.size());
        assertTrue(charSet.contains('a'));
        assertTrue(charSet.contains('b'));
    }
    @Test
    public void testGetInstanceWithInvalidInput() {
        CharSet result = CharSet.getInstance((String[])null);
        assertNull(result);
    }
    @Test
    public void testGetInstanceWithExistingCommonObject() {
        CharSet result = CharSet.getInstance("a", "b");
        assertSame(charSet, result);
    }
    @Test
    public void testGetInstanceWithNewObject() {
        CharSet result = CharSet.getInstance("c", "d");
        assertNotSame(charSet, result);
        assertEquals(2, result.size());
        assertTrue(result.contains('c'));
        assertTrue(result.contains('d'));
    }
}