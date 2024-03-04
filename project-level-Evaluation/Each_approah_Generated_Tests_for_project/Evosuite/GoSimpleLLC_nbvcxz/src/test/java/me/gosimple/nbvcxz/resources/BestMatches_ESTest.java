/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:50:07 GMT 2024
 */
package me.gosimple.nbvcxz.resources;


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

@Test(timeout = 4000)
public void test0() throws Throwable {
    BestMatches bestMatches0 = new BestMatches();
    bestMatches0.setMatchLength(49);
    int int0 = bestMatches0.getMatchLength();
    assertEquals(49, int0);
}

@Test(timeout = 4000)
public void test01() throws Throwable {
    BestMatches bestMatches0 = new BestMatches();
    bestMatches0.setMatchLength(49);
    int int0 = bestMatches0.getMatchLength();
    assertEquals(49, int0);
}

@Test(timeout = 4000)
public void test21() throws Throwable {
    BestMatches bestMatches0 = new BestMatches();
    bestMatches0.setBestMatches((List<Match>) null);
    bestMatches0.getBestMatches();
    assertEquals(0, bestMatches0.getMatchLength());
}

@Test(timeout = 4000)
public void test2() throws Throwable {
    BestMatches bestMatches0 = new BestMatches();
    bestMatches0.setBestMatches((List<Match>) null);
    bestMatches0.getBestMatches();
    assertEquals(0, bestMatches0.getMatchLength());
}

}
