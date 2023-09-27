package com.macasaet.fernet;
import static com.macasaet.fernet.Constants.encoder;
import static com.macasaet.fernet.Constants.encryptionKeyBytes;
import static com.macasaet.fernet.Constants.signingKeyBytes;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.STRICT_INHERITANCE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mutabilitydetector.unittesting.AllowedReason.allowingForSubclassing;
import static org.mutabilitydetector.unittesting.AllowedReason.assumingFields;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;
import java.security.SecureRandom;
import java.time.Instant;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;
// original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest###testGenerateKey
public class TTT_testGenerateKey {
@Test
public void testGenerateKey() throws Exception {
    SecureRandom mockRandom = Mockito.mock(SecureRandom.class);
    when(mockRandom.nextBytes(any())).thenAnswer((invocation) -> {
        Object[] args = invocation.getArguments();
        byte[] bytes = (byte[]) args[0];
        Arrays.fill(bytes, (byte) 42);
        return null;
    });
    Key result = Key.generateKey(mockRandom);
    assertNotNull(result);
    assertTrue(result instanceof Key);
    assertEquals(new SecretKeySpec(new byte[]{42}, "AES"), result.getSigningKey());
    assertEquals(new SecretKeySpec(new byte[]{42}, "AES"), result.getEncryptionKey());
}
}