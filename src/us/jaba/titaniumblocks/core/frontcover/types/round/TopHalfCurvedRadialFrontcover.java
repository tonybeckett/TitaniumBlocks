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
package us.jaba.titaniumblocks.core.frontcover.types.round;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frontcover.types.AbstractRadialFrontcover;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class TopHalfCurvedRadialFrontcover extends AbstractRadialFrontcover
{

    @Override
    protected void apply(Graphics2D graphics, Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath curvePath = new GeneralPath();
        final Point2D HIGHLIGHT_START = new Point2D.Double();
        final Point2D HIGHLIGHT_STOP = new Point2D.Double();

        curvePath.setWindingRule(Path2D.WIND_EVEN_ODD);
        curvePath.moveTo(imageWidth * 0.0, imageHeight * 0.5);
        // 9 to 12 curve
         curvePath.curveTo(imageWidth * 0.0, imageHeight * 0.17102803738317754, imageWidth * 0.17102803738317754, imageHeight * 0.0, imageWidth * 0.5, imageHeight * 0.0);

         // 12 to 3 curve
        curvePath.curveTo(imageWidth * 0.70093, imageHeight * 0.0, imageWidth * 0.994485, imageHeight * 0.12429, imageWidth * 0.996542, imageHeight * 0.51121);
        
        // 3 oclock
        curvePath.curveTo(imageWidth * 0.9999, imageHeight * 0.43925, imageWidth * 0.9999, imageHeight * 0.51869, imageWidth * 0.9, imageHeight * 0.53738);

        // bottom curve
        curvePath.curveTo(imageWidth * 0.794392, imageHeight * 0.546728, imageWidth * 0.55140, imageHeight * 0.41121, imageWidth * 0.39252, imageHeight * 0.45794);
        
        // 9 oclock curve
        curvePath.curveTo(imageWidth * 0.168224, imageHeight * 0.50934, imageWidth * 0.1355, imageHeight * 0.7757, imageWidth * 0.013457, imageHeight * 0.69345);

//        HIGHLIGHT.curveTo(imageWidth * 0.088785, imageHeight * 0.56074, imageWidth * 0.0, imageHeight * 0.5327, imageWidth * 0.0, imageHeight * 0.5);
        curvePath.closePath();
        HIGHLIGHT_START.setLocation(0, curvePath.getBounds2D().getMinY());
        HIGHLIGHT_STOP.setLocation(0, curvePath.getBounds2D().getMaxY());
        PointSupport.validateGradientPoints(HIGHLIGHT_START, HIGHLIGHT_STOP);
        LinearGradientPaint HIGHLIGHT_GRADIENT = new LinearGradientPaint(HIGHLIGHT_START, HIGHLIGHT_STOP, highlightFractions, highlightColors);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(curvePath);
    }

}
