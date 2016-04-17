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
package us.jaba.titaniumblocks.displays;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlue;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frames.FrameImageFactory;
import us.jaba.titaniumblocks.core.frames.types.round.SilverRoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.round.BasicRadialFrontcover;
import us.jaba.titaniumblocks.core.frontcover.types.round.NullFrontcover;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.layout.CircularNoPostLayout;
import us.jaba.titaniumblocks.core.math.CoordinateDefs;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.shadows.LineShadow;
import us.jaba.titaniumblocks.core.pointers.types.LinePointer;
import us.jaba.titaniumblocks.core.posts.NullPost;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.stopwatch.round.SmallTickmarks;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.stopwatch.round.StopwatchSubsecondTickmarks;

/**
 *
 * @author tbeckett
 */
public class AbstractStopwatchDial extends AbstractDial implements TBStopwatchComponent
{

    private int currentOffset = -1;

    private PointerImageFactory minutePointerImage;
    private PointerImageFactory secondsPointerImage;

    private double firstPointerValue = 0.39; // 0.0-1.0
    private double secondPointerValue = 0.39; // 0.0-1.0
    private double thirdPointerValue = 0.39; // 0.0-1.0

    protected CircularLayout circularLayout = new CircularNoPostLayout(CoordinateDefs.Direction.CLOCKWISE, 0.95f);

    private final TickmarkImageFactory tickmarkSmallImage;

    public AbstractStopwatchDial()
    {
        this(new SilverRoundFrame());
    }

