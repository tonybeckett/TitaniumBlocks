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
package us.jaba.titaniumblocks.core.disabled.painters;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;

/**
 *
 * @author tbeckett
 */
public class LinearDisabledPainter extends DisabledPainter
{

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int IMAGE_WIDTH = (int) dimensions.getWidth();
        final int IMAGE_HEIGHT = (int) dimensions.getHeight();

        final double outerAreaCornerRadius;
        if (IMAGE_WIDTH >= IMAGE_HEIGHT)
        {
            outerAreaCornerRadius = IMAGE_HEIGHT * 0.05;
        } else
        {
            outerAreaCornerRadius = IMAGE_WIDTH * 0.05;
        }
        final java.awt.geom.RoundRectangle2D outerArea = new java.awt.geom.RoundRectangle2D.Double(0.0, 0.0, IMAGE_WIDTH, IMAGE_HEIGHT, outerAreaCornerRadius, outerAreaCornerRadius);
        final double mainAreaCornerRadius;
        if (IMAGE_WIDTH >= IMAGE_HEIGHT)
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getHeight() - IMAGE_HEIGHT - 2) / 2.0);
        } else
        {
            mainAreaCornerRadius = outerAreaCornerRadius - ((outerArea.getWidth() - IMAGE_WIDTH - 2) / 2.0);
        }
        final java.awt.geom.RoundRectangle2D mainArea = new java.awt.geom.RoundRectangle2D.Double(1.0, 1.0, IMAGE_WIDTH - 2, IMAGE_HEIGHT - 2, mainAreaCornerRadius, mainAreaCornerRadius);

        final double innerAreaCornerRadius;
        if (IMAGE_WIDTH >= IMAGE_HEIGHT)
        {
            innerAreaCornerRadius = IMAGE_HEIGHT * 0.02857143;
        } else
        {
            innerAreaCornerRadius = IMAGE_WIDTH * 0.02857143;
        }

        final java.awt.geom.RoundRectangle2D innerArea = new java.awt.geom.RoundRectangle2D.Double(mainArea.getX() + 16, mainArea.getY() + 16, mainArea.getWidth() - 32, mainArea.getHeight() - 32, innerAreaCornerRadius, innerAreaCornerRadius);

        final double BACKGROUND_CORNER_RADIUS = innerAreaCornerRadius - 1;

        final java.awt.geom.RoundRectangle2D BACKGROUND = new java.awt.geom.RoundRectangle2D.Double(innerArea.getX() + 1, innerArea.getY() + 1, innerArea.getWidth() - 2, innerArea.getHeight() - 2, BACKGROUND_CORNER_RADIUS, BACKGROUND_CORNER_RADIUS);

        graphics.setColor(disabledColor);
        graphics.fill(BACKGROUND);

       
    }

}
