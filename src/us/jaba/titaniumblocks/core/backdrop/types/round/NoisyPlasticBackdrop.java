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
package us.jaba.titaniumblocks.core.backdrop.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRoundBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.NoisePainter;
import us.jaba.titaniumblocks.core.textures.TextureImageBuilder;
import us.jaba.titaniumblocks.core.textures.types.StainlessSteelPlateTexture;
import us.jaba.titaniumblocks.core.color.ColorTools;
import us.jaba.titaniumblocks.core.utils.PointSupport;

public class NoisyPlasticBackdrop extends AbstractRoundBackdrop
{
    private final TextureImageBuilder builder;
   
    private final NoisePainter noisePainter;

    private final float[] FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] COLORS =
    {
        ColorTools.lighter(backgroundColorModel.getGradientStartColor(), 0.15f),
        ColorTools.darker(backgroundColorModel.getGradientStopColor(), 0.15f)
    };

    public NoisyPlasticBackdrop()
    {
        noisePainter = new NoisePainter();
        StainlessSteelPlateTexture painter = new StainlessSteelPlateTexture();
        builder = new TextureImageBuilder(painter);
    }

      @Override
    public void setBackgroundColor(BackdropColorModel colorModel)
    {
        super.setBackgroundColor( colorModel); 
        noisePainter.setDarkNoise(colorModel.getGradientStartColor().darker());
        noisePainter.setBrightNoise(colorModel.getGradientStopColor().brighter());
    }

    
    @Override
    protected Paint getPaint(Dimension dimensions, Ellipse2D bounds)
    {
        COLORS[0] = ColorTools.darker(backgroundColorModel.getGradientStartColor(), 0.15f);
        COLORS[1] = ColorTools.lighter(backgroundColorModel.getGradientStopColor(), 0.15f);
        final Point2D BACKGROUND_START = new Point2D.Double(0, bounds.getBounds2D().getMinY());
        final Point2D BACKGROUND_STOP = new Point2D.Double(0, bounds.getBounds2D().getMaxY());
        PointSupport.validateGradientPoints(BACKGROUND_START, BACKGROUND_STOP);
        Paint p = new LinearGradientPaint(BACKGROUND_START, BACKGROUND_STOP, FRACTIONS, COLORS);

        return p;
    }

    public TextureImageBuilder getBuilder()
    {
        return builder;
    }

    @Override
    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Ellipse2D GAUGE_BACKGROUND)
    {
        noisePainter.paint(graphics, dimensions, GAUGE_BACKGROUND.getBounds());
    }

//    public Color getTextureColor()
//    {
//        return textureColor;
//    }
//
//    public void setTextureColor(Color textureColor)
//    {
//        this.textureColor = textureColor;
//        COLORS[0] = ColorTools.lighter(textureColor, 0.15f);
//        COLORS[1] = ColorTools.darker(textureColor, 0.15f);
//        changed();
//    }
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

  
}
