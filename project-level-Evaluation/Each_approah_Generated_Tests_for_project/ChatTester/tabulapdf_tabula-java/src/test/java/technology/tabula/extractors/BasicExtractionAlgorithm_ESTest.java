// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/extractors/BasicExtractionAlgorithm_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 09:49:38 GMT 2024
 */
package technology.tabula.extractors;

import java.util.*;
import java.lang.*;
import org.junit.Test;
import java.util.List;
import technology.tabula.Line;
import technology.tabula.Rectangle;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.Page;
import technology.tabula.Ruling;
import technology.tabula.TextChunk;
import technology.tabula.extractors.BasicExtractionAlgorithm;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedList;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import technology.tabula.Line;
import technology.tabula.Page;
import technology.tabula.Ruling;
import technology.tabula.TextChunk;
import technology.tabula.extractors.BasicExtractionAlgorithm;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class BasicExtractionAlgorithm_ESTest extends BasicExtractionAlgorithm_ESTest_scaffolding {

    @Test
    public void testToString() {
        BasicExtractionAlgorithm basicExtractionAlgorithm = new BasicExtractionAlgorithm();
        String expected = "stream";
        String actual = basicExtractionAlgorithm.toString();
        assertEquals(expected, actual);
    }

@Test
public void testColumnPositions() {
    List<Line> lines = new ArrayList<>();
    List<Float> expectedColumnPositions = new ArrayList<>();
     
}

}
