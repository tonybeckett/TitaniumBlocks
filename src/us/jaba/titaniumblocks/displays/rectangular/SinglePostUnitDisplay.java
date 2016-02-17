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
package us.jaba.titaniumblocks.displays.rectangular;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import static us.jaba.titaniumblocks.core.font.BaseFont.DEFAULT_FONT;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.StringPostUnitsText;

/**
 *
 * @author tbeckett
 */
public class SinglePostUnitDisplay extends SingleDisplay
{

    protected TextImageFactory unitTextImage;

    public SinglePostUnitDisplay()
    {
        super(ColorPalette.BLACK);

        Font unitFont = DEFAULT_FONT.deriveFont((float) (DEFAULT_FONT.getSize2D() / 2.0));
        StringPostUnitsText dvt = new StringPostUnitsText();
        dvt.setFont(unitFont);
        dvt.setRightOffsetFactor(0.05);
        unitTextImage = new TextImageFactory(dvt);
        valueTextImage.getTickmark().setRightOffsetFactor(0.25);
    }

    @Override
    public void paintPreText(Graphics2D graphics, BufferedImage image, Dimension interiorDim, int offset)
    {
        unitTextImage.getTickmark().setFontSize((float) (interiorDim.getHeight() / 3.0 * this.getFontScaleFactor()));
        unitTextImage.getTickmark().setColor(this.getColor());

        BufferedImage image2 = unitTextImage.build(interiorDim);
        graphics.drawImage(image2, offset, offset, null);
    }

    public Text getUnitTextPainter()
    {
        return unitTextImage.getTickmark();
    }

    public void setUnitTextPainter(Text unitTextPainter)
    {
        unitTextImage = new TextImageFactory(unitTextPainter);

    }

    @Override
    public void setValueTextPainter(Text valueTextPainter)
    {
        super.setValueTextPainter(valueTextPainter);
        valueTextPainter.setRightOffsetFactor(0.25);
    }

}
