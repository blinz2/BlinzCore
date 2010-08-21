/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009-2010  BlinzProject <gtalent2@gmail.com>
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

import java.util.Vector;

/**
 * Class used to load fonts for drawing text with the Graphics class.
 * @author Blinz Project
 */
public class FontLoader {

    /**
     * List of existing fonts.
     */
    private static final Vector<FontStub> fontStubs = new Vector<FontStub>();

    /**
     * Gets a Font object representing the specified font.
     * @param name the name of the font
     * @param size the size of the font
     * @return a new Font object representing the specified font.
     * @throws FontNotFoundException
     */
    public static Font getFont(final String name, final int size) throws FontNotFoundException {
        for (final FontStub stub : fontStubs) {
            if (stub.getName().equals(name) && stub.getSize() == size) {
                final Font retval = new Font();
                retval.stub = stub;
                return retval;
            }
        }

        final java.awt.Font font = new java.awt.Font(name, java.awt.Font.PLAIN, size);

        if (!font.getFamily().equalsIgnoreCase(name)) {
            throw new FontNotFoundException("Font: " + name + " not found.");
        }

        final FontStub stub = new FontStub(name, size, font);
        fontStubs.add(stub);
        final Font retval = new Font();
        retval.stub = stub;
        return retval;
    }
}

