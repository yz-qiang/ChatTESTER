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
import org.junit.Assert;
import org.junit.Assert;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/math/NumberUtilsTest###testCreateBigInteger
public class NumberUtilsTest_testCreateBigInteger {
    @Test
    public void testCreateBigInteger() throws Exception {
        Assert.assertEquals(new BigInteger("12345"), NumberUtils.createBigInteger("12345"));
        Assert.assertEquals(new BigInteger("-12345"), NumberUtils.createBigInteger("-12345"));
        Assert.assertEquals(new BigInteger("79A"), NumberUtils.createBigInteger("0x79a"));
        Assert.assertEquals(new BigInteger("79A"), NumberUtils.createBigInteger("#79a"));
        Assert.assertEquals(new BigInteger("12345"), NumberUtils.createBigInteger("0o12345"));
        try{
            NumberUtils.createBigInteger("invalid");
            fail("Expected IllegalArgumentException not thrown.");
        } catch(NumberFormatException e){
        }
        try{
            NumberUtils.createBigInteger("0xghi");
            fail("Expected NumberFormatException not thrown.");
        }catch(NumberFormatException e){
        }
        try{
            NumberUtils.createBigInteger("0o89");
            fail("Expected NumberFormatException not thrown.");
        }catch(NumberFormatException e){
        }
        Assert.assertNull(NumberUtils.createBigInteger(null));
    }
}