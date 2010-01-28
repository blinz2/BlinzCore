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
package org.blinz.graphics;

import java.util.Vector;
import org.blinz.util.Bounds;
import javax.media.opengl.GLAutoDrawable;
import org.blinz.input.KeyListener;
import org.blinz.input.MouseListener;
import org.blinz.input.MouseWheelListener;

/**
 * Screen class is necessary to draw to the Display. Screen class allows dividing 
 * the display into section such as top right or bottom left.
 * @author Blinz Project
 */
public abstract class Screen {

    private class InputListener implements MouseListener, MouseWheelListener, KeyListener {

        private final Vector<MouseListener> mouseListeners = new Vector<MouseListener>();
        private final Vector<KeyListener> keyListeners = new Vector<KeyListener>();
        private final Vector<MouseWheelListener> mouseWheelListeners = new Vector<MouseWheelListener>();

        @Override
        public void buttonClick(int buttonNumber, int clickCount, int cursorX, int cursorY) {
            for (MouseListener listener : mouseListeners) {
                listener.buttonClick(buttonNumber, clickCount, cursorX, cursorY);
            }
        }

        @Override
        public void buttonPress(int buttonNumber, int cursorX, int cursorY) {
            for (MouseListener listener : mouseListeners) {
                listener.buttonPress(buttonNumber, cursorX, cursorY);
            }
        }

        @Override
        public void buttonRelease(int buttonNumber, int cursorX, int cursorY) {
            for (MouseListener listener : mouseListeners) {
                listener.buttonRelease(buttonNumber, cursorX, cursorY);
            }
        }

        @Override
        public void wheelScroll(int number, int cursorX, int cursorY) {
            for (MouseWheelListener listener : mouseWheelListeners) {
                listener.wheelScroll(number, cursorX, cursorY);
            }
        }

        @Override
        public void keyPressed(int key) {
            for (KeyListener listener : keyListeners) {
                listener.keyPressed(key);
            }
        }

        @Override
        public void keyReleased(int key) {
            for (KeyListener listener : keyListeners) {
                listener.keyReleased(key);
            }
        }

        @Override
        public void keyTyped(int key) {
            for (KeyListener listener : keyListeners) {
                listener.keyTyped(key);
            }
        }
    }
    public final static int FULL_SCREEN = 0;
    public final static int LEFT_SCREEN = 1;
    public final static int RIGHT_SCREEN = 2;
    public final static int TOP_SCREEN = 3;
    public final static int BOTTOM_SCREEN = 4;
    public final static int TOP_LEFT_SCREEN = 5;
    public final static int TOP_RIGHT_SCREEN = 6;
    public final static int BOTTOM_LEFT_SCREEN = 7;
    public final static int BOTTOM_RIGHT_SCREEN = 8;
    final InputListener inputListener = new InputListener();
    private int screenType = FULL_SCREEN;
    private final Bounds bounds = new Bounds();
    private final Graphics graphics = new Graphics();

    /**
     * Sets the screen type out of a variety of types such as top left or bottom
     * right.
     *
     * Example:
     *          screen.setScreenType(Screen.TOP_RIGHT_SCREEN);
     * 
     * @param type int
     */
    public final void setScreenType(int type) {
        screenType = type;
    }

    /**
     * Returns the width of this Screen.
     * @return width of this Screen.
     */
    public final int getWidth() {
        return bounds.getWidth();
    }

    /**
     * Returns the height of this Screen.
     * @return height of this Screen.
     */
    public final int getHeight() {
        return bounds.getHeight();
    }

    /**
     * Adds the given Blinz MouseListener to the Screen to be updated about
     * the activities of the mouse while the Screen is being displayed.
     * @param listener
     */
    public final void addMouseWheelListener(org.blinz.input.MouseWheelListener listener) {
        inputListener.mouseWheelListeners.add(listener);
    }

    /**
     * Adds the given Blinz MouseWheelListener to the Screen to be updated about
     * the activities of the mouse while the Screen is being displayed.
     * @param listener
     */
    public final void addMouseListener(org.blinz.input.MouseListener listener) {
        inputListener.mouseListeners.add(listener);
    }

