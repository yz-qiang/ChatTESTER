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
public class TestDurationFormatUtils_testLexx {
    @Test
    public void testLexxWithValidInput(){
        String validInput1 = "'a'yyMMddHHmmssSS";
        String validInput2 = "yyyyMMddHHmmss";
        Token[] result1 = DurationFormatUtils.lexx(validInput1);
        Token[] result2 = DurationFormatUtils.lexx(validInput2);
        assertEquals('a',result1[0].getValue());
        assertEquals('y',result1[1].getValue());
        assertEquals('y',result1[2].getValue());
        assertEquals('M',result1[3].getValue());
        assertEquals('M',result1[4].getValue());
        assertEquals('d',result1[5].getValue());
        assertEquals('d',result1[6].getValue());
        assertEquals('H',result1[7].getValue());
        assertEquals('H',result1[8].getValue());
        assertEquals('m',result1[9].getValue());
        assertEquals('m',result1[10].getValue());
        assertEquals('s',result1[11].getValue());
        assertEquals('s',result1[12].getValue());
        assertEquals('S',result1[13].getValue());
        assertEquals('y',result2[0].getValue());
        assertEquals('y',result2[1].getValue());
        assertEquals('y',result2[2].getValue());
        assertEquals('y',result2[3].getValue());
        assertEquals('M',result2[4].getValue());
        assertEquals('M',result2[5].getValue());
        assertEquals('d',result2[6].getValue());
        assertEquals('d',result2[7].getValue());
        assertEquals('H',result2[8].getValue());
        assertEquals('H',result2[9].getValue());
        assertEquals('m',result2[10].getValue());
        assertEquals('m',result2[11].getValue());
        assertEquals('s',result2[12].getValue());
        assertEquals('s',result2[13].getValue());
    }
    @Test
    public void testLexxWithInvalidInput(){
        String invalidInput1 = "'aaa'yyMMddHHmmssSS";
        String invalidInput2 = "yyyyMMddHHmmss'";
        try{
              DurationFormatUtils.lexx(invalidInput1);
              fail("Expected an IllegalArgumentException");
           } catch (IllegalArgumentException e){
               assertEquals("Unmatched quote in format: "+invalidInput1,e.getMessage());
           }
           try{
              DurationFormatUtils.lexx(invalidInput2);
              fail("Expected an IllegalArgumentException");
           }catch (IllegalArgumentException e){
               assertEquals("Unmatched quote in format: "+invalidInput2,e.getMessage());
           }
    }
}