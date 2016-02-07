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
package us.jaba.titaniumblocks.core.math;

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import us.jaba.titaniumblocks.core.layout.CircularLayout;
import us.jaba.titaniumblocks.core.layout.CircularTwoPostLayout;
import us.jaba.titaniumblocks.core.math.CoordinateDefs.Direction;

/**
 *
 * @author tbeckett
 */
public class CoordinateUtilsTest
{

    public CoordinateUtilsTest()
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
     * Test of toPointUsing method, of class CoordinateUtils.
     */
    @Test
    public void testToPointUsing()
    {
        System.out.println("toPointUsing");
        double r = 2.4;
        double theta = 0.033;
        Point2D expResult = new Point2D.Double(2.3986, 0.07918);
        Point2D result = CoordinateUtils.toPointUsing(r, theta);
        assertEquals(expResult.getX(), result.getX(), 0.0001);
        assertEquals(expResult.getY(), result.getY(), 0.0001);

    }

    /**
     * Test of toPoint method, of class CoordinateUtils.
     */
    @Test
    public void testToPoint()
    {
        System.out.println("toPoint");
        Polar p = new Polar(3.2, 55.0);
        Point2D expResult = new Point2D.Double(0.0708, -3.1992);
        Point2D result = CoordinateUtils.toPoint(p);
       assertEquals(expResult.getX(), result.getX(), 0.0001);
        assertEquals(expResult.getY(), result.getY(), 0.0001);
    }

    /**
     * Test of toPolar method, of class CoordinateUtils.
     */
    @Test
    public void testToPolar()
    {
        System.out.println("toPolar");
        Point2D p = new Point2D.Double(4.5, 44.2);
        Polar expResult = new Polar(44.42848, 1.46933);;
        Polar result = CoordinateUtils.toPolar(p);
        assertEquals(expResult.getR(), result.getR(), 0.0001);
        assertEquals(expResult.getTheta(), result.getTheta(), 0.0001);

    }

    /**
     * Test of toPolarWithCenter method, of class CoordinateUtils.
     */
    @Test
    public void testToPolarWithCenter()
    {
        System.out.println("toPolarWithCenter");
        Point2D center = new Point2D.Double(2.0, 3.0);
        Point2D dest = new Point2D.Double(4.5, 44.2);
        Polar expResult = new Polar(41.27577, 1.51019);
        Polar result = CoordinateUtils.toPolarWithCenter(center, dest);
        assertEquals(expResult.getR(), result.getR(), 0.0001);
        assertEquals(expResult.getTheta(), result.getTheta(), 0.0001);

    }

    /**
     * Test of toPoint2DFromCenter method, of class CoordinateUtils.
     */
    @Test
    public void testToPoint2DFromCenter()
    {
        System.out.println("toPoint2DFromCenter");
        Point2D center = new Point2D.Double(2.0, 3.0);
        Polar p = new Polar(3.2, 55.0);;
        Point2D expResult = new Point2D.Double(1.82656, 10.8364);;
        Point2D result = CoordinateUtils.toPoint2DFromCenter(center, p);
        assertEquals(expResult.getX(), result.getX(), 0.0001);
        assertEquals(expResult.getY(), result.getY(), 0.0001);
    }

    /**
     * Test of calcExtent method, of class CoordinateUtils.
     */
    @Test
    public void testCalcExtent1()
    {
        System.out.println("calcExtent1");
        double startAngle = 270.0;
        double endAngle = 90.0;
        CoordinateDefs.Direction direction = Direction.CLOCKWISE;
        double expResult = 180.0;
        double result = CoordinateUtils.calcExtent(startAngle, endAngle, direction);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcExtent method, of class CoordinateUtils.
     */
    @Test
    public void testCalcExtent2()
    {
        System.out.println("calcExtent2");
        double startAngle = 80.0;
        double endAngle = 120.0;
        CoordinateDefs.Direction direction = Direction.COUNTER;
        double expResult = 320.0;
        double result = CoordinateUtils.calcExtent(startAngle, endAngle, direction);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcExtent method, of class CoordinateUtils.
     */
    @Test
    public void testCalcExtent3()
    {
        System.out.println("calcExtent3");
        double startAngle = 340.0;
        double endAngle = 25.0;
        CoordinateDefs.Direction direction = Direction.COUNTER;
        double expResult = 315.0;
        double result = CoordinateUtils.calcExtent(startAngle, endAngle, direction);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcExtent method, of class CoordinateUtils.
     */
    @Test
    public void testCalcExtent4()
    {
        System.out.println("calcExtent4");
        double startAngle = 340.0;
        double endAngle = 250.0;
        CoordinateDefs.Direction direction = Direction.CLOCKWISE;
        double expResult = 270.0;
        double result = CoordinateUtils.calcExtent(startAngle, endAngle, direction);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calcGraphicsAngle method, of class CoordinateUtils.
     */
    @Test
    public void testCalcGraphicsAngle()
    {
        System.out.println("calcGraphicsAngle");
        double normalizedValue = 0.5;
        CircularLayout circularLayout = new CircularTwoPostLayout(270, 90, CoordinateDefs.Direction.CLOCKWISE, 0.95f, 185, 355);
        double expResult = 2.0 * Math.PI;
        double result = CoordinateUtils.calcGraphicsAngle(normalizedValue, circularLayout);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcGraphicsAngle method, of class CoordinateUtils.
     */
    @Test
    public void testCalcGraphicsAngle2()
    {
        System.out.println("calcGraphicsAngle2");
        double normalizedValue = 0.01;
        CircularLayout circularLayout = new CircularTwoPostLayout(270, 90, CoordinateDefs.Direction.CLOCKWISE, 0.95f, 185, 355);
        double expResult = 271.8;
        double result = CoordinateUtils.toDegrees(CoordinateUtils.calcGraphicsAngle(normalizedValue, circularLayout));
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcPosition method, of class CoordinateUtils.
     */
    @Test
    public void testCalcPosition()
    {
        System.out.println("calcPosition");
        Point2D centerPoint = new Point2D.Double(200,200);
        double radius = 100.0;
        double angle = 270.0;
        Point2D expResult = new Point2D.Double(100,200);
        Point2D result = CoordinateUtils.calcPosition(centerPoint, radius, angle);
        assertEquals(expResult.getX(), result.getX(), 0.0001);
        assertEquals(expResult.getY(), result.getY(), 0.0001);
    }

    /**
     * Test of toRadians method, of class CoordinateUtils.
     */
    @Test
    public void testToRadians()
    {
        System.out.println("toRadians");
        double degrees = 0.0;
        double expResult = 0.0;
        double result = CoordinateUtils.toRadians(degrees);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toDegrees method, of class CoordinateUtils.
     */
    @Test
    public void testToDegrees()
    {
        System.out.println("toDegrees");
        double radians = 0.0;
        double expResult = 0.0;
        double result = CoordinateUtils.toDegrees(radians);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normalizeRadians method, of class CoordinateUtils.
     */
    @Test
    public void testNormalizeRadians()
    {
        System.out.println("normalizeRadians");
        double angle = 0.0;
        double expResult = 0.0;
        double result = CoordinateUtils.normalizeRadians(angle);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normalizeDegrees method, of class CoordinateUtils.
     */
    @Test
    public void testNormalizeDegrees()
    {
        System.out.println("normalizeDegrees");
        double angle = 0.0;
        double expResult = 0.0;
        double result = CoordinateUtils.normalizeDegrees(angle);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
}
