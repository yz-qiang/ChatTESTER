package org.apache.commons.lang3.time;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest###testEquals
public class FastDateParserTest_testEquals {
    private static FastDateParser parser;
    @BeforeClass
    public static void setUp() throws Exception{
        parser = new FastDateParser("yyyy/MM/dd", TimeZone.getDefault(), Locale.US);
    }
    @Test
    public void testEqualsWithSameObject(){
        assertTrue(parser.equals(parser));
    }
    @Test
    public void testEqualsWithDifferentPatterns(){
        FastDateParser differentPatternParser = new FastDateParser("dd/MM/yyyy", TimeZone.getDefault(), Locale.US);
        assertFalse(parser.equals(differentPatternParser));
    }
    @Test
    public void testEqualsWithDifferentTimeZones(){
        FastDateParser differentTimezoneParser = new FastDateParser("yyyy/MM/dd", TimeZone.getTimeZone("UTC"), Locale.US);
        assertFalse(parser.equals(differentTimezoneParser));
    }
    @Test
    public void testEqualsWithDifferentLocales(){
        FastDateParser differentLocaleParser = new FastDateParser("yyyy/MM/dd", TimeZone.getDefault(), Locale.CANADA);
        assertFalse(parser.equals(differentLocaleParser));
    }
    @Test
    public void testEqualsWithNull(){
        assertFalse(parser.equals(null));
    }
}