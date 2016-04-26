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

import java.awt.Dimension;
import java.util.ArrayList;
import us.jaba.titaniumblocks.core.CoreImageFactory;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.Painter;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frames.FrameImageFactory;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.core.text.types.PolarText;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;

/**
 *
 * @author tbeckett
 */
public class AbstractDial extends CoreBean implements TBComponent, Painter
{

    protected static final float DEFAULT_FONT_SCALE_FACTOR = 0.67F;
    protected float fontScaleFactor;

    private final ArrayList<CoreImageFactory> listOfImageFactories = new ArrayList();;

    protected BackdropImageFactory backdropImage;
    protected PostImageFactory centerPostImage;
    protected DoubleValueText doubleValueText;
    protected FrameImageFactory frameImage;
    protected FrontcoverImageFactory frontcoverImage;

    protected double normalizedValue = 0.39;
    protected TBText tbText;
    protected TextImageFactory tbTextImage;
    protected TextImageFactory text1Image;
    protected PolarText text1;
    protected PolarText text2;
    protected TextImageFactory text2Image;
    protected TextImageFactory valueTextImage;
    protected PointerImageFactory pointerImage;
  
    protected TickmarkImageFactory tickmarkImage;
  
    protected ShadowPointerImageFactory secShadowPointerImage;

    public AbstractDial(BackdropImageFactory backdropImage, FrameImageFactory frameImage, PostImageFactory centerPostImage)
    {
        init();
        this.backdropImage = backdropImage;
        add(backdropImage);
        this.frameImage = frameImage;
        add(frameImage);
        this.centerPostImage = centerPostImage;
        add(centerPostImage);
    }

    public AbstractDial()
    {
        init();  
    }

    private void init()
    {
        doubleValueText = new DoubleValueText();
        valueTextImage = new TextImageFactory(doubleValueText);
        add(valueTextImage);

        text1 = new PolarText();
        text1Image = new TextImageFactory(text1);
        add(text1Image);

        text2 = new PolarText();
        text2Image = new TextImageFactory(text2);
        add(text2Image);

        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);
        add(tbTextImage);

    }

    public final void add(CoreImageFactory imageFactory)
    {
        listOfImageFactories.add(imageFactory);
    }

    @Override
    public Backdrop getBackdrop()
    {
        return backdropImage.getPainter();
    }

    @Override
    public void setBackdrop(Backdrop painter)
    {
        this.backdropImage = new BackdropImageFactory(painter);
    }

    @Override
    public void setCenterPost(Post postPainter)
    {
        centerPostImage.setPainter(postPainter);
    }

    @Override
    public BasicFrame getFrame()
    {
        return (BasicFrame) frameImage.getPainter();
    }

    @Override
    public void setFrame(BasicFrame linearFramePainter)
    {
        this.frameImage.setPainter( linearFramePainter);
        setChanged();
    }

    @Override
    public void setFrontCover(Frontcover foregroundPainter)
    {
        this.frontcoverImage.setPainter(foregroundPainter);
    }

    @Override
    public Post getCenterPost()
    {
        return centerPostImage.getPainter();
    }

    @Override
    public Frontcover getFrontCover()
    {
        return frontcoverImage.getPainter();
    }

    public void setNormalizedValue(double d)
    {
        normalizedValue = (double) d;
    }

    public void setTitle(String string)
    {
        text1.setValue(string);
    }

    public void setUnits(String units)
    {
        text2.setValue(units);
    }

    public void setValueText(Text valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getPainter().getColor());
        this.valueTextImage.setPainter(valueTextPainter);
    }

    @Override
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

   

    @Override
    public void setPointer(Pointer pointerPainter)
    {
        this.pointerImage.setPainter(pointerPainter);

        this.secShadowPointerImage.setPainter(pointerPainter);

    }

    @Override
    public Pointer getPointer()
    {
        return pointerImage.getPainter();
    }

    

    @Override
    public PolarText getText1()
    {
        return text1;
    }

    @Override
    public void setText1(Text text)
    {
        this.text1 = (PolarText) text;
        
    }

    @Override
    public Dimension getSize()
    {
        return new Dimension(0, 0);
    }

    @Override
    public void setSize(Dimension d)
    {

    }

    @Override
    public Tickmark getTickmarks()
    {
        return  tickmarkImage.getPainter();
    }

    @Override
    public void setTickmarks(Tickmark tm)
    {
        tickmarkImage.setPainter(tm);
    }

    public DoubleValueText getDoubleValueText()
    {
        return doubleValueText;
    }

    public double getNormalizedValue()
    {
        return normalizedValue;
    }

     
    public PolarText getText2()
    {
        return text2;
    }

    public void setText2(Text text2)
    {
        this.text2 = (PolarText) text2;
    }

}
