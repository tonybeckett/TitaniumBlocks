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
import us.jaba.titaniumblocks.core.backdrop.colormodel.colors.BlackBModel;
import us.jaba.titaniumblocks.core.backdrop.types.Backdrop;
import us.jaba.titaniumblocks.core.backdrop.types.round.BasicBackdrop;
import us.jaba.titaniumblocks.core.color.ColorPalette;
import us.jaba.titaniumblocks.core.color.GradientPalette;
import us.jaba.titaniumblocks.core.disabled.DisabledImageFactory;
import us.jaba.titaniumblocks.core.disabled.DisabledPainter;
import us.jaba.titaniumblocks.core.disabled.types.NullLinearDisabled;
import us.jaba.titaniumblocks.core.frontcover.FrontcoverImageFactory;
import us.jaba.titaniumblocks.core.frontcover.types.Frontcover;
import us.jaba.titaniumblocks.core.frames.BasicFrame;
import us.jaba.titaniumblocks.core.frames.FrameImageFactory;
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
import us.jaba.titaniumblocks.core.tickmarks.marks.types.compass.round.Compass3Tickmarks;

import us.jaba.titaniumblocks.displays.AbstractSingleDisplay;


/**
 *
 * @author tbeckett
 */
public class CompassDisplay extends AbstractSingleDisplay 
{
    private ShadowPointerImageFactory shadowImage;

   
 

    public CompassDisplay()
    {
    
        super( new CircularNoPostLayout(CoordinateDefs.Direction.CLOCKWISE, 0.95f), new SilverRoundFrame());

        frameImage = new FrameImageFactory(new SilverRoundFrame());
        add(frameImage);
        
        BasicBackdrop bmbp = new BasicBackdrop();
        bmbp.setBackgroundColor(new BlackBModel());
        backdropImage = new BackdropImageFactory(bmbp);
        add(backdropImage);
        
        Compass3Tickmarks ct = new Compass3Tickmarks();
        ct.setTextColor(ColorPalette.WHITE);
        ct.setMajorColor(ColorPalette.WHITE);
        tickmarkImage = new TickmarkImageFactory(ct);
        add(tickmarkImage);
        
        tbText = new TBText();
        tbTextImage = new TextImageFactory(tbText);
        add(tbTextImage);
        
        frontcoverImage = new FrontcoverImageFactory(new BasicRadialFrontcover());
        add(frontcoverImage);

        disabledImage = new DisabledImageFactory(new NullLinearDisabled());
        add(disabledImage);

        centerPostImage = new PostImageFactory(new BigSilverPost());
        add(centerPostImage);

        Type1Shadow t1spp = new Type1Shadow();
        shadowImage = new ShadowPointerImageFactory(t1spp);
        add(shadowImage);

        CompassPointer tpp = new CompassPointer();
        //tpp.setPointerColor(new PureBlack());

        pointerImage = new PointerImageFactory(tpp);
        add(pointerImage);

        frontcoverImage = new FrontcoverImageFactory(new TopThirdRadialFrontcover());
        add(frontcoverImage);

        
    }

    
    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int offset = (int) frameImage.getFrame().getFrameThickness();

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getFrame().calcInterior(dimensions);

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

    
    
  
 
   

}
