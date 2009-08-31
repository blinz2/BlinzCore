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
 * Class to or together multiple Triggers.
 * @author Blinz Project
 */
public class OrTrigger extends SuperTrigger {

    /**
     * Checks to see if any of the Triggers return true.
     * @return true if any of the triggers return true, false otherwise
     */
    @Override
    public boolean evaluate() {
        for (Trigger trigger : triggers) {
            if (trigger.evaluate()) {
                return true;
            }
        }
        return false;
    }
}
