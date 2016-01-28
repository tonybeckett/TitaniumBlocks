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
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BrushedMetalBModel;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.CompassRoseBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.frames.RoundFrameImageFactory;
import us.jaba.titaniumblocks.core.frames.FrameModel;
import us.jaba.titaniumblocks.core.frames.RoundFrame;
import us.jaba.titaniumblocks.core.frames.types.round.SilverRoundFrame;
import us.jaba.titaniumblocks.core.frontcover.types.round.BasicRadialFrontcover;
import us.jaba.titaniumblocks.core.frontcover.types.round.TopThirdRadialFrontcover;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.layout.CircularNoPostLayout;
import us.jaba.titaniumblocks.core.math.CoordinateDefs;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.pointers.PointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.Pointer;
import us.jaba.titaniumblocks.core.pointers.ShadowPointerImageFactory;
import us.jaba.titaniumblocks.core.pointers.shadows.Type1Shadow;
import us.jaba.titaniumblocks.core.pointers.types.CompassPointer;
import us.jaba.titaniumblocks.core.posts.PostImageFactory;
import us.jaba.titaniumblocks.core.posts.Post;
import us.jaba.titaniumblocks.core.posts.types.BigSilverPost;
import us.jaba.titaniumblocks.core.text.TextImageFactory;
import us.jaba.titaniumblocks.core.text.Text;
import us.jaba.titaniumblocks.core.text.types.TBText;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.TickmarkImageFactory;
import us.jaba.titaniumblocks.core.tickmarks.marks.types.round.CompassTickmarks;
import us.jaba.titaniumblocks.displays.AbstractRoundDisplay;
import us.jaba.titaniumblocks.displays.RoundDisplay;

/**
 *
 * @author tbeckett
 */
public class CompassDisplay extends AbstractRoundDisplay implements RoundDisplay
{

    private PointerImageFactory pointerImage;

    private ShadowPointerImageFactory shadowImage;

    private final TBText tbText;
    private final TextImageFactory tbTextImage;

    private static final float DEFAULT_FONT_SCALE_FACTOR = 0.67f;

    private float fontScaleFactor = DEFAULT_FONT_SCALE_FACTOR;
    private double normalizedValue = 0.39; // 0.0-1.0

    protected BackdropImageFactory backdropImage;
    protected RoundFrameImageFactory frameImage;
    protected FrontcoverImageFactory frontcoverImage;
    protected DisabledImageFactory disabledImage;

    protected CircularLayout circularLayout = new CircularNoPostLayout(CoordinateDefs.Direction.CLOCKWISE, 0.95f);
    protected TextImageFactory valueTextImage;
    protected PostImageFactory centerPostImage;
    private final TickmarkImageFactory tickmarkImage;

    public CompassDisplay()
    {
        this(ColorPalette.BLACK);
    }

    public CompassDisplay(Color c)
    {
        super();

        frameImage = new RoundFrameImageFactory(new SilverRoundFrame());

        CompassRoseBackdrop bmbp = new CompassRoseBackdrop();
        bmbp.setBackgroundColor(new BrushedMetalBModel());
        backdropImage = new BackdropImageFactory(bmbp);

        CompassTickmarks ct = new CompassTickmarks();
        ct.setTextColor(ColorPalette.WHITE);
        ct.setMajorColor(ColorPalette.WHITE);
        tickmarkImage = new TickmarkImageFactory(ct);

        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);

        frontcoverImage = new FrontcoverImageFactory(new BasicRadialFrontcover());
        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        centerPostImage = new PostImageFactory(new BigSilverPost());

        Type1Shadow t1spp = new Type1Shadow();
        shadowImage = new ShadowPointerImageFactory(t1spp);

        CompassPointer tpp = new CompassPointer();
        //tpp.setPointerColor(new PureBlack());

        pointerImage = new PointerImageFactory(tpp);

        frontcoverImage = new FrontcoverImageFactory(new TopThirdRadialFrontcover());

        setColor(c);
    }

    public void setSize(Dimension dimensions)
    {

    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int offset = frameImage.getPainter().getFrameThickness();

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getPainter().getInteriorDimension();

        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(image, 0, 0, null);

        graphics.drawImage(tickmarkImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        AffineTransform currentTransform = graphics.getTransform();

        double angleStep = CoordinateUtils.calcGraphicsAngle(normalizedValue, circularLayout);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(shadowImage.build(interiorDim), offset - 2, offset - 2, null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(pointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        graphics.drawImage(centerPostImage.build(interiorDim), offset, offset, null);

 //       graphics.drawImage(frontcoverImage.build(interiorDim), offset, offset, null);
    }

    public double getNormalizedValue()
    {
        return normalizedValue;
    }

    public void setNormalizedValue(double d)
    {
        normalizedValue = (double) d;
    }

    public Color getColor()
    {
        return valueTextImage.getPainter().getColor();
    }

    public void setColor(Color c)
    {

        tbTextImage.getPainter().setColor(c);

    }

    public Backdrop getBackdropPainter()
    {
        return backdropImage.getPainter();
    }

    public FrameModel getFramePainter()
    {
        return frameImage.getPainter();
    }

    public Text getTextPainter()
    {
        return valueTextImage.getPainter();
    }

    public Frontcover getPainter()
    {
        return frontcoverImage.getPainter();
    }

    public void setBackdropPainter(Backdrop painter)
    {
        this.backdropImage = new BackdropImageFactory(painter);
    }

    public void setRoundFramePainter(RoundFrame linearFramePainter)
    {
        this.frameImage = new RoundFrameImageFactory(linearFramePainter);
    }

    public void setFrontCoverPainter(Frontcover foregroundPainter)
    {
        this.frontcoverImage = new FrontcoverImageFactory(foregroundPainter);
    }

    public void setDisabledPainter(DisabledPainter disabledPainter)
    {
        this.disabledImage = new DisabledImageFactory(disabledPainter);
    }

    public void setPointerPainter(Pointer pointerPainter, Pointer shadowPainter)
    {
        this.pointerImage = new PointerImageFactory(pointerPainter);
        this.shadowImage = new ShadowPointerImageFactory(shadowPainter);
    }

    public void setValueTextPainter(Text valueTextPainter)
    {
        valueTextPainter.setColor(valueTextImage.getPainter().getColor());
        this.valueTextImage = new TextImageFactory(valueTextPainter);
    }

    public void setCenterPostPainter(Post postPainter)
    {
        this.centerPostImage = new PostImageFactory(postPainter);
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

    public void setPointerGradient(GradientPalette cp)
    {
        pointerImage.getPainter().setPointerColor(cp);
    }

}
