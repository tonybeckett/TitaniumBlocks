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
package us.jaba.titaniumblocks.core.tickmarks.ticks;

import java.awt.geom.Point2D;
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
public class RadialTickTest
{
    
    public RadialTickTest()
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
     * Test of getTextPoint method, of class RadialTick.
     */
    @Test
    public void testGetTextPoint()
    {
        System.out.println("getTextPoint");
        RadialTick instance = new RadialTick();
        Point2D expResult = null;
        Point2D result = instance.getTextPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInnerPoint method, of class RadialTick.
     */
    @Test
    public void testGetInnerPoint()
    {
        System.out.println("getInnerPoint");
        RadialTick instance = new RadialTick();
        Point2D expResult = null;
        Point2D result = instance.getInnerPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOuterPoint method, of class RadialTick.
     */
    @Test
    public void testGetOuterPoint()
    {
        System.out.println("getOuterPoint");
        RadialTick instance = new RadialTick();
        Point2D expResult = null;
        Point2D result = instance.getOuterPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextDistance method, of class RadialTick.
     */
    @Test
    public void testGetTextDistance()
    {
        System.out.println("getTextDistance");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getTextDistance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextDistance method, of class RadialTick.
     */
    @Test
    public void testSetTextDistance()
    {
        System.out.println("setTextDistance");
        double textDistance = 0.0;
        RadialTick instance = new RadialTick();
        instance.setTextDistance(textDistance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCenterPoint method, of class RadialTick.
     */
    @Test
    public void testGetCenterPoint()
    {
        System.out.println("getCenterPoint");
        RadialTick instance = new RadialTick();
        Point2D expResult = null;
        Point2D result = instance.getCenterPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCenterPoint method, of class RadialTick.
     */
    @Test
    public void testSetCenterPoint()
    {
        System.out.println("setCenterPoint");
        Point2D centerPoint = new Point2D.Double(100,100);
        RadialTick instance = new RadialTick();
        instance.setCenterPoint(centerPoint);
         
    }

    /**
     * Test of getAngle method, of class RadialTick.
     */
    @Test
    public void testGetAngle()
    {
        System.out.println("getAngle");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAngle method, of class RadialTick.
     */
    @Test
    public void testSetAngle1()
    {
        System.out.println("setAngle1");
        double angle = 270.0;
        RadialTick instance = new RadialTick();
        instance.setCenterPoint(new Point2D.Double(100,100));
        instance.setRadius(20.0);
        instance.setTickLength(5.0);
        instance.setAngle(angle);
        double expResult = 80.0;
         Point2D result = instance.getOuterPoint();
        assertEquals(expResult, result.getX(), 0.0);
    }
    
    /**
     * Test of setAngle method, of class RadialTick.
     */
    @Test
    public void testSetAngle2()
    {
        System.out.println("setAngle2");
        double angle = 0.0;
        RadialTick instance = new RadialTick();
        instance.setCenterPoint(new Point2D.Double(100,100));
        instance.setRadius(20.0);
        instance.setTickLength(5.0);
        instance.setAngle(angle);
        double expResult = 120.0;
         Point2D result = instance.getOuterPoint();
        assertEquals(expResult, result.getX(), 0.0);
    }

    /**
     * Test of getRadius method, of class RadialTick.
     */
    @Test
    public void testGetRadius()
    {
        System.out.println("getRadius");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getRadius();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRadius method, of class RadialTick.
     */
    @Test
    public void testSetRadius()
    {
        System.out.println("setRadius");
        double radius = 0.0;
        RadialTick instance = new RadialTick();
        instance.setRadius(radius);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTickLength method, of class RadialTick.
     */
    @Test
    public void testGetTickLength()
    {
        System.out.println("getTickLength");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getTickLength();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTickLength method, of class RadialTick.
     */
    @Test
    public void testSetTickLength()
    {
        System.out.println("setTickLength");
        double tickLength = 0.0;
        RadialTick instance = new RadialTick();
        instance.setTickLength(tickLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class RadialTick.
     */
    @Test
    public void testSetValue()
    {
        System.out.println("setValue");
        double value = 0.0;
        RadialTick instance = new RadialTick();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class RadialTick.
     */
    @Test
    public void testGetValue()
    {
        System.out.println("getValue");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextAngle method, of class RadialTick.
     */
    @Test
    public void testGetTextAngle()
    {
        System.out.println("getTextAngle");
        RadialTick instance = new RadialTick();
        double expResult = 0.0;
        double result = instance.getTextAngle();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextAngle method, of class RadialTick.
     */
    @Test
    public void testSetTextAngle()
    {
        System.out.println("setTextAngle");
        double textAngle = 0.0;
        RadialTick instance = new RadialTick();
        instance.setTextAngle(textAngle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}
