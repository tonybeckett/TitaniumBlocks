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
package us.jaba.titaniumblocks.core.tickmarks.ticks.factories;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels.HorizontalLinearSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.rangemodels.LinearRangeModel;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels.LinearSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTick;

/**
 *
 * @author tbeckett
 */
public class HorizontalLinearTickFactory
{

    protected LinearSizeModel sizeModel;
    protected LinearRangeModel rangeModel;

    public HorizontalLinearTickFactory(LinearRangeModel linearRangeModel)
    {
        this(linearRangeModel, new HorizontalLinearSizeModel());
    }

    public HorizontalLinearTickFactory(LinearRangeModel linearRangeModel, LinearSizeModel sizeModel)
    {
        this.rangeModel = linearRangeModel;
        this.sizeModel = sizeModel;
    }

    public List<LinearTick> getTicks()
    {
        final double valueDelta = rangeModel.getValuePerTick();
        final double xDelta = rangeModel.getTickSpacingPixels();
        final int numT = rangeModel.getNumberOfTicks() + 1;

        ArrayList<LinearTick> al = new ArrayList();
        double value = rangeModel.getStartValue();
        double currentX = rangeModel.getStartPosition();

        for (int i = 0; i < numT; i++)
        {
            LinearTick t = new LinearTick();

            t.setStartPoint(new Point2D.Double(currentX, sizeModel.getTickStart()));
            t.setStopPoint(new Point2D.Double(currentX, sizeModel.getTickStop()));
            t.setTextPoint(new Point2D.Double(currentX, sizeModel.getTickStart() + 10));
//            t.setTextDistance(sizeModel.getTextDistance());
//            t.setTextAngle(Math.toRadians(tickmarkRadialRangeModel.getTextAngleAdjust() - angle));

            t.setValue(value);

            al.add(t);

            currentX = currentX + xDelta;
            value = value + valueDelta;
        }
        return al;
    }

    public LinearSizeModel getSizeModel()
    {
        return sizeModel;
    }

    public void setSizeModel(LinearSizeModel sizeModel)
    {
        this.sizeModel = sizeModel;
    }

    public LinearRangeModel getRangeModel()
    {
        return rangeModel;
    }

    public void setRangeModel(LinearRangeModel rangeModel)
    {
        this.rangeModel = rangeModel;
    }

}
