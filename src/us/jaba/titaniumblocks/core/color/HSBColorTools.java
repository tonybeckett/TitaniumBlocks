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
public class HSBColorTools
{
 
    /**
     * Returns the given COLOR with the given HUE
     *
     * @param COLOR
     * @param HUE
     * @return Color with a given hue
     */
    public static Color setHue(final Color COLOR, final float HUE)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(COLOR.getRed(), COLOR.getGreen(), COLOR.getBlue(), null);
        return Color.getHSBColor(HUE, HSB_VALUES[1], HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given SATURATION which is really useful
     * if you would like to receive a red tone that has the same brightness and
     * hue as a given blue tone.
     *
     * @param COLOR
     * @param SATURATION
     * @return Color with a given saturation
     */
    public static Color setSaturation(final Color COLOR, final float SATURATION)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(COLOR.getRed(), COLOR.getGreen(), COLOR.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], SATURATION, HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given BRIGHTNESS
     *
     * @param COLOR
     * @param BRIGHTNESS
     * @return Color with the given brightness
     */
    public static Color setBrightness(final Color COLOR, final float BRIGHTNESS)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(COLOR.getRed(), COLOR.getGreen(), COLOR.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], HSB_VALUES[1], BRIGHTNESS);
    }

    /**
     * Returns the given COLOR with the given HUE an SATURATION
     *
     * @param COLOR
     * @param HUE
     * @param SATURATION
     * @return the given COLOR with the given HUE and SATURATION
     */
    public static Color setHueSaturation(final Color COLOR, final float HUE, final float SATURATION)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(COLOR.getRed(), COLOR.getGreen(), COLOR.getBlue(), null);
        return Color.getHSBColor(HUE, SATURATION, HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given SATURATION and BRIGHTNESS
     *
     * @param COLOR
     * @param SATURATION
     * @param BRIGHTNESS
     * @return the given COLOR with the given SATURATION and BRIGHTNESS
     */
    public static Color setSaturationBrightness(final Color COLOR, final float SATURATION, final float BRIGHTNESS)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(COLOR.getRed(), COLOR.getGreen(), COLOR.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], SATURATION, BRIGHTNESS);
    }
}
