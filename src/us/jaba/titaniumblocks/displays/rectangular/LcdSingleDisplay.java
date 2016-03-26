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
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.LcdBackdropModel;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.LcdGradientPalette;
import us.jaba.titaniumblocks.core.color.lcdgradients.Standard;
import us.jaba.titaniumblocks.displays.LinearDisplay;

/**
 *
 * @author tbeckett
 */
public class LcdSingleDisplay extends SingleDisplay implements LinearDisplay
{

    protected BackdropImageFactory lcdBackgroundImage;
    LcdGradientPalette palette = new Standard();

    public LcdSingleDisplay()
    {
        super(ColorPalette.WHITE);
        lcdBackgroundImage = new BackdropImageFactory(new LcdBackdropModel());

        this.valueTextImage.getPainter().setColor(palette.textColor);
    }

    @Override
    public void paintPreText(Graphics2D graphics, BufferedImage image, Dimension interiorDim, int offset)
    {
        ((LcdBackdropModel) lcdBackgroundImage.getPainter()).setPalette(palette);

        BufferedImage image2 = lcdBackgroundImage.build(interiorDim);
        graphics.drawImage(image2, offset, offset, null);
    }

    public Backdrop getLCDBackgroundPainter()
    {
        return lcdBackgroundImage.getPainter();
    }

    
    public LcdGradientPalette getPalette()
    {
        return palette;
    }

    public void setPalette(LcdGradientPalette palette)
    {
        this.palette = palette;
        this.valueTextImage.getPainter().setColor(palette.textColor);
        changed();
    }

}
