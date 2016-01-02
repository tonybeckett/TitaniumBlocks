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
package us.jaba.titaniumblocks.core.tickmarks.marks.models.round;

import java.awt.Dimension;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.text.TextSupport;
import us.jaba.titaniumblocks.core.tickmarks.ticks.factories.RadialNormalTickFactory;

import us.jaba.titaniumblocks.core.tickmarks.marks.models.AbstractRadialTickmarkModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.RadialTick;

public class RNormalMajMinorTickmarkModel extends AbstractRadialTickmarkModel
{

    protected RadialNormalTickFactory tickFactory;

    public RNormalMajMinorTickmarkModel()
    {
        tickFactory = new RadialNormalTickFactory(rangeModel);
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {

        rangeModel.setTickSpacing(1.0);
        rangeModel.setTickLength(sizeModel.getMinorTickLength());

        graphics.setStroke(minorStroke);

        graphics.setColor(minorColor);
        for (RadialTick t : tickFactory.getTicks())
        {
            radialTickModel.paintTicks(graphics, null, 0.0, t.getInnerPoint(), t.getOuterPoint(), t.getCenterPoint(), t.getAngle());
        }

        rangeModel.setTickLength(sizeModel.getMajorTickLength());
        rangeModel.setTickSpacing(10.0);

        graphics.setStroke(majorStroke);

        graphics.setFont(font);
        for (RadialTick t : tickFactory.getTicks())
        {
            graphics.setColor(majorColor);
            radialTickModel.paintTicks(graphics, null, 0.0, t.getInnerPoint(), t.getOuterPoint(), t.getCenterPoint(), t.getAngle());

            graphics.setColor(textColor);
            graphics.fill(TextSupport.rotateTextAroundCenter(graphics,
                    Integer.toString((int) t.getValue()),
                    (int) t.getTextPoint().getX(),
                    (int) t.getTextPoint().getY(),
                    t.getTextAngle()));
        }

    }

}
