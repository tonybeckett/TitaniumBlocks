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
package us.jaba.titaniumblocks.core.knobs.painter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.knobs.BigKnob;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class BigChromeKnob extends BigKnob
{

    private final float[] CHROMEKNOB_BACKFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] CHROMEKNOB_BACKFRAME_COLORS =
    {
        new Color(129, 139, 140, 255),
        new Color(166, 171, 175, 255)
    };

    private final float[] CHROMEKNOB_BACK_FRACTIONS =
    {
        0.0f,
        0.09f,
        0.12f,
        0.16f,
        0.25f,
        0.29f,
        0.33f,
        0.38f,
        0.48f,
        0.52f,
        0.65f,
        0.69f,
        0.8f,
        0.83f,
        0.87f,
        0.97f,
        1.0f
    };
    private final Color[] CHROMEKNOB_BACK_COLORS =
    {
        new Color(255, 255, 255, 255),
        new Color(255, 255, 255, 255),
        new Color(136, 136, 138, 255),
        new Color(164, 185, 190, 255),
        new Color(158, 179, 182, 255),
        new Color(112, 112, 112, 255),
        new Color(221, 227, 227, 255),
        new Color(155, 176, 179, 255),
        new Color(156, 176, 177, 255),
        new Color(254, 255, 255, 255),
        new Color(255, 255, 255, 255),
        new Color(156, 180, 180, 255),
        new Color(198, 209, 211, 255),
        new Color(246, 248, 247, 255),
        new Color(204, 216, 216, 255),
        new Color(164, 188, 190, 255),
        new Color(255, 255, 255, 255)
    };

    private final float[] CHROMEKNOB_FOREFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] CHROMEKNOB_FOREFRAME_COLORS =
    {
        new Color(225, 235, 232, 255),
        new Color(196, 207, 207, 255)
    };

    private final float[] CHROMEKNOB_FORE_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] CHROMEKNOB_FORE_COLORS =
    {
        new Color(237, 239, 237, 255),
        new Color(148, 161, 161, 255)
    };

    public BigChromeKnob(Color[] backgroundFrameColors, Color[] backgroundColors, Color[] foregroundFrameColors, Color[] foregroundColors)
    {
        super(backgroundFrameColors, backgroundColors, foregroundFrameColors, foregroundColors);
    }

    public BigChromeKnob()
    {
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();

        final double radius = dimensions.getWidth() * 0.5;

        Point2D.Double centerPoint = new Point2D.Double((dimensions.getWidth() / 2.0), (dimensions.getHeight() / 2.0));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.14, getAngle().getValue(), CHROMEKNOB_BACKFRAME_FRACTIONS, CHROMEKNOB_BACKFRAME_COLORS);

//        final Ellipse2D CHROMEKNOB_BACKFRAME = new Ellipse2D.Double(imageWidth * 0.42990654706954956, imageHeight * 0.42990654706954956, imageWidth * 0.14018690586090088, imageHeight * 0.14018690586090088);
//        final Point2D CHROMEKNOB_BACKFRAME_START = new Point2D.Double((0.46261682242990654 * imageWidth), (0.4392523364485981 * imageHeight));
//        final Point2D CHROMEKNOB_BACKFRAME_STOP = new Point2D.Double(((0.46261682242990654 + 0.0718114890783315) * imageWidth), ((0.4392523364485981 + 0.1149224055539082) * imageHeight));
//
//        PointSupport.validateGradientPoints(CHROMEKNOB_BACKFRAME_START, CHROMEKNOB_BACKFRAME_STOP);
//        final LinearGradientPaint CHROMEKNOB_BACKFRAME_GRADIENT = new LinearGradientPaint(CHROMEKNOB_BACKFRAME_START, CHROMEKNOB_BACKFRAME_STOP, CHROMEKNOB_BACKFRAME_FRACTIONS, CHROMEKNOB_BACKFRAME_COLORS);
//        graphics.setPaint(CHROMEKNOB_BACKFRAME_GRADIENT);
//        graphics.fill(CHROMEKNOB_BACKFRAME);

        ShapeUtils.placeCircleUsingCGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.13, getAngle().getValue(), CHROMEKNOB_BACK_FRACTIONS, CHROMEKNOB_BACK_COLORS);

        
