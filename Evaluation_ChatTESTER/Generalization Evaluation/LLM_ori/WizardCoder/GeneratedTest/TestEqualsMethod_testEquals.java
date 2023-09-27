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
public 
class TestEqualsMethod_testEquals extends TestCase{
    @Test 
    public void should_returnTrueIfAllFieldsAreEqual(){
        SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy"); 
        Calendar cal2= new GregorianCalendar(2025,9,8);  
        FastDatePrinter fdp1=new FastDatePrinter("",sdf1.getTimeZone(),Locale.getDefault());   
        assertTrue(fdp1.equals((Object)(new FastDatePrinter("",cal2.getTimeZone(),Locale.getDefault()))));
    }
    @Test 
    public void should_returnFalseIfAnyOneFieldIsDifferent(){
        SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zzzz", SystemDefaults.getDateTimezone()); 
        assertFalse(new FastDatePrinter("",sdf1.getTimeZone(),Locale.US).equals(("")));
    }
}