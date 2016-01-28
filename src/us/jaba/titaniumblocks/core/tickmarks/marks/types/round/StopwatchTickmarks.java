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
import static java.awt.JobAttributes.DefaultSelectionType.RANGE;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class StopwatchTickmarks extends AbstractRadialTickmark
{

    public StopwatchTickmarks()
    {

    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

   
        
        final Point2D centerPoint = new Point2D.Double(imageWidth / 2.0f, imageWidth / 2.0f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

         
        final float RANGE = 60f;
        final double TEXT_SCALE = 0.075;
        final double TEXT_DISTANCE_FACTOR = 0.14;

        final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);
        
        final Font STD_FONT = new Font("Verdana", 0, (int) (TEXT_SCALE * imageWidth));
        final BasicStroke THIN_STROKE = new BasicStroke(0.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke MEDIUM_STROKE = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke THICK_STROKE = new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final int TEXT_DISTANCE = (int) (TEXT_DISTANCE_FACTOR * imageWidth);
        final int MIN_LENGTH = (int) (0.025 * imageWidth);
        final int MED_LENGTH = (int) (0.035 * imageWidth);
        final int MAX_LENGTH = (int) (0.045 * imageWidth);
        final Color TEXT_COLOR = this.getTextColor();
        final Color TICK_COLOR = this.getMajorColor();

        // Create the ticks itself
        final float RADIUS = imageWidth * 0.4f;

        // Draw ticks
        Point2D innerPoint;
        Point2D outerPoint;
        Point2D textPoint = null;
        Line2D tick;
        int counter = 0;
        int numberCounter = 0;
        int tickCounter = 0;

        graphics.setFont(STD_FONT);

        double sinValue = 0;
        double cosValue = 0;

        double alpha; // angle for the tickmarks
        final double ALPHA_START = -Math.PI;
        float valueCounter; // value for the tickmarks

        final double ANGLE_STEPSIZE = (2 * Math.PI) / (RANGE);

        for (alpha = ALPHA_START, valueCounter = 0; Float.compare(valueCounter, RANGE + 1) <= 0; alpha -= ANGLE_STEPSIZE * 0.1, valueCounter += 0.1f)
        {
            graphics.setStroke(THIN_STROKE);
            sinValue = Math.sin(alpha);
            cosValue = Math.cos(alpha);

            // tickmark every 2 units
            if (counter % 2 == 0)
            {
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MIN_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MIN_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
                // Draw ticks
                graphics.setColor(TICK_COLOR);
                tick = new Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);
            }

            // Different tickmark every 10 units
            if (counter == 10 || counter == 0)
            {
                graphics.setColor(TEXT_COLOR);
                graphics.setStroke(MEDIUM_STROKE);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
                textPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - TEXT_DISTANCE + STD_FONT.getSize() / 2f) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE + STD_FONT.getSize() / 2f) * cosValue + TEXT_DISTANCE / 2.5f);

                // Draw text
                if (numberCounter == 5)
                {
                    final TextLayout TEXT_LAYOUT = new TextLayout(String.valueOf(Math.round(valueCounter)), graphics.getFont(), RENDER_CONTEXT);
                    final Rectangle2D TEXT_BOUNDARY = TEXT_LAYOUT.getBounds();

                    if (Float.compare(valueCounter, RANGE) != 0)
                    {
                        if (Math.ceil(valueCounter) != 60)
                        {
                            graphics.drawString(String.valueOf(Math.round(valueCounter)), (int) (textPoint.getX() - TEXT_BOUNDARY.getWidth() / 2.0), (int) ((textPoint.getY() - TEXT_BOUNDARY.getHeight() / 2.0)));
                        }
                    }
                    graphics.setStroke(THICK_STROKE);
                    innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MAX_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAX_LENGTH) * cosValue);
                    numberCounter = 0;
                } else
                {
                    graphics.setStroke(MEDIUM_STROKE);
                    innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MED_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MED_LENGTH) * cosValue);
                }

                // Draw ticks
                graphics.setColor(TICK_COLOR);
                tick = new Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                counter = 0;
                tickCounter++;
                numberCounter++;
            }

            counter++;
        }

        graphics.dispose();

    }

}
