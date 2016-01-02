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
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TaperedPoint2PointerPainter extends AbstractPointerPainter
{

    public TaperedPoint2PointerPainter()
    {
    }

    public TaperedPoint2PointerPainter(GradientPalette pointerColor)
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
        final Point2D POINTER_START;
        final Point2D POINTER_STOP;
        final float[] POINTER_FRACTIONS;
        final Color[] POINTER_COLORS;
        final java.awt.Paint POINTER_GRADIENT;

        POINTER = new GeneralPath();
        POINTER.setWindingRule(Path2D.WIND_EVEN_ODD);
        POINTER.moveTo(0.48 * imageWidth, 0.505 * imageHeight);
        POINTER.lineTo(0.48 * imageWidth, 0.275 * imageHeight);
        POINTER.lineTo(0.46 * imageWidth, 0.275 * imageHeight);
        POINTER.lineTo(0.495 * imageWidth, 0.15 * imageHeight);
        POINTER.lineTo(0.53 * imageWidth, 0.275 * imageHeight);
        POINTER.lineTo(0.515 * imageWidth, 0.275 * imageHeight);
        POINTER.lineTo(0.515 * imageWidth, 0.505 * imageHeight);
        POINTER.closePath();
        POINTER_START = new Point2D.Double(0.46 * imageWidth, 0.26 * imageHeight);
        POINTER_STOP = new Point2D.Double(0.53 * imageWidth, 0.26 * imageHeight);
        POINTER_FRACTIONS = new float[]
        {
            0.0f,
            0.5f,
            1.0f
        };
//       
            POINTER_COLORS = new Color[]
            {
                this.getPointerColor().getDarkest(),
                this.getPointerColor().getMediumDark(),
                this.getPointerColor().getDarkest()
            };
        
        if (PointSupport.pointsEqual(POINTER_START, POINTER_STOP))
        {
            POINTER_STOP.setLocation(POINTER_STOP.getX(), POINTER_STOP.getY() + 1);
        }
        POINTER_GRADIENT = new LinearGradientPaint(POINTER_START, POINTER_STOP, POINTER_FRACTIONS, POINTER_COLORS);
        graphics.setPaint(POINTER_GRADIENT);
        graphics.fill(POINTER);

        graphics.dispose();
    }
}