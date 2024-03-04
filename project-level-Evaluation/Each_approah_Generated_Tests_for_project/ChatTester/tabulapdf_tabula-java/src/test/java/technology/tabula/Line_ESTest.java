// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Line_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:53:47 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.TextChunk;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.TextChunk;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Line_ESTest extends Line_ESTest_scaffolding {

@Test
public void testSetTextElements() {
    Line line = new Line();
    List<TextChunk> textChunks = new ArrayList<>();

    textChunks.add(new TextChunk(0.0F, 0.0F, 0.0F, 0.0F));

    textChunks.add(new TextChunk(0.0F, 0.0F, 0.0F, 0.0F));
    line.setTextElements(textChunks);
    assertEquals(textChunks, line.getTextElements());
}

@Test
public void testAddTextChunk() {
    Line line = new Line();
    TextChunk textChunk = new TextChunk(0.0F, 0.0F, 0.0F, 0.0F);
    line.addTextChunk(textChunk);
    assertTrue(line.getTextElements().contains(textChunk));
}

@Test(timeout = 4000)
public void testGetTextElements() throws Throwable {
    // Create a new Line object
    Line line = new Line();
    
    // Set the textChunks field to null
    line.textChunks = null;
    
    // Call the getTextElements() method
    List<TextChunk> result = line.getTextElements();
    
    // Assert that the result is null
    assertNull(result);
}

@Test(timeout = 4000)
public void testRemoveRepeatedCharacters() throws Throwable {
    // Create a Line object
    Line line = new Line();
    TextChunk textChunk = new TextChunk(4684.6978F, 0.0F, 0.0F, -1382.9923F);
    line.addTextChunk(textChunk);
    
    // Define the character and minimum run length
    Character character = new Character('\'');
    int minRunLength = -3689;
    
    // Call the focal method
    Line result = Line.removeRepeatedCharacters(line, character, minRunLength);
    
    // Verify the expected behavior
    assertEquals(4684.6978F, line.y, 0.01F);
    assertTrue(result.equals(line));
}

}
