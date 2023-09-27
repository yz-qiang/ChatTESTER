package org.apache.commons.lang3.time;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import org.apache.commons.lang3.test.SystemDefaults;
import org.apache.commons.lang3.test.SystemDefaultsSwitch;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest###testRound
public class TestRoundMethod_testRound {
    private Calendar cal1;
    private Calendar cal2;
    private Calendar cal3;
    private Calendar cal4;
    private Calendar cal5;
    @Before
    public void setUp(){
        cal1 = new GregorianCalendar(20222, Calendar.JANUARY, 1, 8, 9, 36, 7);
        cal2 = new GregorianCalendar(20222, Calendar.FEBRUARY, 15, 12, 15, 30);
        cal3 = new GregorianCalendar(20222, Calendar.MAY, 1, 1, 12, 0);
        cal4 = new GregorianCalendar(20222, Calendar.DECEMBER, 31, 23, 59, 59);
        cal5 = new GregorianCalendar(20222, Calendar.NOVEMBER, 15, 12, 12, 30);
    }
    @Test
    public void testRoundWithValidInputs() throws Exception{
        assertEquals(new GregorianCalendar(20222, Calendar.JANUARY, 1, 8, 10, 0), DateUtils.round(cal1, Calendar.HOUR));
        assertEquals(new GregorianCalendar(20222, Calendar.FEBRUARY, 15, 12, 16, 0), DateUtils.round(cal2, Calendar.HOUR));
        assertEquals(new GregorianCalendar(20222, Calendar.MAY, 1, 1, 12, 0), DateUtils.round(cal3, Calendar.DAY_OF_MONTH));
        assertEquals(new GregorianCalendar(20222, Calendar.DECEMBER, 31, 23, 0, 0), DateUtils.round(cal4, Calendar.DATE));
        assertEquals(new GregorianCalendar(20222, Calendar.NOVEMBER, 15, 12, 12, 0), DateUtils.round(cal5, Calendar.MINUTE));
    }
    @Test
    public void testRoundWithInvalidInputs() throws Exception{
        try {
            DateUtils.round(null, Calendar.SECOND);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e){
            assertEquals("The date must not be null", e.getMessage());
        }
    }
    @Test
    public void testRoundWithEdgeCases() throws Exception{
        assertEquals(new GregorianCalendar(20222, Calendar.JANUARY, 1, 8, 9, 36, 0), DateUtils.round(cal1, Calendar.MINUTE));
        assertEquals(new GregorianCalendar(20222, Calendar.FEBRUARY, 15, 12, 15, 30), DateUtils.round(cal2, Calendar.MINUTE));
        assertEquals(new GregorianCalendar(20222, Calendar.MAY, 1, 1, 12, 0), DateUtils.round(cal3, Calendar.MILLISECOND));
        assertEquals(new GregorianCalendar(20222, Calendar.DECEMBER, 31, 23, 59, 0), DateUtils.round(cal4, Calendar.SECOND));
        assertEquals(new GregorianCalendar(20222, Calendar.NOVEMBER, 15, 12, 12, 30), DateUtils.round(cal5, Calendar.WEEK_OF_MONTH));
    }
}