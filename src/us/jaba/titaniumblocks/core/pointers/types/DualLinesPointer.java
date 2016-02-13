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
import java.awt.Shape;
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
public class DualLinesPointer extends GradientPointer
{

    private final static float[] gradientFractionArray = new float[]
    {
        0.0f,
        0.25f,
        0.75f,
        1.0f
    };

    public DualLinesPointer()
    {
    }

    public DualLinesPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
    }

    @Override
    protected Shape getShape(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final GeneralPath pointerShape = new GeneralPath();
        float magnitude = 1.0f - this.getRadiusPercent();

        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(imageWidth * 0.481308, imageHeight * 0.485981);
        pointerShape.lineTo(imageWidth * 0.481308, imageHeight * 0.392523);
        pointerShape.lineTo(imageWidth * 0.485981, imageHeight * 2.0 * magnitude);
        pointerShape.lineTo(imageWidth * 0.495327, imageHeight * magnitude);
        pointerShape.lineTo(imageWidth * 0.50467, imageHeight * magnitude);
        pointerShape.lineTo(imageWidth * 0.514018, imageHeight * 2.0 * magnitude);
        pointerShape.lineTo(imageWidth * 0.518691, imageHeight * 0.38785);
        pointerShape.lineTo(imageWidth * 0.518691, imageHeight * 0.485981);
        pointerShape.lineTo(imageWidth * 0.50467, imageHeight * 0.485981);
        pointerShape.lineTo(imageWidth * 0.50467, imageHeight * 0.38785);
        pointerShape.lineTo(imageWidth * 0.5, imageHeight * 2.0 * magnitude);
        pointerShape.lineTo(imageWidth * 0.495327, imageHeight * 0.392523);
        pointerShape.lineTo(imageWidth * 0.495327, imageHeight * 0.485981);
        pointerShape.lineTo(imageWidth * 0.481308, imageHeight * 0.485981);
        pointerShape.closePath();

        return pointerShape;
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
//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();

        final Shape pointerShape = getShape(dimensions);
        final Point2D startPoint;
        final Point2D stopPoint;
        
        final Color[] gradientColorArray;
        final java.awt.Paint gradient;
//        float magnitude = 1.0f - this.getRadiusPercent();
//
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        pointerShape.moveTo(imageWidth * 0.48130841121495327, imageHeight * 0.48598130841121495);
//        pointerShape.lineTo(imageWidth * 0.48130841121495327, imageHeight * 0.3925233644859813);
//        pointerShape.lineTo(imageWidth * 0.48598130841121495, imageHeight * 2.0 * magnitude);//0.3177570093457944);
//        pointerShape.lineTo(imageWidth * 0.4953271028037383, imageHeight * magnitude);//0.1308411214953271);
//        pointerShape.lineTo(imageWidth * 0.5046728971962616, imageHeight * magnitude);//0.1308411214953271);
//        pointerShape.lineTo(imageWidth * 0.514018691588785, imageHeight * 2.0 * magnitude);//0.3177570093457944);
//        pointerShape.lineTo(imageWidth * 0.5186915887850467, imageHeight * 0.3878504672897196);
//        pointerShape.lineTo(imageWidth * 0.5186915887850467, imageHeight * 0.48598130841121495);
//        pointerShape.lineTo(imageWidth * 0.5046728971962616, imageHeight * 0.48598130841121495);
//        pointerShape.lineTo(imageWidth * 0.5046728971962616, imageHeight * 0.3878504672897196);
//        pointerShape.lineTo(imageWidth * 0.5, imageHeight * 2.0 * magnitude);//0.3177570093457944);
//        pointerShape.lineTo(imageWidth * 0.4953271028037383, imageHeight * 0.3925233644859813);
//        pointerShape.lineTo(imageWidth * 0.4953271028037383, imageHeight * 0.48598130841121495);
//        pointerShape.lineTo(imageWidth * 0.48130841121495327, imageHeight * 0.48598130841121495);
//        pointerShape.closePath();
        startPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxY(), 0);
        stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMinY(), 0);
//        gradientFractionArray = new float[]
//        {
//            0.0f,
//            0.25f,
//            0.75f,
//            1.0f
//        };
//
        gradientColorArray = new Color[]
        {
            getPointerColor().getMediumLight(),
            getPointerColor().getMediumDark(),
            getPointerColor().getMediumDark(),
            getPointerColor().getMediumLight()
        };

        if (PointSupport.pointsEqual(startPoint, stopPoint))
        {
            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
        }
        gradient = new LinearGradientPaint(startPoint, stopPoint, gradientFractionArray, gradientColorArray);
        graphics.setPaint(gradient);
        graphics.fill(pointerShape);

        graphics.setColor(getPointerColor().getDark());

        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(pointerShape);

        graphics.dispose();
    }
}
