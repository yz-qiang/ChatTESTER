package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/SerializationUtilsTest###testClone
public class TestSerializationUtils_testClone {
    private MyClass myObj; 
    @Before
    public void setUp(){
         myObj = new MyClass(); 
    }
    @Test
    public void testCloneWithValidInput() throws Exception{
        Object result = SerializationUtils.clone(myObj);
        assertNotNull(result);
        assertTrue(result instanceof MyClass);
        assertEquals(myObj, result);
    }
    @Test
    public void testCloneWithInvalidInput() throws Exception{
        Object result = SerializationUtils.clone(null);
        assertNull(result);
    }
    @Test
    public void testCloneWithNonSerializableInput() throws Exception{
        NonSerializable nonSerializeableObj = new NonSerializable();
        try{
            Object result = SerializationUtils.clone(nonSerializeableObj);
            fail("Should have thrown exception");
        }catch(SerializationException e){
           assertTrue(true);
       }
    }
}