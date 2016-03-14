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
package us.jaba.titaniumblocks.core.pointers;

import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSBlack;

/**
 *
 * @author tbeckett
 */
public abstract class AbstractPointer extends Pointer
{

    protected boolean centerPostVisible;
    protected Scale centerScale;
    protected Scale frontScale;

    private GradientPalette primaryColor;
    private float radiusPercent;
    protected Scale tailScale;
    protected boolean centerPinVisible;
    private GradientPalette secondaryColor;

    public AbstractPointer()
    {
        this(new SSBlack());
    }

    public AbstractPointer(GradientPalette primaryColor)
    {
        this(primaryColor, primaryColor);
    }

    public AbstractPointer(GradientPalette primaryColor, GradientPalette secondaryColor)
    {
        this.primaryColor = primaryColor;
        radiusPercent = 0.95f;
        frontScale = new Scale(1.0);
        tailScale = new Scale(1.0);
        centerPostVisible = false;
        centerScale = new Scale(0.03);
        centerPinVisible = false;
        this.secondaryColor = secondaryColor;
    }

    public AbstractPointer(AbstractPointer other)
    {
        this.centerPostVisible = other.centerPostVisible;
        this.centerScale = other.centerScale;
        this.frontScale = other.frontScale;
        this.primaryColor = other.primaryColor;
        this.radiusPercent = other.radiusPercent;
        this.tailScale = other.tailScale;
        this.centerPinVisible = other.centerPinVisible;
        this.secondaryColor = other.secondaryColor;
    }

    public void copy(AbstractPointer other)
    {
        super.copy(other);

        this.centerPostVisible = other.centerPostVisible;
        this.centerScale = other.centerScale;
        this.frontScale = other.frontScale;
        this.primaryColor = other.primaryColor;
        this.radiusPercent = other.radiusPercent;
        this.tailScale = other.tailScale;
        this.centerPinVisible = other.centerPinVisible;
        this.secondaryColor = other.secondaryColor;
    }

    public void setCenterPostEnable(boolean centerPost)
    {
        this.centerPostVisible = centerPost;
    }

    public Scale getCenterScale()
    {
        return centerScale;
    }

    public void setCenterScale(Scale centerScale)
    {
        this.centerScale = centerScale;
    }

    @Override
    public void setFrontScale(Scale scale)
    {
        this.frontScale = scale;
    }

    public GradientPalette getPrimaryColor()
    {
        return primaryColor;
    }

    @Override
    public void setPrimaryColor(GradientPalette pointerColor)
    {
        this.primaryColor = pointerColor;
        changed();
    }

    public float getRadiusPercent()
    {
        return radiusPercent;
    }

    public void setRadiusPercent(float radiusPercent)
    {
        this.radiusPercent = radiusPercent;
        changed();
    }

    @Override
    public void setTailScale(Scale scale)
    {
        this.tailScale = scale;
        changed();
    }

    public boolean isCenterPostVisible()
    {
        return centerPostVisible;
    }

    public void setCenterPostVisible(boolean centerPostVisible)
    {
        this.centerPostVisible = centerPostVisible;
        changed();
    }

    public boolean isCenterPinVisible()
    {
        return centerPinVisible;
    }

    public void setCenterPinVisible(boolean centerPinVisible)
    {
        this.centerPinVisible = centerPinVisible;
        changed();
    }

    public Scale getFrontScale()
    {
        return frontScale;
    }

    public Scale getTailScale()
    {
        return tailScale;
    }

    public GradientPalette getSecondaryColor()
    {
        return secondaryColor;
    }

    public void setSecondaryColor(GradientPalette secondaryColor)
    {
        this.secondaryColor = secondaryColor;
        changed();
    }

    @Override
    public String toString()
    {
        return "AbstractPointer{" + "centerPostVisible=" + centerPostVisible + ", centerScale=" + centerScale + ", frontScale=" + frontScale + ", pointerColor=" + primaryColor + ", radiusPercent=" + radiusPercent + ", tailScale=" + tailScale + ", centerPinVisible=" + centerPinVisible + '}';
    }

}
