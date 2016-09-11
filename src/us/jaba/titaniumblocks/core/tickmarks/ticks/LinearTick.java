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

/**
 *
 * @author tbeckett
 */
public class LinearTick
{

    private Point2D textPoint = new Point2D.Double(0, 0);
    private Point2D.Double startPoint;
    private Point2D.Double stopPoint;

    private double textDistance = 0.1;
    private double textAngle = 0.0;
    private double value = 0.0;

    public LinearTick()
    {
        startPoint = new Point2D.Double(0, 0);
        stopPoint = new Point2D.Double(1, 1);
    }

    private void calc()
    {

    }

    public void setStartPoint(Point2D.Double aDouble)
    {
        startPoint = aDouble;
    }

    public void setStopPoint(Point2D.Double aDouble)
    {
        stopPoint = aDouble;
    }

    public Point2D.Double getStartPoint()
    {
        return startPoint;
    }

    public Point2D.Double getStopPoint()
    {
        return stopPoint;
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

    public Point2D getTextPoint()
    {
        return textPoint;
    }

    public void setTextPoint(Point2D textPoint)
    {
        this.textPoint = textPoint;
    }

}
