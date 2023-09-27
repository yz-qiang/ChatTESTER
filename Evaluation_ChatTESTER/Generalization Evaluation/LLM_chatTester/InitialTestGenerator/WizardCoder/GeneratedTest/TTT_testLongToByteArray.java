package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToByteArray
public class TTT_testLongToByteArray {
@Test 
    public void convertToByteArrayAndStoreAtPosition(){
        UUID uuidValue= UUID.randomUUID();  
        String expectedHexString=""+uuidValue.getMostSignificantBits()+""+uuidValue.getLeastSignificantBits()+"";   
        System.out.println("Expected Hex string:"+expectedHexString); 
        Long actualLong=(long)(Math.abs((double)actualDouble*ConversionUtil.SCALE_FACTOR)+0.5)/CONVERSION_CONSTANT ;
        assertEquals("", expectedHexString, ""+(new BigInteger(String.valueOf(actualLong)).toString()));
    }
}