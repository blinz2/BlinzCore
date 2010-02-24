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

import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import java.util.ArrayList;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import org.blinz.util.Position;
import org.blinz.util.Bounds;
import org.blinz.util.Size;

/**
 * Graphics class contains methods for drawing to the screen.
 * @author Blinz Project
 */
public class Graphics {

    private final static ArrayList<Viewport> excessViewports = new ArrayList<Viewport>();
    private boolean viewPortOn = false;
    private Viewport viewport;
    private final Bounds screenBounds = new Bounds();
    private final Color color = new Color();
    private Font font;
    private GL gl;

    Graphics() {
    }

    //PUBLIC METHODS------------------------------------------------------------
    /**
     * Moves the point of origin for drawing over the specified amount.
     * @param x
     * @param y
     */
    public final void translate(int x, int y) {
        gl.glTranslated(x, y, 0);
    }

    /**
     * Draws the rectangle with point (x1, y1) representing the top left corner,
     * and point (x2, y2) representing the bottom right corner.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public final void fillRect(int x1, int y1, int x2, int y2) {
        gl.glRecti(x1 - 1, y1 - 1, x2 + 1, y2 + 1);
    }

    /**
     * Draws the outline of the given Polygon with the first point in the Polygon
     * as the point of origin.
     * @param polygon
     */
    public final void fillPolygon(Polygon polygon) {
        gl.glBegin(GL.GL_POLYGON);
        {
            for (int i = 0; i < polygon.size(); i++) {
                gl.glVertex2i(polygon.get(i).x, polygon.get(i).y);
            }
        }
        gl.glEnd();
    }

    /**
     * Draws a line from point (x1, y1) to point (x2, y2).
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public final void drawLine(int x1, int y1, int x2, int y2) {
        gl.glBegin(GL.GL_LINES);
        {
            gl.glVertex2i(x1, y1);
            gl.glVertex2i(x2, y2);
        }
        gl.glEnd();
    }

    /**
     * Draws a line from loc1 to loc2.
     * @param loc1 - a Position object representing the starting point of the line
     * @param loc2 - a Position object representing the end of the line
     */
    public final void drawLine(Position loc1, Position loc2) {
        drawLine(loc1.x, loc1.y, loc2.x, loc2.y);
    }

