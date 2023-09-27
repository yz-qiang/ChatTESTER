package org.apache.commons.lang3.reflect;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.GenericParent;
import org.apache.commons.lang3.reflect.testbed.GenericTypeHolder;
import org.apache.commons.lang3.reflect.testbed.StringParameterizedChild;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testIsAssignable
public class TypeUtilsTest_testIsAssignable {
    private TypeUtils typeUtils = new TypeUtils();
    @Before
    public void setUp(){
    }
    @Test
    public void testIsAssignableWithValidInputAndOutput() throws Exception{
        assertTrue(typeUtils.isAssignable(Integer.TYPE, Integer.class));
        assertTrue(typeUtils.isAssignable(Double[].class, Number[].class));
        assertTrue(typeUtils.isAssignable(Number[].class, Object.class));
        assertFalse(typeUtils.isAssignable(Boolean.TYPE, String.class));
        assertFalse(typeUtils.isAssignable(null, Double.class));
    }
    @Test
    public void testIsAssignableWithInvalidInput() throws Exception{
        try {
           typeUtils.isAssignable(null, null);
          fail("Expected NullPointerException");
       } catch (IllegalArgumentException e){
             assertNotNull(e);
       }
       try {
           typeUtils.isAssignable(new ArrayList<>().getClass(), List.class);
           fail("Expected UnsupportedOperationException");
       } catch (UnsupportedOperationException e){
           assertNotNull(e);
       }
   }
   @Test
   public void testIsAssignableWithBoundaryValues() throws Exception{
       assertTrue(typeUtils.isAssignable(Void.TYPE, Void.TYPE));
       assertFalse(typeUtils.isAssignable(void.class, int.class));
       assertTrue(typeUtils.isAssignable(int.class, Serializable.class));
       assertFalse(typeUtils.isAssignable(double.class, char.class));
   }
}