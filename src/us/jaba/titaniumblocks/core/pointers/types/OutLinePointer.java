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
package us.jaba.titaniumblocks.core.pointers.types;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Aluminum;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class OutLinePointer extends GradientPointer
{

    public OutLinePointer()
    {
        super(new Aluminum());
        tailScale = new Scale(0.25);
    }

    public OutLinePointer(GradientPalette pointerColor)
    {
        super(pointerColor);
        tailScale = new Scale(0.25);
    }

    public OutLinePointer(GradientPointer other)
    {
        super(other);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        GeneralPath pointerShape;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        graphics.setColor(this.getPrimaryColor().getDarkest());

        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();

        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        double frontM = this.getRadiusPercent() * frontScale.getValue();
        double tailM = this.getRadiusPercent() * tailScale.getValue();

        pointerShape = new GeneralPath(new Rectangle2D.Double((imageWidth * 0.49532) - 2, centerY - (maxY * frontM),
                (imageWidth * 0.00934) + 5, (maxY * frontM) + (maxY * tailM)
        )
        );
        graphics.fill(pointerShape);

        graphics.setColor(this.getSecondaryColor().getMedium());

        pointerShape = new GeneralPath(new Rectangle2D.Double((imageWidth * 0.49532), centerY - (maxY * frontM) + 2,
                (imageWidth * 0.00934) + 1, (maxY * frontM))); //imageHeight * 0.37383));
        graphics.fill(pointerShape);

        graphics.dispose();
    }
}
