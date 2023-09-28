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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This {@link Evaluator} implementation seeks to work the same way property evaluation
 * works in Ant. In other words, a reference is defined as a '$' followed by a property
 * name wrapped in braces.<br>
 * <br>
 * For example, a reference to the property "<code>some.property</code>" would like this:
 * <code>${some.property}</code>.
 *
 * @author Gregory P. Moyer
 */
public class DefaultEvaluator implements Evaluator
{
    /**
     * The pattern used to detect property references in the style of Ant.
     */
    private static final Pattern PATTERN = Pattern.compile("\\$\\{(.+?)\\}");

    @Override
    public String evaluate(String rawValue, Retriever retriever)
    {
        if (rawValue == null)
        {
            return null;
        }

        Evaluation eval = new Evaluation(rawValue, retriever);
        eval.parse();

        return eval.getValue();
    }

    @Override
    public Reference referenceAt(String rawValue, int position, Retriever retriever)
    {
        if (rawValue == null)
        {
            return null;
        }

        Evaluation eval = new Evaluation(rawValue, retriever);
        eval.parse();

        return eval.referenceAt(position);
    }

    @Override
    public boolean isReferencing(String rawValue, String name, Retriever retriever)
    {
        if (rawValue == null)
        {
            return false;
        }

        Evaluation eval = new Evaluation(rawValue, retriever);
        eval.parse();

        List<Reference> references = eval.getReferences(true);

        for (Reference ref : references)
        {
            if (ref.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Reference> getReferences(String rawValue, Retriever retriever)
    {
        if (rawValue == null)
        {
            return Collections.emptyList();
        }

        Evaluation eval = new Evaluation(rawValue, retriever);
        eval.parse();

        return eval.getReferences(false);
    }

    /**
     * This class converts a raw value into a tree of nested references. It can then be
     * queried for information, such as evaluating the the raw value recursively.
     *
     * @author Gregory P. Moyer
     */
    private static class Evaluation
    {
        /**
         * The {@link Retriever} instance used to convert a reference to its value.
         */
        private final Retriever retriever;

        /**
         * The root reference encapsulates the raw value that was used to create this
         * instance. It has no name and its start and end encompass the entire raw value.
         * This is the root of the references tree.
         */
        private final Reference rootReference;

        /**
         * Construct a new instance with the given value as the root.
         *
         * @param rawValue
         *            the value to be parsed
         * @param retriever
         *            the {@link Retriever} instance used to convert a reference to its
         *            value
         */
        public Evaluation(String rawValue, Retriever retriever)
        {
            this.retriever = retriever;
            rootReference = new Reference(null, rawValue, 0, rawValue.length());
        }

        /**
         * Run the parser to generate a reference tree. This must be called before valid
         * reference information can be returned.
         */
        public void parse()
        {
            findReferences(rootReference);
        }

        /**
         * Recursively find all references within the value of the given base reference.
         * Any references found will be added to the base reference's list of
         * sub-references.
         *
         * @param baseRef
         *            the base reference to search
         */
        private void findReferences(Reference baseRef)
        {
            Matcher matcher = PATTERN.matcher(baseRef.getValue());
            while (matcher.find())
            {
                String name = matcher.group(1);
                String value = retriever.retrieve(name);

                /*
                 * If the retriever has no value for the given name, then this
                 * is not a valid reference.
                 */
                if (value == null)
                {
                   continue;
                }

                Reference ref = new Reference(name,
                                              value,
                                              matcher.start(),
                                              matcher.end());

                baseRef.addReference(ref);
                findReferences(ref);
            }
        }

        /**
         * Get a list of references found in the raw value used to create this instance.
         *
         * @param recursive
         *            if <code>true</code>, this list will include nested references
         * @return a list of references, immediate or recursive based on the given flag
         */
        public List<Reference> getReferences(boolean recursive)
        {
            if (!recursive)
            {
                return new ArrayList<Reference>(rootReference.getReferences());
            }

            return getReferences(rootReference);
        }

        /**
         * Get a recursive list of all sub-references within the the given base reference.
         *
         * @param baseRef
         *            the base reference to search
         * @return a recursive list of references
         */
        private List<Reference> getReferences(Reference baseRef)
        {
            List<Reference> baseSubReferences = baseRef.getReferences();

            List<Reference> references = new ArrayList<Reference>(baseSubReferences);
            for (Reference ref : baseSubReferences)
            {
                references.addAll(getReferences(ref));
            }

            return references;
        }

        /**
         * Get the fully evaluated value after replacing all references with their
         * corresponding values. This method will recursively replace all nested
         * references as well.
         *
         * @return the fully evaluated value
         */
        public String getValue()
        {
            StringBuilder builder = new StringBuilder(rootReference.getValue());
            replaceReferences(builder, rootReference, 0);

            return builder.toString();
        }

        /**
         * Recursively replace all sub-references to the given base reference in the
         * contents of the given builder.
         *
         * @param builder
         *            the builder containing the value with references to be replaced
         * @param baseRef
         *            the base reference whose sub-references will be replaced (this
         *            method assumes the builder contains the value of the base reference
         *            as some subset)
         * @param offset
         *            the offset used to align the start/end indices of the sub-references
         *            with the start/end indices of the builder (this will be non-zero
         *            when the value of the base reference is not the entire value of the
         *            builder)
         */
        private void replaceReferences(StringBuilder builder, Reference baseRef, int offset)
        {
            /*
             * We must iterate backwards here or else the start/end positions will be
             * corrupted by prior replacements.
             */
            for (Reference ref : ReverseIterable.wrap(baseRef.getReferences()))
            {
                builder.replace(offset + ref.getStartPosition(),
                                offset + ref.getEndPosition(),
                                ref.getValue());

                replaceReferences(builder, ref, offset + ref.getStartPosition());
            }
        }

        /**
         * Get the reference found (if such a reference exists) at the given location in
         * the raw value.
         *
         * @param position
         *            the position to check
         * @return the reference at the given position if such a reference exists;
         *         <code>null</code> otherwise
         */
        public Reference referenceAt(int position)
        {
            for (Reference ref : rootReference.getReferences())
            {
                if (ref.getStartPosition() <= position && position <= ref.getEndPosition())
                {
                    return ref;
                }
            }

            return null;
        }
    }

    /**
     * This class wraps a list and returns an iterator that starts at the end of the list
     * and moves backwards. This is useful when using an enhanced for loop, such as:
     *
     * <pre>
     * <code>
     * List&lt;Animal&gt; animals = ...
     *
     * for (Animal animal : ReverseIterable.wrap(animals))
     * {
     *     // feeding the animals backwards is more efficient
     *     animal.feed();
     * }
     * </code>
     * </pre>
     *
     * @param <T>
     *            the type of elements in the list to be wrapped
     *
     * @author Gregory P. Moyer
     */
    private static class ReverseIterable<T> implements Iterable<T>
    {
        /**
         * The list wrapped by this instance.
         */
        private final List<T> list;

        /**
         * A convenience method to construct a new instance without have to restate the
         * type (it is inferred rather than explicit).<br>
         * <br>
         * The following are equivalent:
         *
         * <pre>
         * <code>
         * ReverseIterable&lt;Animal&gt; backwardsAnimals = new ReverseIterable&lt;Animal&gt;(new ArrayList&lt;Animal&gt;());
         *
         * ReverseIterable&lt;Animal&gt; backwardsAnimals = ReverseIterable.wrap(new ArrayList&lt;Animal&gt;());
         * </code>
         * </pre>
         *
         * @param <T>
         *            the type of elements in the list to be wrapped
         * @param list
         *            the list to be wrapped
         * @return a new instance
         */
        public static <T> ReverseIterable<T> wrap(List<T> list)
        {
            return new ReverseIterable<T>(list);
        }

        /**
         * Construct a new instance wrapping the given list.
         *
         * @see #wrap(List)
         *
         * @param list
         *            the list to wrap
         */
        public ReverseIterable(List<T> list)
        {
            this.list = list;
        }

        @Override
        public Iterator<T> iterator()
        {
            return new Iterator<T>()
            {
                private final ListIterator<T> iterator = list.listIterator(list.size());

                @Override
                public boolean hasNext()
                {
                    return iterator.hasPrevious();
                }

                @Override
                public T next()
                {
                    return iterator.previous();
                }

                @Override
                public void remove()
                {
                    iterator.remove();
                }
            };
        }
    }
}
