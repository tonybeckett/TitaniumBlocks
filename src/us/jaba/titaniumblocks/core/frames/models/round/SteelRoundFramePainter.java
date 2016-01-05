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
import java.awt.Paint;
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
public class SteelRoundFramePainter extends RoundFrameModel
{

    /**
     * Creates the frame image for a radial gauge. The image parameters and the
     * image will be cached. If the current request has the same parameters as
     * the last request it will return the already created image instead of
     * creating a new image. If an image is passed to the method, it will paint
     * to the image and return this image. This will reduce the memory
     * consumption.
     *
     * @param WIDTH
     * @param FRAME_DESIGN
     * @param CUSTOM_FRAME_DESIGN
     * @param FRAME_BASECOLOR
     * @param FRAME_BASECOLOR_ENABLED
     * @param FRAME_EFFECT
     * @param BACKGROUND_IMAGE
     * @return a buffered image that contains the frame image for a radial gauge
     */
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
        
        float[] frameMainFractions5 =
        {
            0.0f,
            0.05f,
            0.10f,
            0.50f,
            0.90f,
            0.95f,
            1.0f
        };
        
        Color[] frameMainColors5 =
        {
            new Color(231, 237, 237, 255),
            new Color(189, 199, 198, 255),
            new Color(192, 201, 200, 255),
            new Color(23, 31, 33, 255),
            new Color(196, 205, 204, 255),
            new Color(194, 204, 203, 255),
            new Color(189, 201, 199, 255)
        };
        PointSupport.validateGradientPoints(FRAME_MAIN_START, FRAME_MAIN_STOP);
        Paint frameMainPaint5 = new LinearGradientPaint(FRAME_MAIN_START, FRAME_MAIN_STOP, frameMainFractions5, frameMainColors5);
        graphics.setPaint(frameMainPaint5);
        graphics.fill(FRAME_MAIN);

        //final Ellipse2D FRAME_INNERFRAME = new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948);
        final Area FRAME_INNERFRAME = new Area(new Ellipse2D.Double(imageWidth * 0.07943925261497498, imageHeight * 0.07943925261497498, imageWidth * 0.8411215543746948, imageHeight * 0.8411215543746948));
        FRAME_INNERFRAME.subtract(SUBTRACT);

        // Former white ring
        graphics.setPaint(innerFrameColor);
        graphics.fill(FRAME_INNERFRAME);

        // Frame effect overlay
        final Point2D EFFECT_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        final float[] EFFECT_FRACTIONS;
        final Color[] EFFECT_COLORS;
        final java.awt.Paint EFFECT_GRADIENT;
        
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