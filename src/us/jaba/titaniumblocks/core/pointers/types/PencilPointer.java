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
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class PencilPointer extends GradientPointer
{

    @Override
    protected Area getShape(Dimension dimensions)
    {

//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
//        final int centerY = imageHeight / 2;
//        final int maxY = imageHeight / 2;
//        double magnitude = this.getRadiusPercent() * frontScale.getValue();
//        
//        GeneralPath pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        pointerShape.moveTo(0.4859 * imageWidth, centerY - (maxY * 0.86 * magnitude));
//        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * 0.92 * magnitude));
//        pointerShape.lineTo(0.5141 * imageWidth, centerY - (maxY * 0.86 * magnitude));
//        pointerShape.lineTo(0.5141 * imageWidth, 0.509 * imageHeight);
//        pointerShape.lineTo(0.4859 * imageWidth, 0.509 * imageHeight);
//        pointerShape.lineTo(0.4859 * imageWidth, centerY - (maxY * 0.86 * magnitude));
//        pointerShape.closePath();
//
//        Area pointerLine = new Area(pointerShape);
//
//        double radius = dimensions.width * centerScale.getValue();
//        Area pointerPost = new Area(new Ellipse2D.Double((imageWidth / 2) - radius, (imageHeight / 2) - radius, radius * 2, radius * 2));
//        pointerLine.add(pointerPost);
//        // pointerLine.setWindingRule(Path2D.WIND_EVEN_ODD);
//        return pointerLine;
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight / 2;
        double magnitude = this.getRadiusPercent() * frontScale.getValue();
        final GeneralPath pointerShape;

        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(0.48598130841121495 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * 0.94 * magnitude));
        pointerShape.lineTo(0.5093457943925234 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.lineTo(0.5093457943925234 * imageWidth, 0.5093457943925234 * imageHeight);
        pointerShape.lineTo(0.48598130841121495 * imageWidth, 0.5093457943925234 * imageHeight);
        pointerShape.lineTo(0.48598130841121495 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.closePath();

//        graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0.5 * imageWidth, 0.5 * imageHeight), new Point2D.Double(0.5 * imageWidth, 0.1308411214953271 * imageHeight), new float[]
//        {
//            0.0f, 0.849999f, 0.85f, 1.0f
//        }, new Color[]
//        {
//            this.getPrimaryColor().getLight(), this.getPrimaryColor().getMedium(), this.getSecondaryColor().getMediumDark(), getSecondaryColor().getMediumDark()
//        }));
//        
        return new Area(pointerShape);

    }

}
