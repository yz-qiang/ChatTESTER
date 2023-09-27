package org.apache.commons.lang3.time;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testLexx
public class TTT_testLexx {
@Test
public void testLexx() throws Exception {
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d")}, DurationFormatUtils.lexx("yyyy-MM-dd"));
    assertArrayEquals(new Token[]{new Token("H"), new Token("m"), new Token("s")}, DurationFormatUtils.lexx("HH:mm:ss"));
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d"), new Token("H"), new Token("m"), new Token("s")}, DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss"));
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d"), new Token("H"), new Token("m"), new Token("s"), new Token("S")}, DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss.SSS"));
    try {
        DurationFormatUtils.lexx("");
        fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {}
    try {
        DurationFormatUtils.lexx("yyy-MM-dd");
        fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {}
    try {
        DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss.SSS");
        fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {}
    try {
        DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss.SSS");
        fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {}
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d")}, DurationFormatUtils.lexx("yyyy-MM-dd"));
    assertArrayEquals(new Token[]{new Token("H"), new Token("m"), new Token("s")}, DurationFormatUtils.lexx("HH:mm:ss"));
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d"), new Token("H"), new Token("m"), new Token("s")}, DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss"));
    assertArrayEquals(new Token[]{new Token("y"), new Token("M"), new Token("d"), new Token("H"), new Token("m"), new Token("s"), new Token("S")}, DurationFormatUtils.lexx("yyyy-MM-dd HH:mm:ss.SSS"));
}
}