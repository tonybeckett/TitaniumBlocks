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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static us.jaba.titaniumblocks.core.font.BaseFont.DEFAULT_FONT;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.TextPainter;
import us.jaba.titaniumblocks.core.text.painters.StringPreUnitsText;

/**
 *
 * @author tbeckett
 */
public class SinglePreUnitDisplay extends SingleDisplay
{

    private static final float DEFAULT_RIGHT_OFFSET_SCALE = 0.05f;
    protected TextImageFactory unitTextImage;

    public SinglePreUnitDisplay()
    {
        super(Color.BLACK);

        Font unitFont = DEFAULT_FONT;
        StringPreUnitsText dvt = new StringPreUnitsText("$");
        dvt.setFont(unitFont);
        dvt.setRightOffsetFactor(DEFAULT_RIGHT_OFFSET_SCALE);
        unitTextImage = new TextImageFactory(dvt);

    }

    @Override
    public void paintPreText(Graphics2D graphics, BufferedImage image, Dimension interiorDim, int offset)
    {
        unitTextImage.getPainter().setFontSize(valueTextImage.getPainter().getFont().getSize());
        unitTextImage.getPainter().setColor(this.getColor());

        image = unitTextImage.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);
    }

    public TextPainter getUnitTextPainter()
    {
        return unitTextImage.getPainter();
    }

    @Override
    public void setValueTextPainter(TextPainter valueTextPainter)
    {
        super.setValueTextPainter(valueTextPainter); 
        valueTextPainter.setRightOffsetFactor(DEFAULT_RIGHT_OFFSET_SCALE);
    }


    

}
