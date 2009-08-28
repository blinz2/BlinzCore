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
package blinz.input;

import blinz.util.Position;

/**
 *
 * @author gary
 */
public class MouseEvent {

    public static final int CLICK = 0;
    public static final int PRESS = 1;
    private int button;
    private int clicks;
    private Position cursorLocation;

    MouseEvent(int button, int clicks, Position loc) {
        this.button = button;
        this.clicks = clicks;
        cursorLocation = loc;
    }

    public final int getButton() {
        return button;
    }

    public final int getClickCount() {
        return clicks;
    }

    public final int getCursorX() {
        return cursorLocation.x;
    }

    public final int getCursorY() {
        return cursorLocation.y;
    }

    public final Position getCursorLocation() {
        return new Position(cursorLocation);
    }
}
