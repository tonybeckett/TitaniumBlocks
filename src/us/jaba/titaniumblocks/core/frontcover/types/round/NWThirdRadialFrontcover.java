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
public class NWThirdRadialFrontcover extends AbstractRadialFrontcover
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
        curvePath.moveTo(imageWidth * 0.0013551401869158877, imageHeight * 0.86962616822429907);

        //  center to 8 curve
        curvePath.curveTo(imageWidth * 0.21495327102803738, imageHeight * 0.5887850467289719, imageWidth * 0.3177570093457944, imageHeight * 0.5, imageWidth * 0.46261682242990654, imageHeight * 0.4252336448598131);
        
        //  2 to center curve
        curvePath.curveTo(imageWidth * 0.6121495327102804, imageHeight * 0.34579439252336447, imageWidth * 0.7336448598130841, imageHeight * 0.3177570093457944, imageWidth * 0.98738317757009346, imageHeight * 0.32242990654205606);
        
        // 11 to 2
        curvePath.curveTo(imageWidth * 0.966, imageHeight * 0.0, imageWidth * 0.6280, imageHeight * 0.0, imageWidth * 0.21, imageHeight * 0.0);

        // 8 to 11 curve
        curvePath.curveTo(imageWidth * 0.0, imageHeight * 0.2383, imageWidth * 0.00, imageHeight * 0.385, imageWidth * 0.0, imageHeight * 0.69);
        curvePath.closePath();
        
        HIGHLIGHT_START.setLocation((0.3130841121495327 * imageWidth), (0.13551401869158877 * imageHeight));
        HIGHLIGHT_STOP.setLocation(((0.3130841121495327 + 0.1824447802691637) * imageWidth), ((0.13551401869158877 + 0.3580680424308394) * imageHeight));
  
        PointSupport.validateGradientPoints(HIGHLIGHT_START, HIGHLIGHT_STOP);
        LinearGradientPaint HIGHLIGHT_GRADIENT = new LinearGradientPaint(HIGHLIGHT_START, HIGHLIGHT_STOP, highlightFractions, highlightColors);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(curvePath);
    }

}
