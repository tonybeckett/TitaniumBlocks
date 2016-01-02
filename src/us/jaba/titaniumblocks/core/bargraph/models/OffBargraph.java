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
package us.jaba.titaniumblocks.core.bargraph.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.bargraph.AbstractBargraph;

/**
 *
 * @author tbeckett
 */
public class OffBargraph extends AbstractBargraph
{

    private Color color = Color.GRAY;
   

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
        changed();
    }

    @Override
    protected void paintBargraph(Graphics2D graphics, Dimension dimensions)
    {
        final int IMAGE_WIDTH = (int) dimensions.getWidth();
        final int IMAGE_HEIGHT = (int) dimensions.getHeight();

        final GeneralPath BARGRAPH_OFF = new GeneralPath();
        BARGRAPH_OFF.setWindingRule(Path2D.WIND_EVEN_ODD);
        BARGRAPH_OFF.moveTo(0.859375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.859375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8828125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8828125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.859375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.8203125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8203125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.84375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.84375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8203125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.78125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.78125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8046875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.8046875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.78125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.7421875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.7421875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.765625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.765625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.7421875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.703125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.703125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.7265625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.7265625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.703125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.6640625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6640625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6640625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6484375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.6484375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.5859375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5859375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.609375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.609375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5859375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.546875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.546875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5703125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5703125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.546875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.5078125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5078125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.53125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.53125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.5078125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.46875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.46875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4921875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4921875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.46875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.4296875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4296875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.453125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.453125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4296875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.390625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.390625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4140625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.4140625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.390625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.3515625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3515625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3515625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.3125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3359375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3359375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.3125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.2734375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.2734375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.296875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.296875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.2734375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.234375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.234375 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.2578125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.2578125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.234375 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.1953125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1953125 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.21875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.21875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1953125 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.15625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.15625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1796875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1796875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.15625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        BARGRAPH_OFF.moveTo(0.1171875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1171875 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.140625 * IMAGE_WIDTH, 0.9375 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.140625 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.lineTo(0.1171875 * IMAGE_WIDTH, 0.8125 * IMAGE_HEIGHT);
        BARGRAPH_OFF.closePath();
        graphics.setPaint(new Color(color.getRed(), color.getGreen(), color.getBlue(), 25));
        graphics.fill(BARGRAPH_OFF);
    }

}
