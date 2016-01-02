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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.CoreImageFactory;
import us.jaba.titaniumblocks.core.image.ImageSupport;
import us.jaba.titaniumblocks.core.knobs.KnobImageFactory;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.math.Polar;

/**
 *
 * @author tbeckett
 */
public class PositionedSmallPostFactory extends CoreImageFactory
{
    public static final double DEFAULT_SIZE_ADJUST = 0.03738316893577576;
    KnobImageFactory knobImageFactory;
    Point2D copyPoint;
    private double sizeAdjust = DEFAULT_SIZE_ADJUST;
    
    public PositionedSmallPostFactory(KnobImageFactory iFactory, Point2D centerPoint)
    {
        knobImageFactory = iFactory;
        this.copyPoint = centerPoint;
       
    }

    public void setSizeAdjust(double sizeAdjust)
    {
        this.sizeAdjust = sizeAdjust;
    }

    @Override
    protected void applyPaint(BufferedImage result, Dimension dimensions)
    {
        BufferedImage image = knobImageFactory.build(new Dimension((int) (dimensions.width * sizeAdjust), (int) (dimensions.width * sizeAdjust)));
        Graphics2D graphics = result.createGraphics();

        Point2D targetPoint = new Point2D.Double((dimensions.width * copyPoint.getX()), (dimensions.height * copyPoint.getY()) );
        
         Polar p = CoordinateUtils.toPolarWithCenter(targetPoint, new Point2D.Double(result.getWidth()/2.0, result.getHeight()/2.0));
        
        graphics.drawImage(image, (int) (dimensions.width * copyPoint.getX()), (int) (dimensions.height * copyPoint.getY()), null);
    }

    @Override
    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.defaultSmallImage;
        }

        BufferedImage mresult = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

        applyPaint(mresult, dimensions);

        return mresult;
    }
}
