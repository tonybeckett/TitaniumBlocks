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
package us.jaba.titaniumblocks.core.threshold.indicators.models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlue;
import us.jaba.titaniumblocks.core.threshold.indicators.ThresholdIndicatorModel;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class VerticalThresholdIndicator extends ThresholdIndicatorModel
{

    final float[] THRESHOLD_FRACTIONS =
    {
        0.0f,
        0.3f,
        0.59f,
        1.0f
    };
    Color[] THRESHOLD_COLORS;
    private GradientPalette gradientPalette;

    public VerticalThresholdIndicator()
    {
        this.setGradientPalette(new PureBlue());
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        int imageWidth = (int) (dimensions.getWidth() * 0.0714285714);
        int IMAGE_HEIGHT = (int) (imageWidth * 0.8);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.translate(0, imageWidth * 0.005);
        final GeneralPath THRESHOLD = new GeneralPath();
        THRESHOLD.setWindingRule(Path2D.WIND_EVEN_ODD);
        final Point2D THRESHOLD_START;
        final Point2D THRESHOLD_STOP;

        THRESHOLD.moveTo(imageWidth * 0.1, IMAGE_HEIGHT * 0.5);
        THRESHOLD.lineTo(imageWidth * 0.9, IMAGE_HEIGHT * 0.1);
        THRESHOLD.lineTo(imageWidth * 0.9, IMAGE_HEIGHT * 0.9);
        THRESHOLD.lineTo(imageWidth * 0.1, IMAGE_HEIGHT * 0.5);
        THRESHOLD.closePath();
        THRESHOLD_START = new Point2D.Double(THRESHOLD.getBounds2D().getMinX(), 0);
        THRESHOLD_STOP = new Point2D.Double(THRESHOLD.getBounds2D().getMaxX(), 0);

        PointSupport.validateGradientPoints(THRESHOLD_START, THRESHOLD_STOP);
        final LinearGradientPaint THRESHOLD_GRADIENT = new LinearGradientPaint(THRESHOLD_START, THRESHOLD_STOP, THRESHOLD_FRACTIONS, THRESHOLD_COLORS);
        graphics.setPaint(THRESHOLD_GRADIENT);
        graphics.fill(THRESHOLD);

        graphics.setColor(Color.WHITE);
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(THRESHOLD);

    }

    public void setGradientPalette(GradientPalette gradientPalette)
    {
        this.gradientPalette = gradientPalette;

        THRESHOLD_COLORS = new Color[]
        {
            gradientPalette.getDark(),
            gradientPalette.getMedium(),
            gradientPalette.getMedium(),
            gradientPalette.getDark()
        };
    }
}
