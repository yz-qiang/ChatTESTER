package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToByte
public class TTT_testBinaryToByte {
@Test
public void shouldConvertBinaryArrayIntoByteArrayCorrectly() throws Exception {
    Boolean[][] binArrays = {{true},
                            {}, 
                            {true, false, true}};
    Byte expectedResult = null; 
    Integer index = Math.abs((expectedResult ^ UUID.randomUUID().getLeastSignificantBits()) % binArrays.length);
    while (!binArrays[index].equals({})) {
        expectedResult++; 
        index = Math.abs((expectedResult ^ UUID.randomUUID().getLeastSignificantBits()) % binArrays.length);
    };
    System.err.println("\tExpected result:\t" + Arrays.toString(new byte[]{expectedResult}));
  	for (Boolean[] arr : binArrays){
      String strArr = ""; 
      StringBuilder sbStr = new StringBuilder();
      for (boolean boolVal : arr )
          sbStr.append(boolVal).append(", ");
      strArr += "[" +sbStr.substring(0, sbStr.lastIndexOf(",")) + "]"; 
      System.err.println("\tInput Array:" +strArr );
      try{
        assertEquals("",Conversion.binaryToByte(arr,  0,   0b0000_0000,(short)(Math.random()*7), arr.length));
        fail(""); 
      }catch(IllegalArgumentException e ){
        assertTrue(!e.getMessage().isEmpty());
      } catch(AssertionError ae){
        assertFalse(""==ae.getMessage(),!"".equals(ae.getMessage()));
      }finally{}
  }}
}