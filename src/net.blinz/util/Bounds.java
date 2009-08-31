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
package net.blinz.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gary
 */
public class Bounds {

    int width = 0;
    int height = 0;
    int x = 0;
    int y = 0;

    public Bounds() {
    }

    public Bounds(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

    public Bounds(Bounds bounds) {
        setBounds(bounds);
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the coordinates of this Bounds to that of the given Location object.
     * @param location
     */
    public final void setPosition(Position location) {
        x = location.x;
        y = location.y;
    }

    /**
     * Sets the coordinates of this Bounds to the given coordinates.
     * @param x
     * @param y
     */
    public final void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void setWidth(int width) {
        this.width = width;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets the size attributes of this Bounds to the given width and height.
     * @param width
     * @param height
     */
    public final void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Sets the size attributes of this Bounds that of the give Size object.
     * @param size
     */
    public final void setSize(Size size) {
        setSize(size.width, size.height);
    }

    public final void modX(int xMod) {
        x += xMod;
    }

    public final void modY(int yMod) {
        y += yMod;
    }

    public final void modWidth(int widthMod) {
        width += widthMod;
    }

    public final void modHeight(int heightMod) {
        height += heightMod;
    }

    /**
     * Sets the Bounds object to the given parameters.
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public final void setBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param bounds
     */
    public final void setBounds(Bounds bounds) {
        setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    /**
     * Returns true if the Bounds object intersects the given line.
     * Note: broken
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return true if given line intersects this Bounds
     */
    public final boolean intersectsLine(int x1, int y1, int x2, int y2) {
        return contains(x1, y1) || contains(x2, y2);
    }

    public final boolean intersects(Bounds bounds) {
        return bounds.width > 0 && bounds.height > 0 && width > 0 && height > 0 &&
                bounds.x < x + width && bounds.x + bounds.width > x && bounds.y < y + height &&
                bounds.y + bounds.height > y;
    }

    public static final boolean intersects(int x1, int x2, int y1, int y2, int width1, int width2, int height1, int height2) {
        return width1 > 0 && height1 > 0 && width2 > 0 && height2 > 0 &&
                x1 < x2 + width2 && x1 + width1 > x2 &&
                y1 < y2 + height2 && y1 + height1 > y2;
    }

    public final boolean intersects(int x, int y, int width, int height) {
        return width > 0 && height > 0 && this.width > 0 && this.height > 0 &&
                x < this.x + this.width && x + width > this.x &&
                y < this.y + this.height && y + height > this.y;
    }

    public final boolean contains(int x, int y) {
        return width > 0 && height > 0 && x >= this.x && x < this.x + width &&
                y >= this.y && y < this.y + height;
    }

    public final boolean contains(Position loc) {
        return contains(loc.x, loc.y);
    }

    @Override
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Bounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
