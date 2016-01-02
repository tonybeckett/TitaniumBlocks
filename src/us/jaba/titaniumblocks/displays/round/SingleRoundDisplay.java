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
import us.jaba.titaniumblocks.core.backdrop.models.BackdropModel;
import us.jaba.titaniumblocks.core.backdrop.models.round.NullBackgroundPainter;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.painters.NullLinearDisabledPainter;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.models.FrontcoverModel;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.RoundFrameModel;
import us.jaba.titaniumblocks.core.frames.models.round.SilverRadialFramePainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.BasicRadialForegroundPainter;
import us.jaba.titaniumblocks.core.frontcover.models.round.TopThirdRadialForegroundPainter;
import us.jaba.titaniumblocks.core.knobs.KnobImageFactory;
import us.jaba.titaniumblocks.core.knobs.painter.SmallSilverKnobPainter;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.LedImageFactory;
import us.jaba.titaniumblocks.core.led.models.SingleBargraphLedOff;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.INVERTED_TEXT;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.math.Polar;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.painters.TaperedRoundedPointerPainter;
import us.jaba.titaniumblocks.core.pointers.shadowpainters.Type1ShadowPointerPainter;
import us.jaba.titaniumblocks.core.posts.PolarSmallPostFactory;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.posts.painters.BigSilverPostPainter;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.TextPainter;
import us.jaba.titaniumblocks.core.text.painters.DoubleValueText;
import us.jaba.titaniumblocks.core.text.painters.TBText;
import us.jaba.titaniumblocks.core.text.painters.TitleText;
import us.jaba.titaniumblocks.core.text.painters.UnitsText;
import us.jaba.titaniumblocks.core.tickmarks.marks.models.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.models.round.RNormalMajMedMinorTickmarkModel;
import us.jaba.titaniumblocks.displays.AbstractRoundDisplay;
import us.jaba.titaniumblocks.displays.RoundDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleRoundDisplay extends AbstractRoundDisplay implements RoundDisplay
{

    private final PointerImageFactory pointerImage;
    private final RNormalMajMedMinorTickmarkModel tickmarkModel;
    private final TextImageFactory titleTextImage;
    private final TitleText titleValueText;
    private TextPainter unitsText;
    private final TextImageFactory unitsTextImage;
    private final SingleBargraphLedOff led;
    private final LedImageFactory ledImageFactory;
    private final ShadowPointerImageFactory shadowImage;
    private CircularLayout circularLayout;
    private final TBText tbText;
    private final TextImageFactory tbTextImage;

    class MySWPostFactory extends PolarSmallPostFactory
    {

        public MySWPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.725, circularLayout.getStartPostAngle() / 180.0 * Math.PI));
        }
    };

    class MySEPostFactory extends PolarSmallPostFactory
    {

        public MySEPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.725, circularLayout.getEndPostAngle() * Math.PI / 180.0));
        }
    };
    private static final float DEFAULT_FONT_SCALE_FACTOR = 0.67f;
    private final DoubleValueText doubleValueText;
    private final MySEPostFactory endPostImage;
    private float fontScaleFactor = DEFAULT_FONT_SCALE_FACTOR;
    private double normalizedValue = 0.39; // 0.0-1.0

    protected BackdropImageFactory backdropImage;
    protected RoundFrameImageFactory frameImage;
    protected FrontcoverImageFactory frontcoverImage;
    protected DisabledImageFactory disabledImage;
    private final MySWPostFactory startPostImage;
    private final TickmarkImageFactory tickmarkImage;
    protected TextImageFactory valueTextImage;
    protected PostImageFactory centerPostImage;

    public SingleRoundDisplay(CircularLayout circularLayout)
    {
        this(circularLayout, Color.BLACK);
    }

    public SingleRoundDisplay(CircularLayout circularLayout, Color c)
    {
        super();
        this.circularLayout = circularLayout;
        frameImage = new RoundFrameImageFactory(new SilverRadialFramePainter());
        
        NullBackgroundPainter bmbp = new NullBackgroundPainter();
        bmbp.setBackgroundColorModel(new WhiteBModel());
        backdropImage = new BackdropImageFactory(bmbp);
        
        doubleValueText = new DoubleValueText();

        valueTextImage = new TextImageFactory(doubleValueText);

        titleValueText = new TitleText();
        titleTextImage = new TextImageFactory(titleValueText);

        unitsText = new UnitsText();
        unitsTextImage = new TextImageFactory(unitsText);

        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);

        frontcoverImage = new FrontcoverImageFactory(new BasicRadialForegroundPainter());
        disabledImage = new DisabledImageFactory(new NullLinearDisabledPainter());
        centerPostImage = new PostImageFactory(new BigSilverPostPainter());

        startPostImage = new MySWPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));
        endPostImage = new MySEPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));

        Type1ShadowPointerPainter t1spp = new Type1ShadowPointerPainter();
        shadowImage = new ShadowPointerImageFactory(t1spp);

        TaperedRoundedPointerPainter tpp = new TaperedRoundedPointerPainter();
        tpp.setPointerColor(new PureBlack());
        pointerImage = new PointerImageFactory(tpp);

        frontcoverImage = new FrontcoverImageFactory(new TopThirdRadialForegroundPainter());

        led = new SingleBargraphLedOff();
        ledImageFactory = new LedImageFactory(led);

        tickmarkModel = new RNormalMajMedMinorTickmarkModel();

