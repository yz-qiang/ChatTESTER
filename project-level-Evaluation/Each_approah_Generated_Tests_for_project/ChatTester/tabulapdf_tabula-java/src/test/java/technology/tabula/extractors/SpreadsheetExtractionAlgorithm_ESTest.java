// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/extractors/SpreadsheetExtractionAlgorithm_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:51:32 GMT 2024
 */
package technology.tabula.extractors;

import java.awt.geom.Point2D;
//import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Cell;
import technology.tabula.Page;
import technology.tabula.Rectangle;
import technology.tabula.Ruling;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class SpreadsheetExtractionAlgorithm_ESTest extends SpreadsheetExtractionAlgorithm_ESTest_scaffolding {

    @Test
    public void testFindSpreadsheetsFromCells() {
        // Create test data
        List<Rectangle> cells = new ArrayList<>();
        cells.add(new Rectangle(0, 0, 10, 10));
        cells.add(new Rectangle(10, 0, 10, 10));
        cells.add(new Rectangle(0, 10, 10, 10));
        cells.add(new Rectangle(10, 10, 10, 10));

        // Call the method under test
        List<Rectangle> result = SpreadsheetExtractionAlgorithm.findSpreadsheetsFromCells(cells);

        // Assert the result
        assertEquals(1, result.size());
        Rectangle spreadsheet = result.get(0);
        assertEquals(0, spreadsheet.getTop(), 0.001);
        assertEquals(0, spreadsheet.getLeft(), 0.001);
        assertEquals(20, spreadsheet.getWidth(), 0.001);
        assertEquals(20, spreadsheet.getHeight(), 0.001);
    }

}
