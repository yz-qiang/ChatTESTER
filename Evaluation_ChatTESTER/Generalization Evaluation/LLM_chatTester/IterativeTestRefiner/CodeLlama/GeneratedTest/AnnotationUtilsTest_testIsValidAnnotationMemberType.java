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
import java.util.List;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testIsValidAnnotationMemberType
public class AnnotationUtilsTest_testIsValidAnnotationMemberType {
@Test
public void testIsValidAnnotationMemberType_otherTypes() throws Exception {
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(Object.class));
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(List.class));
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(Set.class));
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(Map.class));
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(Queue.class));
    assertFalse(AnnotationUtils.isValidAnnotationMemberType(Stack.class));
}
}