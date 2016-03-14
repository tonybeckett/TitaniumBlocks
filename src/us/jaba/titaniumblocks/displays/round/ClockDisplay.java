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
import us.jaba.titaniumblocks.core.Scale;
import us.jaba.titaniumblocks.core.backdrop.BackdropImageFactory;
import us.jaba.titaniumblocks.core.backdrop.colormodel.BackdropColorModel;
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.WhiteBModel;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureBlack;
import us.jaba.titaniumblocks.core.color.gradientdefinitions.PureRed;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.font.BaseFont;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
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
import us.jaba.titaniumblocks.core.pointers.types.LinePointer;
import us.jaba.titaniumblocks.core.pointers.types.Pencil2Pointer;
import us.jaba.titaniumblocks.core.posts.NullPost;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.tickmarks.marks.Tickmark;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.clock.round.NumbersOut;
import us.jaba.titaniumblocks.displays.AbstractRoundDisplay;
import us.jaba.titaniumblocks.displays.RoundDisplay;

/**
 *
 * @author tbeckett
 */
public class ClockDisplay extends AbstractRoundDisplay implements RoundDisplay
{

    private int currentOffset = -1;

    private PointerImageFactory hourPointerImage;
    private final ShadowPointerImageFactory hrShadowPointerImage;
    private final ShadowPointerImageFactory minShadowPointerImage;
    private PointerImageFactory minutePointerImage;
    private PointerImageFactory secondsPointerImage;

    private double firstPointerValue = 0.39; // 0.0-1.0
    private double secondPointerValue = 0.39; // 0.0-1.0
    private double thirdPointerValue = 0.39; // 0.0-1.0

    protected CircularLayout circularLayout = new CircularNoPostLayout(CoordinateDefs.Direction.CLOCKWISE, 0.95f);

    private final TickmarkImageFactory tickmarkImage;

    public ClockDisplay()
    {
        this(ColorPalette.BLACK);
    }

    public ClockDisplay(Color c)
    {
        super();

        frameImage = new RoundFrameImageFactory(new SilverRoundFrame())
        {
            
        };
        add(frameImage);

        BasicBackdrop bmbp = new BasicBackdrop();
        bmbp.setBackgroundColor(new WhiteBModel());
        backdropImage = new BackdropImageFactory(bmbp);
        add(backdropImage);

        NumbersOut ct = new NumbersOut();
        ct.setTextColor(ColorPalette.BLACK);
        ct.setMajorColor(ColorPalette.BLACK);
        ct.setFont(BaseFont.SERIF_FONT);
        tickmarkImage = new TickmarkImageFactory(ct);
        add(tickmarkImage);

        tbText = new TBText();
        tbText.setColor(ColorPalette.GRAY);

        tbTextImage = new TextImageFactory(tbText);
        add(tbTextImage);
        frontcoverImage = new FrontcoverImageFactory(new BasicRadialFrontcover());
        add(frontcoverImage);
        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        add(disabledImage);
        centerPostImage = new PostImageFactory(new NullPost());
        add(centerPostImage);

        Pencil2Pointer hourp = new Pencil2Pointer();
        hourp.setPrimaryColor(new PureBlack());
        hourp.setFrontScale(new Scale(0.6));
        hourp.setTailScale(new Scale(0.2));
        hourPointerImage = new PointerImageFactory(hourp);
        add(hourPointerImage);
        hrShadowPointerImage = new ShadowPointerImageFactory(hourp);
        add(hrShadowPointerImage);

        Pencil2Pointer minp = new Pencil2Pointer();
        minp.setPrimaryColor(new PureBlack());

        minp.setCenterPostEnable(true);
        minp.setCenterScale(new Scale(0.04));
        minp.setFrontScale(new Scale(0.85));
        minp.setTailScale(new Scale(0.2));
        minutePointerImage = new PointerImageFactory(minp);
        add(minutePointerImage);
        minShadowPointerImage = new ShadowPointerImageFactory(minp);
        add(minShadowPointerImage);

        LinePointer secp = new LinePointer();
        secp.setPrimaryColor(new PureRed());
        secp.setFrontScale(new Scale(0.9));
        secp.setTailScale(new Scale(0.2));
        secp.setCenterPostEnable(true);
        secp.setCenterPinVisible(true);

        secondsPointerImage = new PointerImageFactory(secp);
        add(secondsPointerImage);
        
        secShadowPointerImage = new ShadowPointerImageFactory(secp);
        add(secShadowPointerImage);

        frontcoverImage = new FrontcoverImageFactory(new NullFrontcover());
        add(frontcoverImage);
        setColor(c);
    }

