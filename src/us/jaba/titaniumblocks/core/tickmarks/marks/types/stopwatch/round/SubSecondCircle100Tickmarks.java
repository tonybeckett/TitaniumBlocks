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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.stopwatch.round;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class SubSecondCircle100Tickmarks extends AbstractRadialTickmark
{

    private final double TEXT_SCALE = 0.045;

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        mediumStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 1.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 3.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);

        final float radius = (float) (dimensions.getWidth() * 0.485f * this.ticksPositionScale.getValue());
        final float textRadius = (float) (dimensions.getWidth() * 0.485f * this.textPositionScale.getValue());

        graphics.setFont(font.deriveFont((float) (TEXT_SCALE * getTextSizeScale().getValue() * dimensions.getWidth())));

        graphics.setColor(textColor);
        graphics.setStroke(mediumStroke);
        String[] text =
        {
            "60", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"
        };

        String[] text2 =
        {
            " ", "10", "20", "30", "40", "50", "60", "70", "80", "90"
        };
        textPainter.paint(graphics, centerPoint, textRadius * 0.97, 0.0, 30, text);

        graphics.setFont(font.deriveFont((float) (0.065 * dimensions.getWidth())));

        textPainter.paint(graphics, centerPoint, textRadius * 0.65, 0.0, 36, text2);

        graphics.setColor(mediumColor);
        graphics.setStroke(mediumStroke);

        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.85, radius * 0.875, 0.0, 2, 180);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.775, radius * 0.825, 0.0, 3.6, 100);

//            ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.75, radius * 0.825, 0.0+(i*30), 1, 30);
//            ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.75, radius * 0.825, 5.0+(i*30), 6, 4);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.765, radius * 0.825, 0.0, 18, 20);

        ShapeUtils.drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), radius * 0.825);

        graphics.setColor(majorColor);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.85, radius * 0.9, 0.0, 10.0, 36);

        graphics.dispose();

    }

}
