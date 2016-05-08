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
package us.jaba.titaniumblocks.core.led;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.lcdgradients.Standard;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.font.FontSupport;
import us.jaba.titaniumblocks.core.math.Angle;
import us.jaba.titaniumblocks.core.text.painter.BasicRadialTextPainter;
import us.jaba.titaniumblocks.core.text.painter.FacingDown;

/**
 *
 * @author tbeckett
 */
public class PolarLed extends Led
{

    private Scale radiusAdjust = new Scale(0.5);
    private Angle angle = new Angle(0.0);
   
 
    public Scale getRadiusAdjust()
    {
        return radiusAdjust;
    }

    public void setRadiusAdjust(Scale radiusAdjust)
    {
        this.radiusAdjust = radiusAdjust;
        changed();
    }

    public Angle getAngle()
    {
        return angle;
    }

    public void setAngle(Angle angle)
    {
        this.angle = angle;
        changed();
    }

   

   
}
