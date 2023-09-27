package org.apache.commons.lang3.time;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.test.SystemDefaults;
import org.apache.commons.lang3.test.SystemDefaultsSwitch;
import org.junit.Rule;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest###testEquals
@RunWith(JUnit4.class)
public class TestEquals_testEquals {
    @Rule
    public SystemDefaultsSwitch defaultsSwitcher = new SystemDefaultsSwitch("en_US");
    @Test
    public void testEqual() throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd HHmmssSSS", Locale.ENGLISH);
        Date d1 = sdf1.parse("20210905 163728123");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss zzz", Locale.UK);
        Date d2 = sdf2.parse("Wed Sep 05 2021 04:37:28 GMT+00:00");
        assertTrue((new FastDatePrinter("", null, Locale.ENGLISH)).equals(null));
        assertFalse((new FastDatePrinter("", null, Locale.ENGLISH)).equals(""));
    }
}