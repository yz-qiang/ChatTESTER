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
public void generatesValidKeyPair() throws Exception{
    try {
        final int numTestsToRun = 50;
        for (int i=0 ;i<numTestsToRun;++i){
            System.out.println("\nRunning Test #"+String.valueOf(i+1)+"");
            final Instant start = Instant.now();
            final SecureRandom rng = new SecureRandom(); 
            final Key pairA = Key.generateKey(rng);
            Thread.sleep((long)(Math.random()*3*1e6)+7*1e4); 
            final Key pairB = Key.generateKey(new SecureRandom()); 
            assertEquals(pairA.getSigningKey(), pairB.getSigningKey());   
            assertArrayEquals(pairA.getEncryptionKey(), pairB.getEncryptionKey());    
            SingleTypeEqualsVerifierApi verifierAPI = EqualsVerifier
                   .forClass(Key.class)
                   .suppress(STRICT_INHERITANCE).withRedefinedSuperclass().verify();
            assertTrue(verifierAPI.isSuccessful());
           long durationMillis = Duration.between(start, Instant.now()).toMillis();
           double throughputKiBps = ((double)((float)keySizeBits/(durationMillis))) / 1024d;
           DecimalFormat df = new DecimalFormat("#.#");
           System.out.printf("%s Kibits per sec\n",df.format(throughputKiBps));
        }
    } catch (Exception e) { 
        fail("Unexpected exception occurred during testing."); 
    }
}
}