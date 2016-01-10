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
package us.jaba.titaniumblocks.core.color;

import java.awt.Color;

/**
 *
 * @author tbeckett
 */
public class GradientPalette
{

    private Color mediumColor;
    private Color mediumDarkColor;
    private Color darkColor;
    private Color darkestColor;

    private Color mediumLightColor;
    private Color lightColor;
    private Color lightestColor;

    public GradientPalette()
    {
    }

    public GradientPalette(HSLColor base)
    {
        this(new HSLColor(base.getHue(), base.getSaturation(), 10).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 23).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 37).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 50).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 67).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 72).getRGB(),
                new HSLColor(base.getHue(), base.getSaturation(), 90).getRGB());
    }

    public GradientPalette(Color rgbBase)
    {
        this(new HSLColor(rgbBase));
    }

    public GradientPalette(Color darkest, Color dark, Color mediumDark, Color medium, Color mediumLight, Color light, Color lightest)
    {
        this.mediumColor = medium;
        this.mediumDarkColor = mediumDark;
        this.darkColor = dark;
        this.darkestColor = darkest;
        this.mediumLightColor = mediumLight;
        this.lightColor = light;
        this.lightestColor = lightest;
    }

    public Color getMedium()
    {
        return mediumColor;
    }

    public void setMedium(Color medium)
    {
        this.mediumColor = medium;
    }

    public Color getMediumDark()
    {
        return mediumDarkColor;
    }

    public void setMediumDark(Color mediumDark)
    {
        this.mediumDarkColor = mediumDark;
    }

    public Color getDark()
    {
        return darkColor;
    }

    public void setDark(Color dark)
    {
        this.darkColor = dark;
    }

    public Color getDarkest()
    {
        return darkestColor;
    }

    public void setDarkest(Color very_dark)
    {
        this.darkestColor = very_dark;
    }

    public Color getMediumLight()
    {
        return mediumLightColor;
    }

    public void setMediumLight(Color light)
    {
        this.mediumLightColor = light;
    }

    public Color getLight()
    {
        return lightColor;
    }

    public void setLight(Color light)
    {
        this.lightColor = light;
    }

    public Color getLightest()
    {
        return lightestColor;
    }

    public void setLightest(Color very_light)
    {
        this.lightestColor = very_light;
    }

}
