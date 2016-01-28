/*
 * Copyright (c) 2015, Tony Beckett
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * The names of its contributors may not be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.jaba.titaniumblocks.swing.panels.rectangular;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.displays.rectangular.SingleDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleLineDoubleLinearPanel extends JComponent
{

    private final Rectangle DEFAULT_SIZE = new Rectangle(0, 0, 128, 48);
    private Rectangle currentSize = DEFAULT_SIZE;

    private final transient ComponentListener componentListener = new ComponentAdapter()
    {

        @Override
        public void componentResized(ComponentEvent event)
        {
            java.awt.Container parent = getParent();

            if (getWidth() < getMinimumSize().width && getHeight() < getMinimumSize().height)
            {
                if (parent != null && getParent().getLayout() == null)
                {
                    setSize(getMinimumSize());
                } else
                {
                    setPreferredSize(getMinimumSize());
                }
            }

            if (parent != null && getParent().getLayout() == null)
            {
                setSize(getWidth(), getHeight());
            } else
            {
                setPreferredSize(new Dimension(getWidth(), getHeight()));
            }

            init(getInnerBounds().width, getInnerBounds().height);
          
        }

    };
    private final SingleDisplay singleGauge;

    public SingleLineDoubleLinearPanel()
    {
        singleGauge = new SingleDisplay();
    }

    public SingleDisplay getGauge()
    {
        return singleGauge;
    }

    public void init(int width, int height)
    {
        currentSize = new Rectangle(width, height);
    }

    public void setValue(double value)
    {
        ((DoubleValueText)singleGauge.getTextPainter()).setValue(value);
        invalidate();
        repaint();
    }

    protected Rectangle getInnerBounds()
    {
        return currentSize;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        singleGauge.paint((Graphics2D) g, new Dimension(getWidth(), getHeight()));
    }

    public Backdrop getBackgroundPainter()
    {
        return singleGauge.getBackgroundPainter();
    }

    public void setBackgroundPainter(Backdrop painter)
    {
        singleGauge.setBackgroundPainter(painter);
    }

  
}
