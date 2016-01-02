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
package us.jaba.titaniumblocks.core.gradients;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author tbeckett
 */
public class GradientSupport
{
    public static void fillLinearYAxisRect(final Graphics2D graphics2D, Rectangle2D rect, float[] frac, Color[] colors)
    {
        fillLinearYAxis(graphics2D, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), frac, colors);
    }

    public static void fillLinearYAxis(final Graphics2D graphics2D, final double w, final double h, final double a, final double b, float[] frac, Color[] colors)
    {
        final Rectangle2D rectangle2D = new Rectangle2D.Double(w, h, a, b);
        
        final Point2D startPoint = new Point2D.Double(0, rectangle2D.getBounds2D().getMinY());
        final Point2D stopPoint = new Point2D.Double(0, rectangle2D.getBounds2D().getMaxY());
        final LinearGradientPaint lgPaint = new LinearGradientPaint(startPoint, stopPoint, frac, colors);
        
        graphics2D.setPaint(lgPaint);
        graphics2D.fill(rectangle2D);
    }
}
