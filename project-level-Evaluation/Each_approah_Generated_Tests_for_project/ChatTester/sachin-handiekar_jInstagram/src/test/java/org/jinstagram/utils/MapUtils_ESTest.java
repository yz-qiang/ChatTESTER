// original test path: /Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/repo_get/Four_project/sachin-handiekar_jInstagram/src/test/java/org/jinstagram/utils/MapUtils_ESTest.java
/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 05:13:58 GMT 2024
 */
package org.jinstagram.utils;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.utils.MapUtils;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.utils.MapUtils;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class MapUtils_ESTest extends MapUtils_ESTest_scaffolding {

@Test
public void testSort() {
    Map<String, String> map = new HashMap<String, String>();

    map.put("C", "Value C");
    map.put("A", "Value A");
    map.put("B", "Value B");
    Map<String, String> sortedMap = MapUtils.sort(map);
    assertEquals("Value A", sortedMap.get("A"));
    assertEquals("Value B", sortedMap.get("B"));
    assertEquals("Value C", sortedMap.get("C"));
}

@Test
public void testGetSortedKeys() {
    Map<String, String> map = new HashMap<String, String>();

    map.put("key3", "value3");
    map.put("key1", "value1");
    map.put("key2", "value2");
    List<String> sortedKeys = MapUtils.getSortedKeys(map);
    assertEquals(3, sortedKeys.size());
    assertEquals("key1", sortedKeys.get(0));
    assertEquals("key2", sortedKeys.get(1));
    assertEquals("key3", sortedKeys.get(2));
}

}
