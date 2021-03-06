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
package us.jaba.titaniumblocks.core.symbols;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.image.SoftClipImageGenerator;
import us.jaba.titaniumblocks.core.shadows.DropShadowImageGenerator;
import us.jaba.titaniumblocks.core.color.ColorTools;

/**
 *
 * @author tbeckett
 */
public class Symbol extends CoreBean
{

    private boolean glowEnabled = false;

    private Color paintColor;

    public Symbol()
    {
        paintColor = ColorPalette.GRAY;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);
        
        graphics.setColor(paintColor);
        GeneralPath symbol = new GeneralPath();
        paintSymbol(symbol, dimensions);

        int imageWidth = (int) dimensions.getWidth();
//        int imageHeight = (int) dimensions.getHeight();

        Color FILL_COLOR = paintColor.brighter();
        Color STROKE_COLOR = ColorTools.setAlpha(paintColor.darker(), 0.5f);
        Color GLOW_COLOR = paintColor.brighter();

        if (glowEnabled)
        {
            BufferedImage clipImage = SoftClipImageGenerator.create(symbol, FILL_COLOR);

            final double OFFSET = 0.12 * imageWidth;
            graphics.translate(-OFFSET, -OFFSET);
            graphics.drawImage(DropShadowImageGenerator.create(clipImage, 0, 0.65f, (int) OFFSET, 315, GLOW_COLOR), symbol.getBounds().x, symbol.getBounds().y, null);
            graphics.translate(OFFSET, OFFSET);
        } else
        {
            graphics.setPaint(FILL_COLOR);
            graphics.fill(symbol);
            graphics.setStroke(new BasicStroke(0.5f));
            graphics.setColor(STROKE_COLOR);
            graphics.draw(symbol);
        }
        graphics.dispose();
    }

    public Color getPaintColor()
    {
        return paintColor;
    }

    public void setPaintColor(Color paintColor)
    {
        this.paintColor = paintColor;
        changed();
    }

    public boolean isGlowEnabled()
    {
        return glowEnabled;
    }

    public void setGlowEnabled(boolean glowEnabled)
    {
        this.glowEnabled = glowEnabled;
        changed();
    }

    protected void paintSymbol(GeneralPath path, Dimension dimensions)
    {
        // intentional
    }

}
