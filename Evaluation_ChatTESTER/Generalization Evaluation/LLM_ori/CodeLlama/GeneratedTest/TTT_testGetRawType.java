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
    List<Object[]> testData = new ArrayList<>();
    testData.add(new Object[]{Integer.class, Integer.TYPE});
    testData.add(new Object[]{Double.class, Double.TYPE});
    testData.add(new Object[]{Float.class, Float.TYPE});
    testData.add(new Object[]{Long.class, Long.TYPE});
    testData.add(new Object[]{Short.class, Short.TYPE});
    testData.add(new Object[]{Byte.class, Byte.TYPE});
    testData.add(new Object[]{Character.class, Character.TYPE});
    testData.add(new Object[]{Boolean.class, Boolean.TYPE});
    testData.add(new Object[]{Void.class, Void.TYPE});
    testData.add(new Object[]{null, null});
    for (int i = 0; i < testData.size(); i++) {
        Object[] currentTestData = testData.get(i);
        Class<?> expectedResult = (Class<?>) currentTestData[1];
        assertEquals(expectedResult, TypeUtils.getRawType((Type) currentTestData[0], null));
    }
}
}