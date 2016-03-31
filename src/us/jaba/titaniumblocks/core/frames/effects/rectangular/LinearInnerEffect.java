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
import java.awt.LinearGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.utils.PointSupport;
import us.jaba.titaniumblocks.core.frames.RectangularFrameEffect;

/**
 *
 * @author tbeckett
 */
public class LinearInnerEffect implements RectangularFrameEffect
{

    private final float[] EFFECT_BIGINNERFRAME_FRACTIONS =
    {
        0.0f,
        0.13f,
        0.45f,
        0.92f,
        1.0f
    };
    private final Color[] EFFECT_BIGINNERFRAME_COLORS =
    {
        new Color(0, 0, 0, 183),
        new Color(0, 0, 0, 25),
        new Color(0, 0, 0, 160),
        new Color(0, 0, 0, 80),
        new Color(255, 255, 255, 158)
    };

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions, final Area outerFrame)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final RoundRectangle2D EFFECT_BIGINNERFRAME = new RoundRectangle2D.Double(10, 10, imageWidth - 20, imageHeight - 20, 10.0, 10.0);
        final Point2D EFFECT_BIGINNERFRAME_START = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMinY());
        final Point2D EFFECT_BIGINNERFRAME_STOP = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP);
        final LinearGradientPaint EFFECT_BIGINNERFRAME_GRADIENT = new LinearGradientPaint(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP, EFFECT_BIGINNERFRAME_FRACTIONS, EFFECT_BIGINNERFRAME_COLORS);
        graphics.setPaint(EFFECT_BIGINNERFRAME_GRADIENT);
        graphics.fill(EFFECT_BIGINNERFRAME);
    }

}
