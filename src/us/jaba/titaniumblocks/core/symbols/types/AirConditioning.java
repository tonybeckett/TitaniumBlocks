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
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.symbols.Symbol;

/**
 *
 * @author tbeckett
 */
public class AirConditioning extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

       
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.4953271028037383, imageHeight * 0.4766355140186916);
        symbol.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.4766355140186916, imageWidth * 0.5327102803738317, imageHeight * 0.49065420560747663, imageWidth * 0.5327102803738317, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.5327102803738317, imageWidth * 0.5186915887850467, imageHeight * 0.5514018691588785, imageWidth * 0.4953271028037383, imageHeight * 0.5514018691588785);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.5514018691588785, imageWidth * 0.45794392523364486, imageHeight * 0.5327102803738317, imageWidth * 0.45794392523364486, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.45794392523364486, imageHeight * 0.49065420560747663, imageWidth * 0.4766355140186916, imageHeight * 0.4766355140186916, imageWidth * 0.4953271028037383, imageHeight * 0.4766355140186916);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5233644859813084);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5233644859813084, imageWidth * 0.411214953271028, imageHeight * 0.5280373831775701, imageWidth * 0.411214953271028, imageHeight * 0.5280373831775701);
        symbol.curveTo(imageWidth * 0.38317757009345793, imageHeight * 0.5280373831775701, imageWidth * 0.37850467289719625, imageHeight * 0.5, imageWidth * 0.3317757009345794, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.3130841121495327, imageHeight * 0.5046728971962616, imageWidth * 0.29439252336448596, imageHeight * 0.514018691588785, imageWidth * 0.27102803738317754, imageHeight * 0.5420560747663551);
        symbol.curveTo(imageWidth * 0.2570093457943925, imageHeight * 0.5700934579439252, imageWidth * 0.27102803738317754, imageHeight * 0.6869158878504673, imageWidth * 0.38317757009345793, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.38317757009345793, imageHeight * 0.6869158878504673, imageWidth * 0.4532710280373832, imageHeight * 0.6915887850467289, imageWidth * 0.4766355140186916, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.6214953271028038, imageWidth * 0.48598130841121495, imageHeight * 0.602803738317757, imageWidth * 0.48598130841121495, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.5794392523364486, imageWidth * 0.49065420560747663, imageHeight * 0.5794392523364486, imageWidth * 0.4953271028037383, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.5093457943925234, imageHeight * 0.5794392523364486, imageWidth * 0.5186915887850467, imageHeight * 0.5794392523364486, imageWidth * 0.5233644859813084, imageHeight * 0.5747663551401869);
        symbol.curveTo(imageWidth * 0.5233644859813084, imageHeight * 0.5747663551401869, imageWidth * 0.5280373831775701, imageHeight * 0.5887850467289719, imageWidth * 0.5280373831775701, imageHeight * 0.5887850467289719);
        symbol.curveTo(imageWidth * 0.5280373831775701, imageHeight * 0.616822429906542, imageWidth * 0.5, imageHeight * 0.6214953271028038, imageWidth * 0.5, imageHeight * 0.6728971962616822);
        symbol.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.6915887850467289, imageWidth * 0.514018691588785, imageHeight * 0.705607476635514, imageWidth * 0.5420560747663551, imageHeight * 0.7289719626168224);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.7429906542056075, imageWidth * 0.6915887850467289, imageHeight * 0.7289719626168224, imageWidth * 0.6915887850467289, imageHeight * 0.616822429906542);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.616822429906542, imageWidth * 0.6915887850467289, imageHeight * 0.5467289719626168, imageWidth * 0.6214953271028038, imageHeight * 0.5233644859813084);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.5233644859813084, imageWidth * 0.5981308411214953, imageHeight * 0.5046728971962616, imageWidth * 0.5654205607476636, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.5654205607476636, imageHeight * 0.5, imageWidth * 0.5607476635514018, imageHeight * 0.49065420560747663, imageWidth * 0.5560747663551402, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.5654205607476636, imageHeight * 0.48130841121495327, imageWidth * 0.5794392523364486, imageHeight * 0.4766355140186916, imageWidth * 0.5934579439252337, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.4719626168224299, imageWidth * 0.6214953271028038, imageHeight * 0.5, imageWidth * 0.6728971962616822, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.4953271028037383, imageWidth * 0.7102803738317757, imageHeight * 0.48598130841121495, imageWidth * 0.7289719626168224, imageHeight * 0.45794392523364486);
        symbol.curveTo(imageWidth * 0.7429906542056075, imageHeight * 0.42990654205607476, imageWidth * 0.7289719626168224, imageHeight * 0.3130841121495327, imageWidth * 0.616822429906542, imageHeight * 0.3130841121495327);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.3130841121495327, imageWidth * 0.5514018691588785, imageHeight * 0.308411214953271, imageWidth * 0.5233644859813084, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.5233644859813084, imageHeight * 0.37850467289719625, imageWidth * 0.5046728971962616, imageHeight * 0.411214953271028, imageWidth * 0.5093457943925234, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.5046728971962616, imageHeight * 0.4485981308411215, imageWidth * 0.5, imageHeight * 0.4485981308411215, imageWidth * 0.4953271028037383, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.4953271028037383, imageHeight * 0.4485981308411215, imageWidth * 0.49065420560747663, imageHeight * 0.4485981308411215, imageWidth * 0.48598130841121495, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.4392523364485981, imageWidth * 0.4766355140186916, imageHeight * 0.4252336448598131, imageWidth * 0.4766355140186916, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.38317757009345793, imageWidth * 0.5, imageHeight * 0.37850467289719625, imageWidth * 0.5, imageHeight * 0.32710280373831774);
        symbol.curveTo(imageWidth * 0.5, imageHeight * 0.308411214953271, imageWidth * 0.48598130841121495, imageHeight * 0.29439252336448596, imageWidth * 0.45794392523364486, imageHeight * 0.27102803738317754);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.2570093457943925, imageWidth * 0.3130841121495327, imageHeight * 0.27102803738317754, imageWidth * 0.3130841121495327, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.3130841121495327, imageHeight * 0.38317757009345793, imageWidth * 0.3130841121495327, imageHeight * 0.4532710280373832, imageWidth * 0.37850467289719625, imageHeight * 0.4766355140186916);
        symbol.curveTo(imageWidth * 0.37850467289719625, imageHeight * 0.4766355140186916, imageWidth * 0.40186915887850466, imageHeight * 0.49065420560747663, imageWidth * 0.43457943925233644, imageHeight * 0.49065420560747663);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5, imageWidth * 0.42990654205607476, imageHeight * 0.5046728971962616, imageWidth * 0.42990654205607476, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.5186915887850467, imageWidth * 0.42990654205607476, imageHeight * 0.5186915887850467, imageWidth * 0.42990654205607476, imageHeight * 0.5233644859813084);
        symbol.closePath();

         
    }

}
