package us.jaba.titaniumblocks.core.glow.types;

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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.glow.AbstractRadialKnobGlow;

/**
 *
 * @author tbeckett
 */
public class RadialType5OtherGlow extends AbstractRadialKnobGlow
{

    @Override
    public void paintGlow(final Graphics2D graphics, final Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final Ellipse2D postGlowShape = new Ellipse2D.Double();
        final Point2D postGlowStartPoint = new Point2D.Double();
        final Point2D postGlowStopPoint = new Point2D.Double();

        Paint postGlowGradient;

        final Ellipse2D centerGlowShape = new Ellipse2D.Double();
//        final Point2D centerGlowPoint = new Point2D.Double();

        Paint centerGlowGradient;

        // min knob
        postGlowShape.setFrame(imageWidth * 0.1822429907, imageHeight * 0.4485981308, imageWidth * 0.0373831776, imageWidth * 0.0373831776);
        postGlowStartPoint.setLocation(postGlowShape.getMaxX(), postGlowShape.getCenterY());
        postGlowStopPoint.setLocation(postGlowShape.getMinX(), postGlowShape.getCenterY());
        postGlowGradient = new LinearGradientPaint(postGlowStartPoint, postGlowStopPoint, POST_GLOW_FRACTIONS, POST_GLOW_COLORS);
        graphics.setPaint(postGlowGradient);
        graphics.fill(postGlowShape);

        // max knob
        postGlowShape.setFrame(imageWidth * 0.7803738318, imageHeight * 0.4485981308, imageWidth * 0.0373831776, imageWidth * 0.0373831776);
        postGlowStartPoint.setLocation(postGlowShape.getMinX(), postGlowShape.getCenterY());
        postGlowStopPoint.setLocation(postGlowShape.getMaxX(), postGlowShape.getCenterY());
        postGlowGradient = new LinearGradientPaint(postGlowStartPoint, postGlowStopPoint, POST_GLOW_FRACTIONS, POST_GLOW_COLORS);
        graphics.setPaint(postGlowGradient);
        graphics.fill(postGlowShape);

        // center knob
        centerGlowShape.setFrame(imageWidth * 0.4579439252, imageWidth * 0.691588785, imageWidth * 0.0841121495, imageWidth * 0.0841121495);
                        //centerGlowPoint.setLocation(centerGlowShape.getCenterX(), centerGlowShape.getCenterY());
        //centerGlowGradient = new RadialGradientPaint(centerGlowPoint, (float)(centerGlowShape.getWidth() / 2.0), CENTER_GLOW_FRACTIONS, CENTER_GLOW_COLORS);
        centerGlowGradient = new LinearGradientPaint(new Point2D.Double(centerGlowShape.getCenterX(), centerGlowShape.getMinY()), new Point2D.Double(centerGlowShape.getCenterX(), centerGlowShape.getMaxY()), CENTER_GLOW_FRACTIONS, CENTER_GLOW_COLORS);
        graphics.setPaint(centerGlowGradient);
        graphics.fill(centerGlowShape);

    }

}
