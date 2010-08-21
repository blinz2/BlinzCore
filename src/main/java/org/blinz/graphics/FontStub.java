/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2010  BlinzProject <gtalent2@gmail.com>
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

import com.sun.opengl.util.j2d.TextRenderer;

/**
 * Contains internal implementation of the font.
 * @author Blinz Project
 */
final class FontStub {

    int dependentCount = 1;
    private TextRenderer renderer;
    private String name;
    private int size;

    /**
     *
     * @param name - name of font
     * @param size - font size
     * @param font - awt form of this font
     */
    FontStub(String name, int size, java.awt.Font font) {
        this.name = name;
        this.size = size;
        renderer = new TextRenderer(font);
    }

    /**
     *
     * @return a String represting the name of the font this FontStub represents.
     */
    final String getName() {
        return name;
    }

    /**
     *
     * @return an int representing the size of the font this FontStub represents.
     */
    final int getSize() {
        return size;
    }

    /**
     *
     * @return the JOGL TextRender for the font this FontStub represents.
     */
    final TextRenderer getRenderer() {
        return renderer;
    }
}
