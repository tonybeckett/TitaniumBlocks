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
package us.jaba.titaniumblocks.core.shape;

import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;

/**
 *
 * @author tbeckett
 */
public class ShapeUtils
{

    public static void drawCircle(Graphics2D graphics, double x, double y, double radius)
    {
        java.awt.Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);
    }

    public static void fillCircle(Graphics2D graphics, double x, double y, double radius)
    {
        java.awt.Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);
        graphics.fill(circle);
    }

    private static double adjust(double a)
    {
        return CoordinateUtils.toRadians(CoordinateUtils.normalizeDegrees(CoordinateUtils.adjustToNativeAngle(a)));
    }

    public static void placeTextOnRadius(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, String[] text)
    {
        int len = text.length;
        double currentAngle = startAngle;
        final FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);

        for (int i = 0; i < len; i++)
        {
            double gAngle = adjust(currentAngle-270);
            Point2D.Double textPoint = CoordinateUtils.convertToGraphics2dPoint(center, radius, gAngle);

            TextLayout textLayout = new TextLayout(text[i], graphics.getFont(), fontRenderContext);
            Rectangle2D boundary = textLayout.getBounds();

            graphics.drawString(text[i],
                    (int) (textPoint.getX() - (boundary.getWidth() / 2.0)),
                    (int) (textPoint.getY() + (boundary.getHeight() / 2.0))
            );
            currentAngle = currentAngle + angleStep;
        }

    }

    public static void drawRadialLines(Graphics2D graphics, Point2D center, double radiusInner, double radiusOuter, double startAngle, double angleStep, int number)
    {
        
        double currentAngle = startAngle;

        for (int i = 0; i < number; i++)
        {
            double gAngle = adjust(currentAngle-270);
            Point2D.Double innerPoint = CoordinateUtils.convertToGraphics2dPoint(center, radiusInner, gAngle);
            Point2D.Double outerPoint = CoordinateUtils.convertToGraphics2dPoint(center, radiusOuter, gAngle);
            
            graphics.drawLine((int) innerPoint.x, (int) innerPoint.y, (int) outerPoint.x, (int) outerPoint.y);

            currentAngle = CoordinateUtils.normalizeDegrees(currentAngle + angleStep);
        }
    }

    public static void drawRadialCircles(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, boolean fill, int number)
    {
        double currentAngle = startAngle;

        for (int i = 0; i < number; i++)
        {
            double sinValue = Math.sin((currentAngle - 180.0) * Math.PI / 180.0);
            double cosValue = Math.cos((currentAngle - 180.0) * Math.PI / 180.0);
            Point2D.Double centerPoint = new Point2D.Double((double) center.getX() + (radius * sinValue), (double) center.getY() + (radius * cosValue));

            if (fill)
            {
                fillCircle(graphics, centerPoint.x, centerPoint.y, radius);
            } else
            {
                drawCircle(graphics, centerPoint.x, centerPoint.y, radius);
            }
            currentAngle = currentAngle + angleStep;
        }
    }
}
