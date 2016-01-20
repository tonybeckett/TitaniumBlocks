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
public class Oil extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
       
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.7149532710280374, imageHeight * 0.5046728971962616);
        symbol.curveTo(imageWidth * 0.7149532710280374, imageHeight * 0.5046728971962616, imageWidth * 0.7009345794392523, imageHeight * 0.5280373831775701, imageWidth * 0.6962616822429907, imageHeight * 0.5514018691588785);
        symbol.curveTo(imageWidth * 0.6962616822429907, imageHeight * 0.5607476635514018, imageWidth * 0.7009345794392523, imageHeight * 0.5747663551401869, imageWidth * 0.7149532710280374, imageHeight * 0.5747663551401869);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.5747663551401869, imageWidth * 0.7383177570093458, imageHeight * 0.5607476635514018, imageWidth * 0.7336448598130841, imageHeight * 0.5467289719626168);
        symbol.curveTo(imageWidth * 0.7289719626168224, imageHeight * 0.5233644859813084, imageWidth * 0.7149532710280374, imageHeight * 0.5046728971962616, imageWidth * 0.7149532710280374, imageHeight * 0.5046728971962616);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.3130841121495327, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.42990654205607476);
        symbol.lineTo(imageWidth * 0.3130841121495327, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.26635514018691586, imageHeight * 0.4672897196261682);
        symbol.lineTo(imageWidth * 0.2803738317757009, imageHeight * 0.48130841121495327);
        symbol.lineTo(imageWidth * 0.29906542056074764, imageHeight * 0.45794392523364486);
        symbol.lineTo(imageWidth * 0.32242990654205606, imageHeight * 0.48130841121495327);
        symbol.lineTo(imageWidth * 0.32242990654205606, imageHeight * 0.5887850467289719);
        symbol.lineTo(imageWidth * 0.3317757009345794, imageHeight * 0.5981308411214953);
        symbol.lineTo(imageWidth * 0.5654205607476636, imageHeight * 0.5981308411214953);
        symbol.curveTo(imageWidth * 0.5654205607476636, imageHeight * 0.5981308411214953, imageWidth * 0.6261682242990654, imageHeight * 0.46261682242990654, imageWidth * 0.6682242990654206, imageHeight * 0.45794392523364486);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.45794392523364486, imageWidth * 0.705607476635514, imageHeight * 0.48130841121495327, imageWidth * 0.705607476635514, imageHeight * 0.48130841121495327);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.48130841121495327, imageWidth * 0.7149532710280374, imageHeight * 0.48130841121495327, imageWidth * 0.719626168224299, imageHeight * 0.4766355140186916);
        symbol.curveTo(imageWidth * 0.7289719626168224, imageHeight * 0.4719626168224299, imageWidth * 0.7242990654205608, imageHeight * 0.46261682242990654, imageWidth * 0.7242990654205608, imageHeight * 0.46261682242990654);
        symbol.curveTo(imageWidth * 0.7242990654205608, imageHeight * 0.46261682242990654, imageWidth * 0.7009345794392523, imageHeight * 0.4205607476635514, imageWidth * 0.6728971962616822, imageHeight * 0.4205607476635514);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.4205607476635514, imageWidth * 0.5560747663551402, imageHeight * 0.4953271028037383, imageWidth * 0.5233644859813084, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.5093457943925234, imageHeight * 0.5, imageWidth * 0.48598130841121495, imageHeight * 0.46261682242990654, imageWidth * 0.48598130841121495, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.411214953271028, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.411214953271028, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.4392523364485981, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.42990654205607476, imageHeight * 0.411214953271028);
        symbol.lineTo(imageWidth * 0.37850467289719625, imageHeight * 0.411214953271028);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.397196261682243, imageHeight * 0.4205607476635514);
        symbol.lineTo(imageWidth * 0.397196261682243, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.3317757009345794, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.3130841121495327, imageHeight * 0.4439252336448598);
        symbol.closePath();

       
    }

}
