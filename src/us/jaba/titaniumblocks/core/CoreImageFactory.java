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
package us.jaba.titaniumblocks.core;

import us.jaba.titaniumblocks.core.image.ImageSupport;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author tbeckett
 */
public class CoreImageFactory
{

    protected static final BufferedImage DEFAULT_NULL_IMAGE = ImageSupport.DEFAULT_SMALL_IMAGE;
    private CoreBean painter = null;
    private BufferedImage backgroundImage = DEFAULT_NULL_IMAGE;
    public BufferedImage result;

    public CoreImageFactory()
    {
        this(new CoreBean());
    }

    protected CoreImageFactory(CoreBean painter)
    {
        this.painter = painter;
        result = ImageSupport.DEFAULT_SMALL_IMAGE;
    }

    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {
        final Graphics2D graphics2D = result.createGraphics();

        if (painter != null)
        {
            painter.paint(graphics2D, dimensions);
            graphics2D.dispose();
        }

        if (backgroundImage != null)
        {
            final Graphics2D graphics = backgroundImage.createGraphics();
            graphics.drawImage(result, 0, 0, null);
            graphics.dispose();
        }
    }

    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.DEFAULT_SMALL_IMAGE;
        }
        if (painter != null && painter.hasChanged())
        {
            result = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

            applyPaint(result, dimensions);
        }
        return result;
    }

    public void setChanged()
    {
        if (this.painter != null)
        {
            this.painter.changed();
        }
    }

    public Painter getPainter()
    {
        return painter;
    }
    
    public void setPainter(CoreBean cm)
    {
        painter = cm;
        painter.changed();
    }

    public void setBackgroundImage(BufferedImage backgroundImage)
    {
        this.backgroundImage = backgroundImage;
    }

    public BufferedImage getBackgroundImage()
    {
        return backgroundImage;
    }

}
