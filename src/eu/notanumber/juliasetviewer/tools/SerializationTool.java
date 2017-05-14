/*
 * The MIT License
 *
 * Copyright 2017 Bruno K.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.notanumber.juliasetviewer.tools;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class used to serialize and deserialize object
 *
 * @author Bruno K
 */
public class SerializationTool {

    /**
     * Static method to serialize an object in XML file
     *
     * @param obj Object to serialize
     * @param fileName path and file name
     * @throws FileNotFoundException if file is not found
     * @throws IOException if an output operation failed
     */
    public static void serializeToXml(Object obj, String fileName) throws FileNotFoundException, IOException {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(new File(fileName)))) {
            encoder.writeObject(obj);
            encoder.flush();
            encoder.close();
        }
    }

    /**
     * Static method to deserialize an object from XML file
     *
     * @param fileName XML file name
     * @return deserialized object
     * @throws FileNotFoundException if file is not found
     * @throws IOException if an input operation failed
     */
    public static Object deSerializeXml(String fileName) throws FileNotFoundException, IOException {
        Object obj;

        FileInputStream fis = new FileInputStream(fileName);
        try (XMLDecoder decoder = new XMLDecoder(fis)) {
            obj = decoder.readObject();
            decoder.close();
        }
        return obj;
    }
}
