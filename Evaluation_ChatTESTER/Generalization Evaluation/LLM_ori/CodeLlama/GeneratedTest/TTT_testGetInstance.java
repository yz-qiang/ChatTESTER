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
public void testGetInstance() {
    assertNull(CharSet.getInstance((String[])null));
    assertNotNull(CharSet.getInstance());
    String[] singleInput = {"abc"};
    CharSet charSet = CharSet.getInstance(singleInput);
    assertNotNull(charSet);
    assertEquals("abc", charSet.toString());
    String[] multipleInputs = {"abc", "def", "ghi"};
    charSet = CharSet.getInstance(multipleInputs);
    assertNotNull(charSet);
    assertEquals("abcdefghi", charSet.toString());
    try {
        CharSet.getInstance(new Object[]{});
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {
    }
}
}