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

import java.util.Vector;
import javax.media.opengl.GLAutoDrawable;
import net.blinz.core.util.Bounds;
import net.blinz.core.input.KeyListener;
import net.blinz.core.input.MouseListener;
import net.blinz.core.input.MouseWheelListener;

/**
 * Canvas class is necessary to draw to the Display. Canvas class allows dividing
 * the display into section such as top right or bottom left.
 * @author Blinz Project
 */
public abstract class Canvas {

    /**
     * Used to gather input for input clients of this Canvas
     */
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
    final InputListener inputListener = new InputListener();
    private final Bounds bounds = new Bounds();
    private final Graphics graphics = new Graphics();

    /**
     * Gets the width of this Canvas.
     * @return width of this Canvas.
     */
    public final int getWidth() {
        return bounds.getWidth();
    }

    /**
     * Gets the height of this Canvas.
     * @return height of this Canvas.
     */
    public final int getHeight() {
        return bounds.getHeight();
    }

    /**
     * Adds the given Blinz MouseListener to the Canvas to be updated about
     * the activities of the mouse while the Canvas is being displayed.
     * @param listener the MouseWheelListener to be added
     */
    public final void addMouseWheelListener(final net.blinz.core.input.MouseWheelListener listener) {
        inputListener.mouseWheelListeners.add(listener);
    }

    /**
     * Adds the given Blinz MouseWheelListener to the Canvas to be updated about
     * the activities of the mouse while the Canvas is being displayed.
     * @param listener the MouseListener to be added
     */
    public final void addMouseListener(final net.blinz.core.input.MouseListener listener) {
        inputListener.mouseListeners.add(listener);
    }

    /**
     * Adds the given Blinz KeyListener to the Canvas to be updated about
     * activity on the keyboard while the Canvas is being displayed.
     * @param listener the KeyListener to be added
     */
    public final void addKeyListener(final net.blinz.core.input.KeyListener listener) {
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
    public final void addInputListener(final Object listener) {
        if (listener instanceof net.blinz.core.input.KeyListener) {
            addKeyListener((net.blinz.core.input.KeyListener) listener);
        }
        if (listener instanceof net.blinz.core.input.MouseListener) {
            addMouseListener((net.blinz.core.input.MouseListener) listener);
        }
        if (listener instanceof net.blinz.core.input.MouseWheelListener) {
            addMouseWheelListener((net.blinz.core.input.MouseWheelListener) listener);
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
    public final void removeInputListener(final Object listener) {
        if (listener instanceof net.blinz.core.input.KeyListener) {
            removeKeyListener((net.blinz.core.input.KeyListener) listener);
        }
        if (listener instanceof net.blinz.core.input.MouseListener) {
            removeMouseListener((net.blinz.core.input.MouseListener) listener);
        }
        if (listener instanceof net.blinz.core.input.MouseWheelListener) {
            removeMouseWheelListener((net.blinz.core.input.MouseWheelListener) listener);
        }
    }

    /**
     * Removes the specified Blinz MouseListener from this Canvas so that
     * it will no longer be updated by this Canvas.
     * @param listener the MouseListener to be removed
     */
    public final void removeMouseListener(final net.blinz.core.input.MouseListener listener) {
        inputListener.mouseListeners.remove(listener);
    }

    /**
     * Removes the specified Blinz MouseListener from this Canvas so that
     * it will no longer be updated by this Canvas.
     * @param listener the MouseWheelListener to be removed
     */
    public final void removeMouseWheelListener(final net.blinz.core.input.MouseWheelListener listener) {
        inputListener.mouseWheelListeners.remove(listener);
    }

    /**
     * Removes the specified Blinz KeyListener from this Canvas so that
     * it will no longer be updated by this Canvas.
     * @param listener the KeyListener to be added
     */
    public final void removeKeyListener(final net.blinz.core.input.KeyListener listener) {
        inputListener.keyListeners.remove(listener);
    }

    /**
     * Sets the size of this Canvas.
     * @param width the new width of this Canvas
     * @param height the new height of this Canvas
     */
    public final void setSize(final int width, final int height) {
        bounds.setSize(width, height);
        graphics.setContextBounds(bounds);
    }

    /**
     * Sets the width of this Canvas.
     * @param width the new width of this Canvas
     */
    public final void setWidth(final int width) {
        bounds.setWidth(width);
        graphics.setContextBounds(bounds);
    }

    /**
     * Sets the height of this Canvas.
     * @param height the new height of this Canvas
     */
    public final void setHeight(final int height) {
        bounds.setHeight(height);
        graphics.setContextBounds(bounds);
    }

    /**
     * Draw this Canvas.
     * @param gl context for this Canvas.
     */
    final void draw(final GLAutoDrawable gl) {
        graphics.setContext(gl);
        graphics.setContextBounds(bounds);
        graphics.load();
        draw(graphics);
    }

    /**
     * Draw the desired screen.
     * @param graphics
     */
    protected abstract void draw(final Graphics graphics);
}
