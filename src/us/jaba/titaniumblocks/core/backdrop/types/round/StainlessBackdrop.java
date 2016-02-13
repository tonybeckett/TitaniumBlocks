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
package us.jaba.titaniumblocks.core.backdrop.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRoundBackdrop;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

public class StainlessBackdrop extends AbstractRoundBackdrop
{

    private float[] STAINLESS_FRACTIONS =
    {
        0f,
        0.03f,
        0.10f,
        0.14f,
        0.24f,
        0.33f,
        0.38f,
        0.5f,
        0.62f,
        0.67f,
        0.76f,
        0.81f,
        0.85f,
        0.97f,
        1.0f
    };

// Define the colors of the conical gradient paint
    private Color[] STAINLESS_COLORS =
    {
        new Color(0xFDFDFD),
        new Color(0xFDFDFD),
        new Color(0xB2B2B4),
        new Color(0xACACAE),
        new Color(0xFDFDFD),
        new Color(0x6E6E70),
        new Color(0x6E6E70),
        new Color(0xFDFDFD),
        new Color(0x6E6E70),
        new Color(0x6E6E70),
        new Color(0xFDFDFD),
        new Color(0xACACAE),
        new Color(0xB2B2B4),
        new Color(0xFDFDFD),
        new Color(0xFDFDFD)
    };

    @Override
    protected Paint getPaint(Dimension dimensions, Ellipse2D ellipse)
    {
        final Point2D centerPoint = new Point2D.Double(ellipse.getCenterX(), ellipse.getCenterY());

        Paint p = new ConicalGradientPaint(false, centerPoint, -0.45f, STAINLESS_FRACTIONS, STAINLESS_COLORS);

        return p;
    }

}
