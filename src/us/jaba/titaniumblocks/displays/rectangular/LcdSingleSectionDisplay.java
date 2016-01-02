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
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.bargraph.BargraphImage;
import us.jaba.titaniumblocks.core.bargraph.models.linear.Bargraph20;
import us.jaba.titaniumblocks.core.sections.SectionImageFactory;
import us.jaba.titaniumblocks.core.sections.painters.BasicSection;
import us.jaba.titaniumblocks.core.text.painters.DoubleValueText;

/**
 *
 * @author tbeckett
 */
public class LcdSingleSectionDisplay extends LcdSingleDisplay
{

    SectionImageFactory section;
    BasicSection basicSection;

    public LcdSingleSectionDisplay()
    {
        super();
        basicSection = new BasicSection();
        section = new SectionImageFactory(basicSection);
        basicSection.setColor(Color.RED);

        setValue(43.0);
    }

    @Override
    public void paintPreText(Graphics2D graphics, BufferedImage image, Dimension interiorDim, int offset)
    {
        super.paintPreText(graphics, image, interiorDim, offset);
        BufferedImage nimage = section.build(interiorDim);
        graphics.drawImage(nimage, offset, offset, null);
    }

    public void setValue(double value)
    {
        ((DoubleValueText) super.getTextPainter()).setValue(value);
        basicSection.setValue(value);
    }

}