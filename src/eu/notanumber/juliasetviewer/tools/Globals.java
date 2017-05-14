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

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import eu.notanumber.juliasetviewer.entities.ColorRange;
import eu.notanumber.juliasetviewer.entities.JuliaSet;

/**
 * Class of static values used in Julia set
 *
 * @author Bruno K
 */
public class Globals {

    // output curve constants
    public static final int CURVENONE = 10;
    public static final int CURVESINUS = 11;
    public static final int CURVECOSINUS = 12;
    
    public static final int STARTPIXELSIZE = 32; // size of initial pixel in progressive algorithm

    /*
    gray color ramp declaration
     */
    private static final ColorRange grayRamp = new ColorRange(new LinkedHashMap<Double, Color>() {
        {
            put(0.0, Color.BLACK);
            put(0.2, new Color(0x909090));
            put(0.7, new Color(0xcccccc));
            put(1.0, Color.WHITE);
        }
    }, "gray color ramp");
    /*
    gray color ramp declaration
     */
    private static final ColorRange warmRamp = new ColorRange(new LinkedHashMap<Double, Color>() {
        {
            put(0.0, Color.BLACK);
            put(0.1, new Color(0xe24900));
            put(0.4, new Color(0xffcc25));            
            put(0.9, new Color(0xffa625));
            put(1.0, new Color(0xffca7c));
        }
    }, "warm color ramp 1");
    /*
    warm color ramp declaration
     */
    private static final ColorRange warmRamp2 = new ColorRange(new LinkedHashMap<Double, Color>() {
        {
            put(0.0, Color.BLACK);
            put(0.1, new Color(0x5f0279));
            put(0.4, new Color(0xff2300));
            put(0.7, new Color(0xffb300));
            put(1.0, Color.WHITE);
        }
    }, "warm color ramp 2");
    /*
    warm color ramp declaration
     */
    private static final ColorRange coolRamp = new ColorRange(new LinkedHashMap<Double, Color>() {
        {
            put(0.0, Color.BLACK);
            put(0.1, new Color(0x2828d6));
            put(0.4, new Color(0x00bb6b));
            put(0.7, new Color(0xff970b));            
            put(0.8, new Color(0xffbf68));
            put(1.0, Color.WHITE);
        }
    }, "cool color ramp");
    /*
    cold color ramp declaration
     */
    private static final ColorRange coldRamp = new ColorRange(new LinkedHashMap<Double, Color>() {
        {
            put(0.0, Color.BLACK);
            put(0.1, new Color(0x220b8d));
            put(0.4, new Color(0x1c5fd1));
            put(0.8, new Color(0x09ccb1));
            put(1.0, Color.WHITE);
        }
    }, "cold color ramp");
    
    /*
    static ColorRange list declaration
     */
    public static List<ColorRange> colors = new ArrayList<>(Arrays.asList(
            grayRamp,
            warmRamp,
            warmRamp2,
            coolRamp,
            coldRamp
    ));

    private static JuliaSet jSet;       // current Julia Set    
    private static Dimension dim;       // Julia set viewer dimensions

    /**
     * Drawing canvas size getter
     *
     * @return Dimension x and y drawing canvas size
     */
    public static Dimension getDim() {
        return dim;
    }

    /**
     * Drawing canvas size setter
     *
     * @param dim Dimension
     */
    public static void setDim(Dimension dim) {
        Globals.dim = dim;
    }

    /**
     * Current JuliaSet getter
     *
     * @return JuliaSet
     */
    public static JuliaSet getjSet() {
        return jSet;
    }

    /**
     * Current JuliaSet setter
     *
     * @param jSet JuliaSet
     */
    public static void setjSet(JuliaSet jSet) {
        Globals.jSet = jSet;
    }

}
