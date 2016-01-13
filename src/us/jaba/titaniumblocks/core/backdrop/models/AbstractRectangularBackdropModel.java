/*
 * Copyright (c) 2012, Gerrit Grunwald
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
package us.jaba.titaniumblocks.core.backdrop.models;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.shadows.InnerShadowImageGenerator;
import us.jaba.titaniumblocks.core.image.SoftClipImageGenerator;

/**
 *
 * @author hansolo
 */
public abstract class AbstractRectangularBackdropModel extends BackdropModel
{


    public AbstractRectangularBackdropModel()
    {
      
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final double outerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            outerAreaCornerRadius = imageHeight * 0.05;
        } else
        {
            outerAreaCornerRadius = imageWidth * 0.05;
        }
        final RoundRectangle2D outerArea = new RoundRectangle2D.Double(0.0, 0.0, imageWidth, imageHeight, outerAreaCornerRadius, outerAreaCornerRadius);
        final double mainAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getWidth() - imageWidth - 2) / 2.0);
        }
        final RoundRectangle2D mainArea = new RoundRectangle2D.Double(1.0, 1.0, imageWidth - 2, imageHeight - 2, mainAreaCornerRadius, mainAreaCornerRadius);

        final double innerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            innerAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            innerAreaCornerRadius = imageWidth * 0.02857143;
        }

        final RoundRectangle2D innerArea = new RoundRectangle2D.Double(mainArea.getX() + 0, mainArea.getY() + 0, mainArea.getWidth() - 0, mainArea.getHeight() - 0, innerAreaCornerRadius, innerAreaCornerRadius);

        final double BACKGROUND_CORNER_RADIUS = innerAreaCornerRadius - 1;

        final RoundRectangle2D GAUGE_BACKGROUND = new RoundRectangle2D.Double(innerArea.getX() + 1, innerArea.getY() + 1, innerArea.getWidth() - 2, innerArea.getHeight() - 2, BACKGROUND_CORNER_RADIUS, BACKGROUND_CORNER_RADIUS);
        final Point2D BACKGROUND_START = new Point2D.Double(0, GAUGE_BACKGROUND.getBounds2D().getMinY());
        final Point2D BACKGROUND_STOP = new Point2D.Double(0, GAUGE_BACKGROUND.getBounds2D().getMaxY());
        if (BACKGROUND_START.equals(BACKGROUND_STOP))
        {
            BACKGROUND_STOP.setLocation(0.0, BACKGROUND_START.getY() + 1);
        }

        Paint gaugeBackgroundGradient = getPaint(dimensions, GAUGE_BACKGROUND.getBounds());

        graphics.setPaint(gaugeBackgroundGradient);

        graphics.fill(GAUGE_BACKGROUND);

        final BufferedImage IMAGE = SoftClipImageGenerator.create((java.awt.Shape) GAUGE_BACKGROUND, gaugeBackgroundGradient, 0, 0, 0);
        BufferedImage CLP = InnerShadowImageGenerator.create((java.awt.Shape) GAUGE_BACKGROUND, gaugeBackgroundGradient, 0, 0.65f, ColorPalette.BLACK, 20, 315);

        graphics.drawImage(CLP, GAUGE_BACKGROUND.getBounds().x, GAUGE_BACKGROUND.getBounds().y, null);

        
        applyOverlay(graphics, dimensions, GAUGE_BACKGROUND.getBounds());

        graphics.dispose();

//        if (BACKGROUND_IMAGE != null)
//        {
//            final Graphics2D G = BACKGROUND_IMAGE.createGraphics();
//            G.drawImage(linBackgroundImage, 0, 0, null);
//            G.dispose();
//        }
    }

    
    protected abstract Paint getPaint(Dimension dimensions, Rectangle bounds);

    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Rectangle2D GAUGE_BACKGROUND)
    {

    }


}
