package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/CharSetTest###testGetInstance
public class CharSetStringUtils_testGetInstance {
    @Test
    public void testGetInstance() throws Exception {
        assertEquals("abc", CharSetStringUtils_testGetInstance.getInstance("a", "b", "c").toString());
        assertSame(CharsetStringUtils.COMMON.get(""), CharsetStringUtils.getInstance("", ""));
        assertNull(CharsetStringUtils.getInstance((String[]) null));
        assertFalse(CharsetStringUtils.getInstance().isEmpty());
    }
    public static CharSet getInstance(String set) {
        if (set == null || set.length == 0) {
            return null;
        }
        CharSet result = new CharSet();
        for (String s : set) {
            result.add(s);
        }
        return result;
    }
    private static class CharSet {
        private final StringBuilder sb = new StringBuilder();
        public void add(String s) {
            sb.append(s);
        }
        public String toString() {
            return sb.toString();
        }
    }
}