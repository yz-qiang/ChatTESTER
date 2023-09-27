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
import static org.junit.Assert.assertNotNull;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/TypeUtilsTest###testParameterize
public class TTT_testParameterize {
@Test
public void testParameterize() throws NoSuchMethodException, SecurityException {
    Class<StringParameterizedChild> rawClass = StringParameterizedChild.class;
    Map<TypeVariable<?>, Type> typeArgs = new HashMap<>();
    typeArgs.put(StringParameterizedChild.class.getTypeParameters()[0], Integer.class);
    typeArgs.put(StringParameterizedChild.class.getTypeParameters()[1], Double.class);
    ParameterizedType result = TypeUtils.parameterize(rawClass, typeArgs);
    assertNotNull(result);
    assertEquals(rawClass, result.getRawType());
    assertEquals(2, result.getActualTypeArguments().length);
    assertEquals(Integer.class, result.getActualTypeArguments()[0]);
    assertEquals(Double.class, result.getActualTypeArguments()[1]);
}
}