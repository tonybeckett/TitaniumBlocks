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
package us.jaba.titaniumblocks.core.bargraph.leds;

import java.awt.Color;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;

/**
 *
 * @author tbeckett
 */
public class LedModel extends CoreBean
{

    protected double maxValue;
    protected double minValue;
    protected double value;
    private Color[] ledColors;

    public LedModel()
    {
        setColor(new PureRed());
        value = 50.0;
        minValue = 0.0;
        maxValue = 100.0;
    }

    public double getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(double maxValue)
    {
        this.maxValue = maxValue;
    }

    public double getMinValue()
    {
        return minValue;
    }

    public void setMinValue(double minValue)
    {
        this.minValue = minValue;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public void setColor(GradientPalette gp)
    {
        ledColors = new Color[]
        {
            gp.getLight(),
            gp.getDark()
        };
    }

    public Color[] getLedColors()
    {
        return ledColors;
    }

    public void setLedColors(Color[] ledColors)
    {
        this.ledColors = ledColors;
    }

    protected double getCoordForValue(double value, final double FULL_SIZE)
    {
        return ((value - getMinValue()) / (getMaxValue() - getMinValue())) * FULL_SIZE;
    }
}
