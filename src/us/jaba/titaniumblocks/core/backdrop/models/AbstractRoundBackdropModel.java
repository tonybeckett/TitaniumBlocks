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
package us.jaba.titaniumblocks.core.backdrop.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author hansolo
 */
public abstract class AbstractRoundBackdropModel extends BackdropModel
{

    public AbstractRoundBackdropModel()
    {
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
//    public BufferedImage createRadialBackground(final int width, final BackgroundColor backgroundColorModel, final Paint CUSTOM_BACKGROUND, final Color TEXTURE_COLOR, final BufferedImage BACKGROUND_IMAGE)

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        // Background of gauge
        final Ellipse2D GAUGE_BACKGROUND = new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031);
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

//            final Paint GAUGE_BACKGROUND_GRADIENT;
//            if (backgroundColorModel == BackgroundColor.BRUSHED_METAL)
//            {
//                GAUGE_BACKGROUND_GRADIENT = new TexturePaint(UTIL.createBrushMetalTexture(TEXTURE_COLOR, GAUGE_BACKGROUND.getBounds().width, GAUGE_BACKGROUND.getBounds().height), GAUGE_BACKGROUND.getBounds());
//            } else if (backgroundColorModel == BackgroundColor.STAINLESS)
//            {
//                final Point2D centerPoint = new Point2D.Double(GAUGE_BACKGROUND.getCenterX(), GAUGE_BACKGROUND.getCenterY());
//                final float[] STAINLESS_FRACTIONS =
//                {
//                    0f,
//                    0.03f,
//                    0.10f,
//                    0.14f,
//                    0.24f,
//                    0.33f,
//                    0.38f,
//                    0.5f,
//                    0.62f,
//                    0.67f,
//                    0.76f,
//                    0.81f,
//                    0.85f,
//                    0.97f,
//                    1.0f
//                };
//
//                // Define the colors of the conical gradient paint
//                final Color[] STAINLESS_COLORS =
//                {
//                    new Color(0xFDFDFD),
//                    new Color(0xFDFDFD),
//                    new Color(0xB2B2B4),
//                    new Color(0xACACAE),
//                    new Color(0xFDFDFD),
//                    new Color(0x6E6E70),
//                    new Color(0x6E6E70),
//                    new Color(0xFDFDFD),
//                    new Color(0x6E6E70),
//                    new Color(0x6E6E70),
//                    new Color(0xFDFDFD),
//                    new Color(0xACACAE),
//                    new Color(0xB2B2B4),
//                    new Color(0xFDFDFD),
//                    new Color(0xFDFDFD)
//                };
//
////                // Define the conical gradient paint
//                GAUGE_BACKGROUND_GRADIENT = new ConicalGradientPaint(false, centerPoint, -0.45f, STAINLESS_FRACTIONS, STAINLESS_COLORS);
//            } else if (backgroundColorModel == BackgroundColor.STAINLESS_GRINDED)
//            {
//                GAUGE_BACKGROUND_GRADIENT = new TexturePaint(STAINLESS_GRINDED_TEXTURE, new java.awt.Rectangle(0, 0, 100, 100));
//            } else if (backgroundColorModel == BackgroundColor.CARBON)
//            {
//                GAUGE_BACKGROUND_GRADIENT = new TexturePaint(CARBON_FIBRE_TEXTURE, new java.awt.Rectangle(0, 0, 12, 12));
//                fadeInOut = true;
//            } else if (backgroundColorModel == BackgroundColor.PUNCHED_SHEET)
//            {
//                GAUGE_BACKGROUND_GRADIENT = new TexturePaint(punchedSheetTexture, new java.awt.Rectangle(0, 0, 12, 12));
//                fadeInOut = true;
//            } else if (backgroundColorModel == BackgroundColor.LINEN)
//            {
//                GAUGE_BACKGROUND_GRADIENT = new TexturePaint(UTIL.createLinenTexture(TEXTURE_COLOR, GAUGE_BACKGROUND.getBounds().width, GAUGE_BACKGROUND.getBounds().height), GAUGE_BACKGROUND.getBounds());
//            } else if (backgroundColorModel == BackgroundColor.NOISY_PLASTIC)
//            {
//                GAUGE_BACKGROUND_START.setLocation(0.0, GAUGE_BACKGROUND.getMinY());
//                GAUGE_BACKGROUND_STOP.setLocation(0.0, GAUGE_BACKGROUND.getMaxY());
//                PointSupport.validateGradientPoints(GAUGE_BACKGROUND_START, GAUGE_BACKGROUND_STOP);
//                final float[] FRACTIONS =
//                {
//                    0.0f,
//                    1.0f
//                };
//                final Color[] COLORS =
//                {
//                    ColorSupport.lighter(TEXTURE_COLOR, 0.15f),
//                    ColorSupport.darker(TEXTURE_COLOR, 0.15f)
//                };
//                GAUGE_BACKGROUND_GRADIENT = new LinearGradientPaint(GAUGE_BACKGROUND_START, GAUGE_BACKGROUND_STOP, FRACTIONS, COLORS);
//            } else
//        PointSupport.validateGradientPoints(GAUGE_BACKGROUND_START, GAUGE_BACKGROUND_STOP);
//        LinearGradientPaint GAUGE_BACKGROUND_GRADIENT = new LinearGradientPaint(GAUGE_BACKGROUND_START, GAUGE_BACKGROUND_STOP, GAUGE_BACKGROUND_FRACTIONS, GAUGE_BACKGROUND_COLORS);
        graphics.setPaint(gaugeBackgroundGradient);

