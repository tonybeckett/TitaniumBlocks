package us.jaba.titaniumblocks.core.glow.painters;

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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.glow.AbstractRadialKnobGlowPainter;

/**
 *
 * @author tbeckett
 */
public class RadialType1GlowPainter extends AbstractRadialKnobGlowPainter
{

    @Override
    public void paintGlow(final Graphics2D graphics, final Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();
        final Ellipse2D POST_GLOW = new Ellipse2D.Double();
        final Point2D POST_GLOW_START = new Point2D.Double();
        final Point2D POST_GLOW_STOP = new Point2D.Double();

        Paint postGlowGradient;

        final Ellipse2D CENTER_GLOW = new Ellipse2D.Double();
        final Point2D CENTER_GLOW_CENTER = new Point2D.Double();

        Paint centerGlowGradient;

        // min knob
        POST_GLOW.setFrame(imageWidth * 0.13084112107753754, imageHeight * 0.514018714427948, imageWidth * 0.0373831776, imageWidth * 0.0373831776);
        POST_GLOW_START.setLocation(POST_GLOW.getMaxX(), POST_GLOW.getCenterY());
        POST_GLOW_STOP.setLocation(POST_GLOW.getMinX(), POST_GLOW.getCenterY());
        postGlowGradient = new LinearGradientPaint(POST_GLOW_START, POST_GLOW_STOP, POST_GLOW_FRACTIONS, POST_GLOW_COLORS);
        graphics.setPaint(postGlowGradient);
        graphics.fill(POST_GLOW);

        // max knob
        POST_GLOW.setFrame(imageWidth * 0.5233644843101501, imageHeight * 0.13084112107753754, imageWidth * 0.0373831776, imageWidth * 0.0373831776);
        POST_GLOW_START.setLocation(POST_GLOW.getCenterX(), POST_GLOW.getMaxY());
        POST_GLOW_STOP.setLocation(POST_GLOW.getCenterX(), POST_GLOW.getMinY());
        postGlowGradient = new LinearGradientPaint(POST_GLOW_START, POST_GLOW_STOP, POST_GLOW_FRACTIONS, POST_GLOW_COLORS);
        graphics.setPaint(postGlowGradient);
        graphics.fill(POST_GLOW);

        // center knob
        CENTER_GLOW.setFrame(imageWidth * 0.4579439252, imageWidth * 0.4579439252, imageWidth * 0.0841121495, imageWidth * 0.0841121495);
        CENTER_GLOW_CENTER.setLocation(CENTER_GLOW.getCenterX(), CENTER_GLOW.getCenterY());
        centerGlowGradient = new RadialGradientPaint(CENTER_GLOW_CENTER, (float) (CENTER_GLOW.getWidth() / 2.0), CENTER_GLOW_FRACTIONS, CENTER_GLOW_COLORS);
        graphics.setPaint(centerGlowGradient);
        graphics.fill(CENTER_GLOW);

    }
}


