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
package blinz.util;

/**
 *
 * @author gary
 */
public class Position3D {

    public int x = 0,  y = 0;
    public double z = 0;

    public Position3D() {
    }

    public Position3D(int x, int y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position3D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position3D(Position3D location) {
        x = location.x;
        y = location.y;
        z = location.z;
    }

    public final void setPosition(int x, int y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public final void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public final void setPosition(Position3D position) {
        setPosition(position.x, position.y, position.z);
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final void setY(int y) {
        this.y = y;
    }

    public final void setZ(double z) {
        this.z = z;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final double getZ() {
        return z;
    }

    public final void modX(int mod) {
        x += mod;
    }

    public final void modY(int mod) {
        y += mod;
    }

    public final void modZ(int mod) {
        z += mod;
    }
}
