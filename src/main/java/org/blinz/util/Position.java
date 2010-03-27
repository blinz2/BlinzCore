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
package org.blinz.util;

/**
 * Class for holding coordinates.
 * @author Blinz Project
 */
public class Position {

    /**
     * X coordinate of this Position.
     */
    public int x = 0;
    /**
     * Y coordinate of this Position.
     */
    public int y = 0;

    /**
     * Default constructer without parameters, location defaults to (0, 0).
     */
    public Position() {
    }

    /**
     * Creates a new Position with the given coordinates.
     * @param x
     * @param y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a new Position with the values of position.
     * @param position
     */
    public Position(Position position) {
        x = position.x;
        y = position.y;
    }

    /**
     * Sets this Positions coordinate to that of the given coordinates.
     * @param x
     * @param y
     */
    public final void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Sets this Positions coordinates to that of the given Position.
     * @param position
     */
    public final void setPosition(Position position) {
        setPosition(position.x, position.y);
    }

    /**
     * Sets the x coordinate of this Position to the given value.
     * @param x
     */
    public final void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of this Position to the given value.
     * @param y
     */
    public final void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x coordinate of this Position.
     * @return x
     */
    public final int getX() {
        return x;
    }

    /**
     * Gets the y coordinate of this Position.
     * @return y
     */
    public final int getY() {
        return y;
    }

    /**
     * Adds mod to this Position's x coordinate.
     * @param mod
     */
    public final void modX(int mod) {
        x += mod;
    }

    /**
     * Adds mod to this Position's y coordinate.
     * @param mod
     */
    public final void modY(int mod) {
        y += mod;
    }

    /**
     * Adds the mods to their respective attributes.
     * @param xMod
     * @param yMod
     */
    public final void modPosition(int xMod, int yMod) {
        x += xMod;
        y += yMod;
    }
}
