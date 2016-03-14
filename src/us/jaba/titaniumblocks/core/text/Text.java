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
package us.jaba.titaniumblocks.core.text;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.font.BaseFont;

/**
 *
 * @author tbeckett
 */
public class Text extends CoreModel
{

    public static final double DEFAULT_RIGHT_OFFSET_FACTOR = 0.09; // offset = % width from right
    public static final double DEFAULT_BASELINE_SCALE_FACTOR = 0.76; // offset = % width from right
    
    protected double rightOffsetFactor = DEFAULT_RIGHT_OFFSET_FACTOR;
    protected double baselineScaleFactor = DEFAULT_BASELINE_SCALE_FACTOR;
    
    protected Font font = BaseFont.DEFAULT_FONT;
    protected Color color = ColorPalette.BLACK;

    public Text()
    {
    }

    public Text(Font font, Color color)
    {
        this.font = font;
        this.color = color;
    }

    public void setFontSize(float size)
    {

        Font f = font.deriveFont(size);
        font = f;
        changed();
    }

    public double getRightOffsetFactor()
    {
        return rightOffsetFactor;
    }

    public void setRightOffsetFactor(double rightOffsetFactor)
    {
        this.rightOffsetFactor = rightOffsetFactor;
        changed();
    }

    @Override
    public final void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        paintText(graphics, dimensions);
    }

    protected void paintText(Graphics2D graphics, Dimension dimensions)
    {

    }

    public Font getFont()
    {
        return font;
    }

    public void setFont(Font font)
    {
        this.font = font;
        changed();

    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
        changed();
    }

}
