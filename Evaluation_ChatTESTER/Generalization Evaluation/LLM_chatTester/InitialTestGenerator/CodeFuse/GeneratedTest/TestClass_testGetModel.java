package nl.pvanassen.ns.model.stations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
public class TestClass_testGetModel {
    @Test
    public void testGetModel() throws ParserConfigurationException, SAXException, IOException {
        byte[] xmlData = "<Stations>" +
                      "   <Station>" +
                      "       <Code>AMS</Code>" +
                      "       <Type>Main</Type>" +
                      "       <Namen><Kort>Amsterdam</Kort></Namen>" +
                      "       <Namen><Middel>Amsterdam Centraal</Middel></Namen>" +
                      "       <Namen><Lang>Amsterdam Central Station</Lang></Namen>" +
                      "       <Land>NL</Land>" +
                      "       <UICCode>840001265</UICCode>" +
                      "       <Lat>52.37916667</Lat>" +
                      "       <Lon>4.8916667</Lon>" +
                      "       <Synoniemen>" +
                      "           <Synoniem>Central Station Amsterdam</Synoniem>" +
                      "           <Synoniem>CS</Synoniem>" +
                      "       </Synoniemen>" +
                      "</Station>" +
                      "</Stations>";
        InputStream stream = new ByteArrayInputStream(xmlData);
        Stations result = StationsHandle.getModel(stream);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.containsKey("AMS"));
        assertEquals("Main", result.get("AMS").getType());
        assertEquals("Amsterdam", result.get("AMS").getName().getShortName());
        assertEquals("Amsterdam Centraal", result.get("AMS").getName().getMediumName());
        assertEquals("Amsterdam Central Station", result.get("AMS").getName().getLongName());
        assertEquals("NL", result.get("AMS").getCountry());
        assertEquals(840001265, result.get("AMS").getUICCode());
        assertEquals(52.37916667, result.get("AMS").getLatitude(), 0.000001);
        assertEquals(4.8916667, result.get("AMS").getLongitude(), 0.00001);
        assertEquals(2, result.get("AMS").getSynonyms().size());
        assertEquals("Central Station Amsterdam", result.get("AMS").getSynonyms().get(0));
        assertEquals("CS", result.get("AMS").getSynonyms().get(1));
    }
}