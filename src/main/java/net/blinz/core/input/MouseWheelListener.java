/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009-2010 BlinzProject <gtalent2@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
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
package net.blinz.core.input;

/**
 * An interface for listening to movement of the mouse wheel.
 * @author Blinz Project
 */
public interface MouseWheelListener {

    /**
     * Called when the mouse wheel is scrolled.
     * @param number amount of clicks the mouse was scrolled, a negative number
     * denotes an upwards scroll while a positive denotes a downwards scroll
     */
    public void wheelScroll(int number, int cursorX, int cursorY);
}
