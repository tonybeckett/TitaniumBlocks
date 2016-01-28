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
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;

import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;

/**
 *
 * @author tbeckett
 */
public class CompassPointer extends BasicPointer
{

    final float[] gradientFractionArray = new float[]
    {
        0.0f,
        0.4999f,
        0.5f,
        1.0f
    };

    public CompassPointer()
    {
        this(new PureRed());
    }

    public CompassPointer(GradientPalette pointColor)
    {
        super(pointColor);
    }

    @Override
    protected GeneralPath getShape(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final GeneralPath pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);

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
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        final int imageWidth = IMAGE.getWidth();
//        final int imageHeight = IMAGE.getHeight();

//        switch (getPointerType())
//        {
//            case TYPE2:
//                final GeneralPath NORTHPOINTER2 = new GeneralPath();
//                NORTHPOINTER2.setWindingRule(Path2D.WIND_EVEN_ODD);
//                NORTHPOINTER2.moveTo(imageWidth * 0.5327102803738317, imageHeight * 0.4532710280373832);
//                NORTHPOINTER2.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.4532710280373832, imageWidth * 0.5, imageHeight * 0.14953271028037382, imageWidth * 0.5, imageHeight * 0.14953271028037382);
//                NORTHPOINTER2.curveTo(imageWidth * 0.5, imageHeight * 0.14953271028037382, imageWidth * 0.4672897196261682, imageHeight * 0.4532710280373832, imageWidth * 0.4672897196261682, imageHeight * 0.4532710280373832);
//                NORTHPOINTER2.curveTo(imageWidth * 0.4532710280373832, imageHeight * 0.46261682242990654, imageWidth * 0.4439252336448598, imageHeight * 0.48130841121495327, imageWidth * 0.4439252336448598, imageHeight * 0.5);
//                NORTHPOINTER2.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5, imageWidth * 0.5560747663551402, imageHeight * 0.5, imageWidth * 0.5560747663551402, imageHeight * 0.5);
//                NORTHPOINTER2.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.48130841121495327, imageWidth * 0.5467289719626168, imageHeight * 0.46261682242990654, imageWidth * 0.5327102803738317, imageHeight * 0.4532710280373832);
//                NORTHPOINTER2.closePath();
//                final Point2D NORTHPOINTER2_START = new Point2D.Double(NORTHPOINTER2.getBounds2D().getMinX(), 0);
//                final Point2D NORTHPOINTER2_STOP = new Point2D.Double(NORTHPOINTER2.getBounds2D().getMaxX(), 0);
//                final float[] NORTHPOINTER2_FRACTIONS =
//                {
//                    0.0f,
//                    0.4999f,
//                    0.5f,
//                    1.0f
//                };
//                final Color[] NORTHPOINTER2_COLORS =
//                {
//                    getPointerColor().LIGHT,
//                    getPointerColor().LIGHT,
//                    getPointerColor().MEDIUM,
//                    getPointerColor().MEDIUM
//                };
//                final java.awt.LinearGradientPaint NORTHPOINTER2_GRADIENT = new java.awt.LinearGradientPaint(NORTHPOINTER2_START, NORTHPOINTER2_STOP, NORTHPOINTER2_FRACTIONS, NORTHPOINTER2_COLORS);
//                graphics.setPaint(NORTHPOINTER2_GRADIENT);
//                graphics.fill(NORTHPOINTER2);
//                graphics.setColor(getPointerColor().DARK);
//                graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
//                graphics.draw(NORTHPOINTER2);
//
//                final GeneralPath SOUTHPOINTER2 = new GeneralPath();
//                SOUTHPOINTER2.setWindingRule(Path2D.WIND_EVEN_ODD);
//                SOUTHPOINTER2.moveTo(imageWidth * 0.4672897196261682, imageHeight * 0.5467289719626168);
//                SOUTHPOINTER2.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.5467289719626168, imageWidth * 0.5, imageHeight * 0.8504672897196262, imageWidth * 0.5, imageHeight * 0.8504672897196262);
//                SOUTHPOINTER2.curveTo(imageWidth * 0.5, imageHeight * 0.8504672897196262, imageWidth * 0.5327102803738317, imageHeight * 0.5467289719626168, imageWidth * 0.5327102803738317, imageHeight * 0.5467289719626168);
//                SOUTHPOINTER2.curveTo(imageWidth * 0.5467289719626168, imageHeight * 0.5373831775700935, imageWidth * 0.5560747663551402, imageHeight * 0.5186915887850467, imageWidth * 0.5560747663551402, imageHeight * 0.5);
//                SOUTHPOINTER2.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.5, imageWidth * 0.4439252336448598, imageHeight * 0.5, imageWidth * 0.4439252336448598, imageHeight * 0.5);
//                SOUTHPOINTER2.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5186915887850467, imageWidth * 0.4532710280373832, imageHeight * 0.5373831775700935, imageWidth * 0.4672897196261682, imageHeight * 0.5467289719626168);
//                SOUTHPOINTER2.closePath();
//                final Point2D SOUTHPOINTER2_START = new Point2D.Double(SOUTHPOINTER2.getBounds2D().getMinX(), 0);
//                final Point2D SOUTHPOINTER2_STOP = new Point2D.Double(SOUTHPOINTER2.getBounds2D().getMaxX(), 0);
//                final float[] SOUTHPOINTER2_FRACTIONS =
//                {
//                    0.0f,
//                    0.48f,
//                    0.48009998f,
//                    1.0f
//                };
//                final Color[] SOUTHPOINTER2_COLORS =
//                {
//                    new Color(227, 229, 232, 255),
//                    new Color(227, 229, 232, 255),
//                    new Color(171, 177, 184, 255),
//                    new Color(171, 177, 184, 255)
//                };
//                final java.awt.LinearGradientPaint SOUTHPOINTER2_GRADIENT = new java.awt.LinearGradientPaint(SOUTHPOINTER2_START, SOUTHPOINTER2_STOP, SOUTHPOINTER2_FRACTIONS, SOUTHPOINTER2_COLORS);
//                graphics.setPaint(SOUTHPOINTER2_GRADIENT);
//                graphics.fill(SOUTHPOINTER2);
//                graphics.setColor(new Color(0xABB1B8));
//                graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
//                graphics.draw(SOUTHPOINTER2);
//                break;
//
//            case TYPE3:
//                final GeneralPath NORTHPOINTER3 = new GeneralPath();
//                NORTHPOINTER3.setWindingRule(Path2D.WIND_EVEN_ODD);
//                NORTHPOINTER3.moveTo(imageWidth * 0.5, imageHeight * 0.14953271028037382);
//                NORTHPOINTER3.curveTo(imageWidth * 0.5, imageHeight * 0.14953271028037382, imageWidth * 0.4439252336448598, imageHeight * 0.49065420560747663, imageWidth * 0.4439252336448598, imageHeight * 0.5);
//                NORTHPOINTER3.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5327102803738317, imageWidth * 0.4672897196261682, imageHeight * 0.5560747663551402, imageWidth * 0.5, imageHeight * 0.5560747663551402);
//                NORTHPOINTER3.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.5560747663551402, imageWidth * 0.5560747663551402, imageHeight * 0.5327102803738317, imageWidth * 0.5560747663551402, imageHeight * 0.5);
//                NORTHPOINTER3.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.49065420560747663, imageWidth * 0.5, imageHeight * 0.14953271028037382, imageWidth * 0.5, imageHeight * 0.14953271028037382);
//                NORTHPOINTER3.closePath();
//                final Point2D NORTHPOINTER3_START = new Point2D.Double(NORTHPOINTER3.getBounds2D().getMinX(), 0);
//                final Point2D NORTHPOINTER3_STOP = new Point2D.Double(NORTHPOINTER3.getBounds2D().getMaxX(), 0);
//                final float[] NORTHPOINTER3_FRACTIONS =
//                {
//                    0.0f,
//                    0.4999f,
//                    0.5f,
//                    1.0f
//                };
//                final Color[] NORTHPOINTER3_COLORS =
//                {
//                    getPointerColor().LIGHT,
//                    getPointerColor().LIGHT,
//                    getPointerColor().MEDIUM,
//                    getPointerColor().MEDIUM
//                };
//                final java.awt.LinearGradientPaint NORTHPOINTER3_GRADIENT = new java.awt.LinearGradientPaint(NORTHPOINTER3_START, NORTHPOINTER3_STOP, NORTHPOINTER3_FRACTIONS, NORTHPOINTER3_COLORS);
//                graphics.setPaint(NORTHPOINTER3_GRADIENT);
//                graphics.fill(NORTHPOINTER3);
//                break;
//
//            case TYPE1:
//            default:
        float magnitude = 1.0f - this.getRadiusPercent();

