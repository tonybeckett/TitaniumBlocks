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
public class BlackMetalLinearFrame extends RectangularFrame
{
    private static final Color[] COLOR_ARRAY =
    {
        new Color(254, 254, 254, 255),
        new Color(0, 0, 0, 255),
        new Color(153, 153, 153, 255),
        new Color(0, 0, 0, 255),
        new Color(0, 0, 0, 255),
        new Color(0, 0, 0, 255),
        new Color(153, 153, 153, 255),
        new Color(0, 0, 0, 255),
        new Color(254, 254, 254, 255)
    };

    public BlackMetalLinearFrame()
    {
        super(NULL_FRACTION_ARRAY, COLOR_ARRAY);
    }

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final float angleOffset = (float) Math.toDegrees(Math.atan((imageHeight / 8.0f) / (imageWidth / 2.0f)));

        float[] fractionArray =
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

        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        Paint gradient = new ConicalGradientPaint(true, mainCenterPoint, 0, fractionArray, COLOR_ARRAY);
        graphics.setPaint(gradient);

        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);

        this.getLinearEffect().paint(graphics, dimensions, outerArea);

        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

}
