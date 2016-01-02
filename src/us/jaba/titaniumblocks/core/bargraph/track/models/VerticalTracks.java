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
package us.jaba.titaniumblocks.core.bargraph.track.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.DarkGrayBModel;
import us.jaba.titaniumblocks.core.bargraph.track.TrackModel;
import us.jaba.titaniumblocks.core.color.ColorTools;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class VerticalTracks extends TrackModel
{

    private BackdropColorModel backgroundColorModel;
    private final Rectangle2D VALUE_BACKGROUND_TRACK;
    private final Point2D VALUE_BACKGROUND_VERTICAL_START;
    private final Point2D VALUE_BACKGROUND_VERTICAL_STOP;
    private final float[] VALUE_BACKGROUND_TRACK_FRACTIONS;

    private final Rectangle2D VALUE_LEFT_BORDER;
    private final Rectangle2D VALUE_RIGHT_BORDER;
    private final Point2D VALUE_BORDER_START;
    private final Point2D VALUE_BORDER_STOP;
    private final float[] VALUE_BORDER_FRACTIONS;

    public VerticalTracks()
    {
        backgroundColorModel = new DarkGrayBModel();
        VALUE_BACKGROUND_TRACK = new Rectangle2D.Double(0, 0, 10, 10);
        VALUE_BACKGROUND_VERTICAL_START = new Point2D.Double(0, 0);
        VALUE_BACKGROUND_VERTICAL_STOP = new Point2D.Double(0, 0);
        VALUE_BACKGROUND_TRACK_FRACTIONS = new float[]
        {
            0.0f,
            0.48f,
            0.49f,
            1.0f
        };

        VALUE_LEFT_BORDER = new Rectangle2D.Double(0, 0, 10, 10);
        VALUE_RIGHT_BORDER = new Rectangle2D.Double(0, 0, 10, 10);
        VALUE_BORDER_START = new Point2D.Double(0, 0);
        VALUE_BORDER_STOP = new Point2D.Double(0, 0);
        VALUE_BORDER_FRACTIONS = new float[]
        {
            0.0f,
            0.48f,
            0.49f,
            1.0f
        };
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        int WIDTH = (int) dimensions.getWidth();
        int HEIGHT = (int) dimensions.getHeight();

        final double TOP; // position of max value
        final double BOTTOM; // position of min value
        final double FULL_SIZE;

        // Vertical orientation
        TOP = HEIGHT * 0.12864077669902912; // position of max value
        BOTTOM = HEIGHT * 0.8567961165048543; // position of min value
        FULL_SIZE = BOTTOM - TOP;

        VALUE_BACKGROUND_TRACK.setRect(WIDTH * 0.4357142857142857, TOP, WIDTH * 0.14285714285714285, FULL_SIZE);
        VALUE_BACKGROUND_VERTICAL_START.setLocation(0, VALUE_BACKGROUND_TRACK.getBounds2D().getMinY());
        VALUE_BACKGROUND_VERTICAL_STOP.setLocation(0, VALUE_BACKGROUND_TRACK.getBounds2D().getMaxY());

        final Color[] VALUE_BACKGROUND_TRACK_COLORS =
        {
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.0470588235f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.1450980392f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.1490196078f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.0470588235f)
        };

        PointSupport.validateGradientPoints(VALUE_BACKGROUND_VERTICAL_START, VALUE_BACKGROUND_VERTICAL_STOP);
        final LinearGradientPaint VALUE_BACKGROUND_TRACK_GRADIENT = new LinearGradientPaint(VALUE_BACKGROUND_VERTICAL_START, VALUE_BACKGROUND_VERTICAL_STOP, VALUE_BACKGROUND_TRACK_FRACTIONS, VALUE_BACKGROUND_TRACK_COLORS);
        graphics.setPaint(VALUE_BACKGROUND_TRACK_GRADIENT);
        graphics.fill(VALUE_BACKGROUND_TRACK);

        // Vertical orientation
        VALUE_LEFT_BORDER.setRect(WIDTH * 0.4357142857142857, TOP, WIDTH * 0.007142857142857143, FULL_SIZE);
        VALUE_RIGHT_BORDER.setRect(WIDTH * 0.5714285714285714, TOP, WIDTH * 0.007142857142857143, FULL_SIZE);
        VALUE_BORDER_START.setLocation(0, VALUE_LEFT_BORDER.getBounds2D().getMinY());
        VALUE_BORDER_STOP.setLocation(0, VALUE_LEFT_BORDER.getBounds2D().getMaxY());

        final Color[] VALUE_BORDER_COLORS =
        {
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.2980392157f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.6862745098f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.6980392157f),
            ColorTools.setAlpha(backgroundColorModel.getLabelColor(), 0.4f)
        };

        PointSupport.validateGradientPoints(VALUE_BORDER_START, VALUE_BORDER_STOP);
        final LinearGradientPaint VALUE_BORDER_GRADIENT = new LinearGradientPaint(VALUE_BORDER_START, VALUE_BORDER_STOP, VALUE_BORDER_FRACTIONS, VALUE_BORDER_COLORS);
        graphics.setPaint(VALUE_BORDER_GRADIENT);
        graphics.fill(VALUE_LEFT_BORDER);
        graphics.fill(VALUE_RIGHT_BORDER);

    }

}
