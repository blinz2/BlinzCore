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

/**
 * Instances of this class representing various desired fonts are given to the Graphics
 * class to determine how to draw text.
 * @author Blinz Project
 */
public final class Font {

    FontStub stub;
    private String name;

    /**
     * Constructor
     */
    Font() {
    }

    /**
     * Returns a String representing the name of this font.
     * @return String representing the name of this font
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns an int representing the size of this font.
     * @return in representing the size of this font.
     */
    public final int getSize() {
        return stub.getSize();
    }

    /**
     * Returns the width of the given character.
     * @param character
     * @return int width of the specified char, rounded from floating point value
     */
    public final int getCharWidth(final char character) {
        return Math.round(stub.getRenderer().getCharWidth(character));
    }

    /**
     * Gets the width of the given String when drawn on the screen with the current font.
     * @param string the String to be measured
     * @return the width of the given String when drawn on the screen with the current font
     */
    public final long getStringWidth(final String string) {
        double total = 0;
        for (int i = 0; i < string.length(); i++) {
            total += stub.getRenderer().getCharWidth(string.charAt(i));
        }
        return Math.round(total);
    }

    /**
     * Returns this Font's shared font stub.
     * @return
     * @throws NullPointerException - likely means this font was not found.
     */
    final FontStub getStub() throws NullPointerException {
        return stub;
    }

    @Override
    protected void finalize() throws Throwable {
        stub.dependentCount--;
        super.finalize();
    }
}
