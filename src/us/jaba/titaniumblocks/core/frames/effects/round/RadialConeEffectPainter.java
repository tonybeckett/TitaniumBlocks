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
package us.jaba.titaniumblocks.core.frames.effects.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrameEffectPainter;

/**
 *
 * @author tbeckett
 */
public class RadialConeEffectPainter implements RoundFrameEffectPainter
{

    private float[] EFFECT_FRACTIONS;
    private Color[] EFFECT_COLORS;

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions, final Area outerFrame, Point2D center)
    {
        final int width = (int) dimensions.getWidth();
        final int height = (int) dimensions.getHeight();

        EFFECT_FRACTIONS = new float[]
        {
            0.0f,
            0.82f,
            0.8201f,
            0.96f,
            0.9601f,
            1.0f
        };
        EFFECT_COLORS = new Color[]
        {
            new Color(0, 0, 0, 0),
            new Color(0, 0, 0, 50),
            new Color(9, 9, 9, 51),
            new Color(255, 255, 255, 124),
            new Color(223, 223, 223, 127),
            new Color(0, 0, 0, 76)
        };
        RadialGradientPaint EFFECT_GRADIENT = new RadialGradientPaint(center, (float) (0.5 * width), EFFECT_FRACTIONS, EFFECT_COLORS);
        graphics.setPaint(EFFECT_GRADIENT);
        graphics.fill(outerFrame);
    }

}
