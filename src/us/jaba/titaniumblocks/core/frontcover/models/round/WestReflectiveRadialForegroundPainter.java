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
package us.jaba.titaniumblocks.core.frontcover.models.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frontcover.models.AbstractRadialFrontcoverModel;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class WestReflectiveRadialForegroundPainter extends AbstractRadialFrontcoverModel
{

    @Override
    protected void apply(Graphics2D graphics, Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath HIGHLIGHT = new GeneralPath();
         
        HIGHLIGHT.setWindingRule(Path2D.WIND_EVEN_ODD);
        HIGHLIGHT.moveTo(imageWidth * 0.677570093457944, imageHeight * 0.24299065420560748);
        HIGHLIGHT.curveTo(imageWidth * 0.7710280373831776, imageHeight * 0.308411214953271, imageWidth * 0.822429906542056, imageHeight * 0.411214953271028, imageWidth * 0.8130841121495327, imageHeight * 0.5280373831775701);
        HIGHLIGHT.curveTo(imageWidth * 0.7990654205607477, imageHeight * 0.6542056074766355, imageWidth * 0.719626168224299, imageHeight * 0.7570093457943925, imageWidth * 0.5934579439252337, imageHeight * 0.7990654205607477);
        HIGHLIGHT.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.8317757009345794, imageWidth * 0.3691588785046729, imageHeight * 0.8084112149532711, imageWidth * 0.2850467289719626, imageHeight * 0.7289719626168224);
        HIGHLIGHT.curveTo(imageWidth * 0.2757009345794392, imageHeight * 0.719626168224299, imageWidth * 0.2523364485981308, imageHeight * 0.7149532710280374, imageWidth * 0.2336448598130841, imageHeight * 0.7289719626168224);
        HIGHLIGHT.curveTo(imageWidth * 0.21495327102803738, imageHeight * 0.7476635514018691, imageWidth * 0.21962616822429906, imageHeight * 0.7710280373831776, imageWidth * 0.22897196261682243, imageHeight * 0.7757009345794392);
        HIGHLIGHT.curveTo(imageWidth * 0.3317757009345794, imageHeight * 0.8785046728971962, imageWidth * 0.4766355140186916, imageHeight * 0.9158878504672897, imageWidth * 0.616822429906542, imageHeight * 0.8691588785046729);
        HIGHLIGHT.curveTo(imageWidth * 0.7710280373831776, imageHeight * 0.822429906542056, imageWidth * 0.8738317757009346, imageHeight * 0.6915887850467289, imageWidth * 0.8878504672897196, imageHeight * 0.5327102803738317);
        HIGHLIGHT.curveTo(imageWidth * 0.897196261682243, imageHeight * 0.3878504672897196, imageWidth * 0.8364485981308412, imageHeight * 0.2570093457943925, imageWidth * 0.719626168224299, imageHeight * 0.1822429906542056);
        HIGHLIGHT.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.17289719626168223, imageWidth * 0.6822429906542056, imageHeight * 0.16355140186915887, imageWidth * 0.6635514018691588, imageHeight * 0.18691588785046728);
        HIGHLIGHT.curveTo(imageWidth * 0.6542056074766355, imageHeight * 0.205607476635514, imageWidth * 0.6682242990654206, imageHeight * 0.2383177570093458, imageWidth * 0.677570093457944, imageHeight * 0.24299065420560748);
        HIGHLIGHT.closePath();
        final Point2D HIGHLIGHT_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        final float[] HIGHLIGHT_FRACTIONS_4_1 =
        {
            0.0f,
            0.82f,
            0.83f,
            1.0f
        };
        final Color[] HIGHLIGHT_COLORS_4_1 =
        {
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 25)
        };
        RadialGradientPaint HIGHLIGHT_GRADIENT = new RadialGradientPaint(HIGHLIGHT_CENTER, (float) (0.3878504672897196 * imageWidth), HIGHLIGHT_FRACTIONS_4_1, HIGHLIGHT_COLORS_4_1);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(HIGHLIGHT);

        final GeneralPath HIGHLIGHT_4 = new GeneralPath();
        HIGHLIGHT_4.setWindingRule(Path2D.WIND_EVEN_ODD);
        HIGHLIGHT_4.moveTo(imageWidth * 0.2616822429906542, imageHeight * 0.22429906542056074);
        HIGHLIGHT_4.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.2383177570093458, imageWidth * 0.2523364485981308, imageHeight * 0.2850467289719626, imageWidth * 0.24299065420560748, imageHeight * 0.3177570093457944);
        HIGHLIGHT_4.curveTo(imageWidth * 0.24299065420560748, imageHeight * 0.35046728971962615, imageWidth * 0.27102803738317754, imageHeight * 0.38317757009345793, imageWidth * 0.27102803738317754, imageHeight * 0.397196261682243);
        HIGHLIGHT_4.curveTo(imageWidth * 0.2757009345794392, imageHeight * 0.4158878504672897, imageWidth * 0.2616822429906542, imageHeight * 0.45794392523364486, imageWidth * 0.2383177570093458, imageHeight * 0.5093457943925234);
        HIGHLIGHT_4.curveTo(imageWidth * 0.22429906542056074, imageHeight * 0.5420560747663551, imageWidth * 0.17757009345794392, imageHeight * 0.6121495327102804, imageWidth * 0.1588785046728972, imageHeight * 0.6121495327102804);
        HIGHLIGHT_4.curveTo(imageWidth * 0.14485981308411214, imageHeight * 0.6121495327102804, imageWidth * 0.08878504672897196, imageHeight * 0.5467289719626168, imageWidth * 0.1308411214953271, imageHeight * 0.3691588785046729);
        HIGHLIGHT_4.curveTo(imageWidth * 0.14018691588785046, imageHeight * 0.3364485981308411, imageWidth * 0.21495327102803738, imageHeight * 0.20093457943925233, imageWidth * 0.2616822429906542, imageHeight * 0.22429906542056074);
        HIGHLIGHT_4.closePath();
        final Point2D HIGHLIGHT_4_START = new Point2D.Double((0.1308411214953271 * imageWidth), (0.3691588785046729 * imageHeight));
        final Point2D HIGHLIGHT_4_STOP = new Point2D.Double(((0.1308411214953271 + 0.1429988420131642) * imageWidth), ((0.3691588785046729 + 0.04371913341648399) * imageHeight));
        final float[] HIGHLIGHT_FRACTIONS4_2 =
        {
            0.0f,
            1.0f
        };
        final Color[] HIGHLIGHT_FRACTIONS_4_2 =
        {
            new Color(255, 255, 255, 51),
            new Color(255, 255, 255, 0)
        };
        PointSupport.validateGradientPoints(HIGHLIGHT_4_START, HIGHLIGHT_4_STOP);
        final LinearGradientPaint HIGHLIGHT_GRADIENT_4_2 = new LinearGradientPaint(HIGHLIGHT_4_START, HIGHLIGHT_4_STOP, HIGHLIGHT_FRACTIONS4_2, HIGHLIGHT_FRACTIONS_4_2);
        graphics.setPaint(HIGHLIGHT_GRADIENT_4_2);
        graphics.fill(HIGHLIGHT_4);
    }

}
