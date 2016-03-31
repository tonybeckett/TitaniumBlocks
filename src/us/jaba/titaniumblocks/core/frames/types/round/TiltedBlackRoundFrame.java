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
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;

import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frames.RoundFrameEffect;
import us.jaba.titaniumblocks.core.utils.PointSupport;

public class TiltedBlackRoundFrame extends RoundFrame
{

   private float[] frameMainFractions10 =
    {
        0.0f,
        0.21f,
        0.47f,
        0.99f,
        1.0f
    };

  private  Color[] frameMainColors10 =
    {
        new Color(102, 102, 102, 255),
        new Color(0, 0, 0, 255),
        new Color(102, 102, 102, 255),
        new Color(0, 0, 0, 255),
        new Color(0, 0, 0, 255)
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
        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
//        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        mainStartPoint.setLocation((0.22897196261682243 * imageWidth), (0.0794392523364486 * imageHeight));
        mainStopPoint.setLocation(((0.22897196261682243 + 0.573576436351046) * imageWidth), ((0.0794392523364486 + 0.8191520442889918) * imageHeight));

        PointSupport.validateGradientPoints(mainStartPoint, mainStopPoint);
        Paint frameMainPaint10 = new LinearGradientPaint(mainStartPoint, mainStopPoint, frameMainFractions10, frameMainColors10);
        graphics.setPaint(frameMainPaint10);
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
