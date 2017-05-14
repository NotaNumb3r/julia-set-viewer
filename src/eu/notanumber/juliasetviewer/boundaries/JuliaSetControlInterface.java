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
package eu.notanumber.juliasetviewer.boundaries;

/**
 * this interface is designed:
 * <p>
 * to update boundaries according to the Julia set entity
 * <p>
 * to update Julia Set from the boudaries changed values implemented by the
 * control panel class
 *
 * @author Bruno K
 */
public interface JuliaSetControlInterface {

    public void updateJuliaSetBoundary();

    public void setIterations(int value);

    public void setA(double a);

    public void setB(double b);

    public void setZoom(int zoom);

    public void setOffsetX(double offsetX);

    public void setOffsetY(double offsetY);

    public void setCurveOutput(int curveIndex);

    public void setColorRange(int colorIndex);
}
