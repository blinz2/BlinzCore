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
import org.blinz.util.Position;

/**
 * Represents a viewport window in which everything protuding from is sides is not drawn.
 * @author Blinz Project
 */
class Viewport extends Bounds {

    Bounds parent;
    private final Position translation = new Position();
    private final Bounds bounds = new Bounds();

    /**
     * Sets the bounds of this Viewport.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    final void setViewport(int x, int y, int width, int height) {
        bounds.setBounds(x, y, width, height);
    }

    /**
     * Sets the this object to bounds that do not go outside the Screen
     * and compensates for the fact that OpenGL places the point of origin at the
     * lower left corner of the viewport.
     */
    final void fixViewport() {
        if (parent instanceof Viewport) {
            ((Viewport) parent).fixViewport();
            translation.modPosition(((Viewport) parent).getXTranslation(),
                    ((Viewport) parent).getYTranslation());
        } else {
            translation.setPosition(0, 0);
        }

        this.setBounds(bounds);
        Bounds i = this;
        //reset view port translation mod

        //handle x and width of the view port
        {
            //if view port sticks off the right of the screen
            if (i.getX() + i.getWidth() > parent.getWidth()) {
                //if the whole view port is to the right of the screen
                if (i.getX() > parent.getWidth()) {
                    i.setBounds(0, 0, 0, 0);
                    return;
                }

                i.modWidth(-((i.getX() + i.getWidth()) - parent.getWidth()));
            }
            //if view port sticks off the left of the screen
            if (i.getX() < 0) {
                //if the whole view port is to the left of the screen
                if (i.getX() + i.getWidth() < 0) {
                    i.setBounds(0, 0, 0, 0);
                    return;
                }
                translation.setX(-i.getX());
                i.setX(0);
            }
        }//end code for handling x and width

        //handle y and height of the view port
        {
            //translate the y

            //if view port sticks off the right of the screen
            if (i.getY() + i.getHeight() > parent.getHeight()) {
                //if the whole view port is to the right of the screen
                if (i.getY() > parent.getHeight()) {
                    i.setBounds(0, 0, 0, 0);
                    return;
                }

                i.modHeight(-((i.getY() + i.getHeight()) - parent.getHeight()));
            }
            //if view port sticks off the left of the screen
            if (i.getY() < 0) {
                //if the whole view port is to the left of the screen
                if (i.getY() + i.getHeight() < 0) {
                    i.setBounds(0, 0, 0, 0);
                    return;
                }
                translation.setY(-i.getY());
                i.setY(0);
            }

            //invert the y axis and start it at 0 plus height of screen
            i.setY((parent.getHeight() - i.getY()) - i.getHeight());
        }


        i.modX(parent.getX());
        i.modY(parent.getY());
    }

    /**
     * Returns the x translation of this viewport.
     * @return x translation of this viewport
     */
    final int getXTranslation() {
        return translation.x;
    }

    /**
     * Returns the y translation of this viewport.
     * @return y translation of this viewport
     */
    final int getYTranslation() {
        return translation.y;
    }
}
