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
    public final Size getSize() {
        return new Size(stub.getWidth(), stub.getHeight());
    }

    /**
     * Gets the width of the image loaded.
     * @return the width of the image loaded
     */
    public final int getWidth() {
        return stub.getWidth();
    }

    /**
     * Gets the height of the image loaded.
     * @return the height of the image loaded
     */
    public final int getHeight() {
        return stub.getHeight();
    }

    /**
     * Gets the path to this Image in storage.
     * @return path to this Images location in storage.
     */
    public final String getPath() {
        return stub.getPath();
    }

    /**
     * Dumps the image data associated with this Image object, making this object
     * useless.
     */
    public final void dumpImage() {
        stub.decrementDependents();
        stub = null;
    }

    /**
     * Indicates whether or not the image data associated with this image has been
     * dumped.
     * @return true if the image data has been dumped, false otherwise
     */
    public final boolean imageDumped() {
        return stub == null;
    }

    @Override
    protected void finalize() throws Throwable {
        if (stub != null) {
            stub.decrementDependents();
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