//        final Ellipse2D CHROMEKNOB_BACK = new Ellipse2D.Double(imageWidth * 0.43457943201065063, imageHeight * 0.43457943201065063, imageWidth * 0.13084113597869873, imageHeight * 0.13084113597869873);
//        final Point2D CHROMEKNOB_BACK_CENTER = new Point2D.Double(CHROMEKNOB_BACK.getCenterX(), CHROMEKNOB_BACK.getCenterY());
//
//        final ConicalGradientPaint CHROMEKNOB_BACK_GRADIENT = new ConicalGradientPaint(false, CHROMEKNOB_BACK_CENTER, 0, CHROMEKNOB_BACK_FRACTIONS, CHROMEKNOB_BACK_COLORS);
//        graphics.setPaint(CHROMEKNOB_BACK_GRADIENT);
//        graphics.fill(CHROMEKNOB_BACK);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.065, getAngle().getValue(), CHROMEKNOB_FOREFRAME_FRACTIONS, CHROMEKNOB_FOREFRAME_COLORS);

//        final Ellipse2D CHROMEKNOB_FOREFRAME = new Ellipse2D.Double(imageWidth * 0.4672897160053253, imageHeight * 0.4672897160053253, imageWidth * 0.06542053818702698, imageHeight * 0.06542053818702698);
//        final Point2D CHROMEKNOB_FOREFRAME_START = new Point2D.Double((0.48130841121495327 * imageWidth), (0.4719626168224299 * imageHeight));
//        final Point2D CHROMEKNOB_FOREFRAME_STOP = new Point2D.Double(((0.48130841121495327 + 0.033969662360372466) * imageWidth), ((0.4719626168224299 + 0.05036209552904459) * imageHeight));
//
//        PointSupport.validateGradientPoints(CHROMEKNOB_FOREFRAME_START, CHROMEKNOB_FOREFRAME_STOP);
//        final LinearGradientPaint CHROMEKNOB_FOREFRAME_GRADIENT = new LinearGradientPaint(CHROMEKNOB_FOREFRAME_START, CHROMEKNOB_FOREFRAME_STOP, CHROMEKNOB_FOREFRAME_FRACTIONS, CHROMEKNOB_FOREFRAME_COLORS);
//        graphics.setPaint(CHROMEKNOB_FOREFRAME_GRADIENT);
//        graphics.fill(CHROMEKNOB_FOREFRAME);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.056, getAngle().getValue(), CHROMEKNOB_FORE_FRACTIONS, CHROMEKNOB_FORE_COLORS);

//        final Ellipse2D CHROMEKNOB_FORE = new Ellipse2D.Double(imageWidth * 0.4719626307487488, imageHeight * 0.4719626307487488, imageWidth * 0.05607473850250244, imageHeight * 0.05607473850250244);
//        final Point2D CHROMEKNOB_FORE_START = new Point2D.Double((0.48130841121495327 * imageWidth), (0.4766355140186916 * imageHeight));
//        final Point2D CHROMEKNOB_FORE_STOP = new Point2D.Double(((0.48130841121495327 + 0.03135661140957459) * imageWidth), ((0.4766355140186916 + 0.04648808818065655) * imageHeight));
//
//        PointSupport.validateGradientPoints(CHROMEKNOB_FORE_START, CHROMEKNOB_FORE_STOP);
//        final LinearGradientPaint CHROMEKNOB_FORE_GRADIENT = new LinearGradientPaint(CHROMEKNOB_FORE_START, CHROMEKNOB_FORE_STOP, CHROMEKNOB_FORE_FRACTIONS, CHROMEKNOB_FORE_COLORS);
//        graphics.setPaint(CHROMEKNOB_FORE_GRADIENT);
//        graphics.fill(CHROMEKNOB_FORE);
    }

}
