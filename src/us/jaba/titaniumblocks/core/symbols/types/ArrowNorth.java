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
public class ArrowNorth extends Symbol
{
    @Override
    protected void paintSymbol(GeneralPath symbol, Dimension dimensions)
    {
        int imageWidth = (int) dimensions.getWidth();
        int imageHeight = (int) dimensions.getHeight();

        
        symbol.setWindingRule(Path2D.WIND_EVEN_ODD);
        symbol.moveTo(0.616822429906542 * imageWidth, 0.6962616822429907 * imageHeight);
        symbol.lineTo(0.3878504672897196 * imageWidth, 0.6962616822429907 * imageHeight);
        symbol.lineTo(0.3878504672897196 * imageWidth, 0.5794392523364486 * imageHeight);
        symbol.lineTo(0.26635514018691586 * imageWidth, 0.5794392523364486 * imageHeight);
        symbol.lineTo(0.5046728971962616 * imageWidth, 0.3130841121495327 * imageHeight);
        symbol.lineTo(0.7336448598130841 * imageWidth, 0.5794392523364486 * imageHeight);
        symbol.lineTo(0.616822429906542 * imageWidth, 0.5794392523364486 * imageHeight);
        symbol.lineTo(0.616822429906542 * imageWidth, 0.6962616822429907 * imageHeight);
        symbol.closePath();

        
    }

}
