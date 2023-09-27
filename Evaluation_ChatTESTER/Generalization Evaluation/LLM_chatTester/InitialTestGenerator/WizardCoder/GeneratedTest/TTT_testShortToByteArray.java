package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToByteArray
public class TTT_testShortToByteArray {
@Test 
    public void convertToByteArray_shouldConvertShortToBytesAndStoreAtSpecificPositionsInDestinationArray(){
        Short expectedValue=257;  
        Integer startPosition=3;   
        Byte[] destArr={49,(byte)-1,-1};    
        Integer endPosition=(startPosition)+(expectedValue).toString().length()/Byte.SIZE;     
        String hexString=""+Integer.toHexString((new UUID()).getLeastSignificantBits());        
        System.out.println("Expected Value:"+hexString);       
       try{
           long lVal=Long.parseUnsignedLong(hexString, 16 );            
          assertNotEquals(-1L,"Invalid Hexadecimal string "+lVal+" obtained.");          
            assertEquals("",destArr[(endPosition)]);
            Conversion objConversion=new Conversion();           
            byte [] actualResult=objConversion.shortToByteArray(
                    expectedValue,                    
                    3,                            
                    destArr,                       
                    0,                             
                    2                              
                ) ;         
            assertTrue(!Arrays.equals(actualResult,null),"Null Array returned by Convertion Function ");                        
            assertFalse(Arrays.equals(actualResult,{49,(byte)-1}),"Incorrect Values Written In Destination Buffer ");                
            assertArrayEquals({49,(byte)(-(long)((~(((long)expectedValue)>>>(i<<3)))&0xFF)),
                                    (-(long)(((long)expectedValue)>>(i<<3))&0xFF)},
                            Arrays.copyOfRange(
                                destArr,                                  
                                0,                               
                                Math.min(                                 
                                        destArr.length,                           
                                        2+(expectedValue>>>(i<<3)).intValue()*Byte.BYTES                                   
                                    ),                                    
                                ));                     
      }catch(Exception e){
              fail("" +" Exception Occured :"+e.getMessage()+"\n Stack Trace :" +Arrays.toString(e.getStackTrace()));
      }
    }
}