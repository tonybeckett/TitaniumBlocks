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
package us.jaba.titaniumblocks.core.glow.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.glow.Glow;
import us.jaba.titaniumblocks.core.color.ColorTools;

/**
 *
 * @author tbeckett
 */
public class LCDGlow extends Glow
{

    

    /**
     * Returns an image that simulates a glowing ring which could be used to
     * visualize a state of the gauge by a color. The LED might be too small if
     * you are not in front of the screen and so one could see the current state
     * more easy.
     *
     * @param width
     * @param height
     * @param getGlowColor()
     * @param ON
     * @return an image that simulates a glowing ring
     */
//    public BufferedImage createLcdGlow(final int width, final int height, final Color getGlowColor(), final boolean ON)
//    {
//        if (width <= 1 || height <= 1)
//        {
//            return UTIL.createImage(1, 1, Transparency.TRANSLUCENT);
//        }
//
//        // Take image from cache instead of creating a new one if parameters are the same as last time
//        if (lcdWidth == width && lcdHeight == height && lcdGlowColor.equals(getGlowColor()) && lcdOn == ON)
//        {
//            return lcdGlowImage;
//        }
//
//        lcdGlowImage.flush();
//        lcdGlowImage = UTIL.createImage(width, height, Transparency.TRANSLUCENT);

    @Override
    public void paint(final Graphics2D graphics, final Dimension dimensions)
    {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final double CORNER_RADIUS = dimensions.getWidth() > dimensions.getHeight() ? (dimensions.getHeight() * 0.095) - 1 : (dimensions.getWidth() * 0.095) - 1;
        final RoundRectangle2D GLOWRING = new RoundRectangle2D.Double(1, 1, dimensions.getWidth() - 2, dimensions.getHeight() - 2 - 1, CORNER_RADIUS, CORNER_RADIUS);

        final Color[] GLOW_COLORS =
        {
            ColorTools.setAlpha(getGlowColor(), 0.65f),
            ColorTools.setAlpha(getGlowColor(), 0.32f),
            ColorTools.setAlpha(getGlowColor(), 0.18f),
            ColorTools.setAlpha(getGlowColor(), 0.07f),
            ColorTools.setAlpha(getGlowColor(), 0.03f),
            ColorTools.setAlpha(getGlowColor(), 0.01f)
        };

        for (int i = 0; i < 6; i++)
        {
            graphics.setColor(GLOW_COLORS[i]);
            GLOWRING.setRoundRect(i + 1, i + 1, dimensions.getWidth() - 2 - i * 2, dimensions.getHeight() - 2 - i * 2, CORNER_RADIUS, CORNER_RADIUS);
            graphics.draw(GLOWRING);
        }

        graphics.dispose();

//        // memoize parameters
//        lcdWidth = width;
//        lcdHeight = height;
//        lcdGlowColor = getGlowColor();
//        lcdOn = ON;
//
//        return lcdGlowImage;
    }
}
