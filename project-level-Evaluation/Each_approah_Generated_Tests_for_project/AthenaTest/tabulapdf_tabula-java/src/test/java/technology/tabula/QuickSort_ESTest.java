/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:01:44 GMT 2024
 */
package technology.tabula;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;
import technology.tabula.QuickSort;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class QuickSort_ESTest extends QuickSort_ESTest_scaffolding {
    @Test 
    public void testSetLeft() { 
    Rectangle rectangle = new Rectangle();
    rectangle.setLeft(0);
    assertEquals(0, rectangle.getLeft(), 0);
    }
    
}
