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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class SixNumbersTicks extends AbstractRadialTickmark
{

    private double textScale = 0.09;
    String[] arrayOfText =
    {
        "10", "12", "2", 
    };
    String[] arrayOfText2 =
    {
       "4", "6", "8"
    };

    public SixNumbersTicks()
    {
        majorStroke = new BasicStroke(6.0F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
    }

    public SixNumbersTicks(String[] text, double textScaleFactor)
    {
        this.arrayOfText = text;
        textScale = textScaleFactor;
        majorStroke = new BasicStroke(6.0F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (textScale * dimensions.getWidth())));

        graphics.setColor(textColor);
        

        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.75, 300.0, 60, arrayOfText);
        ShapeUtils.placeTextOnRadiusRotateOut(graphics, centerPoint, radius * 0.75, 120.0, 60, arrayOfText2);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.75, radius * 0.85, 30.0, 60.0, 6);

        graphics.setColor(mediumColor);
        graphics.setStroke(mediumStroke);
        for (int i = 0; i < 12; i++)
        {
            ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.90, radius * 0.95, (30.0 * i) + (30.0 / 5.0), 30.0 / 5.0, 4);
        }
        ShapeUtils.placeCircleOnRadius(graphics, centerPoint, radius * 0.930, radius * 0.0125, 0.0, 30.0, true, 12);

        graphics.dispose();

    }

}
