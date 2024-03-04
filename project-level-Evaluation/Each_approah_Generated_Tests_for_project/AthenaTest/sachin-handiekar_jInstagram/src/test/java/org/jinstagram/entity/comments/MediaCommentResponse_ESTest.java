/*
 * This file was automatically generated by EvoSuite
 * Sat Jan 27 03:30:22 GMT 2024
 */
package org.jinstagram.entity.comments;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jinstagram.entity.comments.CommentData;
import org.jinstagram.entity.comments.MediaCommentResponse;
import org.jinstagram.entity.common.Meta;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false)
public class MediaCommentResponse_ESTest extends MediaCommentResponse_ESTest_scaffolding {
    @Test 
    public void setMeta() { 
    MediaCommentResponse response = new MediaCommentResponse();
    response.setMeta(new Meta());
    }
    
    
    @Test 
    public void testSetCommentData() { 
    MediaCommentResponse response = new MediaCommentResponse();
    response.setCommentData(new CommentData());
    }
    
}
