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
package us.jaba.titaniumblocks.core.backdrop.types.rectangular;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRectangularBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.OverlayPainter;
import us.jaba.titaniumblocks.core.textures.TextureImageBuilder;
import us.jaba.titaniumblocks.core.textures.types.CarbonTexture;

public class CarbonBackdrop extends AbstractRectangularBackdrop
{

    CarbonTexture painter;
    private final Rectangle rectangle;
    private final OverlayPainter overlayPainter;

    public CarbonBackdrop()
    {
        rectangle = new java.awt.Rectangle(0, 0, 12, 12);
        painter = new CarbonTexture();
        overlayPainter = new OverlayPainter();

    }

    @Override
    protected Paint getPaint(Dimension dimensions, Rectangle bounds)
    {
        TextureImageBuilder builder = new TextureImageBuilder(painter);
        Paint p = new TexturePaint(builder.build(dimensions), rectangle);

        return p;
    }

    public CarbonTexture getPainter()
    {
        return painter;
    }

    public void setPainter(CarbonTexture painter)
    {
        this.painter = painter;
    }

    @Override
    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Rectangle2D GAUGE_BACKGROUND)
    {
        overlayPainter.paint(graphics, dimensions, GAUGE_BACKGROUND);
    }

}
