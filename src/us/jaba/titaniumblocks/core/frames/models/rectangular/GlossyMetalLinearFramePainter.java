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
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.frames.RectangularFramePainter;
import us.jaba.titaniumblocks.core.gradients.paint.ContourGradientPaint;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GlossyMetalLinearFramePainter extends RectangularFramePainter
{

   

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions)
    {
        /**
         * Creates the frame image for a linear gauge. The image parameters and
         * the image will be cached. If the current request has the same
         * parameters as the last request it will return the already created
         * image instead of creating a new image. If an image is passed to the
         * method, it will paint to the image and return this image. This will
         * reduce the memory consumption.
         *
         * @param WIDTH
         * @param HEIGHT
         * @param FRAME_DESIGN
         * @param FRAME_EFFECT
         * @param FRAME_BASECOLOR
         * @param FRAME_BASECOLOR_ENABLED
         * @param CUSTOM_FRAME_DESIGN
         * @param BACKGROUND_IMAGE
         * @return a buffered image that contains the frame image for a linear
         * gauge
         */

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final double OUTER_FRAME_CORNER_RADIUS;
        if (imageWidth >= imageHeight)
        {
            OUTER_FRAME_CORNER_RADIUS = imageHeight * 0.05;
        } else
        {
            OUTER_FRAME_CORNER_RADIUS = imageWidth * 0.05;
        }

        final Area OUTER_FRAME = new Area(new RoundRectangle2D.Double(0.0, 0.0, imageWidth, imageHeight, OUTER_FRAME_CORNER_RADIUS, OUTER_FRAME_CORNER_RADIUS));
        graphics.setPaint(outerFrameColor);
        // The outer frame will be painted later because first we have to subtract the inner background

        final double FRAME_MAIN_CORNER_RADIUS;
        if (imageWidth >= imageHeight)
        {
            FRAME_MAIN_CORNER_RADIUS = OUTER_FRAME_CORNER_RADIUS - ((OUTER_FRAME.getBounds2D().getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            FRAME_MAIN_CORNER_RADIUS = OUTER_FRAME_CORNER_RADIUS - ((OUTER_FRAME.getBounds2D().getWidth() - imageWidth - 2) / 2.0);
        }
        final Area FRAME_MAIN = new Area(new RoundRectangle2D.Double(1.0, 1.0, imageWidth - 2, imageHeight - 2, FRAME_MAIN_CORNER_RADIUS, FRAME_MAIN_CORNER_RADIUS));
        final Point2D FRAME_MAIN_START = new Point2D.Double(0, FRAME_MAIN.getBounds2D().getMinY());
        final Point2D FRAME_MAIN_STOP = new Point2D.Double(0, FRAME_MAIN.getBounds2D().getMaxY());
        final Point2D FRAME_MAIN_CENTER = new Point2D.Double(FRAME_MAIN.getBounds2D().getCenterX(), FRAME_MAIN.getBounds2D().getCenterY());

        // Create shape that needs to be subtracted from rectangles
        final double SUBTRACT_CORNER_RADIUS;
        if (imageWidth >= imageHeight)
        {
            SUBTRACT_CORNER_RADIUS = imageHeight * 0.02857143;
        } else
        {
            SUBTRACT_CORNER_RADIUS = imageWidth * 0.02857143;
        }
        final Area SUBTRACT = new Area(new RoundRectangle2D.Double(
                 FRAME_MAIN.getBounds2D().getX() + frameThickness, 
                FRAME_MAIN.getBounds2D().getY() + frameThickness, 
                FRAME_MAIN.getBounds2D().getWidth() - (frameThickness*2), 
                FRAME_MAIN.getBounds2D().getHeight() - (frameThickness*2), 
                SUBTRACT_CORNER_RADIUS, SUBTRACT_CORNER_RADIUS));

        // Paint outer frame after we subtracted the inner background shape
        OUTER_FRAME.subtract(SUBTRACT);
        graphics.fill(OUTER_FRAME);

        final float ANGLE_OFFSET = (float) Math.toDegrees(Math.atan((imageHeight / 8.0f) / (imageWidth / 2.0f)));
//
        // The smaller side is important for the contour gradient
        float relFrameSize;
        if (imageWidth >= imageHeight)
        {
            relFrameSize = (32f / imageHeight);
        } else
        {
            relFrameSize = (32f / imageWidth);
        }
        float[] frameMainFractions4 =
        {
            0.0f,
            relFrameSize * 0.04f,
            1.0f
        };
        Color[] frameMainColors4 =
        {
            new Color(0.9568627451f, 0.9568627451f, 0.9568627451f, 1f),
            new Color(0.8117647059f, 0.8117647059f, 0.8117647059f, 1f),
            new Color(0.8117647059f, 0.8117647059f, 0.8117647059f, 1f)
        };
        Paint frameMainGradient4 = new ContourGradientPaint(OUTER_FRAME.getBounds2D(), frameMainFractions4, frameMainColors4);
        graphics.setPaint(frameMainGradient4);
        graphics.fill(FRAME_MAIN);

        final Area FRAME_MAIN_GLOSSY2 = new Area(new RoundRectangle2D.Double(2, 2, imageWidth - 4, imageHeight - 4, FRAME_MAIN_CORNER_RADIUS, FRAME_MAIN_CORNER_RADIUS));
        FRAME_MAIN_GLOSSY2.subtract(SUBTRACT);
        if (PointSupport.pointsEquals(0d, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY(), 0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY()))
        {
            graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY()), new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY() + 1), new float[]
            {
                0.0f, 0.1f, 0.26f, 0.73f, 1.0f
            }, new Color[]
            {
                new Color(0.9764705882f, 0.9764705882f, 0.9764705882f, 1f), new Color(0.7843137255f, 0.7647058824f, 0.7490196078f, 1f), new Color(1f, 1f, 1f, 1f), new Color(0.1137254902f, 0.1137254902f, 0.1137254902f, 1f), new Color(0.8196078431f, 0.8196078431f, 0.8196078431f, 1f)
            }));
        } else
        {
            graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY()), new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY()), new float[]
            {
                0.0f, 0.1f, 0.26f, 0.73f, 1.0f
            }, new Color[]
            {
                new Color(0.9764705882f, 0.9764705882f, 0.9764705882f, 1f), new Color(0.7843137255f, 0.7647058824f, 0.7490196078f, 1f), new Color(1f, 1f, 1f, 1f), new Color(0.1137254902f, 0.1137254902f, 0.1137254902f, 1f), new Color(0.8196078431f, 0.8196078431f, 0.8196078431f, 1f)
            }));
        }
        graphics.fill(FRAME_MAIN_GLOSSY2);

        final Area FRAME_MAIN_GLOSSY3 = new Area(new RoundRectangle2D.Double(15, 15, imageWidth - 30, imageHeight - 30, SUBTRACT_CORNER_RADIUS, SUBTRACT_CORNER_RADIUS));
        FRAME_MAIN_GLOSSY3.subtract(SUBTRACT);
        graphics.setPaint(new Color(0xf6f6f6));
        graphics.fill(FRAME_MAIN_GLOSSY3);

        final Area FRAME_MAIN_GLOSSY4 = new Area(new RoundRectangle2D.Double(16, 16, imageWidth - 32, imageHeight - 32, SUBTRACT_CORNER_RADIUS, SUBTRACT_CORNER_RADIUS));
        FRAME_MAIN_GLOSSY4.subtract(SUBTRACT);
        graphics.setPaint(new Color(0x333333));
        graphics.fill(FRAME_MAIN_GLOSSY4);
//
        this.getLinearEffect().paint(graphics, new Dimension(imageWidth, imageHeight), OUTER_FRAME);

        final double INNER_FRAME_CORNER_RADIUS;
        if (imageWidth >= imageHeight)
        {
            INNER_FRAME_CORNER_RADIUS = imageHeight * 0.02857143;
        } else
        {
            INNER_FRAME_CORNER_RADIUS = imageWidth * 0.02857143;
        }

        final Area INNER_FRAME = new Area(new java.awt.geom.RoundRectangle2D.Double(
                 FRAME_MAIN.getBounds2D().getX() + frameThickness, 
                FRAME_MAIN.getBounds2D().getY() + frameThickness, 
                FRAME_MAIN.getBounds2D().getWidth() - (frameThickness*2), 
                FRAME_MAIN.getBounds2D().getHeight() - (frameThickness*2), 
                INNER_FRAME_CORNER_RADIUS, INNER_FRAME_CORNER_RADIUS));
        graphics.setPaint(innerFrameColor);

        INNER_FRAME.subtract(SUBTRACT);
        graphics.fill(INNER_FRAME);

        graphics.dispose();

    }

}
