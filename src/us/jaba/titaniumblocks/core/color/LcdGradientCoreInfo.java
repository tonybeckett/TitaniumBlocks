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

import java.util.Arrays;
import java.util.List;
import us.jaba.titaniumblocks.core.CoreInfoSupport;
import us.jaba.titaniumblocks.core.color.lcdgradients.Beige;
import us.jaba.titaniumblocks.core.color.lcdgradients.Black;
import us.jaba.titaniumblocks.core.color.lcdgradients.Blue2;
import us.jaba.titaniumblocks.core.color.lcdgradients.BlueBlack;
import us.jaba.titaniumblocks.core.color.lcdgradients.BlueDarkBlue;
import us.jaba.titaniumblocks.core.color.lcdgradients.BlueGray;
import us.jaba.titaniumblocks.core.color.lcdgradients.BlueLcdPalette;
import us.jaba.titaniumblocks.core.color.lcdgradients.BlueLightBlue;
import us.jaba.titaniumblocks.core.color.lcdgradients.Gray;
import us.jaba.titaniumblocks.core.color.lcdgradients.Green;
import us.jaba.titaniumblocks.core.color.lcdgradients.Orange;
import us.jaba.titaniumblocks.core.color.lcdgradients.Red;
import us.jaba.titaniumblocks.core.color.lcdgradients.Standard;
import us.jaba.titaniumblocks.core.color.lcdgradients.StandardGreenLcdPalette;
import us.jaba.titaniumblocks.core.color.lcdgradients.White;
import us.jaba.titaniumblocks.core.color.lcdgradients.Yellow;

/**
 *
 * @author tbeckett
 */
public class LcdGradientCoreInfo
{

    public static final Class<?>[] LCD_GRADIENT_MODELS =
    {
        Beige.class,
        Black.class,
        Blue2.class,
        BlueBlack.class,
        BlueDarkBlue.class,
        BlueGray.class,
        BlueLcdPalette.class,
        BlueLightBlue.class,
        Gray.class,
        Green.class,
        Orange.class,
        Red.class,
        Standard.class,
        StandardGreenLcdPalette.class,
        White.class,
        Yellow.class

    };

    public static List<Class<?>> getAvailableClasses()
    {
        return Arrays.asList(LCD_GRADIENT_MODELS);
    }

    public static List getInstanceOfEach()
    {
        return CoreInfoSupport.getInstanceOfEach(getAvailableClasses());

    }

}
