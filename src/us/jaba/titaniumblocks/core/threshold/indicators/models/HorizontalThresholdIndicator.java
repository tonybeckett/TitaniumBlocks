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
package us.jaba.titaniumblocks.core.threshold.indicators.models;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlue;
import us.jaba.titaniumblocks.core.threshold.indicators.ThresholdIndicatorModel;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class HorizontalThresholdIndicator extends ThresholdIndicatorModel
{

    private GradientPalette gradientPalette;
    private final float[] THRESHOLD_FRACTIONS =
    {
        0.0f,
        0.3f,
        0.59f,
        1.0f
    };

    private Color[] THRESHOLD_COLORS; 
   
    public HorizontalThresholdIndicator()
    {
        this.setGradientPalette(  new PureBlue());
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        int imageHeight = (int) (dimensions.getHeight() * 0.0714285714);
        int IMAGE_WIDTH = (int) (imageHeight * 0.8);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.translate(0, IMAGE_WIDTH * 0.005);
        final GeneralPath path = new GeneralPath();
        path.setWindingRule(Path2D.WIND_EVEN_ODD);
        final Point2D THRESHOLD_START;
        final Point2D THRESHOLD_STOP;

        path.moveTo(IMAGE_WIDTH * 0.5, imageHeight * 0.9);
        path.lineTo(IMAGE_WIDTH * 1.0, imageHeight * 0.1);
        path.lineTo(IMAGE_WIDTH * 0.1, imageHeight * 0.1);
        path.lineTo(IMAGE_WIDTH * 0.5, imageHeight * 0.9);
        path.closePath();
        THRESHOLD_START = new Point2D.Double(0, path.getBounds2D().getMaxY());
        THRESHOLD_STOP = new Point2D.Double(0, path.getBounds2D().getMinY());

        PointSupport.validateGradientPoints(THRESHOLD_START, THRESHOLD_STOP);
        final LinearGradientPaint THRESHOLD_GRADIENT = new LinearGradientPaint(THRESHOLD_START, THRESHOLD_STOP, THRESHOLD_FRACTIONS, THRESHOLD_COLORS);
        graphics.setPaint(THRESHOLD_GRADIENT);
        graphics.fill(path);

        graphics.setColor(ColorPalette.WHITE);
        graphics.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
        graphics.draw(path);

    }

    
//     // Parameters neede for setting the indicators to the right location
//        final double PIXEL_RANGE;
//        final double RANGE;
//        final double PIXEL_SCALE;
//
//        if (getInnerBounds().width < getInnerBounds().height) {
//            // Vertical
//            PIXEL_RANGE = getInnerBounds().height * 0.8567961165048543 - getInnerBounds().height * 0.12864077669902912;
//            RANGE = (getMaxValue() - getMinValue());
//            PIXEL_SCALE = PIXEL_RANGE / RANGE;
//        } else {
//            // Horizontal
//            PIXEL_RANGE = getInnerBounds().width * 0.8567961165048543 - getInnerBounds().width * 0.12864077669902912;
//            RANGE = (getMaxValue() - getMinValue());
//            PIXEL_SCALE = PIXEL_RANGE / RANGE;
//        }
//
//        // Draw threshold indicator
//        if (isThresholdVisible()) {
//            final double VALUE_POS;
//            final AffineTransform OLD_TRANSFORM = G2.getTransform();
//            if (getInnerBounds().width < getInnerBounds().height) {
//                // Vertical orientation
//                if (getMinValue() < 0) {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 + getMinValue() * PIXEL_SCALE - getThreshold() * PIXEL_SCALE ;
//                } else {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 - getMinValue() * PIXEL_SCALE - getThreshold() * PIXEL_SCALE ;
//                }
//                G2.translate(getInnerBounds().width * 0.4357142857142857 - thresholdImage.getWidth() - 2 + getInnerBounds().x, VALUE_POS - thresholdImage.getHeight() / 2.0 + getInnerBounds().y);
//            } else {
//                // Horizontal orientation
//                VALUE_POS = getThreshold() * PIXEL_SCALE - getMinValue() * PIXEL_SCALE;
//                G2.translate(getInnerBounds().width * 0.14285714285714285 - thresholdImage.getWidth() / 2.0 + VALUE_POS + getInnerBounds().x, getInnerBounds().height * 0.5714285714 + 2 + getInnerBounds().y);
//            }
//            G2.drawImage(thresholdImage, 0, 0, null);
//
//            G2.setTransform(OLD_TRANSFORM);
//        }
//
//    
    
//        // Draw min measured value indicator
//        if (isMinMeasuredValueVisible()) {
//            final double VALUE_POS;
//            final AffineTransform OLD_TRANSFORM = G2.getTransform();
//            if (getInnerBounds().width < getInnerBounds().height) {
//                // Vertical orientation
//                if (getMinValue() < 0) {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 + getMinValue() * PIXEL_SCALE - getMinMeasuredValue() * PIXEL_SCALE ;
//                } else {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 - getMinValue() * PIXEL_SCALE - getMinMeasuredValue() * PIXEL_SCALE ;
//                }
//                G2.translate(getInnerBounds().width * 0.37 - minMeasuredImage.getWidth() - 2 + getInnerBounds().x, VALUE_POS - minMeasuredImage.getHeight() / 2.0 + getInnerBounds().y);
//            } else {
//                // Horizontal orientation
//                VALUE_POS = getMinMeasuredValue() * PIXEL_SCALE - getMinValue() * PIXEL_SCALE;
//                G2.translate(getInnerBounds().width * 0.14285714285714285 - minMeasuredImage.getWidth() / 2.0 + VALUE_POS + getInnerBounds().x, getInnerBounds().height * 0.63 + 2 + getInnerBounds().y);
//            }
//            G2.drawImage(minMeasuredImage, 0, 0, null);
//
//            G2.setTransform(OLD_TRANSFORM);
//        }
//
//        // Draw max measured value indicator
//        if (isMaxMeasuredValueVisible()) {
//            final double VALUE_POS;
//            final AffineTransform OLD_TRANSFORM = G2.getTransform();
//            if (getInnerBounds().width < getInnerBounds().height) {
//                // Vertical orientation
//                if (getMinValue() < 0) {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 + getMinValue() * PIXEL_SCALE - getMaxMeasuredValue() * PIXEL_SCALE ;
//                } else {
//                    VALUE_POS = getInnerBounds().height * 0.8567961165048543 - getMinValue() * PIXEL_SCALE - getMaxMeasuredValue() * PIXEL_SCALE ;
//                }
//                G2.translate(getInnerBounds().width * 0.37 - maxMeasuredImage.getWidth() - 2 + getInnerBounds().x, VALUE_POS - maxMeasuredImage.getHeight() / 2.0 + getInnerBounds().y);
//            } else {
//                // Horizontal orientation
//                VALUE_POS = getMaxMeasuredValue() * PIXEL_SCALE - getMinValue() * PIXEL_SCALE;
//                G2.translate(getInnerBounds().width * 0.14285714285714285 - maxMeasuredImage.getWidth() / 2.0 + VALUE_POS + getInnerBounds().x, getInnerBounds().height * 0.63 + 2 + getInnerBounds().y);
//            }
//            G2.drawImage(maxMeasuredImage, 0, 0, null);
//
//    
    
    public void setGradientPalette(GradientPalette gradientPalette)
    {
        this.gradientPalette = gradientPalette;

        THRESHOLD_COLORS = new Color[]
        {
            gradientPalette.getDark(),
            gradientPalette.getMedium(),
            gradientPalette.getMedium(),
            gradientPalette.getDark()
        };
    }

}
