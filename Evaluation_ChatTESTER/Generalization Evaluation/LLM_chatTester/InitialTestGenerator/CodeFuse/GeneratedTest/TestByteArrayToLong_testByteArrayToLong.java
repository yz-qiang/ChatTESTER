package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testByteArrayToLong
public class TestByteArrayToLong_testByteArrayToLong {
    @Test
    public void testByteArrayToLong() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Conversion conversion = new Conversion();
        Method method = Conversion.class.getDeclaredMethods()[0];
        Random random = new Random();
        byte[] src = new byte[random.nextInt(5)];
        int srcPos = random.nextInt(5);
        long dstInit = random.nextLong();
        int dstPos = random.nextInt(7);
        int nBytes = random.nextInt(32);
        try{
            Object result = method.invoke(conversion, src, srcPos, dstInit, dstPos, nBytes);
            assertNotNull(result);
            assertTrue((long)result instanceof Long);
        } catch (IllegalArgumentException e){
            fail("An exception was thrown when calling the method.");
        }
    }
}