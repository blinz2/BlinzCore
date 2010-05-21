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
 *
 * @author Blinz Project
 */
public class Size {

    public int width = 0, height = 0;

    /**
     * Creates a new Size with dimensions defaulting to 0.
     */
    public Size() {
    }

    /**
     * Creates a new Size with the dimensions of the given Size.
     * @param size
     */
    public Size(Size size) {
	width = size.width;
	height = size.height;
    }

    /**
     * Creates a new Size with the given dimensions.
     * @param width
     * @param height
     */
    public Size(int width, int height) {
	this.width = width;
	this.height = height;
    }

    /**
     * Gets the width attribute of this Size.
     * @return width
     */
    public int getWidth() {
	return width;
    }

    /**
     * Gets the height attribute of this Size.
     * @return height
     */
    public int getHeight() {
	return height;
    }

    /**
     * Sets the width of this size to the given value.
     * @param width
     */
    public final void setWidth(int width) {
	this.width = width;
    }

    /**
     * Sets the height of this size to the given value.
     * @param height
     */
    public final void setHeight(int height) {
	this.height = height;
    }

    /**
     * Sets the dimensions of this Size to that of the given values.
     * @param width
     * @param height
     */
    public final void setSize(int width, int height) {
	this.width = width;
	this.height = height;
    }

    /**
     * Sets the dimensions of this Size to that of the given Size.
     * @param size
     */
    public final void setSize(Size size) {
	width = size.width;
	height = size.height;
    }

    /**
     * Adds mod to width.
     * @param mod
     */
    public final void modWidth(int mod) {
	width += mod;
    }

    /**
     * Adds mod to height.
     * @param mod
     */
    public final void modHeight(int mod) {
	height += mod;
    }

    /**
     * Gets this objects attributes formatted as "width, height".
     * @return this objects attributes formatted as "width, height"
     */
    @Override
    public String toString() {
	return width + ", " + height;
    }
}
