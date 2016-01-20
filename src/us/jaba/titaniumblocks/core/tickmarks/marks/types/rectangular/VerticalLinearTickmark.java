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
package us.jaba.titaniumblocks.core.tickmarks.marks.types.rectangular;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import us.jaba.titaniumblocks.core.text.TextSupport;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.sizemodels.VerticalLinearSizeModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.factories.VerticalLinearTickFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractLinearTickmark;
import us.jaba.titaniumblocks.core.tickmarks.ticklabels.numbers.NumberFormater;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTick;
import us.jaba.titaniumblocks.core.tickmarks.ticks.LinearTickModel;
import us.jaba.titaniumblocks.core.tickmarks.ticks.types.linear.LineTicks;

/**
 *
 * @author tbeckett
 */
public class VerticalLinearTickmark extends AbstractLinearTickmark
{

    protected LinearTickModel linearTickModel;

    private NumberFormater numberFormat;
    protected VerticalLinearTickFactory tickFactory;

    public VerticalLinearTickmark()
    {
        super();
//        numberFormaSSNumberFormatrmat.AUTO;

        linearTickModel = new LineTicks();
        tickFactory = new VerticalLinearTickFactory(rangeModel);
        sizeModel = new VerticalLinearSizeModel();

        tickFactory.setSizeModel(sizeModel);
        offsetAdjustment = AbstractLinearTickmark.DEFAULT_VERT_OFFSET_ADJUST;
        sizeAdjustment = AbstractLinearTickmark.DEFAULT_VERT_SIZE_ADJUST;
    }

    @Override
    protected void subPaint(Graphics2D graphics, Dimension dimensions)
    {
        setBounds(new Rectangle2D.Double(0,
                dimensions.getHeight() * this.getOffsetAdjustment(),
                0,
                ((dimensions.getHeight() * this.getSizeAdjustment()) - (dimensions.getHeight() * this.getOffsetAdjustment()))
        )
        );
        double ss = getBounds().getBounds2D().getHeight() / (rangeModel.getEndValue() - rangeModel.getStartValue());
        rangeModel.setStartPosition((int) getBounds().getMinY());
        sizeModel.adjustUsing((float) dimensions.getHeight());

         sizeModel.setTickStart(sizeModel.getMinorTickStart());
        sizeModel.setTickStop(sizeModel.getMinorTickStop());
        rangeModel.setTickSpacingByValue(minorTickSpacing);
        rangeModel.setSizeInPixels(getBounds().getBounds2D().getHeight());
        
//        rangeModel.setTickSpacingPixel(getBounds().getBounds2D().getHeight() / rangeModel.getNumberOfTicks());
        graphics.setStroke(minorStroke);

        graphics.setColor(minorColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);
        }

         sizeModel.setTickStart(sizeModel.getMediumTickStart());
        sizeModel.setTickStop(sizeModel.getMediumTickStop());
        rangeModel.setTickSpacingByValue(mediumTickSpacing);
        rangeModel.setTickSpacingPixel(getBounds().getBounds2D().getHeight() / rangeModel.getNumberOfTicks());
        graphics.setStroke(mediumStroke);

        graphics.setColor(mediumColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);
        }

         sizeModel.setTickStart(sizeModel.getMajorTickStart());
        sizeModel.setTickStop(sizeModel.getMajorTickStop());
        rangeModel.setTickSpacingByValue(majorTickSpacing);
        rangeModel.setTickSpacingPixel(getBounds().getBounds2D().getHeight() / rangeModel.getNumberOfTicks());
        graphics.setStroke(majorStroke);

        graphics.setColor(majorColor);
        for (LinearTick t : tickFactory.getTicks())
        {
            linearTickModel.paintTicks(graphics, null, dimensions, t);
            
            graphics.setColor(textColor);
            graphics.fill(TextSupport.rotateTextAroundCenter(graphics,
                    Double.toString(t.getValue()),
                    (int) t.getTextPoint().getX(),
                    (int) t.getTextPoint().getY(),
                    t.getTextAngle()));
        }
//
//        // Adjust the number format of the ticklabels
//        if (NUMBER_FORMSSNumberFormatFormat.AUTO)
//        {
//            if (Math.abs(MAJOR_TICK_SPACING) > 1000)
//            {
//                numberFSSNumberFormaterFormat.SCIENTIFIC;
//            } else if (MAJOR_TICK_SPACING % 1.0 != 0)
//            {
//                numbeSSNumberFormatmberFormat.FRACTIONAL;
//            }
//        } else
//        {
//            numberFormat = NUMBER_FORMAT;
//        }

