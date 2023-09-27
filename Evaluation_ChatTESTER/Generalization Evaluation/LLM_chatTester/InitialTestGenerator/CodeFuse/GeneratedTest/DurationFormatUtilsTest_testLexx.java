package org.apache.commons.lang3.time;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testLexx
public class DurationFormatUtilsTest_testLexx {
    private static DurationFormatUtils dfu;
    @BeforeClass
    public static void setUp(){
         dfu = new DurationFormatUtils(); 
    }
    @Test
    public void testLexxWithValidInput1() throws Exception{
        String input = "'a'yyMMddHHmmssSS";
        Token[] expectedOutput = {new Token("a"), new Token('y',2), new Token('M'), new Token('d',2), new Token('H'), new Token('m'), new Token('s',2)};
        assertArrayEquals(expectedOutput, dfu.lexx(input));
    }
    @Test
    public void testLexxWithEmptyString() throws Exception{
        String input = "";
        Token[] expectedOutput = {};
        assertArrayEquals(expectedOutput, dfu.lexx(input));
    }
    @Test
    public void testLexxWithInvalidQuote() throws Exception{
        try {
           dfu.lexx("'abcd");
          fail("Expected exception not thrown.");
       } catch (IllegalArgumentException e){
             assertEquals("Unmatched quote in format: abcd",e.getMessage());
       }
    }
    @Test
    public void testLexxWithMultipleTokensOfDifferentTypes() throws Exception{
        String input = "yyyyMMddHHmmss";
        Token[] expectedOutput = {new Token('y',4), new Token('M',2), new Token('d',2), new Token('H'), new Token('m'), new Token('s',2)};
        assertArrayEquals(expectedOutput,dfu.lexx(input));
    }
    @Test
    public void testLexxWithOnlyOneToken() throws Exception{
        String input = "yyyy";
        Token[] expectedOutput = {new Token('y',4)};
        assertArrayEquals(expectedOutput,dfu.lexx(input));
    }
    @Test
    public void testLexxWithNoToken() throws Exception{
        String input = "abcdefghijklmnopqrstuvwxyz";
        Token[] expectedOutput = {new Token("abcdefghijklmnopqrstuvwxyz")};
        assertArrayEquals(expectedOutput,dfu.lexx(input));
    }
}