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

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public class SoftClipImageGenerator
{

    /**
     * Method that creates a intermediate image to enable soft clipping
     * functionality This code was taken from Chris Campbells blog
     * http://weblogs.java.net/blog/campbell/archive/2006/07/java_2d_tricker.html
     *
     * @param SHAPE
     * @param SHAPE_PAINT
     * @return IMAGE buffered image that will be used for soft clipping
     */
    public static BufferedImage create(final Shape SHAPE, final Paint SHAPE_PAINT)
    {
        final BufferedImage IMAGE = ImageSupport.createImage(SHAPE.getBounds().width, SHAPE.getBounds().height, Transparency.TRANSLUCENT);
        final Graphics2D G2 = IMAGE.createGraphics();

        // Clear the image so all pixels have zero alpha
        G2.setComposite(AlphaComposite.Clear);
        G2.fillRect(0, 0, IMAGE.getWidth(), IMAGE.getHeight());

        // Render our clip shape into the image.  Note that we enable
        // antialiasing to achieve the soft clipping effect.  Try
        // commenting out the line that enables antialiasing, and
        // you will see that you end up with the usual hard clipping.
        G2.setComposite(AlphaComposite.Src);
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set Color or Gradient here
        if (SHAPE_PAINT != null)
        {
            G2.setPaint(SHAPE_PAINT);
        }

        // Translate the coordinate system to 0,0
        G2.translate(-SHAPE.getBounds2D().getX(), -SHAPE.getBounds2D().getY());
        G2.fill(SHAPE);

        return IMAGE;
    }

    /**
     * <p>
     * Method that creates a intermediate image to enable soft clipping
     * functionality This code was taken from Chris Campbells blog
     * http://weblogs.java.net/blog/campbell/archive/2006/07/java_2d_tricker.html</p>
     *
     * @param SHAPE
     * @param SHAPE_PAINT
     * @param SOFTNESS
     * @param TRANSLATE_X
     * @param TRANSLATE_Y
     * @return IMAGE buffered image that will be used for soft clipping
     */
    public static BufferedImage create(final Shape SHAPE, final Paint SHAPE_PAINT, final int SOFTNESS, final int TRANSLATE_X, final int TRANSLATE_Y)
    {
        final BufferedImage IMAGE = ImageSupport.createImage(SHAPE.getBounds().width + 2 * SOFTNESS + TRANSLATE_X, SHAPE.getBounds().height + 2 * SOFTNESS + TRANSLATE_Y, Transparency.TRANSLUCENT);
        final Graphics2D G2 = IMAGE.createGraphics();

        G2.translate(SOFTNESS / 2.0, SOFTNESS / 2.0);

        // Clear the image so all pixels have zero alpha
        G2.setComposite(AlphaComposite.Clear);
        G2.fillRect(0, 0, IMAGE.getWidth(), IMAGE.getHeight());

        // Render our clip shape into the image.  Note that we enable
        // antialiasing to achieve the soft clipping effect.  Try
        // commenting out the line that enables antialiasing, and
        // you will see that you end up with the usual hard clipping.
        G2.setComposite(AlphaComposite.Src);
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set Color or Gradient here
        if (SHAPE_PAINT != null)
        {
            G2.setPaint(SHAPE_PAINT);
        }

        // Translate the coordinate system to 0,0
        G2.translate(-SHAPE.getBounds2D().getX(), -SHAPE.getBounds2D().getY());
        G2.fill(SHAPE);

        return IMAGE;
    }

}
