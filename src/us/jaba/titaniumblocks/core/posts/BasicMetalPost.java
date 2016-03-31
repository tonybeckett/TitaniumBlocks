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
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 *
 * @author tbeckett
 */
public class BasicMetalPost extends Post
{

    private final float[] METALKNOB_FRAME_FRACTIONS =
    {
        0.0f,
        0.47f,
        1.0f
    };
    private final Color[] METALKNOB_FRAME_COLORS =
    {
        new Color(92, 95, 101, 255),
        new Color(46, 49, 53, 255),
        new Color(22, 23, 26, 255)
    };

    private final float[] METALKNOB_LOWERHL_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_LOWERHL_COLORS =
    {
        new Color(255, 255, 255, 153),
        new Color(255, 255, 255, 0)
    };

    private final float[] METALKNOB_MAIN_FRACTIONS =
    {
        0.0f,
        1.0f
    };

    private final float[] METALKNOB_UPPERHL_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_UPPERHL_COLORS =
    {
        new Color(255, 255, 255, 191),
        new Color(255, 255, 255, 0)
    };

    private final float[] METALKNOB_INNERFRAME_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_INNERFRAME_COLORS =
    {
        new Color(0, 0, 0, 255),
        new Color(204, 204, 204, 255)
    };

    private final float[] METALKNOB_INNERBACKGROUND_FRACTIONS =
    {
        0.0f,
        1.0f
    };
    private final Color[] METALKNOB_INNERBACKGROUND_COLORS =
    {
        new Color(1, 6, 11, 255),
        new Color(50, 52, 56, 255)
    };

    private final Color[] METALKNOB_MAIN_COLORS;

    public BasicMetalPost()
    {
        super();
        METALKNOB_MAIN_COLORS = new Color[]
        {
            new Color(204, 204, 204, 255),
            new Color(87, 92, 98, 255)
        };
    }

    public BasicMetalPost(Color[] METALKNOB_MAIN_COLORS)
    {
        super();
        this.METALKNOB_MAIN_COLORS = METALKNOB_MAIN_COLORS;
        super.setColor(METALKNOB_MAIN_COLORS[0]);
    }

    @Override
    public void setColor(Color color)
    {
        super.setColor(color);
        METALKNOB_MAIN_COLORS[0] = color;
        METALKNOB_MAIN_COLORS[1] = color.darker().darker();
    }
    
    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        
//        final double centerX = dimensions.getWidth() / 2.0;
//        final double centerY = dimensions.getHeight() / 2.0;
        final double maxY = dimensions.getHeight() / 2.0;
        
       paintCircle(graphics, dimensions, maxY * size.getValue() * 0.08, METALKNOB_FRAME_FRACTIONS, METALKNOB_FRAME_COLORS);
//        final Ellipse2D frame = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.08);
////        final Ellipse2D METALKNOB_FRAME = new Ellipse2D.Double(imageWidth * 0.4579439163208008, imageHeight * 0.4579439163208008, 
////                imageWidth * 0.08411216735839844, imageHeight * 0.08411216735839844);
//        final Point2D METALKNOB_FRAME_START = new Point2D.Double(0, frame.getBounds2D().getMinY());
//        final Point2D METALKNOB_FRAME_STOP = new Point2D.Double(0, frame.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(METALKNOB_FRAME_START, METALKNOB_FRAME_STOP);
//        final LinearGradientPaint METALKNOB_FRAME_GRADIENT = new LinearGradientPaint(METALKNOB_FRAME_START, METALKNOB_FRAME_STOP, METALKNOB_FRAME_FRACTIONS, METALKNOB_FRAME_COLORS);
//        graphics.setPaint(METALKNOB_FRAME_GRADIENT);
//        graphics.fill(frame);

       paintCircle(graphics, dimensions, maxY * size.getValue() * 0.07, METALKNOB_MAIN_FRACTIONS, METALKNOB_MAIN_COLORS);
//        final Ellipse2D main = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.07);
////        final Ellipse2D METALKNOB_MAIN = new Ellipse2D.Double(imageWidth * 0.46261683106422424, imageHeight * 0.46261683106422424, 
////                imageWidth * 0.0747663676738739, imageHeight * 0.0747663676738739);
//        final Point2D METALKNOB_MAIN_START = new Point2D.Double(0, main.getBounds2D().getMinY());
//        final Point2D METALKNOB_MAIN_STOP = new Point2D.Double(0, main.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(METALKNOB_MAIN_START, METALKNOB_MAIN_STOP);
//        final LinearGradientPaint METALKNOB_MAIN_GRADIENT = new LinearGradientPaint(METALKNOB_MAIN_START, METALKNOB_MAIN_STOP, METALKNOB_MAIN_FRACTIONS, METALKNOB_MAIN_COLORS);
//        graphics.setPaint(METALKNOB_MAIN_GRADIENT);
//        graphics.fill(main);

