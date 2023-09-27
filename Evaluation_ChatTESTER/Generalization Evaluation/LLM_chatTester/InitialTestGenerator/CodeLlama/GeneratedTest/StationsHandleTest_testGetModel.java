package nl.pvanassen.ns.model.stations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
public class StationsHandleTest_testGetModel {
    @Test
    public void testGetModel() throws Exception {
        String xmlData = "<Stations>" +
                "<Station><Code>1234567890</Code><Type>train</Type><Namen><Kort>Amsterdam Centraal</Kort><Middel>Central Station Amsterdam</Middel><Lang>Amsterdam Central Train Station</Lang></Namen><Land>NL</Land><UICCode>1234567890</UICCode><Lat>52.37403</Lat><Lon>4.89953</Lon><Synoniemen><Synoniem>Amsterdam CS</Synoniem><Synoniem>AMS</Synoniem></Synoniemen></Station>" +
                "</Stations>";
        InputStream stream = new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8));
        Stations result = new StationsHandle().getModel(stream);
        assertNotNull(result);
        assertEquals(1, result.getStations().size());
        Station station = result.getStations().get(0);
        assertEquals("1234567890", station.getCode());
        assertEquals("train", station.getType());
        assertEquals("Amsterdam Centraal", station.getName().getKort());
        assertEquals("Central Station Amsterdam", station.getName().getMiddel());
        assertEquals("Amsterdam Central Train Station", station.getName().getLang());
        assertEquals("NL", station.getLand());
        assertEquals(1234567890, station.getUICCode());
        assertEquals(52.37403, station.getLatitude());
        assertEquals(4.89953, station.getLongitude());
        assertEquals(2, station.getSynonyms().size());
        assertTrue(station.getSynonyms().contains("Amsterdam CS"));
        assertTrue(station.getSynonyms().contains("AMS"));
    }
}