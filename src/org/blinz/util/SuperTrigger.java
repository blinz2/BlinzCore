/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009  BlinzProject <gtalent2@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 3 as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.blinz.util;

import java.util.ArrayList;

/**
 *
 * @author gary
 */
public abstract class SuperTrigger extends Trigger {

    protected final ArrayList<Trigger> triggers = new ArrayList<Trigger>();

    /**
     * Adds the given trigger to the list of triggers used in evaluation.
     * @param trigger - the trigger object to be added.
     */
    public final void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    /**
     * Adds the given trigger to the trigger to list of triggers used in evaluation.
     * @param index - integer value specifying which trigger to delete.
     */
    public final void removeTrigger(int index) {
        triggers.remove(index);
    }

    /**
     * Removes the given trigger from the list of triggers used in evaluation.
     * @param trigger - the trigger object to be removed.
     */
    public final void removeTrigger(Trigger trigger) {
        triggers.remove(this);
    }

    /**
     * Returns the trigger at the specified index.
     * @param index
     * @return trigger at the specified index.
     */
    public final Trigger getTrigger(int index) {
        return triggers.get(index);
    }
}
