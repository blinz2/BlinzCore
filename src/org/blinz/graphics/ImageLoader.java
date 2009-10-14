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

import java.io.IOException;
import java.util.Vector;

/**
 * 
 * @author Blinz Project
 */
public final class ImageLoader {

    /**
     * Catalog of existing ImageStubs
     */
    private static final Vector<ImageStub> stubs = new Vector<ImageStub>();

    /**
     * Returns an image object associated with the given path.
     * @param path
     * @return Image
     */
    public final static Image loadImage(String path) throws IOException {

        for (ImageStub s : stubs) {
            if (s.getPath().equals(path) && s.type == ImageStub.LOCAL) {
                s.dependentCount++;
                Image image = new Image(s);
                return image;
            }
        }

        ImageStub stub = new ImageStub(path, ImageStub.LOCAL);
        stubs.add(stub);

        Image image = new Image(stub);

        return image;
    }

    /**
     * Returns an image object associated with the given url.
     * @param path
     * @return Image
     */
    public final static Image loadImageHTTP(String url) throws IOException {

        for (ImageStub s : stubs) {
            if (s.getPath().equals(url) && s.type == ImageStub.HTTP) {
                s.dependentCount++;
                Image image = new Image(s);
                return image;
            }
        }

        ImageStub stub = new ImageStub(url, ImageStub.HTTP);
        stubs.add(stub);

        Image image = new Image(stub);

        return image;
    }

    /**
     * Removes Images that are no longer in use.
     */
    static final void clearImages() {
        for (int i = 0; i < stubs.size();) {
            if (stubs.get(i).dependentCount == 0) {
                stubs.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Dumps the image data stored in memory.
     */
    static final void dumpImageData() {
        for (ImageStub stub : stubs) {
            stub.dumpImage();
        }
    }
}