        final GeneralPath NORTHPOINTER1 = new GeneralPath();
        NORTHPOINTER1.setWindingRule(Path2D.WIND_EVEN_ODD);
        NORTHPOINTER1.moveTo(imageWidth * 0.5, imageHeight * 0.4953271028037383);
        NORTHPOINTER1.lineTo(imageWidth * 0.5280373831775701, imageHeight * 0.4953271028037383);
        NORTHPOINTER1.lineTo(imageWidth * 0.5, imageHeight * 0.03 * getRadiusPercent());
        NORTHPOINTER1.lineTo(imageWidth * 0.4719626168224299, imageHeight * 0.4953271028037383);
        NORTHPOINTER1.lineTo(imageWidth * 0.5, imageHeight * 0.4953271028037383);
        NORTHPOINTER1.closePath();

        final Point2D NORTHPOINTER1_START = new Point2D.Double(NORTHPOINTER1.getBounds2D().getMinX(), 0);
        final Point2D NORTHPOINTER1_STOP = new Point2D.Double(NORTHPOINTER1.getBounds2D().getMaxX(), 0);
        final float[] NORTHPOINTER1_FRACTIONS =
        {
            0.0f,
            0.4999f,
            0.5f,
            1.0f
        };
        final Color[] NORTHPOINTER1_COLORS =
        {
            getPointerColor().getLight(),
            getPointerColor().getLight(),
            getPointerColor().getMedium(),
            getPointerColor().getMedium()
        };
        final java.awt.LinearGradientPaint NORTHPOINTER1_GRADIENT = new java.awt.LinearGradientPaint(NORTHPOINTER1_START, NORTHPOINTER1_STOP, NORTHPOINTER1_FRACTIONS, NORTHPOINTER1_COLORS);
        graphics.setPaint(NORTHPOINTER1_GRADIENT);
        graphics.fill(NORTHPOINTER1);
        graphics.setColor(getPointerColor().getDark());
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(NORTHPOINTER1);

