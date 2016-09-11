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
public class FogLight extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
      

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.5607476635514018, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.5887850467289719, imageWidth * 0.5700934579439252, imageHeight * 0.5934579439252337, imageWidth * 0.5747663551401869, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.5934579439252337, imageWidth * 0.5934579439252337, imageHeight * 0.5934579439252337, imageWidth * 0.5934579439252337, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.6121495327102804, imageWidth * 0.6121495327102804, imageHeight * 0.6214953271028038, imageWidth * 0.6121495327102804, imageHeight * 0.6214953271028038);
        symbol.lineTo(imageWidth * 0.6355140186915887, imageHeight * 0.6074766355140186);
        symbol.curveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6074766355140186, imageWidth * 0.6214953271028038, imageHeight * 0.602803738317757, imageWidth * 0.616822429906542, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.5934579439252337, imageWidth * 0.6682242990654206, imageHeight * 0.5934579439252337, imageWidth * 0.6682242990654206, imageHeight * 0.5934579439252337);
        symbol.curveTo(imageWidth * 0.677570093457944, imageHeight * 0.5934579439252337, imageWidth * 0.6822429906542056, imageHeight * 0.5887850467289719, imageWidth * 0.6822429906542056, imageHeight * 0.5794392523364486);
        symbol.curveTo(imageWidth * 0.6822429906542056, imageHeight * 0.5747663551401869, imageWidth * 0.677570093457944, imageHeight * 0.5654205607476636, imageWidth * 0.6682242990654206, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.6682242990654206, imageHeight * 0.5654205607476636, imageWidth * 0.6121495327102804, imageHeight * 0.5654205607476636, imageWidth * 0.6121495327102804, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.5514018691588785, imageWidth * 0.6448598130841121, imageHeight * 0.5280373831775701, imageWidth * 0.6495327102803738, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.6495327102803738, imageHeight * 0.5093457943925234, imageWidth * 0.6682242990654206, imageHeight * 0.5093457943925234, imageWidth * 0.6682242990654206, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.677570093457944, imageHeight * 0.5093457943925234, imageWidth * 0.6822429906542056, imageHeight * 0.5046728971962616, imageWidth * 0.6822429906542056, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.6822429906542056, imageHeight * 0.49065420560747663, imageWidth * 0.677570093457944, imageHeight * 0.48598130841121495, imageWidth * 0.6682242990654206, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.6682242990654206, imageHeight * 0.48598130841121495, imageWidth * 0.6542056074766355, imageHeight * 0.48598130841121495, imageWidth * 0.6542056074766355, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.6448598130841121, imageHeight * 0.4672897196261682, imageWidth * 0.6261682242990654, imageHeight * 0.4532710280373832, imageWidth * 0.616822429906542, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.4392523364485981, imageWidth * 0.6682242990654206, imageHeight * 0.4392523364485981, imageWidth * 0.6682242990654206, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.677570093457944, imageHeight * 0.4392523364485981, imageWidth * 0.6822429906542056, imageHeight * 0.42990654205607476, imageWidth * 0.6822429906542056, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.6822429906542056, imageHeight * 0.4158878504672897, imageWidth * 0.677570093457944, imageHeight * 0.411214953271028, imageWidth * 0.6682242990654206, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.6682242990654206, imageHeight * 0.411214953271028, imageWidth * 0.6121495327102804, imageHeight * 0.411214953271028, imageWidth * 0.6121495327102804, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.397196261682243, imageWidth * 0.6308411214953271, imageHeight * 0.3925233644859813, imageWidth * 0.6308411214953271, imageHeight * 0.3925233644859813);
        symbol.lineTo(imageWidth * 0.616822429906542, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.37850467289719625, imageWidth * 0.5981308411214953, imageHeight * 0.3925233644859813, imageWidth * 0.5887850467289719, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.411214953271028, imageWidth * 0.5747663551401869, imageHeight * 0.411214953271028, imageWidth * 0.5747663551401869, imageHeight * 0.411214953271028);
        symbol.curveTo(imageWidth * 0.5700934579439252, imageHeight * 0.411214953271028, imageWidth * 0.5607476635514018, imageHeight * 0.4158878504672897, imageWidth * 0.5607476635514018, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.42990654205607476, imageWidth * 0.5700934579439252, imageHeight * 0.4392523364485981, imageWidth * 0.5747663551401869, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.4392523364485981, imageWidth * 0.5934579439252337, imageHeight * 0.4392523364485981, imageWidth * 0.5934579439252337, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.4532710280373832, imageWidth * 0.616822429906542, imageHeight * 0.4672897196261682, imageWidth * 0.6261682242990654, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.6261682242990654, imageHeight * 0.48598130841121495, imageWidth * 0.5747663551401869, imageHeight * 0.48598130841121495, imageWidth * 0.5747663551401869, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.5700934579439252, imageHeight * 0.48598130841121495, imageWidth * 0.5607476635514018, imageHeight * 0.49065420560747663, imageWidth * 0.5607476635514018, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.5046728971962616, imageWidth * 0.5700934579439252, imageHeight * 0.5093457943925234, imageWidth * 0.5747663551401869, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.5747663551401869, imageHeight * 0.5093457943925234, imageWidth * 0.6261682242990654, imageHeight * 0.5093457943925234, imageWidth * 0.6261682242990654, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.616822429906542, imageHeight * 0.5280373831775701, imageWidth * 0.5981308411214953, imageHeight * 0.5467289719626168, imageWidth * 0.5887850467289719, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.5887850467289719, imageHeight * 0.5654205607476636, imageWidth * 0.5747663551401869, imageHeight * 0.5654205607476636, imageWidth * 0.5747663551401869, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.5700934579439252, imageHeight * 0.5654205607476636, imageWidth * 0.5607476635514018, imageHeight * 0.5747663551401869, imageWidth * 0.5607476635514018, imageHeight * 0.5794392523364486);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.4719626168224299, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.48598130841121495, imageHeight * 0.38317757009345793, imageWidth * 0.5280373831775701, imageHeight * 0.3878504672897196, imageWidth * 0.5280373831775701, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.5280373831775701, imageHeight * 0.6121495327102804, imageWidth * 0.48598130841121495, imageHeight * 0.6121495327102804, imageWidth * 0.4719626168224299, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.43457943925233644, imageHeight * 0.6121495327102804, imageWidth * 0.34579439252336447, imageHeight * 0.5747663551401869, imageWidth * 0.34579439252336447, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.34579439252336447, imageHeight * 0.4252336448598131, imageWidth * 0.43457943925233644, imageHeight * 0.38317757009345793, imageWidth * 0.4719626168224299, imageHeight * 0.38317757009345793);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.48130841121495327, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.43457943925233644, imageHeight * 0.35514018691588783, imageWidth * 0.32242990654205606, imageHeight * 0.40654205607476634, imageWidth * 0.32242990654205606, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.32242990654205606, imageHeight * 0.5934579439252337, imageWidth * 0.43457943925233644, imageHeight * 0.6401869158878505, imageWidth * 0.48130841121495327, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.4953271028037383, imageHeight * 0.6401869158878505, imageWidth * 0.5514018691588785, imageHeight * 0.6448598130841121, imageWidth * 0.5514018691588785, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.5514018691588785, imageHeight * 0.3598130841121495, imageWidth * 0.4953271028037383, imageHeight * 0.35514018691588783, imageWidth * 0.48130841121495327, imageHeight * 0.35514018691588783);
        symbol.closePath();

       
    }

}
