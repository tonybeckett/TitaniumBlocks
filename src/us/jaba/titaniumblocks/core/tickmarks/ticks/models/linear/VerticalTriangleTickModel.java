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
package us.jaba.titaniumblocks.core.tickmarks.ticks.models.linear;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTick;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTickModel;

/**
 *
 * @author tbeckett
 */
public class VerticalTriangleTickModel extends LinearTickModel
{

    @Override
    public void paintTicks(Graphics2D graphics, Shape shape, Dimension dimensions, LinearTick linearTick)
    {

        final GeneralPath path = new GeneralPath();
//        path.moveTo(startPosition, currentPosition + dimensions.getWidth() * 0.005 );
//        path.lineTo(startPosition, currentPosition - dimensions.getWidth() * 0.005);
//        path.lineTo(stopPosition, currentPosition);
        path.moveTo(linearTick.getStartPoint().getX(), linearTick.getStartPoint().getY() - (dimensions.getWidth() * 0.005));
        path.lineTo(linearTick.getStartPoint().getX(), linearTick.getStartPoint().getY() + (dimensions.getWidth() * 0.005));
        path.lineTo(linearTick.getStopPoint().getX(), linearTick.getStopPoint().getY());
        path.closePath();

        path.closePath();

        graphics.fill(path);

    }
}
