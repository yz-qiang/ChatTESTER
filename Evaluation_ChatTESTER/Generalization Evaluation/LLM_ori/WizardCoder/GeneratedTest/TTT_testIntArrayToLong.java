package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntArrayToLong
public class TTT_testIntArrayToLong {
@Test
public void testIntArrayToLong_validInput() throws Exception {
    byte[][] testDataSets = {{
               {-85,-79},{-128,-128},{Integer.MIN_VALUE/2,(short)-Math.PI*Short.MAX_VALUE},{"Hello".getBytes(),"World!".getBytes()},
        }, 
        { 
                Long.MAX_VALUE,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",new UUID(-1, -1).toString().getBytes()};
    };
    String expectedOutputStrings []={"-85:-79","-128:-128","-1073741824:"+(long)(-(float)((double) Integer.MIN_VALUE / Short.MAX_VALUE)),"{'SGVsbG8=','V29ybGQh'}",""};
    for (byte datasetIndex = 0 ;datasetIndex<testDataSets.length;datasetIndex++){
        Object[] dataSet = testDataSets[(int)datasetIndex];
        System.err.println("Testing Dataset "+((char)'A'+datasetIndex));
       try{
           assertEquals(((String[])dataSet)[expectedOutputStrings.length],Conversion.intArrayToString((int[])dataSet[0])); 
       }catch(Exception e){
          fail();
       } 
    }
}
     public static String intArrayToString(int arr [])throws IOException{
        StringBuilder sb = new StringBuilder("{");
        boolean firstElement = true;
        for(int element :arr ){
                if(!firstElement )
                    sb.append(",");
               else
                   firstElement = false;
              sb.append("'"+Base64.getEncoder().encodeToString((""+element).getBytes())+"'");
        }
        sb.append("}");
        return sb.toString();
   } 
  @Test
  public void testIntArrToIntStr(){
      assertArrayEquals({"{'a', 'b'}, {'c', 'd'}"},Conversion.intArrayToString({97,98},{99,100})); 
  }
}