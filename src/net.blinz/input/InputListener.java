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
package net.blinz.input;

import net.blinz.util.Position;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Gary
 */
class InputListener implements KeyListener, MouseListener, MouseMotionListener {

    private final boolean[] keysPressed = new boolean[526];
    private final boolean[] mouseButtonsPressed = new boolean[20];
    private final ArrayList<net.blinz.input.MouseListener> mouseListeners =
            new ArrayList<net.blinz.input.MouseListener>();
    private final ArrayList<net.blinz.input.KeyListener> keyListeners =
            new ArrayList<net.blinz.input.KeyListener>();
    private final Position cursorLocation = new Position();

    InputListener() {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (net.blinz.input.KeyListener listener : keyListeners) {
            listener.keyTyped(e.getKeyCode());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (net.blinz.input.KeyListener listener : keyListeners) {
            listener.keyPressed(e.getKeyCode());
        }
        keysPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (net.blinz.input.KeyListener listener : keyListeners) {
            listener.keyReleased(e.getKeyCode());
        }
        keysPressed[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (net.blinz.input.MouseListener listener : mouseListeners) {
            listener.buttonClick(e.getButton(), e.getClickCount(), e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (net.blinz.input.MouseListener listener : mouseListeners) {
            listener.buttonPress(e.getButton(), e.getX(), e.getY());
        }
        mouseButtonsPressed[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (net.blinz.input.MouseListener listener : mouseListeners) {
            listener.buttonRelease(e.getButton(), e.getX(), e.getY());
        }
        mouseButtonsPressed[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        cursorLocation.setPosition(e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        cursorLocation.setPosition(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        cursorLocation.setPosition(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorLocation.setPosition(e.getX(), e.getY());
    }

    final boolean[] getKeys() {
        return keysPressed;
    }

    final boolean[] getMouseButtons() {
        return mouseButtonsPressed;
    }

    final void addMouseListener(net.blinz.input.MouseListener listener) {
        mouseListeners.add(listener);
    }

    final void addKeyListener(net.blinz.input.KeyListener listener) {
        keyListeners.add(listener);
    }

    final void removeMouseListener(net.blinz.input.MouseListener listener) {
        mouseListeners.remove(listener);
    }

    final void removeKeyListener(net.blinz.input.KeyListener listener) {
        keyListeners.remove(listener);
    }
}
