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
package net.blinz.core.util;

import java.util.Vector;

/**
 * Holds clients of the program.
 * @author Blinz Project
 */
public final class Clients {

    private final static Vector<Client> clients = new Vector<Client>();
    private final static Client local = new Client();

    /**
     * Gets the Client object for the local process.
     * @return the Client object for the local process
     */
    public final static Client localProcess() {
        return local;
    }
}
