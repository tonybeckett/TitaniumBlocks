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
package us.jaba.titaniumblocks.core.indicators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.NullBackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.models.round.NullBackgroundPainter;

import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.models.round.TopHalfRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.models.round.SilverRadialFramePainter;
import us.jaba.titaniumblocks.core.image.ImageSupport;
import us.jaba.titaniumblocks.core.symbols.SymbolImageFactory;
import us.jaba.titaniumblocks.core.symbols.painters.Fuel;

/**
 *
 * @author tbeckett
 */
public class RoundIndicatorImageFactory
{

    private NullBackdropImageFactory backgroundImageBuilder;
    private final RoundFrameImageFactory radialFrameImageBuilder;
    private SymbolImageFactory symbolOnImageBuilder;
    private SymbolImageFactory symbolOffImageBuilder;
    private FrontcoverImageFactory foregroundImageBuilder;
    private DisabledImageFactory disabledImageBuilder;

    private boolean on;

    public RoundIndicatorImageFactory()
    {
        radialFrameImageBuilder = new RoundFrameImageFactory(new SilverRadialFramePainter());
        backgroundImageBuilder = new NullBackdropImageFactory(new NullBackgroundPainter());
        symbolOnImageBuilder = new SymbolImageFactory(new Fuel());
        symbolOffImageBuilder = new SymbolImageFactory(new Fuel());
        symbolOnImageBuilder.getPainter().setPaintColor(Color.RED);

        foregroundImageBuilder = new FrontcoverImageFactory(new TopHalfRadialForegroundPainter());
        disabledImageBuilder = new DisabledImageFactory(new DisabledPainter());
        on = false;
    }

    public NullBackdropImageFactory getBackgroundImageBuilder()
    {
        return backgroundImageBuilder;
    }

    public SymbolImageFactory getSymbolOnImageBuilder()
    {
        return symbolOnImageBuilder;
    }

    public SymbolImageFactory getSymbolOffImageBuilder()
    {
        return symbolOffImageBuilder;
    }

    public FrontcoverImageFactory getForegroundImageBuilder()
    {
        return foregroundImageBuilder;
    }

    public DisabledImageFactory getDisabledImageBuilder()
    {
        return disabledImageBuilder;
    }

    public BufferedImage getImage(Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        BufferedImage baseImage = ImageSupport.createImage(imageWidth, imageHeight, Color.TRANSLUCENT);
        final Graphics2D graphics = (Graphics2D) baseImage.createGraphics();

        paint(graphics, dimensions);
        return baseImage;
    }

    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        BufferedImage image = backgroundImageBuilder.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

        image = radialFrameImageBuilder.build(dimensions);
        graphics.drawImage(image, 0, 0, null);
        
        if (on)
        {
            image = symbolOnImageBuilder.build(dimensions);
        } else
        {
            image = symbolOffImageBuilder.build(dimensions);
        }
        graphics.drawImage(image, 0, 0, null);

        image = foregroundImageBuilder.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

    }

    public boolean isOn()
    {
        return on;
    }

    public void setOn(boolean on)
    {
        this.on = on;
    }

    public void setBackgroundImageBuilder(NullBackdropImageFactory backgroundImageBuilder)
    {
        this.backgroundImageBuilder = backgroundImageBuilder;
    }

    public void setSymbolOnImageBuilder(SymbolImageFactory symbolOnImageBuilder)
    {
        this.symbolOnImageBuilder = symbolOnImageBuilder;
    }

    public void setSymbolOffImageBuilder(SymbolImageFactory symbolOffImageBuilder)
    {
        this.symbolOffImageBuilder = symbolOffImageBuilder;
    }

    public void setForegroundImageBuilder(FrontcoverImageFactory foregroundImageBuilder)
    {
        this.foregroundImageBuilder = foregroundImageBuilder;
    }

    public void setDisabledImageBuilder(DisabledImageFactory disabledImageBuilder)
    {
        this.disabledImageBuilder = disabledImageBuilder;
    }

}
