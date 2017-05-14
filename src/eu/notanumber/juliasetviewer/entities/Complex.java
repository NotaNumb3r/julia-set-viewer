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

import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Complex is the complex number base class.
 * <p>
 * A complex number C is defined by a real part and and an imaginary part
 * expressed in the form C = a + i*b a and b are real numbers and i is the
 * imaginary unit, satisfying the equation i² = -1
 *
 */
public class Complex implements Serializable {

    private double a;
    private double b;

    /**
     * Complex class empty constructor
     */
    public Complex() {
    }

    /**
     * Complex class constructor
     *
     * @param a real part of C Complex
     * @param b imaginary part of C Complex
     */
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Complex class constructor
     *
     * @param coords Point2D.Double initialize the complex with X and Y double
     * values from Point2D
     */
    public Complex(Point2D.Double coords) {
        this.a = coords.getX();
        this.b = coords.getY();
    }

    /**
     * Complex real part getter
     *
     * @return double real part of Complex
     */
    public double getA() {
        return a;
    }

    /**
     * Complex imaginary part getter
     *
     * @return double imaginary part of Complex
     */
    public double getB() {
        return b;
    }

    /**
     * Complex real part setter
     *
     * @param a double real part of Complex
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Complex imaginary part setter
     *
     * @param b double imaginary part of Complex
     */
    public void setB(double b) {
        this.b = b;
    }
}
