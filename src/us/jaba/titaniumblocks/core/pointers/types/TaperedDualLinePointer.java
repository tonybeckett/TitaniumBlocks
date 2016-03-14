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
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TaperedDualLinePointer extends GradientPointer
{

//    private final float[] gradientFractionArray = new float[]
//    {
//        0.0f,
//        0.48f,
//        1.0f
//    };
//    private final Color[] gradientColorArray = new Color[]
//    {
//        new Color(50, 50, 50, 255),
//        new Color(102, 102, 102, 255),
//        new Color(50, 50, 50, 255)
//    };
    public TaperedDualLinePointer()
    {
    }

    public TaperedDualLinePointer(GradientPalette pointerColor)
    {
        super(pointerColor);
    }

    @Override
    protected Area getShape(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final GeneralPath pointerShape = new GeneralPath();

        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        final double frontM = this.getRadiusPercent() * frontScale.getValue();
//        double tailM = this.getRadiusPercent() * tailScale.getValue();

        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);

        pointerShape.moveTo(imageWidth * 0.4953271, centerY - (maxY * frontM * 0.7664));
        pointerShape.lineTo(imageWidth * 0.5046728, centerY - (maxY * frontM * 0.7664));
        pointerShape.lineTo(imageWidth * 0.5140186, imageHeight * 0.4392523);
        pointerShape.lineTo(imageWidth * 0.4859813, imageHeight * 0.4392523);
        pointerShape.lineTo(imageWidth * 0.4953271, centerY - (maxY * frontM * 0.7664));
        pointerShape.closePath();

        pointerShape.moveTo(imageWidth * 0.4906542, centerY - (frontM * maxY * 0.8692));
        pointerShape.lineTo(imageWidth * 0.4719626, imageHeight * 0.47196261);
        pointerShape.lineTo(imageWidth * 0.4719626, imageHeight * 0.52803738);

        pointerShape.curveTo(imageWidth * 0.4719626, imageHeight * 0.52803738,
                imageWidth * 0.4766355, imageHeight * 0.6028037,
                imageWidth * 0.4766355, imageHeight * 0.60280373);

        pointerShape.curveTo(imageWidth * 0.47663551, imageHeight * 0.6074766,
                imageWidth * 0.48130841, imageHeight * 0.6074766,
                imageWidth * 0.5, imageHeight * 0.60747663);

        pointerShape.curveTo(imageWidth * 0.51869158, imageHeight * 0.6074766,
                imageWidth * 0.52336448, imageHeight * 0.60747663,
                imageWidth * 0.5233644, imageHeight * 0.6028037);

        pointerShape.curveTo(imageWidth * 0.52336448, imageHeight * 0.6028037,
                imageWidth * 0.52803738, imageHeight * 0.52803738,
                imageWidth * 0.52803738, imageHeight * 0.5280373);

        pointerShape.lineTo(imageWidth * 0.528037383, imageHeight * 0.4719626);

        pointerShape.lineTo(imageWidth * 0.509345794, centerY - (frontM * maxY * 0.8692));
        pointerShape.lineTo(imageWidth * 0.490654205, centerY - (frontM * maxY * 0.8692));
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
//        final java.awt.Paint gradient;
//        final double centerY = dimensions.getHeight() / 2.0;
//        final double maxY = dimensions.getHeight() / 2.0;
//        double frontM = this.getRadiusPercent() * frontScale.getValue();
////        double tailM = this.getRadiusPercent() * tailScale.getValue();
//
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//
//        pointerShape.moveTo(imageWidth * 0.4953271, centerY - (maxY * frontM));//* 0.7664);
//        pointerShape.lineTo(imageWidth * 0.5046728, centerY - (maxY * frontM));//* 0.7664);
//        pointerShape.lineTo(imageWidth * 0.5140186, imageHeight * 0.4392523);
//        pointerShape.lineTo(imageWidth * 0.4859813, imageHeight * 0.4392523);
//        pointerShape.lineTo(imageWidth * 0.4953271, centerY - (maxY * frontM));//* 0.7664);
//        pointerShape.closePath();
//
//        pointerShape.moveTo(imageWidth * 0.4906542, centerY - (frontM * maxY * 0.8692));
//        pointerShape.lineTo(imageWidth * 0.4719626, imageHeight * 0.47196261);
//        pointerShape.lineTo(imageWidth * 0.4719626, imageHeight * 0.52803738);
//
//        pointerShape.curveTo(imageWidth * 0.4719626, imageHeight * 0.52803738,
//                imageWidth * 0.4766355, imageHeight * 0.6028037,
//                imageWidth * 0.4766355, imageHeight * 0.60280373);
//
//        pointerShape.curveTo(imageWidth * 0.47663551, imageHeight * 0.6074766,
//                imageWidth * 0.48130841, imageHeight * 0.6074766,
//                imageWidth * 0.5, imageHeight * 0.60747663);
//
//        pointerShape.curveTo(imageWidth * 0.51869158, imageHeight * 0.6074766,
//                imageWidth * 0.52336448, imageHeight * 0.60747663,
//                imageWidth * 0.5233644, imageHeight * 0.6028037);
//
//        pointerShape.curveTo(imageWidth * 0.52336448, imageHeight * 0.6028037,
//                imageWidth * 0.52803738, imageHeight * 0.52803738,
//                imageWidth * 0.52803738, imageHeight * 0.5280373);
//
//        pointerShape.lineTo(imageWidth * 0.528037383, imageHeight * 0.4719626);
//
//        pointerShape.lineTo(imageWidth * 0.509345794, centerY - (frontM * maxY * 0.8692));
//        pointerShape.lineTo(imageWidth * 0.490654205, centerY - (frontM * maxY * 0.8692));
//        pointerShape.closePath();
//
//        startPoint = new Point2D.Double(pointerShape.getBounds2D().getMinX(), 0);
//        stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxX(), 0);
//
//        if (PointSupport.pointsEqual(startPoint, stopPoint))
//        {
//            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
//        }
//        gradient = new LinearGradientPaint(startPoint, stopPoint, gradientFractionArray, gradientColorArray);
//        graphics.setPaint(gradient);
//        graphics.fill(pointerShape);
//        graphics.draw(pointerShape);
//
//        graphics.setColor(this.getPrimaryColor().getMedium());
//
//        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
//        graphics.draw(pointerShape);
//
//        final GeneralPath box = new GeneralPath();
//        box.setWindingRule(Path2D.WIND_EVEN_ODD);
//        box.moveTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.78038);
//        box.lineTo(imageWidth * 0.5046728, centerY - frontM * maxY * 0.78038);
//        box.lineTo(imageWidth * 0.5046728, centerY - frontM * maxY * 0.8645);
//        box.lineTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.8645);
//        box.lineTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.78038);
//        box.closePath();
//
//        graphics.setColor(this.getPrimaryColor().getMediumDark());
//
//        graphics.fill(box);
//        graphics.draw(box);
//        graphics.dispose();
//    }
    @Override
    protected Area getSecondShape(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        final double frontM = this.getRadiusPercent() * frontScale.getValue();
//        double tailM = this.getRadiusPercent() * tailScale.getValue();

        final GeneralPath box = new GeneralPath();
        box.setWindingRule(Path2D.WIND_EVEN_ODD);
        box.moveTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.78038);
        box.lineTo(imageWidth * 0.5046728, centerY - frontM * maxY * 0.78038);
        box.lineTo(imageWidth * 0.5046728, centerY - frontM * maxY * 0.8645);
        box.lineTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.8645);
        box.lineTo(imageWidth * 0.4953271, centerY - frontM * maxY * 0.78038);
        box.closePath();

        return new Area(box);
    }
}
