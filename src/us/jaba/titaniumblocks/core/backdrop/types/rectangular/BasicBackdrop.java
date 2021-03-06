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
package us.jaba.titaniumblocks.core.backdrop.types.rectangular;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRectangularBackdrop;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class BasicBackdrop extends AbstractRectangularBackdrop
{

    private final float[] BACKGROUND_FRACTIONS =
    {
        0.0f,
        0.4f,
        1.0f
    };

    private Color[] BACKGROUND_COLORS =
    {
        backgroundColorModel.getGradientStartColor(),
        backgroundColorModel.getGradientFractionColor(),
        backgroundColorModel.getGradientStopColor()
    };

    @Override
    protected Paint getPaint(Dimension dimensions, Rectangle bounds)
    {
        final Point2D BACKGROUND_START = new Point2D.Double(0, bounds.getBounds2D().getMinY());
        final Point2D BACKGROUND_STOP = new Point2D.Double(0, bounds.getBounds2D().getMaxY());
        PointSupport.validateGradientPoints(BACKGROUND_START, BACKGROUND_STOP);
        Paint p = new LinearGradientPaint(BACKGROUND_START, BACKGROUND_STOP, BACKGROUND_FRACTIONS, BACKGROUND_COLORS);

        return p;
    }

    @Override
    public void setBackgroundColor(BackdropColorModel backgroundColorModel)
    {
        super.setBackgroundColor(backgroundColorModel);

        BACKGROUND_COLORS[0] = backgroundColorModel.getGradientStartColor();
        BACKGROUND_COLORS[1] = backgroundColorModel.getGradientFractionColor();
        BACKGROUND_COLORS[2] = backgroundColorModel.getGradientStopColor();

    }

}
