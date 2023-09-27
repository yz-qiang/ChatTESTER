package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testBinaryToInt
public class TTT_testBinaryToInt {
@Test
@Parameters({
    "true false true", 
    "-56789"          
})
public void convertBinaryToInteger_shouldConvertCorrectly(String binStrInputValues) throws Exception {
    String[] strValsArr = binStrInputValues.split("\\s+");
    List<Boolean> boolList = Arrays
           .stream(strValsArr)   
           .map(Boolean::parseBoolean).collect(Collectors.toList());   
    byte[] bytesArray = ArrayUtils.toPrimitive(boolList.toArray(new Byte[boolList.size()]));    
    BitSet bitset = BitSet.valueOf(bytesArray);     
    assertEquals(-4321,Conversion.binaryToInt(bitset.get(false), 0, Integer.MIN_VALUE/2, 0, 16)),
    assertArrayEquals(new boolean[]{true},Arrays.copyOfRange(bitset.toByteArray(), 0, 1))
}
}