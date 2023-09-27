package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToHex
public class TTT_testLongToHex {
@Test
public void testLongToHex() throws Exception {
    Object[][] tests = {{0xABCDEFL << 32 | 0xABCDFL,  8, "",   5,    7},
                        {(byte)(0xFF),        0, "FF", 9,     1}};
    UUID uuid = null;
    try{
        uuid = UUID.randomUUID();
        byte[] bytes = uuid.getMostSignificantBits().toByteArray();
        assertEquals("Invalid most significant bits conversion.",
                Long.toHexString((bytes[0]<<56)+(bytes[1]<<48)+(bytes[2]<<40)+
                                (bytes[3]<<32)+(bytes[4]&0xffl)<<24+(bytes[5]&0xffl)<<16+
                                 (bytes[6]&0xffl)<<8+(bytes[7]&0xffl)), 
                Conversion.longToHex(((uuid.getLeastSignificantBits())&0xFFFFFFFFFFFFFFFFL),(Integer)((Object[])tests[0])[1],
                                    (String)((Object[])tests[0])[2],(Integer)((Object[])tests[0])[3], 
                                    (Integer)((Object[])tests[0])[4]));
            fail("Expected exception not thrown.");
       catch(IllegalArgumentException e){
           System.out.println("\tException caught successfully!");
       }
   finally{
      if(null!= uuid &&!uuid.equals(""))
          uuid=null;
  }
}
  private char intToHexDigit(final int nibble) {
    switch (nibble) {
        case 0xA: 
        case 0xB: 
        case 0xC: 
        case 0xD: 
        case 0xE: 
            return Character.forDigit(nibble - 0xA + 'A', 16);
        default:
            break;
    } 
    return Integer.toHexString(nibble).charAt(0); 
  }
private boolean compareArrays(char [] arr1, char []arr2 ){
  assertArrayEquals("",arr1,arr2 );
  return true ; 
}
}