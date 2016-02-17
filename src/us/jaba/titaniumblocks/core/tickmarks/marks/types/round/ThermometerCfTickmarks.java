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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.round;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

public class ThermometerCfTickmarks extends ThermometerBaseTickmarks
{

    protected String[] arrayOfFText =
    {
        "0", "20", "40", "60", "80", "100", "120"
    };
    protected String[] arrayOfCText =
    {
        "-20", "-10", "0", "10", "20", "30", "40", "50", "60"
    };

    public ThermometerCfTickmarks()
    {
        super(0.075);

        minorStroke = majorStroke;
        majorStroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        final float radius = (float) (dimensions.getWidth() * 0.485f);

        // 300 degrees
        double angleStep = 315.0 / 9.0;

        graphics.setColor(textColor);

        graphics.setFont(font.deriveFont(Font.BOLD, (float) (textScale * dimensions.getWidth())));
        ShapeUtils.placeTextOnRadius(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.85, 140.0, -1.0 * angleStep, arrayOfCText);

        ShapeUtils.placeTextOnRadius(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.85, 180.0, 0.0, unitsC);

        graphics.setFont(font.deriveFont(Font.BOLD, (float) (textScale * dimensions.getWidth() * 0.75)));
        ShapeUtils.placeTextOnRadius(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.4, 134.0, -39, arrayOfFText);

        ShapeUtils.placeTextOnRadius(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.475, 180.0, 0.0, unitsF);

        graphics.setColor(minorColor);
        graphics.setStroke(minorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.6, radius * 0.685, 140.0, -1.0 * angleStep / 10.0, (arrayOfCText.length - 1) * 10);

        ShapeUtils.drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.6);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.6, radius * 0.7, 140.0, -1.0 * angleStep, 9);

        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.55, radius * 0.6, 134.0, -39, 7);

        graphics.dispose();

    }

}
