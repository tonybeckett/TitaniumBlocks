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
package us.jaba.titaniumblocks.core.frames.models.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrameModel;
import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;

/**
 *
 * @author tbeckett
 */
public class ChromeRadialFramePainter extends RoundFrameModel
{

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
//    public BufferedImage createRadialFrame(final int WIDTH, final FrameDesign FRAME_DESIGN, final Paint CUSTOM_FRAME_DESIGN, final Color FRAME_BASECOLOR, final boolean FRAME_BASECOLOR_ENABLED, final FrameEffect FRAME_EFFECT, final BufferedImage BACKGROUND_IMAGE)
        super.paint(graphics, dimensions);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        // Shape that will be subtracted from the ellipse and will be filled by the background image later
        final Area SUBTRACT = new Area(new Ellipse2D.Double(imageWidth * 0.08411215245723724, imageHeight * 0.08411215245723724, imageWidth * 0.8317756652832031, imageHeight * 0.8317756652832031));

        final Area FRAME_OUTERFRAME = new Area(new Ellipse2D.Double(0.0, 0.0, imageWidth, imageHeight));
        FRAME_OUTERFRAME.subtract(SUBTRACT);
        graphics.setPaint(outerFrameColor);
        graphics.fill(FRAME_OUTERFRAME);

        final Area FRAME_MAIN = new Area(new Ellipse2D.Double(imageWidth * 0.004672897048294544, imageHeight * 0.004672897048294544, imageWidth * 0.9906542301177979, imageHeight * 0.9906542301177979));
        FRAME_MAIN.subtract(SUBTRACT);
        final Point2D FRAME_MAIN_START = new Point2D.Double(0, FRAME_MAIN.getBounds2D().getMinY());
        final Point2D FRAME_MAIN_STOP = new Point2D.Double(0, FRAME_MAIN.getBounds2D().getMaxY());
        final Point2D FRAME_MAIN_CENTER = new Point2D.Double(FRAME_MAIN.getBounds2D().getCenterX(), FRAME_MAIN.getBounds2D().getCenterY());

        float[] frameMainFractions6 =
        {
            0.0f,
            0.09f,
            0.12f,
            0.16f,
            0.25f,
            0.29f,
            0.33f,
            0.38f,
            0.48f,
            0.52f,
            0.63f,
            0.68f,
            0.8f,
            0.83f,
            0.87f,
            0.97f,
            1.0f
        };

        Color[] frameMainColors6 =
        {
            new Color(255, 255, 255, 255),
            new Color(255, 255, 255, 255),
            new Color(136, 136, 138, 255),
            new Color(164, 185, 190, 255),
            new Color(158, 179, 182, 255),
            new Color(112, 112, 112, 255),
            new Color(221, 227, 227, 255),
            new Color(155, 176, 179, 255),
            new Color(156, 176, 177, 255),
            new Color(254, 255, 255, 255),
            new Color(255, 255, 255, 255),
            new Color(156, 180, 180, 255),
            new Color(198, 209, 211, 255),
            new Color(246, 248, 247, 255),
            new Color(204, 216, 216, 255),
            new Color(164, 188, 190, 255),
            new Color(255, 255, 255, 255)
        };

        Paint frameMainPaint6 = new ConicalGradientPaint(false, FRAME_MAIN_CENTER, 0, frameMainFractions6, frameMainColors6);
        graphics.setPaint(frameMainPaint6);
        graphics.fill(FRAME_MAIN);

        //final Ellipse2D FRAME_INNERFRAME = new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948);
        final Area FRAME_INNERFRAME = new Area(new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948));
        FRAME_INNERFRAME.subtract(SUBTRACT);

        // Former white ring
        graphics.setPaint(innerFrameColor);
        graphics.fill(FRAME_INNERFRAME);

        // Frame effect overlay
        final Point2D EFFECT_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        this.getEffect().paint(graphics, dimensions, FRAME_OUTERFRAME, EFFECT_CENTER);

        graphics.dispose();

//        if (BACKGROUND_IMAGE != null)
//        {
//            final Graphics2D G = BACKGROUND_IMAGE.createGraphics();
//            G.drawImage(radFrameImage, 0, 0, null);
//            G.dispose();
//        }
    }

}