   public void setSize(Dimension dimensions)
    {
        titleValueText.setFontSize((float) (dimensions.width / 500.0) * BaseFont.DEFAULT_FONT.getSize());    
    }

    private int adjustOffset(int offset, double graphicsAngle)
    {
        int answer = offset;
        int a = (int) CoordinateUtils.toDegrees(graphicsAngle);

        if (a > 95 && a < 165) // nw
        {
            answer = offset + 2;
        } else if (a >= 165 && a <= 195)
        {
            answer = offset;
        } else if (a > 195 && a < 265) // ne
        {
            answer = offset - 2;
        }

        return answer;
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getRoundFrame().calcInterior(dimensions);

        int offset = (int) frameImage.getRoundFrame().getFrameThickness();
         if ( offset != currentOffset)
        {
            setChanged();
            currentOffset = offset;
            frameImage.setChanged();
            image = frameImage.build(dimensions);
        }
//        System.out.println(String.format("dim %s - off %d", interiorDim.toString(), offset));
        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(image, 0, 0, null);

        graphics.drawImage(tickmarkImage.build(interiorDim), offset, offset, null);
       
        graphics.drawImage(titleTextImage.build(interiorDim), offset, offset, null);
       
        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        AffineTransform currentTransform = graphics.getTransform();

        double graphicsAngle = CoordinateUtils.calcGraphicsAngle(firstPointerValue + (secondPointerValue / 12), circularLayout);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(hrShadowPointerImage.build(interiorDim), adjustOffset(offset, graphicsAngle), offset + 1, null);
        graphics.setTransform(currentTransform);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(hourPointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        graphicsAngle = CoordinateUtils.calcGraphicsAngle(secondPointerValue + (thirdPointerValue / 60), circularLayout);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(minShadowPointerImage.build(interiorDim), adjustOffset(offset, graphicsAngle), offset + 1, null);
        graphics.setTransform(currentTransform);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(minutePointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        graphicsAngle = CoordinateUtils.calcGraphicsAngle(thirdPointerValue, circularLayout);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(secShadowPointerImage.build(interiorDim), adjustOffset(offset, graphicsAngle), offset - 1, null);
        graphics.setTransform(currentTransform);
        graphics.rotate(graphicsAngle, dimensions.width / 2, dimensions.height / 2);
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

    public double getSecondPointerValue()
    {
        return secondPointerValue;
    }

    public void setSecondPointerValue(double secondPointerValue)
    {
        this.secondPointerValue = secondPointerValue;

    }

    public double getThirdPointerValue()
    {
        return thirdPointerValue;
    }

    public void setThirdPointerValue(double thirdPointerValue)
    {
        this.thirdPointerValue = thirdPointerValue;
    }

    public Color getColor()
    {
        return valueTextImage.getTickmark().getColor();
    }

    public void setColor(Color c)
    {

        //  tbTextImage.getTickmark().setColor(c);
    }

    public Backdrop getBackdropPainter()
    {
        return backdropImage.getTickmark();
    }

    
    public Text getTextPainter()
    {
        return valueTextImage.getTickmark();
    }

   

//    public void setPointer(Pointer pointerPainter, Pointer shadowPainter)
//    {
//        this.hourPointerImage = new PointerImageFactory(pointerPainter);
//        this.secShadowPointerImage = new ShadowPointerImageFactory(shadowPainter);
//    }
    protected void paintPreText(Graphics2D graphics, BufferedImage image, Dimension dimensions, int offset)
    {
// intentional
    }

    public void setPointerGradient(GradientPalette cp)
    {
        hourPointerImage.getTickmark().setPrimaryColor(cp);
    }

    public Pointer getHourPointer()
    {
        return hourPointerImage.getTickmark();
    }

    public void setHourPointer(Pointer hourPointer)
    {
        this.hourPointerImage.setPainter(hourPointer);
        this.hrShadowPointerImage.setPainter(hourPointer);
    }

    public Pointer getMinutePointer()
    {
        return minutePointerImage.getTickmark();
    }

    public void setMinutePointer(Pointer minutePointer)
    {
        this.minutePointerImage.setPainter(minutePointer);
        this.minShadowPointerImage.setPainter(minutePointer);
    }

    public Pointer getSecondsPointer()
    {
        return secondsPointerImage.getTickmark();
    }

    public void setSecondsPointer(Pointer secondsPointer)
    {
        this.secondsPointerImage.setPainter(secondsPointer);
        this.secShadowPointerImage.setPainter(secondsPointer);
    }

    public Tickmark getTickmark()
    {
        return tickmarkImage.getTickmark();
    }

    public void setTickmark(Tickmark tm)
    {
        tickmarkImage.setPainter(tm);
    }

}
