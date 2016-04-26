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
package us.jaba.titaniumblocks.core.text.types;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.lcdgradients.Standard;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.font.FontSupport;
import us.jaba.titaniumblocks.core.math.Angle;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.painter.BasicRadialTextPainter;
import us.jaba.titaniumblocks.core.text.painter.FacingDown;

/**
 *
 * @author tbeckett
 */
public class PolarText extends Text
{

    public static final double DEFAULT_TEXT_SCALE = 0.5;
//    private final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);

    protected Scale textSizeScale = new Scale(DEFAULT_TEXT_SCALE);

    private Scale radiusAdjust = new Scale(0.5);
    private Angle angle = new Angle(0.0);
    protected BasicRadialTextPainter textPainter = new FacingDown();
    protected Point2D centerPoint = new Point2D.Double(10, 10);
    private String[] strings =
    {
        value
    };

    public PolarText()
    {
        super(BaseFont.DEFAULT_FONT, new Standard().getTextColor());

        this.setFont(FontSupport.getStandardFont().deriveFont(Font.BOLD, (float) (textSizeScale.getValue() * 500.0)));
    }

    @Override
    protected void paintText(final Graphics2D graphics, final Dimension dimensions)
    {
        //       final double imageWidth = dimensions.getWidth();
        final double imageHeight = dimensions.getHeight();
//        final int centerY = (int) (imageHeight / 2.0);
        final double maxY = (int) (imageHeight / 2.0);
        //       final int yPos = (int) (this.scale.getValue() * maxY);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setColor(getColor());

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        centerPoint.setLocation((dimensions.getWidth() / 2.0), (dimensions.getHeight() / 2.0));

        graphics.setFont(getFont().deriveFont(getFont().getStyle(), (int) (textSizeScale.getValue() * dimensions.getWidth() / 10.0)));
//        Font f = getFont().deriveFont(getFont().getStyle(), (int) (dimensions.width / 500.0 * getFont().getSize()));
//        graphics.setFont(f);
//        TextLayout stringLayout = new TextLayout(value, graphics.getFont(), RENDER_CONTEXT);
//        Rectangle2D boundary = new Rectangle2D.Double();
//
//        boundary.setFrame(stringLayout.getBounds());
//        graphics.drawString(value,
//                (int) ((imageWidth / 2.0) - (stringLayout.getBounds().getWidth() / 2)),
//                centerY - yPos //(int) (imageHeight / 3.25)
//        );
        strings[0] = value;
        textPainter.paint(graphics, centerPoint, radius * radiusAdjust.getValue(), angle.getValue(), 0.0, strings);

    }

    public Scale getRadiusAdjust()
    {
        return radiusAdjust;
    }

    public void setRadiusAdjust(Scale radiusAdjust)
    {
        this.radiusAdjust = radiusAdjust;
        changed();
    }

    public Angle getAngle()
    {
        return angle;
    }

    public void setAngle(Angle angle)
    {
        this.angle = angle;
        changed();
    }

    public BasicRadialTextPainter getTextPainter()
    {
        return textPainter;
    }

    public void setTextPainter(BasicRadialTextPainter textPainter)
    {
        this.textPainter = textPainter;
        changed();
    }

    public Scale getTextSizeScale()
    {
        return textSizeScale;
    }

    public void setTextSizeScale(Scale textSizeScale)
    {
        this.textSizeScale = textSizeScale;
        changed();
    }
}