        final GeneralPath METALKNOB_LOWERHL = new GeneralPath();
        METALKNOB_LOWERHL.setWindingRule(Path2D.WIND_EVEN_ODD);
        METALKNOB_LOWERHL.moveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5280373831775701);
        METALKNOB_LOWERHL.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5186915887850467, imageWidth * 0.5093457943925234, 
                imageHeight * 0.514018691588785, imageWidth * 0.5, imageHeight * 0.514018691588785);
        METALKNOB_LOWERHL.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.514018691588785, imageWidth * 0.4766355140186916, 
                imageHeight * 0.5186915887850467, imageWidth * 0.4766355140186916, imageHeight * 0.5280373831775701);
        METALKNOB_LOWERHL.curveTo(imageWidth * 0.48130841121495327, imageHeight * 0.5327102803738317, imageWidth * 0.49065420560747663, 
                imageHeight * 0.5373831775700935, imageWidth * 0.5, imageHeight * 0.5373831775700935);
        METALKNOB_LOWERHL.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.5373831775700935, imageWidth * 0.514018691588785, 
                imageHeight * 0.5327102803738317, imageWidth * 0.5186915887850467, imageHeight * 0.5280373831775701);
        METALKNOB_LOWERHL.closePath();
        final Point2D METALKNOB_LOWERHL_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5373831775700935 * imageHeight));

        final RadialGradientPaint METALKNOB_LOWERHL_GRADIENT = new RadialGradientPaint(METALKNOB_LOWERHL_CENTER, (float) (0.03271028037383177 * imageWidth), METALKNOB_LOWERHL_FRACTIONS, METALKNOB_LOWERHL_COLORS);
        graphics.setPaint(METALKNOB_LOWERHL_GRADIENT);
        graphics.fill(METALKNOB_LOWERHL);

        final GeneralPath METALKNOB_UPPERHL = new GeneralPath();
        METALKNOB_UPPERHL.setWindingRule(Path2D.WIND_EVEN_ODD);
        METALKNOB_UPPERHL.moveTo(imageWidth * 0.5327102803738317, imageHeight * 0.48130841121495327);
        METALKNOB_UPPERHL.curveTo(imageWidth * 0.5280373831775701, imageHeight * 0.4672897196261682, imageWidth * 0.514018691588785, 
                imageHeight * 0.45794392523364486, imageWidth * 0.5, imageHeight * 0.45794392523364486);
        METALKNOB_UPPERHL.curveTo(imageWidth * 0.48130841121495327, imageHeight * 0.45794392523364486, imageWidth * 0.4672897196261682, 
                imageHeight * 0.4672897196261682, imageWidth * 0.46261682242990654, imageHeight * 0.48130841121495327);
        METALKNOB_UPPERHL.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.48598130841121495, imageWidth * 0.48130841121495327, 
                imageHeight * 0.49065420560747663, imageWidth * 0.5, imageHeight * 0.49065420560747663);
        METALKNOB_UPPERHL.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.49065420560747663, imageWidth * 0.5280373831775701, 
                imageHeight * 0.48598130841121495, imageWidth * 0.5327102803738317, imageHeight * 0.48130841121495327);
        METALKNOB_UPPERHL.closePath();
        final Point2D METALKNOB_UPPERHL_CENTER = new Point2D.Double((0.4953271028037383 * imageWidth), (0.45794392523364486 * imageHeight));

        final RadialGradientPaint METALKNOB_UPPERHL_GRADIENT = new RadialGradientPaint(METALKNOB_UPPERHL_CENTER, (float) (0.04906542056074766 * imageWidth), METALKNOB_UPPERHL_FRACTIONS, METALKNOB_UPPERHL_COLORS);
        graphics.setPaint(METALKNOB_UPPERHL_GRADIENT);
        graphics.fill(METALKNOB_UPPERHL);

       paintCircle(graphics, dimensions, maxY * size.getValue() * 0.06, METALKNOB_INNERFRAME_FRACTIONS, METALKNOB_INNERFRAME_COLORS);
//        final Ellipse2D inner = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.06);
////        final Ellipse2D METALKNOB_INNERFRAME = new Ellipse2D.Double(imageWidth * 0.47663551568984985, imageHeight * 0.4813084006309509, 
////                imageWidth * 0.04205608367919922, imageHeight * 0.04205608367919922);
//        final Point2D METALKNOB_INNERFRAME_START = new Point2D.Double(0, inner.getBounds2D().getMinY());
//        final Point2D METALKNOB_INNERFRAME_STOP = new Point2D.Double(0, inner.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(METALKNOB_INNERFRAME_START, METALKNOB_INNERFRAME_STOP);
//        final LinearGradientPaint METALKNOB_INNERFRAME_GRADIENT = new LinearGradientPaint(METALKNOB_INNERFRAME_START, METALKNOB_INNERFRAME_STOP, METALKNOB_INNERFRAME_FRACTIONS, METALKNOB_INNERFRAME_COLORS);
//        graphics.setPaint(METALKNOB_INNERFRAME_GRADIENT);
//        graphics.fill(inner);

       paintCircle(graphics, dimensions, maxY * size.getValue() * 0.05, METALKNOB_INNERBACKGROUND_FRACTIONS, METALKNOB_INNERBACKGROUND_COLORS);

//       final Ellipse2D back = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, maxY * size.getValue() * 0.05);
////        final Ellipse2D METALKNOB_INNERBACKGROUND = new Ellipse2D.Double(imageWidth * 0.4813084006309509, imageHeight * 0.4859813153743744, 
////                imageWidth * 0.03271031379699707, imageHeight * 0.03271028399467468);
//        final Point2D METALKNOB_INNERBACKGROUND_START = new Point2D.Double(0, back.getBounds2D().getMinY());
//        final Point2D METALKNOB_INNERBACKGROUND_STOP = new Point2D.Double(0, back.getBounds2D().getMaxY());
//
//        PointSupport.validateGradientPoints(METALKNOB_INNERBACKGROUND_START, METALKNOB_INNERBACKGROUND_STOP);
//        final LinearGradientPaint METALKNOB_INNERBACKGROUND_GRADIENT = new LinearGradientPaint(METALKNOB_INNERBACKGROUND_START, METALKNOB_INNERBACKGROUND_STOP, METALKNOB_INNERBACKGROUND_FRACTIONS, METALKNOB_INNERBACKGROUND_COLORS);
//        graphics.setPaint(METALKNOB_INNERBACKGROUND_GRADIENT);
//        graphics.fill(back);
//    
    }
}
