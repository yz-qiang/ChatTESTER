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
    @MyAnnotation(value=42)
    public static class MyClass {}
    @Test
    public void testToString() throws NoSuchMethodException, SecurityException {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("value".equals(method.getName())) {
                    return Integer.valueOf(42);
                } else {
                    return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{MyAnnotation.class}, this).hashCode();
                }
            }
        };
        MyAnnotation myAnnotation = (MyAnnotation) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{MyAnnotation.class}, handler);
        String result = AnnotationUtils.toString(myAnnotation);
        assertNotNull(result);
        assertTrue(result.contains("@MyAnnotation"));
        assertTrue(result.contains("value=42"));
    }
}