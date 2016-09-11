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
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class TaperedPointer extends GradientPointer
{

    public TaperedPointer()
    {
    }

    public TaperedPointer(GradientPalette pointerColor)
    {
        super(pointerColor);
    }

    @Override
    protected Area getShape(Dimension dimensions)
    {
        final GeneralPath pointerShape;
//      
        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
        pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        double frontM = this.getRadiusPercent() * frontScale.getValue();
        double tailM = this.getRadiusPercent() * tailScale.getValue();

        pointerShape.moveTo(0.5 * imageWidth, centerY - (maxY * frontM));
        pointerShape.lineTo((0.5 - 0.015) * imageWidth, centerY + (maxY * tailM));
        pointerShape.lineTo(0.5 * imageWidth, centerY + (maxY * tailM) * 1.05);
        pointerShape.lineTo((0.5 + 0.015) * imageWidth, centerY + (maxY * tailM));

        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * frontM));
        pointerShape.closePath();

       return new Area(pointerShape);
    }

//    @Override
//    public void paint(Graphics2D graphics, Dimension dimensions)
//    {
//
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
//
//        final GeneralPath pointerShape;
////        
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        final double centerY = dimensions.getHeight() / 2.0;
//        final double maxY = dimensions.getHeight() / 2.0;
//        double frontM = this.getRadiusPercent() * frontScale.getValue();
//        double tailM = this.getRadiusPercent() * tailScale.getValue();
//
//        pointerShape.moveTo(0.5 * imageWidth, centerY - (maxY * frontM));
//        pointerShape.lineTo((0.5 - 0.015) * imageWidth, centerY + (maxY * tailM));
//        pointerShape.lineTo(0.5 * imageWidth, centerY + (maxY * tailM) * 1.05);
//        pointerShape.lineTo((0.5 + 0.015) * imageWidth, centerY + (maxY * tailM));
//
//        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * frontM));
//        pointerShape.closePath();
//
//        graphics.setPaint(new LinearGradientPaint(
//                new Point2D.Double(0.5 * imageWidth, centerY - (maxY * frontM)),
//                new Point2D.Double(0.5 * imageWidth, 0.5046 * imageHeight),
//                new float[]
//                {
//                    0.0f, 1.0f
//                },
//                new Color[]
//                {
//                    this.getPrimaryColor().getMedium(), this.getPrimaryColor().getMediumDark()
//                }));
//        graphics.fill(pointerShape);
//        graphics.setColor(this.getPrimaryColor().getMediumDark());
//
//        graphics.setStroke(new BasicStroke((0.004672897196261682f * imageWidth), 0, 1));
//        graphics.draw(pointerShape);
//
//        graphics.dispose();
//    }
}
