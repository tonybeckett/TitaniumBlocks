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
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.text.TextSupport;

/**
 *
 * @author tbeckett
 */
public class ShapeUtils
{

    public static Shape getCircle(double x, double y, double radius)
    {
        return new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
    }

    public static void drawCircle(Graphics2D graphics, double x, double y, double radius)
    {
        Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);
    }

    public static void fillCircle(Graphics2D graphics, double x, double y, double radius)
    {
        Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);

        graphics.fill(circle);
    }

    public static Shape drawTriangle(Graphics2D graphics, double x, double y, double height, double width)
    {
        final GeneralPath triangle = new GeneralPath();
        triangle.setWindingRule(Path2D.WIND_EVEN_ODD);
        triangle.moveTo(x - (width / 2.0), y - (height / 2));
        triangle.lineTo(x + (width / 2.0), y - (height / 2));
        triangle.lineTo(x + (width / 2.0), y + (height / 2));
        triangle.lineTo(x - (width / 2.0), y - (height / 2));
        triangle.closePath();

        graphics.draw(triangle);

        return triangle;
    }

    public static void fillTriangle(Graphics2D graphics, double x, double y, double height, double width)
    {
        Shape triangle = drawTriangle(graphics, x, y, height, width);
        graphics.fill(triangle);
    }

    private static double adjust(double a)
    {
        return CoordinateUtils.toRadians(CoordinateUtils.normalizeDegrees(CoordinateUtils.adjustToNativeAngle(a)));
    }

    public static void placeTextOnRadius(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, String[] text)
    {
        int len = text.length;
        double currentAngle = startAngle;

        for (int i = 0; i < len; i++)
        {
            double gAngle = adjust(currentAngle - 270);
            Point2D.Double textPoint = CoordinateUtils.convertToGraphics2dPoint(center, radius, gAngle);

            TextSupport.rotateTextAroundCenter(graphics, text[i], textPoint.getX(), textPoint.getY(), 0.0);

            currentAngle = currentAngle + angleStep;
        }

    }

    public static void placeTextOnRadiusRotateOut(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, String[] text)
    {
        int len = text.length;
        double currentAngle = startAngle;

        for (int i = 0; i < len; i++)
        {
            double gAngle = adjust(currentAngle - 270);
            Point2D.Double textPoint = CoordinateUtils.convertToGraphics2dPoint(center, radius, gAngle);

            TextSupport.rotateTextAroundCenter(graphics, text[i], textPoint.getX(), textPoint.getY(), gAngle);
            currentAngle = currentAngle + angleStep;
        }

    }

    public static void placeTextOnRadiusRotateIn(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, String[] text)
    {
        int len = text.length;
        double currentAngle = startAngle;

        for (int i = 0; i < len; i++)
        {
            double gAngle = adjust(currentAngle - 270);
            Point2D.Double textPoint = CoordinateUtils.convertToGraphics2dPoint(center, radius, gAngle);

            TextSupport.rotateTextAroundCenter(graphics, text[i], textPoint.getX(), textPoint.getY(), CoordinateUtils.normalizeRadians(gAngle + Math.PI));
            currentAngle = currentAngle + angleStep;
        }

    }

    public static void drawRadialLines(Graphics2D graphics, Point2D center, double radiusInner, double radiusOuter, double startAngle, double angleStep, int number)
    {

        double currentAngle = startAngle;

        for (int i = 0; i < number; i++)
        {
            double gAngle = adjust(currentAngle - 270);
            Point2D.Double innerPoint = CoordinateUtils.convertToGraphics2dPoint(center, radiusInner, gAngle);
            Point2D.Double outerPoint = CoordinateUtils.convertToGraphics2dPoint(center, radiusOuter, gAngle);

            graphics.drawLine((int) Math.round(innerPoint.x), (int) Math.round(innerPoint.y), (int) Math.round(outerPoint.x), (int) Math.round(outerPoint.y));

            currentAngle = CoordinateUtils.normalizeDegrees(currentAngle + angleStep);
        }
    }

    public static void placeCircleOnRadius(Graphics2D graphics, Point2D center, double radius, double circleRadius, double startAngle, double angleStep, boolean fill, int number)
    {
        double currentAngle = startAngle;

        for (int i = 0; i < number; i++)
        {
            double sinValue = Math.sin((currentAngle - 180.0) * Math.PI / 180.0);
            double cosValue = Math.cos((currentAngle - 180.0) * Math.PI / 180.0);
            Point2D.Double centerPoint = new Point2D.Double((double) center.getX() + (radius * sinValue), (double) center.getY() + (radius * cosValue));

            if (fill)
            {
                fillCircle(graphics, centerPoint.x, centerPoint.y, circleRadius);
            } else
            {
                drawCircle(graphics, centerPoint.x, centerPoint.y, circleRadius);
            }
            currentAngle = currentAngle + angleStep;
        }
    }

    public static void placeLineArcOnRadius(Graphics2D graphics, Point2D center, double radius, double startAngle, double endAngle)
    {
        Point2D.Double pointStart = new Point2D.Double((double) center.getX() - radius, (double) center.getY() - radius);

        int extent = (int) (endAngle + (360 - startAngle));

        int width = (int) (radius * 2.0);
        int height = (int) (radius * 2.0);
        graphics.drawArc((int)pointStart.x, (int)pointStart.y, width, height, (int) ((510 - startAngle) % 360), extent);
    }

    public static void placeArcOnRadius(Graphics2D graphics, Point2D center, double innerRadius, double outerRadius, double startAngle, double endAngle, double angleStep, int number)
    {
        double currentAngle = startAngle;

        Point2D.Double outerPointStart = new Point2D.Double((double) center.getX() - outerRadius, (double) center.getY() - outerRadius);
        Point2D.Double innerPointStart = new Point2D.Double((double) center.getX() - innerRadius, (double) center.getY() - innerRadius);

        double extent = endAngle - startAngle;

        for (int i = 0; i < number; i++)
        {
            Arc2D.Double outerArc = new Arc2D.Double(Arc2D.PIE);
            outerArc.setFrame(outerPointStart.getX(), outerPointStart.getY(), outerRadius * 2, outerRadius * 2);
            outerArc.setAngleStart(450 - currentAngle % 360);
            outerArc.setAngleExtent(-extent);

            Area area = new Area(outerArc);
            Arc2D.Double innerArc = new Arc2D.Double(Arc2D.PIE);
            innerArc.setFrame(innerPointStart.getX(), innerPointStart.getY(), innerRadius * 2, innerRadius * 2);
            innerArc.setAngleStart(450 - currentAngle % 360);
            innerArc.setAngleExtent(-extent);
            area.subtract(new Area(innerArc));

            graphics.fill(area);

            currentAngle = currentAngle + angleStep;
        }

    }

    public static void placeTriangleOnRadius(Graphics2D graphics, Point2D center, double width, double height, double radius, double startAngle, double angleStep, boolean fill, int number)
    {
        double currentAngle = startAngle;
        Point2D.Double topPoint = new Point2D.Double(0.0, (height / 2));
        Point2D.Double leftPoint = new Point2D.Double(width / -2.0, (height / -2.0));
        Point2D.Double rightPoint = new Point2D.Double(width / 2.0, (height / -2.0));
        AffineTransform transform = graphics.getTransform();

        for (int i = 0; i < number; i++)
        {
            double sinValue = Math.sin((currentAngle - 180.0) * Math.PI / 180.0);
            double cosValue = Math.cos((currentAngle - 180.0) * Math.PI / 180.0);
            Point2D.Double centerPoint = new Point2D.Double((double) center.getX() + (radius * sinValue), (double) center.getY() + (radius * cosValue));

            final GeneralPath triangle = new GeneralPath();
            triangle.setWindingRule(Path2D.WIND_EVEN_ODD);

            triangle.moveTo(topPoint.x, topPoint.y);
            triangle.lineTo(leftPoint.x, leftPoint.y);
            triangle.lineTo(rightPoint.x, rightPoint.y);
            triangle.lineTo(topPoint.x, topPoint.y);
            triangle.closePath();

            graphics.setTransform(transform);
            graphics.translate(centerPoint.getX(), centerPoint.getY());
            graphics.rotate(CoordinateUtils.normalizeDegrees(180 - currentAngle) * Math.PI / 180.0, 0.0, 0.0);
//            graphics.rotate(((450.0 - currentAngle) % 360) * Math.PI / 180.0, 0.0, 0.0);

            if (fill)
            {
                graphics.draw(triangle);

                graphics.fill(triangle);
            } else
            {
                graphics.draw(triangle);

            }
            currentAngle = currentAngle + angleStep;
        }
        graphics.setTransform(transform);
    }

    public static void placeHalfFillTriangleOnRadius(Graphics2D graphics, Point2D center, double width, double height, double radius, double startAngle, double angleStep, int number)
    {
        double currentAngle = startAngle;
        Point2D.Double topPoint = new Point2D.Double(0.0, (height / 2));
        Point2D.Double leftPoint = new Point2D.Double(width / -2.0, (height / -2.0));
        Point2D.Double rightPoint = new Point2D.Double(width / 2.0, (height / -2.0));
        Point2D.Double bottomCenterPoint = new Point2D.Double(0.0, (height / -2.0));

        AffineTransform transform = graphics.getTransform();

        for (int i = 0; i < number; i++)
        {
            double sinValue = Math.sin((currentAngle - 180.0) * Math.PI / 180.0);
            double cosValue = Math.cos((currentAngle - 180.0) * Math.PI / 180.0);
            Point2D.Double centerPoint = new Point2D.Double((double) center.getX() + (radius * sinValue), (double) center.getY() + (radius * cosValue));

            final GeneralPath leftTriangle = new GeneralPath();
            leftTriangle.setWindingRule(Path2D.WIND_EVEN_ODD);
            leftTriangle.moveTo(topPoint.x, topPoint.y);
            leftTriangle.lineTo(leftPoint.x, leftPoint.y);
            leftTriangle.lineTo(bottomCenterPoint.x, bottomCenterPoint.y);
            leftTriangle.lineTo(topPoint.x, topPoint.y);
            leftTriangle.closePath();

            final GeneralPath rightTriangle = new GeneralPath();
            rightTriangle.setWindingRule(Path2D.WIND_EVEN_ODD);
            rightTriangle.moveTo(topPoint.x, topPoint.y);
            rightTriangle.lineTo(bottomCenterPoint.x, bottomCenterPoint.y);
            rightTriangle.lineTo(rightPoint.x, rightPoint.y);
            rightTriangle.lineTo(topPoint.x, topPoint.y);
            rightTriangle.closePath();

            graphics.setTransform(transform);
            graphics.translate(centerPoint.getX(), centerPoint.getY());
            graphics.rotate(CoordinateUtils.normalizeDegrees(180 - currentAngle) * Math.PI / 180.0, 0.0, 0.0);
//            graphics.rotate(((450.0 - currentAngle) % 360) * Math.PI / 180.0, 0.0, 0.0);

            graphics.draw(leftTriangle);

            graphics.fill(rightTriangle);

            currentAngle = currentAngle + angleStep;
        }
        graphics.setTransform(transform);
    }

    public static void placeSquareOnRadius(Graphics2D graphics, Point2D center, double height, double width, double radius, double startAngle, double angleStep, boolean fill, int number)
    {
        double currentAngle = startAngle;

        Point2D.Double topLeftPoint = new Point2D.Double(width / -2.0, (height / 2));
        Point2D.Double topRightPoint = new Point2D.Double(width / 2.0, (height / 2));
        Point2D.Double bottomLeftPoint = new Point2D.Double(width / -2.0, (height / -2.0));
        Point2D.Double bottomRightPoint = new Point2D.Double(width / 2.0, (height / -2.0));

        AffineTransform transform = graphics.getTransform();
        for (int i = 0; i < number; i++)
        {
            double sinValue = Math.sin((currentAngle - 180.0) * Math.PI / 180.0);
            double cosValue = Math.cos((currentAngle - 180.0) * Math.PI / 180.0);
            Point2D.Double centerPoint = new Point2D.Double((double) center.getX() + (radius * sinValue), (double) center.getY() + (radius * cosValue));

            final GeneralPath square = new GeneralPath();
            square.setWindingRule(Path2D.WIND_EVEN_ODD);
            square.moveTo(topLeftPoint.x, topLeftPoint.y);
            square.lineTo(topRightPoint.x, topRightPoint.y);
            square.lineTo(bottomRightPoint.x, bottomRightPoint.y);
            square.lineTo(bottomLeftPoint.x, bottomLeftPoint.y);
            square.lineTo(topLeftPoint.x, topLeftPoint.y);
            square.closePath();

            graphics.setTransform(transform);
            graphics.translate(centerPoint.getX(), centerPoint.getY());
            graphics.rotate((90 - currentAngle) * Math.PI / 180.0, 0.0, 0.0);

            if (fill)
            {
                graphics.draw(square);
                graphics.fill(square);
            } else
            {
                graphics.draw(square);
            }
            currentAngle = currentAngle + angleStep;
        }
        graphics.setTransform(transform);
    }
}
