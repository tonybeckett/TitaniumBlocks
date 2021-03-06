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
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class OnlyTicksOn30 extends AbstractRadialTickmark
{
 
    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        mediumStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 2.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 4.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final float radius = (float) (dimensions.getWidth() * 0.485f);
        final float tickRadius = (float) (dimensions.getWidth() * 0.485f * this.ticksPositionScale.getValue());

        graphics.setColor(minorColor);
        graphics.setStroke(minorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 30.0, 30.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 120.0, 30.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 210.0, 30.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 300.0, 30.0, 2);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 0.0, 358.0, 1);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 0.0, 2.0, 1);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.975, 90.0, 180.0, 2);
        ShapeUtils.drawRadialLines(graphics, centerPoint, tickRadius * 0.8, tickRadius * 0.9, 180.0, 0.0, 1);

        graphics.dispose();

    }

}
