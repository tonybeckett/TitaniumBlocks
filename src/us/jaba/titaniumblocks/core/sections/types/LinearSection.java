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
package us.jaba.titaniumblocks.core.sections.types;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import us.jaba.titaniumblocks.core.color.LcdGradientPalette;
import us.jaba.titaniumblocks.core.sections.ColorSection;
import us.jaba.titaniumblocks.core.color.ColorTools;

/**
 *
 * @author tbeckett
 */
public class LinearSection extends ColorSection
{

    private LcdGradientPalette lcdColor;
    private double start;
    private double stop;

    public double getStart()
    {
        return start;
    }

    public void setStart(double start)
    {
        this.start = start;
    }

    public double getStop()
    {
        return stop;
    }

    public void setStop(double stop)
    {
        this.stop = stop;
    }
    
    public LinearSection()
    {
        super(Color.GRAY);
        ArrayList<ColorSection> sections = new ArrayList();
        ArrayList<BufferedImage> sectionsBackground = new ArrayList(3);
        ArrayList<Color> sectionsForeground = new ArrayList(3);

        sectionsBackground.clear();
        sectionsForeground.clear();

        final float[] HSB_START = (Color.RGBtoHSB(lcdColor.getStartColor().getRed(), lcdColor.getStartColor().getGreen(), lcdColor.getStartColor().getBlue(), null));
        final float[] HSB_FRACTION1 = (Color.RGBtoHSB(lcdColor.getFirstQuarterColor().getRed(), lcdColor.getFirstQuarterColor().getGreen(), lcdColor.getFirstQuarterColor().getBlue(), null));
        final float[] HSB_FRACTION2 = (Color.RGBtoHSB(lcdColor.getMiddleColor().getRed(), lcdColor.getMiddleColor().getGreen(), lcdColor.getMiddleColor().getBlue(), null));
        final float[] HSB_FRACTION3 = (Color.RGBtoHSB(lcdColor.getThirdQuarterColor().getRed(), lcdColor.getThirdQuarterColor().getGreen(), lcdColor.getThirdQuarterColor().getBlue(), null));
        final float[] HSB_STOP = (Color.RGBtoHSB(lcdColor.getStopColor().getRed(), lcdColor.getStopColor().getGreen(), lcdColor.getStopColor().getBlue(), null));

        // Hue values of the gradient colors
        final float HUE_START = HSB_START[0];
        final float HUE_FRACTION1 = HSB_FRACTION1[0];
        final float HUE_FRACTION2 = HSB_FRACTION2[0];
        final float HUE_FRACTION3 = HSB_FRACTION3[0];
        final float HUE_STOP = HSB_STOP[0];

        // Brightness values of the gradient colors
        final float BRIGHTNESS_START = HSB_START[2];
        final float BRIGHTNESS_FRACTION1 = HSB_FRACTION1[2];
        final float BRIGHTNESS_FRACTION2 = HSB_FRACTION2[2];
        final float BRIGHTNESS_FRACTION3 = HSB_FRACTION3[2];
        final float BRIGHTNESS_STOP = HSB_STOP[2];

        for (ColorSection section : sections)
        {
            final Color[] BACKGROUND_COLORS;
            final Color FOREGROUND_COLOR;
            final float[] HSB_SECTION = Color.RGBtoHSB(section.getColor().getRed(), section.getColor().getGreen(), section.getColor().getBlue(), null);
            final float HUE_SECTION = HSB_SECTION[0];
//            final float SATURATION_SECTION = HSB_SECTION[1];
            final float BRIGHTNESS_SECTION = HSB_SECTION[2];
            if (!ColorTools.isMonochrome(section.getColor()))
            {
//                // ColorSection color is not monochrome
//                if (lcdColor == LcdColor.SECTIONS_LCD)
//                {
//                    BACKGROUND_COLORS = new Color[]
//                    {
//                        new Color(Color.HSBtoRGB(HUE_SECTION, SATURATION_SECTION, BRIGHTNESS_START - 0.31f)),
//                        new Color(Color.HSBtoRGB(HUE_SECTION, SATURATION_SECTION, BRIGHTNESS_FRACTION1 - 0.31f)),
//                        new Color(Color.HSBtoRGB(HUE_SECTION, SATURATION_SECTION, BRIGHTNESS_FRACTION2 - 0.31f)),
//                        new Color(Color.HSBtoRGB(HUE_SECTION, SATURATION_SECTION, BRIGHTNESS_FRACTION3 - 0.31f)),
//                        new Color(Color.HSBtoRGB(HUE_SECTION, SATURATION_SECTION, BRIGHTNESS_STOP - 0.31f))
//                    };
//                } else
//                {
                final float HUE_DIFF = HUE_SECTION - HUE_FRACTION3;
                BACKGROUND_COLORS = new Color[]
                {
                    ColorTools.setHue(lcdColor.getStartColor(), (HUE_START + HUE_DIFF) % 360),
                    ColorTools.setHue(lcdColor.getFirstQuarterColor(), (HUE_FRACTION1 + HUE_DIFF) % 360),
                    ColorTools.setHue(lcdColor.getMiddleColor(), (HUE_FRACTION2 + HUE_DIFF) % 360),
                    ColorTools.setHue(lcdColor.getThirdQuarterColor(), (HUE_FRACTION3 + HUE_DIFF) % 360),
                    ColorTools.setHue(lcdColor.getStopColor(), (HUE_STOP + HUE_DIFF) % 360)
                };
//                }
                FOREGROUND_COLOR = ColorTools.setSaturationBrightness(section.getColor(), 0.57f, 0.83f);
            } else
            {
                // ColorSection color is monochrome
                final float BRIGHTNESS_DIFF = BRIGHTNESS_SECTION - BRIGHTNESS_FRACTION1;

                BACKGROUND_COLORS = new Color[]
                {
                    ColorTools.setSaturationBrightness(lcdColor.getStartColor(), 0, BRIGHTNESS_START + BRIGHTNESS_DIFF),
                    ColorTools.setSaturationBrightness(lcdColor.getFirstQuarterColor(), 0, BRIGHTNESS_FRACTION1 + BRIGHTNESS_DIFF),
                    ColorTools.setSaturationBrightness(lcdColor.getMiddleColor(), 0, BRIGHTNESS_FRACTION2 + BRIGHTNESS_DIFF),
                    ColorTools.setSaturationBrightness(lcdColor.getThirdQuarterColor(), 0, BRIGHTNESS_FRACTION3 + BRIGHTNESS_DIFF),
                    ColorTools.setSaturationBrightness(lcdColor.getStopColor(), 0, BRIGHTNESS_STOP + BRIGHTNESS_DIFF)
                };
                if (ColorTools.isDark(section.getColor()))
                {
                    FOREGROUND_COLOR = Color.WHITE;
                } else
                {
                    FOREGROUND_COLOR = Color.BLACK;
                }
            }
//            sectionsBackground.add(create_LCD_Image(width, height, BACKGROUND_COLORS));
            sectionsForeground.add(FOREGROUND_COLOR);
        }

    }

}
