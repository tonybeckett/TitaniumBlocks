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
package us.jaba.titaniumblocks.core.textures.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.gradients.GradientSupport;
import us.jaba.titaniumblocks.core.textures.Texture;

/**
 *
 * @author tbeckett
 */
public class PunchedSheetTexture extends Texture
{

    private static final float[] FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private static final Color[] COLORS =
    {
        new Color(0, 0, 0, 255),
        new Color(68, 68, 68, 255)
    };

    private Color brushColor;

    public Color getBrushColor()
    {
        return brushColor;
    }

    public void setBrushColor(Color brushColor)
    {
        this.brushColor = brushColor;
        changed();
    }

    public PunchedSheetTexture()
    {
        brushColor = new Color(0x1D2123);
    }

    public PunchedSheetTexture(Color brushColor)
    {
        this.brushColor = brushColor;
        changed();
    }

    @Override
    public void paint(Graphics2D graphics2D, Dimension dimensions)
    {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int resultWidth = (int) dimensions.getWidth();
        final int resultHeight = (int) dimensions.getHeight();

        final Rectangle2D rect = new Rectangle2D.Double(0.0, 0.0, resultWidth, resultHeight);
        graphics2D.setColor(brushColor);
        graphics2D.fill(rect);

        //final Color DARK = new Color(0x050506);
        final Color darkColor = brushColor.darker().darker();

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.0,
                resultHeight * 0.06666667,
                resultWidth * 0.40000,
                resultHeight * 0.4000,
                FRACTIONS,
                COLORS
        );

        final Ellipse2D ULF = new Ellipse2D.Double(resultWidth * 0.0,
                resultHeight * 0.0,
                resultWidth * 0.40000,
                resultHeight * 0.4000);
        graphics2D.setColor(darkColor);
        graphics2D.fill(ULF);

        GradientSupport.fillLinearYAxis(graphics2D,
                resultWidth * 0.466666,
                resultHeight * 0.53333,
                resultWidth * 0.400000,
                resultHeight * 0.39999,
                FRACTIONS,
                COLORS
        );

        final Ellipse2D LRF = new Ellipse2D.Double(resultWidth * 0.46666, resultHeight * 0.46666,
                resultWidth * 0.40, resultHeight * 0.40);
        graphics2D.setColor(darkColor);
        graphics2D.fill(LRF);

        graphics2D.dispose();

    }

}
