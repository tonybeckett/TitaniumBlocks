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
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

// Round 10 divisions Major and Minor tickmarks
public class RoundDualMmTickmarks extends NumericRoundTickmarks
{

    public RoundDualMmTickmarks()
    {
        super();
        generateLabels();
    }

    @Override
    public void setDivisions(int divisions)
    {
        super.setDivisions(divisions);  
        generateLabels();
    }

    @Override
    protected void generateLabels()
    {
        float delta = (Math.abs(maxValue) - Math.abs(minValue)) / (float)divisions;
        String[] strings = new String[divisions+1];
        for (int i = 0; i <= divisions; i++)
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
        float anglePerTick = (float) (CoordinateUtils.calcExtent(rangeModel.getAngleStart(), rangeModel.getAngleEnd(), rangeModel.getDirection()) / llen / this.divisions);
        if (rangeModel.getDirection() == Direction.COUNTER)
        {
            anglePerTick = anglePerTick * -1.0f;
        }

        minorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 1.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        mediumStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 2.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 4.0F), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);

        graphics.setStroke(mediumStroke);
        graphics.setColor(mediumColor);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.9, tickRadius * 0.95, rangeModel.getAngleStart(), anglePerTick, (llen * this.divisions)+1);

        graphics.setStroke(majorStroke);
        graphics.setColor(majorColor);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.83, tickRadius * 0.89, rangeModel.getAngleStart(), anglePerTick * llen, labels.length);

        graphics.setFont(getFont().deriveFont((float) (this.getTextSizeScale().getValue() * dimensions.getWidth())));
        graphics.setColor(textColor);
        this.textPainter.paint(graphics, centerPoint, textRadius * 0.725, rangeModel.getAngleStart(), anglePerTick * llen, labels);

    }

}
