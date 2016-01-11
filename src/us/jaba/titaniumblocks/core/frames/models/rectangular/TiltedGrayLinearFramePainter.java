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
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RectangularFramePainter;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TiltedGrayLinearFramePainter extends RectangularFramePainter
{

    private static final float[] FRACTION_ARRAY =
    {
        0.0f,
        0.07f,
        0.16f,
        0.33f,
        0.55f,
        0.79f,
        1.0f
    };

    private static final Color[] COLOR_ARRAY =
    {
        new Color(255, 255, 255, 255),
        new Color(210, 210, 210, 255),
        new Color(179, 179, 179, 255),
        new Color(255, 255, 255, 255),
        new Color(197, 197, 197, 255),
        new Color(255, 255, 255, 255),
        new Color(102, 102, 102, 255)
    };

    public TiltedGrayLinearFramePainter()
    {
        super(FRACTION_ARRAY, COLOR_ARRAY);
    }

    @Override
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        mainStartPoint.setLocation((0.08571428571428572 * imageWidth), (0.0 * imageHeight));
        mainStopPoint.setLocation(((0.08571428571428572 + 0.7436714214664596) * imageWidth), ((0.0 + 0.9868853088441548) * imageHeight));

        PointSupport.validateGradientPoints(mainStartPoint, mainStopPoint);
        Paint gradientPaint = new LinearGradientPaint(mainStartPoint, mainStopPoint, FRACTION_ARRAY, COLOR_ARRAY);
        graphics.setPaint(gradientPaint);

        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);

        this.getLinearEffect().paint(graphics, dimensions, outerArea);

        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

}
