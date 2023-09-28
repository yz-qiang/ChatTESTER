package org.apache.commons.lang3.time;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testLexx
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
public class DurationFormatUtilsTest_testLexx {
    @Test
    public void testLexx() {
        String format = "y'M'MM'd'd'H'H'm'm's's'S'S'";
        Token[] expectedTokens = {
            new Token(DurationFormatUtils.years),
            new Token(DurationFormatUtils.M, 2),
            new Token(DurationFormatUtils.d),
            new Token(DurationFormatUtils.H),
            new Token(DurationFormatUtils.m),
            new Token(DurationFormatUtils.s),
            new Token(DurationFormatUtils.S)
        };
        Token[] actualTokens = DurationFormatUtils.lexx(format);
        assertArrayEquals(expectedTokens, actualTokens);
        format = "''";
        expectedTokens = new Token[] { new Token(new StringBuilder()) };
        actualTokens = DurationFormatUtils.lexx(format);
        assertArrayEquals(expectedTokens, actualTokens);
        format = "y''M''d''H''m''s''S";
        expectedTokens = new Token[] {
            new Token(DurationFormatUtils.years),
            new Token(new StringBuilder("")),
            new Token(DurationFormatUtils.M),
            new Token(new StringBuilder("")),
            new Token(DurationFormatUtils.d),
            new Token(new StringBuilder("")),
            new Token(DurationFormatUtils.H),
            new Token(new StringBuilder("")),
            new Token(DurationFormatUtils.m),
            new Token(new StringBuilder("")),
            new Token(DurationFormatUtils.s),
            new Token(DurationFormatUtils.S)
        };
        actualTokens = DurationFormatUtils.lexx(format);
        assertArrayEquals(expectedTokens, actualTokens);
        format = "y'M'd'H'm's'S";
        expectedTokens = new Token[] {
            new Token(DurationFormatUtils.years),
            new Token(DurationFormatUtils.M),
            new Token(DurationFormatUtils.d),
            new Token(DurationFormatUtils.H),
            new Token(DurationFormatUtils.m),
            new Token(DurationFormatUtils.s),
            new Token(DurationFormatUtils.S)
        };
        actualTokens = DurationFormatUtils.lexx(format);
        assertArrayEquals(expectedTokens, actualTokens);
    }
}