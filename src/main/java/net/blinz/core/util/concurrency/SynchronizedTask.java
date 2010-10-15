/*
 *  BlinzEngine - A library for large 2D world simultions and games.
 *  Copyright (C) 2009  Blinz <gtalent2@gmail.com>
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
package net.blinz.core.util.concurrency;

/**
 * A non-re-entrant task. To be used on Tasks that need be executed once per loop.
 * @author Blinz
 */
public abstract class SynchronizedTask extends Task {

    @Override
    synchronized boolean moveOn() {
        if (moveOn) {
            return true;
        } else {
            setMoveOn();
            return false;
        }
    }
}
