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
package us.jaba.titaniumblocks.core.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public class ImageReflection
{
    /**
     * Creates a image that contains the reflection of the given sourceimage.
     * This could be useful whereever you need some eyecandy.
     *
     * @param SOURCE_IMAGE
     * @param OPACITY a good standard value is 0.5f
     * @param FADE_OUT_HEIGHT a good standard value is 0.7f
     * @return a new buffered image that contains the reflection of the original
     * image
     */
    public static BufferedImage createReflectionImage(final BufferedImage SOURCE_IMAGE, final float OPACITY, final float FADE_OUT_HEIGHT)
    {
        final BufferedImage REFLECTION_IMAGE = new BufferedImage(SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);
        final BufferedImage BLURED_REFLECTION_IMAGE = new BufferedImage(SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);

        final Graphics2D G2 = REFLECTION_IMAGE.createGraphics();

        G2.translate(0, SOURCE_IMAGE.getHeight());
        G2.scale(1, -1);
        G2.drawRenderedImage(SOURCE_IMAGE, null);
        G2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.DST_IN));
        G2.setPaint(new java.awt.GradientPaint(0, SOURCE_IMAGE.getHeight() * FADE_OUT_HEIGHT, new Color(0.0f, 0.0f, 0.0f, 0.0f), 0, SOURCE_IMAGE.getHeight(), new Color(0.0f, 0.0f, 0.0f, OPACITY)));
        G2.fillRect(0, 0, SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight());
        G2.dispose();

        // Blur the reflection to make it look more realistic
        float[] data =
        {
            0.0625f,
            0.125f,
            0.0625f,
            0.125f,
            0.25f,
            0.125f,
            0.0625f,
            0.125f,
            0.0625f
        };
        final java.awt.image.Kernel KERNEL = new java.awt.image.Kernel(3, 3, data);
        final java.awt.image.ConvolveOp CONVOLE = new java.awt.image.ConvolveOp(KERNEL, java.awt.image.ConvolveOp.EDGE_NO_OP, null);
        CONVOLE.filter(REFLECTION_IMAGE, BLURED_REFLECTION_IMAGE);

        return BLURED_REFLECTION_IMAGE;
    }
}