    public AbstractStopwatchDial(BasicFrame frame)
    {
        super();

        frameImage = new FrameImageFactory(frame);
        add(frameImage);

        BasicBackdrop bmbp = new BasicBackdrop();
        bmbp.setBackgroundColor(new WhiteBModel());
        backdropImage = new BackdropImageFactory(bmbp);
        add(backdropImage);

        StopwatchSubsecondTickmarks ct = new StopwatchSubsecondTickmarks();
        ct.setTextColor(ColorPalette.BLACK);
        ct.setMajorColor(ColorPalette.BLACK);
        ct.setFont(BaseFont.SERIF_FONT);
        tickmarkImage = new TickmarkImageFactory(ct);
        add(tickmarkImage);

        SmallTickmarks sct = new SmallTickmarks();
        sct.setTextColor(ColorPalette.BLACK);
        sct.setMajorColor(ColorPalette.BLACK);
        sct.setFont(BaseFont.SERIF_FONT);
        tickmarkSmallImage = new TickmarkImageFactory(sct);
        add(tickmarkSmallImage);

        tbText = new TBText();
        tbText.setColor(ColorPalette.BLACK);

        tbTextImage = new TextImageFactory(tbText);
        add(tbTextImage);
        frontcoverImage = new FrontcoverImageFactory(new BasicRadialFrontcover());
        add(frontcoverImage);
        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        add(disabledImage);
        centerPostImage = new PostImageFactory(new NullPost());
        add(centerPostImage);

        LineShadow t1spp = new LineShadow();
        secShadowPointerImage = new ShadowPointerImageFactory(t1spp);
        add(secShadowPointerImage);

//        Pencil2Pointer hourp = new Pencil2Pointer();
//        hourp.setPointerColor(new PureBlack());
//        hourp.setFrontScale(0.65f);
//        hourPointerImage = new PointerImageFactory(hourp);
//        add(hourPointerImage);
        LinePointer minp = new LinePointer();
        minp.setRadiusPercent(0.45f);
        minp.setPrimaryColor(new PureBlue());
        minp.setFrontScale(new Scale(0.5));
        minp.setTailScale(new Scale(0.2));
        minp.setCenterPostEnable(true);
        minp.setCenterPinVisible(true);
        minp.setCenterScale(new Scale(0.015));
        minutePointerImage = new PointerImageFactory(minp);
        add(minutePointerImage);

        LinePointer secp = new LinePointer();
        secp.setPrimaryColor(new PureRed());
        secp.setRadiusPercent(0.95f);
        secp.setTailScale(new Scale(0.2));
        secp.setFrontScale(new Scale(0.975));
        secp.setCenterPostEnable(true);
        secp.setCenterPinVisible(true);
        secp.setCenterScale(new Scale(0.04));
        secondsPointerImage = new PointerImageFactory(secp);
        add(secondsPointerImage);

        frontcoverImage = new FrontcoverImageFactory(new NullFrontcover());
        add(frontcoverImage);

    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getFrame().calcInterior(dimensions);

        int offset = (int) frameImage.getFrame().getFrameThickness();
        if (offset != currentOffset)
        {
            setChanged();
            currentOffset = offset;
            frameImage.setChanged();
            image = frameImage.build(dimensions);
        }

        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(image, 0, 0, null);

        graphics.drawImage(tickmarkImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(tickmarkSmallImage.build(interiorDim), offset, offset - (interiorDim.height / 4), null);

        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        AffineTransform currentTransform = graphics.getTransform();

//        double angleStep = CoordinateUtils.calcGraphicsAngle(firstPointerValue +(secondPointerValue/12), circularLayout);
//       
//        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);
//
//        graphics.drawImage(secShadowPointerImage.build(interiorDim), offset - 2, offset - 2, null);
//        graphics.setTransform(currentTransform);
//        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);
//
//        graphics.drawImage(hourPointerImage.build(interiorDim), offset, offset, null);
//        graphics.setTransform(currentTransform);
        double angleStep = CoordinateUtils.calcGraphicsAngle(secondPointerValue, circularLayout);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2 - (interiorDim.height / 4));

        graphics.drawImage(secShadowPointerImage.build(interiorDim), offset - 2, offset - 2 - (interiorDim.height / 4), null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, (dimensions.height / 2) - (interiorDim.height / 4));

        graphics.drawImage(minutePointerImage.build(interiorDim), offset, offset - (interiorDim.height / 4), null);
        graphics.setTransform(currentTransform);

        angleStep = CoordinateUtils.calcGraphicsAngle(thirdPointerValue, circularLayout);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(secShadowPointerImage.build(interiorDim), offset - 2, offset - 2, null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(secondsPointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        graphics.drawImage(centerPostImage.build(interiorDim), offset, offset, null);
        graphics.drawImage(frontcoverImage.build(interiorDim), offset, offset, null);
    }

    public double getFirstPointerValue()
    {
        return firstPointerValue;
    }

    public void setFirstPointerValue(double firstPointerValue)
    {
        this.firstPointerValue = firstPointerValue;
    }

    @Override
    public double getSecondsValue()
    {
        return thirdPointerValue;
    }

    @Override
    public void setSecondsValue(double secondPointerValue)
    {
        this.thirdPointerValue = secondPointerValue;

    }

    @Override
    public double getMinutesValue()
    {
        return secondPointerValue;
    }

    @Override
    public void setMinutesValue(double thirdPointerValue)
    {
        this.secondPointerValue = thirdPointerValue;
    }

//    public Color getColor()
//    {
//        return valueTextImage.getPainter().getColor();
//    }
//
//    public void setColor(Color c)
//    {
//
//        //  tbTextImage.getTickmark().setColor(c);
//    }
    public Text getText()
    {
        return valueTextImage.getPainter();
    }

    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {
//intentional
    }

    @Override
    public void setSmallTickmarks(Tickmark cm)
    {
        tickmarkSmallImage.setPainter(cm);
    }

    @Override
    public Tickmark getSmallTickmarks()
    {
        return tickmarkSmallImage.getPainter();
    }

    @Override
    public Pointer getMinutesPointer()
    {
        return minutePointerImage.getPainter();
    }

    @Override
    public void setMinutesPointer(Pointer pointer)
    {
        minutePointerImage.setPainter(pointer);
    }

    @Override
    public Pointer getSecondsPointer()
    {
        return secondsPointerImage.getPainter();
    }

    @Override
    public void setSecondsPointer(Pointer pointer)
    {
        secondsPointerImage.setPainter(pointer);
    }

}
