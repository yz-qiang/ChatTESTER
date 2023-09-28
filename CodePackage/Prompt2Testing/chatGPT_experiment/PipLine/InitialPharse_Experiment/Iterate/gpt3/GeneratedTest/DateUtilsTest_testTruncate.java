package org.apache.commons.lang3.time;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest###testTruncate
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
public class DateUtilsTest_testTruncate {
    @Test(expected = IllegalArgumentException.class)
    public void testTruncateWithNullDate() {
        DateUtils.truncate(null, Calendar.YEAR);
    }
    @Test
    public void testTruncateWithYear() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.YEAR);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(0, truncated.get(Calendar.MONTH));
        assertEquals(1, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithMonth() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MONTH);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(1, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithDay() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.DAY_OF_MONTH);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(15, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithHour() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.HOUR_OF_DAY);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(15, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(12, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithMinute() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MINUTE);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(15, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(12, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithSecond() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.SECOND);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(15, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(12, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, truncated.get(Calendar.MINUTE));
        assertEquals(45, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
    @Test
    public void testTruncateWithMillisecond() {
        Calendar calendar = new GregorianCalendar(2021, Calendar.AUGUST, 15, 12, 30, 45);
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MILLISECOND);
        assertNotNull(truncated);
        assertEquals(2021, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.AUGUST, truncated.get(Calendar.MONTH));
        assertEquals(15, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(12, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, truncated.get(Calendar.MINUTE));
        assertEquals(45, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }
}