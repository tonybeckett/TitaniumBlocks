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

        final GeneralPath HIGHLIGHT = new GeneralPath();
        final Point2D HIGHLIGHT_START = new Point2D.Double();
        final Point2D HIGHLIGHT_STOP = new Point2D.Double();

        HIGHLIGHT.setWindingRule(Path2D.WIND_EVEN_ODD);
        HIGHLIGHT.moveTo(imageWidth * 0.08411214953271028, imageHeight * 0.5);
        HIGHLIGHT.curveTo(imageWidth * 0.08411214953271028, imageHeight * 0.27102803738317754, imageWidth * 0.27102803738317754, imageHeight * 0.08411214953271028, imageWidth * 0.5, imageHeight * 0.08411214953271028);
        HIGHLIGHT.curveTo(imageWidth * 0.7009345794392523, imageHeight * 0.08411214953271028, imageWidth * 0.8644859813084113, imageHeight * 0.22429906542056074, imageWidth * 0.9065420560747663, imageHeight * 0.411214953271028);
        HIGHLIGHT.curveTo(imageWidth * 0.9112149532710281, imageHeight * 0.4392523364485981, imageWidth * 0.9112149532710281, imageHeight * 0.5186915887850467, imageWidth * 0.8457943925233645, imageHeight * 0.5373831775700935);
        HIGHLIGHT.curveTo(imageWidth * 0.794392523364486, imageHeight * 0.5467289719626168, imageWidth * 0.5514018691588785, imageHeight * 0.411214953271028, imageWidth * 0.3925233644859813, imageHeight * 0.45794392523364486);
        HIGHLIGHT.curveTo(imageWidth * 0.16822429906542055, imageHeight * 0.5093457943925234, imageWidth * 0.13551401869158877, imageHeight * 0.7757009345794392, imageWidth * 0.09345794392523364, imageHeight * 0.5934579439252337);
        HIGHLIGHT.curveTo(imageWidth * 0.08878504672897196, imageHeight * 0.5607476635514018, imageWidth * 0.08411214953271028, imageHeight * 0.5327102803738317, imageWidth * 0.08411214953271028, imageHeight * 0.5);
        HIGHLIGHT.closePath();
        HIGHLIGHT_START.setLocation(0, HIGHLIGHT.getBounds2D().getMinY());
        HIGHLIGHT_STOP.setLocation(0, HIGHLIGHT.getBounds2D().getMaxY());
        PointSupport.validateGradientPoints(HIGHLIGHT_START, HIGHLIGHT_STOP);
        LinearGradientPaint HIGHLIGHT_GRADIENT = new LinearGradientPaint(HIGHLIGHT_START, HIGHLIGHT_STOP, highlightFractions, highlightColors);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(HIGHLIGHT);
    }

}
