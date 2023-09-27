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
public class FastDatePrinterTest_testEquals {
    private FastDatePrinter fastDatePrinter1;
    private FastDatePrinter fastDatePrinter2;
    private FastDatePrinter fastDatePrinter3;
    @Before
    public void setUp() throws Exception {
        fastDatePrinter1 = new FastDatePrinter("yyyy/MM/dd", TimeZone.getDefault(), Locale.US);
        fastDatePrinter2 = new FastDatePrinter("yyyy/MM/dd", TimeZone.getDefault(), Locale.US);
        fastDatePrinter3 = new FastDatePrinter("yyyy/MM/dd HH:mm:ss zzzz", TimeZone.getDefault(), Locale.UK);
    }
    @Test
    public void testEquals() {
        assertTrue(fastDatePrinter1.equals(fastDatePrinter2));
        assertFalse(fastDatePrinter1.equals(fastDatePrinter3));
        assertFalse(fastDatePrinter1.equals(null));
        assertFalse(fastDatePrinter1.equals(""));
    }
}