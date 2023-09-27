package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/CharSetTest###testGetInstance
public class TTT_testGetInstance {
    @Test
    public void testGetInstance() throws Exception {
        assertNull(CharSet.getInstance((String[]) null));
        assertNotNull(CharSet.getInstance());
        CharSet charSet = CharSet.getInstance("abc");
        assertNotNull(charSet);
        assertEquals(1, charSet.size());
        assertTrue(charSet.contains('a'));
        assertTrue(charSet.contains('b'));
        assertTrue(charSet.contains('c'));
        charSet = CharSet.getInstance("abc", "def");
        assertNotNull(charSet);
        assertEquals(2, charSet.size());
        assertTrue(charSet.contains('a'));
        assertTrue(charSet.contains('b'));
        assertTrue(charSet.contains('c'));
        assertTrue(charSet.contains('d'));
        assertTrue(charSet.contains('e'));
        assertTrue(charSet.contains('f'));
        try {
            CharSet.getInstance("invalid_input");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
}