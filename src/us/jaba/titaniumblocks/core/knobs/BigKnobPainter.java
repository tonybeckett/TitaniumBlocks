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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class BigKnobPainter extends KnobPainter
{

    Color[] BIGCENTER_BACKGROUNDFRAME_COLORS;
    Color[] BIGCENTER_BACKGROUND_COLORS;
    Color[] BIGCENTER_FOREGROUNDFRAME_COLORS;
    Color[] BIGCENTER_FOREGROUND_COLORS;

    final float[] BIGCENTER_BACKGROUNDFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    
    final float[] BIGCENTER_BACKGROUND_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    final float[] BIGCENTER_FOREGROUNDFRAME_FRACTIONS =
    {
        0.0f,
        0.47f,
        1.0f
    };
    
    final float[] BIGCENTER_FOREGROUND_FRACTIONS =
    {
        0.0f,
        0.21f,
        0.5f,
        0.78f,
        1.0f
    };

    public BigKnobPainter()
    {
    }

    protected BigKnobPainter(Color[] backgroundFrameColors, Color[] backgroundColors, Color[] foregroundFrameColors, Color[] foregroundColors)
    {
        this.BIGCENTER_BACKGROUNDFRAME_COLORS = backgroundFrameColors;
        this.BIGCENTER_BACKGROUND_COLORS = backgroundColors;
        this.BIGCENTER_FOREGROUNDFRAME_COLORS = foregroundFrameColors;
        this.BIGCENTER_FOREGROUND_COLORS = foregroundColors;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final Ellipse2D BIGCENTER_BACKGROUNDFRAME = new Ellipse2D.Double(imageWidth * 0.4392523467540741, imageHeight * 0.4392523467540741, imageWidth * 0.1214953362941742, imageHeight * 0.1214953362941742);
        final Point2D BIGCENTER_BACKGROUNDFRAME_START = new Point2D.Double(0, BIGCENTER_BACKGROUNDFRAME.getBounds2D().getMinY());
        final Point2D BIGCENTER_BACKGROUNDFRAME_STOP = new Point2D.Double(0, BIGCENTER_BACKGROUNDFRAME.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(BIGCENTER_BACKGROUNDFRAME_START, BIGCENTER_BACKGROUNDFRAME_STOP);
        final LinearGradientPaint BIGCENTER_BACKGROUNDFRAME_GRADIENT = new LinearGradientPaint(BIGCENTER_BACKGROUNDFRAME_START, BIGCENTER_BACKGROUNDFRAME_STOP, BIGCENTER_BACKGROUNDFRAME_FRACTIONS, BIGCENTER_BACKGROUNDFRAME_COLORS);
        graphics.setPaint(BIGCENTER_BACKGROUNDFRAME_GRADIENT);
        graphics.fill(BIGCENTER_BACKGROUNDFRAME);

        final Ellipse2D BIGCENTER_BACKGROUND = new Ellipse2D.Double(imageWidth * 0.44392523169517517, imageHeight * 0.44392523169517517, imageWidth * 0.11214950680732727, imageHeight * 0.11214950680732727);
        final Point2D BIGCENTER_BACKGROUND_START = new Point2D.Double(0, BIGCENTER_BACKGROUND.getBounds2D().getMinY());
        final Point2D BIGCENTER_BACKGROUND_STOP = new Point2D.Double(0, BIGCENTER_BACKGROUND.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(BIGCENTER_BACKGROUND_START, BIGCENTER_BACKGROUND_STOP);
        final LinearGradientPaint BIGCENTER_BACKGROUND_GRADIENT = new LinearGradientPaint(BIGCENTER_BACKGROUND_START, BIGCENTER_BACKGROUND_STOP, BIGCENTER_BACKGROUND_FRACTIONS, BIGCENTER_BACKGROUND_COLORS);
        graphics.setPaint(BIGCENTER_BACKGROUND_GRADIENT);
        graphics.fill(BIGCENTER_BACKGROUND);

        final Ellipse2D BIGCENTER_FOREGROUNDFRAME = new Ellipse2D.Double(imageWidth * 0.4532710313796997, imageHeight * 0.4532710313796997, imageWidth * 0.09345793724060059, imageHeight * 0.09345793724060059);
        final Point2D BIGCENTER_FOREGROUNDFRAME_START = new Point2D.Double(0, BIGCENTER_FOREGROUNDFRAME.getBounds2D().getMinY());
        final Point2D BIGCENTER_FOREGROUNDFRAME_STOP = new Point2D.Double(0, BIGCENTER_FOREGROUNDFRAME.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(BIGCENTER_FOREGROUNDFRAME_START, BIGCENTER_FOREGROUNDFRAME_STOP);
        final LinearGradientPaint BIGCENTER_FOREGROUNDFRAME_GRADIENT = new LinearGradientPaint(BIGCENTER_FOREGROUNDFRAME_START, BIGCENTER_FOREGROUNDFRAME_STOP, BIGCENTER_FOREGROUNDFRAME_FRACTIONS, BIGCENTER_FOREGROUNDFRAME_COLORS);
        graphics.setPaint(BIGCENTER_FOREGROUNDFRAME_GRADIENT);
        graphics.fill(BIGCENTER_FOREGROUNDFRAME);

        final Ellipse2D BIGCENTER_FOREGROUND = new Ellipse2D.Double(imageWidth * 0.4579439163208008, imageHeight * 0.4579439163208008, imageWidth * 0.08411216735839844, imageHeight * 0.08411216735839844);
        final Point2D BIGCENTER_FOREGROUND_START = new Point2D.Double(0, BIGCENTER_FOREGROUND.getBounds2D().getMinY());
        final Point2D BIGCENTER_FOREGROUND_STOP = new Point2D.Double(0, BIGCENTER_FOREGROUND.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(BIGCENTER_FOREGROUND_START, BIGCENTER_FOREGROUND_STOP);
        final LinearGradientPaint BIGCENTER_FOREGROUND_GRADIENT = new LinearGradientPaint(BIGCENTER_FOREGROUND_START, BIGCENTER_FOREGROUND_STOP, BIGCENTER_FOREGROUND_FRACTIONS, BIGCENTER_FOREGROUND_COLORS);
        graphics.setPaint(BIGCENTER_FOREGROUND_GRADIENT);
        graphics.fill(BIGCENTER_FOREGROUND);
    }

    public Color[] getBIGCENTER_BACKGROUNDFRAME_COLORS()
    {
        return BIGCENTER_BACKGROUNDFRAME_COLORS;
    }

    public Color[] getBIGCENTER_BACKGROUND_COLORS()
    {
        return BIGCENTER_BACKGROUND_COLORS;
    }

    public Color[] getBIGCENTER_FOREGROUNDFRAME_COLORS()
    {
        return BIGCENTER_FOREGROUNDFRAME_COLORS;
    }

    public Color[] getBIGCENTER_FOREGROUND_COLORS()
    {
        return BIGCENTER_FOREGROUND_COLORS;
    }

    public void setBIGCENTER_BACKGROUNDFRAME_COLORS(Color[] BIGCENTER_BACKGROUNDFRAME_COLORS)
    {
        this.BIGCENTER_BACKGROUNDFRAME_COLORS = BIGCENTER_BACKGROUNDFRAME_COLORS;
        changed();
    }

    public void setBIGCENTER_BACKGROUND_COLORS(Color[] BIGCENTER_BACKGROUND_COLORS)
    {
        this.BIGCENTER_BACKGROUND_COLORS = BIGCENTER_BACKGROUND_COLORS;
        changed();
    }

    public void setBIGCENTER_FOREGROUNDFRAME_COLORS(Color[] BIGCENTER_FOREGROUNDFRAME_COLORS)
    {
        this.BIGCENTER_FOREGROUNDFRAME_COLORS = BIGCENTER_FOREGROUNDFRAME_COLORS;
        changed();
    }

    public void setBIGCENTER_FOREGROUND_COLORS(Color[] BIGCENTER_FOREGROUND_COLORS)
    {
        this.BIGCENTER_FOREGROUND_COLORS = BIGCENTER_FOREGROUND_COLORS;
        changed();
    }

}
