package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToShort
public class TTT_testBinaryToShort {
@Test 
public void shouldConvertBinaryArrayToIntAndStoreInByteArrayAsSignedTwoComplementUsingJavaPrimitiveTypes(){
    try{
        Boolean []inputBooleanArr={true,false};   
        Integer expectedOutputIntValue=-96 ;        
        Short initDestinationVal=(short)-3584;       
        Byte desiredDestIndexByte =(byte)(initDestinationVal>>8&0xff);    
        Character desiredDestLowOrderChar=(char)((desiredDestIndexByte<<8)|((~expectedOutputIntValue)&0xFF));     
        System.out.println("\t\tInput Parameter Values:");
        printValuesForDebuggingPurposesOnly();      
        String actualResultStr="["+(Conversion.binaryToShort(inputBooleanArr,(Integer)2,initDestinationVal,(Character)7,(Integer)2))+", "+
                (~(((short)~(Conversion.binaryToShort(inputBooleanArr,(Integer)2,initDestinationVal,(Character)7,(Integer)2)))>>>8))+"]";
        assertEquals("["+actualResultStr+" ]", "["+expectedOutputIntValue+", "+desiredDestLowOrderChar+ "]","Actual results did not match expected outputs.");
    }catch(Exception e){
            fail ("An Exception Occured While Performing Unit Testing On BinaryToShortFunction."
                    +" Error Message Is:"+e.getMessage());
    }
}
     private void printValuesForDebuggingPurposesOnly(){
    	System.out.print("\tSource Bool Arr=[ ");
	        for(boolean val:inputBooleanArr ){
	        	  System.out.print(val+" ");
	        }
	        System.out.println("]");
	        System.out.println("\tExpected Int Val="+expectedOutputIntValue+"\tInitial Dstination Val="+initDestinationVal);
	    }
}