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
package us.jaba.titaniumblocks.core.areas.types.round;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.areas.RadialArea;
import static us.jaba.titaniumblocks.core.shape.ShapeUtils.placeAnArcOnRadius;

/**
 *
 * @author tbeckett
 */
public class BasicRadialArea extends RadialArea
{

    private float opacity = 0.35f;

    public BasicRadialArea(double startAngle, double stopAngle, Color color,  double outerRadius)
    {
        super(startAngle, stopAngle, color, outerRadius);
    }

    public float getOpacity()
    {
        return opacity;
    }

    public void setOpacity(float opacity)
    {
        this.opacity = opacity;
    }

    @Override
    protected void paintSection(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setColor(this.getColor());
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Point2D center = new Point2D.Double(dimensions.width / 2.0, dimensions.height / 2.0);
        double radius = (dimensions.getWidth() / 2.0);

        placeAnArcOnRadius(graphics, center, 0.0, outerRadius * radius, startAngle, stopAngle);

        super.paintSection(graphics, dimensions);
    }

}
