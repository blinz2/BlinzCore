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
package org.blinz.input;

import org.blinz.util.Trigger;

/**
 * A Trigger that checks for set input states and events.
 * @author Blinz Project
 */
public class InputTrigger extends Trigger {

    public static final int MOUSE = 0;
    public static final int KEYBOARD = 1;
    private int deviceType = KEYBOARD;
    private int buttonID;

    public InputTrigger() {
    }

    /**
     * Accepts a device type and the buttonID to determine what it checks.
     *
     * Example:
     *          new InputTrigger(InputTrigger.KEYBOARD, Key.KEY_G);
     *
     * @param deviceType
     * @param buttonID
     */
    public InputTrigger(int deviceType, int buttonID) {
        setTrigger(deviceType, buttonID);
    }

    /**
     * Sets the input state to be checked when the condition of this Trigger is
     * evaluated.
     * 
     * Example:
     *          new InputTrigger(InputTrigger.KEYBOARD, Key.KEY_G);
     *
     * @param deviceType
     * @param buttonID
     */
    public final void setTrigger(int deviceType, int buttonID) {
        this.deviceType = deviceType;
        this.buttonID = buttonID;
    }

    /**
     * Evaluates the set input state.
     * @return true if the button is pressed, false otherwise.
     */
    @Override
    protected boolean evaluate() {
        switch (deviceType) {
            case MOUSE:
                return UserInput.mouseButtonPressed(buttonID);
            case KEYBOARD:
                return UserInput.keyPressed(buttonID);
            default:
                return false;
        }
    }
}
