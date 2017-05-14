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

import eu.notanumber.juliasetviewer.boundaries.ControlPanel;
import eu.notanumber.juliasetviewer.entities.JuliaSet;
import eu.notanumber.juliasetviewer.entities.Complex;
import eu.notanumber.juliasetviewer.tools.Globals;
import eu.notanumber.juliasetviewer.boundaries.JuliaSetGraphicInterface;
import eu.notanumber.juliasetviewer.boundaries.JuliaSetControlInterface;

/**
 * This controller is designed to update bou
 * @author Bruno K
 */
public class JuliaSetController {

    private final JuliaSetGraphicInterface juliaGraphicInterface;
    private final JuliaSetControlInterface controlInterface;
    
    private DrawThread currentThread;

    //private final double zoomStep = 0.1;
    public JuliaSetController(JuliaSetGraphicInterface juliaGraphicInterface, JuliaSetControlInterface controlInterface) {
        this.juliaGraphicInterface = juliaGraphicInterface;
        this.controlInterface = controlInterface;
        //(ControlPanel)controlInterface.

    }

    public void stopDrawThread() {

        if (currentThread != null) {
            currentThread.setOnCalc(false);
        }

    }
    
/**
 * This method starts a new drawing thread. 
 */
    public void startDrawing() {
        if (currentThread != null && currentThread.isAlive()) {
            currentThread.interrupt();  //if the current thread is still alive, kill the task
        }
        currentThread = new DrawThread(juliaGraphicInterface);  // instanciate new thread
        currentThread.start();  //start drawing thread
    }
}
