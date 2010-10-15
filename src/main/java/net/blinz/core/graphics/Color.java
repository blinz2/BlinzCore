/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009-2010  BlinzProject <gtalent2@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
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
package net.blinz.core.graphics;

/**
 * Color class used to represent various colors using RGB values.
 * @author Blinz Project
 */
public final class Color {

    byte red = 0;
    byte green = 0;
    byte blue = 0;

    /**
     * Creates a Color object, defaults to black.
     */
    public Color() {
    }

    /**
     * Creates a Color object based on the values provided.
     * @param red the red value in the RGB
     * @param green the red value in the RGB
     * @param blue the red value in the RGB
     */
    public Color(final int red, final int green, final int blue) {
        setColor(red, green, blue);
    }

    /**
     * Sets the Color to the mix of the provided RGB values.
     * @param red the red value in the RGB
     * @param green the green value in the RGB
     * @param blue the blue value in the RGB
     */
    public final void setColor(final int red, final int green, final int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    /**
     * Sets the drawing color to the color represented by the passed Color object.
     * @param color a Color object representing the color for this Color objec to take
     */
    public final void setColor(final Color color) {
        setColor(color.red, color.green, color.blue);
    }

    /**
     * Sets the red value of the RGB values in this Color object to the given value.
     * @param red red value in this Color's RGB
     */
    public final void setRed(int red) {
        if (red > 127) {
            red = 127;
        }
        this.red = (byte) red;
    }

    /**
     * Sets the green value of the RGB values in this Color object to the given value.
     * @param green green value in this Color's RGB
     */
    public final void setGreen(int green) {
        if (green > 127) {
            green = 127;
        }
        this.green = (byte) green;
    }

    /**
     * Sets the blue value of the RGB values in this Color object to the given value.
     * @param blue blue value in this Color's RGB
     */
    public final void setBlue(int blue) {
        if (blue > 127) {
            blue = 127;
        }
        this.blue = (byte) blue;
    }

    /**
     * Gets the blue value in this Color's RGB.
     * @return the red value in this Color's RGB
     */
    public final byte getRed() {
        return red;
    }

    /**
     * Gets the blue value in this Color's RGB.
     * @return the blue value in this Color's RGB
     */
    public final byte getGreen() {
        return green;
    }

    /**
     * Gets the blue value in this Color's RGB.
     * @return the blue value in this Color's RGB
     */
    public final byte getBlue() {
        return blue;
    }

    /**
     * Gets a float representing the red value in a scale of 0 to 1.
     * @return a float representing the red value in a scale of  0 to 1.
     */
    float getRedf() {
        return (float) ((red * 100 / 128) * .01);
    }

    /**
     * Gets a float representing the green value in a scale of 0 to 1.
     * @return a float representing the green value in a scale of  0 to 1.
     */
    float getGreenf() {
        return (float) ((green * 100 / 128) * .01);
    }

    /**
     * Gets a float representing the blue value in a scale of 0 to 1.
     * @return a float representing the blue value in a scale of 0 to 1.
     */
    float getBluef() {
        return (float) ((blue * 100 / 128) * .01);
    }
}
