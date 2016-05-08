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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.areas.AreaImageFactory;
import us.jaba.titaniumblocks.core.areas.AreaList;
import us.jaba.titaniumblocks.core.glow.Glow;
import us.jaba.titaniumblocks.core.glow.GlowImageFactory;
import us.jaba.titaniumblocks.core.knobs.Knob;
import us.jaba.titaniumblocks.core.knobs.KnobImageFactory;
import us.jaba.titaniumblocks.core.knobs.painter.BrassMetalKnob;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.led.Led;
import us.jaba.titaniumblocks.core.led.LedImageFactory;
import us.jaba.titaniumblocks.core.markers.Marker;
import us.jaba.titaniumblocks.core.markers.MarkerImageFactory;
import us.jaba.titaniumblocks.core.math.CoordinateUtils;
import us.jaba.titaniumblocks.core.sections.SectionImageFactory;
import us.jaba.titaniumblocks.core.sections.SectionList;

/**
 *
 * @author tbeckett
 */
public class FullRoundDial extends SimpleRoundDial
{

    private double marker1Value;
    private double marker2Value;
    private double thresholdValue;

    protected MarkerImageFactory markerImage1;
    protected MarkerImageFactory markerImage2;
    protected MarkerImageFactory thresholdImage;

    protected KnobImageFactory knobImage1;
    protected KnobImageFactory knobImage2;
    protected LedImageFactory ledImage1;
    protected LedImageFactory ledImage2;
    protected SectionImageFactory sectionImage;
    protected GlowImageFactory glowImage;
    protected AreaImageFactory areaImage;

    public FullRoundDial(CircularLayout circularLayout)
    {
        super(circularLayout);

        knobImage1 = new KnobImageFactory(new BrassMetalKnob());
        add(knobImage1);
        knobImage2 = new KnobImageFactory(new BrassMetalKnob());
        add(knobImage2);
        ledImage1 = new LedImageFactory(new Led());
        add(ledImage1);
        ledImage2 = new LedImageFactory(new Led());
        add(ledImage2);
        sectionImage = new SectionImageFactory(new SectionList());
        add(sectionImage);
        glowImage = new GlowImageFactory(new Glow());
        add(glowImage);
        markerImage1 = new MarkerImageFactory(new Marker());
        add(markerImage1);
        markerImage2 = new MarkerImageFactory(new Marker());
        add(markerImage2);
        thresholdImage = new MarkerImageFactory(new Marker());
        add(thresholdImage);
        areaImage = new AreaImageFactory(new AreaList());
        add(areaImage);
    }

    public void setAreaList(AreaList al)
    {
        areaImage.setPainter(al);
    }

    public AreaList getAreaList()
    {
        return areaImage.getAreaList();
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int offset = (int) frameImage.getFrame().getFrameThickness();
        if (offset != currentOffset)
        {
            setChanged();
            currentOffset = offset;
        }

        BufferedImage image = frameImage.build(dimensions);
        Dimension interiorDim = frameImage.getFrame().calcInterior(dimensions);

        graphics.drawImage(backdropImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(image, 0, 0, null);

        float fontSize = (float) (Math.min(interiorDim.getHeight(), interiorDim.getWidth()) * fontScaleFactor);
        valueTextImage.getPainter().setFontSize(fontSize);

        paintPreText(graphics, image, interiorDim, offset);

        graphics.drawImage(text1Image.build(interiorDim), offset, offset, null);

        graphics.drawImage(text2Image.build(interiorDim), offset, offset, null);

        graphics.drawImage(tbTextImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(areaImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(sectionImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(tickmarkImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(knobImage1.build(interiorDim), offset, offset, null);

        graphics.drawImage(knobImage2.build(interiorDim), offset, offset, null);

        graphics.drawImage(ledImage1.build(interiorDim), offset, offset, null);

        graphics.drawImage(ledImage2.build(interiorDim), offset, offset, null);

        graphics.drawImage(glowImage.build(interiorDim), offset, offset, null);

        AffineTransform currentTransform = graphics.getTransform();

        double angleStep = CoordinateUtils.calcGraphicsAngle(normalizedValue, circularLayout);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(secShadowPointerImage.build(interiorDim), offset + 1, offset, null);
        graphics.setTransform(currentTransform);

        graphics.rotate(angleStep, dimensions.width / 2, dimensions.height / 2);

        graphics.drawImage(pointerImage.build(interiorDim), offset, offset, null);
        graphics.setTransform(currentTransform);

        double marker1Angle = CoordinateUtils.calcGraphicsAngle(marker1Value, circularLayout);
        graphics.rotate(marker1Angle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(markerImage1.build(interiorDim), offset + 1, offset, null);
        graphics.setTransform(currentTransform);

        double marker2Angle = CoordinateUtils.calcGraphicsAngle(marker2Value, circularLayout);
        graphics.rotate(marker2Angle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(markerImage2.build(interiorDim), offset + 1, offset, null);
        graphics.setTransform(currentTransform);

        double thresholdAngle = CoordinateUtils.calcGraphicsAngle(thresholdValue, circularLayout);
        graphics.rotate(thresholdAngle, dimensions.width / 2, dimensions.height / 2);
        graphics.drawImage(thresholdImage.build(interiorDim), offset + 1, offset, null);
        graphics.setTransform(currentTransform);

        graphics.drawImage(centerPostImage.build(interiorDim), offset, offset, null);

        graphics.drawImage(frontcoverImage.build(interiorDim), offset, offset, null);
    }

    public SectionList getSectionList()
    {
        return sectionImage.getSectionList();
    }

    public void setSectionList(SectionList sections)
    {
        sectionImage.setPainter(sections);
    }

    public Glow getGlow()
    {
        return glowImage.getPainter();
    }

    public void setGlow(Glow glow)
    {
        glowImage.setPainter(glow);
    }

    public Led getLed1()
    {
        return ledImage1.getPainter();
    }

    public void setLed1(Led led)
    {
        ledImage1.setPainter(led);
    }

    public Led getLed2()
    {
        return ledImage2.getPainter();
    }

    public void setLed2(Led led)
    {
        ledImage2.setPainter(led);
    }

    public Knob getKnob1()
    {
        return knobImage1.getPainter();
    }

    public void setKnob1(Knob knob)
    {
        this.knobImage1.setPainter(knob);
    }

    public Knob getKnob2()
    {
        return knobImage2.getPainter();
    }

    public void setKnob2(Knob knob)
    {
        this.knobImage2.setPainter(knob);
    }

    public double getMarker1Value()
    {
        return marker1Value;
    }

    public void setMarker1Value(double marker1Value)
    {
        this.marker1Value = marker1Value;
    }

    public double getMarker2Value()
    {
        return marker2Value;
    }

    public void setMarker2Value(double marker2Value)
    {
        this.marker2Value = marker2Value;
    }

    public Marker getMarker1()
    {
        return markerImage1.getPainter();
    }

    public void setMarker1(Marker p)
    {
        markerImage1.setPainter(p);
    }

    public Marker getMarker2()
    {
        return markerImage2.getPainter();
    }

    public void setMarker2(Marker p)
    {
        markerImage2.setPainter(p);
    }

    public Marker getThreshold()
    {
        return thresholdImage.getPainter();
    }

    public void setThreshold(Marker p)
    {
        thresholdImage.setPainter(p);
    }

    public double getThresholdValue()
    {
        return thresholdValue;
    }

    public void setThresholdValue(double thresholdValue)
    {
        this.thresholdValue = thresholdValue;
    }

}
