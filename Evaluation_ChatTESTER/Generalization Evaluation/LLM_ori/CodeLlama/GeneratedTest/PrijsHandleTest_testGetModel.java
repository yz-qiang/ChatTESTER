package nl.pvanassen.ns.model.prijzen;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// original test path: pvanassen_ns-api###pvanassen_ns-api/src/test/java/nl/pvanassen/ns/model/prijzen/PrijsHandleTest###testGetModel
public 
class PrijsHandleTest_testGetModel {
    private Unmarshaller jaxbUnmarshaller;
    @BeforeEach
    void setUp() throws Exception {
        JAXBContext jc = JAXBContext.newInstance();
        this.jaxbUnmarshaller = jc.createUnmarshaller();
    }
    @ParameterizedTest
    @DisplayName("Get model from input stream")
    @CsvSource({"input1.xml", "input2.xml", "input3.xml"})
    void testGetModelFromInputStream(String fileName) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(fileName.getBytes());
        Map<String, Object> result = (Map<String, Object>) jaxbUnmarshaller.unmarshal(bais);
        assertThat(result).containsOnlyKeys("VervoerderKeuzes");
        assertThat(((Map<?, ?>) result.get("VervoerderKeuzes")).keySet()).hasSize(3);
        assertThat(((Map<?, ?>) ((Map<?, ?>) result.get("VervoerderKeuzes")).get("VervoerderKeuze")).keySet())
                .containsExactlyInAnyOrder("naam", "tariefEenheden", "ReisType");
        assertThat(((Map<?, ?>) ((Map<?, ?>) result.get("VervoerderKeuzes")).get("VervoerderKeuze")).values())
                .allMatch(value -> value instanceof Map && !((Map<?, ?>) value).isEmpty());
    }
}