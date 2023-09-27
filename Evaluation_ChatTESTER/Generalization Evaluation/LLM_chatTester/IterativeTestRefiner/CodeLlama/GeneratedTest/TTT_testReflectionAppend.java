package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/builder/EqualsBuilderTest###testReflectionAppend
public class TTT_testReflectionAppend {
    @Test
    public void testReflectionAppend() throws NoSuchFieldException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        MyClass obj1 = new MyClass();
        obj1.setName("John");
        obj1.setAge(25);
        MyClass obj2 = new MyClass();
        obj2.setName("Jane");
        obj2.setAge(30);
        EqualsBuilder builder = new EqualsBuilder().reflectionAppend(obj1, obj2);
        assertFalse(builder.isEquals());
    }
}