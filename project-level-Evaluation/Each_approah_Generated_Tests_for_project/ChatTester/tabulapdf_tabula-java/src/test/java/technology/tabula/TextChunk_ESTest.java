// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/TextChunk_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:15:23 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.Rectangle;
import technology.tabula.TextChunk;
import technology.tabula.TextElement;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class TextChunk_ESTest extends TextChunk_ESTest_scaffolding {

    @Test
    public void testHashCode() {
        // Create a TextChunk object with the same properties
        TextChunk textChunk1 = new TextChunk(1.0f, 2.0f, 3.0f, 4.0f);
        TextChunk textChunk2 = new TextChunk(1.0f, 2.0f, 3.0f, 4.0f);

        // Assert that the hash codes of the two objects are equal
        assertEquals(textChunk1.hashCode(), textChunk2.hashCode());

        // Create a TextChunk object with different properties
        TextChunk textChunk3 = new TextChunk(5.0f, 6.0f, 7.0f, 8.0f);

        // Assert that the hash codes of the two objects are not equal
        assertNotEquals(textChunk1.hashCode(), textChunk3.hashCode());
    }

}
