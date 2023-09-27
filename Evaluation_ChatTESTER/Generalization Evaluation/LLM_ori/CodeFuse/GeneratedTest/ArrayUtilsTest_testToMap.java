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
    @Test
    public void testToMapWithValidInput(){
        String key1 = "key1";
        Integer value1 = 1;
        Entry<String,Integer> entry1 = new AbstractMap.SimpleImmutableEntry<>(key1,value1);
        String key2 = "key2";
        Integer value2 = 2;
        Entry<String,Integer> entry2 = new AbstractMap.SimpleImmutableEntry<>(key2,value2);
        Object[] arr = {entry1,entry2};
        Map<Object, Object> result = ArrayUtils.toMap(arr);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(value1, result.get(key1));
        assertEquals(value2, result.get(key2));
    }
    @Test
    public void testToMapWithInvalidInput(){
      Object[] arr = {"invalid"};
       try{
              Map<Object, Object> result = ArrayUtils.toMap(arr);
               fail("Expected exception not thrown.");
       } catch(IllegalArgumentException e){
             assertEquals("Array element 0, 'invalid', is neither of type Map.Entry nor an Array",e.getMessage());
       }
    }
    @Test
    public void testToMapWithEmptyInput(){
        Object[] arr = {};
        Map<Object, Object> result = ArrayUtils.toMap(arr);
        assertNotNull(result);
        assertEquals(0, result.size());
    }
    @Test
    public void testToMapWithNullInput(){
        Map<Object, Object> result = ArrayUtils.toMap(null);
        assertNull(result);
    }
    @Test
    public void testToMapWithNonEntryAndNonArrayElement(){
        Object[] arr = {new Date(), "non-array"};
        try{
            Map<Object, Object> result = ArrayUtils.toMap(arr);
            fail("Expected exception not thrown.");
        }catch(IllegalArgumentException e){
            assertEquals("Array element 0, 'Thu Jan 01 00:00:00 IST 1970', is neither of type Map.Entry nor an Array",e.getMessage());
        }
    }
    @Test
    public void testToMapWithShortArray(){
        Object[] arr = {new int[]{1}};
        try{
            Map<Object, Object> result = ArrayUtils.toMap(arr);
            fail("Expected exception not thrown.");
        }catch(IllegalArgumentException e){
            assertEquals("Array element 0, '[Ljava.lang.Integer;@6d4c3a8b6f', has a length less than 2",e.getMessage());
        }
    }
}