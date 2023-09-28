package com.macasaet.fernet;
// original test path: l0s_fernet-java8###l0s_fernet-java8/fernet-java8/src/test/java/com/macasaet/fernet/TokenTest###testGenerate
import org.junit.Test;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import static org.junit.Assert.*;
public class TokenTest_testGenerate {
    @Test
    public void testGenerate() {
        SecureRandom random = new SecureRandom();
        byte[] payload = "test payload".getBytes();
        Key key = new SecretKeySpec(random.generateSeed(16), "AES");
        Token<byte[]> token = Token.generate(key, payload);
        assertNotNull(token);
        assertEquals(Token.supportedVersion, token.getVersion());
        assertNotNull(token.getTimestamp());
        assertNotNull(token.getInitializationVector());
        assertNotNull(token.getCipherText());
        assertNotNull(token.getHmac());
    }
}