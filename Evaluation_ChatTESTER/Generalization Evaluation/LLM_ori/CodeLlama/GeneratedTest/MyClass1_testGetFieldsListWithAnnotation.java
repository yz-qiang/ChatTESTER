package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.testbed.Ambig;
import org.apache.commons.lang3.reflect.testbed.Annotated;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.PrivatelyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.PublicChild;
import org.apache.commons.lang3.reflect.testbed.PubliclyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.StaticContainer;
import org.apache.commons.lang3.reflect.testbed.StaticContainerChild;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/FieldUtilsTest###testGetFieldsListWithAnnotation
@Test
public void testGetFieldsListWithAnnotation() throws Exception {
    @Retention(RUNTIME)
    public @interface MyAnnotation {}
    public class MyClass1_testGetFieldsListWithAnnotation {
        @MyAnnotation
        private String myString;
        @MyAnnotation
        private int myInt;
    }
    public class MyClass2 {
        @MyAnnotation
        private boolean myBoolean;
        @MyAnnotation
        private double myDouble;
    }
    assertEquals("myString", Arrays.asList(FieldUtils.getFieldsListWithAnnotation(MyClass1_testGetFieldsListWithAnnotation.class, MyAnnotation.class)).get(0).getName());
    assertEquals("myInt", Arrays.asList(FieldUtils.getFieldsListWithAnnotation(MyClass1_testGetFieldsListWithAnnotation.class, MyAnnotation.class)).get(1).getName());
    assertEquals("myBoolean", Arrays.asList(FieldUtils.getFieldsListWithAnnotation(MyClass2.class, MyAnnotation.class)).get(0).getName());
    assertEquals("myDouble", Arrays.asList(FieldUtils.getFieldsListWithAnnotation(MyClass2.class, MyAnnotation.class)).get(1).getName());
    assertEquals(Collections.<Field>emptyList(), FieldUtils.getFieldsListWithAnnotation(Object.class, MyAnnotation.class));
}