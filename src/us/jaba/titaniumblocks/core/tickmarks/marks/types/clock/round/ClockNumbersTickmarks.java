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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.font.FontSupport;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class ClockNumbersTickmarks extends AbstractRadialTickmark
{

    private static final double DEFAULT_TEXT_POSITION = 0.81;
    private static final double DEFAULT_TEXT_SCALE = 0.095;
    private String[] arrayOfText =
    {
        "12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
    };

    public ClockNumbersTickmarks()
    {
        super(new Scale(DEFAULT_TEXT_POSITION), new Scale(DEFAULT_TEXT_SCALE));
    }

    public ClockNumbersTickmarks(String[] text, double textScaleFactor)
    {
        super(new Scale(DEFAULT_TEXT_POSITION), new Scale(textScaleFactor));

        this.arrayOfText = text;

        this.setFont(FontSupport.getStandardFont().deriveFont(Font.BOLD, (float) (textScaleFactor * 500.0)));
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {

        final float radius = (float) (dimensions.getWidth() * 0.485f);
        final float tickRadius = (float) (dimensions.getWidth() * 0.485f * this.ticksPositionScale.getValue());

        graphics.setFont(getFont().deriveFont((float) (this.getTextSizeScale().getValue() * dimensions.getWidth())));

        graphics.setColor(textColor);
        graphics.setStroke(mediumStroke);

        textPainter.paint(graphics, centerPoint, radius * textPositionScale.getValue(), 0.0, 30, arrayOfText);

        graphics.setColor(minorColor);
        graphics.setStroke(minorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.945, tickRadius * 0.995, 0.0, 6.0, 60);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.915, tickRadius * 0.995, 0.0, 30.0, 12);

        graphics.dispose();

    }

}