//        int width = (int) dimensions.getWidth();
//        int height = (int) dimensions.getHeight();
//
//        // Horizontal orientation
//        final Font STD_FONT = new Font("Verdana", 0, (int) (0.042 * height));
//        Rectangle2D.Double SCALE_BOUNDS = new Rectangle2D.Double(0, height * 0.12864077669902912, 0, (height * 0.8567961165048543 - height * 0.12864077669902912));
//
//   
//        int MINOR_TICK_START = (int) (0.34 * width);
//        int MINOR_TICK_STOP = (int) (0.36 * width);
//        int MEDIUM_TICK_START = (int) (0.33 * width);
//        int MEDIUM_TICK_STOP = (int) (0.36 * width);
//        int MAJOR_TICK_START = (int) (0.32 * width);
//        int MAJOR_TICK_STOP = (int) (0.36 * width);
//
//        double tickSpaceScaling = SCALE_BOUNDS.getHeight() / (MAX_VALUE - MIN_VALUE);
//
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//
//        graphics.setFont(STD_FONT);
//
//        graphics.setColor(mediumColor);
//
//        final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);
//        final TextLayout TEXT_LAYOUT = new TextLayout(numberFormat.format(MAX_VALUE), graphics.getFont(), RENDER_CONTEXT);
//        final Rectangle2D MAX_BOUNDS = TEXT_LAYOUT.getBounds(); // needed to align the numbers on the right (in vertical layout)
//        final Line2D TICK_LINE = new Line2D.Double(0, 0, 1, 1);
//
//        TextLayout currentLayout;
//        Rectangle2D currentBounds;
//        float alpha = 1.0f;
//        double currentPosY;
//        double valueCounter = MIN_VALUE;
//        int majorTickCounter = NO_OF_MINOR_TICKS - 1; // Indicator when to draw the major tickmark// Indicator when to draw the major tickmark
//
//        // Non logarithmic scaling
//        for (double labelCounter = MIN_VALUE, tickCounter = 0;
//                Float.compare((float) labelCounter, (float) MAX_VALUE) <= 0;
//                labelCounter += MINOR_TICK_SPACING, tickCounter += MINOR_TICK_SPACING)
//        {
//
//            currentPosY = SCALE_BOUNDS.getMaxY() - tickCounter * tickSpaceScaling;
//
//            majorTickCounter++;
//
//            // Draw tickmark every major tickmark spacing
//            if (majorTickCounter == NO_OF_MINOR_TICKS)
//            {
//                graphics.setStroke(majorStroke);
//
//                // Draw the major tickmarks
//                if (TICKS_VISIBLE && MAJOR_TICKS_VISIBLE)
//                {
////                    paint(Graphics2D graphics, Shape shape, Dimension dimensions, double startPosition, double stopPosition, double currentPosition)
//                    linearTickModel.paintTicks(graphics, TICK_LINE, dimensions, null);
////                    drawLinearTicks(graphics, width, height, ORIENTATION, currentPos, MAJOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MAJOR_TICK_START, MAJOR_TICK_STOP, MAJOR_DIAMETER);
//                }
//
//                // Draw the standard tickmark labels
//                if (TICKLABELS_VISIBLE)
//                {
//                    currentLayout = new TextLayout(numberFormat.format(valueCounter), graphics.getFont(), RENDER_CONTEXT);
//                    currentBounds = currentLayout.getBounds();
//
//                    float textOffset = (float) (MAX_BOUNDS.getWidth() - currentBounds.getWidth());
//                    graphics.drawString(numberFormat.format(valueCounter), 0.18f * width + textOffset, (float) (currentPosY - currentBounds.getHeight() / 2.0 + currentBounds.getHeight()));
//
//                }
//
//                valueCounter += MAJOR_TICK_SPACING;
//                majorTickCounter = 0;
//                continue;
//            }
//
//            // Draw tickmark every minor tickmark spacing
//            if (TICKS_VISIBLE && MINOR_TICKS_VISIBLE)
//            {
//                graphics.setStroke(mediumStroke);
//                if (NO_OF_MINOR_TICKS % 2 == 0 && majorTickCounter == (NO_OF_MINOR_TICKS / 2))
//                {
//                    graphics.setStroke(mediumStroke);
//                    linearTickModel.paintTicks(graphics, TICK_LINE, dimensions, null);
////                    linearTickModel.paint(graphics, TICK_LINE, currentPos, centerPoint, centerPoint, centerPoint, alpha);
////                    drawLinearTicks(graphics, width, height, ORIENTATION, currentPos, MINOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MEDIUM_TICK_START, MEDIUM_TICK_STOP, MINOR_DIAMETER);
//
//                } else
//                {
//                    linearTickModel.paintTicks(graphics, TICK_LINE, dimensions, null);
////                    linearTickModel.paint(graphics, TICK_LINE, currentPos, centerPoint, centerPoint, centerPoint, alpha);
////                    drawLinearTicks(graphics, width, height, ORIENTATION, currentPos, MINOR_TICKMARK_TYPE, TICK_LINE, TICK_CIRCLE, TICK_TRIANGLE, MINOR_TICK_START, MINOR_TICK_STOP, MINOR_DIAMETER);
//                }
//            }
//        }
//
//        graphics.dispose();
    }

}
