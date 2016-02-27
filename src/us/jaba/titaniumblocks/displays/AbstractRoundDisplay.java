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
package us.jaba.titaniumblocks.displays;

import java.util.ArrayList;
import us.jaba.titaniumblocks.core.CoreImageFactory;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.Painter;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.frames.FrameModel;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.led.LedImageFactory;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.text.types.TitleText;
import us.jaba.titaniumblocks.core.text.types.UnitsText;

/**
 *
 * @author tbeckett
 */
public class AbstractRoundDisplay extends CoreModel implements Painter
{

    protected static final float DEFAULT_FONT_SCALE_FACTOR = 0.67F;
    protected float fontScaleFactor;

    private final ArrayList<CoreImageFactory> listOfImageFactories;

    protected BackdropImageFactory backdropImage;
    protected PostImageFactory centerPostImage;
    protected DoubleValueText doubleValueText;
    protected RoundFrameImageFactory frameImage;
    protected FrontcoverImageFactory frontcoverImage;

    protected double normalizedValue = 0.39;
    protected TBText tbText;
    protected TextImageFactory tbTextImage;
    protected TextImageFactory titleTextImage;
    protected TitleText titleValueText;
    protected UnitsText unitsText;
    protected TextImageFactory unitsTextImage;
    protected TextImageFactory valueTextImage;
    protected PointerImageFactory pointerImage;
    protected DisabledImageFactory disabledImage;

    protected LedImageFactory ledImageFactory;
    protected ShadowPointerImageFactory secShadowPointerImage;

    public AbstractRoundDisplay(BackdropImageFactory backdropImage, RoundFrameImageFactory frameImage, PostImageFactory centerPostImage)
    {
        this();
        this.backdropImage = backdropImage;
        add(backdropImage);
        this.frameImage = frameImage;
        add(frameImage);
        this.centerPostImage = centerPostImage;
        add(centerPostImage);

        doubleValueText = new DoubleValueText();
        valueTextImage = new TextImageFactory(doubleValueText);
        add(valueTextImage);

        titleValueText = new TitleText();
        titleTextImage = new TextImageFactory(titleValueText);
        add(titleTextImage);

        unitsText = new UnitsText();
        unitsTextImage = new TextImageFactory(unitsText);
        add(unitsTextImage);

        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);
        add(tbTextImage);

    }

    public AbstractRoundDisplay()
    {
        listOfImageFactories = new ArrayList();
    }

    public final void add(CoreImageFactory imageFactory)
    {
        listOfImageFactories.add(imageFactory);
    }

    public Backdrop getBackdrop()
    {
        return backdropImage.getTickmark();
    }

    public void setBackdrop(Backdrop painter)
    {
        this.backdropImage = new BackdropImageFactory(painter);
    }

    public void setCenterPost(Post postPainter)
    {
        centerPostImage.setPainter(postPainter);
    }

    public FrameModel getFrame()
    {
        return frameImage.getTickmark();
    }

    public void setFrame(RoundFrame linearFramePainter)
    {
        this.frameImage.setPainter(linearFramePainter);
        setChanged();
    }

    public void setFrontCover(Frontcover foregroundPainter)
    {
        this.frontcoverImage.setPainter(foregroundPainter);
    }

    public void setNormalizedValue(double d)
    {
        normalizedValue = (double) d;
    }

    public void setTitle(String string)
    {
        titleValueText.setValue(string);
    }

    public void setUnits(String units)
    {
        unitsText.setValue(units);
    }

    public void setValueText(Text valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getTickmark().getColor());
        this.valueTextImage.setPainter(valueTextPainter);
    }

    public final void setChanged()
    {
        for (CoreImageFactory cif : listOfImageFactories)
        {
            cif.setChanged();
        }

    }

    public float getFontScaleFactor()
    {
        return fontScaleFactor;
    }

    public void setFontScaleFactor(float fontScaleFactor)
    {
        this.fontScaleFactor = fontScaleFactor;
    }

    public void setDisabled(DisabledPainter disabledPainter)
    {
        this.disabledImage.setPainter(disabledPainter);

    }

    public void setPointer(Pointer pointerPainter, Pointer shadowPainter)
    {
        this.pointerImage.setPainter(pointerPainter);

        this.secShadowPointerImage.setPainter(shadowPainter);

    }

    public void setLed(Led ledPainter)
    {
        this.ledImageFactory.setPainter(ledPainter);
    }

}
