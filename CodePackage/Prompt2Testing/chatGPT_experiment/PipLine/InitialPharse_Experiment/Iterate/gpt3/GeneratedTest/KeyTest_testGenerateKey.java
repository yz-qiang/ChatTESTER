package com.macasaet.fernet;
// original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/KeyTest###testGenerateKey
import static com.macasaet.fernet.Constants.encoder;
import static com.macasaet.fernet.Constants.encryptionKeyBytes;
import static com.macasaet.fernet.Constants.signingKeyBytes;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.STRICT_INHERITANCE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import java.security.SecureRandom;
import org.junit.Test;
import static org.junit.Assert.*;
public class KeyTest_testGenerateKey {
    @Test
    public void testGenerateKey() {
        SecureRandom random = new SecureRandom();
        Key key = Key.generateKey(random);
        assertNotNull(key);
        assertNotNull(key.getSigningKey());
        assertNotNull(key.getEncryptionKey());
        assertEquals(16, key.getSigningKey().length);
        assertEquals(16, key.getEncryptionKey().length);
    }
}