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
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.text.TextSupport;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class LevelTickmarks extends AbstractRadialTickmark
{

    public LevelTickmarks()
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
        
       

        final Font STD_FONT = new Font("Verdana", 0, (int) (0.04 * imageWidth));
        final Font PERCENTAGE_FONT = new Font("Verdana", 0, (int) (0.03 * imageWidth));
        final BasicStroke MEDIUM_STROKE = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke THIN_STROKE = new BasicStroke(0.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke VERY_THIN_STROKE = new BasicStroke(0.1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final int TEXT_DISTANCE = (int) (0.08 * imageWidth);
        final int MIN_LENGTH = (int) (0.0133333333 * imageWidth);
        final int MED_LENGTH = (int) (0.02 * imageWidth);
        final int MAX_LENGTH = (int) (0.04 * imageWidth);

        // Create the ticks itself
      
        final Point2D GAUGE_CENTER = new Point2D.Double(imageWidth / 2.0f, imageHeight / 2.0f);

        // Draw ticks
        Point2D innerPoint;
        Point2D outerPoint;
        Point2D textPoint = null;
        Line2D tick;
        int counter = 0;
        int tickCounter = 0;
        float valueCounter = 90;
        boolean countUp = false;
        float valueStep = 1;

        graphics.setFont(STD_FONT);

        boolean togglePercentage = false;
        double sinValue = 0;
        double cosValue = 0;

        final double STEP = (2.0 * Math.PI) / (360.0);

        for (double alpha = (2.0 * Math.PI); alpha >= STEP; alpha -= STEP) {
            graphics.setStroke(THIN_STROKE);
            sinValue = Math.sin(alpha);
            cosValue = Math.cos(alpha);
            textPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, GAUGE_CENTER.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
            innerPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - MIN_LENGTH) * sinValue, GAUGE_CENTER.getY() + (RADIUS - MIN_LENGTH) * cosValue);
            outerPoint = new Point2D.Double(GAUGE_CENTER.getX() + RADIUS * sinValue, GAUGE_CENTER.getY() + RADIUS * cosValue);
            graphics.setColor(this.getBaselineColor());

            // Different tickmark every 5 units
            if (counter % 5 == 0) {
                graphics.setColor(this.getBaselineColor());
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - MED_LENGTH) * sinValue, GAUGE_CENTER.getY() + (RADIUS - MED_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(GAUGE_CENTER.getX() + RADIUS * sinValue, GAUGE_CENTER.getY() + RADIUS * cosValue);

                // Draw ticks
                tick = new Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);
            }

            // Different tickmark every 45 units plus text
            if (counter == 45 || counter == 0) {
                graphics.setColor(this.getBaselineColor());
                graphics.setStroke(MEDIUM_STROKE);
                innerPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - MAX_LENGTH) * sinValue, GAUGE_CENTER.getY() + (RADIUS - MAX_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(GAUGE_CENTER.getX() + RADIUS * sinValue, GAUGE_CENTER.getY() + RADIUS * cosValue);

                // Draw outer text
                textPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, GAUGE_CENTER.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
                graphics.setFont(STD_FONT);

                graphics.fill(TextSupport.rotateTextAroundCenter(graphics, String.valueOf((int) valueCounter) + "\u00B0", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));

                if (togglePercentage) {
                    textPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - TEXT_DISTANCE * 2) * sinValue, GAUGE_CENTER.getY() + (RADIUS - TEXT_DISTANCE * 2) * cosValue);
                    graphics.setFont(PERCENTAGE_FONT);

                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "100%", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                } else if (valueCounter == 0) {
                    textPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - TEXT_DISTANCE * 2) * sinValue, GAUGE_CENTER.getY() + (RADIUS - TEXT_DISTANCE * 2) * cosValue);
                    graphics.setFont(PERCENTAGE_FONT);

                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "0%", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                } else {
                    textPoint = new Point2D.Double(GAUGE_CENTER.getX() + (RADIUS - TEXT_DISTANCE * 2) * sinValue, GAUGE_CENTER.getY() + (RADIUS - TEXT_DISTANCE * 2) * cosValue);
                    graphics.setFont(PERCENTAGE_FONT);

                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "\u221E", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                }

                togglePercentage ^= true;

                counter = 0;
                tickCounter++;

                // Draw ticks
                tick = new Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);
            }

            // Draw ticks
            graphics.setStroke(VERY_THIN_STROKE);
            tick = new Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
            graphics.draw(tick);

            counter++;
            if (valueCounter == 0) {
                countUp = true;
            }
            if (valueCounter == 90) {
                countUp = false;
            }
            if (countUp) {
                valueCounter += valueStep;
            } else {
                valueCounter -= valueStep;
            }
        }

        graphics.dispose();

    }

}
