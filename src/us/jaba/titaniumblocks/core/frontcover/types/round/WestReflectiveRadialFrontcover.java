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
package us.jaba.titaniumblocks.core.frontcover.types.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frontcover.types.AbstractRadialFrontcover;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class WestReflectiveRadialFrontcover extends AbstractRadialFrontcover
{

    private void curveTo(GeneralPath path, Point2D center, Dimension dimensions, double radius, double angle0, double angle1, double angle2)
    {
        final double imageWidth = dimensions.getWidth();
        final double imageHeight = dimensions.getHeight();

        Point2D point1 = CoordinateUtils.calcPosition(center, radius, angle0);
        Point2D point2 = CoordinateUtils.calcPosition(center, radius, angle1);
        Point2D point3 = CoordinateUtils.calcPosition(center, radius, angle2);

        path.curveTo(point1.getX() * imageWidth, point1.getY() * imageHeight,
                point2.getX() * imageWidth, point2.getY() * imageHeight,
                point3.getX() * imageWidth, point3.getY() * imageHeight);
    }

    private void arcTo(GeneralPath path, Point2D center, Dimension dimensions, double radius, double startAngle, double endAngle, double angleDelta)
    {
        double angle = startAngle;

        if (startAngle > endAngle)
        {
            while (angle > endAngle)
            {
                curveTo(path, center, dimensions, radius, angle, angle + angleDelta, angle + angleDelta + angleDelta);
                angle = angle + angleDelta + angleDelta;
            }
        } else
        {
            while (angle < endAngle)
            {
                curveTo(path, center, dimensions, radius, angle, angle + angleDelta, angle + angleDelta + angleDelta);
                angle = angle + angleDelta + angleDelta;
            }
        }
    }

    @Override
    protected void apply(Graphics2D graphics, Dimension dimensions)
    {
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        final GeneralPath rightSidePath = new GeneralPath();
        final Point2D center = new Point2D.Double(0.5, 0.5);
        rightSidePath.setWindingRule(Path2D.WIND_EVEN_ODD);
//        rightSideArea.moveTo(imageWidth * 0.677570, imageHeight * 0.242990);

        Point2D point1 = CoordinateUtils.calcPosition(center, 0.5, 225.0);
        rightSidePath.moveTo(imageWidth * point1.getX(), imageHeight * point1.getY());

        arcTo(rightSidePath, center, dimensions, 0.5, 225.0, 35.0, -5.0);

        point1 = CoordinateUtils.calcPosition(center, 0.5, 35.0);
        Point2D point2 = CoordinateUtils.calcPosition(center, 0.45, 25.0);
        Point2D point3 = CoordinateUtils.calcPosition(center, 0.4, 35.0);

        rightSidePath.curveTo(imageWidth * point1.getX(), imageHeight * point1.getY(), imageWidth * point2.getX(), imageHeight * point2.getY(), imageWidth * point3.getX(), imageHeight * point3.getY());

        arcTo(rightSidePath, center, dimensions, 0.4, 35.0, 225.0, 5.0);

        point1 = CoordinateUtils.calcPosition(center, 0.4, 225.0);
        point2 = CoordinateUtils.calcPosition(center, 0.45, 235.0);
        point3 = CoordinateUtils.calcPosition(center, 0.5, 225.0);
        rightSidePath.curveTo(imageWidth * point1.getX(), imageHeight * point1.getY(), imageWidth * point2.getX(), imageHeight * point2.getY(), imageWidth * point3.getX(), imageHeight * point3.getY());

        rightSidePath.closePath();

        final Point2D HIGHLIGHT_CENTER = new Point2D.Double((0.5 * imageWidth), (0.5 * imageHeight));
        final float[] HIGHLIGHT_FRACTIONS_4_1 =
        {
            0.0f,
            0.82f,
            0.83f,
            1.0f
        };
        final Color[] HIGHLIGHT_COLORS_4_1 =
        {
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 0),
            new Color(255, 255, 255, 25)
        };
//        RadialGradientPaint HIGHLIGHT_GRADIENT = new RadialGradientPaint(HIGHLIGHT_CENTER, (float) (0.3878504672897196 * imageWidth), HIGHLIGHT_FRACTIONS_4_1, HIGHLIGHT_COLORS_4_1);
        RadialGradientPaint HIGHLIGHT_GRADIENT = new RadialGradientPaint(HIGHLIGHT_CENTER, (float) (0.485 * imageWidth), HIGHLIGHT_FRACTIONS_4_1, HIGHLIGHT_COLORS_4_1);
        graphics.setPaint(HIGHLIGHT_GRADIENT);
        graphics.fill(rightSidePath);

        final GeneralPath leftSidePath = new GeneralPath();
        leftSidePath.setWindingRule(Path2D.WIND_EVEN_ODD);

        point1 = CoordinateUtils.calcPosition(center, 0.5, 260.0);
        leftSidePath.moveTo(imageWidth * point1.getX(), imageHeight * point1.getY());

        arcTo(leftSidePath, center, dimensions, 0.5, 260.0, 300.0, 5.0);

        point1 = CoordinateUtils.calcPosition(center, 0.5, 300.0);
        point2 = CoordinateUtils.calcPosition(center, 0.45, 330.0);
        point3 = CoordinateUtils.calcPosition(center, 0.35, 300.0);

        leftSidePath.curveTo(imageWidth * point1.getX(), imageHeight * point1.getY(), imageWidth * point2.getX(), imageHeight * point2.getY(), imageWidth * point3.getX(), imageHeight * point3.getY());

        arcTo(leftSidePath, center, dimensions, 0.35, 300.0, 260.0, -5.0);

        point1 = CoordinateUtils.calcPosition(center, 0.35, 260.0);
        point2 = CoordinateUtils.calcPosition(center, 0.425, 250.0);
        point3 = CoordinateUtils.calcPosition(center, 0.5, 260.0);
        leftSidePath.curveTo(imageWidth * point1.getX(), imageHeight * point1.getY(), imageWidth * point2.getX(), imageHeight * point2.getY(), imageWidth * point3.getX(), imageHeight * point3.getY());

//        leftSizeArea.moveTo(imageWidth * 0.2616822429906542, imageHeight * 0.22429906542056074);
//        leftSizeArea.curveTo(imageWidth * 0.2850467289719626, imageHeight * 0.2383177570093458, imageWidth * 0.2523364485981308, imageHeight * 0.2850467289719626, imageWidth * 0.24299065420560748, imageHeight * 0.3177570093457944);
//        leftSizeArea.curveTo(imageWidth * 0.24299065420560748, imageHeight * 0.35046728971962615, imageWidth * 0.27102803738317754, imageHeight * 0.38317757009345793, imageWidth * 0.27102803738317754, imageHeight * 0.397196261682243);
//        leftSizeArea.curveTo(imageWidth * 0.2757009345794392, imageHeight * 0.4158878504672897, imageWidth * 0.2616822429906542, imageHeight * 0.45794392523364486, imageWidth * 0.2383177570093458, imageHeight * 0.5093457943925234);
//        leftSizeArea.curveTo(imageWidth * 0.22429906542056074, imageHeight * 0.5420560747663551, imageWidth * 0.17757009345794392, imageHeight * 0.6121495327102804, imageWidth * 0.1588785046728972, imageHeight * 0.6121495327102804);
//        leftSizeArea.curveTo(imageWidth * 0.14485981308411214, imageHeight * 0.6121495327102804, imageWidth * 0.08878504672897196, imageHeight * 0.5467289719626168, imageWidth * 0.1308411214953271, imageHeight * 0.3691588785046729);
//        leftSizeArea.curveTo(imageWidth * 0.14018691588785046, imageHeight * 0.3364485981308411, imageWidth * 0.21495327102803738, imageHeight * 0.20093457943925233, imageWidth * 0.2616822429906542, imageHeight * 0.22429906542056074);
        leftSidePath.closePath();
//        final Point2D HIGHLIGHT_4_START = new Point2D.Double((0.1308411214953271 * imageWidth), (0.3691588785046729 * imageHeight));
//        final Point2D HIGHLIGHT_4_STOP = new Point2D.Double(((0.1308411214953271 + 0.1429988420131642) * imageWidth), ((0.3691588785046729 + 0.04371913341648399) * imageHeight));
        point1 = CoordinateUtils.calcPosition(center, 0.5, 285.0);
        point2 = CoordinateUtils.calcPosition(center, 0.35, 280.0);
        final Point2D HIGHLIGHT_4_START = new Point2D.Double(imageWidth * point1.getX(), imageHeight * point1.getY());
        final Point2D HIGHLIGHT_4_STOP = new Point2D.Double(imageWidth * point2.getX(), imageHeight * point2.getY());
        final float[] HIGHLIGHT_FRACTIONS4_2 =
        {
            0.0f,
            1.0f
        };
        final Color[] HIGHLIGHT_FRACTIONS_4_2 =
        {
            new Color(255, 255, 255, 51),
            new Color(255, 255, 255, 0)
        };
        PointSupport.validateGradientPoints(HIGHLIGHT_4_START, HIGHLIGHT_4_STOP);
        final LinearGradientPaint HIGHLIGHT_GRADIENT_4_2 = new LinearGradientPaint(HIGHLIGHT_4_START, HIGHLIGHT_4_STOP, HIGHLIGHT_FRACTIONS4_2, HIGHLIGHT_FRACTIONS_4_2);
        graphics.setPaint(HIGHLIGHT_GRADIENT_4_2);
        graphics.fill(leftSidePath);
    }

}
