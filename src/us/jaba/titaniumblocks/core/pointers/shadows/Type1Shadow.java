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
package us.jaba.titaniumblocks.core.pointers.shadows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class Type1Shadow extends GradientPointer
{

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

       
        final Color SHADOW_COLOR = new Color(0.0f, 0.0f, 0.0f, 0.65f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath pointerShape;

        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(imageWidth * 0.5186915887850467, imageHeight * 0.4719626168224299);
        pointerShape.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.45794392523364486, imageWidth * 0.5093457943925234, imageHeight * 0.4158878504672897, imageWidth * 0.5093457943925234, imageHeight * 0.40186915887850466);
        pointerShape.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.38317757009345793, imageWidth * 0.5, imageHeight * 0.1308411214953271, imageWidth * 0.5, imageHeight * 0.1308411214953271);
        pointerShape.curveTo(imageWidth * 0.5, imageHeight * 0.1308411214953271, imageWidth * 0.49065420560747663, imageHeight * 0.38317757009345793, imageWidth * 0.49065420560747663, imageHeight * 0.397196261682243);
        pointerShape.curveTo(imageWidth * 0.49065420560747663, imageHeight * 0.4158878504672897, imageWidth * 0.48598130841121495, imageHeight * 0.45794392523364486, imageWidth * 0.48130841121495327, imageHeight * 0.4719626168224299);
        pointerShape.curveTo(imageWidth * 0.4719626168224299, imageHeight * 0.48130841121495327, imageWidth * 0.4672897196261682, imageHeight * 0.49065420560747663, imageWidth * 0.4672897196261682, imageHeight * 0.5);
        pointerShape.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.5186915887850467, imageWidth * 0.48130841121495327, imageHeight * 0.5327102803738317, imageWidth * 0.5, imageHeight * 0.5327102803738317);
        pointerShape.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5327102803738317, imageWidth * 0.5327102803738317, imageHeight * 0.5186915887850467, imageWidth * 0.5327102803738317, imageHeight * 0.5);
        pointerShape.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.49065420560747663, imageWidth * 0.5280373831775701, imageHeight * 0.48130841121495327, imageWidth * 0.5186915887850467, imageHeight * 0.4719626168224299);
        pointerShape.closePath();
        graphics.setColor(SHADOW_COLOR);
        graphics.fill(pointerShape);

        graphics.dispose();
    }
}
