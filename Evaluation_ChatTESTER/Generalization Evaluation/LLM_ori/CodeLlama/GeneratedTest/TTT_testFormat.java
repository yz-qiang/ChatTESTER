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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDatePrinterTest###testFormat
public class TTT_testFormat {
@Test
public void testFormat() throws ParseException {
    FastDatePrinter printer = new FastDatePrinter("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.US);
    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");
    Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-02");
    Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03");
    assertEquals("2022-01-01 00:00:00", printer.format(date1));
    assertEquals("2022-01-02 00:00:00", printer.format(date2));
    assertEquals("2022-01-03 00:00:00", printer.format(date3));
}
}