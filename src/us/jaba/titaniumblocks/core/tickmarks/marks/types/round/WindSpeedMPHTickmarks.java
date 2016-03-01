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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.round;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import us.jaba.titaniumblocks.core.shape.ShapeUtils;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;

public class WindSpeedMPHTickmarks extends AbstractRadialTickmark
{

    protected String[] arrayOfTextMPH =
    {
        "0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140"
    };

    protected String[] arrayOfLabels =
    {
        "BREEZE", "GALE", "STORM",
    };

    protected String[] arrayOfEFs =
    {
        "EF0", "EF1", "EF2",
    };

    protected String[] windspeed =
    {
        "WindSpeed"
    };

    protected String[] mph =
    {
        "MPH"
    };

    public WindSpeedMPHTickmarks()
    {

        mediumStroke = majorStroke;
        majorStroke = new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
    }

    @Override
    public void subPaint(Graphics2D graphics, Dimension dimensions)
    {

        final float radius = (float) (dimensions.getWidth() * 0.485f);

        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (0.04 * dimensions.getWidth())));

        graphics.setColor(textColor);

        double mphAngleStep = 320.0 / arrayOfTextMPH.length;
        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.55, 210.0, mphAngleStep, arrayOfTextMPH);

        ShapeUtils.placeTextOnRadius(graphics, centerPoint, radius * 0.75, 180.0, 0.0, windspeed);

        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (0.065 * dimensions.getWidth() * 0.75)));

        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.85, 250.0, 40, arrayOfLabels);
        graphics.setFont(font.deriveFont(Font.PLAIN, (float) (0.05 * dimensions.getWidth() * 0.75)));
        ShapeUtils.placeTextOnRadius(graphics, centerPoint, radius * 0.55, 180.0, 0.0, mph);

        ShapeUtils.placeTextOnRadiusRotateIn(graphics, centerPoint, radius * 0.85, 10.0, 47, arrayOfEFs);

        graphics.setColor(mediumColor);
        graphics.setStroke(mediumStroke);

        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.675, radius * 0.75, 210.0, mphAngleStep / 5.0, (arrayOfTextMPH.length - 1) * 5);

        graphics.setColor(majorColor);
        graphics.setStroke(majorStroke);
        ShapeUtils.drawRadialLines(graphics, centerPoint, radius * 0.615, radius * 0.75, 210.0, mphAngleStep, arrayOfTextMPH.length);

        // tbd angles for these are being calculate wrong
        ShapeUtils.placeLineArcOnRadius(graphics, centerPoint, radius * 0.675, 208.5, 148.5);
        ShapeUtils.placeLineArcOnRadius(graphics, centerPoint, radius * 0.75, 209, 148.5);

        graphics.dispose();

    }

}
