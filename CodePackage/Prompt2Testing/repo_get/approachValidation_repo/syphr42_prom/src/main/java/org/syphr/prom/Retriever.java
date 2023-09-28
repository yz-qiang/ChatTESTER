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

import java.util.Properties;

/**
 * This interface defines an interaction whereby the caller requests a value associated
 * with the given name (such as the property-value relationship found in
 * {@link Properties}).
 *
 * @author Gregory P. Moyer
 */
public interface Retriever
{
    /**
     * Retrieve the value associated with the given name.
     *
     * @param name
     *            the name whose value is requested
     * @return the value associated with the given name or <code>null</code> if no such
     *         value exists
     */
    public String retrieve(String name);
}
