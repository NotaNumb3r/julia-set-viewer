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
package eu.notanumber.juliasetviewer.entities;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class defines a Color range it allows multiples colors in specific
 * positions (0.0 to 1.0) Values 0.0 and 1.0 must be set
 *
 * @author Bruno K
 */
public class ColorRange implements Serializable {

    private Map<Double, Color> colors = new LinkedHashMap<>();  //ordonned map of values and Color
    private String name;                                        //name of ColorRange

    /**
     * ColorRange Constructor
     *
     * @param name String name of ColorRange
     */
    public ColorRange(String name) {
        this.name = name;
    }

    /**
     * Color Range constructor
     *
     * @param colors Map of keys Double and values Color
     * @param name String name of ColorRange
     */
    public ColorRange(Map<Double, Color> colors, String name) {
        this.colors = colors;
        this.name = name;
    }

    /**
     * colors getter
     *
     * @return Map of key-values Double,Color
     */
    public Map<Double, Color> getColors() {
        return colors;
    }

    /**
     * name getter
     *
     * @return String name of ColorRange
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     *
     * @param name String name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void addColor(Double index, Color color) {
        this.colors.put(index, color);
    }

    /**
     * Method used to retrieve a color at a position
     *
     * @param value double value from 0.0 to 1.0
     * @return Color return Color at position value in the ColorRange
     */
    public Color getColorAt(double value) {

        double v1 = 0, v2 = 1;      // 2 double values for further search range
        Color C1 = null, C2 = null; // 2 Colors declaration

        int i = -1;     // starting index        

        Object[] keyArray = colors.keySet().toArray();  // convert Map to array

        boolean founded = false;    // starting boolean condition

        while (i++ < colors.size() - 1 && !founded) {
            /*
            check if a value is between two keys of Map colors
             */
            if (value >= (double) keyArray[i] && value <= (double) keyArray[i + 1]) {
                /*
                value is in the current keys interval
                 */
                founded = true;                 //stop search loop
                v1 = (double) keyArray[i];      //set v1 to first founded key
                v2 = (double) keyArray[i + 1];  //set v2 to second founded key
                C1 = colors.get(v1);            //set C1 to 1st key Color
                C2 = colors.get(v2);            //set C2 to 2nd key Color
            }
        }
        value = (value - v1) / (v2 - v1);       //calculate percent value in the current set of keys
        /*
        calculate linear interpolation between the 2 colors in the set of keys
        */
        double R = (double) (C2.getRed() - C1.getRed()) * value + C1.getRed();
        double G = (double) (C2.getGreen() - C1.getGreen()) * value + C1.getGreen();
        double B = (double) (C2.getBlue() - C1.getBlue()) * value + C1.getBlue();

        return new Color((int) R, (int) G, (int) B);    //create new color
    }

    /**
     * Overrided toString method for display purpose
     *
     * @return String name
     */
    @Override
    public String toString() {
        return this.name;
    }

}
