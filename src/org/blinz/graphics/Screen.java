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

import org.blinz.util.Bounds;
import javax.media.opengl.GLAutoDrawable;

/**
 * Screen class is necessary to draw to the Display. Screen class allows dividing 
 * the display into section such as top right or bottom left.
 * @author Blinz Project
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

    /**
     * Sets the screen type out of a variety of types such as top left or bottom
     * right.
     *
     * Example:
     *          screen.setScreenType(Screen.TOP_RIGHT_SCREEN);
     * 
     * @param type int
     */
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

    /**
     * Draw this Screen.
     * @param gl context for this Screen.
     */
    final void draw(GLAutoDrawable gl) {
        computeBounds();
        graphics.setContext(gl);
        graphics.setScreenBounds(bounds);
        graphics.load();
        draw(graphics);
    }

    /**
     * Calculates the bounds of this Screen according to its screen type.
     */
    private final void computeBounds() {
        switch (screenType) {
            case FULL_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getDrawingAreaWidth(), ScreenManager.getDrawingAreaHeight());
                break;
            case TOP_SCREEN:
                bounds.setBounds(0, ScreenManager.getDrawingAreaHeight() / 2,
                        ScreenManager.getDrawingAreaWidth(), ScreenManager.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getDrawingAreaWidth(), ScreenManager.getDrawingAreaHeight() / 2);
                break;
            case LEFT_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight());
                break;
            case TOP_LEFT_SCREEN:
                bounds.setBounds(0, ScreenManager.getDrawingAreaHeight() / 2,
                        ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight() / 2);
                break;
            case TOP_RIGHT_SCREEN:
                bounds.setBounds(ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight() / 2,
                        ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_LEFT_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight() / 2);
                break;
            case BOTTOM_RIGHT_SCREEN:
                bounds.setBounds(ScreenManager.getDrawingAreaWidth() / 2, 0,
                        ScreenManager.getDrawingAreaWidth() / 2, ScreenManager.getDrawingAreaHeight() / 2);
                break;
        }
    }

    /**
     * Draw the desired screen.
     * @param graphics
     */
    protected abstract void draw(Graphics graphics);
}
