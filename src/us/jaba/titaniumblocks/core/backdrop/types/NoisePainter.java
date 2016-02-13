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
package us.jaba.titaniumblocks.core.backdrop.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author tbeckett
 */
public class NoisePainter
{

    private Color DARK_NOISE = new Color(0.2f, 0.2f, 0.2f);
    private Color BRIGHT_NOISE = new Color(0.8f, 0.8f, 0.8f);

    public void paint(Graphics2D graphics, Dimension dimensions, Rectangle2D GAUGE_BACKGROUND)
    {
        final Random BW_RND = new Random();
        final Random ALPHA_RND = new Random();
        final Shape OLD_CLIP = graphics.getClip();
        graphics.setClip(GAUGE_BACKGROUND);
        Color noiseColor;
        int noiseAlpha;
        for (int y = 0; y < GAUGE_BACKGROUND.getHeight(); y++)
        {
            for (int x = 0; x < GAUGE_BACKGROUND.getWidth(); x++)
            {
                if (BW_RND.nextBoolean())
                {
                    noiseColor = BRIGHT_NOISE;
                } else
                {
                    noiseColor = DARK_NOISE;
                }
                noiseAlpha = 10 + ALPHA_RND.nextInt(10) - 5;
                graphics.setColor(new Color(noiseColor.getRed(), noiseColor.getGreen(), noiseColor.getBlue(), noiseAlpha));
                graphics.drawLine((int) (x + GAUGE_BACKGROUND.getMinX()), (int) (y + GAUGE_BACKGROUND.getMinY()), (int) (x + GAUGE_BACKGROUND.getMinX()), (int) (y + GAUGE_BACKGROUND.getMinY()));
            }
        }
        graphics.setClip(OLD_CLIP);
    }

    public Color getDarkNoise()
    {
        return DARK_NOISE;
    }

    public void setDarkNoise(Color DARK_NOISE)
    {
        this.DARK_NOISE = DARK_NOISE;
    }

    public Color getBrightNoise()
    {
        return BRIGHT_NOISE;
    }

    public void setBrightNoise(Color BRIGHT_NOISE)
    {
        this.BRIGHT_NOISE = BRIGHT_NOISE;
    }

}
