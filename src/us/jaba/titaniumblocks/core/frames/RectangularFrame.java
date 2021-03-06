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
// */
package us.jaba.titaniumblocks.core.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import us.jaba.titaniumblocks.core.frames.effects.rectangular.NoEffect;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class RectangularFrame extends BasicFrame
{

    public static final int DEFAULT_FRAME_THICKNESS = 16;
    protected static final float[] SEVEN_FRACTION_ARRAY =
    {
        0.0F, 0.05F, 0.1F, 0.5F, 0.9F, 0.95F, 1.0F
    };

    protected static final float[] ELEVEN_FRACTION_ARRAY =
    {
        0.0F, 0.15F, 0.22F, 0.3F, 0.38F, 0.44F, 0.51F, 0.6F, 0.68F, 0.75F, 1.0F
    };

    protected static final float[] NULL_FRACTION_ARRAY =
    {
        0.0F, 0.0F
    };

    protected static final float[] FOUR_FRACTION_ARRAY =
    {
        0.0f,
        0.06f,
        0.12f,
        1.0f
    };

    protected static Color[] NULL_COLOR_ARRAY =
    {
        new Color(254, 254, 254, 255), new Color(0, 0, 0, 255)
    };

    protected static final float[] SEVENTEEN_FRACTION_ARRAY =
    {
        0.0F, 0.09F, 0.12F, 0.16F, 0.25F, 0.29F, 0.33F, 0.38F, 0.48F, 0.52F, 0.63F, 0.68F, 0.8F, 0.83F, 0.87F, 0.97F, 1.0F
    };
    private RectangularFrameEffect linearEffect = new NoEffect();

    private float[] gradientFractions;
    private Color[] gradientColors;

    public RectangularFrame(float[] fractions, Color[] colors)
    {
        gradientFractions = fractions;
        gradientColors = colors;

        interiorCalc = new FrameInteriorCalc()
        {
            @Override
            public Dimension calculate(Dimension dimensions)
            {
                return new Dimension((int) ((double) dimensions.getWidth() - (2.0 * (double) frameThickness)), (int) ((double) dimensions.getHeight() - (2.0 * (double) frameThickness)));
            }

        };
    }

    public void setFrameThickness(int frameThickness)
    {
        this.frameThickness = frameThickness;
        changed();
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        interiorDimension.setSize(dimensions.getWidth() - (2 * frameThickness), dimensions.getHeight() - (2 * frameThickness));

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final double outerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            outerAreaCornerRadius = imageHeight * 0.05;
        } else
        {
            outerAreaCornerRadius = imageWidth * 0.05;
        }

        final Area outerArea = new Area(new RoundRectangle2D.Double(0.0, 0.0, imageWidth, imageHeight, outerAreaCornerRadius, outerAreaCornerRadius));
        graphics.setPaint(outerFrameColor);
        // The outer frame will be painted later because first we have to subtract the inner background

        final double mainAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getHeight() - imageHeight - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getBounds2D().getWidth() - imageWidth - 2) / 2.0);
        }
        final Area mainArea = new Area(new RoundRectangle2D.Double(1.0, 1.0, imageWidth - 2, imageHeight - 2, mainAreaCornerRadius, mainAreaCornerRadius));

        final double innerAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            innerAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            innerAreaCornerRadius = imageWidth * 0.02857143;
        }

        final Area innerArea = new Area(new RoundRectangle2D.Double(
                mainArea.getBounds2D().getX() + frameThickness,
                mainArea.getBounds2D().getY() + frameThickness,
                mainArea.getBounds2D().getWidth() - (frameThickness * 2),
                mainArea.getBounds2D().getHeight() - (frameThickness * 2),
                innerAreaCornerRadius,
                innerAreaCornerRadius));

        final double subtractAreaCornerRadius;
        if (imageWidth >= imageHeight)
        {
            subtractAreaCornerRadius = imageHeight * 0.02857143;
        } else
        {
            subtractAreaCornerRadius = imageWidth * 0.02857143;
        }
        final Area subtractArea = new Area(new RoundRectangle2D.Double(
                mainArea.getBounds2D().getX() + frameThickness,
                mainArea.getBounds2D().getY() + frameThickness,
                mainArea.getBounds2D().getWidth() - (frameThickness * 2),
                mainArea.getBounds2D().getHeight() - (frameThickness * 2),
                subtractAreaCornerRadius, subtractAreaCornerRadius));

        paintFrame(graphics, dimensions, mainArea, outerArea, innerArea, subtractArea);
    }

    public RectangularFrameEffect getLinearEffect()
    {
        return linearEffect;
    }

    public void setLinearEffect(RectangularFrameEffect linearEffect)
    {
        this.linearEffect = linearEffect;
        changed();
    }

//    public Paint getInnerFrameColor()
//    {
//        return innerFrameColor;
//    }
//
//    public Paint getOuterFrameColor()
//    {
//        return outerFrameColor;
//    }
//
//    public void setInnerFrameColor(Paint innerFrameColor)
//    {
//        this.innerFrameColor = innerFrameColor;
//        changed();
//    }
//
//    public void setOuterFrameColor(Paint outerFrameColor)
//    {
//        this.outerFrameColor = outerFrameColor;
//        changed();
//    }
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
// intentional
    }

    protected void basicPaintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final Point2D mainStartPoint = new Point2D.Double(0, mainArea.getBounds2D().getMinY());
        final Point2D mainStopPoint = new Point2D.Double(0, mainArea.getBounds2D().getMaxY());

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        PointSupport.validateGradientPoints(mainStartPoint, mainStopPoint);
        Paint gradient = new LinearGradientPaint(mainStartPoint, mainStopPoint, gradientFractions, gradientColors);
        graphics.setPaint(gradient);

        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);

        this.getLinearEffect().paint(graphics, dimensions, outerArea);

        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

    protected void basicPaintConticalFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {
        final Point2D mainCenterPoint = new Point2D.Double(mainArea.getBounds2D().getCenterX(), mainArea.getBounds2D().getCenterY());

        // Paint outer frame after we subtracted the inner background shape
        outerArea.subtract(subtractArea);
        graphics.fill(outerArea);

        Paint gradient = new ConicalGradientPaint(false, mainCenterPoint, 0, gradientFractions, gradientColors);
        graphics.setPaint(gradient);

        mainArea.subtract(subtractArea);
        graphics.fill(mainArea);
//
        this.getLinearEffect().paint(graphics, dimensions, outerArea);

        graphics.setPaint(innerFrameColor);

        innerArea.subtract(subtractArea);
        graphics.fill(innerArea);

        graphics.dispose();

    }

    public void setGradientFractions(float[] gradientFractions)
    {
        this.gradientFractions = gradientFractions;
    }

    public void setGradientColors(Color[] gradientColors)
    {
        this.gradientColors = gradientColors;
    }

}
