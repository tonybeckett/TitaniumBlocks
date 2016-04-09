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
package us.jaba.titaniumblocks.core.posts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import us.jaba.titaniumblocks.core.CoreBean;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class Post extends CoreBean implements Serializable
{

    protected Scale size = new Scale(0.5f);
    protected Color color;

    /**
     * Get the value of size
     *
     * @return the value of size
     */
    public Scale getSize()
    {
        return size;
    }

    /**
     * Set the value of size
     *
     * @param size new value of size
     */
    public void setSize(Scale size)
    {
        this.size = size;
        changed();
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
        changed();
    }

    protected void paintCircle(Graphics2D graphics, Dimension dimensions, double radius, float[] fractions, Color[] colors)
    {
        final double centerX = dimensions.getWidth() / 2.0;
        final double centerY = dimensions.getHeight() / 2.0;
        final Ellipse2D circle = (Ellipse2D) ShapeUtils.getCircle(centerX, centerY, radius);
        final Point2D start = new Point2D.Double(0, circle.getBounds2D().getMinY());
        final Point2D stop = new Point2D.Double(0, circle.getBounds2D().getMaxY());
        PointSupport.validateGradientPoints(start, stop);
        final LinearGradientPaint gradient = new LinearGradientPaint(start, stop, fractions, colors);
        graphics.setPaint(gradient);
        graphics.fill(circle);
    }

}
