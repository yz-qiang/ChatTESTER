// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/tabulapdf_tabula-java/src/test/java/technology/tabula/QuickSort_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Feb 10 10:01:44 GMT 2024
 */
package technology.tabula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
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

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    public void testSort_2() {
        // Create a list of unsorted elements
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));

        // Call the sort method to sort the list
        QuickSort.sort(unsortedList);

        // Create a list of expected sorted elements
        List<Integer> expectedSortedList = new ArrayList<>(Arrays.asList(1, 2, 5, 8, 9));

        // Assert that the sorted list matches the expected sorted list
        assertEquals(expectedSortedList, unsortedList);
    }

    @Test
    public void testSort() {
        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(9);

        // Create a comparator to sort in ascending order
        Comparator<Integer> comparator = Comparator.naturalOrder();

        // Call the sort method
        QuickSort.sort(list, comparator);

        // Check if the list is sorted
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(comparator.compare(list.get(i), list.get(i + 1)) <= 0);
        }
    }

}
