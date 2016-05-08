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
package us.jaba.titaniumblocks.core.knobs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class MetalKnob extends PolarKnob
{

    private  Color[] colorArray;

    private final float[] METALKNOB_FRAME_FRACTIONS =
    {
        0.0f,
        0.47f,
        1.0f
    };

    private final Color[] METALKNOB_FRAME_COLORS =
    {
        new Color(92, 95, 101, 255),
        new Color(46, 49, 53, 255),
        new Color(22, 23, 26, 255)
    };

    private final float[] METALKNOB_MAIN_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    private final float[] METALKNOB_LOWERHL_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_LOWERHL_COLORS =
    {
        new Color(255, 255, 255, 153),
        new Color(255, 255, 255, 0)
    };

    private final float[] METALKNOB_UPPERHL_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_UPPERHL_COLORS =
    {
        new Color(255, 255, 255, 191),
        new Color(255, 255, 255, 0)
    };

    private final float[] METALKNOB_INNERFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_INNERFRAME_COLORS =
    {
        new Color(0, 0, 0, 255),
        new Color(204, 204, 204, 255)
    };

    private final float[] METALKNOB_INNERBACKGROUND_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_INNERBACKGROUND_COLORS =
    {
        new Color(1, 6, 11, 255),
        new Color(50, 52, 56, 255)
    };

    public MetalKnob(Color[] colors)
    {
        this.colorArray = colors;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        final double radius = dimensions.getWidth() * 0.5;

        Point2D.Double centerPoint = new Point2D.Double((dimensions.getWidth() / 2.0), (dimensions.getHeight() / 2.0));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.032, getAngle().getValue(), METALKNOB_FRAME_FRACTIONS, METALKNOB_FRAME_COLORS);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.024, getAngle().getValue(), METALKNOB_MAIN_FRACTIONS, colorArray);

 

//final GeneralPath lowerHighlight = new GeneralPath();
//        lowerHighlight.setWindingRule(Path2D.WIND_EVEN_ODD);
//        lowerHighlight.moveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5280373831775701);
//        lowerHighlight.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5186915887850467, imageWidth * 0.5093457943925234, imageHeight * 0.514018691588785, imageWidth * 0.5, imageHeight * 0.514018691588785);
//        lowerHighlight.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.514018691588785, imageWidth * 0.4766355140186916, imageHeight * 0.5186915887850467, imageWidth * 0.4766355140186916, imageHeight * 0.5280373831775701);
//        lowerHighlight.curveTo(imageWidth * 0.48130841121495327, imageHeight * 0.5327102803738317, imageWidth * 0.49065420560747663, imageHeight * 0.5373831775700935, imageWidth * 0.5, imageHeight * 0.5373831775700935);
//        lowerHighlight.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.5373831775700935, imageWidth * 0.514018691588785, imageHeight * 0.5327102803738317, imageWidth * 0.5186915887850467, imageHeight * 0.5280373831775701);
//        lowerHighlight.closePath();
//        final Point2D lowerHighlightCenter = new Point2D.Double((0.5 * imageWidth), (0.5373831775700935 * imageHeight));
//
//        final RadialGradientPaint lowerHighlightGradient = new RadialGradientPaint(lowerHighlightCenter, (float) (0.03271028037383177 * imageWidth), METALKNOB_LOWERHL_FRACTIONS, METALKNOB_LOWERHL_COLORS);
//        graphics.setPaint(lowerHighlightGradient);
//        graphics.fill(lowerHighlight);
//
//        final GeneralPath upperHighlight = new GeneralPath();
//        upperHighlight.setWindingRule(Path2D.WIND_EVEN_ODD);
//        upperHighlight.moveTo(imageWidth * 0.5327102803738317, imageHeight * 0.48130841121495327);
//        upperHighlight.curveTo(imageWidth * 0.5280373831775701, imageHeight * 0.4672897196261682, imageWidth * 0.514018691588785, imageHeight * 0.45794392523364486, imageWidth * 0.5, imageHeight * 0.45794392523364486);
//        upperHighlight.curveTo(imageWidth * 0.48130841121495327, imageHeight * 0.45794392523364486, imageWidth * 0.4672897196261682, imageHeight * 0.4672897196261682, imageWidth * 0.46261682242990654, imageHeight * 0.48130841121495327);
//        upperHighlight.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.48598130841121495, imageWidth * 0.48130841121495327, imageHeight * 0.49065420560747663, imageWidth * 0.5, imageHeight * 0.49065420560747663);
//        upperHighlight.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.49065420560747663, imageWidth * 0.5280373831775701, imageHeight * 0.48598130841121495, imageWidth * 0.5327102803738317, imageHeight * 0.48130841121495327);
//        upperHighlight.closePath();
//        final Point2D upperHighlightCenter = new Point2D.Double((0.4953271028037383 * imageWidth), (0.45794392523364486 * imageHeight));
//
//        final RadialGradientPaint upperHighlightGradient = new RadialGradientPaint(upperHighlightCenter, (float) (0.04906542056074766 * imageWidth), METALKNOB_UPPERHL_FRACTIONS, METALKNOB_UPPERHL_COLORS);
//        graphics.setPaint(upperHighlightGradient);
//        graphics.fill(upperHighlight);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.026, getAngle().getValue(), METALKNOB_INNERFRAME_FRACTIONS, METALKNOB_INNERFRAME_COLORS);

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.008, getAngle().getValue(), METALKNOB_INNERBACKGROUND_FRACTIONS, METALKNOB_INNERBACKGROUND_COLORS);

        graphics.dispose();
    }

}
