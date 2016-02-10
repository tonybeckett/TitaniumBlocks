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

import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class LinePointer extends GradientPointer
{

    public LinePointer()
    {
        this(new PureRed());
    }

    public LinePointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        this.tailScale = 0.03f;
    }

    @Override
    protected Shape getShape(Dimension dimensions)
    {

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight / 2;
        float magnitude = this.getRadiusPercent() * frontScale;

        Area pointerLine = new Area(new Rectangle2D.Double(imageWidth * 0.495327, centerY - (maxY * tailScale)/*- (maxY * 0.94 * magnitude)*/,
                imageWidth * 0.009345, imageHeight * /* 0.599 */ magnitude ));

        if (centerPostVisible)
        {
            double radius = dimensions.width * centerScale;
            Area pointerPost = new Area(new Ellipse2D.Double((imageWidth / 2) - radius, (imageHeight / 2) - radius, radius * 2, radius * 2));
            pointerLine.add(pointerPost);
        }

       
       
        return pointerLine;
    }

//  
}
