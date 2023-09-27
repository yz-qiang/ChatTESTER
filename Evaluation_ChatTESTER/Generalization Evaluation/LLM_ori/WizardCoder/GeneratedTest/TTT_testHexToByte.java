package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToByte
public class TTT_testHexToByte {
@Test
@Parameters({
    "FF FF",     
     "",          {},                    0,                      Byte.MIN_VALUE,        2                           , "empty input"
             null,                    {}                        },           {"null input"},            {{},                         ""}) 
             })  
public void shouldConvertHexStringToBytesCorrectly(@Nullable String inputString, @NotNull Map<Integer, Integer> expectedOutputBytesMap,
                                                    int sourcePosition, byte destInitialValue, int numHexDigits, String desc){
    try{
        UUID uuid=UUID.randomUUID();
        System.err.println("Running Test Case "+desc+" :"+uuid.toString());
        assertEquals("",expectedOutputBytesMap,"Not implemented yet!");
    }catch(Exception e){
            fail("" +"Failed due to exception:"+e.getMessage()+". Check logs."); 
    }
} 
  private int[] getExpectedByteArrayFromInputStringAndNumHexDigits(String inputStr, int numOfHexCharsPerByte){
          List<Integer> resultList=new ArrayList<>();
          char [] charArray=inputStr.toCharArray();
          StringBuilder sb=new StringBuilder("");
          boolean firstCharFound=false;
          while(!firstCharFound &&!charArray[sourcePosition].equals(' ')){
              sb.append(Character.toUpperCase(charArray[sourcePosition]));
              ++numOfHexCharsPerByte;
              --sourcePosition;
              if((--destIndex)<0 || (--numOfHexCharsPerByte)==0 ){
                  break;
              }
          }
          assertArrayEquals("",resultList.toArray(),getActualResult().getBytes());
          return Arrays.stream(sb.reverse().toString().split("\\W"))
                     .mapToInt(Integer::parseInt).toArray();
  }
private byte convertToByteUsingMethodUnderTest(){
    return conversionClassInstance.hexToByte(inputString,
                                            sourcePosition,
                                            destInitialValue,
                                            destIndex++,
                                            numOfHexCharsPerByte);
  }
}