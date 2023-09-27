package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ArrayUtilsTest###testToMap
public class ArrayUtilsTest_testToMap {
    private static ArrayUtils arrayUtils;
    @BeforeClass
    public static void setUp(){
         arrayUtils = new ArrayUtils();
    }
    @Test
    public void testToMapWithSingleEntryInput() throws Exception{
        Object[] arr = new Object[]{new AbstractMap.SimpleImmutableEntry<String, Integer>(null,"test")};
        assertEquals(1, arrayUtils.toMap(arr).size());
    }
    @Test
    public void testToMapWithMultipleEntries() throws Exception{
        Object[] arr = new Object[]{new AbstractMap.SimpleImmutableEntry<Integer, String>(1,"one"), new AbstractMap.SimpleImmutableEntry<Double, Date>(3.4, new Date()), new AbstractMap.SimpleImmutableEntry<Character, Boolean>('a', true)};
        assertEquals(3, arrayUtils.toMap(arr).size());
    }
    @Test
    public void testToMapWithMixedObjects() throws Exception{
        Object[] arr = new Object[]{new AbstractMap.SimpleImmutableEntry<String, Integer>(null,"test"), new int[]{1}, new double[]{1.0}};
        try {
           arrayUtils.toMap(arr);
          fail("Expected exception not thrown.");
       } catch (IllegalArgumentException e){
             assertEquals("Array element 1, '[Ljava.lang.Object;@xxxxxx', is neither of type Map.Entry nor an Array",e.getMessage());
       }
    }
    @Test
    public void testToMapWithInvalidSizeArray() throws Exception{
        Object[] arr = new Object[]{new int[]{1}};
        try {
           arrayUtils.toMap(arr);
          fail("Expected exception not thrown.");
       } catch (IllegalArgumentException e){
             assertEquals("Array element 0, '[I@xxxxxx', has a length less than 2",e.getMessage());
       }
    }
    @Test
    public void testToMapWithNullInput() throws Exception{
        Object[] arr=null;
        assertNull(arrayUtils.toMap(arr));
    }
    @Test
    public void testToMapWithNonValidTypes() throws Exception{
        Object[] arr={"invalid","type"};
        try {
           arrayUtils.toMap(arr);
          fail("Expected exception not thrown.");
       } catch (IllegalArgumentException e){
             assertEquals("Array element 0, 'invalid', is neither of type Map.Entry nor an Array",e.getMessage());
       }
    }
}