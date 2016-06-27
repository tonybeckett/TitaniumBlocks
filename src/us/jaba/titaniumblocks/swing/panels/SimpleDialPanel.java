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

import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.ease.Spline;
import us.jaba.titaniumblocks.core.text.types.PolarText;
import us.jaba.titaniumblocks.displays.AbstractSimpleDial;

/**
 *
 * @author tbeckett
 */
public class SimpleDialPanel extends BasicPanel
{

    private Timeline timeline = new Timeline(this);
    private final Spline EASE = new Spline(0.5f);
    double value;

    public SimpleDialPanel(AbstractSimpleDial dial)
    {
        super(dial);
        this.addComponentListener(componentListener);
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
        ((AbstractSimpleDial) tbComponent).setNormalizedValue(value / 100.0);
        invalidate();
        repaint();
    }

    public void setUnits(String value)
    {
        ((AbstractSimpleDial) tbComponent).setUnits(value);
    }

    public void setMinValue(float value)
    {
        ((AbstractSimpleDial) tbComponent).setMinValue(value);
        invalidate();
        repaint();
    }

    public void setMaxValue(float value)
    {
        ((AbstractSimpleDial) tbComponent).setMaxValue(value);
        invalidate();
        repaint();
    }

//    public void setStartKnob(Knob knob)
//    {
//        ((AbstractSimpleDial) tbComponent).setStartKnob(knob);
//
//    }
//
//    public Knob getStartKnob()
//    {
//        return ((AbstractSimpleDial) tbComponent).getStartKnob();
//    }
//
//    public void setStopKnob(Knob knob)
//    {
//        ((AbstractSimpleDial) tbComponent).setStopKnob(knob);
//    }
//
//    public Knob getStopKnob()
//    {
//        return ((AbstractSimpleDial) tbComponent).getStopKnob();
//    }
    public PolarText getText2()
    {
        return ((AbstractSimpleDial) tbComponent).getText2();
    }

    public void setText2(PolarText text)
    {
        ((AbstractSimpleDial) tbComponent).setText2(text);
    }

}
