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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.pointers.BasicPointer;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class CircleOrbitPointer extends BasicPointer
{

    private BasicStroke stroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

    ;

    public CircleOrbitPointer()
    {
        this(new PureRed());
    }

    public CircleOrbitPointer(BasicPointer other)
    {
        super(other);
    }

    public CircleOrbitPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        this.tailScale = new Scale(0.3);
        stroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

    }

    

    @Override
    protected Area getShape(Dimension dimensions)
    {
        return new Area();
    }

    @Override
    protected void paintShape(Graphics2D graphics, Dimension dimensions)
    {
        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxX = dimensions.getWidth() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        double frontM = this.getRadiusPercent() * frontScale.getValue();
        
        graphics.setColor(this.getPrimaryColor().getMediumDark());
        graphics.setStroke(stroke);
        ShapeUtils.drawCircle(graphics, centerX, centerY - (maxY * frontM) - (maxX / 4.0 * this.getCenterScale().getValue()), maxX / 4.0 * this.getCenterScale().getValue());

    }
//  
}
