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

public class TwoBigNumbersTicks extends AbstractRadialTickmark
{

    private double textScale = 0.115;
    String[] arrayOfText =
    {
        "12", "6"
    };

    String[] arrayOfText2 =
    {
        "1", "2", "3", "4", "5"
    };

    String[] arrayOfText3 =
    {
        "7", "8", "9", "10", "11"
    };

    public TwoBigNumbersTicks()
    {
    }

    public TwoBigNumbersTicks(String[] text, double textScaleFactor)
    {
        this.arrayOfText = text;
        textScale = textScaleFactor;
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        majorStroke = new BasicStroke(((float) dimensions.width / 500.0f * 5.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (textScale * dimensions.getWidth())));

        graphics.setColor(textColor);
        graphics.setStroke(mediumStroke);

        ShapeUtils.placeTextOnRadius(graphics, centerPoint, radius * 0.85, 0.0, 180, arrayOfText);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.875, radius * 0.95, 30.0, 30.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.875, radius * 0.95, 120.0, 30.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.875, radius * 0.95, 210.0, 30.0, 5);

        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (textScale * dimensions.getWidth() * 0.45)));
        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.775, 30.0, 30.0, arrayOfText2);

        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.775, 210.0, 30, arrayOfText3);

        graphics.dispose();

    }

}
