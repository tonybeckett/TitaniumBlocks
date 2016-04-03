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
package us.jaba.titaniumblocks.swing.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.ease.Spline;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;
import us.jaba.titaniumblocks.displays.ClockDisplay;
import us.jaba.titaniumblocks.displays.round.RoundClockDisplay;

/**
 *
 * @author tbeckett
 */
public class ClockPanel extends JComponent
{

    private final Rectangle DEFAULT_SIZE = new Rectangle(0, 0, 128, 48);
    private Rectangle currentSize = DEFAULT_SIZE;
    private double storedValue;
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
    private ClockDisplay clockDisplay;

    public ClockPanel()
    {
        this(new RoundClockDisplay());
    }

    public ClockPanel(ClockDisplay clock)
    {

        clockDisplay = clock;
        this.addComponentListener(componentListener);

    }

    public ClockDisplay getClockDisplay()
    {
        return clockDisplay;
    }

    public void setClockDisplay(ClockDisplay clock)
    {
        clockDisplay = clock;
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
        timeline.addPropertyToInterpolate("hour", hourValue, hour);
        timeline.addPropertyToInterpolate("minute", minuteValue, minute);
        timeline.addPropertyToInterpolate("second", secondValue, second);
        timeline.setEase(EASE);
        timeline.setDuration(50);
        timeline.play();

        hourValue = hour;
        minuteValue = minute;
        secondValue = second;

    }

    public void setTitle(String string)
    {
        clockDisplay.setTitle(string);
    }

    public void setHour(double value)
    {
        clockDisplay.setHoursValue(value / 12.0);
    }

    public void setMinute(double value)
    {

        clockDisplay.setMinutesValue(value / 60.0);
    }

    public void setSecond(double value)
    {
        if (storedValue > 58.0 && value < 59.0)
        {
            storedValue = 0.0;
        } else
        {
            storedValue = value;
        }
        clockDisplay.setSecondsValue(storedValue / 60.0);
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
        Graphics2D g2d = (Graphics2D) g.create();
        super.paint(g);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        clockDisplay.paint((Graphics2D) g, new Dimension(getWidth(), getHeight()));
    }

    public Backdrop getBackdrop()
    {
        return clockDisplay.getBackdrop();
    }

    public void setBackdrop(Backdrop painter)
    {
        clockDisplay.setBackdrop(painter);
    }

    public void setFrame(BasicFrame frame)
    {
        clockDisplay.setFrame(frame);
    }

    @Override
    public void setSize(Dimension d)
    {
        super.setSize(d);

        clockDisplay.setSize(d);
    }

    @Override
    public void setPreferredSize(Dimension preferredSize)
    {
        if (preferredSize != this.getPreferredSize())
        {
            clockDisplay.setChanged();
        }
        super.setPreferredSize(preferredSize);
        clockDisplay.setSize(preferredSize);
        invalidate();
        repaint();
    }

    public void setCenterPost(Post postPainter)
    {
        clockDisplay.setCenterPost(postPainter);
    }

    public void setFrontCover(Frontcover foregroundPainter)
    {
        clockDisplay.setFrontCover(foregroundPainter);
    }

    public Pointer getHoursPointer()
    {
        return clockDisplay.getHoursPointer();
    }

    public void setHoursPointer(Pointer hourPointer)
    {
        clockDisplay.setHoursPointer(hourPointer);
    }

    public Pointer getMinutesPointer()
    {
        return clockDisplay.getMinutesPointer();
    }

    public void setMinutesPointer(Pointer minutePointer)
    {
        clockDisplay.setMinutesPointer(minutePointer);
    }

    public Pointer getSecondsPointer()
    {
        Pointer secondsPointer = clockDisplay.getSecondsPointer();
        return secondsPointer;
    }

    public void setSecondsPointer(Pointer secondsPointer)
    {
        clockDisplay.setSecondsPointer(secondsPointer);
    }

    public Tickmark getTickmark()
    {
        return clockDisplay.getTickmark();
    }

    public void setTickmark(AbstractRadialTickmark tm)
    {
        clockDisplay.setTickmark(tm);
    }

}
