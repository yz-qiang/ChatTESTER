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

/**
 * This interface defines an object that can interrogate a raw value to determine if it
 * references other values and provide information about those references. Most
 * importantly, it can translate a raw value into a fully evaluated value.
 *
 * @author Gregory P. Moyer
 */
public interface Evaluator
{
    /**
     * Transform the given raw value into a fully evaluated value (including recursively
     * nested references).
     *
     * @param rawValue
     *            the raw value, which may contain references to other values
     * @param retriever
     *            the retriever used to obtain the values of referenced properties
     * @return the fully evaluated value
     */
    public String evaluate(String rawValue, Retriever retriever);

    /**
     * Retrieve the reference at the specified location, if one exists.
     *
     * @param rawValue
     *            the raw value that may or may not contain a reference
     * @param position
     *            the position at which to look for a reference - this does not need to be
     *            the beginning of the reference or any other particular position relative
     *            to the reference, if a reference exists that contains this location in
     *            the raw value, it will be returned
     * @param retriever
     *            the {@link Retriever} used to get the value of the reference, if one is
     *            found
     * @return the reference at the given location, if such a reference exists;
     *         <code>null</code> otherwise
     */
    public Reference referenceAt(String rawValue, int position, Retriever retriever);

    /**
     * Determine whether or not the given raw value references another value by name. This
     * includes recursively nested references.
     *
     * @param rawValue
     *            the raw value to search
     * @param name
     *            the name of the reference to find
     * @param retriever
     *            the {@link Retriever} instance used to convert references to values for
     *            recursive searching
     * @return <code>true</code> if a reference with the given name is found;
     *         <code>false</code> otherwise
     */
    public boolean isReferencing(String rawValue, String name, Retriever retriever);

    /**
     * Get a list of references contained within the given raw value. The list is not
     * recursive, but each {@link Reference} contains a list of sub-references found
     * within its value, so a recursive listing is obtainable.
     *
     * @param rawValue
     *            the raw value to search for references
     * @param retriever
     *            the {@link Retriever} instance used to convert references to values
     * @return a list of references in the order that they are found when starting with
     *         the first character of the raw value and processing through the last
     *         character (non-recursive)
     */
    public List<Reference> getReferences(String rawValue, Retriever retriever);
}
