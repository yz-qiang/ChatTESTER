package nl.pvanassen.ns.model.stations;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/stations/StationsHandleTest###testGetModel
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
public class StationsHandleTest_testGetModel {
    @Test
    public void testGetModel() {
        String xmlString = "<Stations>\n" +
                "  <Station>\n" +
                "    <Code>UT</Code>\n" +
                "    <Type>knooppuntIntercitystation</Type>\n" +
                "    <Namen>\n" +
                "      <Kort>Utrecht</Kort>\n" +
                "      <Middel>Utrecht Centraal</Middel>\n" +
                "      <Lang>Utrecht Centraal</Lang>\n" +
                "    </Namen>\n" +
                "    <Land>NL</Land>\n" +
                "    <UICCode>8400629</UICCode>\n" +
                "    <Lat>52.089444</Lat>\n" +
                "    <Lon>5.110278</Lon>\n" +
                "    <Synoniemen>\n" +
                "      <Synoniem>Utrecht CS</Synoniem>\n" +
                "      <Synoniem>Utrecht Centraal Station</Synoniem>\n" +
                "    </Synoniemen>\n" +
                "  </Station>\n" +
                "</Stations>";
        InputStream stream = new ByteArrayInputStream(xmlString.getBytes());
        StationsHandle stationsHandle = new StationsHandle();
        Stations stations = stationsHandle.getModel(stream);
        assertNotNull(stations);
        List<Station> stationList = new ArrayList<>(stations.getStations());
        assertNotNull(stationList);
        assertEquals(1, stationList.size());
        Station station = stationList.get(0);
        assertNotNull(station);
        assertEquals("UT", station.getCode());
        assertEquals("knooppuntIntercitystation", station.getType());
        assertNotNull(station.getNamen());
        assertEquals("Utrecht", station.getNamen().getKort());
        assertEquals("Utrecht Centraal", station.getNamen().getMiddel());
        assertEquals("Utrecht Centraal", station.getNamen().getLang());
        assertEquals("NL", station.getLand());
        assertEquals(8400629, station.getUicCode());
        assertEquals(52.089444, station.getLat(), 0.0);
        assertEquals(5.110278, station.getLon(), 0.0);
        List<String> synoniemen = new ArrayList<>();
        synoniemen.add("Utrecht CS");
        synoniemen.add("Utrecht Centraal Station");
        assertEquals(synoniemen, station.getSynoniemen());
    }
}