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
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.gradients.GradientModel;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;

/**
 *
 * @author tbeckett
 */
public class SmallKnob extends PolarKnob
{

    private GradientModel frame;
    private GradientModel innerShadow;
    private GradientModel knobStyle;

    protected SmallKnob(GradientModel frame, GradientModel innerShadow, GradientModel knobStyle)
    {
        this.frame = frame;
        this.innerShadow = innerShadow;
        this.knobStyle = knobStyle;
    }

    protected SmallKnob(GradientModel knobStyle)
    {
        this.knobStyle = knobStyle;

        frame = new GradientModel(new float[]
        {
            0.0f,
            0.46f,
            1.0f
        },
                new Color[]
                {
                    new Color(180, 180, 180, 255),
                    new Color(63, 63, 63, 255),
                    new Color(40, 40, 40, 255)
                }
        );

        innerShadow = new GradientModel(new float[]
        {
            0.0f,
            0.75f,
            0.76f,
            1.0f
        },
                new Color[]
                {
                    new Color(0, 0, 0, 0),
                    new Color(0, 0, 0, 0),
                    new Color(0, 0, 0, 1),
                    new Color(0, 0, 0, 51)
                });

    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

         final double radius = dimensions.getWidth() * 0.5;

        Point2D.Double centerPoint = new Point2D.Double((dimensions.getWidth() / 2.0), (dimensions.getHeight() / 2.0));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
       


        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.046, getAngle().getValue(), frame.getFractions(), frame.getColors());

 //       LinearGradientPainter.paint(graphics2D, 0, 0, imageWidth, imageHeight, frame.getFractions(), frame.getColors());

        ShapeUtils.placeCircleUsingLGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.036, getAngle().getValue(), knobStyle.getFractions(), knobStyle.getColors());
//       LinearGradientPainter.paint(graphics2D,
//                (imageWidth - imageWidth * 0.77) / 2.0, (imageWidth - imageWidth * 0.77) / 2.0,
//                imageWidth * 0.77, imageWidth * 0.77, knobStyle.getFractions(), knobStyle.getColors());

       ShapeUtils.placeCircleUsingRGradientOnRadius(graphics, centerPoint, radius * getRadiusAdjust().getValue(), radius * 0.026, getAngle().getValue(), innerShadow.getFractions(), innerShadow.getColors());

//        final Ellipse2D innerShadowShape = new Ellipse2D.Double((imageWidth - imageWidth * 0.77) / 2.0, (imageWidth - imageWidth * 0.77) / 2.0, imageWidth * 0.77, imageWidth * 0.77);
//        final Point2D innerShadowCenter = new Point2D.Double(innerShadowShape.getCenterX(), innerShadowShape.getCenterY());
//
//        final RadialGradientPaint gradientPaint = new RadialGradientPaint(innerShadowCenter, (float) (innerShadowShape.getWidth() / 2.0), innerShadow.getFractions(), innerShadow.getColors());
//
//        graphics.setPaint(gradientPaint);
//
//        graphics.fill(innerShadowShape);

        graphics.dispose();
    }

    public GradientModel getFrame()
    {
        return frame;
    }

    public void setFrame(GradientModel frame)
    {
        this.frame = frame;
    }

    public GradientModel getInnerShadow()
    {
        return innerShadow;
    }

    public void setInnerShadow(GradientModel innerShadow)
    {
        this.innerShadow = innerShadow;
    }

}
