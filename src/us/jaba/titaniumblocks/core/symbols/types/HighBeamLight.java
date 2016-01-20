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
public class HighBeamLight extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
         

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.4392523364485981);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.4532710280373832, imageWidth * 0.2850467289719626, imageHeight * 0.4532710280373832, imageWidth * 0.2850467289719626, imageHeight * 0.4532710280373832);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.4532710280373832, imageWidth * 0.40654205607476634, imageHeight * 0.4532710280373832, imageWidth * 0.40654205607476634, imageHeight * 0.4532710280373832);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.43457943925233644, imageWidth * 0.411214953271028, imageHeight * 0.4252336448598131, imageWidth * 0.411214953271028, imageHeight * 0.4252336448598131);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.4252336448598131, imageWidth * 0.27102803738317754, imageHeight * 0.4252336448598131, imageWidth * 0.26635514018691586, imageHeight * 0.4392523364485981);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.5560747663551402);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.5700934579439252, imageWidth * 0.2850467289719626, imageHeight * 0.5700934579439252, imageWidth * 0.2850467289719626, imageHeight * 0.5700934579439252);
        symbol.lineTo(imageWidth * 0.411214953271028, imageHeight * 0.5700934579439252);
        symbol.curveTo(imageWidth * 0.411214953271028, imageHeight * 0.5700934579439252, imageWidth * 0.40654205607476634, imageHeight * 0.5607476635514018, imageWidth * 0.40654205607476634, imageHeight * 0.5420560747663551);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.5420560747663551, imageWidth * 0.2850467289719626, imageHeight * 0.5420560747663551, imageWidth * 0.2850467289719626, imageHeight * 0.5420560747663551);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.5420560747663551, imageWidth * 0.26635514018691586, imageHeight * 0.5420560747663551, imageWidth * 0.26635514018691586, imageHeight * 0.5560747663551402);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.26635514018691586, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.514018691588785, imageWidth * 0.2850467289719626, imageHeight * 0.514018691588785, imageWidth * 0.2850467289719626, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.40654205607476634, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.40654205607476634, imageHeight * 0.48130841121495327);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.48130841121495327);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.48130841121495327, imageWidth * 0.27102803738317754, imageHeight * 0.48130841121495327, imageWidth * 0.26635514018691586, imageHeight * 0.4953271028037383);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.27102803738317754, imageHeight * 0.3691588785046729);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.38317757009345793, imageWidth * 0.2850467289719626, imageHeight * 0.38317757009345793, imageWidth * 0.2850467289719626, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.38317757009345793, imageWidth * 0.42990654205607476, imageHeight * 0.38317757009345793, imageWidth * 0.42990654205607476, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.4485981308411215, imageHeight * 0.3598130841121495, imageWidth * 0.4672897196261682, imageHeight * 0.35514018691588783, imageWidth * 0.4672897196261682, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.35514018691588783, imageWidth * 0.27102803738317754, imageHeight * 0.35514018691588783, imageWidth * 0.27102803738317754, imageHeight * 0.3691588785046729);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.27102803738317754, imageHeight * 0.6261682242990654);
        symbol.curveTo(imageWidth * 0.27102803738317754, imageHeight * 0.6401869158878505, imageWidth * 0.2850467289719626, imageHeight * 0.6401869158878505, imageWidth * 0.2850467289719626, imageHeight * 0.6401869158878505);
        symbol.lineTo(imageWidth * 0.4672897196261682, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.4672897196261682, imageHeight * 0.6401869158878505, imageWidth * 0.4485981308411215, imageHeight * 0.6355140186915887, imageWidth * 0.42990654205607476, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.42990654205607476, imageHeight * 0.6121495327102804, imageWidth * 0.2850467289719626, imageHeight * 0.6121495327102804, imageWidth * 0.2850467289719626, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.6121495327102804, imageWidth * 0.27102803738317754, imageHeight * 0.6121495327102804, imageWidth * 0.27102803738317754, imageHeight * 0.6261682242990654);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5467289719626168, imageHeight * 0.38317757009345793);
        symbol.curveTo(imageWidth * 0.5934579439252337, imageHeight * 0.38317757009345793, imageWidth * 0.705607476635514, imageHeight * 0.4252336448598131, imageWidth * 0.705607476635514, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.705607476635514, imageHeight * 0.5747663551401869, imageWidth * 0.5934579439252337, imageHeight * 0.6121495327102804, imageWidth * 0.5467289719626168, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.5327102803738317, imageHeight * 0.6121495327102804, imageWidth * 0.4766355140186916, imageHeight * 0.6121495327102804, imageWidth * 0.4766355140186916, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.4766355140186916, imageHeight * 0.3878504672897196, imageWidth * 0.5327102803738317, imageHeight * 0.38317757009345793, imageWidth * 0.5467289719626168, imageHeight * 0.38317757009345793);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5373831775700935, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.5186915887850467, imageHeight * 0.35514018691588783, imageWidth * 0.4439252336448598, imageHeight * 0.3598130841121495, imageWidth * 0.4439252336448598, imageHeight * 0.5);
        symbol.curveTo(imageWidth * 0.4439252336448598, imageHeight * 0.6448598130841121, imageWidth * 0.5186915887850467, imageHeight * 0.6401869158878505, imageWidth * 0.5373831775700935, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.6401869158878505, imageWidth * 0.7336448598130841, imageHeight * 0.5934579439252337, imageWidth * 0.7336448598130841, imageHeight * 0.4953271028037383);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.40654205607476634, imageWidth * 0.5981308411214953, imageHeight * 0.35514018691588783, imageWidth * 0.5373831775700935, imageHeight * 0.35514018691588783);
        symbol.closePath();
        
        
    }

}
