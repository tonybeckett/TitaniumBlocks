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
public class BlackMetalRoundFrame extends RoundFrame
{

   private final float[] frameMainFractions1 =
    {
        0.0f,
        45.0f,
        125.0f,
        180.0f,
        245.0f,
        315.0f,
        360.0f
    };

  private final  Color[] frameMainColors1 =
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
    public void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final Point2D centerPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        outerArea.subtract(subtractArea);
        graphics.setPaint(outerFrameColor);
        graphics.fill(outerArea);

        mainArea.subtract(subtractArea);

        Paint paint = new ConicalGradientPaint(true, centerPoint, 0, frameMainFractions1, frameMainColors1);
        graphics.setPaint(paint);
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
