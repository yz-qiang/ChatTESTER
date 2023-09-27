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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testGetRawType
public class TypeUtilsTest_testGetRawType {
    private TypeUtils typeUtils;
    @Before
    public void setUp(){
       typeUtils = new TypeUtils();
    }
    @Test
    public void testGetRawTypeWithClassObjectInput() throws Exception{
        Class<?> clazz = String.class;
        assertNotNull(typeUtils.getRawType(clazz, null));
        assertSame(clazz, typeUtils.getRawType(clazz, null));
    }
    @Test
    public void testGetRawTypeWithParameterizedTypeInput() throws Exception{
        ParameterizedType parameterizedType = new ParameterizedTypeImpl(null, List.class, new Type[]{Integer.class});
        assertNotNull(typeUtils.getRawType(parameterizedType, null));
        assertSame(List.class, typeUtils.getRawType(parameterizedType, null));
    }
    @Test
    public void testGetRawTypeWithTypeVariableNoAssignmentType() throws Exception{
        TypeVariable<?> typeVariable = Foo.class.getTypeParameters()[0];
        assertNull(typeUtils.getRawType(typeVariable, null));
    }
    @Test
    public void testGetRawTypeWithTypeVariableAndAssignmentType() throws Exception{
        TypeVariable<?> typeVariable = GenericParent.class.getTypeParameters()[1];
        Type[] types = new Type[]{String.class};
        Method method = GenericParent.class.getDeclaredMethods()[0];
        Type declaringClass = method.getGenericReturnType().getOwnerType();
        assertNotNull(typeUtils.getRawType(typeVariable, declaringClass));
        assertSame(String.class, typeUtils.getRawType(typeVariable, declaringClass));
    }
    @Test
    public void testGetRawTypeWithGenericArrayType() throws Exception{
        GenericArrayType arrayType = new GenericArrayTypeImpl(String.class);
        assertNotNull(typeUtils.getRawType(arrayType, null));
        assertSame(String[].class, typeUtils.getRawType(arrayType, null));
    }
    @Test
    public void testGetRawTypeWithWildCardType() throws Exception{
        WildcardType wildcardType = new WildcardTypeImpl(new Type[]{}, new Type[]{});
        try {
           typeUtils.getRawType(wildcardType, null);
          fail("Expected exception not thrown");
      } catch (IllegalArgumentException e){
             assertEquals("unknown type: "+wildcardType, e.getMessage());
      }
   }
}