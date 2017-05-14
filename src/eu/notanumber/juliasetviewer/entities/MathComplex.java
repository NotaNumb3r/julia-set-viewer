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

/**
 * Complex numbers mathematic class
 * holds static methods add, multiply and modulus
 * 
 * @author Bruno K
 */
public class MathComplex {

    public static Complex add(Complex za, Complex zb) {
        return new Complex(za.getA() + zb.getA(), za.getB() + zb.getB());
    }

    public static Complex add(Complex z, double d) {
        return new Complex(z.getA() + d, z.getB());
    }

    public static Complex mult(Complex z, double value) {
        return new Complex(z.getA() * value, z.getB() * value);
    }

    public static Complex mult(Complex za, Complex zb) {
        double fa = za.getA() * zb.getA() - za.getB() * zb.getB();
        double fb = za.getA() * zb.getB() + za.getB() * zb.getA();
        return new Complex(fa, fb);
    }

    public static Complex square(Complex z) {
        double fa = z.getA() * z.getA() - z.getB() * z.getB();
        double fb = 2 * z.getA() * z.getB();
        return new Complex(fa, fb);
    }

    public static double modulus(Complex z) {
        return Math.sqrt(z.getA() * z.getA() + z.getB() * z.getB());
    }
}
