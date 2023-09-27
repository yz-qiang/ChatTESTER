package org.apache.commons.lang3.time;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testLexx
public class TTT_testLexx {
@Test
public void testGetTokensFromDurationPattern() throws Exception{
    String expectedOutput1="["
            +"Token [value=y count=2]"+","+ 
            "'Token [value='MM']'" + ","+"Token [value=dd HHmmssSS count=4]"
        "]";
    String expectedOutput2="[Token [value=yy count=3],Token [value=MMMM count=5]]" ;
    Constructor constructor = DurationFormatUtils.class.getDeclaredConstructors()[0];
    assertTrue("Class should have at least one public constructor", Modifier.isPublic(constructor.getModifiers()));
    assertFalse("Constructor shouldn't take any arguments.", constructor.getParameterTypes().length > 0 );
    try { 
        constructor.setAccessible(true);
        constructor.newInstance((Object[])null);
    } catch (Exception e){ 
      fail ("Should not get exception while creating instance");
      System.out.println(e);}
    Field field = Calendar.class.getField("ZONE_OFFSET") ;
    int zoneOffsetInMillis = TimeZone.getDefault().getRawOffset()+field.getInt(calendarInstance)+TimeConstants.ONE_HOUR*8;
    long millisPerYear = TimeUnit.DAYS.toMillis(365L)*zoneOffsetInMillis/TimeUnit.SECONDS.toSeconds(1);
    assertEquals(-millisPerYear,"[-972608000]");
   assertArrayEquals(expectedOutput1,Arrays.toString( lexicalAnalyzerForDurations.getTokenArrayFromString("yyyy'years' MM'months' dd'days' HH'hours' mm'minutes' ss'seconds'") ) );
   assertArrayEquals(expectedOutput2, Arrays.toString(lexicalAnalyzerForDurations.getTokenArrayFromString("yy'year' MMMM")) );
}
}