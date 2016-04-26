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
import us.jaba.titaniumblocks.core.bargraph.BargraphImage;
import us.jaba.titaniumblocks.core.bargraph.types.linear.BargraphGradient20;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;

/**
 *
 * @author tbeckett
 */
public class SingleBargraphDisplay extends SingleDisplay
{

    private BargraphImage bargraphImage = new BargraphImage(new BargraphGradient20());

    public SingleBargraphDisplay()
    {
        super(ColorPalette.WHITE);
        BargraphGradient20 b = new BargraphGradient20();
        bargraphImage = new BargraphImage(b);
        b.setColor(ColorPalette.RED);

        setValue(43.0);
    }

    @Override
    public void paintPreText(Graphics2D graphics, BufferedImage image, Dimension interiorDim, int offset)
    {
        BufferedImage nimage = bargraphImage.build(interiorDim);
        graphics.drawImage(nimage, offset, offset, null);
    }

   
    public void setValue(double value)
    {
        ((DoubleValueText)super.getValueText()).setDoubleValue(value);
        BargraphGradient20 bg = (BargraphGradient20) bargraphImage.getPainter();
        bg.setValue(value);
    }

}
