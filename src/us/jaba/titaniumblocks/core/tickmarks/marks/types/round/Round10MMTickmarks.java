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

import us.jaba.titaniumblocks.core.tickmarks.marks.types.NumericRoundTickmarks;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

// Round 10 divisions Major and Minor tickmarks
public class Round10MMTickmarks extends NumericRoundTickmarks
{

   
    @Override
    protected void generateTicks()
    {
        float delta = (Math.abs(maxValue) - Math.abs(minValue)) / 10.0f;
        String[] strings = new String[11];
        for (int i = 0; i < 11; i++)
        {
            strings[i] = String.format("%d", (int) (minValue + (i * delta)));
        }
        this.labels = strings;
    }

   

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        final int llen = labels.length - 1;
        final float tickRadius = (float) (dimensions.getWidth() * 0.485f * this.ticksPositionScale.getValue());
        final float textRadius = (float) (dimensions.getWidth() * 0.485f * this.textPositionScale.getValue());
        final float anglePerTick = (float) (CoordinateUtils.calcExtent(rangeModel.getAngleStart(), rangeModel.getAngleEnd(), rangeModel.getDirection()) / llen / 10.0);
        minorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 1.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        mediumStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 2.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 4.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);

        graphics.setStroke(minorStroke);
        graphics.setColor(minorColor);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.93, tickRadius * 0.95, rangeModel.getAngleStart(), anglePerTick, llen * 10);

        graphics.setStroke(majorStroke);
        graphics.setColor(majorColor);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.9, tickRadius * 0.95, rangeModel.getAngleStart(), anglePerTick * llen, labels.length);

        graphics.setFont(getFont().deriveFont((float) (this.getTextSizeScale().getValue() * dimensions.getWidth())));
        graphics.setColor(textColor);
        this.textPainter.paint(graphics, centerPoint, textRadius * 0.8, rangeModel.getAngleStart(), anglePerTick * llen, labels);

    }

}
