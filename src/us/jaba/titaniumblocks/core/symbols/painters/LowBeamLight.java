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
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.symbols.SymbolPainter;

/**
 *
 * @author tbeckett
 */
public class LowBeamLight extends SymbolPainter
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
         

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

        
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.514018691588785, imageWidth * 0.2850467289719626, imageHeight * 0.5093457943925234, imageWidth * 0.2850467289719626, imageHeight * 0.5093457943925234);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.5093457943925234, imageWidth * 0.40654205607476634, imageHeight * 0.4719626168224299, imageWidth * 0.40654205607476634, imageHeight * 0.4719626168224299);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.4532710280373832, imageWidth * 0.411214953271028, imageHeight * 0.4392523364485981, imageWidth * 0.411214953271028, imageHeight * 0.4392523364485981);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.4766355140186916);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.4766355140186916, imageWidth * 0.27102803738317754, imageHeight * 0.48130841121495327, imageWidth * 0.26635514018691586, imageHeight * 0.4953271028037383);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.616822429906542);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.6308411214953271, imageWidth * 0.2850467289719626, imageHeight * 0.6261682242990654, imageWidth * 0.2850467289719626, imageHeight * 0.6261682242990654);
        symbol.lineTo(imageWidth * 0.411214953271028, imageHeight * 0.5887850467289719);
        symbol.curveTo(imageWidth * 0.411214953271028, imageHeight * 0.5887850467289719, imageWidth * 0.40654205607476634, imageHeight * 0.5794392523364486, imageWidth * 0.40654205607476634, imageHeight * 0.5607476635514018);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.5607476635514018, imageWidth * 0.2850467289719626, imageHeight * 0.5981308411214953, imageWidth * 0.2850467289719626, imageHeight * 0.5981308411214953);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.5981308411214953, imageWidth * 0.26635514018691586, imageHeight * 0.602803738317757, imageWidth * 0.26635514018691586, imageHeight * 0.616822429906542);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.5560747663551402);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.5700934579439252, imageWidth * 0.2850467289719626, imageHeight * 0.5654205607476636, imageWidth * 0.2850467289719626, imageHeight * 0.5654205607476636);
        symbol.lineTo(imageWidth * 0.40654205607476634, imageHeight * 0.5280373831775701);
        symbol.lineTo(imageWidth * 0.40654205607476634, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.5373831775700935);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.5373831775700935, imageWidth * 0.27102803738317754, imageHeight * 0.5420560747663551, imageWidth * 0.26635514018691586, imageHeight * 0.5560747663551402);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.27102803738317754, imageHeight * 0.42990654205607476);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.4439252336448598, imageWidth * 0.2850467289719626, imageHeight * 0.4392523364485981, imageWidth * 0.2850467289719626, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.4392523364485981, imageWidth * 0.42990654205607476, imageHeight * 0.3925233644859813, imageWidth * 0.42990654205607476, imageHeight * 0.3925233644859813);
        symbol.curveTo(imageWidth * 0.4485981308411215, imageHeight * 0.3644859813084112, imageWidth * 0.4672897196261682, imageHeight * 0.35514018691588783, imageWidth * 0.4672897196261682, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.40654205607476634);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.40654205607476634, imageWidth * 0.27102803738317754, imageHeight * 0.411214953271028, imageWidth * 0.27102803738317754, imageHeight * 0.42990654205607476);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.27102803738317754, imageHeight * 0.6822429906542056);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.7009345794392523, imageWidth * 0.2850467289719626, imageHeight * 0.6962616822429907, imageWidth * 0.2850467289719626, imageHeight * 0.6962616822429907);
        symbol.lineTo(imageWidth * 0.4672897196261682, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.6401869158878505, imageWidth * 0.4485981308411215, imageHeight * 0.6401869158878505, imageWidth * 0.42990654205607476, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.6214953271028038, imageWidth * 0.2850467289719626, imageHeight * 0.6682242990654206, imageWidth * 0.2850467289719626, imageHeight * 0.6682242990654206);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.6682242990654206, imageWidth * 0.27102803738317754, imageHeight * 0.6682242990654206, imageWidth * 0.27102803738317754, imageHeight * 0.6822429906542056);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5467289719626168, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.38317757009345793, imageWidth * 0.705607476635514, imageHeight * 0.4252336448598131, imageWidth * 0.705607476635514, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.5747663551401869, imageWidth * 0.5934579439252337, imageHeight * 0.6121495327102804, imageWidth * 0.5467289719626168, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.6121495327102804, imageWidth * 0.4766355140186916, imageHeight * 0.6121495327102804, imageWidth * 0.4766355140186916, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.3878504672897196, imageWidth * 0.5327102803738317, imageHeight * 0.38317757009345793, imageWidth * 0.5467289719626168, imageHeight * 0.38317757009345793);
        symbol.closePath();
        
       

    }

}
