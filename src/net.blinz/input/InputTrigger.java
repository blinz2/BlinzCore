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
package net.blinz.input;

import net.blinz.util.Trigger;

/**
 *
 * @author gary
 */
public class InputTrigger extends Trigger {

    public static final int MOUSE = 0;
    public static final int KEYBOARD = 1;
    private int deviceType = KEYBOARD;
    private int buttonID;

    public InputTrigger() {
    }

    public InputTrigger(int deviceType, int buttonID) {
        this.deviceType = deviceType;
        this.buttonID = buttonID;
    }

    @Override
    protected boolean evaluate() {
        if (deviceType == MOUSE) {
            return UserInput.mouseButtonPressed(buttonID);
        } else if (deviceType == KEYBOARD) {
            return UserInput.keyPressed(buttonID);
        } else {
            return false;
        }
    }


}
