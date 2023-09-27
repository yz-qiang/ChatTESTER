package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToInt
public class TestByteArrayToInt_testByteArrayToInt {
    @Test
    public void testByteArrayToIntWithValidInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Random rand = new Random();
        byte[] src = new byte[4];
        int srcPos = rand.nextInt(5);
        int dstInit = rand.nextInt();
        int dstPos = rand.nextInt(5);
        int nBytes = rand.nextInt(5);
        for (int i=0; i<src.length; i++){
            src[i]=(byte)(rand.nextBoolean() ? 1 : 0);
        }
        Conversion conversionObj = new Conversion();
        Method method = conversionObj.getClass().getDeclaredMethod("byteArrayToInt", byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        Object result = method.invoke(conversionObj, src, srcPos, dstInit, nBytes);
        assertNotNull(result);
        Assert.assertTrue((Integer)result instanceof Integer);
    }
    @Test
    public void testByteArrayToIntWithInvalidInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        byte[] src = {};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 9;
        try {
            Conversion conversionObj = new Conversion();
            Method method = conversionObj.getClass().getDeclaredMethod("byteArrayToInt", byte[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            method.invoke(conversionObj, src, srcPos, dstInit, nBytes);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e){
        }
    }
}