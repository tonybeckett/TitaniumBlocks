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
import java.awt.LinearGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrameEffectPainter;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class RadialInnerEffectPainter implements RoundFrameEffectPainter
{

    private float[] EFFECT_FRACTIONS;
    private Color[] EFFECT_COLORS;

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions, final Area outerFrame, Point2D center)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Ellipse2D EFFECT_BIGINNERFRAME = new Ellipse2D.Double(imageWidth * 0.0607476644217968, imageHeight * 0.0607476644217968, imageWidth * 0.8785046339035034, imageHeight * 0.8785046339035034);
        final Point2D EFFECT_BIGINNERFRAME_START = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMinY());
        final Point2D EFFECT_BIGINNERFRAME_STOP = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMaxY());
        EFFECT_FRACTIONS = new float[]
        {
            0.0f,
            0.3f,
            0.5f,
            0.71f,
            1.0f
        };
        EFFECT_COLORS = new Color[]
        {
            new Color(0, 0, 0, 183),
            new Color(148, 148, 148, 25),
            new Color(0, 0, 0, 159),
            new Color(0, 0, 0, 81),
            new Color(255, 255, 255, 158)
        };
        PointSupport.validateGradientPoints(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP);
        final LinearGradientPaint EFFECT_BIGINNERFRAME_GRADIENT = new LinearGradientPaint(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP, EFFECT_FRACTIONS, EFFECT_COLORS);
        graphics.setPaint(EFFECT_BIGINNERFRAME_GRADIENT);
        graphics.fill(EFFECT_BIGINNERFRAME);
    }

}
