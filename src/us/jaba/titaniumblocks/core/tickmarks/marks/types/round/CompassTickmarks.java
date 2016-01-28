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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.text.TextSupport;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class CompassTickmarks extends AbstractRadialTickmark
{


    public CompassTickmarks()
    {
        
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();
      // Store former transformation
        final AffineTransform FORMER_TRANSFORM = graphics.getTransform();

        final BasicStroke MEDIUM_STROKE = new BasicStroke(0.005859375f * imageWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke THIN_STROKE = new BasicStroke(0.00390625f * imageWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final java.awt.Font BIG_FONT = new java.awt.Font("Serif", java.awt.Font.PLAIN, (int) (0.12f * imageWidth));
        final java.awt.Font SMALL_FONT = new java.awt.Font("Serif", java.awt.Font.PLAIN, (int) (0.06f * imageWidth));
        final float TEXT_DISTANCE = 0.0750f * imageWidth;
        final float MIN_LENGTH = 0.015625f * imageWidth;
        final float MED_LENGTH = 0.0234375f * imageWidth;
        final float MAX_LENGTH = 0.03125f * imageWidth;

        final Color TEXT_COLOR = getTextColor();
        final Color TICK_COLOR = getMajorColor();

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

        // Draw ticks
        Point2D innerPoint;
        Point2D outerPoint;
        Point2D textPoint = null;
        java.awt.geom.Line2D tick;
        int tickCounter90 = 0;
        int tickCounter15 = 0;
        int tickCounter5 = 0;
        int counter = 0;

        double sinValue = 0;
        double cosValue = 0;

        final double STEP = (2.0d * Math.PI) / (360.0d);

        for (double alpha = 2 * Math.PI; alpha >= 0; alpha -= STEP)
        {
            graphics.setStroke(THIN_STROKE);
            sinValue = Math.sin(alpha);
            cosValue = Math.cos(alpha);

            graphics.setColor(TICK_COLOR);

            if (tickCounter5 == 5)
            {
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MIN_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MIN_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter5 = 0;
            }

            // Different tickmark every 15 units
            if (tickCounter15 == 15)
            {
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MED_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MED_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);

                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter15 = 0;
                tickCounter90 += 15;
            }

            // Different tickmark every 90 units plus text
            if (tickCounter90 == 90)
            {
                graphics.setStroke(MEDIUM_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MAX_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAX_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);

                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter90 = 0;
            }

            // Draw text
            graphics.setFont(BIG_FONT);
            graphics.setColor(TEXT_COLOR);

            textPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
            switch (counter)
            {
                case 360:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "S", (int) textPoint.getX()+5, (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 45:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "SW", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 90:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "W", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 135:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "NW", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 180:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "N", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 225:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "NE", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 270:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "E", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 315:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "SE", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
            }
            graphics.setTransform(FORMER_TRANSFORM);

            tickCounter5++;
            tickCounter15++;

            counter++;
        }

        // Restore former transformation
        graphics.setTransform(FORMER_TRANSFORM);
    }

}
