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
        byte[] array = (byte[])args[0];
        Arrays.fill(array, (byte)0xFF);
        return null;
    });
    Key key = Key.generateKey(mockRandom);
    assertNotNull(key);
    assertTrue(key instanceof Key);
    assertEquals(signingKeyBytes, key.getSigningKey().length);
    assertEquals(encryptionKeyBytes, key.getEncryptionKey().length);
    assertFalse(Arrays.equals(new byte[signingKeyBytes], key.getSigningKey()));
    assertFalse(Arrays.equals(new byte[encryptionKeyBytes], key.getEncryptionKey()));
}
}