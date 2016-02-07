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
package us.jaba.titaniumblocks.displays.rectangular;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.frames.FrameModel;
import us.jaba.titaniumblocks.core.frames.RectangularFrame;
import us.jaba.titaniumblocks.core.frames.RectangularFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.rectangular.SilverLinearFrame;
import us.jaba.titaniumblocks.core.frontcover.types.round.BasicRadialFrontcover;
import us.jaba.titaniumblocks.core.frontcover.types.round.TopThirdRadialFrontcover;
import us.jaba.titaniumblocks.core.knobs.KnobImageFactory;
import us.jaba.titaniumblocks.core.knobs.KnobPainter;
import us.jaba.titaniumblocks.core.knobs.painter.SmallSilverKnobPainter;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.LedImageFactory;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.led.types.SingleBargraphLedOff;
import static us.jaba.titaniumblocks.core.math.CoordinateDefs.INVERTED_TEXT;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.math.Polar;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.types.TaperedRoundedPointer;
import us.jaba.titaniumblocks.core.pointers.shadows.Type1Shadow;
import us.jaba.titaniumblocks.core.posts.PolarSmallPostFactory;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.posts.types.BigSilverPost;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.DoubleValueText;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.text.types.TitleText;
import us.jaba.titaniumblocks.core.text.types.UnitsText;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.RNormalMajMedMinorTickmark;
import us.jaba.titaniumblocks.displays.AbstractRoundDisplay;
import us.jaba.titaniumblocks.displays.RoundDisplay;

/**
 *
 * @author tbeckett
 */
public class SingleRectangularDisplay extends AbstractRoundDisplay implements RoundDisplay
{

   
    private final RNormalMajMedMinorTickmark tickmarkModel;
    
    private final SingleBargraphLedOff led;
    
    private CircularLayout circularLayout;
    

    class MySWPostFactory extends PolarSmallPostFactory
    {

        public MySWPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.925, circularLayout.getStartPostAngle() / 180.0 * Math.PI));
        }
    };

    class MySEPostFactory extends PolarSmallPostFactory
    {

        public MySEPostFactory(KnobImageFactory iFactory)
        {
            super(iFactory, new Polar(0.925, circularLayout.getEndPostAngle() * Math.PI / 180.0));
        }
    };
   
    private MySEPostFactory endPostImage;
   RectangularFrameImageFactory rectFrameImage;
    
    private MySWPostFactory startPostImage;
    private final TickmarkImageFactory tickmarkImage;
    
    public SingleRectangularDisplay(CircularLayout circularLayout)
    {
        this(circularLayout, ColorPalette.BLACK);
    }

    public SingleRectangularDisplay(CircularLayout circularLayout, Color c)
    {
        super();
        this.circularLayout = circularLayout;
        rectFrameImage = new RectangularFrameImageFactory(new SilverLinearFrame());

        BasicBackdrop bmbp = new BasicBackdrop();
        bmbp.setBackgroundColor(new WhiteBModel());
        backdropImage = new BackdropImageFactory(bmbp);

        doubleValueText = new DoubleValueText();

        valueTextImage = new TextImageFactory(doubleValueText);

        titleValueText = new TitleText();
        titleTextImage = new TextImageFactory(titleValueText);

        unitsText = new UnitsText();
        unitsTextImage = new TextImageFactory(unitsText);

        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);

        frontcoverImage = new FrontcoverImageFactory(new BasicRadialFrontcover());
        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        centerPostImage = new PostImageFactory(new BigSilverPost());

        startPostImage = new MySWPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));
        endPostImage = new MySEPostFactory(new KnobImageFactory(new SmallSilverKnobPainter()));

        Type1Shadow t1spp = new Type1Shadow();
        shadowImage = new ShadowPointerImageFactory(t1spp);

        TaperedRoundedPointer tpp = new TaperedRoundedPointer();
        tpp.setPointerColor(new PureBlack());
        tpp.setRadiusPercent(circularLayout.getTickmarkRadius() + 0.025f);
        pointerImage = new PointerImageFactory(tpp);

        frontcoverImage = new FrontcoverImageFactory(new TopThirdRadialFrontcover());

        led = new SingleBargraphLedOff();
        ledImageFactory = new LedImageFactory(led);

        tickmarkModel = new RNormalMajMedMinorTickmark();

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

        int offset = rectFrameImage.getPainter().getFrameThickness();

        BufferedImage image = rectFrameImage.build(dimensions);
        Dimension interiorDim = rectFrameImage.getPainter().getInteriorDimension();
        
        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);
        
        graphics.drawImage(image, 0, 0, null);
        
        

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

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(shadowImage.build(interiorDim), offset - 2, offset - 2, null);
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
        return valueTextImage.getPainter().getColor();
    }

    public void setColor(Color c)
    {
        doubleValueText.setColor(c);
        titleTextImage.getPainter().setColor(c);
        unitsTextImage.getPainter().setColor(c);
        tbTextImage.getPainter().setColor(c);

        tickmarkModel.setMajorColor(c);
        tickmarkModel.setMediumColor(c);
        tickmarkModel.setMinorColor(c);
        tickmarkModel.setBaselineColor(c);
        tickmarkModel.setTextColor(c);
    }



    public Text getText()
    {
        return valueTextImage.getPainter();
    }

    public Frontcover getFrontCover()
    {
        return frontcoverImage.getPainter();
    }

   

    public void setFrame(RectangularFrame linearFramePainter)
    {
        this.rectFrameImage = new RectangularFrameImageFactory(linearFramePainter);
    }

  
    public void setSmallKnobs(KnobPainter startPainter, KnobPainter endPainter)
    {
        startPostImage = new MySWPostFactory(new KnobImageFactory(startPainter));
        endPostImage = new MySEPostFactory(new KnobImageFactory(endPainter));
    }

 
    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {

    }

    public void setPointerGradient(GradientPalette cp)
    {
        pointerImage.getPainter().setPointerColor(cp);
    }


}
