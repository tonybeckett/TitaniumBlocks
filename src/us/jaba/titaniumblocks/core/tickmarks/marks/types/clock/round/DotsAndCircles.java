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

public class DotsAndCircles extends AbstractRadialTickmark
{
 
    private String[] arrayOfText =
    {
        "00", "03", "06", "09"
    };

   
    public DotsAndCircles(String[] text, double textScaleFactor)
    {
        this.arrayOfText = text;
         
     }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        majorStroke = new BasicStroke(((float) dimensions.width / 500.0f * 2.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        for (int i = 0; i < 12; i++)
        {
            ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.90, radius * 0.95, (30.0*i)+(30.0 / 5.0), 30.0 / 5.0, 4);
        }
        ShapeUtils.placeCircleOnRadius(graphics, centerPoint, radius * 0.930, radius * 0.0125, 0.0, 30.0, true, 12);

        graphics.dispose();

    }

}
