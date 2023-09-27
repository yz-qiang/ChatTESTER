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
public class TTT_testTruncate {
@Test
public void testTruncate() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    GregorianCalendar calendar = new GregorianCalendar(2019, Calendar.JANUARY, 15, 14, 30, 0);
    Date date = sdf.parse("2019-01-15 14:30:00");
    Calendar expectedYearLevel = new GregorianCalendar(2019, Calendar.JANUARY, 1, 0, 0, 0);
    assertEquals(expectedYearLevel, DateUtils.truncate(calendar, Calendar.YEAR));
    Calendar expectedMonthLevel = new GregorianCalendar(2019, Calendar.FEBRUARY, 1, 0, 0, 0);
    assertEquals(expectedMonthLevel, DateUtils.truncate(calendar, Calendar.MONTH));
    Calendar expectedDayLevel = new GregorianCalendar(2019, Calendar.MARCH, 1, 0, 0, 0);
    assertEquals(expectedDayLevel, DateUtils.truncate(calendar, Calendar.DAY_OF_WEEK));
    Calendar expectedHourLevel = new GregorianCalendar(2019, Calendar.APRIL, 1, 14, 0, 0);
    assertEquals(expectedHourLevel, DateUtils.truncate(calendar, Calendar.HOUR_OF_DAY));
    Calendar expectedMinuteLevel = new GregorianCalendar(2019, Calendar.MAY, 1, 14, 30, 0);
    assertEquals(expectedMinuteLevel, DateUtils.truncate(calendar, Calendar.MINUTE));
    Calendar expectedSecondLevel = new GregorianCalendar(2019, Calendar.JUNE, 1, 14, 30, 0);
    assertEquals(expectedSecondLevel, DateUtils.truncate(calendar, Calendar.SECOND));
    Calendar expectedMillisecondLevel = new GregorianCalendar(2019, Calendar.JULY, 1, 14, 30, 0);
    assertEquals(expectedMillisecondLevel, DateUtils.truncate(calendar, Calendar.MILLISECOND));
    try {
        DateUtils.truncate((Calendar)null, Calendar.YEAR);
        fail("Expected IllegalArgumentException when passing null argument.");
    } catch (IllegalArgumentException e) {}
    try {
        DateUtils.truncate(calendar, -1);
        fail("Expected IllegalArgumentException when passing invalid field value.");
    } catch (IllegalArgumentException e) {}
}
}