        final GeneralPath SOUTHPOINTER1 = new GeneralPath();
        SOUTHPOINTER1.setWindingRule(Path2D.WIND_EVEN_ODD);
        SOUTHPOINTER1.moveTo(imageWidth * 0.5, imageHeight * 0.5046728971962616);
        SOUTHPOINTER1.lineTo(imageWidth * 0.4719626168224299, imageHeight * 0.5046728971962616);
        SOUTHPOINTER1.lineTo(imageWidth * 0.5, imageHeight * (1.0 - (0.03 * getRadiusPercent())));
        SOUTHPOINTER1.lineTo(imageWidth * 0.5280373831775701, imageHeight * 0.5046728971962616);
        SOUTHPOINTER1.lineTo(imageWidth * 0.5, imageHeight * 0.5046728971962616);
        SOUTHPOINTER1.closePath();

        final Point2D SOUTHPOINTER1_START = new Point2D.Double(SOUTHPOINTER1.getBounds2D().getMinX(), 0);
        final Point2D SOUTHPOINTER1_STOP = new Point2D.Double(SOUTHPOINTER1.getBounds2D().getMaxX(), 0);
        final float[] SOUTHPOINTER1_FRACTIONS =
        {
            0.0f,
            0.4999f,
            0.5f,
            1.0f
        };
        final Color[] SOUTHPOINTER1_COLORS =
        {
            new Color(227, 229, 232, 255),
            new Color(227, 229, 232, 255),
            new Color(171, 177, 184, 255),
            new Color(171, 177, 184, 255)
        };
        final java.awt.LinearGradientPaint SOUTHPOINTER1_GRADIENT = new java.awt.LinearGradientPaint(SOUTHPOINTER1_START, SOUTHPOINTER1_STOP, SOUTHPOINTER1_FRACTIONS, SOUTHPOINTER1_COLORS);
        graphics.setPaint(SOUTHPOINTER1_GRADIENT);
        graphics.fill(SOUTHPOINTER1);
        final Color STROKE_COLOR_SOUTHPOINTER1 = new Color(0xABB1B8);
        graphics.setColor(STROKE_COLOR_SOUTHPOINTER1);
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(SOUTHPOINTER1);
//                break;
//        }

        graphics.dispose();

    }
}
