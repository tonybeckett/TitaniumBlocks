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
package us.jaba.titaniumblocks.core.led.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.ColorTools;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class RoundDialLed extends Led
{

    private final float[] LED_FRACTIONS =
    {
        0.0f,
        0.2f,
        1.0f
    };

    private final float[] LED_INNER_SHADOW_FRACTIONS =
    {
        0.0f,
        0.8f,
        1.0f
    };

    private final Color[] LED_INNER_SHADOW_COLORS =
    {
        new Color(0.0f, 0.0f, 0.0f, 0.0f),
        new Color(0.0f, 0.0f, 0.0f, 0.0f),
        new Color(0.0f, 0.0f, 0.0f, 0.4f),
    };

    private final float[] LED_ON_CORONA_FRACTIONS =
    {
        0.0f,
        0.6f,
        0.7f,
        0.8f,
        0.85f,
        1.0f
    };

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        int width = (int) (dimensions.getWidth() * 0.0934579439);
        int height = (int) (dimensions.getHeight() * 0.0934579439);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        // Define led data
        final Ellipse2D LED = new Ellipse2D.Double(0.25 * width, 0.25 * height, 0.5 * width, 0.5 * height);
        final Ellipse2D LED_CORONA = new Ellipse2D.Double(0, 0, width, height);

        final Point2D LED_CENTER = new Point2D.Double(LED.getCenterX(), LED.getCenterY());

        final Color[] LED_ON_COLORS;
        final Color[] LED_ON_CORONA_COLORS;

        LED_ON_COLORS = new Color[]
        {
            getLedColor().getInner1On(),// LED_COLOR.INNER_COLOR1_ON,
            getLedColor().getInner2On(),// LED_COLOR.INNER_COLOR2_ON,
            getLedColor().getOuterOn()// LED_COLOR.OUTER_COLOR_ON
        };

        LED_ON_CORONA_COLORS = new Color[]
        {
            ColorTools.setAlpha(getLedColor().getCorona(), 0.0f),
            ColorTools.setAlpha(getLedColor().getCorona(), 0.4f),
            ColorTools.setAlpha(getLedColor().getCorona(), 0.25f),
            ColorTools.setAlpha(getLedColor().getCorona(), 0.15f),
            ColorTools.setAlpha(getLedColor().getCorona(), 0.05f),
            ColorTools.setAlpha(getLedColor().getCorona(), 0.0f)
        };

        // Define gradients for the lower led
        final RadialGradientPaint LED_ON_GRADIENT = new RadialGradientPaint(LED_CENTER, 0.25f * width, LED_FRACTIONS, LED_ON_COLORS);
        final RadialGradientPaint LED_INNER_SHADOW_GRADIENT = new RadialGradientPaint(LED_CENTER, 0.25f * width, LED_INNER_SHADOW_FRACTIONS, LED_INNER_SHADOW_COLORS);
        final RadialGradientPaint LED_ON_CORONA_GRADIENT = new RadialGradientPaint(LED_CENTER, 0.5f * width, LED_ON_CORONA_FRACTIONS, LED_ON_CORONA_COLORS);

        // Define light reflex data
        final Ellipse2D LED_LIGHTREFLEX = new Ellipse2D.Double(0.4 * width, 0.35 * width, 0.2 * width, 0.15 * width);
        final Point2D LED_LIGHTREFLEX_START = new Point2D.Double(0, LED_LIGHTREFLEX.getMinY());
        final Point2D LED_LIGHTREFLEX_STOP = new Point2D.Double(0, LED_LIGHTREFLEX.getMaxY());

        final float[] LIGHT_REFLEX_FRACTIONS =
        {
            0.0f,
            1.0f
        };

        final Color[] LIGHTREFLEX_COLORS =
        {
            new Color(1.0f, 1.0f, 1.0f, 0.4f),
            new Color(1.0f, 1.0f, 1.0f, 0.0f)
        };

        // Define light reflex gradients
        if (PointSupport.pointsEqual(LED_LIGHTREFLEX_START, LED_LIGHTREFLEX_STOP))
        {
            LED_LIGHTREFLEX_STOP.setLocation(LED_LIGHTREFLEX_STOP.getX(), LED_LIGHTREFLEX.getY() + 1);
        }
        final LinearGradientPaint LED_LIGHTREFLEX_GRADIENT = new LinearGradientPaint(LED_LIGHTREFLEX_START, LED_LIGHTREFLEX_STOP, LIGHT_REFLEX_FRACTIONS, LIGHTREFLEX_COLORS);

        // Draw the led in on state
        // LED ON
        graphics.setPaint(LED_ON_CORONA_GRADIENT);
        graphics.fill(LED_CORONA);
        graphics.setPaint(LED_ON_GRADIENT);
        graphics.fill(LED);
        graphics.setPaint(LED_INNER_SHADOW_GRADIENT);
        graphics.fill(LED);
        graphics.setPaint(LED_LIGHTREFLEX_GRADIENT);
        graphics.fill(LED_LIGHTREFLEX);

    }

}
