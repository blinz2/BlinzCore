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

/**
 * Abstract class that wraps and evaluates boolean statements.
 * @author Trigger
 */
public abstract class Trigger {

    private boolean enabled = true;

    /**
     * This method enables the Trigger, if enabled it can return true.
     * Enabled by default.
     */
    public final void enable() {
        enabled = true;
    }

    /**
     * This method enables the Trigger, if disabled cannot can return true.
     * Enabled by default.
     */
    public final void disable() {
        enabled = false;
    }

    /**
     * Checks this Trigger's condition.
     * @return true if this Trigger's condition evaluates to true, false otherwise
     */
    public final boolean condition() {
        return evaluate() && enabled;
    }

    /**
     * 
     * @return true if this Trigger's condition is true, false otherwise
     */
    protected abstract boolean evaluate();
}
