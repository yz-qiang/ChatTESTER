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
public class TTT_testClone {
    @Test
    public void testClone() throws Exception {
        MySerializableObject obj1 = new MySerializableObject();
        obj1.setName("Original Object");
        obj1.setValue(42);
        MySerializableObject obj2 = SerializationUtils.clone(obj1);
        assertEquals(obj1, obj2);
        obj1.setName("Modified Original Object");
        assertNotEquals(obj1, obj2);
    }
}