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
package us.jaba.titaniumblocks.core.pointers.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.pointers.AbstractPointerPainter;
import us.jaba.titaniumblocks.core.color.GradientPalette;

/**
 *
 * @author tbeckett
 */
public class TaperedRoundedPointerPainter extends AbstractPointerPainter
{

    public TaperedRoundedPointerPainter()
    {
    }

    public TaperedRoundedPointerPainter(GradientPalette pointerColor)
    {
        super(pointerColor);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath POINTER;
//        
        POINTER = new GeneralPath();
        POINTER.setWindingRule(Path2D.WIND_EVEN_ODD);

        POINTER.moveTo(0.5 * imageWidth, 0.125 * imageHeight);
        POINTER.lineTo((0.5-0.015) /*0.485*/ * imageWidth, 0.5 * imageHeight);
        POINTER.lineTo(0.5 * imageWidth, 0.5046 * imageHeight);
        POINTER.lineTo((0.5+0.015)/*0.509*/ * imageWidth, 0.5 * imageHeight);

        POINTER.lineTo(0.5 * imageWidth, 0.125 * imageHeight);
        POINTER.closePath();

        graphics.setPaint(new LinearGradientPaint(
                new Point2D.Double(0.5 * imageWidth, 0.125 * imageHeight),
                new Point2D.Double(0.5 * imageWidth, 0.5046 * imageHeight),
                new float[]
                {
                    0.0f, 1.0f
                },
                new Color[]
                {
                    this.getPointerColor().getMedium(), this.getPointerColor().getMediumDark()
                }));
        graphics.fill(POINTER);
        graphics.setColor(this.getPointerColor().getMediumDark());

        graphics.setStroke(new BasicStroke((0.004672897196261682f * imageWidth), 0, 1));
        graphics.draw(POINTER);

        graphics.dispose();
    }
}