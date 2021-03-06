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
package us.jaba.titaniumblocks.core.frontcover.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.CoreBean;

/**
 *
 * @author tbeckett
 */
public class CenterKnobPainter extends CoreBean
{

    private final float[] E_CENTER_KNOB_FRAME_FRACTIONS =
    {
        0.0f,
        0.46f,
        1.0f
    };
    private final Color[] E_CENTER_KNOB_FRAME_COLORS =
    {
        new Color(180, 180, 180, 255),
        new Color(63, 63, 63, 255),
        new Color(40, 40, 40, 255)
    };

    private final float[] E_CENTER_KNOB_MAIN_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] E_CENTER_KNOB_MAIN_COLORS =
    {
        new Color(217, 217, 217, 255),
        new Color(191, 191, 191, 255)
    };

    private final float[] E_CENTER_KNOB_INNERSHADOW_FRACTIONS =
    {
        0.0f,
        0.75f,
        0.76f,
        1.0f
    };
    private final Color[] E_CENTER_KNOB_INNERSHADOW_COLORS =
    {
        new Color(0, 0, 0, 0),
        new Color(0, 0, 0, 0),
        new Color(0, 0, 0, 1),
        new Color(0, 0, 0, 51)
    };

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Ellipse2D E_CENTER_KNOB_FRAME = new Ellipse2D.Double(imageWidth * 0.4579439163208008, imageHeight * 0.4579439163208008, imageWidth * 0.08411216735839844, imageHeight * 0.08411216735839844);
        final Point2D E_CENTER_KNOB_FRAME_START = new Point2D.Double(0, E_CENTER_KNOB_FRAME.getBounds2D().getMinY());
        final Point2D E_CENTER_KNOB_FRAME_STOP = new Point2D.Double(0, E_CENTER_KNOB_FRAME.getBounds2D().getMaxY());

        final LinearGradientPaint E_CENTER_KNOB_FRAME_GRADIENT = new LinearGradientPaint(E_CENTER_KNOB_FRAME_START, E_CENTER_KNOB_FRAME_STOP, E_CENTER_KNOB_FRAME_FRACTIONS, E_CENTER_KNOB_FRAME_COLORS);
        graphics.setPaint(E_CENTER_KNOB_FRAME_GRADIENT);
        graphics.fill(E_CENTER_KNOB_FRAME);

        final Ellipse2D E_CENTER_KNOB_MAIN = new Ellipse2D.Double(imageWidth * 0.4672897160053253, imageHeight * 0.4672897160053253, imageWidth * 0.06542053818702698, imageHeight * 0.06542053818702698);
        final Point2D E_CENTER_KNOB_MAIN_START = new Point2D.Double(0, E_CENTER_KNOB_MAIN.getBounds2D().getMinY());
        final Point2D E_CENTER_KNOB_MAIN_STOP = new Point2D.Double(0, E_CENTER_KNOB_MAIN.getBounds2D().getMaxY());

        final LinearGradientPaint E_CENTER_KNOB_MAIN_GRADIENT = new LinearGradientPaint(E_CENTER_KNOB_MAIN_START, E_CENTER_KNOB_MAIN_STOP, E_CENTER_KNOB_MAIN_FRACTIONS, E_CENTER_KNOB_MAIN_COLORS);
        graphics.setPaint(E_CENTER_KNOB_MAIN_GRADIENT);
        graphics.fill(E_CENTER_KNOB_MAIN);

        final Ellipse2D E_CENTER_KNOB_INNERSHADOW = new Ellipse2D.Double(imageWidth * 0.4672897160053253, imageHeight * 0.4672897160053253, imageWidth * 0.06542053818702698, imageHeight * 0.06542053818702698);
        final Point2D E_CENTER_KNOB_INNERSHADOW_CENTER = new Point2D.Double((0.4953271028037383 * imageWidth), (0.49065420560747663 * imageHeight));

        final RadialGradientPaint E_CENTER_KNOB_INNERSHADOW_GRADIENT = new RadialGradientPaint(E_CENTER_KNOB_INNERSHADOW_CENTER, (float) (0.03271028037383177 * imageWidth), E_CENTER_KNOB_INNERSHADOW_FRACTIONS, E_CENTER_KNOB_INNERSHADOW_COLORS);
        graphics.setPaint(E_CENTER_KNOB_INNERSHADOW_GRADIENT);
        graphics.fill(E_CENTER_KNOB_INNERSHADOW);
    }

}
