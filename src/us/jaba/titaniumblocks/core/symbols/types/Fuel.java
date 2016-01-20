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
public class Fuel extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
       
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();
        
         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.37383177570093457, imageHeight * 0.32242990654205606);
        symbol.curveTo(imageWidth * 0.37383177570093457, imageHeight * 0.3130841121495327, imageWidth * 0.37850467289719625, imageHeight * 0.3037383177570093, imageWidth * 0.3925233644859813, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.3925233644859813, imageHeight * 0.3037383177570093, imageWidth * 0.5327102803738317, imageHeight * 0.3037383177570093, imageWidth * 0.5327102803738317, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.5467289719626168, imageHeight * 0.3037383177570093, imageWidth * 0.5514018691588785, imageHeight * 0.3130841121495327, imageWidth * 0.5514018691588785, imageHeight * 0.32242990654205606);
        symbol.curveTo(imageWidth * 0.5514018691588785, imageHeight * 0.32242990654205606, imageWidth * 0.5514018691588785, imageHeight * 0.4392523364485981, imageWidth * 0.5514018691588785, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.5514018691588785, imageHeight * 0.4532710280373832, imageWidth * 0.5467289719626168, imageHeight * 0.46261682242990654, imageWidth * 0.5327102803738317, imageHeight * 0.46261682242990654);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.46261682242990654, imageWidth * 0.3925233644859813, imageHeight * 0.46261682242990654, imageWidth * 0.3925233644859813, imageHeight * 0.46261682242990654);
        symbol.curveTo(imageWidth * 0.37850467289719625, imageHeight * 0.46261682242990654, imageWidth * 0.37383177570093457, imageHeight * 0.4532710280373832, imageWidth * 0.37383177570093457, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.37383177570093457, imageHeight * 0.4392523364485981, imageWidth * 0.37383177570093457, imageHeight * 0.32242990654205606, imageWidth * 0.37383177570093457, imageHeight * 0.32242990654205606);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.3364485981308411, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.3364485981308411, imageHeight * 0.3037383177570093, imageWidth * 0.3364485981308411, imageHeight * 0.6869158878504673, imageWidth * 0.3364485981308411, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.3364485981308411, imageHeight * 0.6869158878504673, imageWidth * 0.32710280373831774, imageHeight * 0.6869158878504673, imageWidth * 0.32710280373831774, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.3130841121495327, imageHeight * 0.6869158878504673, imageWidth * 0.3037383177570093, imageHeight * 0.7009345794392523, imageWidth * 0.3037383177570093, imageHeight * 0.7102803738317757);
        symbol.curveTo(imageWidth * 0.3037383177570093, imageHeight * 0.7102803738317757, imageWidth * 0.3037383177570093, imageHeight * 0.7383177570093458, imageWidth * 0.3037383177570093, imageHeight * 0.7383177570093458);
        symbol.lineTo(imageWidth * 0.3364485981308411, imageHeight * 0.7383177570093458);
        symbol.lineTo(imageWidth * 0.5887850467289719, imageHeight * 0.7383177570093458);
        symbol.lineTo(imageWidth * 0.6214953271028038, imageHeight * 0.7383177570093458);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.7383177570093458, imageWidth * 0.6214953271028038, imageHeight * 0.7102803738317757, imageWidth * 0.6214953271028038, imageHeight * 0.7102803738317757);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.7009345794392523, imageWidth * 0.6121495327102804, imageHeight * 0.6869158878504673, imageWidth * 0.5981308411214953, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.6869158878504673, imageWidth * 0.5887850467289719, imageHeight * 0.6869158878504673, imageWidth * 0.5887850467289719, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.6869158878504673, imageWidth * 0.5887850467289719, imageHeight * 0.5420560747663551, imageWidth * 0.5887850467289719, imageHeight * 0.5420560747663551);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.5467289719626168, imageWidth * 0.602803738317757, imageHeight * 0.5467289719626168, imageWidth * 0.6121495327102804, imageHeight * 0.5514018691588785);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.5560747663551402, imageWidth * 0.6308411214953271, imageHeight * 0.5654205607476636, imageWidth * 0.6355140186915887, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6261682242990654, imageWidth * 0.6308411214953271, imageHeight * 0.6588785046728972, imageWidth * 0.6401869158878505, imageHeight * 0.6822429906542056);
        symbol.curveTo(imageWidth * 0.6495327102803738, imageHeight * 0.6962616822429907, imageWidth * 0.6728971962616822, imageHeight * 0.7102803738317757, imageWidth * 0.6915887850467289, imageHeight * 0.7102803738317757);
        symbol.curveTo(imageWidth * 0.7242990654205608, imageHeight * 0.7102803738317757, imageWidth * 0.7383177570093458, imageHeight * 0.6915887850467289, imageWidth * 0.7476635514018691, imageHeight * 0.6822429906542056);
        symbol.curveTo(imageWidth * 0.7523364485981309, imageHeight * 0.6635514018691588, imageWidth * 0.7523364485981309, imageHeight * 0.6495327102803738, imageWidth * 0.7523364485981309, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.7476635514018691, imageHeight * 0.6214953271028038, imageWidth * 0.7429906542056075, imageHeight * 0.5981308411214953, imageWidth * 0.7336448598130841, imageHeight * 0.5747663551401869);
        symbol.curveTo(imageWidth * 0.7289719626168224, imageHeight * 0.5607476635514018, imageWidth * 0.719626168224299, imageHeight * 0.5327102803738317, imageWidth * 0.7149532710280374, imageHeight * 0.5233644859813084);
        symbol.curveTo(imageWidth * 0.7102803738317757, imageHeight * 0.514018691588785, imageWidth * 0.705607476635514, imageHeight * 0.4953271028037383, imageWidth * 0.705607476635514, imageHeight * 0.48130841121495327);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.4532710280373832, imageWidth * 0.7149532710280374, imageHeight * 0.4205607476635514, imageWidth * 0.7149532710280374, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.7289719626168224, imageHeight * 0.3878504672897196);
        symbol.curveTo(imageWidth * 0.7289719626168224, imageHeight * 0.3878504672897196, imageWidth * 0.7429906542056075, imageHeight * 0.3878504672897196, imageWidth * 0.7476635514018691, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.7570093457943925, imageHeight * 0.3691588785046729, imageWidth * 0.7523364485981309, imageHeight * 0.3598130841121495, imageWidth * 0.7523364485981309, imageHeight * 0.35046728971962615);
        symbol.curveTo(imageWidth * 0.7476635514018691, imageHeight * 0.3364485981308411, imageWidth * 0.7242990654205608, imageHeight * 0.308411214953271, imageWidth * 0.7149532710280374, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.6962616822429907, imageHeight * 0.2850467289719626, imageWidth * 0.6448598130841121, imageHeight * 0.27102803738317754, imageWidth * 0.6448598130841121, imageHeight * 0.27102803738317754);
        symbol.lineTo(imageWidth * 0.6401869158878505, imageHeight * 0.2897196261682243);
        symbol.curveTo(imageWidth * 0.6401869158878505, imageHeight * 0.2897196261682243, imageWidth * 0.6542056074766355, imageHeight * 0.29439252336448596, imageWidth * 0.6682242990654206, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.3177570093457944, imageWidth * 0.705607476635514, imageHeight * 0.3364485981308411, imageWidth * 0.705607476635514, imageHeight * 0.3411214953271028);
        symbol.curveTo(imageWidth * 0.7102803738317757, imageHeight * 0.35046728971962615, imageWidth * 0.7102803738317757, imageHeight * 0.3598130841121495, imageWidth * 0.705607476635514, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.7009345794392523, imageHeight * 0.38317757009345793, imageWidth * 0.6915887850467289, imageHeight * 0.40186915887850466, imageWidth * 0.6915887850467289, imageHeight * 0.40186915887850466);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.40186915887850466, imageWidth * 0.6822429906542056, imageHeight * 0.4252336448598131, imageWidth * 0.6822429906542056, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.6822429906542056, imageHeight * 0.48598130841121495, imageWidth * 0.6822429906542056, imageHeight * 0.514018691588785, imageWidth * 0.705607476635514, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.7149532710280374, imageHeight * 0.5887850467289719, imageWidth * 0.719626168224299, imageHeight * 0.602803738317757, imageWidth * 0.7289719626168224, imageHeight * 0.6542056074766355);
        symbol.curveTo(imageWidth * 0.7289719626168224, imageHeight * 0.6635514018691588, imageWidth * 0.7289719626168224, imageHeight * 0.6869158878504673, imageWidth * 0.6915887850467289, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.6682242990654206, imageHeight * 0.6869158878504673, imageWidth * 0.6635514018691588, imageHeight * 0.6495327102803738, imageWidth * 0.6635514018691588, imageHeight * 0.6495327102803738);
        symbol.curveTo(imageWidth * 0.6635514018691588, imageHeight * 0.6495327102803738, imageWidth * 0.6542056074766355, imageHeight * 0.6308411214953271, imageWidth * 0.6588785046728972, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.6542056074766355, imageHeight * 0.5747663551401869, imageWidth * 0.6495327102803738, imageHeight * 0.5607476635514018, imageWidth * 0.6355140186915887, imageHeight * 0.5420560747663551);
        symbol.curveTo(imageWidth * 0.6308411214953271, imageHeight * 0.5327102803738317, imageWidth * 0.6121495327102804, imageHeight * 0.5233644859813084, imageWidth * 0.5981308411214953, imageHeight * 0.5186915887850467);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.5186915887850467, imageWidth * 0.5887850467289719, imageHeight * 0.5186915887850467, imageWidth * 0.5887850467289719, imageHeight * 0.5186915887850467);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.5186915887850467, imageWidth * 0.5887850467289719, imageHeight * 0.3037383177570093, imageWidth * 0.5887850467289719, imageHeight * 0.3037383177570093);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.2850467289719626, imageWidth * 0.5700934579439252, imageHeight * 0.27102803738317754, imageWidth * 0.5514018691588785, imageHeight * 0.27102803738317754);
        symbol.curveTo(imageWidth * 0.5514018691588785, imageHeight * 0.27102803738317754, imageWidth * 0.37383177570093457, imageHeight * 0.27102803738317754, imageWidth * 0.37383177570093457, imageHeight * 0.27102803738317754);
        symbol.curveTo(imageWidth * 0.35514018691588783, imageHeight * 0.27102803738317754, imageWidth * 0.3364485981308411, imageHeight * 0.2850467289719626, imageWidth * 0.3364485981308411, imageHeight * 0.3037383177570093);
        symbol.closePath();
        
         
    }

}
