package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/CharSetTest###testGetInstance
@Test 
public void testGetInstance() throws Exception{
    assertEquals("abc", CharSetStringUtils_testGetInstance.getInstance("a","b","c").toString());
    assertSame(CharsetStringUtils.COMMON.get(""), CharsetStringUtils.getInstance("", ""));
    assertNull(CharsetStringUtils.getInstance((String[])null));
    assertFalse(CharsetStringUtils.getInstance().isEmpty());
} 
class CharSetStringUtils_testGetInstance extends CharSet {}