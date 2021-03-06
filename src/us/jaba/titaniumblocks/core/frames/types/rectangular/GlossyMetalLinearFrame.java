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
package us.jaba.titaniumblocks.core.frames.types.rectangular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.frames.RectangularFrame;
import us.jaba.titaniumblocks.core.gradients.paint.ContourGradientPaint;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GlossyMetalLinearFrame extends RectangularFrame
{

     

    private static final Color[] COLOR_ARRAY =
    {
        new Color(0.9568627451f, 0.9568627451f, 0.9568627451f, 1f),
        new Color(0.8117647059f, 0.8117647059f, 0.8117647059f, 1f),
        new Color(0.8117647059f, 0.8117647059f, 0.8117647059f, 1f)
    };

    public GlossyMetalLinearFrame()
    {
        super(NULL_FRACTION_ARRAY, COLOR_ARRAY);
    }

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {

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

        final double mainAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getWidth() - imageWidth - 2) / 2.0);
        }

        // Create shape that needs to be subtracted from rectangles
        final double subtractAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            subtractAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            subtractAreaCornerRadius = imageWidth * 0.02857143;
        }

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

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

        Paint frameMainGradient4 = new ContourGradientPaint(outerArea.getBounds2D(), frameMainFractions4, COLOR_ARRAY);
        graphics.setPaint(frameMainGradient4);
        graphics.fill(mainArea);

        final Area FRAME_MAIN_GLOSSY2 = new Area(new RoundRectangle2D.Double(2, 2, imageWidth - 4, imageHeight - 4, mainAreaCornerRadius, mainAreaCornerRadius));
        FRAME_MAIN_GLOSSY2.subtract(subtractArea);
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

        final Area FRAME_MAIN_GLOSSY3 = new Area(new RoundRectangle2D.Double(15, 15, imageWidth - 30, imageHeight - 30, subtractAreaCornerRadius, subtractAreaCornerRadius));
        FRAME_MAIN_GLOSSY3.subtract(subtractArea);
        graphics.setPaint(new Color(0xf6f6f6));
        graphics.fill(FRAME_MAIN_GLOSSY3);

        final Area FRAME_MAIN_GLOSSY4 = new Area(new RoundRectangle2D.Double(16, 16, imageWidth - 32, imageHeight - 32, subtractAreaCornerRadius, subtractAreaCornerRadius));
        FRAME_MAIN_GLOSSY4.subtract(subtractArea);
        graphics.setPaint(new Color(0x333333));
        graphics.fill(FRAME_MAIN_GLOSSY4);
//
        this.getLinearEffect().paint(graphics, dimensions, outerArea);

        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

}
