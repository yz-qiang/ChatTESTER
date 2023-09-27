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
public class TokenGenerateTest_testGenerate {
    @Test
    public void testGenerateWithValidInput() throws Exception {
        SecureRandom secureRandom = mock(SecureRandom.class);
        when(secureRandom.nextBytes()).thenReturn(new byte[]{0x01});
        Key key = mock(Key.class);
        when(key.encrypt(any(), any())).thenReturn(new byte[]{0x02});
        when(key.sign(any(), any(), any(), any())).thenReturn(new byte[]{0x03});
        byte[] payload = Base64.getEncoder().encodeToString("Hello World".getBytes());
        Token token = Token.generate(secureRandom, key, payload);
        assertNotNull(token);
        assertEquals(supportedVersion, token.getVersion());
        assertEquals(Instant.now(), token.getTimestamp());
        assertArrayEquals(new byte[]{0x01}, token.getInitializationVector().getIV());
        assertArrayEquals(new byte[]{0x02}, token.getCipherText());
        assertArrayEquals(new byte[]{0x03}, token.getHmac());
    }
    @Test
    public void testGenerateWithInvalidPayload() throws Exception {
        SecureRandom secureRandom = mock(SecureRandom.class);
        when(secureRandom.nextBytes()).thenThrow(IllegalStateException.class);
        Key key = mock(Key.class);
        when(key.encrypt(any(), any())).thenThrow(IllegalStateException.class);
        when(key.sign(any(), any(), any(), any())).thenThrow(IllegalStateException.class);
        byte[] payload = Base64.getDecoder().decode("Hello World".getBytes());
        assertThrows(IllegalStateException.class, () -> Token.generate(secureRandom, key, payload));
    }
}