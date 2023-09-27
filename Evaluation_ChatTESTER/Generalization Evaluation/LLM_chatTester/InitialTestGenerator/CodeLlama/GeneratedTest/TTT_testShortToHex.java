package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testShortToHex
public class TTT_testShortToHex {
@Test
public void testShortToHex() {
    short src = 258;
    int srcPos = 3;
    String dstInit = "";
    int dstPos = 0;
    int nHexs = 2;
    String expectedResult = "0000";
    assertEquals(expectedResult, Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs));
    src = -258;
    srcPos = 3;
    dstInit = "";
    dstPos = 0;
    nHexs = 2;
    expectedResult = "-0000";
    assertEquals(expectedResult, Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs));
    src = 258;
    srcPos = 3;
    dstInit = "0000";
    dstPos = 0;
    nHexs = 2;
    expectedResult = "00000000";
    assertEquals(expectedResult, Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs));
    src = 258;
    srcPos = 3;
    dstInit = "0000";
    dstPos = 4;
    nHexs = 2;
    expectedResult = "00000000";
    assertEquals(expectedResult, Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs));
    try {
        Conversion.shortToHex(null, null, null, null, null);
        fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
        assertTrue(e.getMessage().contains("Invalid parameter"));
    }
}
}