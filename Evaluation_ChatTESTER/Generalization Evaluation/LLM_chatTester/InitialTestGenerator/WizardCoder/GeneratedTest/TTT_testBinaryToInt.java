package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToInt
public class TTT_testBinaryToInt {
@Test 
public void shouldConvertEmptyArrayToZeroWithInitialValueAndPositionSpecified(){
    assertArrayEquals("",new Boolean[]{false},Conversion.binaryToInt(new boolean[0],5,-47689,3,0));  
} 
@Test 
public void shouldThrowExceptionWhenNumberofBooleansIsGreaterThanSizeOfInputArrayPlusSourcePositionMinusOneOrDestinationPosition(){ 
    try{
        assertEquals("-4",String.valueOf(-4), String.valueOf(Conversion.binaryToInt(new boolean[]{true, false},0,Integer.MIN_VALUE,0,4)));  
    }catch(IllegalArgumentException e){ 
        fail();   
    }    
}
}