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
public class Horn extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
         
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();
        
      
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.40654205607476634, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.40654205607476634, imageHeight * 0.5514018691588785, imageWidth * 0.4205607476635514, imageHeight * 0.5420560747663551, imageWidth * 0.4485981308411215, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.4719626168224299, imageHeight * 0.5233644859813084, imageWidth * 0.5, imageHeight * 0.5186915887850467, imageWidth * 0.5327102803738317, imageHeight * 0.5186915887850467);
        symbol.curveTo(imageWidth * 0.5607476635514018, imageHeight * 0.5186915887850467, imageWidth * 0.5934579439252337, imageHeight * 0.5233644859813084, imageWidth * 0.6121495327102804, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.6401869158878505, imageHeight * 0.5420560747663551, imageWidth * 0.6542056074766355, imageHeight * 0.5514018691588785, imageWidth * 0.6542056074766355, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.6542056074766355, imageHeight * 0.5887850467289719, imageWidth * 0.5981308411214953, imageHeight * 0.6121495327102804, imageWidth * 0.5327102803738317, imageHeight * 0.6121495327102804);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.6121495327102804, imageWidth * 0.40654205607476634, imageHeight * 0.5887850467289719, imageWidth * 0.40654205607476634, imageHeight * 0.5654205607476636);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.677570093457944, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.677570093457944, imageHeight * 0.5514018691588785, imageWidth * 0.6728971962616822, imageHeight * 0.5420560747663551, imageWidth * 0.6588785046728972, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.5046728971962616, imageWidth * 0.7242990654205608, imageHeight * 0.5327102803738317, imageWidth * 0.7242990654205608, imageHeight * 0.5327102803738317);
        symbol.lineTo(imageWidth * 0.7383177570093458, imageHeight * 0.5327102803738317);
        symbol.lineTo(imageWidth * 0.7383177570093458, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.7242990654205608, imageHeight * 0.46261682242990654);
        symbol.curveTo(imageWidth * 0.7242990654205608, imageHeight * 0.46261682242990654, imageWidth * 0.705607476635514, imageHeight * 0.48598130841121495, imageWidth * 0.6542056074766355, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.6214953271028038, imageHeight * 0.48598130841121495, imageWidth * 0.5981308411214953, imageHeight * 0.48598130841121495, imageWidth * 0.5981308411214953, imageHeight * 0.48598130841121495);
        symbol.lineTo(imageWidth * 0.5981308411214953, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.5747663551401869, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.5747663551401869, imageHeight * 0.48598130841121495);
        symbol.lineTo(imageWidth * 0.5420560747663551, imageHeight * 0.48598130841121495);
        symbol.lineTo(imageWidth * 0.5420560747663551, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.5186915887850467, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.5186915887850467, imageHeight * 0.48598130841121495);
        symbol.lineTo(imageWidth * 0.48598130841121495, imageHeight * 0.48598130841121495);
        symbol.lineTo(imageWidth * 0.48598130841121495, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.46261682242990654, imageHeight * 0.4439252336448598);
        symbol.curveTo(imageWidth * 0.46261682242990654, imageHeight * 0.4439252336448598, imageWidth * 0.46261682242990654, imageHeight * 0.48130841121495327, imageWidth * 0.46261682242990654, imageHeight * 0.48598130841121495);
        symbol.curveTo(imageWidth * 0.3037383177570093, imageHeight * 0.48598130841121495, imageWidth * 0.2803738317757009, imageHeight * 0.3644859813084112, imageWidth * 0.2803738317757009, imageHeight * 0.3644859813084112);
        symbol.lineTo(imageWidth * 0.27102803738317754, imageHeight * 0.3644859813084112);
        symbol.lineTo(imageWidth * 0.27102803738317754, imageHeight * 0.6401869158878505);
        symbol.lineTo(imageWidth * 0.2850467289719626, imageHeight * 0.6401869158878505);
        symbol.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.6401869158878505, imageWidth * 0.29439252336448596, imageHeight * 0.5327102803738317, imageWidth * 0.3925233644859813, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.3925233644859813, imageHeight * 0.5327102803738317, imageWidth * 0.40186915887850466, imageHeight * 0.5327102803738317, imageWidth * 0.40186915887850466, imageHeight * 0.5327102803738317);
        symbol.curveTo(imageWidth * 0.3878504672897196, imageHeight * 0.5420560747663551, imageWidth * 0.38317757009345793, imageHeight * 0.5514018691588785, imageWidth * 0.38317757009345793, imageHeight * 0.5654205607476636);
        symbol.curveTo(imageWidth * 0.38317757009345793, imageHeight * 0.602803738317757, imageWidth * 0.4485981308411215, imageHeight * 0.6355140186915887, imageWidth * 0.5327102803738317, imageHeight * 0.6355140186915887);
        symbol.curveTo(imageWidth * 0.6121495327102804, imageHeight * 0.6355140186915887, imageWidth * 0.677570093457944, imageHeight * 0.602803738317757, imageWidth * 0.677570093457944, imageHeight * 0.5654205607476636);
        symbol.closePath();

       
    }

}
