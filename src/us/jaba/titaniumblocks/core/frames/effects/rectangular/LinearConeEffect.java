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
package us.jaba.titaniumblocks.core.frames.effects.rectangular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import us.jaba.titaniumblocks.core.frames.RectangularFrameEffectPainter;

import us.jaba.titaniumblocks.core.gradients.paint.ContourGradientPaint;

/**
 *
 * @author tbeckett
 */
public class LinearConeEffect implements RectangularFrameEffectPainter
{

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions, final Area outerFrame)
    {
        final int width = (int) dimensions.getWidth();
        final int height = (int) dimensions.getHeight();
        float relFrameSize;
        float[] EFFECT_FRACTIONS;
        Color[] EFFECT_COLORS;

        // The smaller side is important for the contour gradient
        if (width >= height)
        {
            relFrameSize = 32f / height;
        } else
        {
            relFrameSize = 32f / width;
        }
        EFFECT_FRACTIONS = new float[]
        {
            0.0f,
            relFrameSize * 0.1f,
            //relFrameSize * 0.2f,
            relFrameSize * 0.3f,
            //relFrameSize * 0.4f,
            //relFrameSize * 0.5f,
            //relFrameSize * 0.6f,
            //relFrameSize * 0.7f,
            //relFrameSize * 0.8f,
            //relFrameSize * 0.9f,
            relFrameSize,
            1.0f
        };
        EFFECT_COLORS = new Color[]
        {
            //ColorPalette.BLUE,     // 0.0f                   Outer border of frame
            //ColorPalette.RED,      // 0.1f * relFrameSize
            //ColorPalette.WHITE,    // 0.2f * relFrameSize
            //ColorPalette.BLACK,    // 0.3f * relFrameSize
            //ColorPalette.YELLOW,   // 0.4f * relFrameSize
            //ColorPalette.MAGENTA,  // 0.5f * relFrameSize
            //ColorPalette.CYAN,    // 0.6f * relFrameSize
            //ColorPalette.GREEN,    // 0.7f * relFrameSize
            //ColorPalette.GRAY,     // 0.8f * relFrameSize
            //ColorPalette.BLUE,     // 0.9f * relFrameSize
            //ColorPalette.RED,      // 1.0f * relFrameSize    Inner border of frame
            //ColorPalette.WHITE,    // 1.0f

            new Color(0f, 0f, 0f, 0.3f),
            new Color(0f, 0f, 0f, 0.3f),
            new Color(1f, 1f, 1f, 0.5f),
            new Color(0f, 0f, 0f, 0.2f),
            new Color(0f, 0f, 0f, 0f)
        };
        ContourGradientPaint EFFECT_GRADIENT = new ContourGradientPaint(outerFrame.getBounds2D(), EFFECT_FRACTIONS, EFFECT_COLORS);
        graphics.setPaint(EFFECT_GRADIENT);
        graphics.fill(outerFrame);
    }

}
