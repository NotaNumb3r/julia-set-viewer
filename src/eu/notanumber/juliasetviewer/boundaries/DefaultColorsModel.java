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

import javax.swing.DefaultComboBoxModel;
import eu.notanumber.juliasetviewer.tools.Globals;

/**
 * ComboxBox Model For Swing ComboBox, it uses the static ColorRange list for
 * data model
 * @see eu.notanumber.juliasetviewer.entities.ColorRange
 *
 * @author Bruno K
 */
public class DefaultColorsModel extends DefaultComboBoxModel {

    private Object selectedItem;

    public DefaultColorsModel() {
        selectedItem = Globals.colors.get(0);
    }

    @Override
    public int getIndexOf(Object anObject) {
        return Globals.colors.indexOf(anObject);
    }

    @Override
    public Object getElementAt(int index) {
        return Globals.colors.get(index);
    }

    @Override
    public int getSize() {
        return Globals.colors.size();
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object anObject) {
        selectedItem = anObject;
    }

}
