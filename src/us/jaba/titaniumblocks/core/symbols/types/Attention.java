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
public class Attention extends Symbol
{

    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {

        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

         
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(imageWidth * 0.6962616822429907, imageHeight * 0.6401869158878505);
        symbol.lineTo(imageWidth * 0.3037383177570093, imageHeight * 0.6401869158878505);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.2850467289719626);
        symbol.lineTo(imageWidth * 0.6962616822429907, imageHeight * 0.6401869158878505);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.7336448598130841, imageHeight * 0.6635514018691588);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.24299065420560748);
        symbol.lineTo(imageWidth * 0.26635514018691586, imageHeight * 0.6635514018691588);
        symbol.lineTo(imageWidth * 0.7336448598130841, imageHeight * 0.6635514018691588);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.5887850467289719, imageHeight * 0.5841121495327103);
        symbol.lineTo(imageWidth * 0.411214953271028, imageHeight * 0.5841121495327103);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.411214953271028);
        symbol.lineTo(imageWidth * 0.5887850467289719, imageHeight * 0.5841121495327103);
        symbol.closePath();
        symbol.moveTo(imageWidth * 0.6355140186915887, imageHeight * 0.6074766355140186);
        symbol.lineTo(imageWidth * 0.5, imageHeight * 0.3644859813084112);
        symbol.lineTo(imageWidth * 0.3644859813084112, imageHeight * 0.6074766355140186);
        symbol.lineTo(imageWidth * 0.6355140186915887, imageHeight * 0.6074766355140186);
        symbol.closePath();

        
    }

}
