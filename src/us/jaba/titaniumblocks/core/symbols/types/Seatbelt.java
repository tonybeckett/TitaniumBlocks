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
public class Seatbelt extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.2897196261682243, imageHeight * 0.719626168224299);
        symbol.curveTo(imageWidth * 0.29439252336448596, imageHeight * 0.7242990654205608, imageWidth * 0.3037383177570093, imageHeight * 0.7242990654205608, imageWidth * 0.3130841121495327, imageHeight * 0.719626168224299);
        symbol.curveTo(imageWidth * 0.3130841121495327, imageHeight * 0.719626168224299, imageWidth * 0.3644859813084112, imageHeight * 0.6682242990654206, imageWidth * 0.3644859813084112, imageHeight * 0.6682242990654206);
        symbol.curveTo(imageWidth * 0.3644859813084112, imageHeight * 0.6682242990654206, imageWidth * 0.3644859813084112, imageHeight * 0.6635514018691588, imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588);
        symbol.curveTo(imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588, imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588, imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.6635514018691588);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.6495327102803738);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.6261682242990654);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542);
        symbol.curveTo(imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542, imageWidth * 0.2897196261682243, imageHeight * 0.6915887850467289, imageWidth * 0.2897196261682243, imageHeight * 0.6915887850467289);
        symbol.curveTo(imageWidth * 0.2803738317757009, imageHeight * 0.7009345794392523, imageWidth * 0.2803738317757009, imageHeight * 0.7102803738317757, imageWidth * 0.2897196261682243, imageHeight * 0.719626168224299);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.616822429906542, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.6261682242990654, imageHeight * 0.6962616822429907, imageWidth * 0.6355140186915887, imageHeight * 0.7102803738317757, imageWidth * 0.6401869158878505, imageHeight * 0.719626168224299);
        symbol.curveTo(imageWidth * 0.6401869158878505, imageHeight * 0.719626168224299, imageWidth * 0.6682242990654206, imageHeight * 0.705607476635514, imageWidth * 0.6682242990654206, imageHeight * 0.705607476635514);
        symbol.curveTo(imageWidth * 0.6588785046728972, imageHeight * 0.6869158878504673, imageWidth * 0.6495327102803738, imageHeight * 0.6682242990654206, imageWidth * 0.6355140186915887, imageHeight * 0.6542056074766355);
        symbol.curveTo(imageWidth * 0.6308411214953271, imageHeight * 0.6682242990654206, imageWidth * 0.6261682242990654, imageHeight * 0.677570093457944, imageWidth * 0.616822429906542, imageHeight * 0.6869158878504673);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299);
        symbol.lineTo(imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5420560747663551, imageHeight * 0.45794392523364486);
        symbol.curveTo(imageWidth * 0.5467289719626168, imageHeight * 0.46261682242990654, imageWidth * 0.5514018691588785, imageHeight * 0.4672897196261682, imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299, imageWidth * 0.6214953271028038, imageHeight * 0.411214953271028, imageWidth * 0.6214953271028038, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.6261682242990654, imageHeight * 0.40186915887850466, imageWidth * 0.6261682242990654, imageHeight * 0.3925233644859813, imageWidth * 0.6214953271028038, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.6121495327102804, imageHeight * 0.37850467289719625, imageWidth * 0.602803738317757, imageHeight * 0.37850467289719625, imageWidth * 0.5934579439252337, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.38317757009345793, imageWidth * 0.5327102803738317, imageHeight * 0.4439252336448598, imageWidth * 0.5327102803738317, imageHeight * 0.4439252336448598);
        symbol.curveTo(imageWidth * 0.5373831775700935, imageHeight * 0.4485981308411215, imageWidth * 0.5373831775700935, imageHeight * 0.4532710280373832, imageWidth * 0.5420560747663551, imageHeight * 0.45794392523364486);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588);
        symbol.curveTo(imageWidth * 0.37383177570093457, imageHeight * 0.6869158878504673, imageWidth * 0.397196261682243, imageHeight * 0.705607476635514, imageWidth * 0.4252336448598131, imageHeight * 0.705607476635514);
        symbol.curveTo(imageWidth * 0.4252336448598131, imageHeight * 0.705607476635514, imageWidth * 0.5747663551401869, imageHeight * 0.705607476635514, imageWidth * 0.5747663551401869, imageHeight * 0.705607476635514);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.705607476635514, imageWidth * 0.6074766355140186, imageHeight * 0.6962616822429907, imageWidth * 0.616822429906542, imageHeight * 0.6869158878504673);
        symbol.curveTo(imageWidth * 0.5841121495327103, imageHeight * 0.6495327102803738, imageWidth * 0.5327102803738317, imageHeight * 0.6261682242990654, imageWidth * 0.48130841121495327, imageHeight * 0.6261682242990654);
        symbol.curveTo(imageWidth * 0.4392523364485981, imageHeight * 0.6261682242990654, imageWidth * 0.397196261682243, imageHeight * 0.6401869158878505, imageWidth * 0.3691588785046729, imageHeight * 0.6635514018691588);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6542056074766355);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6542056074766355, imageWidth * 0.6355140186915887, imageHeight * 0.6495327102803738, imageWidth * 0.6355140186915887, imageHeight * 0.6495327102803738);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6495327102803738, imageWidth * 0.6355140186915887, imageHeight * 0.5327102803738317, imageWidth * 0.6355140186915887, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.5, imageWidth * 0.6074766355140186, imageHeight * 0.4719626168224299, imageWidth * 0.5747663551401869, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.4719626168224299, imageWidth * 0.5700934579439252, imageHeight * 0.4719626168224299, imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.4719626168224299, imageWidth * 0.42990654205607476, imageHeight * 0.5981308411214953, imageWidth * 0.42990654205607476, imageHeight * 0.5981308411214953);
        symbol.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.5934579439252337, imageWidth * 0.46261682242990654, imageHeight * 0.5934579439252337, imageWidth * 0.48130841121495327, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.5373831775700935, imageHeight * 0.5934579439252337, imageWidth * 0.5934579439252337, imageHeight * 0.616822429906542, imageWidth * 0.6355140186915887, imageHeight * 0.6542056074766355);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542);
        symbol.curveTo(imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542, imageWidth * 0.5327102803738317, imageHeight * 0.4439252336448598, imageWidth * 0.5327102803738317, imageHeight * 0.4439252336448598);
        symbol.curveTo(imageWidth * 0.5280373831775701, imageHeight * 0.42990654205607476, imageWidth * 0.5327102803738317, imageHeight * 0.411214953271028, imageWidth * 0.5327102803738317, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.5420560747663551, imageHeight * 0.40186915887850466, imageWidth * 0.5514018691588785, imageHeight * 0.38317757009345793, imageWidth * 0.5560747663551402, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.3691588785046729, imageWidth * 0.5560747663551402, imageHeight * 0.3691588785046729, imageWidth * 0.5560747663551402, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.3691588785046729, imageWidth * 0.5654205607476636, imageHeight * 0.34579439252336447, imageWidth * 0.5654205607476636, imageHeight * 0.34579439252336447);
        symbol.curveTo(imageWidth * 0.5654205607476636, imageHeight * 0.3411214953271028, imageWidth * 0.5654205607476636, imageHeight * 0.3364485981308411, imageWidth * 0.5607476635514018, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.5560747663551402, imageHeight * 0.2897196261682243, imageWidth * 0.5280373831775701, imageHeight * 0.2570093457943925, imageWidth * 0.4953271028037383, imageHeight * 0.2570093457943925);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.2570093457943925, imageWidth * 0.43457943925233644, imageHeight * 0.2897196261682243, imageWidth * 0.42990654205607476, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.4252336448598131, imageHeight * 0.3364485981308411, imageWidth * 0.4252336448598131, imageHeight * 0.3411214953271028, imageWidth * 0.4252336448598131, imageHeight * 0.34579439252336447);
        symbol.curveTo(imageWidth * 0.4252336448598131, imageHeight * 0.34579439252336447, imageWidth * 0.4252336448598131, imageHeight * 0.3691588785046729, imageWidth * 0.43457943925233644, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.43457943925233644, imageHeight * 0.3691588785046729, imageWidth * 0.43457943925233644, imageHeight * 0.3691588785046729, imageWidth * 0.43457943925233644, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.4392523364485981, imageHeight * 0.38317757009345793, imageWidth * 0.4485981308411215, imageHeight * 0.40186915887850466, imageWidth * 0.45794392523364486, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.45794392523364486, imageHeight * 0.411214953271028, imageWidth * 0.4672897196261682, imageHeight * 0.4439252336448598, imageWidth * 0.4485981308411215, imageHeight * 0.46261682242990654);
        symbol.curveTo(imageWidth * 0.4392523364485981, imageHeight * 0.4719626168224299, imageWidth * 0.4252336448598131, imageHeight * 0.4719626168224299, imageWidth * 0.4252336448598131, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.3925233644859813, imageHeight * 0.4719626168224299, imageWidth * 0.3644859813084112, imageHeight * 0.5, imageWidth * 0.3644859813084112, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.3644859813084112, imageHeight * 0.5327102803738317, imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542, imageWidth * 0.3644859813084112, imageHeight * 0.616822429906542);
        symbol.closePath();

         
    }

}
