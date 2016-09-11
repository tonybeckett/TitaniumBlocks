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
package us.jaba.titaniumblocks.core.tickmarks.ticks.types.radial;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.tickmarks.ticks.RadialTickModel;

/**
 *
 * @author tbeckett
 */
public class RadialTriangleTicks extends RadialTickModel
{

    private final Point2D outerPoint_LEFT;
    private final Point2D outerPoint_RIGHT;
    private double TICK_LENGTH = 1.0;

    public RadialTriangleTicks()
    {
        this.outerPoint_LEFT = new Point2D.Double();
        this.outerPoint_RIGHT = new Point2D.Double();

    }

    public RadialTriangleTicks(Point2D outerPoint_LEFT, Point2D outerPoint_RIGHT)
    {
        this.outerPoint_LEFT = outerPoint_LEFT;
        this.outerPoint_RIGHT = outerPoint_RIGHT;
    }

    @Override
    public void paintTicks(Graphics2D graphics, Shape shape, double diameter, Point2D inner, Point2D outer, Point2D center, double alpha)
    {
        final GeneralPath TICK_TRIANGLE = new GeneralPath();
        final double RADIUS = diameter / 2.0;

        outerPoint_LEFT.setLocation(center.getX() + RADIUS * Math.sin(alpha - Math.toRadians(Math.asin(TICK_LENGTH / 16.0))), center.getY() + RADIUS * Math.cos(alpha - Math.toRadians(Math.asin(TICK_LENGTH / 16.0))));
        outerPoint_RIGHT.setLocation(center.getX() + RADIUS * Math.sin(alpha + Math.toRadians(Math.asin(TICK_LENGTH / 16.0))), center.getY() + RADIUS * Math.cos(alpha + Math.toRadians(Math.asin(TICK_LENGTH / 16.0))));
        TICK_TRIANGLE.reset();
        TICK_TRIANGLE.moveTo(inner.getX(), inner.getY());
        TICK_TRIANGLE.lineTo(outerPoint_LEFT.getX(), outerPoint_LEFT.getY());
        TICK_TRIANGLE.lineTo(outerPoint_RIGHT.getX(), outerPoint_RIGHT.getY());
        TICK_TRIANGLE.closePath();
        graphics.fill(TICK_TRIANGLE);

    }

    public double getTICK_LENGTH()
    {
        return TICK_LENGTH;
    }

    public void setTICK_LENGTH(double TICK_LENGTH)
    {
        this.TICK_LENGTH = TICK_LENGTH;
        changed();
    }

}
