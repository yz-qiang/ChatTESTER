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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testParameterize
public class TypeUtilsTest_testParameterize {
    private static TypeUtils typeUtils = new TypeUtils();
    @BeforeClass
    public static void setUp(){
    }
    @Test
    public void testParameterize() throws NoSuchMethodException{
        Class<?> raw = StringParameterizedChild.class;
        Map<TypeVariable<? extends GenericDeclaration, ? extends Type> map = new HashMap<>();
        TypeVariable<?> tv1 = StringParameterizedChild.class.getTypeParameters()[0];
        Type t1 = Integer.TYPE;
        map.put(tv1,t1);
        ParameterizedType expectedOutput = (ParameterizedType) ((ParameterizedType) StringParameterizedChild.class.getSuperclass().asSubclass(GenericParent.class).getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ParameterizedType actualOutput = typeUtils.parameterize(raw,map);
        assertEquals("The result should match the expected output", expectedOutput, actualOutput);
    }
} 