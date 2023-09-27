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
import org.junit.Assert;
import org.junit.BeforeClass;
import java.util.Collections;
import org.apache.commons.lang3.reflect.TypeUtils;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testParameterize
public class TypeUtilsTest_testParameterize {
    private static TypeUtils typeUtils = new TypeUtils();
    private static Map<TypeVariable<? extends GenericDeclaration, ? extends Type> mappings;
    @BeforeClass
    public static void setUp(){
        mappings = new HashMap<>();
        mappings.put(((new Foo()).getClass().getSuperclass().getTypeParameters()[0], String.class);
        mappings.put((new Foo()).getClass().getSuperclass().getTypeParameters()[1], Integer.class);
    }
    @Test
    public void testParameterizeNotNull() throws Exception{
        assertNotNull("Returned value should not be null", typeUtils.parameterize(Foo.class, mappings));
    }
    @Test
    public void testParameterizeCorrectValue() throws Exception{
        ParameterizedType expectedResult = ((ParameterizedType) (new Foo()).getClass().getGenericSuperclass();
        assertEquals("The returned result does not match the expected one.", expectedResult, typeUtils.parameterize(Foo.class, mappings));
    }
    @Test
    public void testParameterizeInvalidParams() throws Exception{
        assertNull("Returned value should be null", typeUtils.parameterize(null, Collections.<TypeVariable<?>, Type>emptyMap());
    }
    @Test
    public void testParameterizeEmptyMapping() throws Exception{
        assertNull("Returned value should be null", typeUtils.parameterize(Foo.class, Collections.<TypeVariable<?>, Type>emptyMap());
    }
}