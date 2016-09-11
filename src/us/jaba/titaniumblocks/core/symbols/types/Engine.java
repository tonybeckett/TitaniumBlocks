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
public class Engine extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
         
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();
        
        
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.32710280373831774, imageHeight * 0.397196261682243);
        symbol.lineTo(imageWidth * 0.38317757009345793, imageHeight * 0.3691588785046729);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.3691588785046729);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.4252336448598131, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.4252336448598131, imageHeight * 0.32710280373831774);
        symbol.lineTo(imageWidth * 0.602803738317757, imageHeight * 0.32710280373831774);
        symbol.lineTo(imageWidth * 0.602803738317757, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.5280373831775701, imageHeight * 0.35514018691588783);
        symbol.lineTo(imageWidth * 0.5280373831775701, imageHeight * 0.3691588785046729);
        symbol.lineTo(imageWidth * 0.616822429906542, imageHeight * 0.3691588785046729);
        symbol.lineTo(imageWidth * 0.6308411214953271, imageHeight * 0.397196261682243);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.397196261682243);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.705607476635514, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.705607476635514, imageHeight * 0.397196261682243);
        symbol.lineTo(imageWidth * 0.7336448598130841, imageHeight * 0.397196261682243);
        symbol.lineTo(imageWidth * 0.7336448598130841, imageHeight * 0.6308411214953271);
        symbol.lineTo(imageWidth * 0.705607476635514, imageHeight * 0.6308411214953271);
        symbol.lineTo(imageWidth * 0.705607476635514, imageHeight * 0.5887850467289719);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.5887850467289719);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.677570093457944);
        symbol.lineTo(imageWidth * 0.4252336448598131, imageHeight * 0.677570093457944);
        symbol.lineTo(imageWidth * 0.3691588785046729, imageHeight * 0.6308411214953271);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.6308411214953271);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.5280373831775701);
        symbol.lineTo(imageWidth * 0.29439252336448596, imageHeight * 0.5280373831775701);
        symbol.lineTo(imageWidth * 0.29439252336448596, imageHeight * 0.602803738317757);
        symbol.lineTo(imageWidth * 0.26635514018691586, imageHeight * 0.5841121495327103);
        symbol.lineTo(imageWidth * 0.26635514018691586, imageHeight * 0.4439252336448598);
        symbol.lineTo(imageWidth * 0.29439252336448596, imageHeight * 0.4252336448598131);
        symbol.lineTo(imageWidth * 0.29439252336448596, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.397196261682243);
        symbol.closePath();
        
          
    }

}
