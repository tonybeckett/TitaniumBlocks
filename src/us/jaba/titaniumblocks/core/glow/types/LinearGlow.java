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
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

import us.jaba.titaniumblocks.core.glow.Glow;
import us.jaba.titaniumblocks.core.gradients.paint.ContourGradientPaint;
import us.jaba.titaniumblocks.core.color.ColorTools;

/**
 *
 * @author tbeckett
 */
public class LinearGlow extends Glow
{

    private final float[] GLOWRING_OFF_FRACTIONS =
    {
        0.0f,
        0.17f,
        0.33f,
        0.34f,
        0.63f,
        0.64f,
        0.83f,
        1.0f
    };
    private final Color[] GLOWRING_OFF_COLORS =
    {
        new Color(204, 204, 204, 102),
        new Color(153, 153, 153, 102),
        new Color(252, 252, 252, 102),
        new Color(255, 255, 255, 102),
        new Color(204, 204, 204, 102),
        new Color(203, 203, 203, 102),
        new Color(153, 153, 153, 102),
        new Color(255, 255, 255, 102)
    };

    private final float[] GLOWRING_HL_FRACTIONS =
    {
        0.0f,
        0.1f,
        0.2f,
        0.2001f,
        0.27f,
        0.41f,
        0.42f,
        0.48f,
        0.48009998f,
        0.55f,
        0.5501f,
        0.92f,
        0.93f,
        0.97f,
        0.99f,
        1.0f
    };
    
    private final Color[] GLOWRING_HL_COLORS =
    {
        new Color(255, 255, 255, 140),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 50),
        new Color(255, 255, 255, 60),
        new Color(255, 255, 255, 45),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 80),
        new Color(255, 255, 255, 95),
        new Color(255, 255, 255, 24),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 0),
        new Color(255, 255, 255, 124),
        new Color(255, 255, 255, 164)
    };

    public boolean ON;

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
//    public BufferedImage createLinearGlow(final int width, final int height, final Color getGlowColor(), final boolean ON) {
//        if (width <= 32 || height <= 32) {
//            return UTIL.createImage(1, 1, Transparency.TRANSLUCENT);
//        }
//
//        // Take image from cache instead of creating a new one if parameters are the same as last time
//        if (linWidth == width && linHeight == height && linGlowColor.equals(getGlowColor()) && linOn == ON) {
//            return linGlowImage;
//        }
//
//        linGlowImage.flush();
//        linGlowImage = UTIL.createImage(width, height, Transparency.TRANSLUCENT);
//        final Graphics2D graphics = linGlowImage.createGraphics();
    @Override
    public void paint(final Graphics2D graphics, final Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final double outerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            outerAreaCornerRadius = imageHeight * 0.05;
        } else
        {
            outerAreaCornerRadius = imageWidth * 0.05;
        }
        final RoundRectangle2D outerArea = new RoundRectangle2D.Double(0.0, 0.0, imageWidth, imageHeight, outerAreaCornerRadius, outerAreaCornerRadius);
        final double mainAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getWidth() - imageWidth - 2) / 2.0);
        }
        final RoundRectangle2D mainArea = new RoundRectangle2D.Double(1.0, 1.0, imageWidth - 2, imageHeight - 2, mainAreaCornerRadius, mainAreaCornerRadius);

        final double innerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            innerAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            innerAreaCornerRadius = imageWidth * 0.02857143;
        }

        final RoundRectangle2D innerArea = new RoundRectangle2D.Double(mainArea.getX() + 16, mainArea.getY() + 16, mainArea.getWidth() - 32, mainArea.getHeight() - 32, innerAreaCornerRadius, innerAreaCornerRadius);

        final double BACKGROUND_CORNER_RADIUS = innerAreaCornerRadius - 1;

        final Area GLOWRING = new Area(new RoundRectangle2D.Double(innerArea.getX() + 1, innerArea.getY() + 1, innerArea.getWidth() - 2, innerArea.getHeight() - 2, BACKGROUND_CORNER_RADIUS, BACKGROUND_CORNER_RADIUS));
        final Area TMP_RING = new Area(new RoundRectangle2D.Double(innerArea.getX() + 6, innerArea.getY() + 6, innerArea.getWidth() - 12, innerArea.getHeight() - 12, BACKGROUND_CORNER_RADIUS, BACKGROUND_CORNER_RADIUS));
        GLOWRING.subtract(TMP_RING);

        if (!isActive())
        {
            final Point2D GLOWRING_OFF_START = new Point2D.Double(0, GLOWRING.getBounds2D().getMinY());
            final Point2D GLOWRING_OFF_STOP = new Point2D.Double(0, GLOWRING.getBounds2D().getMaxY());

            final Paint GLOWRING_OFF_GRADIENT = new LinearGradientPaint(GLOWRING_OFF_START, GLOWRING_OFF_STOP, GLOWRING_OFF_FRACTIONS, GLOWRING_OFF_COLORS);
            graphics.setPaint(GLOWRING_OFF_GRADIENT);
            graphics.fill(GLOWRING);
        } else
        {
            final float relFrameSize;
            if (imageWidth >= imageHeight)
            {
                relFrameSize = (10f / GLOWRING.getBounds().height);
            } else
            {
                relFrameSize = (10f / GLOWRING.getBounds().width);
            }
            final float[] GLOWRING_ON_FRACTIONS =
            {
                0.0f,
                relFrameSize * 0.1f,
                relFrameSize * 0.5f,
                relFrameSize,
                1.0f
            };
            final Color[] GLOWRING_ON_COLORS =
            {
                ColorTools.setAlpha(getGlowColor(), 0.0f),
                ColorTools.setSaturation(getGlowColor(), 0.6f),
                getGlowColor(),
                ColorTools.setSaturation(getGlowColor(), 0.6f),
                ColorTools.setAlpha(getGlowColor(), 0.0f)
            };
            final Paint GLOWRING_ON_GRADIENT = new ContourGradientPaint(GLOWRING.getBounds2D(), GLOWRING_ON_FRACTIONS, GLOWRING_ON_COLORS);
            graphics.setPaint(GLOWRING_ON_GRADIENT);
            graphics.translate(-10, -10);
//            graphics.drawImage(Shadow.INSTANCE.createDropShadow(GLOWRING, GLOWRING_ON_GRADIENT, getGlowColor(), true, null, null, 0, 1.0f, 10, 315, getGlowColor()), GLOWRING.getBounds().x, GLOWRING.getBounds().y, null);
            graphics.translate(10, 10);

            // add a little highlight
            final Point2D GLOWRING_HL_START = new Point2D.Double(GLOWRING.getBounds2D().getCenterX(), GLOWRING.getBounds2D().getMinY());
            final Point2D GLOWRING_HL_STOP = new Point2D.Double(GLOWRING.getBounds2D().getCenterX(), GLOWRING.getBounds2D().getMaxY());

            final LinearGradientPaint GLOWRING_HL_GRADIENT = new LinearGradientPaint(GLOWRING_HL_START, GLOWRING_HL_STOP, GLOWRING_HL_FRACTIONS, GLOWRING_HL_COLORS);
            graphics.setPaint(GLOWRING_HL_GRADIENT);
            graphics.fill(GLOWRING);
        }

        graphics.dispose();

//        // memoize parameters
//        linWidth = width;
//        linHeight = height;
//        linGlowColor = getGlowColor();
//        linOn = ON;
//
//        return linGlowImage;
    }
}
