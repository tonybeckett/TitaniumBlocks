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
public class Temperature extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.616822429906542, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.6074766355140186, imageHeight * 0.6121495327102804, imageWidth * 0.6121495327102804, imageHeight * 0.602803738317757, imageWidth * 0.5841121495327103, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.6074766355140186, imageWidth * 0.5794392523364486, imageHeight * 0.6214953271028038, imageWidth * 0.5887850467289719, imageHeight * 0.6261682242990654);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.6261682242990654, imageWidth * 0.6121495327102804, imageHeight * 0.6355140186915887, imageWidth * 0.6214953271028038, imageHeight * 0.6355140186915887);
        symbol.curveTo(imageWidth * 0.6495327102803738, imageHeight * 0.6355140186915887, imageWidth * 0.6588785046728972, imageHeight * 0.602803738317757, imageWidth * 0.677570093457944, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.7009345794392523, imageHeight * 0.602803738317757, imageWidth * 0.6962616822429907, imageHeight * 0.6355140186915887, imageWidth * 0.719626168224299, imageHeight * 0.6355140186915887);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.6355140186915887, imageWidth * 0.7336448598130841, imageHeight * 0.6121495327102804, imageWidth * 0.7242990654205608, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.6121495327102804, imageWidth * 0.6962616822429907, imageHeight * 0.5794392523364486, imageWidth * 0.677570093457944, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.6542056074766355, imageHeight * 0.5794392523364486, imageWidth * 0.6448598130841121, imageHeight * 0.6121495327102804, imageWidth * 0.616822429906542, imageHeight * 0.6121495327102804);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.27102803738317754, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.2616822429906542, imageHeight * 0.6074766355140186, imageWidth * 0.2616822429906542, imageHeight * 0.6261682242990654, imageWidth * 0.27102803738317754, imageHeight * 0.6261682242990654);
        symbol.curveTo(imageWidth * 0.3037383177570093, imageHeight * 0.6261682242990654, imageWidth * 0.3037383177570093, imageHeight * 0.602803738317757, imageWidth * 0.32242990654205606, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.35046728971962615, imageHeight * 0.602803738317757, imageWidth * 0.35046728971962615, imageHeight * 0.6261682242990654, imageWidth * 0.38317757009345793, imageHeight * 0.6261682242990654);
        symbol.curveTo(imageWidth * 0.411214953271028, imageHeight * 0.6261682242990654, imageWidth * 0.411214953271028, imageHeight * 0.6214953271028038, imageWidth * 0.4158878504672897, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.4205607476635514, imageHeight * 0.602803738317757, imageWidth * 0.40186915887850466, imageHeight * 0.5981308411214953, imageWidth * 0.37850467289719625, imageHeight * 0.602803738317757);
        symbol.curveTo(imageWidth * 0.35514018691588783, imageHeight * 0.602803738317757, imageWidth * 0.35046728971962615, imageHeight * 0.5747663551401869, imageWidth * 0.32242990654205606, imageHeight * 0.5747663551401869);
        symbol.curveTo(imageWidth * 0.29906542056074764, imageHeight * 0.5747663551401869, imageWidth * 0.2850467289719626, imageHeight * 0.602803738317757, imageWidth * 0.27102803738317754, imageHeight * 0.602803738317757);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.32242990654205606, imageHeight * 0.6728971962616822);
        symbol.curveTo(imageWidth * 0.32242990654205606, imageHeight * 0.6728971962616822, imageWidth * 0.3130841121495327, imageHeight * 0.6822429906542056, imageWidth * 0.3130841121495327, imageHeight * 0.6915887850467289);
        symbol.curveTo(imageWidth * 0.3411214953271028, imageHeight * 0.6915887850467289, imageWidth * 0.35514018691588783, imageHeight * 0.7242990654205608, imageWidth * 0.38317757009345793, imageHeight * 0.7242990654205608);
        symbol.curveTo(imageWidth * 0.411214953271028, imageHeight * 0.7242990654205608, imageWidth * 0.4205607476635514, imageHeight * 0.6869158878504673, imageWidth * 0.4439252336448598, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.4719626168224299, imageHeight * 0.6869158878504673, imageWidth * 0.4719626168224299, imageHeight * 0.7242990654205608, imageWidth * 0.5046728971962616, imageHeight * 0.7242990654205608);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.7242990654205608, imageWidth * 0.5420560747663551, imageHeight * 0.6869158878504673, imageWidth * 0.5607476635514018, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.5841121495327103, imageHeight * 0.6869158878504673, imageWidth * 0.5887850467289719, imageHeight * 0.7242990654205608, imageWidth * 0.6121495327102804, imageHeight * 0.7242990654205608);
        symbol.curveTo(imageWidth * 0.6401869158878505, imageHeight * 0.7242990654205608, imageWidth * 0.6588785046728972, imageHeight * 0.6822429906542056, imageWidth * 0.6915887850467289, imageHeight * 0.6822429906542056);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.6822429906542056, imageWidth * 0.6915887850467289, imageHeight * 0.6728971962616822, imageWidth * 0.6822429906542056, imageHeight * 0.6635514018691588);
        symbol.curveTo(imageWidth * 0.6542056074766355, imageHeight * 0.6635514018691588, imageWidth * 0.6355140186915887, imageHeight * 0.7009345794392523, imageWidth * 0.6121495327102804, imageHeight * 0.7009345794392523);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.7009345794392523, imageWidth * 0.5841121495327103, imageHeight * 0.6635514018691588, imageWidth * 0.5607476635514018, imageHeight * 0.6635514018691588);
        symbol.curveTo(imageWidth * 0.5420560747663551, imageHeight * 0.6635514018691588, imageWidth * 0.5280373831775701, imageHeight * 0.7009345794392523, imageWidth * 0.5046728971962616, imageHeight * 0.7009345794392523);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.7009345794392523, imageWidth * 0.4719626168224299, imageHeight * 0.6635514018691588, imageWidth * 0.4439252336448598, imageHeight * 0.6635514018691588);
        symbol.curveTo(imageWidth * 0.4205607476635514, imageHeight * 0.6635514018691588, imageWidth * 0.397196261682243, imageHeight * 0.7009345794392523, imageWidth * 0.38317757009345793, imageHeight * 0.7009345794392523);
        symbol.curveTo(imageWidth * 0.35514018691588783, imageHeight * 0.7009345794392523, imageWidth * 0.35514018691588783, imageHeight * 0.6728971962616822, imageWidth * 0.32242990654205606, imageHeight * 0.6728971962616822);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.514018691588785, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.37850467289719625, imageWidth * 0.5747663551401869, imageHeight * 0.37850467289719625, imageWidth * 0.5747663551401869, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.37850467289719625, imageWidth * 0.5887850467289719, imageHeight * 0.3691588785046729, imageWidth * 0.5887850467289719, imageHeight * 0.3644859813084112);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.3598130841121495, imageWidth * 0.5794392523364486, imageHeight * 0.35046728971962615, imageWidth * 0.5747663551401869, imageHeight * 0.35046728971962615);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.35046728971962615, imageWidth * 0.514018691588785, imageHeight * 0.35046728971962615, imageWidth * 0.514018691588785, imageHeight * 0.35046728971962615);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.35046728971962615, imageWidth * 0.514018691588785, imageHeight * 0.29906542056074764, imageWidth * 0.514018691588785, imageHeight * 0.29906542056074764);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.2897196261682243, imageWidth * 0.5046728971962616, imageHeight * 0.2803738317757009, imageWidth * 0.4953271028037383, imageHeight * 0.2803738317757009);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.2803738317757009, imageWidth * 0.4766355140186916, imageHeight * 0.2897196261682243, imageWidth * 0.4766355140186916, imageHeight * 0.29906542056074764);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.29906542056074764, imageWidth * 0.4766355140186916, imageHeight * 0.5700934579439252, imageWidth * 0.4766355140186916, imageHeight * 0.5700934579439252);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.5794392523364486, imageWidth * 0.4532710280373832, imageHeight * 0.5934579439252337, imageWidth * 0.4532710280373832, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.4532710280373832, imageHeight * 0.6355140186915887, imageWidth * 0.4719626168224299, imageHeight * 0.6542056074766355, imageWidth * 0.4953271028037383, imageHeight * 0.6542056074766355);
        symbol.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.6542056074766355, imageWidth * 0.5373831775700935, imageHeight * 0.6355140186915887, imageWidth * 0.5373831775700935, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.5373831775700935, imageHeight * 0.5934579439252337, imageWidth * 0.5280373831775701, imageHeight * 0.5794392523364486, imageWidth * 0.514018691588785, imageHeight * 0.5700934579439252);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.5700934579439252, imageWidth * 0.514018691588785, imageHeight * 0.5186915887850467, imageWidth * 0.514018691588785, imageHeight * 0.5186915887850467);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.5186915887850467, imageWidth * 0.5747663551401869, imageHeight * 0.5186915887850467, imageWidth * 0.5747663551401869, imageHeight * 0.5186915887850467);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.5186915887850467, imageWidth * 0.5887850467289719, imageHeight * 0.514018691588785, imageWidth * 0.5887850467289719, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.5, imageWidth * 0.5794392523364486, imageHeight * 0.4953271028037383, imageWidth * 0.5747663551401869, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.4953271028037383, imageWidth * 0.514018691588785, imageHeight * 0.4953271028037383, imageWidth * 0.514018691588785, imageHeight * 0.4953271028037383);
        symbol.lineTo(imageWidth * 0.514018691588785, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.514018691588785, imageHeight * 0.4485981308411215, imageWidth * 0.5747663551401869, imageHeight * 0.4485981308411215, imageWidth * 0.5747663551401869, imageHeight * 0.4485981308411215);
        symbol.curveTo(imageWidth * 0.5794392523364486, imageHeight * 0.4485981308411215, imageWidth * 0.5887850467289719, imageHeight * 0.4439252336448598, imageWidth * 0.5887850467289719, imageHeight * 0.43457943925233644);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.42990654205607476, imageWidth * 0.5794392523364486, imageHeight * 0.4252336448598131, imageWidth * 0.5747663551401869, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.4252336448598131, imageWidth * 0.514018691588785, imageHeight * 0.4252336448598131, imageWidth * 0.514018691588785, imageHeight * 0.4252336448598131);
        symbol.lineTo(imageWidth * 0.514018691588785, imageHeight * 0.37850467289719625);
        symbol.closePath();
        
         
    }

}
