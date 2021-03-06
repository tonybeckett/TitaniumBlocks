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
import java.awt.Paint;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRoundBackdrop;
import us.jaba.titaniumblocks.core.textures.TextureImageBuilder;
import us.jaba.titaniumblocks.core.textures.types.LinenTexture;

public class LinenBackdrop extends AbstractRoundBackdrop
{

    private LinenTexture painter;

//    private Color color = ColorPalette.GRAY.darker();//(0x686868);

    public LinenBackdrop()
    {
        painter = new LinenTexture();
    }

    @Override
    protected Paint getPaint(Dimension dimensions, Ellipse2D bounds)
    {
        painter.setBrushColor(backgroundColorModel.getGradientStartColor());
        TextureImageBuilder builder = new TextureImageBuilder(painter);
        Paint p = new TexturePaint(builder.build(dimensions), bounds.getBounds());

        return p;
    }

    public LinenTexture getPainter()
    {
        return painter;
    }

    public void setPainter(LinenTexture painter)
    {
        this.painter = painter;
        changed();
    }

//    public Color getColor()
//    {
//        return color;
//    }
//
//    public void setColor(Color color)
//    {
//        this.color = color;
//        changed();
//    }

}
