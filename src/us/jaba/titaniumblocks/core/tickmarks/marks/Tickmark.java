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
package us.jaba.titaniumblocks.core.tickmarks.marks;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.text.painter.BasicRadialTextPainter;
import us.jaba.titaniumblocks.core.text.painter.FacingDown;

/**
 *
 * @author tbeckett
 */
public class Tickmark extends CoreModel implements Serializable
{

    public static final float DEFAULT_MIN_VALUE = 0.0F;
    public static final float DEFAULT_MAX_VALUE = 100.0F;

    protected static final Color DEFAULT_BASELINE_COLOR = ColorPalette.BLACK;
    protected static final Color DEFAULT_MAJOR_COLOR = ColorPalette.BLACK;
    protected static final Color DEFAULT_MEDIUM_COLOR = ColorPalette.BLACK;
    protected static final Color DEFAULT_MINOR_COLOR = ColorPalette.BLACK;
    protected static final Color DEFAULT_TEXT_COLOR = ColorPalette.BLACK;

    public static final BasicStroke DEFAULT_BASELINE_STROKE = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    public static final BasicStroke DEFAULT_MAJOR_STROKE = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    public static final BasicStroke DEFAULT_MEDIUM_STROKE = new BasicStroke(0.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    public static final BasicStroke DEFAULT_MINOR_STROKE = new BasicStroke(0.3F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

    public static final int DEFAULT_MINOR_TICK_SPACING = 1;
    public static final int DEFAULT_MEDIUM_TICK_SPACING = 5;
    public static final int DEFAULT_MAJOR_TICK_SPACING = 10;
    protected static final float TARGET_WINDOW_SIZE = 500.0F;

    protected Color baselineColor = DEFAULT_BASELINE_COLOR;

    protected BasicStroke baselineStroke = DEFAULT_BASELINE_STROKE;
    protected BasicStroke majorStroke = DEFAULT_MAJOR_STROKE;
    protected BasicStroke mediumStroke = DEFAULT_MEDIUM_STROKE;
    protected BasicStroke minorStroke = DEFAULT_MINOR_STROKE;

    protected Color majorColor = DEFAULT_MAJOR_COLOR;
    protected Color mediumColor = DEFAULT_MEDIUM_COLOR;
    protected Color minorColor = DEFAULT_MINOR_COLOR;
    protected Color textColor = DEFAULT_TEXT_COLOR;

    protected int minorTickSpacing = DEFAULT_MINOR_TICK_SPACING;
    protected int mediumTickSpacing = DEFAULT_MEDIUM_TICK_SPACING;
    protected int majorTickSpacing = DEFAULT_MAJOR_TICK_SPACING;

    protected Font font = BaseFont.DEFAULT_FONT.deriveFont(10.0F);
    protected BasicRadialTextPainter textPainter = new FacingDown();
    
    public Tickmark()
    {
    }

    public Tickmark(Tickmark other)
    {
        copy(other);
    }

    public void copy(Tickmark other)
    {
        this.majorColor = other.majorColor;
        this.mediumColor = other.mediumColor;
        this.minorColor = other.minorColor;
        this.textColor = other.textColor;
        this.font = other.font;
        
        
    }

    public Color getBaselineColor()
    {
        return baselineColor;
    }

    public void setBaselineColor(Color baselineColor)
    {
        this.baselineColor = baselineColor;
        changed();
    }

    public BasicStroke getBaselineStroke()
    {
        return baselineStroke;
    }

    public void setBaselineStroke(BasicStroke baselineStroke)
    {
        this.baselineStroke = baselineStroke;
        changed();
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

    public Color getMajorColor()
    {
        return majorColor;
    }

    public void setMajorColor(Color majorColor)
    {
        this.majorColor = majorColor;
        changed();
    }

    public BasicStroke getMajorStroke()
    {
        return majorStroke;
    }

    public void setMajorStroke(BasicStroke majorStroke)
    {
        this.majorStroke = majorStroke;
        changed();
    }

    public Color getMediumColor()
    {
        return mediumColor;
    }

    public void setMediumColor(Color mediumColor)
    {
        this.mediumColor = mediumColor;
        changed();
    }

    public BasicStroke getMediumStroke()
    {
        return mediumStroke;
    }

    public void setMediumStroke(BasicStroke mediumStroke)
    {
        this.mediumStroke = mediumStroke;
        changed();
    }

    public Color getMinorColor()
    {
        return minorColor;
    }

    public void setMinorColor(Color minorColor)
    {
        this.minorColor = minorColor;
        changed();
    }

    public BasicStroke getMinorStroke()
    {
        return minorStroke;
    }

    public void setMinorStroke(BasicStroke minorStroke)
    {
        this.minorStroke = minorStroke;
        changed();
    }

    public Color getTextColor()
    {
        return textColor;
    }

    public void setTextColor(Color textColor)
    {
        this.textColor = textColor;
        changed();

    }

    public BasicRadialTextPainter getTextPainter()
    {
        return textPainter;
    }

    public void setTextPainter(BasicRadialTextPainter textPainter)
    {
        this.textPainter = textPainter;
        changed();
    }

}
