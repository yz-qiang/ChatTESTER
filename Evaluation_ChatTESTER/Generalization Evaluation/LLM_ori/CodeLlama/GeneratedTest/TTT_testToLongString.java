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
public class TTT_testToLongString {
@Test
public void testToLongString_withValidInput() throws Exception {
    TypeVariable<?> typeVarMock = Mockito.mock(TypeVariable.class);
    GenericDeclaration declMock = Mockito.mock(GenericDeclaration.class);
    Class<?> clazzMock = Mockito.mock(Class.class);
    Method methodMock = Mockito.mock(Method.class);
    Field fieldMock = Mockito.mock(Field.class);
    when(declMock.getEnclosingClass()).thenReturn(clazzMock);
    when(methodMock.getGenericDeclaration()).thenReturn(declMock);
    when(fieldMock.getGenericDeclaration()).thenReturn(declMock);
    when(typeVarMock.getGenericDeclaration()).thenReturn(declMock);
    when(typeVarMock.getName()).thenReturn("T");
    when(clazzMock.getName()).thenReturn("com.example.MyClass");
    when(methodMock.getName()).thenReturn("myMethod");
    when(fieldMock.getName()).thenReturn("myField");
    String result = TypeUtils.toLongString(typeVarMock);
    assertThat(result).isEqualTo("com.example.MyClass:T");
}
}