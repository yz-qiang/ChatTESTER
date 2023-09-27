package org.apache.commons.lang3.time;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/FastDateParserTest###testEquals
public class FastDateParserTest_testEquals {
  @Test
  public void testEqualsMethod(){
      FastDateParser fdp1 = new FastDateParser("dd/MM/yyyy", TimeZone.getDefault(), Locale.US);
      FastDateParser fdp2 = new FastDateParser("dd/MM/yyyy", TimeZone.getDefault(), Locale.US);
      FastDateParser fdp3 = new FastDateParser("mm/yy", TimeZone.getDefault(), Locale.UK);
      assertTrue(fdp1.equals(fdp2));
      assertFalse(fdp1.equals(fdp3));
      assertFalse(fdp1.equals("String"));
  }
}