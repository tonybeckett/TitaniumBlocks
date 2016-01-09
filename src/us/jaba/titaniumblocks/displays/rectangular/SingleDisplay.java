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
import us.jaba.titaniumblocks.core.backdrop.models.BackdropModel;
import us.jaba.titaniumblocks.core.backdrop.models.rectangular.NullBackdropPainter;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.painters.NullLinearDisabledPainter;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.models.FrontcoverModel;
import us.jaba.titaniumblocks.core.frontcover.models.rectangular.BasicLinearFrontcoverModel;
import us.jaba.titaniumblocks.core.frames.RectangularFramePainter;
import us.jaba.titaniumblocks.core.frames.RectangularFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.models.rectangular.ShinyMetalLinearFramePainter;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.TextPainter;
import us.jaba.titaniumblocks.core.text.painters.DoubleValueText;
import us.jaba.titaniumblocks.core.text.painters.TBText;
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
        this(Color.BLACK);
    }

    public SingleDisplay(Color c)
    {
        super();
        linearFrameImage = new RectangularFrameImageFactory(new ShinyMetalLinearFramePainter());
        backgroundImage = new BackdropImageFactory(new NullBackdropPainter());
        doubleValueText = new DoubleValueText();

        valueTextImage = new TextImageFactory(doubleValueText);

        foregroundImage = new FrontcoverImageFactory(new BasicLinearFrontcoverModel());
        disabledImage = new DisabledImageFactory(new NullLinearDisabledPainter());

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
        int offset = linearFrameImage.getPainter().getFrameThickness();
        Dimension interiorDim = linearFrameImage.getPainter().getInteriorDimension();

//        valueTextImage.getPainter().setFontSize((float) (interiorDim.getHeight() * fontScaleFactor));
        valueTextImage.getPainter().setFontSize((float) (Math.min(interiorDim.getHeight(), interiorDim.getWidth()) * fontScaleFactor));

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
        return valueTextImage.getPainter().getColor();
    }

    public void setColor(Color c)
    {
        valueTextImage.getPainter().setColor(c);
    }

    public BackdropModel getBackgroundPainter()
    {
        return backgroundImage.getPainter();
    }

    public RectangularFramePainter getFramePainter()
    {
        return linearFrameImage.getPainter();
    }

    public TextPainter getTextPainter()
    {
        return valueTextImage.getPainter();
    }

    public FrontcoverModel getPainter()
    {
        return foregroundImage.getPainter();
    }

    public void setBackgroundPainter(BackdropModel painter)
    {
        this.backgroundImage = new BackdropImageFactory(painter);
    }

    public void setLinearFramePainter(RectangularFramePainter linearFramePainter)
    {
        this.linearFrameImage = new RectangularFrameImageFactory(linearFramePainter);
    }

    public void setForegroundPainter(FrontcoverModel foregroundPainter)
    {
        this.foregroundImage = new FrontcoverImageFactory(foregroundPainter);
    }

    public void setDisabledPainter(DisabledPainter disabledPainter)
    {
        this.disabledImage = new DisabledImageFactory(disabledPainter);
    }

    public void setValueTextPainter(TextPainter valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getPainter().getColor());
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
