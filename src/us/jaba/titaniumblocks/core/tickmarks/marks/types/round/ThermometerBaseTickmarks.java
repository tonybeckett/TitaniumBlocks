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

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.text.StringSupport;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class ThermometerBaseTickmarks extends AbstractRadialTickmark
{

    protected double textScale = 0.075;

    protected String[] unitsC =
    {
        StringSupport.DEGREE + "C"
    };
    protected String[] unitsF =
    {
        StringSupport.DEGREE + "F"
    };

    public ThermometerBaseTickmarks(double textScaleFactor)
    {
        textScale = textScaleFactor;
        majorStroke = new BasicStroke(4.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        mediumStroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        minorStroke = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        minorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 1.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        mediumStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 2.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        majorStroke = new BasicStroke(((float) dimensions.width / TARGET_WINDOW_SIZE * 5.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        super.paint(graphics, dimensions);  
    }

}
