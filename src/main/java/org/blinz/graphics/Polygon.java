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
import org.blinz.util.Position;

/**
 * Polygon stores a series of points, each being connected to the previous with
 * the exception of the last one which is connected to the first.
 * @author Blinz Project
 */
public final class Polygon {

    /**
     * List storing points on the polygon.
     */
    private final Vector<Position> points = new Vector<Position>();

    /**
     * Adds a copy of the specified point to the last spot on the list.
     * @param loc
     */
    public final void addPoint(final Position loc) {
        points.add(new Position(loc));
    }

    /**
     * Adds the specified point to the last spot on the list.
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public final void addPoint(final int x, final int y) {
        points.add(new Position(x, y));
    }

    /**
     * Adds the specified point to the last spot on the list by reference.
     * @param loc a reference tot he point to be added
     */
    public final void addPointByReference(final Position loc) {
        points.add(loc);
    }

    /**
     * Gets the point at the specified index.
     * @param index the index of the desired point
     * @return the point at index
     */
    public final Position get(final int index) {
        return points.get(index);
    }

    /**
     * Returns the number of points in the Polygon.
     * @return int - number of points in the Polygon.
     */
    public final int size() {
        return points.size();
    }
}
