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
public class TTT_testEquals {
@Test
public void testEquals() throws Exception {
    FastDatePrinter printer1 = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
    FastDatePrinter printer2 = new FastDatePrinter("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"), Locale.UK);
    assertTrue(printer1.equals(printer2));
    FastDatePrinter printer3 = new FastDatePrinter("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.US);
    assertFalse(printer1.equals(printer3));
    FastDatePrinter printer4 = new FastDatePrinter("yyyy-MM-dd", TimeZone.getTimeZone("America/New_York"), Locale.US);
    assertFalse(printer1.equals(printer4));
    FastDatePrinter printer5 = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.FRANCE);
    assertFalse(printer1.equals(printer5));
}
}