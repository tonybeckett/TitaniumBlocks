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
package us.jaba.titaniumblocks.core.frames.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frames.RoundFrameEffect;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

/**
 *
 * @author tbeckett
 */
public class ChromeRoundFrame extends RoundFrame
{

    private float[] frameMainFractions6 =
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

    private Color[] frameMainColors6 =
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
    public void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        outerArea.subtract(subtractArea);
        graphics.setPaint(outerFrameColor);
        graphics.fill(outerArea);

        mainArea.subtract(subtractArea);
//        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
//        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        Paint frameMainPaint6 = new ConicalGradientPaint(false, mainCenterPoint, 0, frameMainFractions6, frameMainColors6);
        graphics.setPaint(frameMainPaint6);
        graphics.fill(mainArea);

        innerArea.subtract(subtractArea);

        // Former white ring
        graphics.setPaint(innerFrameColor);
        graphics.fill(innerArea);

        // Frame effect overlay
        final Point2D effectCenterPoint = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        ((RoundFrameEffect) this.getEffect()).paint(graphics, dimensions, outerArea, effectCenterPoint);

        graphics.dispose();
    }

}
