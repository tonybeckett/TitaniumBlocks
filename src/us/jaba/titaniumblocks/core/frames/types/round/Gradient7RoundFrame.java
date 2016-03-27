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
package us.jaba.titaniumblocks.core.frames.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureGray;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class Gradient7RoundFrame extends BasicGradientRoundFrame
{

    private final float[] gradientFractions =
    {
        0.0f,
        0.05f,
        0.10f,
        0.50f,
        0.90f,
        0.95f,
        1.0f
    };

    private Color[] gradientColors =
    {
        new PureGray().getLight(),
        new PureGray().getMediumLight(),
        new PureGray().getMedium(),
        new PureGray().getDark(),
        new PureGray().getLight(),
        new PureGray().getMediumLight(),
        new PureGray().getMedium(),
    };
 

    public Gradient7RoundFrame(Color[] colors)
    {
        super();
        init(gradientFractions, gradientColors);
        super.setPrimaryColor(colors[0]);
        for( int i = 0; i < 7; i++)
        {
            gradientColors[i] = colors[i];
        }
    }

    @Override
    public void setPrimaryColor(Color primaryColor)
    {
        super.setPrimaryColor(primaryColor);
        GradientPalette gp = new GradientPalette(primaryColor);

        gradientColors[0] = gp.getLight();
        gradientColors[1] = gp.getMediumLight();
        gradientColors[2] = gp.getMedium();
        gradientColors[3] = gp.getDark();
        gradientColors[4] = gp.getLight();
        gradientColors[5] = gp.getMediumLight();
        gradientColors[6] = gp.getMedium();
    }

   
}
