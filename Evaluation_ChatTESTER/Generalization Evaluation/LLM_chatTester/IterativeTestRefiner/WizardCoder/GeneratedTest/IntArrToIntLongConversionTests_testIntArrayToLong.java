package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testIntArrayToLong
public class IntArrToIntLongConversionTests_testIntArrayToLong {
    @Test
    public void shouldConvertIntArrayElementsIntoSingleUnsignedLongValueWithSpecifiedBitPositionsAndNumberOfIntegersAsInputParameters_whenAllInputsAreValid() throws Exception {
        byte[][] testDataSets = {{
            {Byte.MIN_VALUE},
            {(short)-32768, Short.MAX_VALUE, Byte.MIN_VALUE, Character.MAX_VALUE / 2, Long.MAX_VALUE >> 32, -(Byte.MIN_VALUE)},
            {}
        }};
        for (int dataSetIndex = 0; dataSetIndex < testDataSets.length; dataSetIndex++) {
            Object expectedOutputObj = testDataSets[dataSetIndex][expectedOutputArrayIndex];
            assertTrue("Expected object at index " + expectedOutputArrayIndex + " not found", expectedOutputObj!= null);
            assertEquals(((long[]) expectedOutputObj)[0], actualOutput);
        }
    }
    private volatile boolean stopRequested = false;
}