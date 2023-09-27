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
    public void testGetInstanceWithOneArgumentAndExistingObject() {
        assertSame(charSet, CharSet.getInstance("a", "b"));
    }
    @Test
    public void testGetInstanceWithMultipleArguments() {
        assertNotNull(CharSet.getInstance("c", "d"));
    }
    @Test
    public void testGetInstanceWithDifferentArguments() {
        assertNotSame(charSet, CharSet.getInstance("e", "f"));
    }
    @Test
    public void testGetInstanceWithEmptyArray() {
        assertNull(CharSet.getInstance());
    }
    @Test
    public void testGetInstanceWithNullInput() {
        assertNull(CharSet.getInstance((String[])null));
    }
}