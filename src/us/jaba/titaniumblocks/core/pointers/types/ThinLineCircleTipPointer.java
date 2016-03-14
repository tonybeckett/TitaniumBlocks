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
package us.jaba.titaniumblocks.core.pointers.types;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class ThinLineCircleTipPointer extends GradientPointer
{

    private BasicStroke stroke;

    public ThinLineCircleTipPointer()
    {
        this(new PureRed());
    }

    public ThinLineCircleTipPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        this.tailScale = new Scale(0.3);
        stroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

    }

    public ThinLineCircleTipPointer(GradientPointer other)
    {
        super(other);
    }

    @Override
    protected Area getShape(Dimension dimensions)
    {

        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxX = dimensions.getWidth() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        double frontM = this.getRadiusPercent() * frontScale.getValue();
        double tailM = this.getRadiusPercent() * tailScale.getValue();

        Area pointerLine = new Area(new Rectangle2D.Double(centerX - (maxX * 0.0045), centerY - (maxY * frontM),
                2.0 * (maxX * 0.0045), (maxY * frontM) + (maxY * tailM)));

//        if (centerPostVisible)
//        {
//            double radius = dimensions.width * centerScale.getValue();
//            Area pointerPost = new Area(new Ellipse2D.Double((dimensions.getWidth() / 2.0) - radius, (dimensions.getHeight() / 2.0) - radius, radius * 2, radius * 2));
//            pointerLine.add(pointerPost);
//        }

        return pointerLine;
    }

    @Override
    protected void paintShape(Graphics2D graphics, Dimension dimensions, Area shape, Color[] gradientColorArray)
    {
        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxX = dimensions.getWidth() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        double frontM = this.getRadiusPercent() * frontScale.getValue();

        super.paintShape(graphics, dimensions, shape, gradientColorArray);

        graphics.setStroke(stroke);
        ShapeUtils.drawCircle(graphics, centerX, centerY - (maxY * frontM) - (maxX * 0.025), maxX * 0.025);

    }
//  
}
