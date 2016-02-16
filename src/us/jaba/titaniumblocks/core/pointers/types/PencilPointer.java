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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class PencilPointer extends GradientPointer
{

    private Color labelColor;

    public PencilPointer()
    {
        labelColor = ColorPalette.BLACK;
    }

    public PencilPointer(GradientPalette pointerColor, Color labelColor)
    {
        super(pointerColor);
        this.labelColor = labelColor;
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
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight/ 2;
        double magnitude = this.getRadiusPercent() * frontScale.getValue();
        final GeneralPath pointerShape;

        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(0.48598130841121495 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * 0.94 * magnitude));
        pointerShape.lineTo(0.5093457943925234 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.lineTo(0.5093457943925234 * imageWidth, 0.5093457943925234 * imageHeight);
        pointerShape.lineTo(0.48598130841121495 * imageWidth, 0.5093457943925234 * imageHeight);
        pointerShape.lineTo(0.48598130841121495 * imageWidth, centerY - (maxY * 0.84 * magnitude));
        pointerShape.closePath();

        graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0.5 * imageWidth, 0.5 * imageHeight), new Point2D.Double(0.5 * imageWidth, 0.1308411214953271 * imageHeight), new float[]
        {
            0.0f, 0.849999f, 0.85f, 1.0f
        }, new Color[]
        {
            labelColor, labelColor, this.getPointerColor().getMediumDark(), getPointerColor().getMediumDark()
        }));
//        
        graphics.fill(pointerShape);

        graphics.dispose();
    }

    public Color getLabelColor()
    {
        return labelColor;
    }

    public void setLabelColor(Color labelColor)
    {
        this.labelColor = labelColor;
    }

}
