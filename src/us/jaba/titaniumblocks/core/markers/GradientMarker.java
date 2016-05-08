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
package us.jaba.titaniumblocks.core.markers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;

import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GradientMarker extends Marker
{

    private GradientPalette color = new PureBlack();
    protected final float[] gradientFractionArray = new float[]
    {
        0.0f,
        0.4999f,
        0.5f,
        1.0f
    };

    protected Color[] gradientColors = new Color[]
    {
        this.getColor().getMediumLight(),
        this.getColor().getMediumLight(),
        this.getColor().getMediumDark(),
        this.getColor().getMediumDark()
    };
    private BasicStroke stroke;
    private boolean threeD;

    public GradientMarker()
    {
        this(new PureBlack());

        stroke = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    }

    public GradientMarker(GradientPalette color)
    {
        super();
        this.color = color;

    }

    protected Area getShape(Dimension dimensions)
    {
        return new Area();
    }

    public GradientPalette getColor()
    {
        return color;
    }

    public void setColor(GradientPalette color)
    {
        this.color = color;
        changed();

        gradientColors[0] = color.getMediumLight();
        gradientColors[1] = color.getMediumLight();
        gradientColors[2] = color.getMediumDark();
        gradientColors[3] = color.getMediumDark();
    }

    public boolean isThreeD()
    {
        return threeD;
    }

    public void setThreeD(boolean threeD)
    {
        this.threeD = threeD;
        changed();
    }

    protected void paintShape(Graphics2D graphics, Dimension dimensions, Area shape, Color[] gradientColorArray)
    {

        stroke = new BasicStroke(((float) dimensions.width / 500.0f * 1.0F), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final Point2D startPoint = new Point2D.Double(shape.getBounds2D().getMinX(), 0);
        final Point2D stopPoint = new Point2D.Double(shape.getBounds2D().getMaxX(), 0);

        if (PointSupport.pointsEqual(startPoint, stopPoint))
        {
            stopPoint.setLocation(stopPoint.getX(), stopPoint.getY() + 1);
        }
        final Paint gradient = new LinearGradientPaint(startPoint, stopPoint, gradientFractionArray, gradientColorArray);
        if (this.isThreeD())
        {
            graphics.setPaint(gradient);
        } else
        {
            graphics.setPaint(gradientColorArray[0]);
        }
        graphics.fill(shape);
        if (this.showOutline)
        {
            graphics.setColor(this.getOutlineColor());
            graphics.setStroke(stroke);
        }
        graphics.draw(shape);

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

        graphics.setColor(this.getColor().getMediumDark());
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));

        Area shape = getShape(dimensions);

        paintShape(graphics, dimensions, shape, gradientColors);

        graphics.dispose();
    }
}
