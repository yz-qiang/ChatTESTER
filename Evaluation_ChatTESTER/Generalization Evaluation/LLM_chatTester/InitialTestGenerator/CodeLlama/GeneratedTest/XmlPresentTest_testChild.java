package nl.pvanassen.ns.xml;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/xml/XmlPresentTest###testChild
public 
class XmlPresentTest_testChild {
    @Test
    void testChildMethodWithValidInput() throws Exception {
        InputStream stream = getResourceAsStream("/testdata/valid_input.xml");
        String rootName = "root";
        XmlPresent xmlPresent = new XmlPresent(stream, rootName);
        Xml result = xmlPresent.child("child");
        assertNotNull(result);
        assertEquals("child", result.getName());
        assertEquals("value", result.getValue());
    }
    @Test
    void testChildMethodWithInvalidInput() throws Exception {
        InputStream stream = getResourceAsStream("/testdata/invalid_input.xml");
        String rootName = "root";
        XmlPresent xmlPresent = new XmlPresent(stream, rootName);
        Xml result = xmlPresent.child("nonExistentChild");
        assertNull(result);
    }
    @ParameterizedTest
    @CsvSource({"valid_input.xml, root, child", "invalid_input.xml, root, nonExistentChild"})
    void testChildMethodWithDifferentScenarios(String fileName, String rootName, String childName) throws Exception {
        InputStream stream = getResourceAsStream("/testdata/" + fileName);
        XmlPresent xmlPresent = new XmlPresent(stream, rootName);
        Xml result = xmlPresent.child(childName);
        if ("valid_input.xml".equals(fileName)) {
            assertNotNull(result);
            assertEquals(childName, result.getName());
            assertEquals("value", result.getValue());
        } else {
            assertNull(result);
        }
    }
}