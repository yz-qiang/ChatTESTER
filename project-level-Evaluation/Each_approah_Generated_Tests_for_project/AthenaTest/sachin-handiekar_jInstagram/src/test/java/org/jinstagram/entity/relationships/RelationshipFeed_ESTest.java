/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 04:10:49 GMT 2024
 */
package org.jinstagram.entity.relationships;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.common.Meta;
import org.jinstagram.entity.relationships.RelationshipData;
import org.jinstagram.entity.relationships.RelationshipFeed;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class RelationshipFeed_ESTest extends RelationshipFeed_ESTest_scaffolding {
    @Test 
    public void testSetData() { 
    RelationshipFeed feed = new RelationshipFeed();
    feed.setData(new RelationshipData());
    }
    
}
