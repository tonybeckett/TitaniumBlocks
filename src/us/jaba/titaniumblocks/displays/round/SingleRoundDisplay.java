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
package us.jaba.titaniumblocks.displays.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.round.SilverRoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.round.TopThirdRadialFrontcover;
import us.jaba.titaniumblocks.core.knobs.KnobImageFactory;
import us.jaba.titaniumblocks.core.knobs.KnobPainter;
import us.jaba.titaniumblocks.core.knobs.painter.SmallSilverKnobPainter;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.LedImageFactory;
import us.jaba.titaniumblocks.core.led.types.SingleBargraphLedOff;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.INVERTED_TEXT;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.math.Polar;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.types.TaperedPointer;
import us.jaba.titaniumblocks.core.pointers.shadows.Type1Shadow;
import us.jaba.titaniumblocks.core.posts.PolarSmallPostFactory;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.posts.types.BigSilverPost;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.AbstractRadialTickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RNormalMajMedMinorTickmark;
import us.jaba.titaniumblocks.displays.AbstractRoundDisplay;
import us.jaba.titaniumblocks.displays.RoundDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleRoundDisplay extends AbstractRoundDisplay implements RoundDisplay
{

//    private PointerImageFactory pointerImage;
    private final RNormalMajMedMinorTickmark tickmarkModel;
    private final SingleBargraphLedOff led;
//    private LedImageFactory ledImageFactory;
//    private ShadowPointerImageFactory secShadowPointerImage;
    private CircularLayout circularLayout;
    private MySEPostFactory endPostImage;
    protected float fontScaleFactor = DEFAULT_FONT_SCALE_FACTOR;
    private int currentOffset = -1;
    private MySWPostFactory startPostImage;
    private final TickmarkImageFactory tickmarkImage;

    class MySWPostFactory extends PolarSmallPostFactory
    {

        public MySWPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.925, CoordinateUtils.toRadians(CoordinateUtils.adjustToNativeAngle(circularLayout.getStartPostAngle()))));
        }
    };

    class MySEPostFactory extends PolarSmallPostFactory
    {

        public MySEPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.925, CoordinateUtils.toRadians(CoordinateUtils.adjustToNativeAngle(circularLayout.getEndPostAngle()))));
        }
    };

    public SingleRoundDisplay(CircularLayout circularLayout)
    {
        this(circularLayout, ColorPalette.BLACK);
    }

    public SingleRoundDisplay(CircularLayout circularLayout, Color c)
    {
        super(new BackdropImageFactory(new BasicBackdrop()),
                new RoundFrameImageFactory(new SilverRoundFrame()),
                new PostImageFactory(new BigSilverPost()));
        this.circularLayout = circularLayout;

        BasicBackdrop bmbp = new BasicBackdrop();
        bmbp.setBackgroundColor(new WhiteBModel());
        this.setBackdrop(bmbp);

        doubleValueText = new DoubleValueText();

        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        add(disabledImage);

        startPostImage = new MySWPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));
        add(startPostImage);

        endPostImage = new MySEPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));
        add(endPostImage);

        Type1Shadow t1spp = new Type1Shadow();
        secShadowPointerImage = new ShadowPointerImageFactory(t1spp);
        add(secShadowPointerImage);

        TaperedPointer tpp = new TaperedPointer();
        tpp.setPrimaryColor(new PureBlack());
        tpp.setRadiusPercent(circularLayout.getTickmarkRadius() + 0.025f);
        pointerImage = new PointerImageFactory(tpp);
        add(pointerImage);

        frontcoverImage = new FrontcoverImageFactory(new TopThirdRadialFrontcover());
        add(frontcoverImage);

        led = new SingleBargraphLedOff();
        ledImageFactory = new LedImageFactory(led);
        add(ledImageFactory);

        tickmarkModel = new RNormalMajMedMinorTickmark();

        tickmarkModel.getRadialRangeModel().setTextAngleAdjust(INVERTED_TEXT);
        tickmarkModel.useFixedTextAdjust();

        tickmarkModel.getRadialRangeModel().setAngleStart(circularLayout.getTickmarkStartAngle());
        tickmarkModel.getRadialRangeModel().setEndAngle(circularLayout.getTickmarkEndAngle());
        tickmarkModel.getRadialRangeModel().setDirection(circularLayout.getTickmarkDirection());

        tickmarkModel.getRadialSizeModel().setRadiusAdj(circularLayout.getTickmarkRadius());
        tickmarkImage = new TickmarkImageFactory(tickmarkModel);
        add(tickmarkImage);

        setColor(c);
    }

    public void setSize(Dimension dimensions)
    {
        unitsText.setFontSize((float) (dimensions.width / 500.0) * BaseFont.DEFAULT_FONT.getSize());
        titleValueText.setFontSize((float) (dimensions.width / 500.0) * BaseFont.DEFAULT_FONT.getSize());
        tickmarkModel.setFont(BaseFont.DEFAULT_FONT.deriveFont((float) (dimensions.width / 600.0) * BaseFont.DEFAULT_FONT.getSize()));
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int offset = (int) frameImage.getRoundFrame().getFrameThickness();
        if ( offset != currentOffset)
        {
            setChanged();
            currentOffset = offset;
        }

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getRoundFrame().calcInterior(dimensions);

        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(image, 0, 0, null);

        float fontSize = (float) (Math.min(interiorDim.getHeight(), interiorDim.getWidth()) * fontScaleFactor);
        valueTextImage.getTickmark().setFontSize(fontSize);

        paintPreText(graphics, image, interiorDim, offset);

        graphics.drawImage(disabledImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(startPostImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(endPostImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(titleTextImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(unitsTextImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(tickmarkImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(ledImageFactory.build(interiorDim), dimensions.width * 10 / 16, dimensions.height * 13 / 32, null);

        AffineTransform currentTransform = graphics.getTransform();

        double angleStep = CoordinateUtils.calcGraphicsAngle(normalizedValue, circularLayout);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(secShadowPointerImage.build(interiorDim), offset + 1, offset, null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(pointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        graphics.drawImage(centerPostImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(frontcoverImage.build(interiorDim), offset, offset, null);
    }

    public double getNormalizedValue()
    {
        return normalizedValue;
    }

    public Color getColor()
    {
        return valueTextImage.getTickmark().getColor();
    }

    public void setColor(Color c)
    {
        doubleValueText.setColor(c);
        titleTextImage.getTickmark().setColor(c);
        unitsTextImage.getTickmark().setColor(c);
        tbTextImage.getTickmark().setColor(c);

        tickmarkModel.setMajorColor(c);
        tickmarkModel.setMediumColor(c);
        tickmarkModel.setMinorColor(c);
        tickmarkModel.setBaselineColor(c);
        tickmarkModel.setTextColor(c);
    }

    public Text getValueText()
    {
        return valueTextImage.getTickmark();
    }

    public Frontcover getPainter()
    {
        return frontcoverImage.getTickmark();
    }

    public void setSmallKnobs(KnobPainter startPainter, KnobPainter endPainter)
    {
        startPostImage = new SingleRoundDisplay.MySWPostFactory(new KnobImageFactory(startPainter));
        add(startPostImage);
        endPostImage = new SingleRoundDisplay.MySEPostFactory(new KnobImageFactory(endPainter));
        add(endPostImage); /// ??????????
    }

    public void setTickmarks(AbstractRadialTickmark tickmarks)
    {
        tickmarkImage.setPainter(tickmarks);
    }

    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {
// intentional
    }

    public void setPointerGradient(GradientPalette cp)
    {
        pointerImage.getTickmark().setPrimaryColor(cp);
    }

}
