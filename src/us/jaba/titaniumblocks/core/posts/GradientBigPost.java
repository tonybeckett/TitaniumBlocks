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
package us.jaba.titaniumblocks.core.posts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import us.jaba.titaniumblocks.core.color.GradientPalette;

/**
 *
 * @author tbeckett
 */
public class GradientBigPost extends Post
{

    private Color[] BIGCENTER_BACKGROUNDFRAME_COLORS;
    private Color[] BIGCENTER_BACKGROUND_COLORS;
    private Color[] BIGCENTER_FOREGROUNDFRAME_COLORS;
    private Color[] BIGCENTER_FOREGROUND_COLORS;

    private final float[] BIGCENTER_BACKGROUNDFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    private final float[] BIGCENTER_BACKGROUND_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    private final float[] BIGCENTER_FOREGROUNDFRAME_FRACTIONS =
    {
        0.0f,
        0.47f,
        1.0f
    };

    private final float[] BIGCENTER_FOREGROUND_FRACTIONS =
    {
        0.0f,
        0.21f,
        0.5f,
        0.78f,
        1.0f
    };

    public GradientBigPost(Color color)
    {
        setPalette( new GradientPalette(color));
    }

    public GradientBigPost(GradientPalette gd)
    {
        setPalette(gd);
    }

    public GradientBigPost(Color[] BIGCENTER_BACKGROUNDFRAME_COLORS, Color[] BIGCENTER_BACKGROUND_COLORS, Color[] BIGCENTER_FOREGROUNDFRAME_COLORS, Color[] BIGCENTER_FOREGROUND_COLORS)
    {
        this.BIGCENTER_BACKGROUNDFRAME_COLORS = BIGCENTER_BACKGROUNDFRAME_COLORS;
        this.BIGCENTER_BACKGROUND_COLORS = BIGCENTER_BACKGROUND_COLORS;
        this.BIGCENTER_FOREGROUNDFRAME_COLORS = BIGCENTER_FOREGROUNDFRAME_COLORS;
        this.BIGCENTER_FOREGROUND_COLORS = BIGCENTER_FOREGROUND_COLORS;
        super.setColor(BIGCENTER_FOREGROUND_COLORS[1]);
    }

    private void setPalette(GradientPalette gd)
    {
        this.BIGCENTER_BACKGROUNDFRAME_COLORS = new Color[]
        {
            gd.getMediumLight(),
            gd.getMediumDark(),
        };
        BIGCENTER_BACKGROUND_COLORS = new Color[]
        {
            gd.getMediumDark(),
            gd.getMediumLight(),
        };

        BIGCENTER_FOREGROUNDFRAME_COLORS = new Color[]
        {
            gd.getMediumLight(),
            gd.getMediumDark(),
            gd.getMedium(),
        };
        BIGCENTER_FOREGROUND_COLORS = new Color[]
        {
            gd.getLightest(),
            gd.getMedium(),
            gd.getMediumDark(),
            gd.getMedium(),
            gd.getLight()
        };
        
    }

    @Override
    public void setColor(Color color)
    {
        super.setColor(color);
        setPalette( new GradientPalette(color));

    }


    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final double maxY = dimensions.getHeight() / 2.0;

        paintCircle(graphics, dimensions, maxY * size.getValue() * 0.12, BIGCENTER_BACKGROUNDFRAME_FRACTIONS, BIGCENTER_BACKGROUNDFRAME_COLORS);
//        final Ellipse2D frame = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.12);
//        final Point2D BIGCENTER_BACKGROUNDFRAME_START = new Point2D.Double(0, frame.getBounds2D().getMinY());
//        final Point2D BIGCENTER_BACKGROUNDFRAME_STOP = new Point2D.Double(0, frame.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(BIGCENTER_BACKGROUNDFRAME_START, BIGCENTER_BACKGROUNDFRAME_STOP);
//        final LinearGradientPaint BIGCENTER_BACKGROUNDFRAME_GRADIENT = new LinearGradientPaint(BIGCENTER_BACKGROUNDFRAME_START, BIGCENTER_BACKGROUNDFRAME_STOP, BIGCENTER_BACKGROUNDFRAME_FRACTIONS, BIGCENTER_BACKGROUNDFRAME_COLORS);
//        graphics.setPaint(BIGCENTER_BACKGROUNDFRAME_GRADIENT);
//        graphics.fill(frame);

