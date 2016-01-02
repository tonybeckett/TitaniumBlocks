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
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.color.LcdGradientPalette;
import us.jaba.titaniumblocks.core.color.lcdgradients.StandardGreenLcdPalette;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class LcdBackdropModel extends AbstractRectangularBackdropModel
{

    private LcdGradientPalette palette;

    public LcdGradientPalette getPalette()
    {
        return palette;
    }

    public void setPalette(LcdGradientPalette palette)
    {
        this.palette = palette;
        changed();
    }

    public LcdBackdropModel()
    {
        palette = new StandardGreenLcdPalette();
    }

    @Override
    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Rectangle2D bounds)
    {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        // Background rectangle
        final Point2D BACKGROUND_START = new Point2D.Double(0.0, bounds.getMinY());
        final Point2D BACKGROUND_STOP = new Point2D.Double(0.0, bounds.getMaxY());
        if (PointSupport.pointsEqual(BACKGROUND_START, BACKGROUND_STOP))
        {
            BACKGROUND_STOP.setLocation(0.0, BACKGROUND_STOP.getY() + 1);
        }

        final float[] BACKGROUND_FRACTIONS =
        {
            0.0f,
            0.08f,
            0.92f,
            1.0f
        };

        final Color[] BACKGROUND_COLORS =
        {
            new Color(0.3f, 0.3f, 0.3f, 1.0f),
            new Color(0.4f, 0.4f, 0.4f, 1.0f),
            new Color(0.4f, 0.4f, 0.4f, 1.0f),
            new Color(0.9f, 0.9f, 0.9f, 1.0f)
        };

        final LinearGradientPaint BACKGROUND_GRADIENT = new LinearGradientPaint(BACKGROUND_START, BACKGROUND_STOP, BACKGROUND_FRACTIONS, BACKGROUND_COLORS);
        final double BACKGROUND_CORNER_RADIUS = bounds.getWidth() > bounds.getHeight() ? (bounds.getHeight() * 0.12) : (bounds.getWidth() * 0.12);
        final RoundRectangle2D BACKGROUND = new RoundRectangle2D.Double(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight(), BACKGROUND_CORNER_RADIUS, BACKGROUND_CORNER_RADIUS);
        graphics.setPaint(BACKGROUND_GRADIENT);
        graphics.fill(BACKGROUND);

        // Foreground rectangle
        final Point2D FOREGROUND_START = new Point2D.Double(0.0, bounds.getMinY() + 1.0);
        final Point2D FOREGROUND_STOP = new Point2D.Double(0.0, bounds.getMaxY() - 1);
        if (PointSupport.pointsEqual(FOREGROUND_START, FOREGROUND_STOP))
        {
            FOREGROUND_STOP.setLocation(0.0, FOREGROUND_STOP.getY() + 1);
        }

        final float[] FOREGROUND_FRACTIONS =
        {
//            0.0f,
//            0.03f,
//            0.49f,
//            0.5f,
//            1.0f
            0.0f,
            0.03f,
            0.39f,
            0.59f,
            1.0f
        };

        final Color[] FOREGROUND_COLORS =
        {
            palette.getStartColor(),
            palette.getFirstQuarterColor(),
            palette.getMiddleColor(),
            palette.getThirdQuarterColor(),
            palette.getStopColor()
        };

        final LinearGradientPaint FOREGROUND_GRADIENT = new LinearGradientPaint(FOREGROUND_START, FOREGROUND_STOP, FOREGROUND_FRACTIONS, FOREGROUND_COLORS);
        graphics.setPaint(FOREGROUND_GRADIENT);

        final double FOREGROUND_CORNER_RADIUS = BACKGROUND.getArcWidth() - 1;
        final RoundRectangle2D FOREGROUND = new RoundRectangle2D.Double(bounds.getMinX() + 0, bounds.getMinY() + 0, bounds.getWidth() - 0, bounds.getHeight() - 0, FOREGROUND_CORNER_RADIUS, FOREGROUND_CORNER_RADIUS);
        graphics.fill(FOREGROUND);

    }

    @Override
    protected Paint getPaint(Dimension dimensions, Rectangle bounds)
    {
        return null;
    }

}
