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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRoundBackdrop;
import us.jaba.titaniumblocks.core.backdrop.types.NoisePainter;
import us.jaba.titaniumblocks.core.backdrop.types.OverlayPainter;
import us.jaba.titaniumblocks.core.textures.TextureImageBuilder;
import us.jaba.titaniumblocks.core.textures.types.PunchedSheetTexture;

public class PunchedSteelBackdrop extends AbstractRoundBackdrop
{

    private PunchedSheetTexture painter;
    private final Rectangle rectangle;
    private final OverlayPainter overlayPainter;
    private final NoisePainter noisePainter;

    public PunchedSteelBackdrop()
    {
        rectangle = new Rectangle(0, 0, 12, 12);
        painter = new PunchedSheetTexture();
        overlayPainter = new OverlayPainter();
        noisePainter = new NoisePainter();

    }

    @Override
    protected Paint getPaint(Dimension dimensions, Ellipse2D ellipse)
    {
        TextureImageBuilder builder = new TextureImageBuilder(painter);
        Paint p = new TexturePaint(builder.build(dimensions), rectangle);

        return p;
    }

    public PunchedSheetTexture getPainter()
    {
        return painter;
    }

    public void setPainter(PunchedSheetTexture painter)
    {
        this.painter = painter;
         changed();
    }

    public OverlayPainter getOverlayPainter()
    {
        return overlayPainter;
    }

    @Override
    public void setBackgroundColor(BackdropColorModel backgroundColorModel)
    {
        super.setBackgroundColor(backgroundColorModel); 
        
        painter.setBrushColor(backgroundColorModel.getGradientStartColor());
         
    }

    @Override
    protected void applyOverlay(Graphics2D graphics, Dimension dimensions, Ellipse2D GAUGE_BACKGROUND)
    {
        noisePainter.paint(graphics, dimensions, GAUGE_BACKGROUND.getBounds().getBounds());
    }

}
