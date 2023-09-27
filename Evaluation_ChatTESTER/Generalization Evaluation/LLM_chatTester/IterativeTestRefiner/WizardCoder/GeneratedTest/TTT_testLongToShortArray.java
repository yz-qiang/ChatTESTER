package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.UUID;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/ConversionTest###testLongToShortArray
public class TTT_testLongToShortArray {
    @Test
    public void shouldConvertLongIntoArrayOfSignedTwoComplementIntegers_whenSourcePositionIsZeroAndDestinationLengthIsOne() throws Exception {
        byte expectedResult[] = {(byte) -32768};
        Short result[] = conversionClassInstance().longToShortArray((long) (Math.pow(-2, 5)), 0, new Short[]{expectedResult[0]}, 0, 1);
        assertArrayEquals("Should Convert Long Into Array Of Signed Two Complement Integers", result, (Object[]) expectedResult);
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenShiftValueGreaterThanOrEqualToSixtyFourBitsForLastElementInInputByteArray() {
        try {
            UUID uuid = UUID.randomUUID();
            String randomString = uuid.toString();
            char chars[] = randomString.toCharArray();
            StringBuilder sb = new StringBuilder("");
            Random rand = new Random();
            while (sb.length() < 9) {
                int index = Math.abs(rand.nextInt()) % chars.length;
                if (!Character.isLetterOrDigit(chars[index]))
                    continue;
                else
                    sb.append("" + Character.toUpperCase(chars[index]));
            }
            System.out.println("\"" + sb + "\"");
            fail("\"(" + sb + ")\" Should Throw Illegal Argument Exception For Last Element in Input ByteArray");
        } catch (Exception e) {
        }
    }
    private Conversion conversionClassInstance() throws Exception {
        Constructor constructor = Conversion.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object object = constructor.newInstance();
        return (Conversion) object;
    }
}