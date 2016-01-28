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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class BasicClockTickmarks extends AbstractRadialTickmark
{

    public BasicClockTickmarks()
    {

    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

        // Create the watch itself
        final float RADIUS = imageWidth * 0.485f;//0.38f;
        final Point2D centerPoint = new Point2D.Double(imageWidth / 2.0f, imageWidth / 2.0f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        final Color TICKMARK_COLOR = this.getBaselineColor();//getBackgroundColor().LABEL_COLOR;
        final double SMALL_TICK_WIDTH;
        final double SMALL_TICK_HEIGHT;
        final double BIG_TICK_WIDTH;
        final double BIG_TICK_HEIGHT;
        final Rectangle2D SMALL_TICK = new Rectangle2D.Double();
        final Rectangle2D BIG_TICK = new Rectangle2D.Double();
        final AffineTransform OLD_TRANSFORM = graphics.getTransform();

//        switch (getPointerType())
//        {
//            case TYPE2:
//
//                // Draw minutes tickmarks
//                SMALL_TICK_WIDTH = imageWidth * 0.0140186916;
//                SMALL_TICK_HEIGHT = imageWidth * 0.0373831776;
//                SMALL_TICK.setFrame(CENTER.getX() - (SMALL_TICK_WIDTH / 2), imageWidth * 0.0981308411, SMALL_TICK_WIDTH, SMALL_TICK_HEIGHT);
//                graphics.setColor(TICKMARK_COLOR);
//                for (int tickAngle = 0; tickAngle < 360; tickAngle += 6)
//                {
//                    graphics.setTransform(OLD_TRANSFORM);
//                    graphics.rotate(Math.toRadians(tickAngle), CENTER.getX(), CENTER.getY());
//                    graphics.fill(SMALL_TICK);
//                }
//
//                // Draw hours tickmarks
//                BIG_TICK_WIDTH = imageWidth * 0.0327102804;
//                BIG_TICK_HEIGHT = imageWidth * 0.1261682243;
//                BIG_TICK.setFrame(CENTER.getX() - (BIG_TICK_WIDTH / 2), imageWidth * 0.0981308411, BIG_TICK_WIDTH, BIG_TICK_HEIGHT);
//                for (int tickAngle = 0; tickAngle < 360; tickAngle += 30)
//                {
//                    graphics.setTransform(OLD_TRANSFORM);
//                    graphics.rotate(Math.toRadians(tickAngle), CENTER.getX(), CENTER.getY());
//                    graphics.fill(BIG_TICK);
//                }
//                break;
//
//            case TYPE1:

//            default:
                SMALL_TICK_WIDTH = imageWidth * 0.0093457944;
                SMALL_TICK_HEIGHT = imageWidth * 0.0747663551;
                SMALL_TICK.setFrame(centerPoint.getX() - (SMALL_TICK_WIDTH / 2), imageWidth * 0.0981308411, SMALL_TICK_WIDTH, SMALL_TICK_HEIGHT);
                for (int tickAngle = 0; tickAngle < 360; tickAngle += 30)
                {
                    graphics.setTransform(OLD_TRANSFORM);
                    graphics.rotate(Math.toRadians(tickAngle), centerPoint.getX(), centerPoint.getY());
                    graphics.setColor(TICKMARK_COLOR);
                    graphics.fill(SMALL_TICK);
                    graphics.setColor(TICKMARK_COLOR.darker());
                    graphics.draw(SMALL_TICK);
                }

                BIG_TICK_WIDTH = imageWidth * 0.0280373832;
                BIG_TICK_HEIGHT = imageWidth * 0.0841121495;
                BIG_TICK.setFrame(centerPoint.getX() - (BIG_TICK_WIDTH / 2), imageWidth * 0.0981308411, BIG_TICK_WIDTH, BIG_TICK_HEIGHT);
                for (int tickAngle = 0; tickAngle < 360; tickAngle += 90)
                {
                    graphics.setTransform(OLD_TRANSFORM);
                    graphics.rotate(Math.toRadians(tickAngle), centerPoint.getX(), centerPoint.getY());
                    graphics.setColor(TICKMARK_COLOR);
                    graphics.fill(BIG_TICK);
                    graphics.setColor(TICKMARK_COLOR.darker());
                    graphics.draw(BIG_TICK);
                }
//                break;
//        }

        graphics.dispose();
    }

}
