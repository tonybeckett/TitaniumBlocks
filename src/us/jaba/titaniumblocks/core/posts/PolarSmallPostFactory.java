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
public class PolarSmallPostFactory extends CoreImageFactory
{

    public static final double DEFAULT_SIZE_ADJUST = 0.03738316893577576;
    private KnobImageFactory knobImageFactory;
    private Polar postPosition;
    private double sizeAdjust = DEFAULT_SIZE_ADJUST;

    public PolarSmallPostFactory(KnobImageFactory iFactory, Polar unityPosition)
    {
        knobImageFactory = iFactory;
        this.postPosition = unityPosition;

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

        Point2D.Double resultCenterPoint = new Point2D.Double(result.getWidth() / 2.0, result.getHeight() / 2.0);

        Point2D rcp = CoordinateUtils.toPoint2DFromCenter(resultCenterPoint, postPosition);

//        Polar p = CoordinateUtils.toPolar(rcp);
        graphics.drawImage(image, (int) (rcp.getX() - (image.getWidth() / 2)), (int) (rcp.getY() - (image.getHeight() / 2)), null);
    }

    @Override
    public BufferedImage build(Dimension dimensions)
    {
        if (!ImageSupport.isValidSize(dimensions.width, dimensions.height))
        {
            return ImageSupport.DEFAULT_SMALL_IMAGE;
        }

        BufferedImage mresult = ImageSupport.createImage(dimensions, Transparency.TRANSLUCENT);

        applyPaint(mresult, dimensions);

        return mresult;
    }
}
