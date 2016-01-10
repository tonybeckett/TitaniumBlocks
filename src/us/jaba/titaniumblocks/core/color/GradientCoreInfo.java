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
import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;


import us.jaba.titaniumblocks.core.color.gradientdefinitions.Aluminum;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Bone;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Brass;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Bronze;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.CastIron;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Chrome;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Copper;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Gold;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Gray;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Ivory;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Lcd;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Nickel;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Pewter;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Porcelain;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlue;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureCyan;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureGreen;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureMagenta;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureOrange;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureWhite;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureYellow;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSBlack;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSBlue;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSCyan;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSGreen;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSJugGreen;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSMagenta;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSOrange;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSRaith;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSRed;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSWhite;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.SSYellow;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.Titanium;

/**
 *
 * @author tbeckett
 */
public class GradientCoreInfo
{

    public static final Class<?>[] GRADIENT_MODELS =
    {
        Aluminum.class,
        Bone.class,
        Brass.class,
        Bronze.class,
        CastIron.class,
        Chrome.class,
        Copper.class,
        Gray.class,
        Gold.class,
        Lcd.class,
        Ivory.class,
        Nickel.class,
        Pewter.class,
        Porcelain.class,
        PureBlack.class,
        PureBlue.class,
        PureCyan.class,
        PureGreen.class,
        PureMagenta.class,
        PureOrange.class,
        PureRed.class,
        PureWhite.class,
        PureYellow.class,
        SSBlack.class,
        SSBlue.class,
        SSCyan.class,
        SSGreen.class,
        SSJugGreen.class,
        SSMagenta.class,
        SSOrange.class,
        SSRaith.class,
        SSRed.class,
        SSWhite.class,
        SSYellow.class,
        Titanium.class

    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(GRADIENT_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }

    public static GradientPalette buildPaletteFromColor(Color c)
    {
        HSLColor hsl = new HSLColor(c);
        float hue = hsl.getHue();
        return new GradientPalette(new HSLColor(hue, 0, 10).getRGB(),
                new HSLColor(hue, 0, 23).getRGB(),
                new HSLColor(hue, 0, 37).getRGB(),
                new HSLColor(hue, 0, 50).getRGB(),
                new HSLColor(hue, 0, 67).getRGB(),
                new HSLColor(hue, 0, 72).getRGB(),
                new HSLColor(hue, 0, 90).getRGB()
        );

    }
}
