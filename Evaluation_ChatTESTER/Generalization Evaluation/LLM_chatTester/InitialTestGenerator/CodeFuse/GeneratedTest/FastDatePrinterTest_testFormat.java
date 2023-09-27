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
  private FastDatePrinter fastDatePrinter;
  @Before
  public void setUp() throws Exception {
      fastDatePrinter = new FastDatePrinter("yyyy/MM/dd HH:mm", TimeZone.getDefault(), Locale.US);
  }
  @After
  public void tearDown() throws Exception {}
  @Test
  public void testFormatWithValidInputs(){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      sdf.setTimeZone(TimeZone.getDefault());
      Date validDate = new GregorianCalendar(20222, Calendar.JANUARY, 1, 5, 9, 48).getTime();
      assertEquals(sdf.format(validDate), fastDatePrinter.format(validDate));
  }
  @Test
  public void testFormatWithNullInput(){
      try{
          fastDatePrinter.format(null);
          fail("Expected IllegalArgumentException not thrown.");
      } catch(IllegalArgumentException e){
      }
  }
  @Test
  public void testFormatWithInvalidInput(){
      try{
          fastDatePrinter.format("invalidDate");
          fail("Expected ParseException not thrown.");
      } catch(ParseException pe){
      }
  }
  @Test
  public void testFormatWithDifferentLocales(){
      FastDatePrinter fdpFR = new FastDatePrinter("yyyy/MM/dd HH:mm", TimeZone.getDefault(), Locale.FRANCE);
      SimpleDateFormat sdfFR = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      sdfFR.setTimeZone(TimeZone.getDefault());
      Date validDate = new GregorianCalendar(20222, Calendar.FEBRUARY, 7, 6, 12, 30).getTime();
      assertNotEquals(sdfFR.format(validDate), fastDatePrinter.format(validDate));
  }
}