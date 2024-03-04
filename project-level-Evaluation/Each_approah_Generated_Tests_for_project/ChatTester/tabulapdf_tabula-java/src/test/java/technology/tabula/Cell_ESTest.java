// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Cell_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:42:58 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Cell;
import technology.tabula.TextChunk;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Cell_ESTest extends Cell_ESTest_scaffolding {

    @Test
    public void testIsPlaceholder() {
        // Create a Cell object
        Cell cell = new Cell(0, 0, 10, 10);

        // Verify that the initial placeholder status is false
        assertFalse(cell.isPlaceholder());

        // Set the placeholder status to true
        cell.setPlaceholder(true);

        // Verify that the placeholder status is now true
        assertTrue(cell.isPlaceholder());

        // Set the placeholder status back to false
        cell.setPlaceholder(false);

        // Verify that the placeholder status is false again
        assertFalse(cell.isPlaceholder());
    }

    @Test
    public void testGetText() {
        // Create a Cell object
        Cell cell = new Cell(0, 0, 10, 10);

        // Test getText() method
        String expectedText = "";
        String actualText = cell.getText();
        assertEquals(expectedText, actualText);
    }

    @Test
    public void testSetSpanning() {
        // Create a new Cell object
        Cell cell = new Cell(0, 0, 10, 10);

        // Verify that the initial value of spanning is false
        assertFalse(cell.isSpanning());

        // Set spanning to true
        cell.setSpanning(true);

        // Verify that the value of spanning is now true
        assertTrue(cell.isSpanning());

        // Set spanning back to false
        cell.setSpanning(false);

        // Verify that the value of spanning is now false again
        assertFalse(cell.isSpanning());
    }

    @Test
    public void testIsSpanning() {
        // Create a Cell object
        Cell cell = new Cell(0, 0, 10, 10);

        // Verify that the initial value of isSpanning is false
        assertFalse(cell.isSpanning());

        // Set isSpanning to true
        cell.setSpanning(true);

        // Verify that isSpanning is now true
        assertTrue(cell.isSpanning());

        // Set isSpanning back to false
        cell.setSpanning(false);

        // Verify that isSpanning is false again
        assertFalse(cell.isSpanning());
    }

    @Test
    public void testSetPlaceholder() {
        Cell cell = new Cell(0, 0, 10, 10);
        
        // Test initial value
        assertFalse(cell.isPlaceholder());
        
        // Set placeholder to true
        cell.setPlaceholder(true);
        assertTrue(cell.isPlaceholder());
        
        // Set placeholder to false
        cell.setPlaceholder(false);
        assertFalse(cell.isPlaceholder());
    }

}
