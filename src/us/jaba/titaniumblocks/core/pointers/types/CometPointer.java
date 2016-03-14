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
import us.jaba.titaniumblocks.core.color.GradientPalette;

import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class CometPointer extends GradientPointer
{


    public CometPointer()
    {
    }

    public CometPointer(GradientPalette pointColor)
    {
        super(pointColor);
    }

    public CometPointer(GradientPointer other)
    {
        super(other);
    }

    
    @Override
    protected Area getShape(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        
        final GeneralPath pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
 
        
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight / 2;

        double magnitude = (this.getRadiusPercent() * frontScale.getValue());


        pointerShape.moveTo(imageWidth * 0.5, centerY - (maxY * magnitude)); 

        pointerShape.curveTo(imageWidth * 0.5, centerY - (maxY * magnitude), 
                imageWidth * 0.4439252336448598, imageHeight * 0.49065420560747663,
                imageWidth * 0.4439252336448598, imageHeight * 0.5);

        pointerShape.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5327102803738317,
                imageWidth * 0.4672897196261682, imageHeight * 0.5560747663551402,
                imageWidth * 0.5, imageHeight * 0.5560747663551402);

        pointerShape.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.5560747663551402,
                imageWidth * 0.5560747663551402, imageHeight * 0.5327102803738317,
                imageWidth * 0.5560747663551402, imageHeight * 0.5);

        pointerShape.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.49065420560747663,
                imageWidth * 0.5, centerY - (maxY * magnitude), 
                imageWidth * 0.5, centerY - (maxY * magnitude)); 

        pointerShape.closePath();
        
        return new Area(pointerShape);
    }
    
//    @Override
//    public void paint(Graphics2D graphics, Dimension dimensions)
//    {
//
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
//
//        final GeneralPath pointerShape;
//        final Point2D startPoint;
//        final Point2D stopPoint;
//
//        final Color[] gradientColorArray;
//        final java.awt.Paint gradient;
//
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        float radiusAdj = 1.0f - this.getRadiusPercent();
//
//        Point2D tip = new Point2D.Double(0.5, radiusAdj);//0.14953);
//
//        pointerShape.moveTo(imageWidth * 0.5, imageHeight * radiusAdj);//0.14953271028037382);
//
//        pointerShape.curveTo(imageWidth * 0.5, imageHeight * radiusAdj,//0.14953271028037382,
//                imageWidth * 0.4439252336448598, imageHeight * 0.49065420560747663,
//                imageWidth * 0.4439252336448598, imageHeight * 0.5);
//
//        pointerShape.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5327102803738317,
//                imageWidth * 0.4672897196261682, imageHeight * 0.5560747663551402,
//                imageWidth * 0.5, imageHeight * 0.5560747663551402);
//
//        pointerShape.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.5560747663551402,
//                imageWidth * 0.5560747663551402, imageHeight * 0.5327102803738317,
//                imageWidth * 0.5560747663551402, imageHeight * 0.5);
//
//        pointerShape.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.49065420560747663,
//                imageWidth * 0.5, imageHeight * radiusAdj,//0.14953271028037382,
//                imageWidth * 0.5, imageHeight * radiusAdj);//0.14953271028037382);
//
//        pointerShape.closePath();
//        startPoint = new Point2D.Double(pointerShape.getBounds2D().getMinX(), 0);
//        stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxX(), 0);
//
//        gradientColorArray = new Color[]
//        {
//            this.getPointerColor().getMediumLight(),
//            this.getPointerColor().getMediumLight(),
//            this.getPointerColor().getMediumDark(),
//            this.getPointerColor().getMediumDark()
//        };
//
//        if (PointSupport.pointsEqual(startPoint, stopPoint))
//        {
//            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
//        }
//        gradient = new LinearGradientPaint(startPoint, stopPoint, gradientFractionArray, gradientColorArray);
//        graphics.setPaint(gradient);
//        graphics.fill(pointerShape);
//        graphics.setColor(this.getPointerColor().getMediumDark());
//        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
//        graphics.draw(pointerShape);
//
//        graphics.dispose();
//    }
}
