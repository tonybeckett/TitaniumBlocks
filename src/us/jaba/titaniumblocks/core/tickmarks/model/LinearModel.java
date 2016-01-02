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
package us.jaba.titaniumblocks.core.tickmarks.model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author tbeckett
 */
public class LinearModel
{

    public static final Rectangle2D.Double DEFAULT_BACKGROUND_TRACK = new Rectangle2D.Double(0, 0, 10, 10);
    public static final float[] DEFAULT_BACKGROUND_FRACTIONS = new float[]
    {
        0.0f, 0.48f, 0.49f, 1.0f
    };
    public static final float[] DEFAULT_FOREGROUND_FRACTIONS = new float[]
    {
        0.0f, 1.0f
    };
    public static final Color[] DEFAULT_FOREGROUND_COLORS = new Color[]
    {
        new Color(1.0f, 1.0f, 1.0f, 0.7f),
        new Color(1.0f, 1.0f, 1.0f, 0.05f)
    };
    
    private Rectangle2D.Double backgroundRectangle;
    private Point2D.Double backgroundStartPoint;
    private Point2D.Double backgroundStopPoint;
    private Rectangle2D.Double backgroundTrack;
    private float[] backgroundTrackFractions;
    private float[] borderFractions;
    private Point2D.Double borderStartPoint;
    private Point2D.Double borderStopPoint;
    private Rectangle2D.Double foregroundRectangle;
    private Color[] foregroundColors;
    private float[] foregroundFractions;
    private Point2D.Double foregroundStartPoint;
    private Point2D.Double foregroundStopPoint;
    private Rectangle2D.Double leftBorderRectangle;
    private Rectangle2D.Double rightBorderRectangle;
    private Point2D.Double startPoint;
    private Point2D.Double stopPoint;

    public LinearModel()
    {

        backgroundTrack = new Rectangle2D.Double(0, 0, 10, 10);
        backgroundStartPoint = new Point2D.Double(0, 0);
        backgroundStopPoint = new Point2D.Double(0, 0);
        backgroundTrackFractions = DEFAULT_BACKGROUND_FRACTIONS;
        leftBorderRectangle = new Rectangle2D.Double(0, 0, 10, 10);
        rightBorderRectangle = new Rectangle2D.Double(0, 0, 10, 10);
        borderStartPoint = new Point2D.Double(0, 0);
        borderStopPoint = new Point2D.Double(0, 0);
        borderFractions = DEFAULT_BACKGROUND_FRACTIONS;

        backgroundRectangle = new Rectangle2D.Double(0, 0, 10, 10);
        startPoint = new Point2D.Double(0, 0);
        stopPoint = new Point2D.Double(0, 0);
        foregroundRectangle = new Rectangle2D.Double(0, 0, 10, 10);
        foregroundStartPoint = new Point2D.Double(0, 0);
        foregroundStopPoint = new Point2D.Double(0, 0);
        foregroundFractions = DEFAULT_FOREGROUND_FRACTIONS;

        foregroundColors = DEFAULT_FOREGROUND_COLORS;
        
//        init(getInnerBounds().width, getInnerBounds().height);
    }

    public Rectangle2D.Double getBackgroundRectangle()
    {
        return backgroundRectangle;
    }

    public void setBackgroundRectangle(Rectangle2D.Double backgroundRectangle)
    {
        this.backgroundRectangle = backgroundRectangle;
    }

    public Point2D.Double getBackgroundStartPoint()
    {
        return backgroundStartPoint;
    }

    public void setBackgroundStartPoint(Point2D.Double backgroundStartPoint)
    {
        this.backgroundStartPoint = backgroundStartPoint;
    }

    public Point2D.Double getBackgroundStopPoint()
    {
        return backgroundStopPoint;
    }

    public void setBackgroundStopPoint(Point2D.Double backgroundStopPoint)
    {
        this.backgroundStopPoint = backgroundStopPoint;
    }

    public Rectangle2D.Double getBackgroundTrack()
    {
        return backgroundTrack;
    }

    public void setBackgroundTrack(Rectangle2D.Double backgroundTrack)
    {
        this.backgroundTrack = backgroundTrack;
    }

    public float[] getBackgroundTrackFractions()
    {
        return backgroundTrackFractions;
    }

    public void setBackgroundTrackFractions(float[] backgroundTrackFractions)
    {
        this.backgroundTrackFractions = backgroundTrackFractions;
    }

    public float[] getBorderFractions()
    {
        return borderFractions;
    }

    public void setBorderFractions(float[] borderFractions)
    {
        this.borderFractions = borderFractions;
    }

    public Point2D.Double getBorderStartPoint()
    {
        return borderStartPoint;
    }

    public void setBorderStartPoint(Point2D.Double borderStartPoint)
    {
        this.borderStartPoint = borderStartPoint;
    }

    public Point2D.Double getBorderStopPoint()
    {
        return borderStopPoint;
    }

    public void setBorderStopPoint(Point2D.Double borderStopPoint)
    {
        this.borderStopPoint = borderStopPoint;
    }

    public Rectangle2D.Double getForegroundRectangle()
    {
        return foregroundRectangle;
    }

    public void setForegroundRectangle(Rectangle2D.Double foregroundRectangle)
    {
        this.foregroundRectangle = foregroundRectangle;
    }

    public Color[] getForegroundColors()
    {
        return foregroundColors;
    }

    public void setForegroundColors(Color[] foregroundColors)
    {
        this.foregroundColors = foregroundColors;
    }

    public float[] getForegroundFractions()
    {
        return foregroundFractions;
    }

    public void setForegroundFractions(float[] foregroundFractions)
    {
        this.foregroundFractions = foregroundFractions;
    }

    public Point2D.Double getForegroundStartPoint()
    {
        return foregroundStartPoint;
    }

    public void setForegroundStartPoint(Point2D.Double foregroundStartPoint)
    {
        this.foregroundStartPoint = foregroundStartPoint;
    }

    public Point2D.Double getForegroundStopPoint()
    {
        return foregroundStopPoint;
    }

    public void setForegroundStopPoint(Point2D.Double foregroundStopPoint)
    {
        this.foregroundStopPoint = foregroundStopPoint;
    }

    public Rectangle2D.Double getLeftBorderRectangle()
    {
        return leftBorderRectangle;
    }

    public void setLeftBorderRectangle(Rectangle2D.Double leftBorderRectangle)
    {
        this.leftBorderRectangle = leftBorderRectangle;
    }

    public Rectangle2D.Double getRightBorderRectangle()
    {
        return rightBorderRectangle;
    }

    public void setRightBorderRectangle(Rectangle2D.Double rightBorderRectangle)
    {
        this.rightBorderRectangle = rightBorderRectangle;
    }

    public Point2D.Double getStartPoint()
    {
        return startPoint;
    }

    public void setStartPoint(Point2D.Double startPoint)
    {
        this.startPoint = startPoint;
    }

    public Point2D.Double getStopPoint()
    {
        return stopPoint;
    }

    public void setStopPoint(Point2D.Double stopPoint)
    {
        this.stopPoint = stopPoint;
    }

}
