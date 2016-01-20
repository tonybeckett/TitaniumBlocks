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
package us.jaba.titaniumblocks.core.symbols.types;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.symbols.Symbol;

/**
 *
 * @author tbeckett
 */
public class Wiper extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

        
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5794392523364486, imageWidth * 0.29906542056074764, imageHeight * 0.43457943925233644, imageWidth * 0.29906542056074764, imageHeight * 0.43457943925233644);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.3364485981308411, imageWidth * 0.5934579439252337, imageHeight * 0.3364485981308411, imageWidth * 0.705607476635514, imageHeight * 0.43457943925233644);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.43457943925233644, imageWidth * 0.5747663551401869, imageHeight * 0.5794392523364486, imageWidth * 0.5747663551401869, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.5514018691588785, imageHeight * 0.5560747663551402, imageWidth * 0.514018691588785, imageHeight * 0.5514018691588785, imageWidth * 0.4766355140186916, imageHeight * 0.5560747663551402);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.5560747663551402, imageWidth * 0.40186915887850466, imageHeight * 0.4158878504672897, imageWidth * 0.40186915887850466, imageHeight * 0.4158878504672897);
        symbol.curveTo(imageWidth * 0.40186915887850466, imageHeight * 0.411214953271028, imageWidth * 0.3925233644859813, imageHeight * 0.40654205607476634, imageWidth * 0.3878504672897196, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.37850467289719625, imageHeight * 0.4158878504672897, imageWidth * 0.37850467289719625, imageHeight * 0.4252336448598131, imageWidth * 0.38317757009345793, imageHeight * 0.42990654205607476);
        symbol.curveTo(imageWidth * 0.38317757009345793, imageHeight * 0.42990654205607476, imageWidth * 0.4532710280373832, imageHeight * 0.5654205607476636, imageWidth * 0.4532710280373832, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5700934579439252, imageWidth * 0.43457943925233644, imageHeight * 0.5747663551401869, imageWidth * 0.42990654205607476, imageHeight * 0.5794392523364486);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.4205607476635514, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.43457943925233644, imageHeight * 0.5934579439252337, imageWidth * 0.4485981308411215, imageHeight * 0.5841121495327103, imageWidth * 0.46261682242990654, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.5794392523364486, imageWidth * 0.48130841121495327, imageHeight * 0.616822429906542, imageWidth * 0.48130841121495327, imageHeight * 0.616822429906542);
        symbol.curveTo(imageWidth * 0.4719626168224299, imageHeight * 0.6261682242990654, imageWidth * 0.4719626168224299, imageHeight * 0.6355140186915887, imageWidth * 0.4766355140186916, imageHeight * 0.6495327102803738);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.6635514018691588, imageWidth * 0.5046728971962616, imageHeight * 0.6682242990654206, imageWidth * 0.5186915887850467, imageHeight * 0.6588785046728972);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.6542056074766355, imageWidth * 0.5373831775700935, imageHeight * 0.6355140186915887, imageWidth * 0.5327102803738317, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.5233644859813084, imageHeight * 0.6121495327102804, imageWidth * 0.514018691588785, imageHeight * 0.602803738317757, imageWidth * 0.5046728971962616, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.602803738317757, imageWidth * 0.48598130841121495, imageHeight * 0.5747663551401869, imageWidth * 0.48598130841121495, imageHeight * 0.5747663551401869);
        symbol.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.5700934579439252, imageWidth * 0.5514018691588785, imageHeight * 0.5794392523364486, imageWidth * 0.5794392523364486, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.602803738317757, imageWidth * 0.7336448598130841, imageHeight * 0.42990654205607476, imageWidth * 0.7336448598130841, imageHeight * 0.42990654205607476);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.308411214953271, imageWidth * 0.40186915887850466, imageHeight * 0.3130841121495327, imageWidth * 0.26635514018691586, imageHeight * 0.42990654205607476);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.42990654205607476, imageWidth * 0.4205607476635514, imageHeight * 0.602803738317757, imageWidth * 0.4205607476635514, imageHeight * 0.602803738317757);
        symbol.closePath();

        
    }

}
