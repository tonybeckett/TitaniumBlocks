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
package us.jaba.titaniumblocks.core.lcd.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.NullBackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.LcdBackdropModel;
import us.jaba.titaniumblocks.core.backdrop.types.rectangular.NullBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.lcdgradients.StandardGreenLcdPalette;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.font.DigitalFont;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.rectangular.BasicLinearFrontcover;
import us.jaba.titaniumblocks.core.frames.RectangularFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.rectangular.ShinyMetalLinearFrame;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;

/**
 *
 * @author tbeckett
 */
public class LinearLcd extends CoreModel
{

    private BackdropImageFactory backgroundImageBuilder;
    private final RectangularFrameImageFactory linearFrameImageBuilder;
    private BackdropImageFactory lcdBackgroundBuilder;
    private FrontcoverImageFactory foregroundImageBuilder;
    private DisabledImageFactory disabledImageBuilder;
    private TextImageFactory textImageBuilder;

    private boolean disabled = false;

    public LinearLcd()
    {
        this(ColorPalette.YELLOW);
    }

    public LinearLcd(Color c)
    {
        linearFrameImageBuilder = new RectangularFrameImageFactory(new ShinyMetalLinearFrame());
        backgroundImageBuilder = new NullBackdropImageFactory(new NullBackdrop());
        textImageBuilder = new TextImageFactory(new DoubleValueText());
        lcdBackgroundBuilder = new BackdropImageFactory(new LcdBackdropModel());

        foregroundImageBuilder = new FrontcoverImageFactory(new BasicLinearFrontcover());
        disabledImageBuilder = new DisabledImageFactory(new DisabledPainter());

    }

    public BackdropImageFactory getBackgroundImageBuilder()
    {
        return backgroundImageBuilder;
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
        int offset = linearFrameImageBuilder.getPainter().getFrameThickness();
        Dimension interiorDim = linearFrameImageBuilder.getPainter().getInteriorDimension();

        LcdBackdropModel p = (LcdBackdropModel) lcdBackgroundBuilder.getPainter();

        p.setPalette(new StandardGreenLcdPalette());
        image = lcdBackgroundBuilder.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

        textImageBuilder.getPainter().setColor(p.getPalette().getTextColor());

        
        textImageBuilder.getPainter().setFont(DigitalFont.getInstance());
        textImageBuilder.getPainter().setFontSize((float) (interiorDim.getHeight() * 0.8f));
        image = textImageBuilder.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

        image = foregroundImageBuilder.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

        if (isDisabled())
        {
            image = disabledImageBuilder.build(interiorDim);
            graphics.drawImage(image, offset, offset, null);
        }

    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
        changed();
    }

    public void setBackgroundImageBuilder(NullBackdropImageFactory backgroundImageBuilder)
    {
        this.backgroundImageBuilder = backgroundImageBuilder;
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
