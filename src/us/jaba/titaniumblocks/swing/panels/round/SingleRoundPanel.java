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
package us.jaba.titaniumblocks.swing.panels.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.ease.Spline;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.knobs.KnobPainter;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;
import us.jaba.titaniumblocks.displays.round.SingleRoundDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleRoundPanel extends JComponent
{

    private final Rectangle DEFAULT_SIZE = new Rectangle(0, 0, 128, 48);
    private Rectangle currentSize = DEFAULT_SIZE;
    private Timeline timeline = new Timeline(this);
    private final Spline EASE = new Spline(0.5f);
    private double value;

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
                int min = Math.min(getWidth(), getHeight());
                setPreferredSize(new Dimension(min, min));
            }

            init(getInnerBounds().width, getInnerBounds().height);

        }

    };
    private final SingleRoundDisplay singleGauge;
    private final CircularLayout circularLayout;

    public SingleRoundPanel(CircularLayout circularLayout)
    {
        this.circularLayout = circularLayout;
        singleGauge = new SingleRoundDisplay(circularLayout);
        this.addComponentListener(componentListener);
    }

    public SingleRoundDisplay getGauge()
    {
        return singleGauge;
    }

    public void setTickmarks(AbstractRadialTickmark tickmarks)
    {
        singleGauge.setTickmarks(tickmarks);
    }

    public void setTitle(String string)
    {
        singleGauge.setTitle(string);
    }

    public void init(int width, int height)
    {
        
        currentSize = new Rectangle(width, height);
    }

    public void setValueAnimated(double newValue)
    {

        if (timeline.getState() == Timeline.TimelineState.PLAYING_FORWARD || timeline.getState() == Timeline.TimelineState.PLAYING_REVERSE)
        {
            timeline.abort();
        }
        timeline = new Timeline(this);
        timeline.addPropertyToInterpolate("value", value, newValue);
        timeline.setEase(EASE);
        timeline.setDuration(450);
        timeline.play();
        value = newValue;

    }

    public void setValue(double value)
    {
        singleGauge.setNormalizedValue(value / 100.0);
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

    public Backdrop getBackdropPainter()
    {
        return singleGauge.getBackdrop();
    }

    public void setBackdropPainter(Backdrop painter)
    {
        singleGauge.setBackdrop(painter);
    }

    public void setFrame(RoundFrame linearFramePainter)
    {
        singleGauge.setFrame(linearFramePainter);
    }

    @Override
    public void setSize(Dimension d)
    {
        super.setSize(d);
        singleGauge.setSize(d);
    }

    @Override
    public void setPreferredSize(Dimension preferredSize)
    {
        if (preferredSize != this.getPreferredSize())
        {
            singleGauge.setChanged();
        }
        super.setPreferredSize(preferredSize);
        singleGauge.setSize(preferredSize);
        invalidate();
        repaint();
    }

    public void setColor(Color c)
    {
        singleGauge.setColor(c);
    }

    public void setPointerGradient(GradientPalette cp)
    {
        singleGauge.setPointerGradient(cp);
    }

    public void setUnits(String units)
    {
        singleGauge.setUnits(units);
    }

    public void setCenterPostPainter(Post postPainter)
    {
        singleGauge.setCenterPost(postPainter);
    }

    public void setSmallKnobsPainter(KnobPainter startPainter, KnobPainter endPainter)
    {
        singleGauge.setSmallKnobs(startPainter, endPainter);
    }

    public void setPointerPainter(Pointer pointerPainter, Pointer shadowPainter)
    {
        singleGauge.setPointer(pointerPainter);
    }

    public void setLedPainter(Led ledPainter)
    {
        singleGauge.setLed(ledPainter);
    }

    public void setFrontCoverPainter(Frontcover foregroundPainter)
    {
        singleGauge.setFrontCover(foregroundPainter);
    }

    protected CircularLayout getCircularLayout()
    {
        return circularLayout;
    }

   
     

}
