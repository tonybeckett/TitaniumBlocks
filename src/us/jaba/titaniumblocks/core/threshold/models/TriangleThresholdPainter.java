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
package us.jaba.titaniumblocks.core.threshold.models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.threshold.AbstractThresholdPainter;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TriangleThresholdPainter extends AbstractThresholdPainter
{

    private float ROTATION_OFFSET = 0.0f;

    @Override
    protected void paintThreshold(Graphics2D graphics, Dimension dimensions)
    {

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.rotate(ROTATION_OFFSET, imageWidth / 2.0, imageHeight / 2.0);

        final Point2D THRESHOLD_START = new Point2D.Double();
        final Point2D THRESHOLD_STOP = new Point2D.Double();

        final GeneralPath THRESHOLD = new GeneralPath();

        THRESHOLD.setWindingRule(Path2D.WIND_EVEN_ODD);
        THRESHOLD.moveTo(imageWidth * 0.5, imageHeight * 0.6190476190476191);
        THRESHOLD.lineTo(imageWidth * 0.1111111111111111, imageHeight * 0.9523809523809523);
        THRESHOLD.lineTo(imageWidth * 0.8888888888888888, imageHeight * 0.9523809523809523);
        THRESHOLD.closePath();
        THRESHOLD_START.setLocation(0, THRESHOLD.getBounds2D().getMaxY());
        THRESHOLD_STOP.setLocation(0, THRESHOLD.getBounds2D().getMinY());

        final float[] THRESHOLD_FRACTIONS =
        {
            0.0f,
            0.3f,
            0.59f,
            1.0f
        };
        final Color[] THRESHOLD_COLORS =
        {
            gradientPalette.getDark(),
            gradientPalette.getMedium(),
            gradientPalette.getMedium(),
            gradientPalette.getDark(),
        };
        PointSupport.validateGradientPoints(THRESHOLD_START, THRESHOLD_STOP);
        final LinearGradientPaint THRESHOLD_GRADIENT = new LinearGradientPaint(THRESHOLD_START, THRESHOLD_STOP, THRESHOLD_FRACTIONS, THRESHOLD_COLORS);
        graphics.setPaint(THRESHOLD_GRADIENT);
        graphics.fill(THRESHOLD);

        graphics.setColor(Color.WHITE);
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(THRESHOLD);

        graphics.dispose();
    }

}
