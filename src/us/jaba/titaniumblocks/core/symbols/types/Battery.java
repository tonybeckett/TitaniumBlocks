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
public class Battery extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.3037383177570093, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.3037383177570093, imageHeight * 0.4205607476635514, imageWidth * 0.308411214953271, imageHeight * 0.4158878504672897, imageWidth * 0.3177570093457944, imageHeight * 0.4158878504672897);
        symbol.curveTo(imageWidth * 0.3177570093457944, imageHeight * 0.4158878504672897, imageWidth * 0.6822429906542056, imageHeight * 0.4158878504672897, imageWidth * 0.6822429906542056, imageHeight * 0.4158878504672897);
        symbol.curveTo(imageWidth * 0.6915887850467289, imageHeight * 0.4158878504672897, imageWidth * 0.6962616822429907, imageHeight * 0.4205607476635514, imageWidth * 0.6962616822429907, imageHeight * 0.4252336448598131);
        symbol.curveTo(imageWidth * 0.6962616822429907, imageHeight * 0.4252336448598131, imageWidth * 0.6962616822429907, imageHeight * 0.6214953271028038, imageWidth * 0.6962616822429907, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.6962616822429907, imageHeight * 0.6308411214953271, imageWidth * 0.6915887850467289, imageHeight * 0.6355140186915887, imageWidth * 0.6822429906542056, imageHeight * 0.6355140186915887);
        symbol.curveTo(imageWidth * 0.6822429906542056, imageHeight * 0.6355140186915887, imageWidth * 0.3177570093457944, imageHeight * 0.6355140186915887, imageWidth * 0.3177570093457944, imageHeight * 0.6355140186915887);
        symbol.curveTo(imageWidth * 0.308411214953271, imageHeight * 0.6355140186915887, imageWidth * 0.3037383177570093, imageHeight * 0.6308411214953271, imageWidth * 0.3037383177570093, imageHeight * 0.6214953271028038);
        symbol.curveTo(imageWidth * 0.3037383177570093, imageHeight * 0.6214953271028038, imageWidth * 0.3037383177570093, imageHeight * 0.4252336448598131, imageWidth * 0.3037383177570093, imageHeight * 0.4252336448598131);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.32710280373831774, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.32710280373831774, imageHeight * 0.35514018691588783, imageWidth * 0.32710280373831774, imageHeight * 0.37850467289719625, imageWidth * 0.32710280373831774, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.32710280373831774, imageHeight * 0.37850467289719625, imageWidth * 0.2897196261682243, imageHeight * 0.37850467289719625, imageWidth * 0.2897196261682243, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.2757009345794392, imageHeight * 0.37850467289719625, imageWidth * 0.26635514018691586, imageHeight * 0.3878504672897196, imageWidth * 0.26635514018691586, imageHeight * 0.40186915887850466);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.40186915887850466, imageWidth * 0.26635514018691586, imageHeight * 0.6448598130841121, imageWidth * 0.26635514018691586, imageHeight * 0.6448598130841121);
        symbol.curveTo(imageWidth * 0.26635514018691586, imageHeight * 0.6588785046728972, imageWidth * 0.2757009345794392, imageHeight * 0.6728971962616822, imageWidth * 0.2897196261682243, imageHeight * 0.6728971962616822);
        symbol.curveTo(imageWidth * 0.2897196261682243, imageHeight * 0.6728971962616822, imageWidth * 0.7102803738317757, imageHeight * 0.6728971962616822, imageWidth * 0.7102803738317757, imageHeight * 0.6728971962616822);
        symbol.curveTo(imageWidth * 0.7242990654205608, imageHeight * 0.6728971962616822, imageWidth * 0.7336448598130841, imageHeight * 0.6588785046728972, imageWidth * 0.7336448598130841, imageHeight * 0.6448598130841121);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.6448598130841121, imageWidth * 0.7336448598130841, imageHeight * 0.40186915887850466, imageWidth * 0.7336448598130841, imageHeight * 0.40186915887850466);
        symbol.curveTo(imageWidth * 0.7336448598130841, imageHeight * 0.3878504672897196, imageWidth * 0.7242990654205608, imageHeight * 0.37850467289719625, imageWidth * 0.7102803738317757, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.7102803738317757, imageHeight * 0.37850467289719625, imageWidth * 0.6728971962616822, imageHeight * 0.37850467289719625, imageWidth * 0.6728971962616822, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.6728971962616822, imageHeight * 0.37850467289719625, imageWidth * 0.6728971962616822, imageHeight * 0.35514018691588783, imageWidth * 0.6728971962616822, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.6728971962616822, imageHeight * 0.3411214953271028, imageWidth * 0.6588785046728972, imageHeight * 0.3317757009345794, imageWidth * 0.6448598130841121, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.6448598130841121, imageHeight * 0.3317757009345794, imageWidth * 0.6121495327102804, imageHeight * 0.3317757009345794, imageWidth * 0.6121495327102804, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.5981308411214953, imageHeight * 0.3317757009345794, imageWidth * 0.5841121495327103, imageHeight * 0.3411214953271028, imageWidth * 0.5841121495327103, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.5841121495327103, imageHeight * 0.35514018691588783, imageWidth * 0.5841121495327103, imageHeight * 0.37850467289719625, imageWidth * 0.5841121495327103, imageHeight * 0.37850467289719625);
        symbol.lineTo(imageWidth * 0.4158878504672897, imageHeight * 0.37850467289719625);
        symbol.curveTo(imageWidth * 0.4158878504672897, imageHeight * 0.37850467289719625, imageWidth * 0.4158878504672897, imageHeight * 0.35514018691588783, imageWidth * 0.4158878504672897, imageHeight * 0.35514018691588783);
        symbol.curveTo(imageWidth * 0.4158878504672897, imageHeight * 0.3411214953271028, imageWidth * 0.40186915887850466, imageHeight * 0.3317757009345794, imageWidth * 0.3878504672897196, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.3878504672897196, imageHeight * 0.3317757009345794, imageWidth * 0.35514018691588783, imageHeight * 0.3317757009345794, imageWidth * 0.35514018691588783, imageHeight * 0.3317757009345794);
        symbol.curveTo(imageWidth * 0.3411214953271028, imageHeight * 0.3317757009345794, imageWidth * 0.32710280373831774, imageHeight * 0.3411214953271028, imageWidth * 0.32710280373831774, imageHeight * 0.35514018691588783);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5747663551401869, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.5747663551401869, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.6121495327102804, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.6121495327102804, imageHeight * 0.5467289719626168);
        symbol.lineTo(imageWidth * 0.6214953271028038, imageHeight * 0.5467289719626168);
        symbol.lineTo(imageWidth * 0.6214953271028038, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.6588785046728972, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.6214953271028038, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.6214953271028038, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.6121495327102804, imageHeight * 0.46261682242990654);
        symbol.lineTo(imageWidth * 0.6121495327102804, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.5747663551401869, imageHeight * 0.5);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.32710280373831774, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.4158878504672897, imageHeight * 0.514018691588785);
        symbol.lineTo(imageWidth * 0.4158878504672897, imageHeight * 0.5);
        symbol.lineTo(imageWidth * 0.32710280373831774, imageHeight * 0.5);
        symbol.closePath();

        
    }
}
