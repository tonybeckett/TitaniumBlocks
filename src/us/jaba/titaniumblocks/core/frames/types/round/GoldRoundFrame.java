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
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.HSLColor;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GoldRoundFrame extends BasicGradientRoundFrame
{

    private final float[] fractionArray =
    {
        0.0f,
        0.15f,
        0.22f,
        0.3f,
        0.38f,
        0.44f,
        0.51f,
        0.6f,
        0.68f,
        0.75f,
        1.0f
    };

    private Color[] colorArray =
    {
        new Color(255, 255, 207, 255),
        new Color(255, 237, 96, 255),
        new Color(254, 199, 57, 255),
        new Color(255, 249, 203, 255),
        new Color(255, 199, 64, 255),
        new Color(252, 194, 60, 255),
        new Color(255, 204, 59, 255),
        new Color(213, 134, 29, 255),
        new Color(255, 201, 56, 255),
        new Color(212, 135, 29, 255),
        new Color(247, 238, 101, 255)
    };

    public GoldRoundFrame()
    {
        super();
        init(fractionArray, colorArray);
        this.setPrimaryColor(ColorPalette.GOLD);
    }

    @Override
    public void setPrimaryColor(Color primaryColor)
    {
        super.setPrimaryColor(primaryColor);

        HSLColor hsl = new HSLColor(primaryColor);
        colorArray[0] = hsl.adjustLuminance(80.0f);
        colorArray[1] = hsl.adjustLuminance(70.0f);
        colorArray[2] = hsl.adjustLuminance(60.0f);
        colorArray[3] = hsl.adjustLuminance(75.0f);
        colorArray[4] = hsl.adjustLuminance(62.0f);
        colorArray[5] = hsl.adjustLuminance(60.0f);
        colorArray[6] = hsl.adjustLuminance(59.0f);
        colorArray[7] = hsl.adjustLuminance(30.0f);
        colorArray[8] = hsl.adjustLuminance(50.0f);
        colorArray[9] = hsl.adjustLuminance(63.0f);
        colorArray[10] = hsl.adjustLuminance(69.0f);
    }

//    @Override
//    public void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
//    {
//        final int imageWidth = (int) dimensions.getWidth();
//        final int imageHeight = (int) dimensions.getHeight();
//
//        outerArea.subtract(subtractArea);
//        graphics.setPaint(outerFrameColor);
//        graphics.fill(outerArea);
//
//        mainArea.subtract(subtractArea);
//        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
//        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(mainStartPoint, mainStopPoint);
//        Paint frameMainPaint7 = new LinearGradientPaint(mainStartPoint, mainStopPoint, fractionArray, colorArray);
//        graphics.setPaint(frameMainPaint7);
//        graphics.fill(mainArea);
//
//        innerArea.subtract(subtractArea);
//        // Former white ring
//        graphics.setPaint(innerFrameColor);
//        graphics.fill(innerArea);
//
//        // Frame effect overlay
//        final Point2D effectCenterPoint = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
//
//        this.getEffect().paint(graphics, dimensions, outerArea, effectCenterPoint);
//
//        graphics.dispose();
//    }
}
