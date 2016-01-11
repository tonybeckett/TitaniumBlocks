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
// */
package us.jaba.titaniumblocks.core.frames;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author tbeckett
 */
public class RoundFramePainter extends FrameModel
{


    private static final double DEFAULT_MAIN_WIDTH_MULTIPLIER = 0.99065;
    private static final double DEFAULT_MAIN_HEIGHT_MULTIPLIER = 0.99065;
    private static final double DEFAULT_MAIN_X_MULTIPLER = 0.004672;
    private static final double DEFAULT_MAIN_Y_MULTIPLER = 0.004672;

    private static final double DEFAULT_INNER_WIDTH_MULTIPLIER = 0.84112;
    private static final double DEFAULT_INNER_HEIGHT_MULTIPLIER = 0.84112;
    private static final double DEFAULT_INNER_X_MULTIPLER = 0.07943;
    private static final double DEFAULT_INNER_Y_MULTIPLER = 0.07943;

    private static final double DEFAULT_SUBTRACT_WIDTH_MULTIPLIER = 0.83177;
    private static final double DEFAULT_SUBTRACT_HEIGHT_MULTIPLIER = 0.83177;
    private static final double DEFAULT_SUBTRACT_X_MULTIPLER = 0.084112;
    private static final double DEFAULT_SUBTRACT_Y_MULTIPLER = 0.084112;

    private static final double DEFAULT_OUTER_WIDTH_MULTIPLIER = 1.0;
    private static final double DEFAULT_OUTER_HEIGHT_MULTIPLIER = 1.0;
    private static final double DEFAULT_OUTER_X_MULTIPLER = 0.0;
    private static final double DEFAULT_OUTER_Y_MULTIPLER = 0.0;

    public static final int DEFAULT_FRAME_THICKNESS = 5; // DEFAULT_SUBTRACT_X_MULTIPLER - DEFAULT_INNER_X_MULTIPLER * 100.0

    protected int frameThickness = DEFAULT_FRAME_THICKNESS;
    
    protected Dimension interiorDimension = new Dimension(1, 1);

    
    protected Rectangle2D innerMultiRect;
    protected Rectangle2D mainMultiRect;
    protected Rectangle2D outerMultiRect;
    protected Rectangle2D subtractMultiRect;

    public RoundFramePainter()
    {
        innerMultiRect = new Rectangle2D.Double(DEFAULT_INNER_X_MULTIPLER, DEFAULT_INNER_Y_MULTIPLER, DEFAULT_INNER_WIDTH_MULTIPLIER, DEFAULT_INNER_HEIGHT_MULTIPLIER);
        mainMultiRect = new Rectangle2D.Double(DEFAULT_MAIN_X_MULTIPLER, DEFAULT_MAIN_Y_MULTIPLER, DEFAULT_MAIN_WIDTH_MULTIPLIER, DEFAULT_MAIN_HEIGHT_MULTIPLIER);
        outerMultiRect = new Rectangle2D.Double(DEFAULT_OUTER_X_MULTIPLER, DEFAULT_OUTER_Y_MULTIPLER, DEFAULT_OUTER_WIDTH_MULTIPLIER, DEFAULT_OUTER_HEIGHT_MULTIPLIER);
        subtractMultiRect = new Rectangle2D.Double(DEFAULT_SUBTRACT_X_MULTIPLER, DEFAULT_SUBTRACT_Y_MULTIPLER, DEFAULT_SUBTRACT_WIDTH_MULTIPLIER, DEFAULT_SUBTRACT_HEIGHT_MULTIPLIER);
    }

    public Dimension getInteriorDimension()
    {
        return interiorDimension;
    }

    public int getFrameThickness()
    {
        return frameThickness;
    }

    public void setFrameThickness(int frameThickness)
    {
        this.frameThickness = frameThickness;
        changed();
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        final Area innerArea = new Area(new Ellipse2D.Double(imageWidth * innerMultiRect.getX(), imageHeight * innerMultiRect.getY(),
                imageWidth * innerMultiRect.getWidth(), imageHeight * innerMultiRect.getHeight()));

        final Area outerArea = new Area(new Ellipse2D.Double(0.0, 0.0, imageWidth * outerMultiRect.getWidth(), 
                imageHeight * outerMultiRect.getHeight()));

        final Area mainArea = new Area(new Ellipse2D.Double(imageWidth * mainMultiRect.getX(), imageHeight * outerMultiRect.getY(),
                imageWidth * mainMultiRect.getWidth(), imageHeight * mainMultiRect.getHeight()));

        final Area subtractArea = new Area(new Ellipse2D.Double(imageWidth * subtractMultiRect.getX(), imageHeight * subtractMultiRect.getY(),
                imageWidth * subtractMultiRect.getWidth(), imageHeight * subtractMultiRect.getHeight()));

        paintFrame(graphics, dimensions, mainArea, outerArea, innerArea, subtractArea);
    }

//    public RectangularFrameEffectPainter getLinearEffect()
//    {
//        return linearEffect;
//    }
//
//    public void setLinearEffect(RectangularFrameEffectPainter linearEffect)
//    {
//        this.linearEffect = linearEffect;
//        changed();
//    }
//    public Paint getInnerFrameColor()
//    {
//        return innerFrameColor;
//    }
//
//    public Paint getOuterFrameColor()
//    {
//        return outerFrameColor;
//    }
//
//    public void setInnerFrameColor(Paint innerFrameColor)
//    {
//        this.innerFrameColor = innerFrameColor;
//        changed();
//    }
//
//    public void setOuterFrameColor(Paint outerFrameColor)
//    {
//        this.outerFrameColor = outerFrameColor;
//        changed();
//    }
    protected void paintFrame(Graphics2D graphics, Dimension dimensions, Area mainArea, Area outerArea, Area innerArea, Area subtractArea)
    {

    }

}
