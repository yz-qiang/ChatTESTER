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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testFormatDurationWords
public class DurationFormatUtilsTest_testFormatDurationWords {
    @BeforeClass
    public static void setUp(){
    }
    @Test
    public void testFormatDurationWordsWithSuppressedLeadingAndTrailingZeros() throws Exception{
        assertEquals("2 days 5 hours 46 minutes 40 seconds", DurationFormatUtils.formatDurationWords(187924000000l, true, true));
    }
    @Test
    public void testFormatDurationWordsWithoutSuppressedLeadingOrTrailingZeros() throws Exception{
        assertEquals("0 days 0 hours 0 minutes 0 seconds", DurationFormatUtils.formatDurationWords(0l, false, false));
    }
    @Test
    public void testFormatDurationWordsWithOnlyDays() throws Exception{
        assertEquals("1 day", DurationFormatUtils.formatDurationWords(86400000000l, true, true));
    }
    @Test
    public void testFormatDurationWordsWithOnlyMinutes() throws Exception{
        assertEquals("120 minutes", DurationFormatUtils.formatDurationWords(720000000l, true, true));
    }
    @Test
    public void testFormatDurationWordsWithOnlySeconds() throws Exception{
        assertEquals("30 seconds", DurationFormatUtils.formatDurationWords(3000000l, true, true));
    }
    @Test
    public void testFormatDurationWordsWithAllUnits() throws Exception{
        assertEquals("1 year 1 month 1 week 1 day 1 hour 1 minute 1 second", DurationFormatUtils.formatDurationWords(349322160000000l, false, false));
    }
    @Test
    public void testFormatDurationWordsWithNoInput() throws Exception{
        try {
            DurationFormatUtils.formatDurationWords(-1l, true, true);
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e){
            assertEquals("Invalid argument.", e.getMessage());
        }
    }
}