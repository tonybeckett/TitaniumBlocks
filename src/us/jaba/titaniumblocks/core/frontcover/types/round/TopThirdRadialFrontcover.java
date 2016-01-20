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
public class TopThirdRadialFrontcover extends AbstractRadialFrontcover
{

    @Override
    protected void apply(Graphics2D graphics, Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        
        final GeneralPath HIGHLIGHT = new GeneralPath();
        final Point2D HIGHLIGHT_START = new Point2D.Double();
        final Point2D HIGHLIGHT_STOP = new Point2D.Double();
        
        HIGHLIGHT.setWindingRule(Path2D.WIND_EVEN_ODD);
        HIGHLIGHT.moveTo(imageWidth * 0.08411214953271028, imageHeight * 0.49065420560747663);
        HIGHLIGHT.curveTo(imageWidth * 0.08411214953271028, imageHeight * 0.5, imageWidth * 0.08411214953271028, imageHeight * 0.5046728971962616, imageWidth * 0.08411214953271028, imageHeight * 0.5093457943925234);
        HIGHLIGHT.curveTo(imageWidth * 0.20093457943925233, imageHeight * 0.4532710280373832, imageWidth * 0.32710280373831774, imageHeight * 0.4158878504672897, imageWidth * 0.49065420560747663, imageHeight * 0.4158878504672897);
        HIGHLIGHT.curveTo(imageWidth * 0.6588785046728972, imageHeight * 0.4158878504672897, imageWidth * 0.794392523364486, imageHeight * 0.4439252336448598, imageWidth * 0.9158878504672897, imageHeight * 0.514018691588785);
        HIGHLIGHT.curveTo(imageWidth * 0.9158878504672897, imageHeight * 0.5046728971962616, imageWidth * 0.9205607476635514, imageHeight * 0.5, imageWidth * 0.9158878504672897, imageHeight * 0.49065420560747663);
        HIGHLIGHT.curveTo(imageWidth * 0.9158878504672897, imageHeight * 0.2757009345794392, imageWidth * 0.7476635514018691, imageHeight * 0.08411214953271028, imageWidth * 0.5, imageHeight * 0.08411214953271028);
        HIGHLIGHT.curveTo(imageWidth * 0.2523364485981308, imageHeight * 0.08411214953271028, imageWidth * 0.08411214953271028, imageHeight * 0.2803738317757009, imageWidth * 0.08411214953271028, imageHeight * 0.49065420560747663);
        HIGHLIGHT.closePath();
        
        HIGHLIGHT_START.setLocation(0, HIGHLIGHT.getBounds2D().getMinY());
        HIGHLIGHT_STOP.setLocation(0, HIGHLIGHT.getBounds2D().getMaxY());
        
        PointSupport.validateGradientPoints(HIGHLIGHT_START, HIGHLIGHT_STOP);
        LinearGradientPaint HIGHLIGHT_GRADIENT = new LinearGradientPaint(HIGHLIGHT_START, HIGHLIGHT_STOP, HIGHLIGHT_FRACTIONS, HIGHLIGHT_COLORS);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(HIGHLIGHT);
    }

}
