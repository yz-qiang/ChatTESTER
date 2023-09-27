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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testToString
public class AnnotationUtilsTest_testToString {
    public static interface MyAnnotation {
        int value();
    }
    public static class MyClass implements MyAnnotation {
        @Override
        public int value() {
            return 42;
        }
    }
    @MyAnnotation(value=42)
    public static class MyAnnotatedClass {}
    @Test
    public void testToString() throws NoSuchMethodException, SecurityException {
        MyAnnotatedClass myObject = new MyAnnotatedClass();
        Annotation[] annotations = myObject.getClass().getAnnotationsByType(MyAnnotation.class);
        assertNotNull(annotations);
        assertEquals(1, annotations.length);
        String expectedResult = "@MyAnnotation(value=42)";
        String actualResult = AnnotationUtils.toString(annotations[0]);
        assertEquals(expectedResult, actualResult);
    }
}