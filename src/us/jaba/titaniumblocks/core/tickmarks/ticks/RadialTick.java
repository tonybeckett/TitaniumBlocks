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
package us.jaba.titaniumblocks.core.tickmarks.ticks;

import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;

/**
 *
 * @author tbeckett
 */
public class RadialTick
{

    Point2D textPoint = new Point2D.Double(0, 0);
    Point2D innerPoint = new Point2D.Double(0, 0);
    Point2D outerPoint = new Point2D.Double(0, 0);
    Point2D centerPoint = new Point2D.Double(0, 0);
    double angle = 0.0;
    double radius = 1.0;
    double tickLength = 0.5;
    double textDistance = 0.1;
    double textAngle = 0.0;
    double value = 0.0;

    // java coordinate system has positive x down so converting from polar needs to adjust.
    private void calc()
    {
        innerPoint.setLocation(CoordinateUtils.calcPosition(centerPoint, radius - tickLength, angle)); 
        outerPoint.setLocation(CoordinateUtils.calcPosition(centerPoint, radius, angle)); 
        textPoint.setLocation(CoordinateUtils.calcPosition(centerPoint, radius - textDistance, angle)); 
    }

    public Point2D getTextPoint()
    {
        return textPoint;
    }

    public Point2D getInnerPoint()
    {
        return innerPoint;
    }

    public Point2D getOuterPoint()
    {
        return outerPoint;
    }

    public double getTextDistance()
    {
        return textDistance;
    }

    public void setTextDistance(double textDistance)
    {
        this.textDistance = textDistance;
        calc();
    }

    public Point2D getCenterPoint()
    {
        return centerPoint;
    }

    public void setCenterPoint(Point2D centerPoint)
    {
        this.centerPoint = centerPoint;
        calc();
    }

    public double getAngle()
    {
        return angle;
    }

    public void setAngle(double angle)
    {
        this.angle = angle;
        calc();
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
        calc();
    }

    public double getTickLength()
    {
        return tickLength;
    }

    public void setTickLength(double tickLength)
    {
        this.tickLength = tickLength;
        calc();
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public double getValue()
    {
        return value;
    }

    public double getTextAngle()
    {
        return textAngle;
    }

    public void setTextAngle(double textAngle)
    {
        this.textAngle = textAngle;
    }

    @Override
    public String toString()
    {
        return "RadialTick{" + "textPoint=" + textPoint + ", innerPoint=" + innerPoint + ", outerPoint=" + outerPoint + ", centerPoint=" + centerPoint + ", angle=" + angle + ", radius=" + radius + ", tickLength=" + tickLength + ", textDistance=" + textDistance + ", textAngle=" + textAngle + ", value=" + value + '}';
    }

}
