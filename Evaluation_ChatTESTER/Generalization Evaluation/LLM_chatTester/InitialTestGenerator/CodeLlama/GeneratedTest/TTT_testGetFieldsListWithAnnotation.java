package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.testbed.Ambig;
import org.apache.commons.lang3.reflect.testbed.Annotated;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.PrivatelyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.PublicChild;
import org.apache.commons.lang3.reflect.testbed.PubliclyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.StaticContainer;
import org.apache.commons.lang3.reflect.testbed.StaticContainerChild;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/reflect/FieldUtilsTest###testGetFieldsListWithAnnotation
public class TTT_testGetFieldsListWithAnnotation {
@Test
public void testGetFieldsListWithAnnotation() throws Exception {
    Class<?> cls = StaticContainer.class;
    Class<? extends Annotation> annotationCls = MyAnnotation.class;
    List<Field> expectedFields = Arrays.asList(new Field[] {
            StaticContainer.class.getDeclaredField("myField"),
            StaticContainer.class.getDeclaredField("anotherField") });
    List<Field> actualFields = FieldUtils.getFieldsListWithAnnotation(cls, annotationCls);
    assertEquals(expectedFields, actualFields);
}
}