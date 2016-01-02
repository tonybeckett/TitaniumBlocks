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
package us.jaba.titaniumblocks.core.backdrop.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class OverlayPainter
{

    private float[] SHADOW_OVERLAY_FRACTIONS =
    {
        0.0f,
        0.4f,
        0.6f,
        1.0f
    };
    private Color[] SHADOW_OVERLAY_COLORS =
    {
        new Color(0f, 0f, 0f, 0.5f),
        new Color(0f, 0f, 0f, 0.0f),
        new Color(0f, 0f, 0f, 0.0f),
        new Color(0f, 0f, 0f, 0.5f)
    };

    public void paint(Graphics2D graphics, Dimension dimensions, Rectangle2D GAUGE_BACKGROUND)
    {
        // Draw an overlay gradient that gives the carbon fibre a more realistic look

        final LinearGradientPaint SHADOW_OVERLAY_GRADIENT;
        if (PointSupport.pointsEquals(GAUGE_BACKGROUND.getMinX(), 0, GAUGE_BACKGROUND.getMaxX(), 0))
        {
            SHADOW_OVERLAY_GRADIENT = new LinearGradientPaint(new Point2D.Double(GAUGE_BACKGROUND.getMinX(), 0), new Point2D.Double(GAUGE_BACKGROUND.getMaxX() + 1, 0), SHADOW_OVERLAY_FRACTIONS, SHADOW_OVERLAY_COLORS);
        } else
        {
            SHADOW_OVERLAY_GRADIENT = new LinearGradientPaint(new Point2D.Double(GAUGE_BACKGROUND.getMinX(), 0), new Point2D.Double(GAUGE_BACKGROUND.getMaxX(), 0), SHADOW_OVERLAY_FRACTIONS, SHADOW_OVERLAY_COLORS);
        }
        graphics.setPaint(SHADOW_OVERLAY_GRADIENT);
        graphics.fill(GAUGE_BACKGROUND);
    }

    public float[] getSHADOW_OVERLAY_FRACTIONS()
    {
        return SHADOW_OVERLAY_FRACTIONS;
    }

    public void setSHADOW_OVERLAY_FRACTIONS(float[] SHADOW_OVERLAY_FRACTIONS)
    {
        this.SHADOW_OVERLAY_FRACTIONS = SHADOW_OVERLAY_FRACTIONS;
    }

    public Color[] getSHADOW_OVERLAY_COLORS()
    {
        return SHADOW_OVERLAY_COLORS;
    }

    public void setSHADOW_OVERLAY_COLORS(Color[] SHADOW_OVERLAY_COLORS)
    {
        this.SHADOW_OVERLAY_COLORS = SHADOW_OVERLAY_COLORS;
    }

}
