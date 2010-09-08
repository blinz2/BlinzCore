/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2010  BlinzProject <gtalent2@gmail.com>
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
package org.blinz.util;

/**
 *
 * @author Blinz Project
 */
public final class Client {

    private Process process;
    /**
     * The port on which the process is to be communicated with.
     */
    private int port;

    /**
     * Gets the port communication with this Client takes place on.
     * @return the port communication with this Client takes place on
     */
    public final int getPort() {
        return port;
    }

    /**
     * Ends the process of this Client.
     */
    final void kill() {
        process.destroy();
    }
}
