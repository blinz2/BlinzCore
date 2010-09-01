/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2010  BlinzProject <gtalent2@gmail.com>
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

/**
 * Super-class for resource stub.
 * @author Blinz Project
 */
abstract class ResourceStub {

    private int totalDeps = 1;

    /**
     * Constructor
     */
    ResourceStub() {
    }

    /**
     * Gets the number of dependents of this stub.
     * @return the number of dependents of this stub
     */
    final int dependents() {
        return totalDeps;
    }

    /**
     * Increments the number of references the given Client has to this Stub.
     */
    final void incrementDependents() {
        totalDeps++;
    }

    /**
     * Decrements the number of references the given Client has to this Stub.
     */
    final void decrementDependents() {
        totalDeps--;
    }
}
