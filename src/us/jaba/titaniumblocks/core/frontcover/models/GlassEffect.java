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
package us.jaba.titaniumblocks.core.frontcover.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.CoreModel;

/**
 *
 * @author tbeckett
 */
public class GlassEffect extends CoreModel
{

    final float[] GLASSEFFECT_FRACTIONS =
    {
        0.0f,
        0.06f,
        0.07f,
        0.12f,
        0.17f,
        0.1701f,
        0.79f,
        0.8f,
        0.84f,
        0.93f,
        0.94f,
        0.96f,
        0.97f,
        1.0f
    };
    final Color[] GLASSEFFECT_COLORS =
    {
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 3),
        new Color(255, 255, 255, 5),
        new Color(255, 255, 255, 5),
        new Color(255, 255, 255, 5),
        new Color(255, 255, 255, 20),
        new Color(255, 255, 255, 73),
        new Color(255, 255, 255, 76),
        new Color(255, 255, 255, 30),
        new Color(255, 255, 255, 10),
        new Color(255, 255, 255, 5)
    };

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        // Highlight
        final GeneralPath GLASSEFFECT = new GeneralPath();
        GLASSEFFECT.setWindingRule(Path2D.WIND_EVEN_ODD);
        final Point2D GLASSEFFECT_START;
        final Point2D GLASSEFFECT_STOP;
        final LinearGradientPaint GLASSEFFECT_GRADIENT;

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        if (imageWidth >= imageHeight)
        {
            // Horizontal glass effect
            GLASSEFFECT.moveTo(2, imageHeight - 2);
            GLASSEFFECT.lineTo(imageWidth - 2, imageHeight - 2);
            GLASSEFFECT.curveTo(imageWidth - 2, imageHeight - 2, imageWidth - 11, imageHeight * 0.7, imageWidth - 11, imageHeight * 0.5);
            GLASSEFFECT.curveTo(imageWidth - 11, 11, imageWidth - 2, 2, imageWidth - 2, 2);
            GLASSEFFECT.lineTo(2, 2);
            GLASSEFFECT.curveTo(2, 2, 11, imageHeight * 0.2857142857142857, 11, imageHeight * 0.5);
            GLASSEFFECT.curveTo(11, imageHeight * 0.7, 2, imageHeight - 2, 2, imageHeight - 2);
            GLASSEFFECT.closePath();
            GLASSEFFECT_START = new Point2D.Double(0, GLASSEFFECT.getBounds2D().getMaxY());
            GLASSEFFECT_STOP = new Point2D.Double(0, GLASSEFFECT.getBounds2D().getMinY());
        } else
        {
            // Vertical glass effect
            GLASSEFFECT.setWindingRule(Path2D.WIND_EVEN_ODD);
            GLASSEFFECT.moveTo(2, 2);
            GLASSEFFECT.lineTo(2, imageHeight - 2);
            GLASSEFFECT.curveTo(2, imageHeight - 2, 11, imageHeight - 11, imageWidth * 0.5, imageHeight - 11);
            GLASSEFFECT.curveTo(imageWidth - 11, imageHeight - 11, imageWidth - 2, imageHeight - 2, imageWidth - 2, imageHeight - 2);
            GLASSEFFECT.lineTo(imageWidth - 2, 2);
            GLASSEFFECT.curveTo(imageWidth - 2, 2, imageWidth - 11, 11, imageWidth * 0.5, 11);
            GLASSEFFECT.curveTo(11, 11, 2, 2, 2, 2);
            GLASSEFFECT.closePath();
            GLASSEFFECT_START = new Point2D.Double(GLASSEFFECT.getBounds2D().getMinX(), 0);
            GLASSEFFECT_STOP = new Point2D.Double(GLASSEFFECT.getBounds2D().getMaxX(), 0);
        }

        GLASSEFFECT_GRADIENT = new LinearGradientPaint(GLASSEFFECT_START, GLASSEFFECT_STOP, GLASSEFFECT_FRACTIONS, GLASSEFFECT_COLORS);
        graphics.setPaint(GLASSEFFECT_GRADIENT);
        graphics.fill(GLASSEFFECT);

    }

}
