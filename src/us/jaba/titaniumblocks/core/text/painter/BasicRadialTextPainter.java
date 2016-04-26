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
package us.jaba.titaniumblocks.core.text.painter;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.text.TextSupport;

/**
 *
 * @author tbeckett
 */
public class BasicRadialTextPainter
{

    protected double adjustAngle(double angle)
    {
        return angle;
    }

    protected double adjustToRadians(double a)
    {
        return CoordinateUtils.toRadians(CoordinateUtils.normalizeDegrees(CoordinateUtils.adjustToNativeAngle(a)));
    }

    public void paint(Graphics2D graphics, Point2D center, double radius, double startAngle, double angleStep, String[] text)
    {
        int len = text.length;
        double currentAngle = startAngle;
        for (int i = 0; i < len; i++)
        {
            double gAngle = adjustToRadians(currentAngle - 270);
            Point2D.Double textPoint = CoordinateUtils.convertToGraphics2dPoint(center, radius, gAngle);
            TextSupport.rotateTextAroundCenter(graphics, text[i], textPoint.getX(), textPoint.getY(), adjustAngle(gAngle));
            System.out.println(String.format(" %s %f %f", text[i], gAngle, adjustAngle(gAngle)));
            currentAngle = currentAngle + angleStep;
        }
    }

}
