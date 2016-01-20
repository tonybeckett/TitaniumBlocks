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

import us.jaba.titaniumblocks.core.tickmarks.marks.types.rangemodels.LinearRangeModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels.LinearSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.marks.TickmarkModel;
import static us.jaba.titaniumblocks.core.tickmarks.marks.TickmarkModel.DEFAULT_MAX_VALUE;
import static us.jaba.titaniumblocks.core.tickmarks.marks.TickmarkModel.DEFAULT_MIN_VALUE;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.orientation.TickLabelModel;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.orientation.models.NormalTickLabelModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTickModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.types.linear.LineTicks;

/**
 *
 * @author tbeckett
 */
public abstract class AbstractLinearTickmark extends TickmarkModel
{

    public static final float DEFAULT_HORIZ_OFFSET_ADJUST = 0.12864f;
    public static final float DEFAULT_HORIZ_SIZE_ADJUST = 0.856796f;

    public static final float DEFAULT_VERT_OFFSET_ADJUST = 0.142857f;
    public static final float DEFAULT_VERT_SIZE_ADJUST = 0.871012f;

    protected LinearRangeModel rangeModel;
    protected LinearSizeModel sizeModel = new LinearSizeModel();
    protected LinearTickModel tickModel = new LineTicks();

    protected double MAX_VALUE = 100.0;
    protected double MIN_VALUE = 0;

    protected Point2D OFFSET = new Point2D.Double(0, 0);

    protected Font STD_FONT = new Font("Verdana", 0, 10);

    protected TickLabelModel tickLabelPainter = new NormalTickLabelModel();
    protected float offsetAdjustment = 1.0f;
    protected float sizeAdjustment = 1.0f;
    
    private Rectangle2D bounds;
    
    public AbstractLinearTickmark()
    {
        rangeModel = new LinearRangeModel();
        rangeModel.setStartValue(DEFAULT_MIN_VALUE);
        rangeModel.setEndValue(DEFAULT_MAX_VALUE);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        super.paint(graphics, dimensions);
        
        sizeModel.adjustUsing((float) dimensions.getWidth());

//        rangeModel.setTextDistance(sizeModel.getTextDistance());
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        subPaint(graphics, dimensions);
    }

    protected abstract void subPaint(Graphics2D graphics, Dimension dimensions);

    public float getOffsetAdjustment()
    {
        return offsetAdjustment;
    }

    public void setOffsetAdjustment(float offsetAdjustment)
    {
        this.offsetAdjustment = offsetAdjustment;
    }

    public float getSizeAdjustment()
    {
        return sizeAdjustment;
    }

    public void setSizeAdjustment(float sizeAdjustment)
    {
        this.sizeAdjustment = sizeAdjustment;
    }

    public Rectangle2D getBounds()
    {
        return bounds;
    }

    public void setBounds(Rectangle2D bounds)
    {
        this.bounds = bounds;
    }

    public LinearRangeModel getRangeModel()
    {
        return rangeModel;
    }

    public void setRangeModel(LinearRangeModel rangeModel)
    {
        this.rangeModel = rangeModel;
    }

    public LinearSizeModel getSizeModel()
    {
        return sizeModel;
    }

    public void setSizeModel(LinearSizeModel sizeModel)
    {
        this.sizeModel = sizeModel;
    }

    public LinearTickModel getTickModel()
    {
        return tickModel;
    }

    public void setTickModel(LinearTickModel tickModel)
    {
        this.tickModel = tickModel;
    }

}
