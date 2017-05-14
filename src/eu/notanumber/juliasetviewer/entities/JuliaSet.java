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

import java.io.Serializable;

/**
 * JuliaSet entity class.
 *
 * @author Bruno K
 */
public class JuliaSet implements Serializable {

    private Complex C;              // complex number used by Julia set
    private int iteration;          // number of iterations
    private int zoom;               // zoom factor
    private double offsetX;         // x offset value
    private double offsetY;         // y offset value
    private int colorRangeIndex;    // index of color range list
    private int outputCurve;        // output curve type

    public JuliaSet() {
    }

    /**
     * JuliaSet Class constructor
     * <p>
     * It defines a Complex number C used in the recursive complex formula
     * Z(n+1) = Z(n)² + C This class contains also display parameters.
     *
     * @param C Complex
     * @param iteration integer number of maximal iterations
     * @param zoom int zoom factor
     * @param offsetX double X offset
     * @param offsetY double Y offset
     * @param colorRangeIndex integer index of static ColorRange list, defined
     * in Globals class
     */
    public JuliaSet(Complex C, int iteration, int zoom, double offsetX, double offsetY, int colorRangeIndex) {
        this.C = C;
        this.iteration = iteration;
        this.zoom = zoom;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.colorRangeIndex = colorRangeIndex;
    }

    /**
     * Complex number C getter
     *
     * @return Complex C from Julia set
     */
    public Complex getC() {
        return C;
    }

    /**
     * Complex number C setter
     *
     * @param C Complex to be set
     */
    public void setC(Complex C) {
        this.C = C;
    }

    /**
     * iteration max getter
     *
     * @return integer number maximum of iterations
     */
    public int getIteration() {
        return iteration;
    }

    /**
     * iteration max setter
     *
     * @param iteration to be set
     */
    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public int getOutputCurve() {
        return outputCurve;
    }

    public void setOutputCurve(int outputCurve) {
        this.outputCurve = outputCurve;
    }

    public int getColorRange() {
        return colorRangeIndex;
    }

    public void setColorRange(int colorRangeIndex) {
        this.colorRangeIndex = colorRangeIndex;
    }

}
