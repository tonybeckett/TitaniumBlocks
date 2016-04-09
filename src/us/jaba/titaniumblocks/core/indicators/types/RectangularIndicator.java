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
package us.jaba.titaniumblocks.core.indicators.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.backdrop.NullBackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.rectangular.NullBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.rectangular.BasicLinearFrontcover;
import us.jaba.titaniumblocks.core.frames.RectangularFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.rectangular.ShinyMetalLinearFrame;
import us.jaba.titaniumblocks.core.symbols.SymbolImageFactory;
import us.jaba.titaniumblocks.core.symbols.Symbol;
import us.jaba.titaniumblocks.core.symbols.types.Temperature;

/**
 *
 * @author tbeckett
 */
public class RectangularIndicator extends CoreBean
{

    private NullBackdropImageFactory backgroundImageBuilder;
    private final RectangularFrameImageFactory linearFrameImageBuilder;
    private SymbolImageFactory symbolOnImageBuilder;
    private SymbolImageFactory symbolOffImageBuilder;
    private FrontcoverImageFactory foregroundImageBuilder;
    private DisabledImageFactory disabledImageBuilder;

    private boolean on;

    public RectangularIndicator()
    {
        this(new Temperature());
    }

    public RectangularIndicator(Symbol symbolPainter)
    {
        this(symbolPainter, ColorPalette.RED);
    }

    public RectangularIndicator(Symbol symbolPainter, Color c)
    {
        linearFrameImageBuilder = new RectangularFrameImageFactory(new ShinyMetalLinearFrame());
        backgroundImageBuilder = new NullBackdropImageFactory(new NullBackdrop());

        foregroundImageBuilder = new FrontcoverImageFactory(new BasicLinearFrontcover());
        disabledImageBuilder = new DisabledImageFactory(new DisabledPainter());
        on = false;
        this.symbolOnImageBuilder = new SymbolImageFactory(symbolPainter);
        this.symbolOffImageBuilder = new SymbolImageFactory(symbolPainter);
        symbolOnImageBuilder.getPainter().setPaintColor(c);
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

    public RectangularFrameImageFactory getLinearFrameImageBuilder()
    {
        return linearFrameImageBuilder;
    }

    public DisabledImageFactory getDisabledImageBuilder()
    {
        return disabledImageBuilder;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        BufferedImage image = backgroundImageBuilder.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

        image = linearFrameImageBuilder.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

        if (on)
        {
            image = symbolOnImageBuilder.build(linearFrameImageBuilder.getPainter().getInteriorDimension());
        } else
        {
            image = symbolOffImageBuilder.build(linearFrameImageBuilder.getPainter().getInteriorDimension());
        }
        int offset = (int) linearFrameImageBuilder.getPainter().getFrameThickness();
        graphics.drawImage(image, offset, offset, null);

        image = foregroundImageBuilder.build(linearFrameImageBuilder.getPainter().getInteriorDimension());
        graphics.drawImage(image, offset, offset, null);

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
        changed();
    }

    public void setSymbolOnImageBuilder(SymbolImageFactory symbolOnImageBuilder)
    {
        this.symbolOnImageBuilder = symbolOnImageBuilder;
        changed();
    }

    public void setSymbolOffImageBuilder(SymbolImageFactory symbolOffImageBuilder)
    {
        this.symbolOffImageBuilder = symbolOffImageBuilder;
        changed();
    }

    public void setForegroundImageBuilder(FrontcoverImageFactory foregroundImageBuilder)
    {
        this.foregroundImageBuilder = foregroundImageBuilder;
        changed();
    }

    public void setDisabledImageBuilder(DisabledImageFactory disabledImageBuilder)
    {
        this.disabledImageBuilder = disabledImageBuilder;
        changed();
    }

}
