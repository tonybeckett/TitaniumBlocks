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

import java.awt.Graphics2D;
import java.io.Serializable;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.ease.Spline;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;
import us.jaba.titaniumblocks.displays.TBClockComponent;
import us.jaba.titaniumblocks.displays.round.RoundClockDial;

/**
 *
 * @author tbeckett
 */
public class ClockPanel extends BasicPanel implements Serializable
{

    private double storedValue;
    private Timeline timeline = new Timeline(this);
    private final Spline EASE = new Spline(0.5f);
    private double hourValue;
    private double minuteValue;
    private double secondValue;

    public ClockPanel()
    {
        super(new RoundClockDial());
    }


    public ClockPanel(TBClockComponent clock)
    {
        super(clock);
        this.addComponentListener(componentListener);

    }

    @Override
    public void paint(Graphics2D graphics2D)
    {
     
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

    public void setHour(double value)
    {
        ((TBClockComponent) tbComponent).setHoursValue(value / 12.0);
    }

    public void setMinute(double value)
    {

        ((TBClockComponent) tbComponent).setMinutesValue(value / 60.0);
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
        ((TBClockComponent) tbComponent).setSecondsValue(storedValue / 60.0);
        invalidate();
        repaint();
    }

    public Pointer getHoursPointer()
    {
        return ((TBClockComponent) tbComponent).getHoursPointer();
    }

    public void setHoursPointer(Pointer hourPointer)
    {
        ((TBClockComponent) tbComponent).setHoursPointer(hourPointer);
    }

    public Pointer getMinutesPointer()
    {
        return ((TBClockComponent) tbComponent).getMinutesPointer();
    }

    public void setMinutesPointer(Pointer minutePointer)
    {
        ((TBClockComponent) tbComponent).setMinutesPointer(minutePointer);
    }

    public Pointer getSecondsPointer()
    {
        Pointer secondsPointer = ((TBClockComponent) tbComponent).getSecondsPointer();
        return secondsPointer;
    }

    public void setSecondsPointer(Pointer secondsPointer)
    {
        ((TBClockComponent) tbComponent).setSecondsPointer(secondsPointer);
    }

    @Override
    public AbstractRadialTickmark getTickmarks()
    {
        return (AbstractRadialTickmark) super.getTickmarks(); 
    }

}
