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
package us.jaba.titaniumblocks.core.frames.types.round;

import java.awt.Color;
import us.jaba.titaniumblocks.core.color.HSLColor;

/**
 *
 * @author tbeckett
 */
public class MetalRoundFrame extends BasicGradientRoundFrame
{

    private final float[] fractionArray =
    {
        0.0f,
        0.07f,
        0.12f,
        1.0f
    };

    private Color[] primaryColorArray =
    {
        new Color(254, 254, 254, 255),
        new Color(210, 210, 210, 255),
        new Color(179, 179, 179, 255),
        new Color(213, 213, 213, 255)
    };

    public MetalRoundFrame()
    {
        init(fractionArray, primaryColorArray);
        setPrimaryColor(new Color(254, 254, 254, 255));
    }

    @Override
    public void setPrimaryColor(Color primaryColor)
    {
        super.setPrimaryColor(primaryColor);

        HSLColor hsl = new HSLColor(primaryColor);
        primaryColorArray[0] = primaryColor;
        primaryColorArray[1] = hsl.adjustLuminance(80.0f);
        primaryColorArray[2] = hsl.adjustLuminance(60.0f);
        primaryColorArray[3] = hsl.adjustLuminance(90.0f);
    }

}
