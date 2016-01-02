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
package us.jaba.titaniumblocks.core.tickmarks.marks.models.rectangular;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.text.TextSupport;
import us.jaba.titaniumblocks.core.tickmarks.marks.models.sizemodels.HorizontalLinearSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.factories.HorizontalLinearTickFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.models.AbstractLinearTickmarkModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTick;

import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTickModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.models.linear.LineTickModel;

/**
 *
 * @author tbeckett
 */
public class HorizontalLinearTickmarkModel extends AbstractLinearTickmarkModel
{

    protected LinearTickModel linearTickModel;

    protected HorizontalLinearTickFactory tickFactory;

    public HorizontalLinearTickmarkModel()
    {
        super();
//        numberFormat = NumberFormat.AUTO;

        linearTickModel = new LineTickModel();
        tickFactory = new HorizontalLinearTickFactory(rangeModel);
        sizeModel = new HorizontalLinearSizeModel();
        tickFactory.setSizeModel(sizeModel);
        offsetAdjustment = AbstractLinearTickmarkModel.DEFAULT_HORIZ_OFFSET_ADJUST;
        sizeAdjustment = AbstractLinearTickmarkModel.DEFAULT_HORIZ_SIZE_ADJUST;
    }

    @Override
    protected void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        setBounds(new Rectangle2D.Double(
                dimensions.getWidth() * this.getOffsetAdjustment(),
                0,
                ((dimensions.getWidth() * this.getSizeAdjustment()) - (dimensions.getWidth() * this.getOffsetAdjustment())),
                0
        )
        );

        sizeModel.adjustUsing((float) dimensions.getWidth());
        sizeModel.setTickStart(sizeModel.getMinorTickStart());
        sizeModel.setTickStop(sizeModel.getMinorTickStop());
        rangeModel.setStartPosition((int) getBounds().getMinX());
        rangeModel.setTickSpacingByValue(this.minorTickSpacing);
        rangeModel.setSizeInPixels(getBounds().getBounds2D().getWidth());
         

        graphics.setStroke(minorStroke);
        graphics.setColor(minorColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);// t.getInnerPoint(), t.getOuterPoint(), t.getCenterPoint(), t.getAngle());
        }

        sizeModel.setTickStart(sizeModel.getMediumTickStart());
        sizeModel.setTickStop(sizeModel.getMediumTickStop());
        rangeModel.setTickSpacingByValue(this.mediumTickSpacing);

         

        graphics.setStroke(mediumStroke);
        graphics.setColor(mediumColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);
        }

        sizeModel.setTickStart(sizeModel.getMajorTickStart());
        sizeModel.setTickStop(sizeModel.getMajorTickStop());
        rangeModel.setTickSpacingByValue(this.majorTickSpacing);

        

        graphics.setStroke(majorStroke);
        graphics.setColor(majorColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);

            graphics.setColor(textColor);
            graphics.fill(TextSupport.rotateTextAroundCenter(graphics,
                    Double.toString(t.getValue()),
                    (int) t.getTextPoint().getX(),
                    (int) t.getTextPoint().getY(),
                    t.getTextAngle()));
        }

    }

}
