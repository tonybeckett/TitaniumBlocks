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
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.HSLColor;

/**
 *
 * @author tbeckett
 */
public class SteelRoundFrame extends BasicGradientRoundFrame
{

    private final float[] fractionsArray =
    {
        0.0f,
        0.05f,
        0.10f,
        0.50f,
        0.90f,
        0.95f,
        1.0f
    };

    private Color[] primaryColorArray =
    {
        new Color(231, 237, 237, 255),
        new Color(189, 199, 198, 255),
        new Color(192, 201, 200, 255),
        new Color(23, 31, 33, 255),
        new Color(196, 205, 204, 255),
        new Color(194, 204, 203, 255),
        new Color(189, 201, 199, 255)
    };

    public SteelRoundFrame()
    {
        init(fractionsArray, primaryColorArray);
//        this.setPrimaryColor(new Color(118, 117, 135, 255));
        this.setPrimaryColor(ColorPalette.STEEL);
    }

    @Override
    public void setPrimaryColor(Color primaryColor)
    {
        super.setPrimaryColor(primaryColor);

        HSLColor hsl = new HSLColor(primaryColor);
        primaryColorArray[0] = hsl.adjustLuminance(100.0f);
        primaryColorArray[1] = hsl.adjustLuminance(80.0f);
        primaryColorArray[2] = hsl.adjustLuminance(90.0f);
        primaryColorArray[3] = hsl.adjustLuminance(25.0f);
        primaryColorArray[4] = hsl.adjustLuminance(100.0f);
        primaryColorArray[5] = hsl.adjustLuminance(95.0f);
        primaryColorArray[6] = hsl.adjustLuminance(89.0f);
    }

//    @Override
//    public void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
//    {
//
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
////        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());
//
//        PointSupport.validateGradientPoints(mainStartPoint, mainStopPoint);
//        Paint frameMainPaint5 = new LinearGradientPaint(mainStartPoint, mainStopPoint, frameMainFractions5, frameMainColors5);
//        graphics.setPaint(frameMainPaint5);
//        graphics.fill(mainArea);
//
//        innerArea.subtract(subtractArea);
//
//        // Former white ring
//        graphics.setPaint(innerFrameColor);
//        graphics.fill(innerArea);
//
//        // Frame effect overlay
//        final Point2D effectCenterPoint = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
//
//        this.getEffect().paint(graphics, dimensions, outerArea, effectCenterPoint);
//        graphics.dispose();
//
//    }
}
