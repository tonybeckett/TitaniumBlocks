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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.compass.round;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class ThreeCirclesTickmarks extends AbstractRadialTickmark
{

    private double textScale = 0.04;
    String[] arrayOfText =
    {
        "N", "n-e", "E", "s-e", "S", "s-w", "W", "n-w"
    };
    String[] arrayOfDegrees = new String[18];

    public ThreeCirclesTickmarks()
    {
        minorColor = ColorPalette.GRAY.darker();
        int j = 0;
        for (int i = 0; i < 18; i++, j = j + 20)
        {
            arrayOfDegrees[i] = String.format("%d", j);
        }
        minorColor  = ColorPalette.WHITE;
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
//        int imageHeight = (int) dimensions.getHeight();

        minorStroke = new BasicStroke(((float) dimensions.width / 500.0f * 1.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        mediumStroke = new BasicStroke(((float) dimensions.width / 500.0f * 2.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / 500.0f * 3.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

        final Point2D centerPoint = new Point2D.Double(imageWidth / 2.0f, imageWidth / 2.0f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        graphics.setColor(minorColor);
        graphics.setStroke(minorStroke);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.2, radius * 0.95, 0.0, 45.0, 8);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.2, radius * 0.95, 15.0, 90.0, 4);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.2, radius * 0.95, 75.0, 90.0, 4);
        ShapeUtils.drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.4);

        ShapeUtils.drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.6);
        ShapeUtils.drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.815);
        
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.95, radius * 0.995, 0.0, 2.0, 180);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.93, radius * 0.995, 0.0, 10.0, 360);

        ShapeUtils.placeHalfFillTriangleOnRadius(graphics, centerPoint, radius * 0.075, radius * 0.2, radius * 0.2, 45.0, 90.0,   4);
        ShapeUtils.placeHalfFillTriangleOnRadius(graphics, centerPoint, radius * 0.15, radius * 0.5, radius * 0.312, 0.0, 90.0,   4);


        graphics.setColor(textColor);
        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.88, 0.0, 20, arrayOfDegrees);
        graphics.setFont(font.deriveFont((float) (textScale* 1.3 * dimensions.getWidth())));

        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.725, 0.0, 45, arrayOfText);

        graphics.setStroke(mediumStroke);
//        graphics.setColor(mediumColor);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.965, radius * 0.995, 0.0, 5, 72);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.945, radius * 0.995, 0.0, 45.0, 8);

        graphics.setStroke(majorStroke);
//        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.925, radius * 0.995, 0.0, 90.0, 4);

    }

}
