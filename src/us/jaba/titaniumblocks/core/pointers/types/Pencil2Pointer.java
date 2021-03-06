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
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.pointers.GradientPointer;

/**
 *
 * @author tbeckett
 */
public class Pencil2Pointer extends GradientPointer
{

    public Pencil2Pointer()
    {
        this(new PureBlack());
    }

    public Pencil2Pointer(GradientPalette pointerColor)
    {
        super(pointerColor);
    }

    public Pencil2Pointer(GradientPointer other)
    {
        super(other);
    }

    @Override
    protected Area getShape(Dimension dimensions)
    {

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final int centerY = imageHeight / 2;
        final int maxY = imageHeight / 2;
        double frontM = this.getRadiusPercent() * frontScale.getValue();
        double tailM = this.getRadiusPercent() * tailScale.getValue();

        GeneralPath pointerShape = new GeneralPath();
        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
        pointerShape.moveTo(0.4859 * imageWidth, centerY - (maxY * 0.86 * frontM));
        pointerShape.lineTo(0.5 * imageWidth, centerY - (maxY * 0.92 * frontM));
        pointerShape.lineTo(0.5141 * imageWidth, centerY - (maxY * 0.86 * frontM));
        pointerShape.lineTo(0.5141 * imageWidth,  centerY + (maxY * tailM));
        pointerShape.lineTo(0.4859 * imageWidth, centerY + (maxY * tailM));
        pointerShape.lineTo(0.4859 * imageWidth, centerY - (maxY * 0.86 * frontM));
        pointerShape.closePath();

        Area pointerLine = new Area(pointerShape);

//        double radius = dimensions.width * centerScale.getValue();
//        Area pointerPost = new Area(new Ellipse2D.Double((imageWidth / 2) - radius, (imageHeight / 2) - radius, radius * 2, radius * 2));
//        pointerLine.add(pointerPost);
        // pointerLine.setWindingRule(Path2D.WIND_EVEN_ODD);
        return new Area(pointerLine);

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
//        final Point2D startPoint;
//        final Point2D stopPoint;
//        final float[] gradientFractionArray;
//        final Color[] gradientColorArray;
//        final java.awt.Paint gradient;
//        float radiusAdj = 1.0f - this.getRadiusPercent();
//
//        pointerShape = new GeneralPath();
//        pointerShape.setWindingRule(Path2D.WIND_EVEN_ODD);
//        pointerShape.moveTo(0.48598130841121495 * imageWidth, 0.16822429906542055 * imageHeight);
//        pointerShape.lineTo(0.5 * imageWidth, 0.1308411214953271 * imageHeight);
//        pointerShape.lineTo(0.5093457943925234 * imageWidth, 0.16822429906542055 * imageHeight);
//        pointerShape.lineTo(0.5093457943925234 * imageWidth, 0.5093457943925234 * imageHeight);
//        pointerShape.lineTo(0.48598130841121495 * imageWidth, 0.5093457943925234 * imageHeight);
//        pointerShape.lineTo(0.48598130841121495 * imageWidth, 0.16822429906542055 * imageHeight);
//        pointerShape.closePath();
//
//        graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0.48598130841121495 * imageWidth, 0), new Point2D.Double(0.5093457943925234 * imageHeight, 0), new float[]
//        {
//            0f, 0.5f, 1f
//        }, new Color[]
//        {
//            this.getPointerColor().getDarkest(), this.getPointerColor().getMediumLight(), this.getPointerColor().getDarkest()
//        }));
////        
//        graphics.fill(pointerShape);
//
//        graphics.dispose();
//    }
}
