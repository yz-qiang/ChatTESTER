package com.macasaet.fernet;
import static com.macasaet.fernet.Constants.initializationVectorBytes;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mutabilitydetector.unittesting.AllowedReason.allowingForSubclassing;
import static org.mutabilitydetector.unittesting.AllowedReason.assumingFields;
import static org.mutabilitydetector.unittesting.AllowedReason.provided;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;
import javax.crypto.spec.IvParameterSpec;
import org.junit.Before;
import org.junit.Test;
// original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest###testGenerate
@RunWith(MockitoJUnitRunner.class)
public class TokenTest_testGenerate {
    @Mock
    private SecureRandom mockRandom;
    @InjectMocks
    private Token tokenUnderTest;
    private static String secretKeyString = "mySecretKey";
    private static byte[] secretKeyBytes = Strings.toString(secretKeyString).getBytes(StandardCharsets.UTF_8);
    private static Key key = Keys.hmacSha256(secretKeyBytes);
    private static byte[] payload = "Hello World".getBytes(StandardCharsets.US_ASCII);
    @BeforeClass
    public static void setUpOnce() throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("\n\nRunning tests\n");
    }
    @AfterClass
    public static void tearDownOnce(){
        System.out.println("\nTests finished.\n");
    }
    @Test
    public void testGenerate() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, BadPaddingException, ShortBufferException {
        when(mockRandom.nextBytes(any())).thenReturn(new byte[32]);
        Token result = Token.generate(mockRandom, key, payload);
        assertNotNull(result);
        assertThat(result.getTimestamp(), notNullValue());
        assertThat(result.getHmac(), notNullValue());
        assertThat(result.getCipherText(), notNullValue());
        assertThat(result.getInitializationVector(), notNullValue());
    }
}