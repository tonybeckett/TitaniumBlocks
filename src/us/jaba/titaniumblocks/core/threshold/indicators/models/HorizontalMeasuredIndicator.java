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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.threshold.indicators.ThresholdIndicatorModel;

/**
 *
 * @author tbeckett
 */
public class HorizontalMeasuredIndicator extends ThresholdIndicatorModel
{

    private Color color;

    public HorizontalMeasuredIndicator()
    {
        color = ColorPalette.Walnut;
    }

    public HorizontalMeasuredIndicator(Color c)
    {
        color = c;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        int imageHeight = (int) (dimensions.getHeight() *.05);
        int imageWidth = imageHeight;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final GeneralPath INDICATOR = new GeneralPath();
        INDICATOR.setWindingRule(Path2D.WIND_EVEN_ODD);

        INDICATOR.moveTo(imageWidth * 0.5, 0.0);
        INDICATOR.lineTo(imageWidth, imageHeight);
        INDICATOR.lineTo(0.0, imageHeight);
        INDICATOR.closePath();

        graphics.setColor(color);
        graphics.fill(INDICATOR);

    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
// if (isMinMeasuredValueVisible()) {
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
//            G2.setTransform(OLD_TRANSFORM);
//        }
//}
