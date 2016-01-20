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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.rangemodels;

import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.NORTH;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.SOUTH_WEST;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;

/**
 *
 * @author tbeckett
 */
public class RadialRangeModel
{

    

//    private final Arc2D arc2D = new Arc2D.Double();
    private Point2D center;
    private double startAngle;
    private double endAngle;
    private double radius = 1.0;
    private double endValue = 1.0;
    private double startValue = 0.0;
    private double tickSpacing = 1.0; // by value
    private double tickLength = 1.0;
    private Direction direction = Direction.COUNTER;
    private double textDistance;
    private float textAngleAdjust = 0.0f;


    public RadialRangeModel(Point2D center, double radius, double startAngle, double endAngle)
    {

//        arc2D.setArcByCenter(center.getX(), center.getY(), radius, startAngle, CoordinateUtils.calcExtent(startAngle, endAngle, this), arc2D.CHORD);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.radius = radius;
    }

    public double getAngleStart()
    {
        return startAngle;
    }

//    public double getAngleExtent()
//    {
//        return arc2D.getAngleExtent();
//    }

    public double getAngleEnd()
    {
        return endAngle;
    }

    public void setAngleStart(double angSt)
    {
        startAngle = angSt;
    }

//    public void setAngleExtent(double angExt)
//    {
//        arc2D.setAngleExtent(angExt);
//    }

//    public Rectangle2D getBounds2D()
//    {
//        return arc2D.getBounds2D();
//    }

    public double getCenterX()
    {
        return center.getX();
    }

    public double getCenterY()
    {
        return center.getY();
    }

    public double getEndValue()
    {
        return endValue;
    }

    public void setEndValue(double endValue)
    {
        this.endValue = endValue;
    }

    public double getStartValue()
    {
        return startValue;
    }

    public void setStartValue(double startValue)
    {
        this.startValue = startValue;
    }

    public double getTickSpacing()
    {
        return tickSpacing;
    }

    public void setTickSpacing(double tickSpacing)
    {
        this.tickSpacing = tickSpacing;
    }

    public double getAnglePerTick()
    {
        return CoordinateUtils.calcExtent(startAngle, endAngle, direction) / getNumberOfTicks();
    }

    public double getValuePerTick()
    {
        return (this.endValue - this.startValue) / getNumberOfTicks();
    }

    public int getNumberOfTicks()
    {
        return (int) ((endValue - startValue) / this.tickSpacing);
    }

    public Point2D getCenter()
    {
        return  center;
    }

    public void setCenter(Point2D centerPoint)
    {
        this.center = centerPoint;
    }

    public double getTickLength()
    {
        return tickLength;
    }

    public void setTickLength(double tickLength)
    {
        this.tickLength = tickLength;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
        
    }

    @Override
    public String toString()
    {
        return "TickmarkRadialRangeModel{" + "angleStart=" + this.getAngleStart() + ",angleStop=" + this.getAngleEnd()  + ", radius=" + radius + ", endValue=" + endValue + ", startValue=" + startValue + ", tickSpacing=" + tickSpacing + ", tickLength=" + tickLength + ", direction=" + direction + '}';
    }

    public double getTextDistance()
    {
        return textDistance;
    }

    public void setTextDistance(double textDistance)
    {
        this.textDistance = textDistance;
    }

    public float getTextAngleAdjust()
    {
        return textAngleAdjust;
    }

    public void setTextAngleAdjust(float textAngleAdjust)
    {
        this.textAngleAdjust = textAngleAdjust;
    }

    public double getEndAngle()
    {
        return endAngle;
    }

    public void setEndAngle(double d)
    {
        endAngle = d;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        RadialRangeModel trrm = new RadialRangeModel(new Point2D.Double(1, 1), 0.5, NORTH, SOUTH_WEST);

        System.out.println(trrm.toString());

        trrm.setDirection(Direction.CLOCKWISE);

        System.out.println(trrm.toString());

    }
}
