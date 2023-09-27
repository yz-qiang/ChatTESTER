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
import java.lang.annotation.RetentionPolicy;
import org.junit.Assert;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.BeforeEach;
import org.junit.Assertions;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testToString
public class AnnotationUtilsTest_testToString {
    private Annotation mockedAnnotation;
    @BeforeEach
    public void setup(){
         mockedAnnotation = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {Annotation.class}, new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 switch (method.getName()) {
                     case "annotationType":
                         return Retention.class;
                     default:
                         return "";
                 }
             }
         });
    }
    @Test
    public void testToStringWithEmptyAnnotation() {
        assertEquals("@Retention", AnnotationUtils.toString(mockedAnnotation));
    }
    @Test
    public void testToStringWithNonEmptyAnnotation() {
        List<Integer> values = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        when(mockedAnnotation.annotationType()).thenReturn(values.getClass());
        assertEquals("@Retention([1, 2, 3, 4, 5])", AnnotationUtils.toString(mockedAnnotation));
    }
    @Test
    public void testToStringWithNullInput() {
        Assertions.assertThrows(RuntimeException.class, () -> AnnotationUtils.toString(null));
    }
    @Test
    public void testToStringWithInvalidInput() {
        Assertions.assertThrows(RuntimeException.class, () -> AnnotationUtils.toString(new ArrayList<>()));
    }
}