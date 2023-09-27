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
public class TokenGenerateTest_testGenerate {
    @Mock
    private SecureRandom mockRandom;
    @Mock
    private Key mockKey;
    @InjectMocks
    private Token sut; 
    @Test
    public void testGenerate_withValidInputs_returnsExpectedResult() throws Exception {
        when(mockRandom.nextBytes()).thenReturn(new byte[]{0x01});
        when(mockKey.encrypt(any(), any())).thenReturn(new byte[]{0x02});
        when(mockKey.sign(any(), any(), any(), any())).thenReturn(new byte[]{0x03});
        Token result = sut.generate(mockRandom, mockKey, new byte[]{0x04});
        assertNotNull(result);
        assertEquals(supportedVersion, result.getVersion());
        assertEquals(Instant.now(), result.getTimestamp());
        assertArrayEquals(new byte[]{0x01}, result.getInitializationVector().getIV());
        assertArrayEquals(new byte[]{0x02}, result.getCipherText());
        assertArrayEquals(new byte[]{0x03}, result.getHmac());
    }
    @Test
    public void testGenerate_withInvalidPayloadLength_throwsIllegalArgumentException() throws Exception {
        when(mockRandom.nextBytes()).thenThrow(new IllegalArgumentException("invalid length"));
        assertThrows(IllegalArgumentException.class, () -> sut.generate(mockRandom, mockKey, new byte[]{}));
    }
    @Test
    public void testGenerate_withInvalidInitializationVector_throwsIllegalArgumentException() throws Exception {
        when(mockRandom.nextBytes()).thenReturn(new byte[]{0x01});
        when(mockKey.encrypt(any(), any())).thenThrow(new IllegalArgumentException("invalid IV"));
        assertThrows(IllegalArgumentException.class, () -> sut.generate(mockRandom, mockKey, new byte[]{0x04}));
    }
    @Test
    public void testGenerate_withInvalidSignature_throwsIllegalArgumentException() throws Exception {
        when(mockRandom.nextBytes()).thenReturn(new byte[]{0x01});
        when(mockKey.encrypt(any(), any())).thenReturn(new byte[]{0x02});
        when(mockKey.sign(any(), any(), any(), any())).thenThrow(new IllegalArgumentException("invalid signature"));
        assertThrows(IllegalArgumentException.class, () -> sut.generate(mockRandom, mockKey, new byte[]{0x04}));
    }
}