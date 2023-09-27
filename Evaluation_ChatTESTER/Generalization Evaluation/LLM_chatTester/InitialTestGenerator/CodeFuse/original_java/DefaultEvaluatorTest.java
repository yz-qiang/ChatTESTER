/*
 * Copyright 2010-2012 Gregory P. Moyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.syphr.prom;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class DefaultEvaluatorTest
{
    private static final String KEY_1 = "test1";
    private static final String RAW_VALUE_1 = "value numero uno";
    private static final String EVAL_VALUE_1 = RAW_VALUE_1;
    private static final String KEY_1_VAR = "${" + KEY_1 + "}";

    private static final String KEY_2 = "test2";
    private static final String RAW_VALUE_2 = "value numero dos";
    private static final String EVAL_VALUE_2 = RAW_VALUE_2;
    private static final String KEY_2_VAR = "${" + KEY_2 + "}";

    /*
     * Key3 contains direct references to Key1 and Key2.
     */
    private static final String KEY_3 = "test3";
    private static final String RAW_VALUE_3 = "prefix "
                                              + KEY_1_VAR
                                              + " middle "
                                              + KEY_2_VAR
                                              + " suffix";
    private static final int RAW_VALUE_3_KEY_1_START = RAW_VALUE_3.indexOf(KEY_1_VAR);
    private static final int RAW_VALUE_3_KEY_1_END = RAW_VALUE_3_KEY_1_START
                                                     + KEY_1_VAR.length();
    private static final String EVAL_VALUE_3 = "prefix "
                                               + RAW_VALUE_1
                                               + " middle "
                                               + RAW_VALUE_2
                                               + " suffix";

    /*
     * Key4 contains a direct reference to Key3 and indirect references to Key1
     * and Key2.
     */
    private static final String KEY_4 = "test4";
    private static final String RAW_VALUE_4 = "nested ${" + KEY_3 + "} variables";
    private static final String EVAL_NOREC_VALUE_4 = "nested " + RAW_VALUE_3 + " variables";
    private static final String EVAL_REC_VALUE_4 = "nested " + EVAL_VALUE_3 + " variables";

    /*
     * Key5 contains an invalid reference and a direct reference to Key1.
     */
    private static final String KEY_5 = "test5";
    private static final String RAW_VALUE_5 = "invalid ${reference} and " + KEY_1_VAR;
    private static final String EVAL_VALUE_5 = "invalid ${reference} and " + EVAL_VALUE_1;

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    private static Retriever retriever;
    private static DefaultEvaluator evaluator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        final Properties properties = new Properties();
        properties.setProperty(KEY_1, RAW_VALUE_1);
        properties.setProperty(KEY_2, RAW_VALUE_2);
        properties.setProperty(KEY_3, RAW_VALUE_3);

        retriever = new Retriever()
        {
            @Override
            public String retrieve(String name)
            {
                return properties.getProperty(name);
            }
        };

        evaluator = new DefaultEvaluator();
    }

    @Test
    public void testEvaluate()
    {
        String computedEval = evaluator.evaluate(RAW_VALUE_4, retriever);
        Assert.assertEquals("The computed value of \"" + RAW_VALUE_4 + "\" was not correct",
                            EVAL_REC_VALUE_4,
                            computedEval);
    }

    @Test
    public void testEvaluateWithInvalidReference()
    {
        String computedEval = evaluator.evaluate(RAW_VALUE_5, retriever);
        Assert.assertEquals("The computed value of \"" + RAW_VALUE_5 + "\" was not correct",
                            EVAL_VALUE_5,
                            computedEval);
    }

    @Test
    public void testReferenceAt()
    {
        final int position = 9;
        Reference variable = evaluator.referenceAt(RAW_VALUE_3, position, retriever);
        Assert.assertNotNull("Variable was not found at position " + position + " in \""
                             + RAW_VALUE_3 + "\"", variable);
        Assert.assertEquals("Substring of \""
                                    + RAW_VALUE_3
                                    + "\" using computed start/end positions does not match expected",
                            KEY_1_VAR,
                            RAW_VALUE_3.substring(variable.getStartPosition(),
                                                  variable.getEndPosition()));
    }

    @Test
    public void testIsReferencing()
    {
        Assert.assertTrue("Raw value \"" + RAW_VALUE_4
                                  + "\" should contain a nested reference to \"" + KEY_2 + "\"",
                          evaluator.isReferencing(RAW_VALUE_4, KEY_2, retriever));
        Assert.assertFalse("Raw value \"" + RAW_VALUE_3
                                   + "\" should not contain a nested reference to \"" + KEY_4
                                   + "\"",
                           evaluator.isReferencing(RAW_VALUE_3, KEY_4, retriever));
    }

    @Test
    public void testGetreferences()
    {
        List<Reference> variablesNoRec = evaluator.getReferences(RAW_VALUE_4, retriever);
        Assert.assertEquals("Non-recursive variable lookup on \"" + RAW_VALUE_4
                            + "\" returned unexpected number of results", 1, variablesNoRec.size());
        Assert.assertEquals("Non-recursive evaluation of \""
                                    + RAW_VALUE_4
                                    + "\" did not yield the expected value for the first variable found",
                            RAW_VALUE_3,
                            variablesNoRec.get(0).getValue());
    }
}
