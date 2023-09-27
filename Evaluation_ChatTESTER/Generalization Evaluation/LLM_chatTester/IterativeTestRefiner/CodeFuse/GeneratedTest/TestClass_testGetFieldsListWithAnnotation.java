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
import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/FieldUtilsTest###testGetFieldsListWithAnnotation
public class TestClass_testGetFieldsListWithAnnotation {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyCustomAnnotation {}
    private class MyClass {
        @MyCustomAnnotation
        int myInt1;
        String myString2;
        double myDouble3;
    }
    @Test
    public void testGetFieldsListWithAnnotation() throws Exception{
        MyClass obj = new MyClass();
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(obj.getClass(), MyCustomAnnotation.class);
        assertNotNull("Return value should not be null", fields);
        assertEquals("Number of fields returned should match number of annotations found", 1, fields.size());
        assertEquals("First element should have correct name", "myInt1", fields.get(0).getName());
    }
}