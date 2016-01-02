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
package us.jaba.titaniumblocks.core.tickmarks.ticklabels.orientation.models;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.text.TextSupport;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.orientation.AbstractTickLabelModel;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.numbers.NumberFormater;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.numbers.formats.AutoFormat;

/**
 *
 * @author tbeckett
 */
public class HorizontalTickLabelModel extends AbstractTickLabelModel
{


    public HorizontalTickLabelModel()
    {
        this.numberFormat = new AutoFormat();
        this.ticklabelRotationOffset = 0;
        rotationOffset = 0;

    }

    public HorizontalTickLabelModel(NumberFormater numberFormat, double ticklabelRotationOffset, double rotationOffset)
    {
        this.numberFormat = numberFormat;
        this.ticklabelRotationOffset = ticklabelRotationOffset;
        this.rotationOffset = rotationOffset;

    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions, Point2D textPoint, double value, double alpha)
    {
        super.paint(graphics, dimensions);

        double orientationOffset = 0;
        switch (orientation)
        {
            case WEST:
                orientationOffset = Math.PI / 2;
                break;
                
            case EAST:
                orientationOffset = -Math.PI / 2;
                break;

            case SOUTH:
                orientationOffset = Math.PI;
                break;

            case NORTH:
            default:
                orientationOffset = 0;
                break;
        }
        graphics.fill(TextSupport.rotateTextAroundCenter(graphics, numberFormat.format(value), (int) textPoint.getX(), (int) textPoint.getY(), Math.PI - rotationOffset + orientationOffset));

    }


}
