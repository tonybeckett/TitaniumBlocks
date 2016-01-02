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
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.RoundFrameModel;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class GlossyMetalRadialFramePainter extends RoundFrameModel
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

        graphics.setPaint(new RadialGradientPaint(new Point2D.Double(0.5 * imageWidth, 0.5 * imageHeight), imageWidth * 0.5f, new float[]
        {
            0.0f, 0.96f, 1.0f
        }, new Color[]
        {
            new Color(0.8117647059f, 0.8117647059f, 0.8117647059f, 1f), new Color(0.8039215686f, 0.8f, 0.8039215686f, 1f), new Color(0.9568627451f, 0.9568627451f, 0.9568627451f, 1f)
        }));
        graphics.fill(FRAME_MAIN);

        //final Area FRAME_MAIN_GLOSSY2 = new Area(new Ellipse2D.Double(0.018691588785046728 * imageWidth, 0.018691588785046728 * imageHeight, 0.9626168224299065 * imageWidth, 0.9626168224299065 * imageHeight));
        final Area FRAME_MAIN_GLOSSY2 = new Area(new Ellipse2D.Double(0.0140186916 * imageWidth, 0.0140186916 * imageHeight, 0.9719626168 * imageWidth, 0.9719626168 * imageHeight));
        FRAME_MAIN_GLOSSY2.subtract(SUBTRACT);
        if (PointSupport.pointsEquals(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY(), 0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY()))
        {
            graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY()), new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY() + 1), new float[]
            {
                0.0f, 0.23f, 0.36f, 0.59f, 0.76f, 1.0f
            }, new Color[]
            {
                new Color(0.9764705882f, 0.9764705882f, 0.9764705882f, 1f), new Color(0.7843137255f, 0.7647058824f, 0.7490196078f, 1f), Color.WHITE, new Color(0.1137254902f, 0.1137254902f, 0.1137254902f, 1f), new Color(0.7843137255f, 0.7607843137f, 0.7529411765f, 1f), new Color(0.8196078431f, 0.8196078431f, 0.8196078431f, 1f)
            }));
        } else
        {
            graphics.setPaint(new LinearGradientPaint(new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMinY()), new Point2D.Double(0, FRAME_MAIN_GLOSSY2.getBounds2D().getMaxY()), new float[]
            {
                0.0f, 0.23f, 0.36f, 0.59f, 0.76f, 1.0f
            }, new Color[]
            {
                new Color(0.9764705882f, 0.9764705882f, 0.9764705882f, 1f), new Color(0.7843137255f, 0.7647058824f, 0.7490196078f, 1f), Color.WHITE, new Color(0.1137254902f, 0.1137254902f, 0.1137254902f, 1f), new Color(0.7843137255f, 0.7607843137f, 0.7529411765f, 1f), new Color(0.8196078431f, 0.8196078431f, 0.8196078431f, 1f)
            }));
        }
        graphics.fill(FRAME_MAIN_GLOSSY2);

        final Area FRAME_MAIN_GLOSSY3 = new Area(new Ellipse2D.Double(0.06542056074766354 * imageWidth, 0.06542056074766354 * imageHeight, 0.8691588785046729 * imageWidth, 0.8691588785046729 * imageHeight));
        FRAME_MAIN_GLOSSY3.subtract(SUBTRACT);
        graphics.setColor(new Color(0xf6f6f6));
        graphics.fill(FRAME_MAIN_GLOSSY3);

        final Area FRAME_MAIN_GLOSSY4 = new Area(new Ellipse2D.Double(FRAME_MAIN_GLOSSY3.getBounds2D().getMinX() + 2, FRAME_MAIN_GLOSSY3.getBounds2D().getMinY() + 2, FRAME_MAIN_GLOSSY3.getBounds2D().getWidth() - 4, FRAME_MAIN_GLOSSY3.getBounds2D().getHeight() - 4));
        FRAME_MAIN_GLOSSY4.subtract(SUBTRACT);
        graphics.setColor(new Color(0x333333));
        graphics.fill(FRAME_MAIN_GLOSSY4);

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