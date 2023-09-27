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
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testToLongString
public class TypeUtilsTest_testToLongString {
    private TypeUtils typeUtils;
    @Before
    public void setUp(){
       typeUtils = new TypeUtils();
    }
    @Test(expected=IllegalArgumentException.class)
    public void testToLongStringWithNullInput() throws Exception{
         assertNull("Expected IllegalArgumentException", typeUtils.toLongString(null));
    }
    @Test
    public void testToLongStringWhenVarIsOfClass() throws NoSuchFieldException {
        Field field = Foo.class.getDeclaredField("T");
        TypeVariable tv = (TypeVariable)field.getGenericType();
        String expectedOutput = "org.apache.commons.lang3.reflect.testbed.Foo:T";
        String actualOutput = typeUtils.toLongString(tv);
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testToLongStringWhenVarIsOfParametrizedType() throws NoSuchFieldException {
        Field field = StringParameterizedChild.class.getDeclaredField("value");
        TypeVariable tv = (TypeVariable)field.getGenericType();
        String expectedOutput = "org.apache.commons.lang3.reflect.testbed.StringParameterizedChild:T#Ljava/lang/Object;";
        String actualOutput = typeUtils.toLongString(tv);
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testToLongStringWhenVarIsOfGenericDeclaration() throws NoSuchFieldException {
        Field field = GenericParent.class.getDeclaredField("t");
        TypeVariable tv = (TypeVariable)field.getGenericType();
        String expectedOutput = "org.apache.commons.lang3.reflect.testbed.GenericParent:T#Ljava/lang/Object;";
        String actualOutput = typeUtils.toLongString(tv);
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testToLongStringWhenVarIsOfWildCardType() throws NoSuchFieldException {
        Field field = GenericTypeHolder.class.getDeclaredField("wildcards");
        TypeVariable tv = ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
        String expectedOutput = "org.apache.commons.lang3.reflect.testbed.GenericTypeHolder:U#+? extends java.lang.Number&java.lang.Comparable<?>";
        String actualOutput = typeUtils.toLongString(tv);
        assertEquals(expectedOutput,actualOutput);
    }
}