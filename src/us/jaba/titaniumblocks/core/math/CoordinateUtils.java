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
package us.jaba.titaniumblocks.core.math;

import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.layout.CircularTwoPostLayout;
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;

/**
 *
 * @author tbeckett
 */
public class CoordinateUtils
{

    public static Point2D toPointUsing(double r, double theta)
    {
        Point2D pp = new Point2D.Double(r * Math.cos(theta), r * Math.sin(theta));
        return pp;
    }

    public static Point2D toPoint(Polar p)
    {
        return toPointUsing(p.getR(), p.getTheta());
    }

    public static Polar toPolar(Point2D p)
    {
        double r = Math.sqrt(p.getX() * p.getX() + p.getY() * p.getY());
        double theta = Math.atan2(p.getY(), p.getX());

        return new Polar(r, theta);
    }

    public static Polar toPolarWithCenter(Point2D center, Point2D dest)
    {
        double r = Math.sqrt(dest.distanceSq(center));
        double theta = Math.atan2(dest.getY() - center.getY(), dest.getX() - center.getX());

        while (theta < 0)
        {
            theta += Math.PI * 2.0;
        }

        while (theta > 2.0 * Math.PI)
        {
            theta -= Math.PI * 2.0;
        }

        return new Polar(r, theta);
    }

    public static Point2D toPoint2DFromCenter(Point2D center, Polar p)
    {
        Point2D point = toPointUsing(p.getR() * Math.sqrt(center.getX() * center.getY()), p.getTheta());

        return new Point2D.Double(center.getX() - point.getX(), center.getY() - point.getY());
    }

    public static double calcExtent(double startAngle, double endAngle, Direction direction)
    {
        double ext;
        if (direction == CoordinateDefs.Direction.COUNTER)
        {
            ext = endAngle - startAngle;
        } else
        {
            ext = startAngle - endAngle;
        }
        if (ext > 360.0)
        {
            ext = ext - 360.0;
        }
        if (ext < 0)
        {
            ext = ext + 360.0;
        }
        return ext;
    }

    public static double calcGraphicsAngle(double normalizedValue, CircularLayout circularLayout)
    {

        double angleInDegrees = 100.0;

        double ext = calcExtent(circularLayout.getTickmarkStartAngle(), circularLayout.getTickmarkEndAngle(), circularLayout.getTickmarkDirection());

        switch (circularLayout.getTickmarkDirection())
        {
            case CLOCKWISE:
                angleInDegrees = (circularLayout.getTickmarkStartAngle()) - (normalizedValue * ext);

                break;

            case COUNTER:
                angleInDegrees = (normalizedValue * ext * Math.PI / 180.0) - (90.0 * Math.PI / 180.0) - (circularLayout.getTickmarkStartAngle() * Math.PI / 180.0);
                break;
        }
        angleInDegrees = angleInDegrees - 90.0;
//        System.out.println(String.format("%6.3f   %6.3f   %6.3f", normalizedValue, angleInDegrees, 360.0 - angleInDegrees));
        return (360.0 - angleInDegrees) * Math.PI / 180.0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        Polar p = new Polar(0.5, Math.PI / 2.0);

        System.out.println(p.toString());

        Point2D point = toPoint(p);

        Polar np = toPolar(point);

        System.out.println(np.toString());

        point = toPoint2DFromCenter(new Point2D.Double(10.0, 10.0), np);

        System.out.println(point.toString());

        np = toPolar(point);

        System.out.println(np.toString());

        CircularTwoPostLayout circularLayout = new CircularTwoPostLayout(180, 0, Direction.CLOCKWISE, 0.75f, 140, 40);

        double n = 0.01;
        double angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));

        n = 0.5;
        angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));

        n = 0.99;
        angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));

        circularLayout = new CircularTwoPostLayout(270, 90, Direction.CLOCKWISE, 0.75f, 140, 40);

        n = 0.01;
        angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));

        n = 0.5;
        angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));

        n = 0.99;
        angle = calcGraphicsAngle(n, circularLayout);
//        System.out.println(String.format("%f %f", n, angle));
    }
}