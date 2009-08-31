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
package org.blinz.input;

import org.blinz.graphics.Display;

/**
 * UserInput allows initialization and basic access to the current state of the
 * input system through static method calls. It includes methods to determine the
 * currents state of the keyboard and mouse.
 * @author Blinz Project
 */
public final class UserInput {

    private static boolean isInitialized = false;
    private static final InputListener listener = new InputListener();

    /**
     * Initializes the UserInput system.
     */
    public static final synchronized void init() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;
        if (Display.isInitialized()) {
            Display.setInputContext(listener);
        }
    }

    /**
     * Indicates whether or not the UserInput system is active.
     * @return true if UserInput has been initialized, false otherwise.
     */
    public static final boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Returns true if the specified key is currently pressed, false if it is not.
     * @param key
     * @return true if the specified key is currently pressed.
     */
    public static final boolean keyPressed(int key) {
        return listener.getKeys()[key];
    }

    /**
     * Returns true if the specified mouse button is currently pressed, false if
     * it is not.
     *
     * Supports up to 20 mouse buttons.
     * @param button
     * @return true if the specified key is currently pressed.
     */
    public static final boolean mouseButtonPressed(int button) {
        return listener.getMouseButtons()[button];
    }

    /**
     * Adds the specified KeyListener to the list of KeyListeners that
     * are to be informed of events correspoding to their methods.
     * @param keyListener
     */
    public static final void addKeyListener(KeyListener keyListener) {
        listener.addKeyListener(keyListener);
    }

    /**
     * Adds the specified KeyListener to the list of MouseListeners that
     * are to be informed of events correspoding to their methods.
     * @param mouseListener
     */
    public static final void addMouseListener(MouseListener mouseListener) {
        listener.addMouseListener(mouseListener);
    }

    /**
     * Removes the specified KeyListener from the list of MouseListeners that
     * are to be informed of events correspoding to their methods.
     * @param keyListener
     */
    public static final void removeKeyListener(KeyListener keyListener) {
        listener.removeKeyListener(keyListener);
    }

    /**
     * Removes the specified MouseListener from the list of MouseListeners that
     * are to be informed of events correspoding to their methods.
     * @param mouseListener
     */
    public static final void removeMouseListener(MouseListener mouseListener) {
        listener.removeMouseListener(mouseListener);
    }

    /**
     * This method is of no interest to users of this API, it exist only for
     * passing an internal object from one package to another. Ideally this would
     * not be publically accessable and hopefully will not be in future releases.
     */
    @Deprecated
    public static final Object getContext() {
        return listener;
    }
}
