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
package us.jaba.titaniumblocks.core.frames.models.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrameModel;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

/**
 *
 * @author tbeckett
 */
public class BlackMetalRoundFramePainter extends RoundFrameModel
{

    float[] frameMainFractions1 =
    {
        0.0f,
        45.0f,
        125.0f,
        180.0f,
        245.0f,
        315.0f,
        360.0f
    };

    Color[] frameMainColors1 =
    {
        new Color(254, 254, 254, 255),
        new Color(0, 0, 0, 255),
        new Color(153, 153, 153, 255),
        new Color(0, 0, 0, 255),
        new Color(153, 153, 153, 255),
        new Color(0, 0, 0, 255),
        new Color(254, 254, 254, 255)
    };

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        // Shape that will be subtracted from the ellipse and will be filled by the background image later
        final Area subtractArea = new Area(new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031));

        final Area outerArea = new Area(new Ellipse2D.Double(0.0, 0.0, imageWidth, imageHeight));
        outerArea.subtract(subtractArea);
        graphics.setPaint(outerFrameColor);
        graphics.fill(outerArea);

        final Area mainArea = new Area(new Ellipse2D.Double(imageWidth * 0.004672897048294544, imageHeight * 0.004672897048294544, imageWidth * 0.9906542301177979, imageHeight * 0.9906542301177979));
        mainArea.subtract(subtractArea);
        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        Paint frameMainPaint1 = new ConicalGradientPaint(true, mainCenterPoint, 0, frameMainFractions1, frameMainColors1);
        graphics.setPaint(frameMainPaint1);
        graphics.fill(mainArea);

        //final Ellipse2D innerArea = new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948);
        final Area innerArea = new Area(new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948));
        innerArea.subtract(subtractArea);

        // Former white ring
        graphics.setPaint(innerFrameColor);
        graphics.fill(innerArea);

        // Frame effect overlay
        final Point2D effectCenterPoint = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));

        this.getEffect().paint(graphics, dimensions, outerArea, effectCenterPoint);
        graphics.dispose();

    }

}
