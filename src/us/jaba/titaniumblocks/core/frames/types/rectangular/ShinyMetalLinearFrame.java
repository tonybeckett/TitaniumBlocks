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
import java.awt.Paint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RectangularFrame;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

/**
 *
 * @author tbeckett
 */
public class ShinyMetalLinearFrame extends RectangularFrame
{

    private boolean baseColor_ENABLED;
    private Color baseColor;

   
    
    public ShinyMetalLinearFrame()
    {
        super(NULL_FRACTION_ARRAY, NULL_COLOR_ARRAY);
    }

    public void setbaseColor_ENABLED(boolean baseColor_ENABLED)
    {
        this.baseColor_ENABLED = baseColor_ENABLED;
    }

    public Color getbaseColor()
    {
        return baseColor;
    }

    public void setbaseColor(Color baseColor)
    {
        this.baseColor = baseColor;
    }

    @Override
    public void setInnerFrameColor(Paint innerFrameColor)
    {
        this.innerFrameColor = innerFrameColor;
    }

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        final float angleOffset = (float) Math.toDegrees(Math.atan((imageHeight / 8.0f) / (imageWidth / 2.0f)));
//
        float[] frameMainFractions3 =
        {
            0.0f,
            90.0f - 2 * angleOffset,
            90.0f,
            90.0f + 3 * angleOffset,
            180.0f,
            270.0f - 3 * angleOffset,
            270.0f,
            270.0f + 2 * angleOffset,
            1.0f
        };
        Color[] frameMainColors3;
        if (baseColor_ENABLED)
        {
            frameMainColors3 = new Color[]
            {
                new Color(254, 254, 254, 255),
                new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 255),
                new Color(baseColor.brighter().brighter().getRed(), baseColor.brighter().brighter().getGreen(), baseColor.brighter().brighter().getBlue(), 255),
                new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 255),
                new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 255),
                new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 255),
                new Color(baseColor.brighter().brighter().getRed(), baseColor.brighter().brighter().getGreen(), baseColor.brighter().brighter().getBlue(), 255),
                new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 255),
                new Color(254, 254, 254, 255)
            };
        } else
        {
            frameMainColors3 = new Color[]
            {
                new Color(254, 254, 254, 255),
                new Color(179, 179, 179, 255),
                new Color(238, 238, 238, 255),
                new Color(179, 179, 179, 255),
                new Color(179, 179, 179, 255),
                new Color(179, 179, 179, 255),
                new Color(238, 238, 238, 255),
                new Color(179, 179, 179, 255),
                new Color(254, 254, 254, 255)
            };
        }
        Paint gradient = new ConicalGradientPaint(true, mainCenterPoint, 0, frameMainFractions3, frameMainColors3);
        graphics.setPaint(gradient);
        
        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);
//
        this.getLinearEffect().paint(graphics, new Dimension(imageWidth, imageHeight), outerArea);

//        
        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

}