        paintCircle(graphics, dimensions, maxY * size.getValue() * 0.11, BIGCENTER_BACKGROUND_FRACTIONS, BIGCENTER_BACKGROUND_COLORS);
//        final Ellipse2D back = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.11);
////        final Ellipse2D BIGCENTER_BACKGROUND = new Ellipse2D.Double(imageWidth * 0.44392523169517517, imageHeight * 0.44392523169517517, 
////                imageWidth * 0.11214950680732727, imageHeight * 0.11214950680732727);
//        final Point2D BIGCENTER_BACKGROUND_START = new Point2D.Double(0, back.getBounds2D().getMinY());
//        final Point2D BIGCENTER_BACKGROUND_STOP = new Point2D.Double(0, back.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(BIGCENTER_BACKGROUND_START, BIGCENTER_BACKGROUND_STOP);
//        final LinearGradientPaint BIGCENTER_BACKGROUND_GRADIENT = new LinearGradientPaint(BIGCENTER_BACKGROUND_START, BIGCENTER_BACKGROUND_STOP, BIGCENTER_BACKGROUND_FRACTIONS, BIGCENTER_BACKGROUND_COLORS);
//        graphics.setPaint(BIGCENTER_BACKGROUND_GRADIENT);
//        graphics.fill(back);

        paintCircle(graphics, dimensions, maxY * size.getValue() * 0.09, BIGCENTER_FOREGROUNDFRAME_FRACTIONS, BIGCENTER_FOREGROUNDFRAME_COLORS);

//        final Ellipse2D foreFrame = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.09);
////        final Ellipse2D BIGCENTER_FOREGROUNDFRAME = new Ellipse2D.Double(imageWidth * 0.4532710313796997, imageHeight * 0.4532710313796997, 
////                imageWidth * 0.09345793724060059, imageHeight * 0.09345793724060059);
//        final Point2D BIGCENTER_FOREGROUNDFRAME_START = new Point2D.Double(0, foreFrame.getBounds2D().getMinY());
//        final Point2D BIGCENTER_FOREGROUNDFRAME_STOP = new Point2D.Double(0, foreFrame.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(BIGCENTER_FOREGROUNDFRAME_START, BIGCENTER_FOREGROUNDFRAME_STOP);
//        final LinearGradientPaint BIGCENTER_FOREGROUNDFRAME_GRADIENT = new LinearGradientPaint(BIGCENTER_FOREGROUNDFRAME_START, BIGCENTER_FOREGROUNDFRAME_STOP, BIGCENTER_FOREGROUNDFRAME_FRACTIONS, BIGCENTER_FOREGROUNDFRAME_COLORS);
//        graphics.setPaint(BIGCENTER_FOREGROUNDFRAME_GRADIENT);
//        graphics.fill(foreFrame);
        paintCircle(graphics, dimensions, maxY * size.getValue() * 0.08, BIGCENTER_FOREGROUND_FRACTIONS, BIGCENTER_FOREGROUND_COLORS);
//        final Ellipse2D fore = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.08);
////        final Ellipse2D BIGCENTER_FOREGROUND = new Ellipse2D.Double(imageWidth * 0.4579439163208008, imageHeight * 0.4579439163208008, 
////                imageWidth * 0.08411216735839844, imageHeight * 0.08411216735839844);
//        final Point2D BIGCENTER_FOREGROUND_START = new Point2D.Double(0, fore.getBounds2D().getMinY());
//        final Point2D BIGCENTER_FOREGROUND_STOP = new Point2D.Double(0, fore.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(BIGCENTER_FOREGROUND_START, BIGCENTER_FOREGROUND_STOP);
//        final LinearGradientPaint BIGCENTER_FOREGROUND_GRADIENT = new LinearGradientPaint(BIGCENTER_FOREGROUND_START, BIGCENTER_FOREGROUND_STOP, BIGCENTER_FOREGROUND_FRACTIONS, BIGCENTER_FOREGROUND_COLORS);
//        graphics.setPaint(BIGCENTER_FOREGROUND_GRADIENT);
//        graphics.fill(fore);

    }
}
