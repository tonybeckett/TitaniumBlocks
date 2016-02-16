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
package us.jaba.titaniumblocks.core.pointers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;

import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GradientPointer extends AbstractPointer
{

   private final float[] gradientFractionArray = new float[]
    {
        0.0f,
        0.4999f,
        0.5f,
        1.0f
    };

   private final Color SHADOW_COLOR = new Color(0.0f, 0.0f, 0.0f, 0.35f);

    public GradientPointer()
    {
        this(new PureBlack());
    }

    public GradientPointer(GradientPalette pointColor)
    {
        super(pointColor);

    }

    public GradientPointer(GradientPointer other)
    {
        super(other);
    }

    protected Shape getShape(Dimension dimensions)
    {
        return new GeneralPath();
    }

    private void paintShape(Graphics2D graphics, Dimension dimensions, Color[] gradientColorArray)
    {
        final Shape pointerShape = getShape(dimensions);

//        float magnitude = 1.0f - this.getRadiusPercent();
//        Point2D tip = new Point2D.Double(0.5, magnitude);//0.14953);
        final Point2D startPoint = new Point2D.Double(pointerShape.getBounds2D().getMinX(), 0);
        final Point2D stopPoint = new Point2D.Double(pointerShape.getBounds2D().getMaxX(), 0);

        if (PointSupport.pointsEqual(startPoint, stopPoint))
        {
            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
        }
        final Paint gradient = new LinearGradientPaint(startPoint, stopPoint, gradientFractionArray, gradientColorArray);
        graphics.setPaint(gradient);
        graphics.fill(pointerShape);

        graphics.draw(pointerShape);

    }

    @Override
    public void paintShadow(Graphics2D graphics, Dimension dimensions)
    {
        super.paintShadow(graphics, dimensions);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        final Color[] gradientColorArray = new Color[]
        {
            SHADOW_COLOR,
            SHADOW_COLOR,
            SHADOW_COLOR,
            SHADOW_COLOR,
        };
        graphics.setColor(SHADOW_COLOR);
        paintShape(graphics, dimensions, gradientColorArray);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        final Color[] gradientColorArray = new Color[]
        {
            this.getPointerColor().getMediumLight(),
            this.getPointerColor().getMediumLight(),
            this.getPointerColor().getMediumDark(),
            this.getPointerColor().getMediumDark()
        };
        graphics.setColor(this.getPointerColor().getMediumDark());
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        paintShape(graphics, dimensions, gradientColorArray);

        if (centerPinVisible)
        {
            double radius = Math.min(dimensions.width * 0.0089, 2.0);
            graphics.setColor(ColorPalette.ALUMINIUM);
            ShapeUtils.fillCircle(graphics, dimensions.getWidth() / 2.0, dimensions.getHeight() / 2.0, radius);
        }

        graphics.dispose();
    }
}
