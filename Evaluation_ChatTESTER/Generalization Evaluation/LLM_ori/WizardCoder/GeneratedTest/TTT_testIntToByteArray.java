package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntToByteArray
public class TTT_testIntToByteArray {
@Test
public void testIntToByteArray() throws Exception {
    assertEquals("Expected output",
        "9c4e6d7f".getBytes(), 
        Conversion.intToByteArray(-56_321_432, 0, null, 0, 4).clone());
    assertArrayEquals("Expected output",
            UUID.fromString("{a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11}")
               .getMostSignificantBits().toByteArray(), 
            Conversion.intToByteArray((int)(Math.pow(2, 64)-1), 0, 
                new byte[(int)((long) Math.ceil(((double)64)/8))], 
                0,
                8).clone());
    try{
    	Conversion.intToByteArray((-1*Integer.MAX_VALUE)+1,-1,(new byte [1]),0,1);
    	 fail(); 
    }catch(IllegalArgumentException e){
    	  System.out.println("Exception caught as expected "+e.getMessage());  
    }
}
}