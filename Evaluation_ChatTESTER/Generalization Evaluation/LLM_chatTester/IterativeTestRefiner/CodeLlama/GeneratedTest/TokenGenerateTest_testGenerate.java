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
}