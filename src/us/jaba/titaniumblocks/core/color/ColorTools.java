/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.color;

import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author tbeckett
 */
public class ColorTools
{

    private static final float INT_TO_FLOAT_CONST = 1f / 255f;

    public static Color invert(Color gradientStartColor)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns the given COLOR with the given ALPHA transparency
     *
     * @param COLOR
     * @param ALPHA
     * @return Color with the given float transparency
     */
    public static Color setAlpha(final Color color, final float ALPHA)
    {
        if (ALPHA > 1)
        {
            return setAlpha(color, 255);
        }
        if (ALPHA < 0)
        {
            return setAlpha(color, 0);
        }
        return setAlpha(color, (int) (Math.ceil(255 * ALPHA)));
    }

    /**
     * Return the given COLOR with the given ALPHA transparency
     *
     * @param COLOR
     * @param ALPHA
     * @return Color with given integer transparency
     */
    public static Color setAlpha(final Color color, final int ALPHA)
    {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), ALPHA);
    }

    /**
     * Returns the color that equals the value from CURRENT_FRACTION in a RANGE
     * of values where the start of the RANGE equals the SOURCE_COLOR and the
     * end of the RANGE equals the DESTINATION_COLOR. In other words you could
     * get any color in a gradient between to colors by a given value.
     *
     * @param SOURCE_COLOR
     * @param DESTINATION_COLOR
     * @param RANGE
     * @param CURRENT_FRACTION
     * @return Color that was calculated by a fraction from a range of values.
     */
    public static Color getColorFromFraction(final Color SOURCE_COLOR, final Color DESTINATION_COLOR, final int RANGE, final int CURRENT_FRACTION)
    {
        final float SOURCE_RED = SOURCE_COLOR.getRed() * INT_TO_FLOAT_CONST;
        final float SOURCE_GREEN = SOURCE_COLOR.getGreen() * INT_TO_FLOAT_CONST;
        final float SOURCE_BLUE = SOURCE_COLOR.getBlue() * INT_TO_FLOAT_CONST;
        final float SOURCE_ALPHA = SOURCE_COLOR.getAlpha() * INT_TO_FLOAT_CONST;

        final float DESTINATION_RED = DESTINATION_COLOR.getRed() * INT_TO_FLOAT_CONST;
        final float DESTINATION_GREEN = DESTINATION_COLOR.getGreen() * INT_TO_FLOAT_CONST;
        final float DESTINATION_BLUE = DESTINATION_COLOR.getBlue() * INT_TO_FLOAT_CONST;
        final float DESTINATION_ALPHA = DESTINATION_COLOR.getAlpha() * INT_TO_FLOAT_CONST;

        final float RED_DELTA = DESTINATION_RED - SOURCE_RED;
        final float GREEN_DELTA = DESTINATION_GREEN - SOURCE_GREEN;
        final float BLUE_DELTA = DESTINATION_BLUE - SOURCE_BLUE;
        final float ALPHA_DELTA = DESTINATION_ALPHA - SOURCE_ALPHA;

        final float RED_FRACTION = RED_DELTA / RANGE;
        final float GREEN_FRACTION = GREEN_DELTA / RANGE;
        final float BLUE_FRACTION = BLUE_DELTA / RANGE;
        final float ALPHA_FRACTION = ALPHA_DELTA / RANGE;

        return new Color(SOURCE_RED + RED_FRACTION * CURRENT_FRACTION, SOURCE_GREEN + GREEN_FRACTION * CURRENT_FRACTION, SOURCE_BLUE + BLUE_FRACTION * CURRENT_FRACTION, SOURCE_ALPHA + ALPHA_FRACTION * CURRENT_FRACTION);
    }

    /**
     * Returns the interpolated color that you get if you multiply the delta
     * between color2 and color1 with the given fraction (for each channel) and
     * interpolation. The fraction should be a value between 0 and 1.
     *
     * @param COLOR1 The first color as integer in the hex format 0xALPHA RED
     * GREEN BLUE, e.g. 0xFF00FF00 for a pure green
     * @param COLOR2 The second color as integer in the hex format 0xALPHA RED
     * GREEN BLUE e.g. 0xFFFF0000 for a pure red
     * @param FRACTION The fraction between those two colors that we would like
     * to get e.g. 0.5f will result in the color 0xFF808000
     * @return the interpolated color between color1 and color2 calculated by
     * the given fraction and interpolation
     */
    public static Color interpolateColor(final Color color1, final Color color2, final float FRACTION)
    {
        assert (Float.compare(FRACTION, 0f) >= 0 && Float.compare(FRACTION, 1f) <= 0);

        final float RED1 = color1.getRed() * INT_TO_FLOAT_CONST;
        final float GREEN1 = color1.getGreen() * INT_TO_FLOAT_CONST;
        final float BLUE1 = color1.getBlue() * INT_TO_FLOAT_CONST;
        final float ALPHA1 = color1.getAlpha() * INT_TO_FLOAT_CONST;

        final float RED2 = color2.getRed() * INT_TO_FLOAT_CONST;
        final float GREEN2 = color2.getGreen() * INT_TO_FLOAT_CONST;
        final float BLUE2 = color2.getBlue() * INT_TO_FLOAT_CONST;
        final float ALPHA2 = color2.getAlpha() * INT_TO_FLOAT_CONST;

        final float DELTA_RED = RED2 - RED1;
        final float DELTA_GREEN = GREEN2 - GREEN1;
        final float DELTA_BLUE = BLUE2 - BLUE1;
        final float DELTA_ALPHA = ALPHA2 - ALPHA1;

        float red = RED1 + (DELTA_RED * FRACTION);
        float green = GREEN1 + (DELTA_GREEN * FRACTION);
        float blue = BLUE1 + (DELTA_BLUE * FRACTION);
        float alpha = ALPHA1 + (DELTA_ALPHA * FRACTION);

        red = red < 0f ? 0f : (red > 1f ? 1f : red);
        green = green < 0f ? 0f : (green > 1f ? 1f : green);
        blue = blue < 0f ? 0f : (blue > 1f ? 1f : blue);
        alpha = alpha < 0f ? 0f : (alpha > 1f ? 1f : alpha);

        return new Color(red, green, blue, alpha);
    }

    /**
     * Returns the color calculated by a bilinear interpolation by the two
     * fractions in x and y direction. To get the color of the point defined by
     * FRACTION_X and FRACTION_Y with in the rectangle defined by the for given
     * colors we first calculate the interpolated color between COLOR_00 and
     * COLOR_10 (x-direction) with the given FRACTION_X. After that we calculate
     * the interpolated color between COLOR_01 and COLOR_11 (x-direction) with
     * the given FRACTION_X. Now we interpolate between the two results of the
     * former calculations (y-direction) with the given FRACTION_Y.
     *
     * @param COLOR_UL The color on the lower left corner of the square
     * @param COLOR_UR The color on the lower right corner of the square
     * @param COLOR_LL The color on the upper left corner of the square
     * @param COLOR_LR The color on the upper right corner of the square
     * @param FRACTION_X The fraction of the point in x direction (between
     * COLOR_00 and COLOR_10 or COLOR_01 and COLOR_11) range: 0.0f .. 1.0f
     * @param FRACTION_Y The fraction of the point in y direction (between
     * COLOR_00 and COLOR_01 or COLOR_10 and COLOR_11) range: 0.0f .. 1.0f
     * @return the color of the point defined by fraction_x and fraction_y in
     * the square defined by the for colors
     */
    public static Color bilinearInterpolateColor(final Color COLOR_UL, final Color COLOR_UR, final Color COLOR_LL, final Color COLOR_LR, final float FRACTION_X, final float FRACTION_Y)
    {
        final Color INTERPOLATED_COLOR_X1 = interpolateColor(COLOR_UL, COLOR_UR, FRACTION_X);
        final Color INTERPOLATED_COLOR_X2 = interpolateColor(COLOR_LL, COLOR_LR, FRACTION_X);
        return interpolateColor(INTERPOLATED_COLOR_X1, INTERPOLATED_COLOR_X2, FRACTION_Y);
    }

    /**
     * Returns the given COLOR with the given HUE
     *
     * @param COLOR
     * @param HUE
     * @return Color with a given hue
     */
    public static Color setHue(final Color color, final float HUE)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(HUE, HSB_VALUES[1], HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given SATURATION which is really useful
     * if you would like to receive a red tone that has the same brightness and
     * hue as a given blue tone.
     *
     * @param COLOR
     * @param SATURATION
     * @return Color with a given saturation
     */
    public static Color setSaturation(final Color color, final float SATURATION)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], SATURATION, HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given BRIGHTNESS
     *
     * @param COLOR
     * @param BRIGHTNESS
     * @return Color with the given brightness
     */
    public static Color setBrightness(final Color color, final float BRIGHTNESS)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], HSB_VALUES[1], BRIGHTNESS);
    }

    /**
     * Returns the given COLOR with the given HUE an SATURATION
     *
     * @param COLOR
     * @param HUE
     * @param SATURATION
     * @return the given COLOR with the given HUE and SATURATION
     */
    public static Color setHueSaturation(final Color color, final float HUE, final float SATURATION)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(HUE, SATURATION, HSB_VALUES[2]);
    }

    /**
     * Returns the given COLOR with the given SATURATION and BRIGHTNESS
     *
     * @param COLOR
     * @param SATURATION
     * @param BRIGHTNESS
     * @return the given COLOR with the given SATURATION and BRIGHTNESS
     */
    public static Color setSaturationBrightness(final Color color, final float SATURATION, final float BRIGHTNESS)
    {
        final float HSB_VALUES[] = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(HSB_VALUES[0], SATURATION, BRIGHTNESS);
    }

    /**
     * Returns a darker version of the given color
     *
     * @param COLOR
     * @param FRACTION
     * @return a darker version of the given color
     */
    public static Color darker(final Color color, final double FRACTION)
    {
        int red = (int) Math.round(color.getRed() * (1.0 - FRACTION));
        int green = (int) Math.round(color.getGreen() * (1.0 - FRACTION));
        int blue = (int) Math.round(color.getBlue() * (1.0 - FRACTION));

        red = red < 0 ? 0 : (red > 255 ? 255 : red);
        green = green < 0 ? 0 : (green > 255 ? 255 : green);
        blue = blue < 0 ? 0 : (blue > 255 ? 255 : blue);

        return new Color(red, green, blue, color.getAlpha());
    }

    /**
     * Returns a brighter version of the given color
     *
     * @param COLOR
     * @param FRACTION
     * @return a brighter version of the given color
     */
    public static Color lighter(final Color color, final double FRACTION)
    {
        int red = (int) Math.round(color.getRed() * (1.0 + FRACTION));
        int green = (int) Math.round(color.getGreen() * (1.0 + FRACTION));
        int blue = (int) Math.round(color.getBlue() * (1.0 + FRACTION));

        red = red < 0 ? 0 : (red > 255 ? 255 : red);
        green = green < 0 ? 0 : (green > 255 ? 255 : green);
        blue = blue < 0 ? 0 : (blue > 255 ? 255 : blue);

        return new Color(red, green, blue, color.getAlpha());
    }

    /**
     * Return the "distance" between two colors where the rgb values are are
     * taken to be coordinates in a 3D space [0.0-1.0].
     *
     * @param COLOR1
     * @param COLOR2
     * @return Distance bwetween colors.
     */
    public static double colorDistance(final Color color1, final Color color2)
    {
        final double FACTOR = 1.0 / 255.0;
        final double DELTA_R = (color2.getRed() - color1.getRed()) * FACTOR;
        final double DELTA_G = (color2.getGreen() - color1.getGreen()) * FACTOR;
        final double DELTA_B = (color2.getBlue() - color1.getBlue()) * FACTOR;

        return Math.sqrt(DELTA_R * DELTA_R + DELTA_G * DELTA_G + DELTA_B * DELTA_B);
    }

    /**
     * Returns true if the given color is closer to black than to white. To get
     * the result we calculate the colorDistance from the given color to black
     * and compare it with the colorDistance from the given color to white.
     *
     * @param COLOR
     * @return true if the given color is closer to black than white
     */
    public static boolean isDark(final Color color)
    {
        final double DISTANCE_TO_WHITE = colorDistance(color, Color.WHITE);
        final double DISTANCE_TO_BLACK = colorDistance(color, Color.BLACK);

        return DISTANCE_TO_BLACK < DISTANCE_TO_WHITE;
    }

    /**
     * Returns true if the red, green and blue value of the given color are
     * equal
     *
     * @param COLOR
     * @return true if the red, green and blue value of the given color are
     * equal
     */
    public static boolean isMonochrome(final Color color)
    {
        return ((color.getRed() == color.getGreen()) && (color.getGreen() == color.getBlue()));
    }

    /**
     * Returns a list of 9 shades of the given color which will be calculated by
     * the given intensity. The 5 element of the list is the same as the igven
     * color which means you will get 4 darker colors and 4 brighter colors of
     * the given color.
     *
     * @param INTENSITY
     * @param COLOR
     * @return a list of 9 shades of the given color, 4 darker, the original and
     * 4 brighter colors
     */
    public LinkedList<Color> createShades(final float INTENSITY, final Color color)
    {
        final float[] HSB = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        final float SATURATION_STEPSIZE = HSB[1] / INTENSITY;
        final float BRIGHTNESS_STEPSIZE = HSB[2] / INTENSITY;
        LinkedList<Color> colorShades = new LinkedList<Color>();
        for (int i = 4; i > 0; i--)
        {
            colorShades.add(new HsbColor.Builder(color).saturation(HSB[1] - i * SATURATION_STEPSIZE).build().getColor());
        }
        colorShades.add(color);
        for (int i = 4; i > 0; i--)
        {
            colorShades.add(new HsbColor.Builder(color).brightness(HSB[2] - i * BRIGHTNESS_STEPSIZE).build().getColor());
        }
        return colorShades;
    }

}
