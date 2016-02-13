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
package us.jaba.titaniumblocks.core.bargraph.leds.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.bargraph.leds.LedModel;

/**
 *
 * @author tbeckett
 */
public class HorizontalLeds extends LedModel
{

    private final float[] LED_FRACTIONS = new float[]
    {
        0.0f,
        1.0f
    };
    private final Color[] LED_INACTIVE_COLORS = new Color[]
    {
        new Color(60, 60, 60, 255),
        new Color(50, 50, 50, 255)
    };

   
    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        int width = (int) dimensions.getWidth();
        int height = (int) dimensions.getHeight();

        // Horizontal orientation
        double TOP = width * 0.8567961165048543; // position of max value
        double BOTTOM = width * 0.12864077669902912; // position of min value
        double FULL_SIZE = TOP - BOTTOM;

        Rectangle2D.Double led = new Rectangle2D.Double(width * 0.14285714285714285, height * 0.45, width * 0.0121359223, height * 0.1214285714);
        Point2D.Double ledCenter = new Point2D.Double(led.getCenterX(), led.getCenterY());

        

        RadialGradientPaint ledGradient = new RadialGradientPaint(ledCenter, (float) (0.030373831775700934 * height), LED_FRACTIONS, getLedColors());
        RadialGradientPaint ledInactiveGradient = new RadialGradientPaint(ledCenter, (float) (0.030373831775700934 * height), LED_FRACTIONS, LED_INACTIVE_COLORS);
///////
        // Draw the inactive leds
        final AffineTransform OLD_TRANSFORM = graphics.getTransform();
        graphics.setPaint(ledInactiveGradient);
        final double INACTIVE_LEDS = getCoordForValue(getMaxValue(), FULL_SIZE);
        for (double translateX = -(led.getWidth() / 2); Double.compare(translateX, INACTIVE_LEDS) <= 0; translateX += led.getWidth() + 1)
        {
            graphics.translate(translateX, 0);
            graphics.fill(led);
            graphics.setTransform(OLD_TRANSFORM);
        }

        final double ACTIVE_LEDS;

        ACTIVE_LEDS = getCoordForValue(getValue(), FULL_SIZE);
//        } else
//        {
//            final double SIZE_FACTOR = FULL_SIZE / (UTIL.logOfBase(BASE, getMaxValue()));
//            ACTIVE_LEDS = SIZE_FACTOR * UTIL.logOfBase(BASE, getValue());
//        }
//
//       
        
        for (double translateX = -(led.getWidth() / 2); Double.compare(translateX, ACTIVE_LEDS) <= 0; translateX += led.getWidth() + 1)
        {
            // If sections visible, color the bargraph with the given section colors
            graphics.setPaint(ledGradient);

         

            graphics.translate(translateX, 0);
            graphics.fill(led);
            graphics.setTransform(OLD_TRANSFORM);
        }
//        } else
//        {   // Draw only one led
//            final double TRANSLATE_X = getCoordForValue(getValue(), FULL_SIZE);
//            if (isSectionsVisible())
//            {
//                for (Section section : getSections())
//                {
//                    if (TRANSLATE_X + (led.getWidth() / 2) >= sectionOffsets.get(section).getX() && TRANSLATE_X + (led.getWidth() / 2) < sectionOffsets.get(section).getY())
//                    {
//                        graphics.setPaint(sectionGradients.get(section));
//                    }
//                }
//            }
//            graphics.translate(TRANSLATE_X, 0);
//            graphics.fill(led);
//            graphics.setTransform(OLD_TRANSFORM);
//        }
//

    }

}
