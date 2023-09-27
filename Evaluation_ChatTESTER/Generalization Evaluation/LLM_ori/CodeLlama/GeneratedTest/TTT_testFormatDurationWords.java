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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/time/DurationFormatUtilsTest###testFormatDurationWords
public class TTT_testFormatDurationWords {
@Test
public void testFormatDurationWords() {
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, true, true));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, false, false));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, true, false));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, false, true));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, true, true));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, false, false));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, true, false));
    assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, false, true));
    TimeZone tz = TimeZone.getDefault();
    try {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, true, true));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, false, false));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, true, false));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(86579, false, true));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, true, true));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, false, false));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, true, false));
        assertEquals("1 day 2 hours 3 minutes 4 seconds", DurationFormatUtils.formatDurationWords(-86579, false, true));
    } finally {
        TimeZone.setDefault(tz);
    }
    assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.formatDurationWords(null, true, true));
    assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.formatDurationWords(null, false, false));
    assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.formatDurationWords(null, true, false));
    assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.formatDurationWords(null, false, true));
}
}