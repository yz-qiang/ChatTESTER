package org.apache.commons.lang3.reflect;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testIsAssignable
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
import org.junit.Test;
import static org.junit.Assert.*;
public class TypeUtilsTest_testIsAssignable {
    @Test
    public void testIsAssignable() {
        assertTrue(TypeUtils.isAssignable(null, null));
        assertFalse(TypeUtils.isAssignable(null, int.class));
        assertFalse(TypeUtils.isAssignable(null, String.class));
        assertFalse(TypeUtils.isAssignable(int.class, null));
        assertFalse(TypeUtils.isAssignable(String.class, null));
        assertTrue(TypeUtils.isAssignable(int.class, int.class));
        assertTrue(TypeUtils.isAssignable(String.class, String.class));
        assertTrue(TypeUtils.isAssignable(String.class, CharSequence.class));
        assertTrue(TypeUtils.isAssignable(ArrayList.class, List.class));
        assertTrue(TypeUtils.isAssignable(TreeSet.class, Collection.class));
        assertFalse(TypeUtils.isAssignable(String.class, Integer.class));
        assertFalse(TypeUtils.isAssignable(ArrayList.class, Map.class));
        assertTrue(TypeUtils.isAssignable(TypeUtils.parameterize(GenericTypeHolder.class, String.class).getType(), String.class));
        assertTrue(TypeUtils.isAssignable(TypeUtils.parameterize(GenericTypeHolder.class, TypeUtils.parameterize(List.class, String.class)).getType(), List.class));
        assertTrue(TypeUtils.isAssignable(TypeUtils.parameterize(GenericTypeHolder.class, TypeUtils.parameterize(Map.class, String.class, Integer.class)).getType(), Map.class));
        assertFalse(TypeUtils.isAssignable(TypeUtils.parameterize(GenericTypeHolder.class, String.class).getType(), Integer.class));
        assertFalse(TypeUtils.isAssignable(TypeUtils.parameterize(GenericTypeHolder.class, TypeUtils.parameterize(List.class, String.class)).getType(), Map.class));
        assertTrue(TypeUtils.isAssignable(Foo.class.getTypeParameters()[0], String.class));
        assertTrue(TypeUtils.isAssignable(GenericParent.class.getTypeParameters()[0], String.class));
        assertFalse(TypeUtils.isAssignable(Foo.class.getTypeParameters()[0], Integer.class));
        assertFalse(TypeUtils.isAssignable(GenericParent.class.getTypeParameters()[0], Integer.class));
        assertTrue(TypeUtils.isAssignable(new String[0].getClass(), String[].class));
        assertTrue(TypeUtils.isAssignable(new String[0].getClass(), Object[].class));
        assertTrue(TypeUtils.isAssignable(new String[0].getClass(), Serializable[].class));
        assertFalse(TypeUtils.isAssignable(new String[0].getClass(), Integer[].class));
        assertFalse(TypeUtils.isAssignable(new Integer[0].getClass(), String[].class));
        assertFalse(TypeUtils.isAssignable(StringParameterizedChild.class.getTypeParameters()[0], String.class));
        assertTrue(TypeUtils.isAssignable(StringParameterizedChild.class.getTypeParameters()[0], Integer.class));
    }
}