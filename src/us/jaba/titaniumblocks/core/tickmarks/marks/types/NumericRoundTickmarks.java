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
package us.jaba.titaniumblocks.core.tickmarks.marks.types;

import java.awt.Font;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.font.FontSupport;

/**
 *
 * @author tbeckett
 */
public class NumericRoundTickmarks extends AbstractRadialTickmark
{

    protected String[] labels;
    protected float minValue;
    protected float maxValue;

    public static final String[] DEFAULT_LABELS =
    {
        "0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"
    };

    public NumericRoundTickmarks()
    {
        super();
        init();
    }

    public NumericRoundTickmarks(String[] labels)
    {
        super();
        this.labels = labels;
        init();
    }

    protected void generateTicks()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init()
    {
        minValue = 0.0f;
        maxValue = 100.0f;
        this.textSizeScale = new Scale(0.05);
        this.setFont(FontSupport.getStandardFont().deriveFont(Font.BOLD, (float) (this.textSizeScale.getValue() * 500.0)));
    }


public String[] getLabels()
    {
        return labels;
    }

    public void setLabels(String[] labels)
    {
        this.labels = labels;
        changed();
    }

    public float getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(float maxValue)
    {
        this.maxValue = maxValue;
        changed();
        generateTicks();

    }

    public float getMinValue()
    {
        return minValue;
    }

    public void setMinValue(float minValue)
    {
        this.minValue = minValue;
        changed();
        generateTicks();
    }

}
