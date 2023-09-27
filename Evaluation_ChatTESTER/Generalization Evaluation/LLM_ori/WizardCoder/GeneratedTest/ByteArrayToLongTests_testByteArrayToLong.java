package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class ByteArrayToLongTests_testByteArrayToLong {
    @Test
    public void shouldConvertByteArrayToIntWhenSrcLengthIsZeroAndSrcPositionEqualsZeroOrNbytesEqualsOne() throws Exception {
        assertEquals(-72057594037927936l,
                Conversion.byteArrayToLong(new byte[]{}, 0, Long.MIN_VALUE, Integer.MAX_VALUE / 8, 1));
        assertArrayEquals("".getBytes(), 
                Conversion.longToBytes(Conversion.byteArrayToLong("", "", Byte.MIN_VALUE)));
    }
    @Test 
    public void shouldReturnCorrectValueForInputWithAllMostSignificantBitsSetExceptFirstTwoGroupsOfEightConsecutiveBytes() 
            throws Exception{ 
        String hexString="FF FF FE FD FC FB FA F9";  
        byte [] data=hexStringToByteArray(hexString); 
        long result = Conversion.byteArrayToLong(data, 
                0 ,
                0xABCDEFABCDABCDL ,
                0 ,
                12 );
       assertTrue((result >> 56)==0xFFL);
      assertFalse(((result>>48)&0xFFFF)!=0xFEFL);
      assertFalse(((result>>40)&0xFFFF)!=0xFDFCL);
   }
   private byte[] hexStringToByteArray(String s) 
   {   
       int len = s.length();    
       byte[] data = new byte[(len / 2)];     
       for (int i = 0; i < len; i += 2) {       
          data[i / 2] = (byte)(Character.digit(s.charAt(i), 16)      
              + Character.digit(s.charAt(i+1), 16));     
       }     
       return data;    
   }
}