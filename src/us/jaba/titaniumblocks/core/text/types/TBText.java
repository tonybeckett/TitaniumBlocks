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
package us.jaba.titaniumblocks.core.text.types;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.text.Text;

/**
 *
 * @author tbeckett
 */
public class TBText extends Text
{

    private final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);

    private String value = "tb";

    public TBText()
    {
        super(BaseFont.DEFAULT_FONT.deriveFont(Font.ITALIC), ColorPalette.BLACK);
        setFontSize(10);
    }

    @Override
    protected void paintText(final Graphics2D graphics, final Dimension dimensions)
    {
        final double imageWidth = dimensions.getWidth();
        final double imageHeight = dimensions.getHeight();

        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        graphics.setColor(getColor());
        graphics.setFont(getFont());
        TextLayout stringLayout = new TextLayout(value, graphics.getFont(), RENDER_CONTEXT);
        Rectangle2D boundary = new Rectangle2D.Double();

        boundary.setFrame(stringLayout.getBounds());
        graphics.drawString(value,
                (int) ((imageWidth / 2.0) - (stringLayout.getBounds().getWidth() / 2)),
                (int) ((imageHeight * 0.68) - stringLayout.getBounds().getHeight())
        );

        FontRenderContext frc = graphics.getFontRenderContext();
        graphics.translate((int) (imageWidth / 2.0), (int) (imageHeight * 3.0 / 4.0));



    }

    public String getIntegerValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
        changed();
    }

}
