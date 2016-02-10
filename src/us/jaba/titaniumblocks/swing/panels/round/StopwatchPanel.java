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
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.displays.round.ClockDisplay;
import us.jaba.titaniumblocks.displays.round.StopWatchDisplay;

/**
 *
 * @author tbeckett
 */
public class StopwatchPanel extends JComponent
{

    private final Rectangle DEFAULT_SIZE = new Rectangle(0, 0, 128, 48);
    private Rectangle currentSize = DEFAULT_SIZE;
    private Timeline timeline = new Timeline(this);
    private final Spline EASE = new Spline(0.5f);
    private double hourValue;
    private double minuteValue;
    private double secondValue;

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

            init(getWidth(), getHeight());

        }

    };
    private final StopWatchDisplay singleGauge;

    public StopwatchPanel(Color color)
    {
        
        singleGauge = new StopWatchDisplay(color);
        this.addComponentListener(componentListener);
    }

    public StopWatchDisplay getGauge()
    {
        return singleGauge;
    }

    public void init(int width, int height)
    {

        currentSize = new Rectangle(width, height);
    }

    public void setValueAnimated(double hour, double minute, double second)
    {

        if (timeline.getState() == Timeline.TimelineState.PLAYING_FORWARD || timeline.getState() == Timeline.TimelineState.PLAYING_REVERSE)
        {
            timeline.abort();
        }
        timeline = new Timeline(this);
       
        timeline.addPropertyToInterpolate("minute", minuteValue, minute);
        timeline.addPropertyToInterpolate("second", secondValue, second);
        timeline.setEase(EASE);
        timeline.setDuration(50);
        timeline.play();
       
        minuteValue = minute;
        secondValue = second;

    }

  

    public void setMinute(double value)
    {

        singleGauge.setSecondPointerValue(value / 60.0);
    }

    public void setSecond(double value)
    {

        singleGauge.setThirdPointerValue(value / 60.0);
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

    public Backdrop getBackdrop()
    {
        return singleGauge.getBackdropPainter();
    }

    public void setBackdrop(Backdrop painter)
    {
        singleGauge.setBackdrop(painter);
    }

    public void setRoundFrame(RoundFrame linearFramePainter)
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

    public void setCenterPost(Post postPainter)
    {
        singleGauge.setCenterPost(postPainter);
    }

    public void setPointer(Pointer pointerPainter, Pointer shadowPainter)
    {
        singleGauge.setPointer(pointerPainter, shadowPainter);
    }

    public void setFrontCover(Frontcover foregroundPainter)
    {
        singleGauge.setFrontCover(foregroundPainter);
    }

}
