package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testHexToInt
@SuppressWarnings("javadoc") 
public class HexToIntegerConversionTests_testHexToInt {
    private Conversion conversionInstance;
    @Before
    public void setUp() throws Exception {
        conversionInstance = new Conversion(); 
    }
    @Test
    public void shouldReturnInitialDestinationValueForZeroLengthInputStringAndValidPositionParameters() {
        assertEquals(-56789, 
                conversionInstance.hexToInt("", 0, -56789, 0, 0));
    }
    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTryingToExtractMoreBytesThanAvailableInSourceString() {
        try{
            conversionInstance.hexToInt("-ABCDEF", 0, Integer.MAX_VALUE/2, 0, 6); 
            fail("Expected IllegalArgumentException was never raised."); 
        } catch (IllegalArgumentException e){
           assertTrue(e instanceof IllegalArgumentException &&
                   "(nHexs-1)*4+dstPos is greater or equal to than 32".equals(e.getMessage()));           
        }        
    }
    @Test
    public void shouldConvertPositiveOffsetSingleByteHexStringCorrectly(){
      assertArrayEquals("{byte[1]={-1}}",
              "{byte["+(conversionInstance.hexToInt("+FF", 0,-1<<2*8|-(~((~0)<<2))&0xff,(short)(Math.random()*Short.SIZE), Math.abs(((short)(Math.random()*Short.SIZE)- Short.MIN_VALUE))/2)+","
                      +" "+(conversionInstance.hexToInt("+FF", 0,-1<<2*8|(~((-1<<(Math.abs(((short)(Math.random()*Short.SIZE)- Short.MIN_VALUE))+1)/2))),
                              (short)((Math.random()-0.5)*(Short.MAX_VALUE/(float)Math.pow(2, Byte.SIZE)))),
                              1)).replace(' ',',')+"}",new byte[]{
                          (byte)~(
                                  ~(
                                      (~0)
                                    )
                                ),
                  });
          System.err.println("\t"+"shouldConvertPositiveOffsetSingleByteHexStringCorrectly passed successfully!");          
    }
}