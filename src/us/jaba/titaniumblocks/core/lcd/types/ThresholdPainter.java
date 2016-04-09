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
package us.jaba.titaniumblocks.core.lcd.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import us.jaba.titaniumblocks.core.CoreBean;

/**
 *
 * @author tbeckett
 */
public class ThresholdPainter extends CoreBean
{

    private Color color;

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final int IMAGE_WIDTH = (int) dimensions.getWidth();
        final int IMAGE_HEIGHT = (int) dimensions.getHeight();

        final GeneralPath LCD_THRESHOLD = new GeneralPath();
        LCD_THRESHOLD.setWindingRule(Path2D.WIND_EVEN_ODD);
        LCD_THRESHOLD.moveTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.7777777777777778);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.5555555555555556, IMAGE_HEIGHT * 0.7777777777777778);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.5555555555555556, IMAGE_HEIGHT * 0.8888888888888888);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.8888888888888888);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.7777777777777778);
        LCD_THRESHOLD.closePath();
        LCD_THRESHOLD.moveTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.3333333333333333);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.5555555555555556, IMAGE_HEIGHT * 0.3333333333333333);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.5555555555555556, IMAGE_HEIGHT * 0.7222222222222222);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.7222222222222222);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.4444444444444444, IMAGE_HEIGHT * 0.3333333333333333);
        LCD_THRESHOLD.closePath();
        LCD_THRESHOLD.moveTo(0.0, IMAGE_HEIGHT);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH, IMAGE_HEIGHT);
        LCD_THRESHOLD.lineTo(IMAGE_WIDTH * 0.5, 0.0);
        LCD_THRESHOLD.lineTo(0.0, IMAGE_HEIGHT);
        LCD_THRESHOLD.closePath();
        graphics.setColor(color);
        graphics.fill(LCD_THRESHOLD);
    }
}
