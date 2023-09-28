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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class encapsulates a reference to another property from within a property's value.
 * For example, using an Ant-like {@link Evaluator}, a property may look like
 * <code>some.property = some value ${nested}</code> where <code>${nested}</code> is
 * the reference.
 *
 * @author Gregory P. Moyer
 */
public class Reference
{
    /**
     * The name of the reference. This would be the key used to lookup the value of the
     * reference.
     */
    private final String name;

    /**
     * The value of the reference.
     */
    private final String value;

    /**
     * The start index of this reference in the original value in which it was nested.
     *
     * @see #getStartPosition()
     */
    private final int startPosition;

    /**
     * The end index of this reference in the original value in which it was nested.
     *
     * @see #getEndPosition()
     */
    private final int endPosition;

    /**
     * A list of sub-references nested within the value of this reference.
     */
    private final List<Reference> references;

    /**
     * Construct a new reference.
     *
     * @param name
     *            the name of the reference
     * @param value
     *            the value of the reference
     * @param startPosition
     *            the starting location (inclusive) of the entire reference (not just the
     *            name) in its original context
     * @param endPosition
     *            the ending location (inclusive) of the entire reference (not just the
     *            name) in its original context
     */
    public Reference(String name, String value, int startPosition, int endPosition)
    {
        this.name = name;
        this.value = value;
        this.startPosition = startPosition;
        this.endPosition = endPosition;

        references = new ArrayList<Reference>();
    }

    /**
     * Retrieve the name of this reference.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retrieve the value of this reference, which may contain other references.
     *
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Retrieve the start index (inclusive) of this reference in the original value in
     * which it was nested. Note that this position is the start of whatever defines this
     * string as a reference, which is not necessarily the beginning of the reference
     * name.<br>
     * <br>
     * For example, with an Ant-like {@link Evaluator} and a reference "
     * <code>${reference}</code>", the start position would be the '<code>$</code>'.<br>
     * <br>
     * This means that the following line will replace this reference with its value in
     * the original string:<br>
     *
     * <pre>
     * <code>
     * StringBuilder originalValue = new StringBuilder(original);
     * String evaluated = originalValue.replace(ref.getStartPosition(), ref.getEndPostion(), ref.getValue());
     * </code>
     * </pre>
     *
     * @see #getEndPosition()
     *
     * @return the starting index for this reference
     */
    public int getStartPosition()
    {
        return startPosition;
    }

    /**
     * Retrieve the end index (inclusive) of this reference in the original value in which
     * it was nested. Note that this position is the end of whatever defines this string
     * as a reference, which is not necessarily the end of the reference name.<br>
     * <br>
     * For example, with an Ant-like {@link Evaluator} and a reference "
     * <code>${reference}</code>", the end position would be the '<code>}</code>'.<br>
     * <br>
     * This means that the following line will replace this reference with its value in
     * the original string:<br>
     *
     * <pre>
     * <code>
     * StringBuilder originalValue = new StringBuilder(original);
     * String evaluated = originalValue.replace(ref.getStartPosition(), ref.getEndPostion(), ref.getValue());
     * </code>
     * </pre>
     *
     * @see #getStartPosition()
     *
     * @return the starting index for this reference
     */
    public int getEndPosition()
    {
        return endPosition;
    }

    /**
     * Add a sub reference to this instance. This method is intended for use by an
     * {@link Evaluator} when building a reference.
     *
     * @param ref
     *            the reference to add
     */
    public void addReference(Reference ref)
    {
        references.add(ref);
    }

    /**
     * Retrieve a list of sub-references contained within the value of this reference. The
     * elements in this list should not be modified.
     *
     * @return an immutable list of sub-references
     */
    public List<Reference> getReferences()
    {
        return Collections.unmodifiableList(references);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Reference other = (Reference)obj;
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        return true;
    }
}