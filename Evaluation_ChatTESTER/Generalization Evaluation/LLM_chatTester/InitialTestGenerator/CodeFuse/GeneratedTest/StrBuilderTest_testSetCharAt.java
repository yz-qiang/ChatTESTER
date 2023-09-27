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
Below are some sample Junit tests for the `StrBuilder` class:
public class StrBuilderTest_testSetCharAt {
    private StrBuilder strBuilder;
    @Before
    public void setup(){
       strBuilder = new StrBuilder("Hello World"); 
    }
    @Test
    public void testSetCharAtWithValidInput() {
        assertEquals('H', strBuilder.buffer[0]);
        strBuilder.setCharAt(1,'a');
        assertEquals('a', strBuilder.buffer[1]);
    }
    @Test(expected=StringIndexOutOfBoundsException.class)
    public void testSetCharAtWithInvalidIndex() {
        strBuilder.setCharAt(-1, 'x');
    }
    @Test
    public void testSetCharAtWithBoundaryValues() {
        strBuilder.setCharAt(5, 'X');
        assertEquals('W', strBuilder.buffer[4]);
        assertEquals('X', strBuilder.buffer[5]);
    }
    @Test
    public void testSetCharAtWithLastPosition() {
        strBuilder.setCharAt(9, '!');
        assertEquals('d', strBuilder.buffer[8]);
        assertEquals('!', strBuilder.buffer[9]);
    }
}