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
package us.jaba.titaniumblocks.core.backdrop.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public abstract class AbstractRoundBackdrop extends Backdrop
{

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) Math.round(dimensions.getWidth() + 0.5);
        final int imageHeight = (int) Math.round(dimensions.getHeight() + 0.5);

        // Background of gauge
//        final Ellipse2D GAUGE_BACKGROUND = new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031);
        final Ellipse2D GAUGE_BACKGROUND = new Ellipse2D.Double(0, 0, imageWidth, imageHeight);
        final Point2D GAUGE_BACKGROUND_START = new Point2D.Double(0, GAUGE_BACKGROUND.getBounds2D().getMinY());
        final Point2D GAUGE_BACKGROUND_STOP = new Point2D.Double(0, GAUGE_BACKGROUND.getBounds2D().getMaxY());
        if (GAUGE_BACKGROUND_START.equals(GAUGE_BACKGROUND_STOP))
        {
            GAUGE_BACKGROUND_STOP.setLocation(0.0, GAUGE_BACKGROUND_START.getY() + 1);
        }

        Paint gaugeBackgroundGradient = getPaint(dimensions, GAUGE_BACKGROUND);

        final float[] GAUGE_BACKGROUND_FRACTIONS =
        {
            0.0f,
            0.40f,
            1.0f
        };

        final Color[] GAUGE_BACKGROUND_COLORS =
        {
            backgroundColorModel.getGradientStartColor(),
            backgroundColorModel.getGradientFractionColor(),
            backgroundColorModel.getGradientStopColor()
        };

        graphics.setPaint(gaugeBackgroundGradient);

        graphics.fill(GAUGE_BACKGROUND);

        applyOverlay(graphics, dimensions, GAUGE_BACKGROUND);

//        final Ellipse2D innerShadow = new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031);
//        final Ellipse2D innerShadow = new Ellipse2D.Double(0 , 0 , imageWidth , imageHeight );
        final Point2D centerPoint = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        final float[] GAUGE_INNERSHADOW_FRACTIONS =
        {
            0.0f,
            0.7f,
            0.71f,
            0.86f,
            0.92f,
            0.97f,
            1.0f
        };
        final Color[] GAUGE_INNERSHADOW_COLORS =
        {
            new Color(0f, 0f, 0f, 0f),
            new Color(0f, 0f, 0f, 0f),
            new Color(0f, 0f, 0f, 0f),
            new Color(0f, 0f, 0f, 0.03f),
            new Color(0f, 0f, 0f, 0.07f),
            new Color(0f, 0f, 0f, 0.15f),
            new Color(0f, 0f, 0f, 0.3f)
        };
        final RadialGradientPaint GAUGE_INNERSHADOW_GRADIENT = new RadialGradientPaint(centerPoint, (float) (0.4158878504672897 * imageWidth), GAUGE_INNERSHADOW_FRACTIONS, GAUGE_INNERSHADOW_COLORS);

        graphics.setPaint(GAUGE_INNERSHADOW_GRADIENT);

//        graphics.fill(innerShadow);
//
//        graphics.fill(innerShadow);
        graphics.dispose();

    }

    protected abstract Paint getPaint(Dimension dimensions, Ellipse2D bounds);

    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Ellipse2D GAUGE_BACKGROUND)
    {
// intentional
    }

}
