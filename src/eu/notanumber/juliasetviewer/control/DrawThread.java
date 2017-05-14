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
package eu.notanumber.juliasetviewer.control;

import java.awt.Color;
import eu.notanumber.juliasetviewer.boundaries.JuliaSetGraphicInterface;
import eu.notanumber.juliasetviewer.entities.ColorRange;
import eu.notanumber.juliasetviewer.entities.Complex;
import eu.notanumber.juliasetviewer.entities.JuliaSet;
import eu.notanumber.juliasetviewer.entities.MathComplex;
import eu.notanumber.juliasetviewer.tools.Globals;

/**
 * DrawThread Class
 * <p>
 * draw fractal julia set, for more informations about the calculus behind this
 * kind of fractals, see Julia Set on wikipedia
 *
 * @author Bruno K
 */
public class DrawThread extends Thread {

    private final JuliaSetGraphicInterface graphicInterface;    // reference to the graphic interface

    protected volatile boolean onCalc = true;                   // volatile control value for interrupting current draw thread

    /**
     * DrawThread constructor
     *
     * @param graphicInterface graphic interface to be referenced
     */
    public DrawThread(JuliaSetGraphicInterface graphicInterface) {
        this.graphicInterface = graphicInterface;

    }

    /**
     * thread control boolean getter
     *
     * @return boolean value
     */
    public boolean isOnCalc() {
        return onCalc;
    }

    /**
     * thread control boolean value setter
     *
     * @param onCalc boolean value to be set
     */
    public void setOnCalc(boolean onCalc) {
        this.onCalc = onCalc;
    }

    /**
     * Output curve correction, slightly modify the color result
     *
     * @param input double value to correct
     * @return double value corrected
     */
    private double outputCurve(double input) {
        double output = input;
        switch (Globals.getjSet().getOutputCurve()) {
            case Globals.CURVENONE:
                break;
            case Globals.CURVESINUS:
                output = Math.sin(input * Math.PI / 2);
                break;
            case Globals.CURVECOSINUS:
                output = 1 - Math.cos(input * Math.PI / 2);
                break;
            default:
                break;
        }
        return output;
    }

    /**
     * Log 2 function, calculate Log(x)/Log(2)
     *
     * @param x double value to calculate
     * @return result value
     */
    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /**
     * Escape time calculus
     * <p>
     * Uses the iterative complex function Z(n+1) = Z(n)² + C, computes the
     * number of iterations needed for the function to converge to infinity
     *
     * @param x real part start value of Z complex number
     * @param y imaginary part start value of Z complex number
     * @return double the number of iterations needed for the function to
     * converge to infinity
     */
    private double escapeCalc(double x, double y) {
        Complex C = Globals.getjSet().getC();      // get instance of the current julia set
        Complex Z = new Complex(x, y);              // create Complex number

        /*
        Compute function Z(n+1) = Z(n)² + C
        till Z is not converging to infinity and the maximum number of iterations is not reached
         */
        int i = 0;
        while (i++ < Globals.getjSet().getIteration() && MathComplex.modulus(Z) < 2) {

            Z = MathComplex.add(MathComplex.square(Z), C);      // function Z(n+1) = Z(n)² + C
        }
        // convert escape time discreet value in real value
        double r = i - log2(log2(MathComplex.modulus(Z)));

        return r;
    }

    private double correctResult(double result) {
        int iter = Globals.getjSet().getIteration();
        if (Double.isFinite(result)) {
            if (result > iter) {
                result = iter;

            }
            result /= iter;     //to get a value between 0.0 and 1.0
            if (result < 0) {
                result = Math.abs(result);
            }
        } else {
            result = 1;
        }
        return result;
    }

    /**
     * DrawThread run method, it uses a progressive resolution drawing algorithm
     *
     */
    @Override
    public void run() {

        int width = Globals.getDim().width;             //x screen size
        int height = Globals.getDim().height;           //y screen size

        int pixelSize = Globals.STARTPIXELSIZE; //size of starting pixel size       

        JuliaSet currentSet = Globals.getjSet();    //get reference of current Julia set
        ColorRange range = Globals.colors.get(currentSet.getColorRange());  //get ColorRange

        double zoomLimit = 1.5 / Math.pow(10, (double)currentSet.getZoom() / 10);   // compute the real zoom value

        /*
        First drawing pass, draws every pixels of maximum size
         */
        double realX;
        double realY;
        double result;

        for (int i = 0; i < width && onCalc; i += pixelSize) {
            for (int j = 0; j < height && onCalc; j += pixelSize) {
                realX = 2 * zoomLimit * i / (width - 1) - zoomLimit + currentSet.getOffsetX();
                realY = 2 * zoomLimit * j / (height - 1) - zoomLimit + currentSet.getOffsetY();
                result = escapeCalc(realX, realY);
                result = correctResult(result);
                Color color = range.getColorAt(outputCurve(result));    //calculate color output, add curve correction 
                graphicInterface.setPixel(pixelSize, i, j, color);      //draw the current pixel with calculated color
            }
        }
        /*
        second drawing pass, draws only needed pixels
        */
        pixelSize /= 2;
        while (onCalc && pixelSize >= 1) {
            // x calculus loop
            for (int i = 0; i < width && onCalc; i += pixelSize) {
                // y calculus loop
                for (int j = 0; j < height && onCalc; j += pixelSize) {
                    if (i % (2 * pixelSize) != 0 || j % (2 * pixelSize) != 0) {
                        // calculate real X based on x screen coordinates, zoom factor and offset
                        realX = 2 * zoomLimit * i / (width - 1) - zoomLimit + currentSet.getOffsetX();
                        // calculate real Y based on y screen coordinates, zoom factor and offset
                        realY = 2 * zoomLimit * j / (height - 1) - zoomLimit + currentSet.getOffsetY();
                        result = escapeCalc(realX, realY);   //call escapeCalc method to calculate escape time
                        result = correctResult(result);
                        Color color = range.getColorAt(outputCurve(result));    //calculate color output, add curve correction 
                        graphicInterface.setPixel(pixelSize, i, j, color);      //draw the current pixel with calculated color
                    }
                }
            }
            pixelSize /= 2; //reduce the pixel size by 2
        }
    }
}
