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
package us.jaba.titaniumblocks.core.symbols.painters;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.symbols.SymbolPainter;

/**
 *
 * @author tbeckett
 */
public class Airbag extends SymbolPainter
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.5467289719626168, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.5420560747663551, imageHeight * 0.5, imageWidth * 0.5420560747663551, imageHeight * 0.5046728971962616, imageWidth * 0.5420560747663551, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.5420560747663551, imageHeight * 0.5186915887850467, imageWidth * 0.5747663551401869, imageHeight * 0.5607476635514018, imageWidth * 0.5794392523364486, imageHeight * 0.5607476635514018);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.5560747663551402, imageWidth * 0.602803738317757, imageHeight * 0.5280373831775701, imageWidth * 0.6214953271028038, imageHeight * 0.49065420560747663);
        symbol.curveTo(imageWidth * 0.6261682242990654, imageHeight * 0.4719626168224299, imageWidth * 0.6308411214953271, imageHeight * 0.4392523364485981, imageWidth * 0.6074766355140186, imageHeight * 0.43457943925233644);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.43457943925233644, imageWidth * 0.5467289719626168, imageHeight * 0.49065420560747663, imageWidth * 0.5467289719626168, imageHeight * 0.4953271028037383);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.6355140186915887, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.6401869158878505, imageHeight * 0.4672897196261682, imageWidth * 0.6355140186915887, imageHeight * 0.4766355140186916, imageWidth * 0.6355140186915887, imageHeight * 0.48130841121495327);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.48598130841121495, imageWidth * 0.6308411214953271, imageHeight * 0.49065420560747663, imageWidth * 0.6308411214953271, imageHeight * 0.49065420560747663);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.5, imageWidth * 0.6542056074766355, imageHeight * 0.49065420560747663, imageWidth * 0.6542056074766355, imageHeight * 0.49065420560747663);
        symbol.curveTo(imageWidth * 0.6869158878504673, imageHeight * 0.4672897196261682, imageWidth * 0.7289719626168224, imageHeight * 0.4439252336448598, imageWidth * 0.7289719626168224, imageHeight * 0.4439252336448598);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.4439252336448598, imageWidth * 0.7383177570093458, imageHeight * 0.4205607476635514, imageWidth * 0.7242990654205608, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.719626168224299, imageHeight * 0.40186915887850466, imageWidth * 0.6962616822429907, imageHeight * 0.4158878504672897, imageWidth * 0.6869158878504673, imageHeight * 0.4205607476635514);
        symbol.curveTo(imageWidth * 0.6635514018691588, imageHeight * 0.42990654205607476, imageWidth * 0.6355140186915887, imageHeight * 0.4485981308411215, imageWidth * 0.6355140186915887, imageHeight * 0.4485981308411215);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.48598130841121495, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.5233644859813084, imageWidth * 0.4719626168224299, imageHeight * 0.5373831775700935, imageWidth * 0.48130841121495327, imageHeight * 0.5514018691588785);
        symbol.curveTo(imageWidth * 0.48130841121495327, imageHeight * 0.5514018691588785, imageWidth * 0.5046728971962616, imageHeight * 0.616822429906542, imageWidth * 0.5420560747663551, imageHeight * 0.677570093457944);
        symbol.curveTo(imageWidth * 0.5420560747663551, imageHeight * 0.677570093457944, imageWidth * 0.5700934579439252, imageHeight * 0.7102803738317757, imageWidth * 0.5981308411214953, imageHeight * 0.6962616822429907);
        symbol.curveTo(imageWidth * 0.6308411214953271, imageHeight * 0.6728971962616822, imageWidth * 0.616822429906542, imageHeight * 0.6448598130841121, imageWidth * 0.6121495327102804, imageHeight * 0.6308411214953271);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.602803738317757, imageWidth * 0.5233644859813084, imageHeight * 0.5186915887850467, imageWidth * 0.514018691588785, imageHeight * 0.514018691588785);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.514018691588785, imageWidth * 0.5, imageHeight * 0.5093457943925234, imageWidth * 0.48598130841121495, imageHeight * 0.514018691588785);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.45794392523364486, imageHeight * 0.5467289719626168);
        symbol.curveTo(imageWidth * 0.4532710280373832, imageHeight * 0.5467289719626168, imageWidth * 0.4392523364485981, imageHeight * 0.5420560747663551, imageWidth * 0.411214953271028, imageHeight * 0.5560747663551402);
        symbol.curveTo(imageWidth * 0.40186915887850466, imageHeight * 0.5607476635514018, imageWidth * 0.38317757009345793, imageHeight * 0.5841121495327103, imageWidth * 0.35514018691588783, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.3364485981308411, imageHeight * 0.6448598130841121, imageWidth * 0.3130841121495327, imageHeight * 0.6822429906542056, imageWidth * 0.3130841121495327, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.308411214953271, imageHeight * 0.7009345794392523, imageWidth * 0.3177570093457944, imageHeight * 0.7149532710280374, imageWidth * 0.3364485981308411, imageHeight * 0.7149532710280374);
        symbol.curveTo(imageWidth * 0.35046728971962615, imageHeight * 0.7149532710280374, imageWidth * 0.397196261682243, imageHeight * 0.6588785046728972, imageWidth * 0.397196261682243, imageHeight * 0.6588785046728972);
        symbol.curveTo(imageWidth * 0.397196261682243, imageHeight * 0.6588785046728972, imageWidth * 0.4158878504672897, imageHeight * 0.6261682242990654, imageWidth * 0.4485981308411215, imageHeight * 0.6074766355140186);
        symbol.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.5981308411214953, imageWidth * 0.48598130841121495, imageHeight * 0.5981308411214953, imageWidth * 0.48598130841121495, imageHeight * 0.5981308411214953);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.5981308411214953, imageWidth * 0.4766355140186916, imageHeight * 0.5654205607476636, imageWidth * 0.45794392523364486, imageHeight * 0.5467289719626168);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5654205607476636, imageHeight * 0.3598130841121495);
        symbol.curveTo(imageWidth * 0.5654205607476636, imageHeight * 0.3878504672897196, imageWidth * 0.5887850467289719, imageHeight * 0.411214953271028, imageWidth * 0.6214953271028038, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.6495327102803738, imageHeight * 0.411214953271028, imageWidth * 0.6728971962616822, imageHeight * 0.3878504672897196, imageWidth * 0.6728971962616822, imageHeight * 0.3598130841121495);
        symbol.curveTo(imageWidth * 0.6728971962616822, imageHeight * 0.32710280373831774, imageWidth * 0.6495327102803738, imageHeight * 0.3037383177570093, imageWidth * 0.6214953271028038, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.3037383177570093, imageWidth * 0.5654205607476636, imageHeight * 0.32710280373831774, imageWidth * 0.5654205607476636, imageHeight * 0.3598130841121495);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.40654205607476634);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.4766355140186916, imageWidth * 0.32242990654205606, imageHeight * 0.5327102803738317, imageWidth * 0.3925233644859813, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.5327102803738317, imageWidth * 0.5186915887850467, imageHeight * 0.4766355140186916, imageWidth * 0.5186915887850467, imageHeight * 0.40654205607476634);
        symbol.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.3364485981308411, imageWidth * 0.46261682242990654, imageHeight * 0.2803738317757009, imageWidth * 0.3925233644859813, imageHeight * 0.2803738317757009);
        symbol.curveTo(imageWidth * 0.32242990654205606, imageHeight * 0.2803738317757009, imageWidth * 0.26635514018691586, imageHeight * 0.3364485981308411, imageWidth * 0.26635514018691586, imageHeight * 0.40654205607476634);
        symbol.closePath();

        
    }

}
