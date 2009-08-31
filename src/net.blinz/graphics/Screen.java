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
package net.blinz.graphics;

import net.blinz.util.Bounds;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author gary
 */
public abstract class Screen {

    public final static int FULL_SCREEN = 0;
    public final static int LEFT_SCREEN = 1;
    public final static int RIGHT_SCREEN = 2;
    public final static int TOP_SCREEN = 3;
    public final static int BOTTOM_SCREEN = 4;
    public final static int TOP_LEFT_SCREEN = 5;
    public final static int TOP_RIGHT_SCREEN = 6;
    public final static int BOTTOM_LEFT_SCREEN = 7;
    public final static int BOTTOM_RIGHT_SCREEN = 8;
    private int screenType = FULL_SCREEN;
    private final Bounds bounds = new Bounds();
    private final Graphics graphics = new Graphics();

    public final void setScreenType(int type) {
        screenType = type;
    }

    /**
     * Returns the width of this Screen.
     * @return width of this Screen.
     */
    public final int getWidth() {
        return bounds.getWidth();
    }

    /**
     * Returns the height of this Screen.
     * @return height of this Screen.
     */
    public final int getHeight() {
        return bounds.getHeight();
    }

    final void draw(GLAutoDrawable gl) {
        generateBounds();
        graphics.setContext(gl);
        graphics.setScreenBounds(bounds);
        graphics.load();
        draw(graphics);
    }

    final void generateBounds() {
        switch (screenType) {
            case FULL_SCREEN:
                bounds.setBounds(0, 0, Display.getDrawingAreaWidth(), Display.getDrawingAreaHeight());
                break;
            case TOP_SCREEN:
                bounds.setBounds(0, Display.getDrawingAreaHeight() / 2,
                        Display.getDrawingAreaWidth(), Display.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_SCREEN:
                bounds.setBounds(0, 0, Display.getDrawingAreaWidth(), Display.getDrawingAreaHeight() / 2);
                break;
            case LEFT_SCREEN:
                bounds.setBounds(0, 0, Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight());
                break;
            case TOP_LEFT_SCREEN:
                bounds.setBounds(0, Display.getDrawingAreaHeight() / 2,
                        Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight() / 2);
                break;
            case TOP_RIGHT_SCREEN:
                bounds.setBounds(Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight() / 2,
                        Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_LEFT_SCREEN:
                bounds.setBounds(0, 0, Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_RIGHT_SCREEN:
                bounds.setBounds(Display.getDrawingAreaWidth() / 2, 0,
                        Display.getDrawingAreaWidth() / 2, Display.getDrawingAreaHeight() / 2);
                break;
        }
    }

    protected abstract void draw(Graphics graphics);
}