//        tickmarkModel.setBaselineColor(Color.WHITE);
//        tickmarkModel.setMajorColor(Color.WHITE);
//        tickmarkModel.setMinorColor(Color.WHITE);
        tickmarkModel.getRadialRangeModel().setTextAngleAdjust(INVERTED_TEXT);
        tickmarkModel.useFixedTextAdjust();

        tickmarkModel.getRadialRangeModel().setAngleStart(circularLayout.getTickmarkStartAngle());
        tickmarkModel.getRadialRangeModel().setEndAngle(circularLayout.getTickmarkEndAngle());
        tickmarkModel.getRadialRangeModel().setDirection(circularLayout.getTickmarkDirection());

//        double ff = CoordinateUtils.calcExtent(circularLayout.getTickmarkStartAngle(), circularLayout.getTickmarkEndAngle(), tickmarkModel.getRadialRangeModel());
//        tickmarkModel.getRadialRangeModel().setAngleExtent(ff);
        tickmarkModel.getRadialSizeModel().setRadiusAdj(circularLayout.getTickmarkRadius());
        tickmarkImage = new TickmarkImageFactory(tickmarkModel);
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

        BufferedImage image = backdropImage.build(dimensions);
        graphics.drawImage(image, 0, 0, null);

        image = frameImage.build(dimensions);
        graphics.drawImage(image, 0, 0, null);
        int offset = 0;//linearFrameImage.getPainter().getFrameThickness();
        Dimension interiorDim = dimensions;//linearFrameImage.getPainter().getInteriorDimension();
//        valueTextImage.getPainter().setFontSize((float) (interiorDim.getHeight() * fontScaleFactor));
        float fontSize = (float) (Math.min(interiorDim.getHeight(), interiorDim.getWidth()) * fontScaleFactor);
        valueTextImage.getPainter().setFontSize(fontSize);

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

        graphics.rotate(angleStep, dimensions.width / 2 , dimensions.height / 2 );

        graphics.drawImage(shadowImage.build(interiorDim), -2 , -2 , null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(pointerImage.build(interiorDim), 0, 0, null);
        graphics.setTransform(currentTransform);

        graphics.drawImage(centerPostImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(frontcoverImage.build(interiorDim), offset, offset, null);
    }

    public double getNormalizedValue()
    {
        return normalizedValue;
    }

    public void setNormalizedValue(double d)
    {
        normalizedValue = (double) d;
    }

    public void setTitle(String string)
    {
        titleValueText.setValue(string);
    }

    public Color getColor()
    {
        return valueTextImage.getPainter().getColor();
    }

    public void setColor(Color c)
    {
        valueTextImage.getPainter().setColor(c);
    }

    public BackdropModel getBackgroundPainter()
    {
        return backdropImage.getPainter();
    }

    public RoundFrameModel getFramePainter()
    {
        return frameImage.getPainter();
    }

    public TextPainter getTextPainter()
    {
        return valueTextImage.getPainter();
    }

    public FrontcoverModel getPainter()
    {
        return frontcoverImage.getPainter();
    }

    public void setBackgroundPainter(BackdropModel painter)
    {
        this.backdropImage = new BackdropImageFactory(painter);
    }

    public void setRoundFramePainter(RoundFrameModel linearFramePainter)
    {
        this.frameImage = new RoundFrameImageFactory(linearFramePainter);
    }

    public void setForegroundPainter(FrontcoverModel foregroundPainter)
    {
        this.frontcoverImage = new FrontcoverImageFactory(foregroundPainter);
    }

    public void setDisabledPainter(DisabledPainter disabledPainter)
    {
        this.disabledImage = new DisabledImageFactory(disabledPainter);
    }

    public void setValueTextPainter(TextPainter valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getPainter().getColor());
        this.valueTextImage = new TextImageFactory(valueTextPainter);
    }

    public float getFontScaleFactor()
    {
        return fontScaleFactor;
    }

    public void setFontScaleFactor(float fontScaleFactor)
    {
        this.fontScaleFactor = fontScaleFactor;
    }

    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {

    }

}