        graphics.fill(GAUGE_BACKGROUND);

//        // add noise if NOISY_PLASTIC
//        if (backgroundColorModel == BackgroundColor.NOISY_PLASTIC)
//        {
//            final Random BW_RND = new Random();
//            final Random ALPHA_RND = new Random();
//            final Shape OLD_CLIP = graphics.getClip();
//            graphics.setClip(GAUGE_BACKGROUND);
//            Color noiseColor;
//            int noiseAlpha;
//            for (int y = 0; y < GAUGE_BACKGROUND.getHeight(); y++)
//            {
//                for (int x = 0; x < GAUGE_BACKGROUND.getWidth(); x++)
//                {
//                    if (BW_RND.nextBoolean())
//                    {
//                        noiseColor = BRIGHT_NOISE;
//                    } else
//                    {
//                        noiseColor = DARK_NOISE;
//                    }
//                    noiseAlpha = 10 + ALPHA_RND.nextInt(10) - 5;
//                    graphics.setColor(new Color(noiseColor.getRed(), noiseColor.getGreen(), noiseColor.getBlue(), noiseAlpha));
//                    graphics.drawLine((int) (x + GAUGE_BACKGROUND.getMinX()), (int) (y + GAUGE_BACKGROUND.getMinY()), (int) (x + GAUGE_BACKGROUND.getMinX()), (int) (y + GAUGE_BACKGROUND.getMinY()));
//                }
//            }
//            graphics.setClip(OLD_CLIP);
//        }
        // Draw an overlay gradient that gives the carbon fibre a more realistic look
//        if (fadeInOut)
//        {
//            final float[] SHADOW_OVERLAY_FRACTIONS =
//            {
//                0.0f,
//                0.4f,
//                0.6f,
//                1.0f
//            };
//            final Color[] SHADOW_OVERLAY_COLORS =
//            {
//                new Color(0f, 0f, 0f, 0.6f),
//                new Color(0f, 0f, 0f, 0.0f),
//                new Color(0f, 0f, 0f, 0.0f),
//                new Color(0f, 0f, 0f, 0.6f)
//            };
//            final LinearGradientPaint SHADOW_OVERLAY_GRADIENT;
//            if (PointSupport.pointsEquals(GAUGE_BACKGROUND.getMinX(), 0, GAUGE_BACKGROUND.getMaxX(), 0))
//            {
//                SHADOW_OVERLAY_GRADIENT = new LinearGradientPaint(new Point2D.Double(GAUGE_BACKGROUND.getMinX(), 0), new Point2D.Double(GAUGE_BACKGROUND.getMaxX() + 1, 0), SHADOW_OVERLAY_FRACTIONS, SHADOW_OVERLAY_COLORS);
//            } else
//            {
//                SHADOW_OVERLAY_GRADIENT = new LinearGradientPaint(new Point2D.Double(GAUGE_BACKGROUND.getMinX(), 0), new Point2D.Double(GAUGE_BACKGROUND.getMaxX(), 0), SHADOW_OVERLAY_FRACTIONS, SHADOW_OVERLAY_COLORS);
//            }
//            graphics.setPaint(SHADOW_OVERLAY_GRADIENT);
//            graphics.fill(GAUGE_BACKGROUND);
//        }
        applyOverlay(graphics, dimensions, GAUGE_BACKGROUND);

        final Ellipse2D GAUGE_INNERSHADOW = new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031);
        final Point2D GAUGE_INNERSHADOW_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
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
        final RadialGradientPaint GAUGE_INNERSHADOW_GRADIENT = new RadialGradientPaint(GAUGE_INNERSHADOW_CENTER, (float) (0.4158878504672897 * imageWidth), GAUGE_INNERSHADOW_FRACTIONS, GAUGE_INNERSHADOW_COLORS);

        graphics.setPaint(GAUGE_INNERSHADOW_GRADIENT);

        graphics.fill(GAUGE_INNERSHADOW);
//        if (backgroundColorModel != BackgroundColor.TRANSPARENT)
//        {
        graphics.fill(GAUGE_INNERSHADOW);
//        }

        graphics.dispose();

//        if (BACKGROUND_IMAGE != null)
//        {
//            final Graphics2D G = BACKGROUND_IMAGE.createGraphics();
//            G.drawImage(radBackgroundImage, 0, 0, null);
//            G.dispose();
//        }
    }

    protected abstract Paint getPaint(Dimension dimensions, Ellipse2D bounds);

    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Ellipse2D GAUGE_BACKGROUND)
    {

    }

}
