/*
 * Copyright (c) 2012, Gerrit Grunwald
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
package us.jaba.titaniumblocks.core.tickmarks.marks.models.round;

import java.awt.Dimension;
import java.awt.Graphics2D;

import us.jaba.titaniumblocks.core.tickmarks.marks.models.AbstractRadialTickmarkModel;


/**
 * @author Gerrit Grunwald <han.solo at muenster.de>
 */
public class RadialSectionsTickmarkModel extends AbstractRadialTickmarkModel
{

    

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {

//        // Definitions
//        final int WIDTH = (int) dimensions.getWidth();
//        final int HEIGHT = (int) dimensions.getHeight();
//
//        final Font STD_FONT = getSTD_FONT();
//        final Font SECTION_FONT = this.getBaseSectionFont();
//        final int TEXT_DISTANCE = (int) (this.getTEXT_DISTANCE_FACTOR() * WIDTH);
//        final double MAX_VALUE = this.getMAX_VALUE();
//        final double MIN_VALUE = this.getMIN_VALUE();
//
//        double ticklabelRotationOffset = 0;
//        final int MINOR_TICK_LENGTH = (int) (0.0133333333 * WIDTH);
//        final int MEDIUM_TICK_LENGTH = (int) (0.02 * WIDTH);
//        final int MAJOR_TICK_LENGTH = (int) (0.03 * WIDTH);
//        final int MINOR_DIAMETER = (int) (0.0093457944 * WIDTH);
//        //final int MEDIUM_DIAMETER = (int) (0.0186915888 * WIDTH);
//        final int MAJOR_DIAMETER = (int) (0.03 * WIDTH);
//
//        final Point2D textPoint = new Point2D.Double(0, 0);
//        final Point2D innerPoint = new Point2D.Double(0, 0);
//        final Point2D outerPoint = new Point2D.Double(0, 0);
//        final Point2D outerPoint_LEFT = new Point2D.Double(0, 0);
//        final Point2D outerPoint_RIGHT = new Point2D.Double(0, 0);
//        final Line2D TICK_LINE = new Line2D.Double(0, 0, 1, 1);
//        final Ellipse2D TICK_CIRCLE = new Ellipse2D.Double(0, 0, 1, 1);
//        final GeneralPath TICK_TRIANGLE = new GeneralPath();
//
//        final double ROTATION_OFFSET = getGAUGE_TYPE().ROTATION_OFFSET; // Depends on GaugeType
//        final float RADIUS = WIDTH * getRADIUS_FACTOR();
//        final double ANGLE_STEP = (getGAUGE_TYPE().ANGLE_RANGE / ((MAX_VALUE - MIN_VALUE) / getMINOR_TICK_SPACING()));
//        double sinValue;
//        double cosValue;
//        double valueCounter = MIN_VALUE;
//        int majorTickCounter = getNO_OF_MINOR_TICKS() - 1; // Indicator when to draw the major tickmark
//
//        Point2D centerPoint = getCENTER();
//        // Create the image
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//        // Set some default parameters for the graphics object
//        if (getOFFSET() != null)
//        {
//            graphics.translate(getOFFSET().getX(), getOFFSET().getY());
//        }
//        graphics.setFont(STD_FONT);
//
//        graphics.rotate(ROTATION_OFFSET - Math.PI, centerPoint.getX(), centerPoint.getY());
//
//        double alpha = 0;
//        graphics.setFont(SECTION_FONT);
//        // Min Value
//        sinValue = Math.sin(alpha);
//        cosValue = Math.cos(alpha);
//        graphics.setStroke(MAJOR_TICKMARK_STROKE);
//        innerPoint.setLocation(centerPoint.getX() + (RADIUS - MAJOR_TICK_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAJOR_TICK_LENGTH) * cosValue);
//        outerPoint.setLocation(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
//        textPoint.setLocation(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
//        this.radialTickPainter.paintTicks(graphics, TICK_LINE, alpha, innerPoint, outerPoint, centerPoint, alpha);
////        drawRadialTicks(graphics, innerPoint, outerPoint, centerPoint, RADIUS, MAJOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MAJOR_TICK_LENGTH, MAJOR_DIAMETER, outerPoint_LEFT, outerPoint_RIGHT, alpha);
//        graphics.fill(TextSupport.rotateTextAroundCenter(graphics, getNUMBER_FORMAT().format(MIN_VALUE), (int) textPoint.getX(), (int) textPoint.getY(), Math.PI - getGAUGE_TYPE().ROTATION_OFFSET));
//
//        // Max Value
//        alpha = -(MAX_VALUE - MIN_VALUE) * ANGLE_STEP;
//        sinValue = Math.sin(alpha);
//        cosValue = Math.cos(alpha);
//        graphics.setStroke(MAJOR_TICKMARK_STROKE);
//        innerPoint.setLocation(centerPoint.getX() + (RADIUS - MAJOR_TICK_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAJOR_TICK_LENGTH) * cosValue);
//        outerPoint.setLocation(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
//        textPoint.setLocation(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
//        radialTickPainter.paintTicks(graphics, TICK_LINE, alpha, innerPoint, outerPoint, centerPoint, alpha);
////        drawRadialTicks(graphics, innerPoint, outerPoint, centerPoint, RADIUS, MAJOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MAJOR_TICK_LENGTH, MAJOR_DIAMETER, outerPoint_LEFT, outerPoint_RIGHT, alpha);
//        graphics.fill(TextSupport.rotateTextAroundCenter(graphics, getNUMBER_FORMAT().format(MAX_VALUE), (int) textPoint.getX(), (int) textPoint.getY(), Math.PI - getGAUGE_TYPE().ROTATION_OFFSET));
//
//        for (SSSection section : getSections())
//        {
//            // SSSection start
//            alpha = -(section.getStart() - MIN_VALUE) * ANGLE_STEP;
//            sinValue = Math.sin(alpha);
//            cosValue = Math.cos(alpha);
//            graphics.setStroke(MAJOR_TICKMARK_STROKE);
//            innerPoint.setLocation(centerPoint.getX() + (RADIUS - MAJOR_TICK_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAJOR_TICK_LENGTH) * cosValue);
//            outerPoint.setLocation(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
//            textPoint.setLocation(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
//            
//            radialTickPainter.paintTicks(graphics, TICK_LINE, alpha, innerPoint, outerPoint, centerPoint, alpha);
//            
////            drawRadialTicks(graphics, innerPoint, outerPoint, centerPoint, RADIUS, MAJOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MAJOR_TICK_LENGTH, MAJOR_DIAMETER, outerPoint_LEFT, outerPoint_RIGHT, alpha);
//            graphics.fill(TextSupport.rotateTextAroundCenter(graphics, getNUMBER_FORMAT().format(section.getStart()), (int) textPoint.getX(), (int) textPoint.getY(), Math.PI - getGAUGE_TYPE().ROTATION_OFFSET));
//
//            // SSSection stop
//            alpha = -(section.getStop() - MIN_VALUE) * ANGLE_STEP;
//            sinValue = Math.sin(alpha);
//            cosValue = Math.cos(alpha);
//            graphics.setStroke(MAJOR_TICKMARK_STROKE);
//            innerPoint.setLocation(centerPoint.getX() + (RADIUS - MAJOR_TICK_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAJOR_TICK_LENGTH) * cosValue);
//            outerPoint.setLocation(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
//            textPoint.setLocation(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
//            
//            radialTickPainter.paintTicks(graphics, TICK_LINE, alpha, innerPoint, outerPoint, centerPoint, alpha);
//            
////            drawRadialTicks(graphics, innerPoint, outerPoint, centerPoint, RADIUS, MAJOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MAJOR_TICK_LENGTH, MAJOR_DIAMETER, outerPoint_LEFT, outerPoint_RIGHT, alpha);
//            graphics.fill(TextSupport.rotateTextAroundCenter(graphics, getNUMBER_FORMAT().format(section.getStop()), (int) textPoint.getX(), (int) textPoint.getY(), Math.PI - getGAUGE_TYPE().ROTATION_OFFSET));
//
//            graphics.dispose();
//
////        if (BACKGROUND_IMAGE != null) {
////            final Graphics2D G = BACKGROUND_IMAGE.createGraphics();
////            G.drawImage(imageBufferRad, 0, 0, null);
////            G.dispose();
////        }
//        }
    }
}
    // </editor-fold>

