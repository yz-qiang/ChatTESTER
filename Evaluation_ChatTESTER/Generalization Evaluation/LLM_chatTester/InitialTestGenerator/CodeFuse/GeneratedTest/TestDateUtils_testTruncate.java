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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest###testTruncate
public class TestDateUtils_testTruncate {
    private Calendar cal1;
    private Calendar cal2;
    private Calendar cal3;
    @Before
    public void setup(){
         cal1 = new GregorianCalendar(20222, Calendar.JANUARY, 5, 6, 8, 47, 39);
         cal2 = new GregorianCalendar(20222, Calendar.MARCH, 10, 12, 15, 23);
         cal3 = new GregorianCalendar(20222, Calendar.DECEMBER, 30, 23, 1, 59);
    }
    @Test
    public void testTruncateWithValidInputs() throws Exception{
        assertEquals(new GregorianCalendar(20222, Calendar.JANUARY, 1, 1, 0, 0), DateUtils.truncate(cal1, Calendar.MONTH));
        assertEquals(new GregorianCalendar(20222, Calendar.MARCH, 1, 1, 0, 0), DateUtils.truncate(cal2, Calendar.DAY_OF_YEAR));
        assertEquals(new GregorianCalendar(20222, Calendar.DECEMBER, 30, 1, 0, 0), DateUtils.truncate(cal3, Calendar.HOUR));
    }
    @Test
    public void testTruncateWithInvalidInputs() throws Exception{
        try {
            DateUtils.truncate(null, Calendar.MINUTE);
            fail("Expected exception was not thrown.");
        } catch (IllegalArgumentException e){
        }
    }
    @Test
    public void testTruncateWithBoundaryValues() throws Exception{
        assertEquals(new GregorianCalendar(20222, Calendar.JANUARY, 1, 1, 0, 0), DateUtils.truncate(new GregorianCalendar(20222, Calendar.JANUARY, 1, 1, 0, 0), Calendar.SECOND));
        assertEquals(new GregorianCalendar(20222, Calendar.DECEMBER, 31, 23, 59, 59), DateUtils.truncate(new GregorianCalendar(20222, Calendar.DECEMBER, 31, 23, 59, 59), Calendar.MILLISECOND));
    }
}