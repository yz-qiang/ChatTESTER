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
import java.util.Iterator;
import java.util.List;

// TODO need a history limit

/**
 * This class provides a naive stack implementation with the ability to move
 * back and forth through the stack. It is naive in that it maintains references
 * to all of the values, not differences between them. However, it is suitable
 * for simple values, such as primitive wrappers or Strings.
 *
 * @param <T>
 *            the type of element tracked by this stack
 *
 * @author Gregory P. Moyer
 */
/* default */class ChangeStack<T>
{
    /**
     * The stack of changes being tracked.
     */
    private final List<T> stack;

    /**
     * The current location in the stack. This will change as operations are
     * performed (such as changing the value, undoing a change, or redoing a
     * change).
     */
    private int currentLoc;

    /**
     * The location of the last value that was synchronized. It is up to the
     * client to determine when this should be set (e.g. what does it mean to be
     * synchronized).
     */
    private int syncLoc = -1;

    /**
     * Create a new stack with the given initial value. This new stack will be
     * in a {@link #synced() synced}, {@link #isModified() unmodified} state.
     *
     * @param value
     *            the initial value of this stack
     */
    public ChangeStack(T value)
    {
        this(value, true);
    }

    /**
     * Create a new stack with the given initial value.
     *
     * @param value
     *            the initial value of this stack
     * @param sync
     *            if <code>true</code>, the initial state will be
     *            {@link #synced() synced} and {@link #isModified() unmodified};
     *            otherwise the the initial state will be {@link #isModified()
     *            modified}
     */
    public ChangeStack(T value, boolean sync)
    {
        stack = new ArrayList<T>();
        stack.add(value);

        if (sync)
        {
            synced();
        }
    }

    /**
     * Push the given value onto the stack. This will invalidate all future
     * changes, which removes redo capability until an undo is called.<br>
     * <br>
     * Note that this method will do nothing if the new value is the same as the
     * current value.
     *
     * @param value
     *            the new value to push
     * @return <code>true</code> if {@link #getCurrentValue()} changes as a
     *         result of this call; <code>false</code> otherwise
     * @throws NullPointerException
     *             if the given value is <code>null</code>
     */
    public synchronized boolean push(T value) throws NullPointerException
    {
        if (value.equals(getCurrentValue()))
        {
            return false;
        }

        if (stack.size() > currentLoc + 1)
        {
            Iterator<T> iter = stack.listIterator(currentLoc + 1);
            while (iter.hasNext())
            {
                iter.next();
                iter.remove();
            }
        }

        stack.add(value);
        currentLoc++;

        return true;
    }

    /**
     * This method behaves exactly like {@link #push(Object)}, except that it
     * will mark the current value after {@link #push(Object)} as
     * {@link #synced()}. The marking will happen regardless of whether or not
     * the {@link #getCurrentValue() current value} changed as a result of this
     * call.<br>
     * <br>
     * To put it another way, it is guaranteed that after this call
     * {@link #getCurrentValue()} will return the given value and
     * {@link #isModified()} will return <code>false</code>.
     *
     * @param value
     *            the new value to push
     * @return <code>true</code> if {@link #getCurrentValue()} changes as a
     *         result of this call; <code>false</code> otherwise
     * @throws NullPointerException
     *             if the given value is <code>null</code>
     */
    public synchronized boolean sync(T value) throws NullPointerException
    {
        boolean pushed = push(value);
        synced();

        return pushed;
    }

    /**
     * Record that the current location has been synchronized. It is guaranteed
     * that after this method completes {@link #isModified()} will return
     * <code>false</code>.
     */
    public synchronized void synced()
    {
        syncLoc = currentLoc;
    }

    /**
     * Determine whether or not the current value is the same as the synced
     * value. This method will return <code>true</code> if the two values are
     * equal, even if modifications have been made between the last synced value
     * and the current value.
     *
     * @return <code>true</code> if the {@link #getCurrentValue() current value}
     *         is equal to the {@link #getSyncedValue() last synced value};
     *         <code>false</code> otherwise
     */
    public synchronized boolean isModified()
    {
        return !getCurrentValue().equals(getSyncedValue());
    }

    /**
     * Retrieve the current value for the property to which this stack is
     * registered.
     *
     * @return the current value
     */
    public synchronized T getCurrentValue()
    {
        return stack.get(currentLoc);
    }

    /**
     * Retrieve the last synced value for the property to which this stack is
     * registered. If the value has never been synced, <code>null</code> will be
     * returned.
     *
     * @see #sync(Object)
     * @see #synced()
     *
     * @return the synced value or <code>null</code> if the stack has never been
     *         synced
     */
    public synchronized T getSyncedValue()
    {
        return syncLoc < 0 ? null : stack.get(syncLoc);
    }

    /**
     * Determine whether or not {@link #undo()} can be called.
     *
     * @return <code>true</code> if there is at least one past value on the
     *         stack; <code>false</code> otherwise
     */
    public synchronized boolean isUndoPossible()
    {
        return currentLoc > 0;
    }

    /**
     * Determine whether or not {@link #redo()} can be called.
     *
     * @return <code>true</code> if there is at least one future value on the
     *         stack; <code>false</code> otherwise
     */
    public synchronized boolean isRedoPossible()
    {
        return currentLoc < stack.size() - 1;
    }

    /**
     * Undo the last modification. After this call completes, {@link #redo()}
     * may be used until a new modification is made. If undo is not possible,
     * the {@link #getCurrentValue() current value} will be returned with no
     * change.
     *
     * @return the new {@link #getCurrentValue() current value}
     */
    public synchronized T undo()
    {
        if (!isUndoPossible())
        {
            return getCurrentValue();
        }

        return stack.get(--currentLoc);
    }

    /**
     * Redo the last undo. This method will only have an effect after at least
     * one successful call to {@link #undo()} and before any new modifications
     * are made. If redo is not possible, the {@link #getCurrentValue() current
     * value} will be returned with no change.
     *
     * @return the new {@link #getCurrentValue() current value}
     */
    public synchronized T redo()
    {
        if (!isRedoPossible())
        {
            return getCurrentValue();
        }

        return stack.get(++currentLoc);
    }
}
