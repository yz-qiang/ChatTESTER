package org.apache.commons.lang3;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testIsValidAnnotationMemberType
public class AnnotationUtilsTest_testIsValidAnnotationMemberType {
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testIsValidAnnotationMemberType_primitiveTypes() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(long.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(float.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(double.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(boolean.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(byte.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(short.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(char.class));
    }
    @Test
    public void testIsValidAnnotationMemberType_enumTypes() {
        enum MyEnum {}
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(MyEnum.class));
    }
    @Test
    public void testIsValidAnnotationMemberType_arrayTypes() {
        int[] array1 = new int[]{};
        long[] array2 = new long[]{};
        float[] array3 = new float[]{};
        double[] array4 = new double[]{};
        boolean[] array5 = new boolean[]{};
        byte[] array6 = new byte[]{};
        short[] array7 = new short[]{};
        char[] array8 = new char[]{};
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array1.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array2.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array3.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array4.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array5.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array6.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array7.getClass()));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(array8.getClass()));
    }
    @Test
    public void testIsValidAnnotationMemberType_stringAndClassTypes() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class.class));
    }
    @Test
    public void testIsValidAnnotationMemberType_invalidTypes() {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Object obj = new Object();
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(list.getClass()));
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(map.getClass()));
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(obj.getClass()));
    }
}