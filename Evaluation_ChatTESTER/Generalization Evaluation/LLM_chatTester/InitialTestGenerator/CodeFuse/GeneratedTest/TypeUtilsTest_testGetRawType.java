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
    public void testGetRawTypeWithClassType() throws Exception{
        assertEquals(Integer.class, typeUtils.getRawType(Integer.TYPE, String.class));
    }
    @Test
    public void testGetRawTypeWithParameterizedType() throws Exception{
        assertEquals(String.class, typeUtils.getRawType(new ArrayList<>().getClass().getGenericSuperclass(), String.class));
    }
    @Test
    public void testGetRawTypeWithTypeVariableAndNoAssignment() throws Exception{
        assertNull(typeUtils.getRawType(T.class.getTypeParameters()[0], Integer.class));
    }
    @Test
    public void testGetRawTypeWithTypeVariableAndAssignment() throws Exception{
        assertEquals(Number.class, typeUtils.getRawType(T.class.getTypeParameters()[1], Number.class));
    }
    @Test
    public void testGetRawTypeWithGenericArrayType() throws Exception{
        assertEquals(int[][].class, typeUtils.getRawType(new int[][]{}.getClass().getComponentType(), String.class));
    }
    @Test(expected=IllegalArgumentException.class)
    public void testGetRawTypeWithUnknownType() throws Exception{
        typeUtils.getRawType(null, String.class);
    }
    interface T extends Serializable {}
}