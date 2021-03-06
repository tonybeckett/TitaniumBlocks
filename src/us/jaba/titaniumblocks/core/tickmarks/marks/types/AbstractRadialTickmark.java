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
package us.jaba.titaniumblocks.core.tickmarks.marks.types;

import us.jaba.titaniumblocks.core.tickmarks.marks.types.rangemodels.RadialRangeModel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.math.CoordinateDefs;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.NORTH;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.SOUTH_WEST;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels.RadialSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.RadialTickModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.types.radial.RadialLineTicks;

/**
 *
 * @author tbeckett
 */
public class AbstractRadialTickmark extends Tickmark
{

    private Point2D centerOffset = new Point2D.Double(0.0, 0.0);
    protected Point2D centerPoint = new Point2D.Double(10, 10);
    protected Scale textPositionScale = new Scale(1.0);
    protected Scale textSizeScale = new Scale(1.0);
    protected Scale ticksPositionScale = new Scale(1.0);  // 0.0 - 2.0
    protected RadialRangeModel rangeModel;
    protected RadialSizeModel sizeModel = new RadialSizeModel();
    protected RadialTickModel radialTickModel = new RadialLineTicks();

    public AbstractRadialTickmark()
    {
        this(new Scale(1.0), new Scale(1.0));
    }

    public AbstractRadialTickmark(Scale textPos, Scale sizeScale)
    {
        textPositionScale = textPos;
        textSizeScale = sizeScale;
        rangeModel = new RadialRangeModel(centerPoint, sizeModel.getRadius(), SOUTH_WEST, NORTH);
        rangeModel.setStartValue(DEFAULT_MIN_VALUE);
        rangeModel.setEndValue(DEFAULT_MAX_VALUE);
    }

    public AbstractRadialTickmark(RadialRangeModel radialRangeModel)
    {
        this.rangeModel = radialRangeModel;
    }

    public void copy(AbstractRadialTickmark other)
    {
        super.copy(other);
        //       this.textPositionScale = other.textPositionScale;  Position is design dependent
        this.textSizeScale = other.textSizeScale;
        rangeModel = new RadialRangeModel( other.rangeModel.getCenter(), other.rangeModel.getRadius(), other.rangeModel.getAngleStart(), other.rangeModel.getAngleEnd());
        rangeModel.setDirection(other.rangeModel.getDirection());
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);

        centerPoint.setLocation((dimensions.getWidth() / 2.0) + centerOffset.getX(), (dimensions.getHeight() / 2.0) + centerOffset.getY());
     
        sizeModel.adjustUsing((float) dimensions.getWidth());
        rangeModel.setRadius(sizeModel.getRadius());
        rangeModel.setCenter(centerPoint);
        rangeModel.setTextDistance(sizeModel.getTextDistance());

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        GeneralPath baselinePath = new GeneralPath();
        baselinePath.setWindingRule(Path2D.WIND_EVEN_ODD);

        subPaint(graphics, dimensions);

    }

    protected void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Point2D getCenterOffset()
    {
        return centerOffset;
    }

    public void setCenterOffset(Point2D centerOffset)
    {
        this.centerOffset = centerOffset;
        changed();
    }

    public Point2D getCenterPoint()
    {
        return centerPoint;
    }

    public void setCenterPoint(Point2D centerPoint)
    {
        this.centerPoint = centerPoint;
        changed();
    }

    public RadialRangeModel getRadialRangeModel()
    {
        return rangeModel;
    }

    public void setRadialRangeModel(RadialRangeModel radialRangeModel)
    {
        this.rangeModel = radialRangeModel;
        changed();
    }

    public RadialSizeModel getRadialSizeModel()
    {
        return sizeModel;
    }

    public void setRadialSizeModel(RadialSizeModel radialSizeModel)
    {
        this.sizeModel = radialSizeModel;
        changed();
    }

    public RadialTickModel getRadialTickModel()
    {
        return radialTickModel;
    }

    public void setRadialTickModel(RadialTickModel radialTickModel)
    {
        this.radialTickModel = radialTickModel;
        changed();
    }

    public Scale getTextPositionScale()
    {
        return textPositionScale;
    }

    public void setTextPositionScale(Scale textPositionScale)
    {
        this.textPositionScale = textPositionScale;
        changed();
    }

    public Scale getTextSizeScale()
    {
        return textSizeScale;
    }

    public void setTextSizeScale(Scale textSizeScale)
    {
        this.textSizeScale = textSizeScale;
        changed();
    }

    public Scale getTicksPositionScale()
    {
        return ticksPositionScale;
    }

    public void setTicksPositionScale(Scale ticksPositionScale)
    {
        this.ticksPositionScale = ticksPositionScale;
        changed();
    }

    public void setAngleStart(double angSt)
    {
        rangeModel.setAngleStart(angSt);
        changed();
    }

    public void setDirection(CoordinateDefs.Direction direction)
    {
        rangeModel.setDirection(direction);
        changed();
    }

    public void setEndAngle(double d)
    {
        rangeModel.setEndAngle(d);
        changed();
    }

}
