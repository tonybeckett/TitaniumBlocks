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
package us.jaba.titaniumblocks.core.lcd.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;
import us.jaba.titaniumblocks.core.CoreModel;
import us.jaba.titaniumblocks.core.color.HSLColor;
import us.jaba.titaniumblocks.core.lcd.SixteenSegmentAlphabet;

/**
 *
 * @author tbeckett
 */
public class SixteenSegmentCharacter extends CoreModel
{

    private java.util.List<Integer> lightedSegments;
    public static final float POINT_REFERENCE_WIDTH = 32.0f;
    public static final float POINT_REFERENCE_HEIGHT = 46.0f;

    private final double INACTIVE_COLOR_DARKEN_FRACTION = 0.4;

    private Color activeSegmentColor = new Color(0xFF0000);
    private Color inactiveSegmentColor = darken(new Color(0xFF0000), INACTIVE_COLOR_DARKEN_FRACTION);

    public SixteenSegmentCharacter()
    {
        lightedSegments = new ArrayList();
    }

    public void setSegmentColor(Color segmentColor)
    {
        activeSegmentColor = segmentColor;
        inactiveSegmentColor = new HSLColor(segmentColor).adjustLuminance((float) 60.0);
    }

    public void setCharacter(char character)
    {
        setLightedSegments(SixteenSegmentAlphabet.MAP.get(character));
    }

    private void setLightedSegments(SixteenSegmentAlphabet character)
    {
        if (character != null && character.getSegments() != null)
        {
            this.lightedSegments = Arrays.asList(character.getSegments());
        } else
        {
            this.lightedSegments = new ArrayList(0);
        }

    }

    private Color darken(Color c, double fragment)
    {
        Double newRed = fragment * c.getRed();
        Double newBlue = fragment * c.getBlue();
        Double newGreen = fragment * c.getGreen();
        return new Color(newRed.intValue(), newGreen.intValue(), newBlue.intValue());
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        // left top to top middle
        paintSegment(graphics, lightedSegments.contains(1), getPoints(dimensions, "2,2;3,1;14,1;15,2;14,3;3,3;2,2"));
        // top middle to right top
        paintSegment(graphics, lightedSegments.contains(2), getPoints(dimensions, "15,2;16,1;27,1;28,2;27,3;16,3;15,2"));
        // left top to left middle
        paintSegment(graphics, lightedSegments.contains(3), getPoints(dimensions, "2,2;3,3;3,22;2,23;1,22;1,3;2,2"));
        // top left to middle middle
        paintSegment(graphics, lightedSegments.contains(4), getPoints(dimensions, "4,4;5,4;13,19;13,21;12,21;4,6;4,4"));
        // top middle to middle middle
        paintSegment(graphics, lightedSegments.contains(5), getPoints(dimensions, "15,2;14,3;14,22;15,23;16,22;16,3;15,2"));
        // top right to middle middle
        paintSegment(graphics, lightedSegments.contains(6), getPoints(dimensions, "25,4;26,4;26,6;18,21;17,21;17,19;25,4"));
        // top middle to right middle
        paintSegment(graphics, lightedSegments.contains(7), getPoints(dimensions, "28,2;29,3;29,22;28,23;27,22;27,3;28,2"));
        // left middle to middle middle
        paintSegment(graphics, lightedSegments.contains(8), getPoints(dimensions, "2,23;3,22;14,22;15,23;14,24;3,24;2,23"));
        // middle middle to right middle
        paintSegment(graphics, lightedSegments.contains(9), getPoints(dimensions, "15,23;16,22;27,22;28,23;27,24;16,24;15,23"));
        // left middle to bottom left
        paintSegment(graphics, lightedSegments.contains(10), getPoints(dimensions, "2,23;3,24;3,43;2,44;1,43;1,24;2,23"));
        // left bottom to middle middle
        paintSegment(graphics, lightedSegments.contains(11), getPoints(dimensions, "13,27;13,25;12,25;4,40;4,42;5,42;13,27"));
        // bottom middle to middle middle
        paintSegment(graphics, lightedSegments.contains(12), getPoints(dimensions, "15,23;16,24;16,43;15,44;14,43;14,24;15,23"));
        // bottom right to middle middle
        paintSegment(graphics, lightedSegments.contains(13), getPoints(dimensions, "17,25;18,25;26,40;26,42;25,42;17,27;17,25"));
        // right middle to bottom right
        paintSegment(graphics, lightedSegments.contains(14), getPoints(dimensions, "28,23;29,24;29,43;28,44;27,43;27,24;28,23"));
        // bottpm left to bottom middle
        paintSegment(graphics, lightedSegments.contains(15), getPoints(dimensions, "2,44;3,43;14,43;15,4;14,45;3,45;2,44"));
        // bottom middle to bottom right
        paintSegment(graphics, lightedSegments.contains(16), getPoints(dimensions, "15,244;16,43;27,43;28,44;27,45;16,45;15,44"));
    }

    private void paintSegment(Graphics2D g, boolean active, Point... points)
    {
        if (points != null && active)
        {
            g.setColor(activeSegmentColor);
            Polygon polygon = new Polygon();
            for (Point point : points)
            {
                polygon.addPoint(point.x, point.y);
            }
            g.fillPolygon(polygon);
        }
    }

    private static Point[] getPoints(Dimension d, String coded)
    {
        if (coded.length() == 0)
        {
            return null;
        }
        java.util.List<Point> pointList = new ArrayList();
        String[] points = coded.split(";");
        for (String point : points)
        {
            String[] pointCoordinates = point.split(",");
            int x = (int) ((float) Integer.parseInt(pointCoordinates[0]) / POINT_REFERENCE_WIDTH * d.getWidth());
            int y = (int) ((float) Integer.parseInt(pointCoordinates[1]) / POINT_REFERENCE_HEIGHT * d.getHeight());
            pointList.add(new Point(x, y));
        }
        return pointList.toArray(new Point[pointList.size()]);
    }
}
