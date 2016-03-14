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
package us.jaba.titaniumblocks.core.pointers.types;

import java.awt.Dimension;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author tbeckett
 */
public class LineWithPaddleTailPointer extends LinePointer
{

    

    @Override
    protected Area getShape(Dimension dimensions)
    {
        Area pointerLine = super.getShape(dimensions);
        
        final int imageWidth = (int) dimensions.getWidth();

        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
//        double frontM = this.getRadiusPercent() * frontScale.getValue();
        double tailM = this.getRadiusPercent() * tailScale.getValue();

        double lineWidthScale = 0.009345;
        
        lineWidthScale = 0.009345 * 4.0;
        Area paddle = new Area(new Ellipse2D.Double(centerX - imageWidth * (lineWidthScale / 2.0), centerY + maxY * (tailM / 3),
                imageWidth * lineWidthScale,  maxY * tailM));
        pointerLine.add(paddle);

        return pointerLine;
    }

//  
}
