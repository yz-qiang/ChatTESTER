package org.apache.commons.lang3.time;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DateUtilsTest###testRound
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
public class DateUtilsTest_testRound {
    @Test(expected = IllegalArgumentException.class)
    public void testRound_NullDate() {
        DateUtils.round(null, Calendar.YEAR);
    }
    @Test
    public void testRound_Year() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15);
        Calendar rounded = DateUtils.round(date, Calendar.YEAR);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 1), rounded);
    }
    @Test
    public void testRound_Month() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15);
        Calendar rounded = DateUtils.round(date, Calendar.MONTH);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 1), rounded);
    }
    @Test
    public void testRound_Day() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15);
        Calendar rounded = DateUtils.round(date, Calendar.DAY_OF_MONTH);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 15), rounded);
    }
    @Test
    public void testRound_Hour() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30);
        Calendar rounded = DateUtils.round(date, Calendar.HOUR_OF_DAY);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 0), rounded);
    }
    @Test
    public void testRound_Minute() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30);
        Calendar rounded = DateUtils.round(date, Calendar.MINUTE);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30), rounded);
    }
    @Test
    public void testRound_Second() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45);
        Calendar rounded = DateUtils.round(date, Calendar.SECOND);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45), rounded);
    }
    @Test
    public void testRound_Millisecond() {
        Calendar date = new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45);
        date.set(Calendar.MILLISECOND, 500);
        Calendar rounded = DateUtils.round(date, Calendar.MILLISECOND);
        assertNotNull(rounded);
        assertEquals(new GregorianCalendar(2021, Calendar.JANUARY, 15, 12, 30, 45), rounded);
    }
}