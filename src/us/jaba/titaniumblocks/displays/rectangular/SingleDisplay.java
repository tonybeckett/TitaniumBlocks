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
package us.jaba.titaniumblocks.displays.rectangular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.rectangular.NullBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.frontcover.types.rectangular.BasicLinearFrontcover;
import us.jaba.titaniumblocks.core.frames.RectangularFrame;
import us.jaba.titaniumblocks.core.frames.RectangularFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.rectangular.ShinyMetalLinearFrame;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.displays.AbstractLinearDisplay;
import us.jaba.titaniumblocks.displays.LinearDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleDisplay extends AbstractLinearDisplay implements LinearDisplay
{

    private static final float DEFAULT_FONT_SCALE_FACTOR = 0.67f;
    private final DoubleValueText doubleValueText;
    private float fontScaleFactor = DEFAULT_FONT_SCALE_FACTOR;

    protected BackdropImageFactory backgroundImage;
    protected RectangularFrameImageFactory linearFrameImage;
    protected FrontcoverImageFactory foregroundImage;
    protected DisabledImageFactory disabledImage;
    protected TextImageFactory valueTextImage;

    public SingleDisplay()
    {
        this(ColorPalette.BLACK);
    }

    public SingleDisplay(Color c)
    {
        super();
        linearFrameImage = new RectangularFrameImageFactory(new ShinyMetalLinearFrame());
        backgroundImage = new BackdropImageFactory(new NullBackdrop());
        doubleValueText = new DoubleValueText();

        valueTextImage = new TextImageFactory(doubleValueText);

        foregroundImage = new FrontcoverImageFactory(new BasicLinearFrontcover());
        disabledImage = new DisabledImageFactory(new NullLinearDisabled());

        setColor(c);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        BufferedImage image = backgroundImage.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

        image = linearFrameImage.build(dimensions);
        graphics.drawImage(image, 0, 0, null);
        int offset = linearFrameImage.getTickmark().getFrameThickness();
        Dimension interiorDim = linearFrameImage.getTickmark().getInteriorDimension();

//        valueTextImage.getTickmark().setFontSize((float) (interiorDim.getHeight() * fontScaleFactor));
        valueTextImage.getTickmark().setFontSize((float) (Math.min(interiorDim.getHeight(), interiorDim.getWidth()) * fontScaleFactor));

        paintPreText(graphics, image, interiorDim, offset);

        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        
        image = valueTextImage.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

        image = foregroundImage.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

        image = disabledImage.build(interiorDim);
        graphics.drawImage(image, offset, offset, null);

    }

    public Color getColor()
    {
        return valueTextImage.getTickmark().getColor();
    }

    public void setColor(Color c)
    {
        valueTextImage.getTickmark().setColor(c);
    }

    public Backdrop getBackgroundPainter()
    {
        return backgroundImage.getTickmark();
    }

    public RectangularFrame getFramePainter()
    {
        return linearFrameImage.getTickmark();
    }

    public Text getTextPainter()
    {
        return valueTextImage.getTickmark();
    }

    public Frontcover getPainter()
    {
        return foregroundImage.getTickmark();
    }

    public void setBackgroundPainter(Backdrop painter)
    {
        this.backgroundImage = new BackdropImageFactory(painter);
    }

    public void setLinearFramePainter(RectangularFrame linearFramePainter)
    {
        this.linearFrameImage = new RectangularFrameImageFactory(linearFramePainter);
    }

    public void setForegroundPainter(Frontcover foregroundPainter)
    {
        this.foregroundImage = new FrontcoverImageFactory(foregroundPainter);
    }

    public void setDisabledPainter(DisabledPainter disabledPainter)
    {
        this.disabledImage = new DisabledImageFactory(disabledPainter);
    }

    public void setValueTextPainter(Text valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getTickmark().getColor());
        this.valueTextImage = new TextImageFactory(valueTextPainter);
    }

    public float getFontScaleFactor()
    {
        return fontScaleFactor;
    }

    public void setFontScaleFactor(float fontScaleFactor)
    {
        this.fontScaleFactor = fontScaleFactor;
    }

    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {

    }

}
