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
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Aluminum;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TaperedRoundedTailPointer extends GradientPointer
{

    public TaperedRoundedTailPointer()
    {
        this( new Aluminum());
        
    }

    public TaperedRoundedTailPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        tailScale = new Scale(0.3);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath pointerShape;
        
        final java.awt.Paint gradient;
        double magnitude = (1.0f - this.getRadiusPercent()) * frontScale.getValue();
        float tailOffset = (float) (0.5 * tailScale.getValue());
                
        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(0.5 * imageWidth, magnitude  * imageHeight);
        pointerShape.lineTo(0.4859813  * imageWidth, imageHeight * (0.5 + tailOffset));
        
        pointerShape.curveTo(0.4859813 * imageWidth, imageHeight * (0.5 + tailOffset),
                0.4813084  * imageWidth, imageHeight * (0.584112 + tailOffset),
                0.5 * imageWidth, imageHeight * (0.584112 + tailOffset));
        
        pointerShape.curveTo(0.5  * imageWidth, imageHeight * (0.584112 + tailOffset),
                0.5193454 * imageWidth, imageHeight * (0.584112 + tailOffset),
                0.5153454 * imageWidth, imageHeight * (0.5 + tailOffset));
        
        pointerShape.lineTo(0.5 * imageWidth, magnitude  * imageHeight);
        pointerShape.closePath();

        if (PointSupport.pointsEquals(0d, pointerShape.getBounds2D().getMinY(), 0d, pointerShape.getBounds2D().getMaxY()))
        {
            gradient = new LinearGradientPaint(new Point2D.Double(0, pointerShape.getBounds2D().getMinY()), new Point2D.Double(0, pointerShape.getBounds2D().getMaxY() + 1), new float[]
            {
                0.0f, 1.0f
            }, new Color[]
            {
                this.getPointerColor().getMediumDark(), this.getPointerColor().getDark()
            });
        } else
        {
            gradient = new LinearGradientPaint(new Point2D.Double(0, pointerShape.getBounds2D().getMinY()), new Point2D.Double(0, pointerShape.getBounds2D().getMaxY()), new float[]
            {
                0.0f, 1.0f
            }, new Color[]
            {
                this.getPointerColor().getMediumDark(), this.getPointerColor().getDark()
            });
        }
        graphics.setPaint(gradient);
        graphics.fill(pointerShape);
        graphics.setColor(this.getPointerColor().getDark());
//        
        graphics.setStroke(new BasicStroke(0.004672f * imageWidth, 0, 1));
        graphics.draw(pointerShape);

        graphics.dispose();
    }
}
