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

import us.jaba.titaniumblocks.core.areas.AreaList;
import us.jaba.titaniumblocks.core.glow.Glow;
import us.jaba.titaniumblocks.core.knobs.Knob;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.markers.Marker;
import us.jaba.titaniumblocks.core.sections.SectionList;
import us.jaba.titaniumblocks.displays.round.FullRoundDial;

/**
 *
 * @author tbeckett
 */
public class FullDialPanel extends SimpleDialPanel
{
    private FullRoundDial fullRoundDial;
    
    public FullDialPanel(FullRoundDial dial)
    {
        super(dial);
        fullRoundDial = dial;
    }

    public void setAreaList(AreaList al)
    {
        fullRoundDial.setAreaList(al);
    }

    public AreaList getAreaList()
    {
        return fullRoundDial.getAreaList();
    }

    public SectionList getSectionList()
    {
        return fullRoundDial.getSectionList();
    }

    public void setSectionList(SectionList sections)
    {
        fullRoundDial.setSectionList(sections);
    }

    public Glow getGlow()
    {
        return fullRoundDial.getGlow();
    }

    public void setGlow(Glow glow)
    {
        fullRoundDial.setGlow(glow);
    }

    public Led getLed1()
    {
        return fullRoundDial.getLed1();
    }

    public void setLed1(Led led)
    {
        fullRoundDial.setLed1(led);
    }

    public Led getLed2()
    {
        return fullRoundDial.getLed2();
    }

    public void setLed2(Led led)
    {
        fullRoundDial.setLed2(led);
    }

    public Knob getKnob1()
    {
        return fullRoundDial.getKnob1();
    }

    public void setKnob1(Knob knob)
    {
        fullRoundDial.setKnob1(knob);
    }

    public Knob getKnob2()
    {
        return fullRoundDial.getKnob2();
    }

    public void setKnob2(Knob knob)
    {
        fullRoundDial.setKnob2(knob);
    }

   

    public double getMarker1Value()
    {
        return fullRoundDial.getMarker1Value();
    }

    public void setMarker1Value(double marker1Value)
    {
        fullRoundDial.setMarker1Value(marker1Value);
    }

    public double getMarker2Value()
    {
        return fullRoundDial.getMarker2Value();
    }

    public void setMarker2Value(double marker2Value)
    {
        fullRoundDial.setMarker2Value(marker2Value);
    }

    public Marker getMarker1()
    {
        return fullRoundDial.getMarker1();
    }

    public void setMarker1(Marker p)
    {
        fullRoundDial.setMarker1(p);
    }

    public Marker getMarker2()
    {
        return fullRoundDial.getMarker2();
    }

    public void setMarker2(Marker p)
    {
        fullRoundDial.setMarker2(p);
    }

    public Marker getThreshold()
    {
        return fullRoundDial.getThreshold();
    }

    public void setThreshold(Marker p)
    {
        fullRoundDial.setThreshold(p);
    }

    public double getThresholdValue()
    {
        return fullRoundDial.getThresholdValue();
    }

    public void setThresholdValue(double thresholdValue)
    {
        fullRoundDial.setThresholdValue(thresholdValue);
    }
    
}
