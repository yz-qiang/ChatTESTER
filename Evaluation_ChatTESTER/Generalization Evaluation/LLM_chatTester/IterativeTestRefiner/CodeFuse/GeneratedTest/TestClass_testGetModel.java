package nl.pvanassen.ns.model.stations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import java.nio.charset.StandardCharsets;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
public class TestClass_testGetModel {
    @Test
    public void testGetModel() throws ParserConfigurationException, SAXException, IOException {
        String xmlData = "<Stations>" +
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
        byte[] xmlDataBytes = xmlData.getBytes(StandardCharsets.UTF_8);
        InputStream stream = new ByteArrayInputStream(xmlDataBytes);
        StationsHandle stationsHandle = new StationsHandle();
        Stations result = stationsHandle.getModel(stream);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        Assert.assertTrue(result.containsKey("AMS"));
        Assert.assertEquals("Main", result.get("AMS").getType());
        Assert.assertEquals("Amsterdam", result.get("AMS").getName().getShortName());
        Assert.assertEquals("Amsterdam Centraal", result.get("AMS").getName().getMediumName());
        Assert.assertEquals("Amsterdam Central Station", result.get("AMS").getName().getLongName());
        Assert.assertEquals("NL", result.get("AMS").getCountry());
        Assert.assertEquals(840001265, result.get("AMS").getUICCode());
        Assert.assertEquals(52.37916667, result.get("AMS").getLatitude(), 0.00001);
        Assert.assertEquals(4.8916667, result.get("AMS").getLongitude(), 0.00001);
        Assert.assertEquals(2, result.get("AMS").getSynonyms().size());
        Assert.assertEquals("Central Station Amsterdam", result.get("AMS").getSynonyms().get(0));
        Assert.assertEquals("CS", result.get("AMS").getSynonyms().get(1));
    }
}