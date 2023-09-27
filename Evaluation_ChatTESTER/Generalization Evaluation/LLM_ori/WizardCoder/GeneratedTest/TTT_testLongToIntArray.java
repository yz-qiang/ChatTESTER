package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToIntArray
public class TTT_testLongToIntArray {
@Test
public void shouldConvertLongToIntArrayCorrectly() throws Exception {
    UUID uuidValue = UUID.randomUUID();
    byte[] bytesFromUuid = uuidValue.toString().getBytes("UTF8");
    String hexString = "";
    StringBuilder sb = new StringBuilder("");
    for (byte b : bytesFromUuid){
        sb.append(Integer.toHexString((b << 4) | (b >>> 4)));
    }
    while (sb.length() % 8!= 0 ){ 
        sb.insert(0,"0" ); 
    }  
    hexString=sb.substring(0);
   Long sourceNumber = Long.parseUnsignedLong(hexString, 16); 
   Integer expectedResultLength = Math.max(((bytesFromUuid.length*8)/5),1)+1 ;
   System.out.println("\ntest case data:");
   System.out.printf("%s\t%d",sourceNumber,expectedResultLength);
   int [] resultArry =Conversion.longToIntArray(sourceNumber,(bytesFromUuid.length*8)%5,null,-1,Math.min(expectedResultLength,7)) ;
  assertEquals("",resultArry[(expectedResultLength>7)?7:(expectedResultLength<1?1:expectedResultLength)],'\uffff');
  try{
      Conversion.longToIntArray(-9L,0,new int [1],0,1); 
      fail ("Expected exception not thrown.");
  }catch(IllegalArgumentException e){} 
  try{
       Conversion.longToIntArray(uuidValue.getMostSignificantBits(),0,new int [-1],0,1); 
       fail ("Expected exception not thrown.");
  }catch(IndexOutOfBoundsException e){}  
}
}