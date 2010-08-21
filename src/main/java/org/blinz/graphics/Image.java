/*
 *  BlinzCore - core library of audio, video, and other essential classes.
 *  Copyright (C) 2009-2010  BlinzProject <gtalent2@gmail.com>
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

import org.blinz.util.Size;

/**
 * Image class, instances represent images stored in file. To create an Image use
 * ImageLoader.
 * @author Blinz Project
 */
public final class Image {

    /**
     * stub is a shared object among any Image object that point to the same file.
     * It contains all the actual information about the image.
     */
    private ImageStub stub;

    /**
     * Constructor for instances of Image.
     * @param stub takes the ImageStub and represents it.
     */
    Image (final ImageStub stub) {
        this.stub = stub;
    }

    /**
     * Gets a new Size object representing the size of the image in the file
     * this was loaded from.
     * @return a new Size object representing the size of this Image
     */
    public Size getSize() {
        return new Size(stub.getWidth(), stub.getHeight());
    }

    /**
     * Gets the width of the image loaded.
     * @return the width of the image loaded
     */
    public int getWidth() {
        return stub.getWidth();
    }

    /**
     * Gets the height of the image loaded.
     * @return the height of the image loaded
     */
    public int getHeight() {
        return stub.getHeight();
    }

    /**
     * Gets the path to this Image in storage.
     * @return path to this Images location in storage.
     */
    public String getPath() {
        return stub.getPath();
    }

    @Override
    protected void finalize() throws Throwable {
        if (stub != null) {
            stub.dependentCount--;
        }
        super.finalize();
    }

    /**
     * Gets the ImageStub that contains necessary objects to draw the image.
     * @return the ImageStub that this Image represents.
     */
    final ImageStub getImageStub() {
        return stub;
    }
}
