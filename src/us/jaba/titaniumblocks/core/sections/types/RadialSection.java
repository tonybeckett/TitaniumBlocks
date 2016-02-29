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
package us.jaba.titaniumblocks.core.sections.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.sections.ColorSection;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class RadialSection extends ColorSection
{

    private double startAngle;
    private double stopAngle;
    private double innerRadius;
    private double outerRadius;

    public RadialSection(double startAngle, double stopAngle, Color color, double innerRadius, double outerRadius)
    {
        super(color);
        this.startAngle = startAngle;
        this.stopAngle = stopAngle;

        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public double getStartAngle()
    {
        return startAngle;
    }

    public void setStartAngle(double startAngle)
    {
        this.startAngle = startAngle;
    }

    public double getStopAngle()
    {
        return stopAngle;
    }

    public void setStopAngle(double stopAngle)
    {
        this.stopAngle = stopAngle;
    }

    public double getInnerRadius()
    {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius)
    {
        this.innerRadius = innerRadius;
    }

    public double getOuterRadius()
    {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius)
    {
        this.outerRadius = outerRadius;
    }

    @Override
    protected void paintSection(Graphics2D graphics, Dimension dimensions)
    {
        super.paintSection(graphics, dimensions);

        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        Point2D.Double center = new Point2D.Double(centerX, centerY);

        graphics.setColor(this.getColor());
        ShapeUtils.placeArcOnRadius(graphics, center, innerRadius, outerRadius, this.getStartAngle(), this.getStopAngle(), 0, 1);
    }

}
