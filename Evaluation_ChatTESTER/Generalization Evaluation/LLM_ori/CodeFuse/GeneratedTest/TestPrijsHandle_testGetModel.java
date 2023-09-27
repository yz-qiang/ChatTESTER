package nl.pvanassen.ns.model.prijzen;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/prijzen/PrijsHandleTest###testGetModel
public class TestPrijsHandle_testGetModel {
    private static final String XML_FILENAME = "/path/to/your/file"; 
    private static Prijzen prijzen;
    @BeforeClass
    public static void setUp() throws Exception{
        InputStream inputStream = new FileInputStream(XML_FILENAME);
        Unmarshaller unmarshaller = JAXBContext.newInstance(Prijzen.class).createUnmarshaller();
        Source source = new StreamSource(inputStream);
        prijzen = (Prijzen) unmarshaller.unmarshal(source);
    }
    @Test
    public void testGetModel(){
        assertThat(prijzen, notNullValue());
        assertThat(prijzen.getVervoerders(), hasSize(2));
        Optional<VervoerderKeuze> opt1 = prijzen.getVervoerders().values().stream().filter(v -> v.getName().equalsIgnoreCase("Vervoerder 1")).findFirst();
        assertTrue(opt1.isPresent());
        VervoerderKeuze keuze1 = opt1.orElseThrow(() -> new AssertionError("Expected 'Vervoerder 1' in list but it was missing!"));
        assertThat(keuze1.getTariefeenheden(), equalTo(50));
        assertThat(keuze1.getReistypes(), hasKey("Bus"));
        assertThat(keuze1.getReistypes().get("Bus").getKlasses(), hasKey(3));
        assertThat(keuze1.getReistypes().get("Bus").getKlas(3).getTotalPrice(), equalTo(new BigDecimal("49.87"));
        assertThat(keuze1.getReistypes().get("Bus").getKlas(3).getPrijsdelingen(), containsInAnyOrder(
                new Prijsdeel("Transdev", new BigDecimal("6.999"), "Amsterdam", "Leiden"),
                new Prijsdeel("Arnhem & Nijmegen", new BigDecimal("7.999"), "Utrecht"),
                new Prijsdeel("Connexionz", new BigDecimal("8.999"), "Rotterdam"));
        );
        assertThat(keuze1.getReistypes().get("Bus").getKlas(3).getKortingsprijzen(), hasEntry("Studentenkorting", new BigDecimal("10.000"));
    }
    @Test
    public void testOtherCases(){
    }
}