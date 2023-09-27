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
public class TTT_testRound {
@Test
public void testRound() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    GregorianCalendar calendar = new GregorianCalendar(2019, Calendar.JANUARY, 15, 14, 30, 0);
    Date date = sdf.parse("2019-01-15 14:30:00");
    assertEquals(calendar.getTime(), DateUtils.round(date, Calendar.MINUTE));
    assertEquals(new GregorianCalendar(2019, Calendar.JANUARY, 15, 14, 0, 0).getTime(), DateUtils.round(date, Calendar.HOUR_OF_DAY));
    assertEquals(new GregorianCalendar(2019, Calendar.JANUARY, 16, 0, 0, 0).getTime(), DateUtils.round(date, Calendar.DATE));
    assertEquals(new GregorianCalendar(2019, Calendar.FEBRUARY, 8, 0, 0, 0).getTime(), DateUtils.round(date, Calendar.WEEK_OF_YEAR));
    assertEquals(new GregorianCalendar(2019, Calendar.MARCH, 1, 0, 0, 0).getTime(), DateUtils.round(date, Calendar.MONTH));
    assertEquals(new GregorianCalendar(2020, Calendar.JANUARY, 1, 0, 0, 0).getTime(), DateUtils.round(date, Calendar.YEAR));
}
}