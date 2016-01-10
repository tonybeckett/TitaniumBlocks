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
package us.jaba.titaniumblocks.core.color;

import java.awt.Color;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tbeckett
 */
public class ColorToolsTest
{
    
    public ColorToolsTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of setAlpha method, of class ColorTools.
     */
    @Test
    public void testSetAlpha_Color_float()
    {
        System.out.println("setAlpha");
        Color COLOR = new Color(8,8,128);
        float ALPHA = 0.02F;
        Color expResult = new Color(8,8,128);
        Color result = ColorTools.setAlpha(COLOR, ALPHA);
        assertEquals(expResult.getRed(), result.getRed());
        assertEquals(expResult.getGreen(), result.getGreen());
        assertEquals(expResult.getBlue(), result.getBlue());
        assertEquals(6, result.getAlpha());
    }

    /**
     * Test of setAlpha method, of class ColorTools.
     */
    @Test
    public void testSetAlpha_Color_int()
    {
        System.out.println("setAlpha");
        Color COLOR = new Color(128,128,128);
        int ALPHA = 12;
        Color expResult = new Color(128,128,128);
        Color result = ColorTools.setAlpha(COLOR, ALPHA);
         assertEquals(expResult.getRed(), result.getRed());
        assertEquals(expResult.getGreen(), result.getGreen());
        assertEquals(expResult.getBlue(), result.getBlue());
        assertEquals(12, result.getAlpha());
    }

    /**
     * Test of getColorFromFraction method, of class ColorTools.
     */
    @Test
    public void testGetColorFromFraction()
    {
        System.out.println("getColorFromFraction");
        Color SOURCE_COLOR = null;
        Color DESTINATION_COLOR = null;
        int RANGE = 0;
        int CURRENT_FRACTION = 0;
        Color expResult = null;
        Color result = ColorTools.getColorFromFraction(SOURCE_COLOR, DESTINATION_COLOR, RANGE, CURRENT_FRACTION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of interpolateColor method, of class ColorTools.
     */
    @Test
    public void testInterpolateColor()
    {
        System.out.println("interpolateColor");
        Color COLOR1 = null;
        Color COLOR2 = null;
        float FRACTION = 0.0F;
        Color expResult = null;
        Color result = ColorTools.interpolateColor(COLOR1, COLOR2, FRACTION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bilinearInterpolateColor method, of class ColorTools.
     */
    @Test
    public void testBilinearInterpolateColor()
    {
        System.out.println("bilinearInterpolateColor");
        Color COLOR_UL = null;
        Color COLOR_UR = null;
        Color COLOR_LL = null;
        Color COLOR_LR = null;
        float FRACTION_X = 0.0F;
        float FRACTION_Y = 0.0F;
        Color expResult = null;
        Color result = ColorTools.bilinearInterpolateColor(COLOR_UL, COLOR_UR, COLOR_LL, COLOR_LR, FRACTION_X, FRACTION_Y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHue method, of class ColorTools.
     */
    @Test
    public void testSetHue()
    {
        System.out.println("setHue");
        Color COLOR = null;
        float HUE = 0.0F;
        Color expResult = null;
        Color result = ColorTools.setHue(COLOR, HUE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaturation method, of class ColorTools.
     */
    @Test
    public void testSetSaturation()
    {
        System.out.println("setSaturation");
        Color COLOR = null;
        float SATURATION = 0.0F;
        Color expResult = null;
        Color result = ColorTools.setSaturation(COLOR, SATURATION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBrightness method, of class ColorTools.
     */
    @Test
    public void testSetBrightness()
    {
        System.out.println("setBrightness");
        Color COLOR = null;
        float BRIGHTNESS = 0.0F;
        Color expResult = null;
        Color result = ColorTools.setBrightness(COLOR, BRIGHTNESS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHueSaturation method, of class ColorTools.
     */
    @Test
    public void testSetHueSaturation()
    {
        System.out.println("setHueSaturation");
        Color COLOR = null;
        float HUE = 0.0F;
        float SATURATION = 0.0F;
        Color expResult = null;
        Color result = ColorTools.setHueSaturation(COLOR, HUE, SATURATION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaturationBrightness method, of class ColorTools.
     */
    @Test
    public void testSetSaturationBrightness()
    {
        System.out.println("setSaturationBrightness");
        Color COLOR = null;
        float SATURATION = 0.0F;
        float BRIGHTNESS = 0.0F;
        Color expResult = null;
        Color result = ColorTools.setSaturationBrightness(COLOR, SATURATION, BRIGHTNESS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of darker method, of class ColorTools.
     */
    @Test
    public void testDarker()
    {
        System.out.println("darker");
        Color COLOR = null;
        double FRACTION = 0.0;
        Color expResult = null;
        Color result = ColorTools.darker(COLOR, FRACTION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lighter method, of class ColorTools.
     */
    @Test
    public void testLighter()
    {
        System.out.println("lighter");
        Color COLOR = null;
        double FRACTION = 0.0;
        Color expResult = null;
        Color result = ColorTools.lighter(COLOR, FRACTION);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colorDistance method, of class ColorTools.
     */
    @Test
    public void testColorDistance()
    {
        System.out.println("colorDistance");
        Color COLOR1 = null;
        Color COLOR2 = null;
        double expResult = 0.0;
        double result = ColorTools.colorDistance(COLOR1, COLOR2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDark method, of class ColorTools.
     */
    @Test
    public void testIsDark()
    {
        System.out.println("isDark");
        Color COLOR = null;
        boolean expResult = false;
        boolean result = ColorTools.isDark(COLOR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMonochrome method, of class ColorTools.
     */
    @Test
    public void testIsMonochrome()
    {
        System.out.println("isMonochrome");
        Color COLOR = null;
        boolean expResult = false;
        boolean result = ColorTools.isMonochrome(COLOR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createShades method, of class ColorTools.
     */
    @Test
    public void testCreateShades()
    {
        System.out.println("createShades");
        float INTENSITY = 0.0F;
        Color COLOR = null;
        ColorTools instance = new ColorTools();
        LinkedList<Color> expResult = null;
        LinkedList<Color> result = instance.createShades(INTENSITY, COLOR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
