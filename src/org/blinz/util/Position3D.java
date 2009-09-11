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
 * Class for holding 3 dimensional coordinates.
 * @author Blinz Project
 */
public class Position3D extends Position {

    /**
     * Z coordinate of this Position.
     */
    public float z = 0;

    /**
     * Default constructer without parameters, location defaults to (0, 0).
     */
    public Position3D() {
    }

    /**
     * Creates a new Position with the given coordinates.
     * @param x
     * @param y
     */
    public Position3D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a new Position with the given coordinates.
     * @param x
     * @param y
     */
    public Position3D(int x, int y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a new Position with the values of position.
     * @param position
     */
    public Position3D(Position3D position) {
        x = position.x;
        y = position.y;
        z = position.z;
    }

    /**
     * Sets this Positions coordinate to that of the given coordinates.
     * @param x
     * @param y
     */
    public final void setPosition(int x, int y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * Sets this Positions coordinates to that of the given Position.
     * @param position
     */
    public final void setPosition3D(Position3D position) {
        setPosition(position.x, position.y, position.z);
    }

    /**
     * Sets the z coordinate of this Position to the given value.
     * @param z
     */
    public final void setZ(float z) {
        this.z = z;
    }

    /**
     * Gets the z coordinate of this Position.
     * @return z
     */
    public final double getZ() {
        return z;
    }

    /**
     * Adds mod to this Position's z coordinate.
     * @param mod
     */
    public final void modZ(double mod) {
        z += mod;
    }
}
