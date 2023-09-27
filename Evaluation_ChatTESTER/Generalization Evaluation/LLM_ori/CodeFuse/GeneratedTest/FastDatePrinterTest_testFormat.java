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
public class FastDatePrinterTest_testFormat {
  @Test
  public void testFormat() throws Exception {
      FastDatePrinter fastDatePrinter = new FastDatePrinter("yyyy/MM/dd", TimeZone.getDefault(), Locale.US);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      sdf.setTimeZone(TimeZone.getDefault());
      assertEquals(sdf.format(new GregorianCalendar().getTime()), fastDatePrinter.format(new GregorianCalendar().getTime()));
      try{
          fastDatePrinter.format(null);
          fail("Expected NullPointerException not thrown.");
      } catch(NullPointerException e){
      }
  }
}