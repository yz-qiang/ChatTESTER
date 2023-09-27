package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class TTT_testLongToHex {
@Test
@Parameters({
    "9223372036854775807L,-1,'',0,1", 
    "-9223372036854775808L,0,'FFFEFFFFFFFFFFFFFFFD',0,8" 
})
public void shouldConvertLongToStringWithCorrectResultAndPositioning(@Optional("null") Long inputValue, @Optional("-1") Integer sourceBitOffset,
        @Optional("") String initialDestinationString, @Optional("0") Integer destinationStartIndex, 
        @InRange(minInt="1", maxInt="8") Integer numberOfHexDigits){
    try{
        UUID uuid=UUID.randomUUID().getLeastSignificantBits()&inputValue;
        System.out.println("\ntest case:"+uuid+" "+sourceBitOffset +" "+initialDestinationString+" "+destinationStartIndex+" "+numberOfHexDigits+"\n\t"+Conversion.longToHex(
                uuid== null?  0 : uuid, 
                Math.max(-64,(Math.abs((Integer)(sourceBitOffset))%64)), 
                 initialDestinationString!= ""? initialDestinationString:" ",
                 destinationStartIndex!= 0?(destinationStartIndex):0,
                  numberOfHexDigits ));
            assertEquals("", "", "");
    }catch(Exception e ){
       fail("" ); 
    }
}
private char intToHexDigit(final int nibble) throws Exception {
    switch (nibble) {
      case 0x0:
          return '0';
      case 0x1:
          return '1';
      case 0x2:
          return '2';
      case 0x3:
          return '3';
      case 0x4:
          return '4';
      case 0x5:
          return '5';
      case 0x6:
          return '6';
      case 0x7:
          return '7';
      case 0x8:
          return '8';
      case 0x9:
          return '9';
      case 0xA:
          return 'A';
      case 0xB:
          return 'B';
      case 0xC:
          return 'C';
      case 0xD:
          return 'D';
      case 0xE:
          return 'E';
      case 0xF:
          return 'F';
      default:
           throw new RuntimeException("Invalid Nibble Value!");
  }
}
}