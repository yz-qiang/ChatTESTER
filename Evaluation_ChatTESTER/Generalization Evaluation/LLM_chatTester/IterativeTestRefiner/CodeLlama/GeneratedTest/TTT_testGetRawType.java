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
public class TTT_testGetRawType {
@Test
public void testGetRawType() throws Exception {
    assertEquals(Integer.class, TypeUtils.getRawType(Integer.class));
    assertEquals(List.class, TypeUtils.getRawType(new ParameterizedTypeImpl(null, List.class, String.class)));
    assertEquals(Object.class, TypeUtils.getRawType(new WildcardTypeImpl(null, null, null)));
    assertEquals(Number.class, TypeUtils.getRawType(new TypeVariableImpl(null, Number.class)));
    assertEquals(Integer[][].class, TypeUtils.getRawType(new GenericArrayTypeImpl(Integer.class, Integer.class)));
    assertEquals(List[][].class, TypeUtils.getRawType(new GenericArrayTypeImpl(List.class, String.class)));
    assertEquals(null, TypeUtils.getRawType(new NonReifiableType()));
    assertEquals(null, TypeUtils.getRawType(new NoCorrespondingClassType()));
}
}