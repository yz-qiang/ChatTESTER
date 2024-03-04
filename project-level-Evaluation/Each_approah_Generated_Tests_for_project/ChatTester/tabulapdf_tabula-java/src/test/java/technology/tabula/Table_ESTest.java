// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/Table_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:11:53 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.ExtractionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class Table_ESTest extends Table_ESTest_scaffolding {

@Test
public void testGetExtractionMethod() {
    ExtractionAlgorithm extractionAlgorithm = new SpreadsheetExtractionAlgorithm();
    Table table = new Table(extractionAlgorithm);
    String expectedExtractionMethod = extractionAlgorithm.toString();
    
    String actualExtractionMethod = table.getExtractionMethod();
    
    assertEquals(expectedExtractionMethod, actualExtractionMethod);
}

@Test
public void testSetPageNumber() {
    Table table = Table.empty();

    int pageNumber = 5;
    table.setPageNumber(pageNumber);
    assertEquals(pageNumber, table.getPageNumber());
}

@Test
public void testGetPageNumber() {
    Table table = Table.empty();
    table.setPageNumber(5);
    int pageNumber = table.getPageNumber();
    assertEquals(5, pageNumber);
}

@Test
public void testGetExtractionMethod_3() {
    ExtractionAlgorithm extractionAlgorithm = new SpreadsheetExtractionAlgorithm();
    Table table = new Table(extractionAlgorithm);
    String expectedExtractionMethod = extractionAlgorithm.toString();
    
    String actualExtractionMethod = table.getExtractionMethod();
    
    assertEquals(expectedExtractionMethod, actualExtractionMethod);
}

    @Test
    public void testEmpty() {
        Table table = Table.empty();
        
        assertNotNull(table);
        assertEquals("", table.getExtractionMethod());
        assertEquals(0, table.getRowCount());
        assertEquals(0, table.getColCount());
        assertEquals(0, table.getPageNumber());
        
        table.setPageNumber(5);
        assertEquals(5, table.getPageNumber());
    }

@Test
public void testGetExtractionMethod_2() {
    ExtractionAlgorithm extractionAlgorithm = new SpreadsheetExtractionAlgorithm();
    Table table = new Table(extractionAlgorithm);
    String expectedExtractionMethod = extractionAlgorithm.toString();
    
    String actualExtractionMethod = table.getExtractionMethod();
    
    assertEquals(expectedExtractionMethod, actualExtractionMethod);
}

}
