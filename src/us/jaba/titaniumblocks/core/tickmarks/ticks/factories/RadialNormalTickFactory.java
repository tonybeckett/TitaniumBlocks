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

import us.jaba.titaniumblocks.core.tickmarks.marks.models.rangemodels.RadialRangeModel;
import java.util.ArrayList;
import java.util.List;
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;
import us.jaba.titaniumblocks.core.tickmarks.ticks.RadialTick;

/**
 *
 * @author tbeckett
 */
public class RadialNormalTickFactory
{

    RadialRangeModel tickmarkRadialRangeModel;

    public RadialNormalTickFactory(RadialRangeModel tickmarkRadialRangeModel)
    {
        this.tickmarkRadialRangeModel = tickmarkRadialRangeModel;
    }

    public List<RadialTick> getTicks()
    {
        ArrayList<RadialTick> al = new ArrayList();
        double angle = tickmarkRadialRangeModel.getAngleStart();
        double angleDelta = tickmarkRadialRangeModel.getAnglePerTick();

        double valueDelta = tickmarkRadialRangeModel.getValuePerTick();
        if (tickmarkRadialRangeModel.getDirection() == Direction.COUNTER)
        {
             
        } else
        {
            angleDelta = angleDelta * -1.0;
        }
        double value = tickmarkRadialRangeModel.getStartValue();

        int numT = tickmarkRadialRangeModel.getNumberOfTicks() + 1;
        for (int i = 0; i < numT; i++)
        {
            RadialTick t = new RadialTick();

            t.setCenterPoint(tickmarkRadialRangeModel.getCenter());
            t.setRadius(tickmarkRadialRangeModel.getRadius());
            t.setTickLength(tickmarkRadialRangeModel.getTickLength());
            t.setTextDistance(tickmarkRadialRangeModel.getTextDistance());
            t.setTextAngle(Math.toRadians(calcAngle(angle)));
            t.setAngle(angle);
            t.setValue(value);

            al.add(t);

            angle = angle + angleDelta;
            value = value + valueDelta;
        }
        return al;
    }
    
    protected double calcAngle(double angle)
    {
        return tickmarkRadialRangeModel.getTextAngleAdjust() - angle;
    }
}