    /**
     * Draws the outline of a rectangle with point (x1, y1) representing the top
     * left corner, and point (x2, y2) representing the bottom right corner.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public final void drawRect(int x1, int y1, int x2, int y2) {
        gl.glBegin(GL.GL_LINE_STRIP);
        {
            gl.glVertex2i(x1, y1);
            gl.glVertex2i(x2, y1);
            gl.glVertex2i(x2, y2);
            gl.glVertex2i(x1, y2);
            gl.glVertex2i(x1, y1);
        }
        gl.glEnd();

    }

    /**
     * Draws the outline of the given Polygon with the first point in the Polygon
     * as the point of origin.
     * @param polygon
     */
    public final void drawPolygon(Polygon polygon) {
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int i = 0; i < polygon.size(); i++) {
            gl.glVertex2i(polygon.get(i).x, polygon.get(i).y);
        }
        gl.glEnd();
    }

    /**
     * Sets the drawing color to the color represented by the passed Color object.
     * @param color
     */
    public final void setColor(Color color) {
        setColor(color.red, color.green, color.blue);
    }

    /**
     * Sets the drawing color to the mix of the provided RGB values.
     * @param red
     * @param green
     * @param blue
     */
    public final void setColor(int red, int green, int blue) {
        color.setColor(red, green, blue);
        gl.glColor3b(color.red, color.green, color.blue);
    }

    /**
     * Draws the current Image of the given Animation on the screen at the 
     * given coordinates.
     *
     * Note: x1 and y1 refer to the top left corner of the image, and x2 and y2
     * refer to the bottom right.
     * @param animation
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public final void drawAnimation(Animation animation, int x1, int y1, int x2, int y2) {
        drawImage(animation.getImage(), x1, y1, x2, y2);
    }

    /**
     * Draws the current Image of the given Animation on the screen at the
     * given coordinates.
     *
     * Note: loc1 refers to the top left corner of the image and loc2
     * refers to the bottom right.
     * @param animation
     * @param loc1
     * @param loc2
     */
    public final void drawAnimation(Animation animation, Position loc1, Position loc2) {
        drawImage(animation.getImage(), loc1.x, loc1.y, loc2.x, loc2.y);
    }

    /**
     * Draws the given Image on the screen at the given coordinates.
     *
     * Note: loc1 refers to the top left corner of the image and loc2
     * refers to the bottom right.
     * @param image
     * @param loc1
     * @param loc2
     */
    public final void drawImage(Image image, Position loc1, Position loc2) {
        drawImage(image, loc1.x, loc1.y, loc2.x, loc2.y);
    }

    /**
     * Draws the given Image on the screen at the given coordinates.
     *
     * Note: x1 and y1 refer to the top left corner of the image, and x2 and y2
     * refer to the bottom right.
     * @param image
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public final void drawImage(Image image, int x1, int y1, int x2, int y2) {
        Texture texture = image.getImageStub().getTexture();
        TextureCoords t = texture.getImageTexCoords();
        gl.glPushMatrix();
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        gl.glEnable(GL.GL_ALPHA_TEST);
        gl.glAlphaFunc(GL.GL_GREATER, 0);

        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glTexEnvf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
        gl.glColor3d(1, 1, 1);
        texture.bind();

        gl.glBegin(GL.GL_QUADS);
        {
            //Top Left
            gl.glTexCoord2f(t.left(), t.top());
            gl.glVertex3i(x1, y1, 0);
            //Top Right
            gl.glTexCoord2f(t.right(), t.top());
            gl.glVertex3i(x2, y1, 0);
            //Bottom Right
            gl.glTexCoord2f(t.right(), t.bottom());
            gl.glVertex3i(x2, y2, 0);
            //Bottom Left
            gl.glTexCoord2f(t.left(), t.bottom());
            gl.glVertex3i(x1, y2, 0);
        }
        gl.glEnd();

        gl.glDisable(GL.GL_TEXTURE_2D);
        gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);

        gl.glDisable(GL.GL_ALPHA);
        gl.glDisable(GL.GL_BLEND);


        gl.glPopMatrix();

        gl.glColor3d(color.red, color.green, color.blue);
    }

    /**
     * Draws a rectangle, with loc representing the top left corner of the
     * rectangle.
     * @param loc - Position object representing the top left corner of the rectangle
     * @param size - Size object specifying how far to the right and down the rectangle will extend
     */
    public final void fillRect(Position loc, Size size) {
        fillRect(loc.x, loc.y, size.width, size.height);
    }

    /**
     * Fills a rectangle, with loc representing the top left corner of the
     * rectangle.
     * @param loc - Position object representing the top left corner of the rectangle
     * @param size - Size object specifying how far to the right and down the rectangle will extend
     */
    public final void drawRect(Position loc, Size size) {
        drawRect(loc.x, loc.y, size.width, size.height);
    }

    /**
     * Draws the specified String with the specified font with the the bottom
     * left corner as the point of origin.
     * @param string
     * @param x
     * @param y
     * @param font
     */
    public final void drawString(String string, int x, int y, Font font) {
        TextRenderer r = font.stub.getRenderer();
        r.setColor(color.getRedf(), color.getGreenf(), color.getBluef(), 1f);
        if (viewPortOn) {
            y = viewport.getHeight() - y;
            r.beginRendering(viewport.getWidth(), viewport.getHeight());
        } else {
            y = screenBounds.getHeight() - y;
            r.beginRendering(screenBounds.getWidth(), screenBounds.getHeight());
        }
        r.draw(string, x, y);
        r.endRendering();
    }

    /**
     * Draws the specified String with the specified font with the the bottom
     * left corner as the point of origin.
     * @param string - String to be drawn
     * @param loc - Position object with the coordinates string will be drawn at
     * @param font - Font the String will be drawn with
     */
    public final void drawString(String string, Position loc, Font font) {
        drawString(string, loc.x, loc.y, font);
    }

    /**
     * Draws the specified String with the specified font with the the bottom
     * left corner as the point of origin.
     * @param string - String to be drawn
     * @param x - x location that string will be drawn at
     * @param y - y location that string will be drawn at
     */
    public final void drawString(String string, int x, int y) {
        drawString(string, x, y, font);
    }

    /**
     * Draws the specified String with the specified font with the the bottom
     * left corner as the point of origin.
     * @param string - String to be drawn
     * @param loc - Position object with the coordinates string will be drawn at
     */
    public final void drawString(String string, Position loc) {
        drawString(string, loc.x, loc.y, font);
    }

    /**
     * Returns the width of the given char.
     * Note: this number is rounded from a floating point number.
     * @param character
     * @return int - width of the given char
     */
    public final int getCharWidth(char character) {
        return Math.round(font.getCharWidth(character));
    }

    /**
     * Sets the Font to be used when drawing text.
     * @param font
     */
    public final void setFont(Font font) {
        this.font = font;
    }

    /**
     * Gets the width of the Screen and/or viewport in which this currently draws.
     * @return drawing area width
     */
    public final int getPaneWidth() {
        if (viewport != null) {
            return viewport.getWidth();
        }
        return screenBounds.getWidth();
    }

    /**
     * Gets the height of the Screen and/or viewport in which this currently draws.
     * @return drawing area height
     */
    public final int getPaneHeight() {
        if (viewport != null) {
            return viewport.getHeight();
        }
        return screenBounds.getHeight();
    }

    /**
     * Sets the bounds within the current screen which things will be drawn,
     * outside of it everything will be cut off.
     *
     * IMPORTANT: Nesting viewports is not currently supported but may be in the
     * future, please exit the viewport when you're done.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public final void enterViewport(int x, int y, int width, int height) {
        Viewport v = viewport;
        viewport = fetchViewport();
        if (v == null) {
            viewport.parent = screenBounds;
        } else {
            viewport.parent = v;
        }
        viewport.setViewport(x, y, width, height);
        viewport.fixViewport();
        gl.glViewport(viewport.getX(), viewport.getY(),
                viewport.getWidth(), viewport.getHeight());
        gl.glLoadIdentity();
        gl.glOrtho(0.0f, viewport.getWidth(), viewport.getHeight(),
                0.0f, -1.0f, 1.0f);
        gl.glTranslated(viewport.getXTranslation(), viewport.getYTranslation(), 0);
        viewPortOn = true;
    }

    /**
     * Leaves the viewport and returns the scope to the whole screen.
     */
    public final void exitViewport() {
        excessViewports.add(viewport);
        if (viewport.parent instanceof Viewport) {
            viewport = (Viewport) viewport.parent;
        } else {
            viewport = null;
            viewPortOn = false;
        }
        load();
    }

    /**
     * Sets the bounds of the Screen this Graphics object belongs to and draws for.
     * @param bounds
     */
    final void setScreenBounds(Bounds bounds) {
        screenBounds.setBounds(bounds);
    }

    /**
     * Sets the GL context to be used for drawing.
     * @param drawable
     */
    final void setContext(GLAutoDrawable drawable) {
        gl = drawable.getGL();
    }

    /**
     * Loads this Graphics objects settings to the OpenGL context.
     */
    final void load() {
        gl.glLoadIdentity();
        if (viewPortOn) {
            viewport.fixViewport();

            gl.glViewport(viewport.getX(), viewport.getY(),
                    viewport.getWidth(), viewport.getHeight());
            gl.glOrtho(0.0f, viewport.getWidth(), viewport.getHeight(),
                    0.0f, -1.0f, 1.0f);
        } else {
            gl.glViewport(screenBounds.getX(), screenBounds.getY(),
                    screenBounds.getWidth(), screenBounds.getHeight());
            gl.glOrtho(0.0f, screenBounds.getWidth(), screenBounds.getHeight(), 0.0f,
                    -1.0f, 1.0f);
        }
        gl.glColor3b(color.red, color.green, color.blue);
    }

    /**
     * Cleans out excess data being used, reduces memory use.
     */
    final void clean() {
        excessViewports.trimToSize();
        excessViewports.clear();
    }

    /**
     *
     * @return a Viewport object, reuses old Position objects when possible
     */
    private final Viewport fetchViewport() {
        if (excessViewports.isEmpty()) {
            return new Viewport();
        } else {
            return excessViewports.remove(0);
        }
    }
}
