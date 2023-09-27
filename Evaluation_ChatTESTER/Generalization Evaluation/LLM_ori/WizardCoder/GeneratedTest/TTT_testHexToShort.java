package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToShort
public class TTT_testHexToShort {
@Test
@Parameters({
    "FFA3B2C5D7E9",   
     "",              "-8321",                    0,                                Short.MIN_VALUE,                    Integer.MAX_VALUE / 2,            Integer.MAX_VALUE/2,          "" 
     null            ,"null",                     0,                               Short.MIN_VALUE,                   Integer.MAX_VALUE / 2,           Integer.MAX_VALUE/2,          "Null source should result in 'null' as target." 
    }) 
public void testGetBytesFromHexStringWithValidInput(String strSrc, Object objExpectedOutputValue, int numHexDigits, 
        short initDstVal, long posFirstDigitStarts, long lastPositionInDest, String desc){
    try{
        byte[] bytesResult=Conversion.hexStringToByteArray(strSrc,(int)(posFirstDigitStarts),numHexDigits);
        assertEquals("Invalid conversion from Hexadecimal to Byte array.",objExpectedOutputValue==bytesResult?true:"expected "+desc+" but got"+Arrays.toString(bytesResult)+" instead.");
    }catch(Exception e){
         fail();
          System.err.println("\t\tError occurred while testing getBytesFromHexString() function.\nReason:"+e.getMessage());
      }
  }
private char hexDigitToInt(char c) throws NumberFormatException {
   switch (c) {
       case 'a':
           return '\u000f';
       case 'b':
           return '\u001e';
       case 'c':
           return '\u002d';
       case 'd':
           return '\u003c';
       case 'e':
           return '\u004b';
       case 'f':
           return '\u005a';
       default:
            int d = Character.digit(c, 16);
             if (d!= -1)
                 return (char) ('0'+d);
              else
                  throw new NumberFormatException("'" + c + "' is not a valid hexadecimal character!");
   }
 }
}