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
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.ColorTools;
import us.jaba.titaniumblocks.core.led.LedColor;
import us.jaba.titaniumblocks.core.led.PolarLed;
import us.jaba.titaniumblocks.core.led.colors.LedColorRed;
import us.jaba.titaniumblocks.core.math.Angle;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class RoundDialLed extends PolarLed
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

    private final float[] LIGHT_REFLEX_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    private final Color[] LIGHTREFLEX_COLORS =
    {
        new Color(1.0f, 1.0f, 1.0f, 0.4f),
        new Color(1.0f, 1.0f, 1.0f, 0.0f)
    };

    private Color[] LED_OFF_COLORS;
    private Color[] LED_ON_COLORS;
    private Color[] LED_ON_CORONA_COLORS;

    public RoundDialLed()
    {
        setLedColor(new LedColorRed());
        this.setAngle(new Angle(75.0));
        this.setRadiusAdjust(new Scale(0.35));
    }

    @Override
    public void setLedColor(LedColor ledColor)
    {
        super.setLedColor(ledColor);

        LED_OFF_COLORS = new Color[]
        {
            getLedColor().getInner1Off(),
            getLedColor().getInner2Off(),
            getLedColor().getOuterOff()
        };

        LED_ON_COLORS = new Color[]
        {
            getLedColor().getInner1On(),
            getLedColor().getInner2On(),
            getLedColor().getOuterOn()
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
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        final double radius = dimensions.getWidth() * 0.5;

        double width = (dimensions.getWidth() * 0.0934579439);
        double height = (dimensions.getHeight() * 0.0934579439);
        Point2D.Double centerPoint = new Point2D.Double((dimensions.getWidth() / 2.0), (dimensions.getHeight() / 2.0));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        // Define led data
        double gAngle = CoordinateUtils.toRadians(CoordinateUtils.normalizeDegrees(CoordinateUtils.adjustToNativeAngle(getAngle().getValue() - 270.0)));
        Point2D.Double ledCenter = CoordinateUtils.convertToGraphics2dPoint(centerPoint, getRadiusAdjust().getValue() * radius, gAngle);

//        final Ellipse2D LED = new Ellipse2D.Double(0.25 * width, 0.25 * height, 0.5 * width, 0.5 * height);
//        final Ellipse2D corona = new Ellipse2D.Double(0, 0, width, height);
        // Define gradients for the lower led
        final RadialGradientPaint offGradient = new RadialGradientPaint(ledCenter, (float) (0.22 * width), LED_FRACTIONS, LED_OFF_COLORS);

        final RadialGradientPaint onGradient = new RadialGradientPaint(ledCenter, (float) (0.22 * width), LED_FRACTIONS, LED_ON_COLORS);
        final RadialGradientPaint innerShadowGradient = new RadialGradientPaint(ledCenter, (float) (0.22 * width), LED_INNER_SHADOW_FRACTIONS, LED_INNER_SHADOW_COLORS);
        final RadialGradientPaint onCoronaGradient = new RadialGradientPaint(ledCenter, (float) (0.22 * width), LED_ON_CORONA_FRACTIONS, LED_ON_CORONA_COLORS);

        // Define light reflex data
        final Ellipse2D lightReflexShape = new Ellipse2D.Double(width * 0.22, width * 0.22, width * 0.22, width * 0.22);
        final Point2D lightReflexStartPoint = new Point2D.Double(0, lightReflexShape.getMinY());
        final Point2D lightReflexStopPoint = new Point2D.Double(0, lightReflexShape.getMaxY());

        // Define light reflex gradients
        if (PointSupport.pointsEqual(lightReflexStartPoint, lightReflexStopPoint))
        {
            lightReflexStopPoint.setLocation(lightReflexStopPoint.getX(), lightReflexShape.getY() + 1);
        }
        final LinearGradientPaint lightReflexGradient = new LinearGradientPaint(lightReflexStartPoint, lightReflexStopPoint, LIGHT_REFLEX_FRACTIONS, LIGHTREFLEX_COLORS);

        // Draw the led in on state
        // LED ON
        if (this.isState())
        {
            graphics.setPaint(onCoronaGradient);
//            graphics.fill(corona);
            ShapeUtils.fillCircle(graphics, ledCenter.getX(), ledCenter.getY(), width * 0.22 * 4.0);

            graphics.setPaint(onGradient);
//            graphics.fill(LED);
            ShapeUtils.fillCircle(graphics, ledCenter.getX(), ledCenter.getY(), width * 0.22);
        } else
        {
            graphics.setPaint(offGradient);
//            graphics.fill(LED);
            ShapeUtils.fillCircle(graphics, ledCenter.getX(), ledCenter.getY(), width * 0.22);
        }
        graphics.setPaint(innerShadowGradient);
        ShapeUtils.fillCircle(graphics, ledCenter.getX(), ledCenter.getY(), width * 0.22);
//        graphics.fill(LED);
        graphics.setPaint(lightReflexGradient);
        graphics.fill(lightReflexShape);

    }

}
