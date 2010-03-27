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
package org.blinz.graphics;

/**
 * An exception thrown when a requested font is not found.
 * @author Blinz Project
 */
public class FontNotFoundException extends Exception {

    /**
     * Creates a new instance of FontNotFoundException without detail message.
     */
    public FontNotFoundException() {
    }


    /**
     * Constructs an instance of FontNotFoundException with the specified detail message.
     * @param msg the detail message.
     */
    public FontNotFoundException(String msg) {
        super(msg);
    }
}
