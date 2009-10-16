
package org.blinz.input;

/**
 *
 * @author Blinz Project
 */
public interface MouseWheelListener {

    /**
     * Called when the mouse wheel is scrolled.
     * @param number amount of clicks the mouse was scrolled, a negative number
     * denotes an upwards scroll while a positive denotes a downwards scroll
     */
    public void wheelScroll(int number);
}
