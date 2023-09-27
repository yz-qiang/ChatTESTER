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
    @Test
    public void testIsValidAnnotationMemberTypeWithNullInput(){
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(null)); 
    }
    @Test
    public void testIsValidAnnotationMemberTypeWithPrimitiveTypes(){
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class)); 
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(boolean.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(double.class));
    }
    @Test
    public void testIsValidAnnotationMemberTypeWithNonPrimitiveTypes(){
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(MyCustomEnum.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(MyCustomAnnotation.class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Object[].class));
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Integer[].class));
    }
    @Test
    public void testIsInvalidAnnotationMemberType(){
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(ArrayList.class));
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(HashMap.class));
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(AnotherCustomClass.class));
    }
}