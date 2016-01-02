/*
 * Copyright (c) 2012, Gerrit Grunwald
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
package us.jaba.titaniumblocks.core.frontcover.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.Painter;

/**
 *
 * @author hansolo
 */
public class AbstractRadialFrontcoverModel extends FrontcoverModel implements Painter
{

    private final CenterKnobPainter centerKnobPainter;
    private boolean WITH_CENTER_KNOB = false;

    protected float[] HIGHLIGHT_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    protected Color[] HIGHLIGHT_COLORS =
    {
        new Color(1.0f, 1.0f, 1.0f, 0.2f),
        new Color(1.0f, 1.0f, 1.0f, 0.05f)
    };

    public AbstractRadialFrontcoverModel()
    {
        centerKnobPainter = new CenterKnobPainter();
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        if (WITH_CENTER_KNOB)
        {

            centerKnobPainter.paint(graphics, dimensions);

        }

        final GeneralPath HIGHLIGHT = new GeneralPath();
        final Point2D HIGHLIGHT_START = new Point2D.Double();
        final Point2D HIGHLIGHT_STOP = new Point2D.Double();

        final Paint HIGHLIGHT_GRADIENT;

        apply(graphics, dimensions);
         
        graphics.dispose();

//        if (FOREGROUND_IMAGE != null) {
//            final Graphics2D G = FOREGROUND_IMAGE.createGraphics();
//            G.drawImage(radForegroundImage, 0, 0, null);
//            G.dispose();
//        }
    }

    public boolean isWITH_CENTER_KNOB()
    {
        return WITH_CENTER_KNOB;
    }

    public void setWITH_CENTER_KNOB(boolean WITH_CENTER_KNOB)
    {
        this.WITH_CENTER_KNOB = WITH_CENTER_KNOB;
        changed();
    }

    public float[] getHIGHLIGHT_FRACTIONS()
    {
        return HIGHLIGHT_FRACTIONS;
    }

    public void setHIGHLIGHT_FRACTIONS(float[] HIGHLIGHT_FRACTIONS)
    {
        this.HIGHLIGHT_FRACTIONS = HIGHLIGHT_FRACTIONS;
        changed();
    }

    public Color[] getHIGHLIGHT_COLORS()
    {
        return HIGHLIGHT_COLORS;
    }

    public void setHIGHLIGHT_COLORS(Color[] HIGHLIGHT_COLORS)
    {
        this.HIGHLIGHT_COLORS = HIGHLIGHT_COLORS;
        changed();
    }

    protected void apply(Graphics2D graphics, Dimension dimensions)
    {
         
    }

}
