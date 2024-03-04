// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/GoSimpleLLC_nbvcxz/src/test/java/me/gosimple/nbvcxz/resources/BestMatches_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:50:07 GMT 2024
 */
package me.gosimple.nbvcxz.resources;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import me.gosimple.nbvcxz.matching.match.DictionaryMatch;
import me.gosimple.nbvcxz.matching.match.Match;
import me.gosimple.nbvcxz.resources.BestMatches;
import me.gosimple.nbvcxz.resources.Configuration;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import me.gosimple.nbvcxz.matching.match.Match;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import me.gosimple.nbvcxz.matching.match.DictionaryMatch;
import me.gosimple.nbvcxz.matching.match.Match;
import me.gosimple.nbvcxz.resources.BestMatches;
import me.gosimple.nbvcxz.resources.Configuration;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class BestMatches_ESTest extends BestMatches_ESTest_scaffolding {

    @Test
    public void testGetMatchLength() {
        // Create an instance of BestMatches
        BestMatches bestMatches = new BestMatches();

        // Set the best match length
        bestMatches.setMatchLength(10);

        // Call the getMatchLength() method
        int matchLength = bestMatches.getMatchLength();

        // Assert that the returned match length is equal to the set match length
        assertEquals(10, matchLength);
    }

    @Test
    public void testSetMatchLength() {
        BestMatches bestMatches = new BestMatches();
        int expectedMatchLength = 10;
        
        bestMatches.setMatchLength(expectedMatchLength);
        int actualMatchLength = bestMatches.getMatchLength();
        
        assertEquals(expectedMatchLength, actualMatchLength);
    }

@Test
public void testSetBestMatches() {
    // Create an instance of BestMatches
    BestMatches bestMatches = new BestMatches();
    
    // Create a new list of matches
    List<Match> newMatches = new ArrayList<>();
    
    // Set the new list of matches using the focal method
    bestMatches.setBestMatches(newMatches);
    
    // Verify that the list of best matches has been updated
    assertEquals(newMatches, bestMatches.getBestMatches());
}

}