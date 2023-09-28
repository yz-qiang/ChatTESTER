package nl.pvanassen.ns.model.prijzen;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/prijzen/PrijsHandleTest###testGetModel
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class PrijsHandleTest_testGetModel {
    @Test
    public void testGetModel() {
        String xmlString = "<VervoerderKeuzes>\n" +
                "    <VervoerderKeuze naam=\"NS\">\n" +
                "        <Tariefeenheden>2</Tariefeenheden>\n" +
                "        <ReisType name=\"Enkele reis\">\n" +
                "            <ReisKlasse klasse=\"1\">\n" +
                "                <Prijsdeel vervoerder=\"NS\" prijs=\"4.20\" van=\"Amsterdam\" naar=\"Utrecht\"/>\n" +
                "                <Prijsdeel vervoerder=\"NS\" prijs=\"2.80\" van=\"Utrecht\" naar=\"Den Haag\"/>\n" +
                "                <Totaal>7.00</Totaal>\n" +
                "                <Korting>\n" +
                "                    <Kortingsprijs name=\"Korting 65+\" prijs=\"5.00\"/>\n" +
                "                </Korting>\n" +
                "            </ReisKlasse>\n" +
                "        </ReisType>\n" +
                "    </VervoerderKeuze>\n" +
                "</VervoerderKeuzes>";
        ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes());
        PrijsHandle prijsHandle = new PrijsHandle();
        Prijzen prijzen = prijsHandle.getModel(stream);
        assertNotNull(prijzen);
        assertEquals(1, prijzen.getVervoerderKeuzes().size());
        VervoerderKeuze nsKeuze = prijzen.getVervoerderKeuzes().get("NS");
        assertNotNull(nsKeuze);
        assertEquals(2, nsKeuze.getTariefEenheden());
        assertEquals(1, nsKeuze.getReisTypes().size());
        ReisType enkeleReis = nsKeuze.getReisTypes().get("Enkele reis");
        assertNotNull(enkeleReis);
        assertEquals(1, enkeleReis.getReisKlassen().size());
        ReisKlasse eersteKlasse = enkeleReis.getReisKlassen().get(1);
        assertNotNull(eersteKlasse);
        Map<String, String> prijsdelen = eersteKlasse.getPrijsdelen();
        assertNotNull(prijsdelen);
        assertEquals(2, prijsdelen.size());
        assertEquals(new BigDecimal("7.00"), new BigDecimal(eersteKlasse.getTotaal()));
        Map<String, String> kortingprijzen = eersteKlasse.getKortingprijzen();
        assertNotNull(kortingprijzen);
        assertEquals(1, kortingprijzen.size());
        assertEquals(new BigDecimal("5.00"), new BigDecimal(kortingprijzen.get("Korting 65+")));
    }
}