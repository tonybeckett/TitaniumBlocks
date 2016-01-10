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
package us.jaba.titaniumblocks.core.frames.models.rectangular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.frames.RectangularFrameEffectPainter;
import us.jaba.titaniumblocks.core.frames.RectangularFramePainter;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

/**
 *
 * @author tbeckett
 */
public class ChromeLinearFramePainter extends RectangularFramePainter
{

    float[] frameMainFractions7 =
    {
        0.0f,
        0.09f,
        0.12f,
        0.16f,
        0.25f,
        0.29f,
        0.33f,
        0.38f,
        0.48f,
        0.52f,
        0.63f,
        0.68f,
        0.8f,
        0.83f,
        0.87f,
        0.97f,
        1.0f
    };
    
     Color[] frameMainColors7 =
        {
            new Color(255, 255, 255, 255),
            new Color(255, 255, 255, 255),
            new Color(136, 136, 138, 255),
            new Color(164, 185, 190, 255),
            new Color(158, 179, 182, 255),
            new Color(112, 112, 112, 255),
            new Color(221, 227, 227, 255),
            new Color(155, 176, 179, 255),
            new Color(156, 176, 177, 255),
            new Color(254, 255, 255, 255),
            new Color(255, 255, 255, 255),
            new Color(156, 180, 180, 255),
            new Color(198, 209, 211, 255),
            new Color(246, 248, 247, 255),
            new Color(204, 216, 216, 255),
            new Color(164, 188, 190, 255),
            new Color(255, 255, 255, 255)
        };

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions)
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

        final Area outerArea = new Area(new RoundRectangle2D.Double(0.0, 0.0, imageWidth, imageHeight, outerAreaCornerRadius, outerAreaCornerRadius));
        graphics.setPaint(outerFrameColor);
        // The outer frame will be painted later because first we have to subtract the inner background

        final double mainAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getWidth() - imageWidth - 2) / 2.0);
        }
        final Area mainArea = new Area(new RoundRectangle2D.Double(1.0, 1.0, imageWidth - 2, imageHeight - 2, mainAreaCornerRadius, mainAreaCornerRadius));
        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        // Create shape that needs to be subtracted from rectangles
        final double subtractAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            subtractAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            subtractAreaCornerRadius = imageWidth * 0.02857143;
        }
        final Area subtractArea = new Area(new RoundRectangle2D.Double(
                mainArea.getBounds2D().getX() + frameThickness,
                mainArea.getBounds2D().getY() + frameThickness,
                mainArea.getBounds2D().getWidth() - (frameThickness * 2),
                mainArea.getBounds2D().getHeight() - (frameThickness * 2),
                subtractAreaCornerRadius, subtractAreaCornerRadius));

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        final float angleOffset = (float) Math.toDegrees(Math.atan((imageHeight / 8.0f) / (imageWidth / 2.0f)));
//

       

        Paint frameMainGradient7 = new ConicalGradientPaint(false, mainCenterPoint, 0, frameMainFractions7, frameMainColors7);
        graphics.setPaint(frameMainGradient7);
        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);
//
        this.getLinearEffect().paint(graphics, new Dimension(imageWidth, imageHeight), outerArea);

        final double innerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            innerAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            innerAreaCornerRadius = imageWidth * 0.02857143;
        }

        final Area innerArea = new Area(new java.awt.geom.RoundRectangle2D.Double(
                mainArea.getBounds2D().getX() + frameThickness,
                mainArea.getBounds2D().getY() + frameThickness,
                mainArea.getBounds2D().getWidth() - (frameThickness * 2),
                mainArea.getBounds2D().getHeight() - (frameThickness * 2),
                innerAreaCornerRadius, innerAreaCornerRadius));
        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

}
