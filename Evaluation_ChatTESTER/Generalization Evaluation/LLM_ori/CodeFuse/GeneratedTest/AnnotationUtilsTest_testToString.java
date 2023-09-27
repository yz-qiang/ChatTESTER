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
    public @interface MyAnnotation{
         int id() default -1;
         String name() default "default";
    }
    @MyAnnotation(id=5,name="test")
    private static class MyClass{}
    @Test
    public void testToString(){
        List<Object[]> expectedValues = Stream.of(-1,"default").collect(Collectors.toList());
        assertEquals(expectedValues.toString(), AnnotationUtils.toString(MyClass.class.getAnnotations()[0]));
    }
}