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
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public class ShapeImageGenerator
{

    public static BufferedImage createImageFromShape(final Shape SHAPE, final Paint PAINT, final Color COLOR, final boolean FILLED, final Stroke STROKE, final Color STROKE_COLOR)
    {
        final BufferedImage IMAGE = ImageSupport.createImage(SHAPE.getBounds().width, SHAPE.getBounds().height, Transparency.TRANSLUCENT);
        final Graphics2D G2 = IMAGE.createGraphics();

        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        G2.translate(-SHAPE.getBounds2D().getX(), -SHAPE.getBounds2D().getY());

        if (PAINT != null)
        {
            G2.setPaint(PAINT);
            if (FILLED)
            {
                G2.fill(SHAPE);
            } else
            {
                G2.draw(SHAPE);
            }
        }

        if (COLOR != null)
        {
            G2.setColor(COLOR);
            if (FILLED)
            {
                G2.fill(SHAPE);
            } else
            {
                G2.draw(SHAPE);
            }
        }

        if (STROKE != null)
        {
            if (STROKE_COLOR != null)
            {
                G2.setColor(STROKE_COLOR);
            }

            G2.setStroke(STROKE);

            if (!FILLED)
            {
                G2.draw(SHAPE);
            }
        }

        G2.dispose();

        return IMAGE;

    }

}
