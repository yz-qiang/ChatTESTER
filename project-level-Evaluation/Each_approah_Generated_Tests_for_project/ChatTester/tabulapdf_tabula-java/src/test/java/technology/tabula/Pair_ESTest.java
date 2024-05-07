// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Pair_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:57:41 GMT 2024
 */
package technology.tabula;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Pair;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Pair_ESTest extends Pair_ESTest_scaffolding {

    @Test
    public void testGetRight() {
        // Given
        Integer leftValue = 10;
        Integer rightValue = 20;
        Pair<Integer, Integer> pair = new Pair<>(leftValue, rightValue);

        // When
        Integer retrievedRightValue = pair.getRight();

        // Then
        assertEquals(rightValue, retrievedRightValue);
    }

}
