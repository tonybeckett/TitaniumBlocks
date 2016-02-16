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
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Aluminum;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class LineCircleWithFanTailPointer extends GradientPointer
{

    public LineCircleWithFanTailPointer()
    {
        super(new Aluminum());
        tailScale = new Scale(0.3);
    }

    public LineCircleWithFanTailPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        tailScale = new Scale(0.3);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        GeneralPath pointerShape;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        graphics.setColor(this.getPointerColor().getDarkest());

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        double magnitude = (1.0f - this.getRadiusPercent()) * frontScale.getValue();
        int fanOffset = (int) (imageWidth * 0.02066);
        
        pointerShape = new GeneralPath(new Rectangle2D.Double((imageWidth * 0.49532), (imageHeight * magnitude),
                (imageWidth * 0.00934), imageHeight * 0.525)
        );
        pointerShape.moveTo(imageWidth * 0.5 + 1, imageHeight * 0.525);
        pointerShape.lineTo((imageWidth * 0.5) + fanOffset, imageHeight * (0.525 + (0.5 * tailScale.getValue())));
        pointerShape.lineTo((imageWidth * 0.5) - fanOffset, imageHeight * (0.525 + (0.5 * tailScale.getValue())));
        pointerShape.lineTo((imageWidth * 0.5 - 1), imageHeight * 0.525);

        pointerShape.closePath();
        graphics.fill(pointerShape);

        int circleSize = (int) (imageWidth * 0.033);
        Ellipse2D shape = new Ellipse2D.Double(imageWidth * 0.5-(circleSize/2) , imageHeight *  magnitude +10, circleSize , circleSize  );
        graphics.fill(shape);

        if ( this.centerPinVisible)
        {
            graphics.setColor(ColorPalette.ALUMINIUM);
            int pinSize = (int) Math.min( (imageWidth * 0.0085), 2);
            ShapeUtils.fillCircle(graphics, imageWidth/2, imageHeight/2, pinSize);
         
        }
        
        graphics.dispose();
    }
}
