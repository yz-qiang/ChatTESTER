package org.apache.commons.lang3.text;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/text/StrBuilderTest###testSetCharAt
public class TTT_testSetCharAt {
@Test
public void testSetCharAt() throws Exception {
    StrBuilder builder = new StrBuilder("hello");
    assertEquals('h', builder.charAt(0));
    builder.setCharAt(0, 'H');
    assertEquals('H', builder.charAt(0));
    try {
        builder.setCharAt(-1, 'x');
        fail("Expected StringIndexOutOfBoundsException");
    } catch (StringIndexOutOfBoundsException e) {
    }
    try {
        builder.setCharAt(builder.length(), 'y');
        fail("Expected StringIndexOutOfBoundsException");
    } catch (StringIndexOutOfBoundsException e) {
    }
}
}