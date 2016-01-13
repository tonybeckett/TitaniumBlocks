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
package us.jaba.titaniumblocks.core.knobs;

import java.awt.Color;
import us.jaba.titaniumblocks.core.color.ColorPalette;

/**
 *
 * @author tbeckett
 */
public class KnobColors
{

    public static final Color[] WHITE =
    {
        ColorPalette.WHITE,
        ColorPalette.WHITE.darker().darker(),
        ColorPalette.WHITE
    };

    public static final Color[] BLACK =
    {
        ColorPalette.BLACK,
        ColorPalette.BLACK.brighter().brighter(),
        ColorPalette.BLACK
    };

    public static final Color[] SILVER =
    {
        ColorPalette.SILVER,
        ColorPalette.SILVER.darker().darker(),
        ColorPalette.SILVER
    };

    public static final Color[] NICKEL =
    {
        new Color(0xCFC9BD),
        new Color(0xC3BCB1),
        new Color(0xCFC9BD)
    };

    public static final Color[] COPPER =
    {
        ColorPalette.COPPER.darker(),
        ColorPalette.COPPER.darker().darker(),
        ColorPalette.COPPER.darker()
    };

    public static final Color[] BRASS =
    {
        new Color(0xDFD0AE),
        new Color(0x7A5E3E),
        new Color(0xCFBE9D)
    };
}
