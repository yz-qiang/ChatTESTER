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
public                                                   
class TestEqualsMethod{_testEquals
    private FastDateParser parserA;
    private FastDateParser parserB;
    @Before 
    public void setUp(){
        parserA=mock(FastDateParser.class);
        when(parserA).thenReturn("test");
        parserB=mock(FastDateParser.class);
    }
   @org.junit.Test 
   public void shouldReturnTrueIfBothObjectsHaveSameValuesAsPerEqualImplementationOfTheirClass(){
       assertTrue(parserA.equals(parserB));       
      verifyNoMoreInteractions(parserA,"verifying no interaction happened on first object after calling its equals()"); 
      verifyZeroInteractions(parserB,"verifying zero interactions happenned on second object since it was not called at all during execution.");     
  }
  @org.junit.Test 
  public void ShouldReturnFalseIfAnyOneObjectIsNullOrNotInstanceOfFastDateParser(){
	  assertFalse((null==parserA ||!(parserA instanceof FastDateParser))); 
	  assertFalse(!(parserB == "not instance"||!(parserB instanceof FastDateParser)));
		try{
			when(parserA.equals(any())).thenThrow(NullPointerException.class); 
			assertThatThrownBy(() -> parserA.equals(parserB)).isInstanceOf(AssertionError.class)
			.hasMessageThat().containsIgnoringCase("expected:<true> but was <false>");
		}finally{
			reset(parserA); 
		}
	}
}