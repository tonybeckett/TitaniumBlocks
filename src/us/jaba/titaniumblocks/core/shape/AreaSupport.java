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
package us.jaba.titaniumblocks.core.shape;

import java.awt.Color;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

/**
 *
 * @author tbeckett
 */
public class AreaSupport
{

    // from SteelSeries by  Gerrit Grunwald
    /**
     * Returns a radial gradient paint that will be used as overlay for the
     * track or area image to achieve some kind of a 3d effect.
     *
     * @param width
     * @param RADIUS_FACTOR
     * @return a radial gradient paint that will be used as overlay for the
     * track or area image
     */
    protected RadialGradientPaint createArea3DEffectGradient(final int width, final float RADIUS_FACTOR)
    {
        final float[] FRACTIONS;
        final Color[] COLORS;

        FRACTIONS = new float[]
        {
            0.0f,
            0.6f,
            1.0f
        };
        COLORS = new Color[]
        {
            new Color(1.0f, 1.0f, 1.0f, 0.75f),
            new Color(1.0f, 1.0f, 1.0f, 0.0f),
            new Color(0.0f, 0.0f, 0.0f, 0.3f)
        };
        final Point2D GRADIENT_CENTER = new Point2D.Double(width / 2.0, width / 2.0);

        return new RadialGradientPaint(GRADIENT_CENTER, width * RADIUS_FACTOR, FRACTIONS, COLORS);
    }
}
