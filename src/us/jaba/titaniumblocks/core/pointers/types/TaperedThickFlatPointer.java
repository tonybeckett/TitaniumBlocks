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
public class TaperedThickFlatPointer extends GradientPointer
{

//    private final float[] fractionArray = new float[]
//    {
//        0.0f,
//        0.001f,
//        0.5f,
//        0.998f,
//        1.0f
//    };

    public TaperedThickFlatPointer()
    {
        this(new Aluminum());
    }

    public TaperedThickFlatPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        tailScale = new Scale(0.3);
        centerScale = new Scale(0.018);
    }

    public TaperedThickFlatPointer(GradientPointer other)
    {
        super(other);
    }
    
    
    @Override
    protected Area getShape(Dimension dimensions)
    {

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath pointerShape;
        final Point2D startPoint;
        final Point2D stopPoint;

      
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight / 2;

        double magnitude = (this.getRadiusPercent() * frontScale.getValue());

        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(imageWidth * 0.490654, centerY - (maxY * magnitude));
        pointerShape.lineTo(imageWidth * 0.481308, centerY + (maxY * tailScale.getValue()));
        pointerShape.lineTo(imageWidth * 0.518691, centerY + (maxY * tailScale.getValue()));
        pointerShape.lineTo(imageWidth * 0.504672, centerY - (maxY * magnitude));
        pointerShape.lineTo(imageWidth * 0.490654, centerY - (maxY * magnitude));
        pointerShape.closePath();
        
        Area area = new Area(pointerShape);
        
        startPoint = new Point2D.Double(pointerShape.getBounds2D().getMinX(), 0);
        stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxX(), 0);

       
        if (PointSupport.pointsEqual(startPoint, stopPoint))
        {
            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
        }
      
//         if (centerPostVisible)
//        {
//            double radius = dimensions.width * centerScale.getValue();
//            Area pointerPost = new Area(new Ellipse2D.Double((dimensions.getWidth() / 2.0) - radius, (dimensions.getHeight() / 2.0) - radius, radius * 2, radius * 2));
//            area.add(pointerPost);
//        }
        
       
        return area;
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
//        final int centerY = imageHeight / 2;
//        final int maxY = imageHeight / 2;
//
//        double magnitude = (this.getRadiusPercent() * frontScale.getValue());
//
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        pointerShape.moveTo(imageWidth * 0.490654, centerY - (maxY * magnitude));
//        pointerShape.lineTo(imageWidth * 0.481308, centerY + (maxY * tailScale.getValue()));
//        pointerShape.lineTo(imageWidth * 0.518691, centerY + (maxY * tailScale.getValue()));
//        pointerShape.lineTo(imageWidth * 0.504672, centerY - (maxY * magnitude));
//        pointerShape.lineTo(imageWidth * 0.490654, centerY - (maxY * magnitude));
//        pointerShape.closePath();
//        startPoint = new Point2D.Double(pointerShape.getBounds2D().getMinX(), 0);
//        stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxX(), 0);
//
//        gradientColorArray = new Color[]
//        {
//            this.getPointerColor().getMedium(),
//            this.getPointerColor().getMedium(),
//            this.getPointerColor().getMedium(),
//            this.getPointerColor().getMedium(),
//            this.getPointerColor().getMedium()
//        };
//
//        if (PointSupport.pointsEqual(startPoint, stopPoint))
//        {
//            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
//        }
//        gradient = new LinearGradientPaint(startPoint, stopPoint, fractionArray, gradientColorArray);
//        graphics.setPaint(gradient);
//        //       graphics.setColor(this.getPointerColor().getMedium());
//        graphics.fill(pointerShape);
//
//        int circleSize = (int) (imageWidth * 0.08);
//        Ellipse2D shape = new Ellipse2D.Double((imageWidth * 0.5) - (circleSize / 2), (imageHeight * 0.5) - (circleSize / 2), circleSize, circleSize);
//
//        graphics.fill(shape);
//
//        graphics.setColor(ColorPalette.STEELGRAY);
//        circleSize = (int) (imageWidth * 0.018);
//        shape = new Ellipse2D.Double((imageWidth * 0.5) - (circleSize / 2), (imageHeight * 0.5) - (circleSize / 2), circleSize, circleSize);
//
//        graphics.fill(shape);
//
//        graphics.dispose();
//    }
}
