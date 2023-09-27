package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/NumberUtilsTest###testCreateBigInteger
public class TTT_testCreateBigInteger {
@Test
public void testCreateBigInteger() {
    assertEquals(new BigInteger("1"), NumberUtils.createBigInteger("1"));
    assertEquals(new BigInteger("10"), NumberUtils.createBigInteger("A"));
    assertEquals(new BigInteger("-1"), NumberUtils.createBigInteger("-1"));
    assertEquals(new BigInteger("-10"), NumberUtils.createBigInteger("-A"));
    assertEquals(new BigInteger("100"), NumberUtils.createBigInteger("64"));
    assertEquals(new BigInteger("-100"), NumberUtils.createBigInteger("-64"));
    assertEquals(new BigInteger("1000"), NumberUtils.createBigInteger("3E8"));
    assertEquals(new BigInteger("-1000"), NumberUtils.createBigInteger("-3E8"));
    try {
        NumberUtils.createBigInteger(null);
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    try {
        NumberUtils.createBigInteger("");
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    try {
        NumberUtils.createBigInteger(" ");
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    try {
        NumberUtils.createBigInteger("\n\r\f\b");
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    try {
        NumberUtils.createBigInteger("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    try {
        NumberUtils.createBigInteger("$%^&*()_-+={[]}|\\:\"<>?,./~`");
        fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException e) {}
    return;
}
}