    /**
     * Adds the given Blinz KeyListener to the Screen to be updated about
     * activity on the keyboard while the Screen is being displayed.
     * @param listener
     */
    public final void addKeyListener(org.blinz.input.KeyListener listener) {
        inputListener.keyListeners.add(listener);
    }

    /**
     * Adds the given input listener as all applicible types of input listeners
     * to be updated with this Zone.
     *
     * If the given listener is a KeyListener and a MouseListener but not a
     * MouseWheelListener it will be passed to addKeyListener(listener) and
     * addMouseListener(listener).
     *
     * @param listener
     */
    public final void addInputListener(Object listener) {
        if (listener instanceof org.blinz.input.KeyListener) {
            addKeyListener((org.blinz.input.KeyListener) listener);
        }
        if (listener instanceof org.blinz.input.MouseListener) {
            addMouseListener((org.blinz.input.MouseListener) listener);
        }
        if (listener instanceof org.blinz.input.MouseWheelListener) {
            addMouseWheelListener((org.blinz.input.MouseWheelListener) listener);
        }
    }

    /**
     * Removes the given input listener as all applicible types of input listeners
     * from be updated with this Zone.
     *
     * If the given listener is a KeyListener and a MouseListener but not a
     * MouseWheelListener it will be passed to removeKeyListener(listener) and
     * removeMouseListener(listener).
     *
     * @param listener
     */
    public final void removeInputListener(Object listener) {
        if (listener instanceof org.blinz.input.KeyListener) {
            removeKeyListener((org.blinz.input.KeyListener) listener);
        }
        if (listener instanceof org.blinz.input.MouseListener) {
            removeMouseListener((org.blinz.input.MouseListener) listener);
        }
        if (listener instanceof org.blinz.input.MouseWheelListener) {
            removeMouseWheelListener((org.blinz.input.MouseWheelListener) listener);
        }
    }

    /**
     * Removes the specified Blinz MouseListener from this Screen so that
     * it will no longer be updated by this Screen.
     * @param listener
     */
    public final void removeMouseListener(org.blinz.input.MouseListener listener) {
        inputListener.mouseListeners.remove(listener);
    }

    /**
     * Removes the specified Blinz MouseListener from this Screen so that
     * it will no longer be updated by this Screen.
     * @param listener
     */
    public final void removeMouseWheelListener(org.blinz.input.MouseWheelListener listener) {
        inputListener.mouseWheelListeners.remove(listener);
    }

    /**
     * Removes the specified Blinz KeyListener from this Screen so that
     * it will no longer be updated by this Screen.
     * @param listener
     */
    public final void removeKeyListener(org.blinz.input.KeyListener listener) {
        inputListener.keyListeners.remove(listener);
    }

    /**
     * Draw this Screen.
     * @param gl context for this Screen.
     */
    final void draw(GLAutoDrawable gl) {
        computeBounds();
        graphics.setContext(gl);
        graphics.setScreenBounds(bounds);
        graphics.load();
        draw(graphics);
    }

    /**
     * Calculates the bounds of this Screen according to its screen type.
     */
    private final void computeBounds() {
        switch (screenType) {
            case FULL_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getPaneWidth(), ScreenManager.getPaneHeight());
                break;
            case TOP_SCREEN:
                bounds.setBounds(0, ScreenManager.getPaneHeight() / 2,
                        ScreenManager.getPaneWidth(), ScreenManager.getPaneHeight() / 2);
                break;
            case BOTTOM_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getPaneWidth(), ScreenManager.getPaneHeight() / 2);
                break;
            case LEFT_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight());
                break;
            case TOP_LEFT_SCREEN:
                bounds.setBounds(0, ScreenManager.getPaneHeight() / 2,
                        ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight() / 2);
                break;
            case TOP_RIGHT_SCREEN:
                bounds.setBounds(ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight() / 2,
                        ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight() / 2);
                break;
            case BOTTOM_LEFT_SCREEN:
                bounds.setBounds(0, 0, ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight() / 2);
                break;
            case BOTTOM_RIGHT_SCREEN:
                bounds.setBounds(ScreenManager.getPaneWidth() / 2, 0,
                        ScreenManager.getPaneWidth() / 2, ScreenManager.getPaneHeight() / 2);
                break;
        }
    }

    /**
     * Draw the desired screen.
     * @param graphics
     */
    protected abstract void draw(Graphics graphics);
}
