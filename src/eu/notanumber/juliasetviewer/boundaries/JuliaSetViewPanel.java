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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import eu.notanumber.juliasetviewer.tools.Globals;

/**
 * Julia set JPanel image viewer, implements JuliaSetGraphicInterface
 *
 * @author Bruno K
 */
public class JuliaSetViewPanel extends JPanel implements JuliaSetGraphicInterface {

    // instance of used Buffered Image to draw Julia set
    private final BufferedImage canvas;

    public JuliaSetViewPanel() {
        // Constructor. Create new Buffered image for drawing Julia set
        canvas = new BufferedImage(Globals.getDim().width, Globals.getDim().height, BufferedImage.TYPE_INT_ARGB);
    }

    public BufferedImage getCanvas() {
        return canvas;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    /**
     * Draw a square in the image
     *
     * @param size integer size of the square to draw
     * @param x integer x position of pixel to start drawing square
     * @param y integer y position of pixel to start drawing square
     * @param c Color of the square
     */
    @Override
    public void setPixel(int size, int x, int y, Color c) {
        int color = c.getRGB();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                canvas.setRGB(x + i, y + j, color);
            }
        }

        repaint();
    }

    /**
     * Fill the Buffered Image with a color
     *
     * @param c Color to use
     */
    @Override
    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }
}
