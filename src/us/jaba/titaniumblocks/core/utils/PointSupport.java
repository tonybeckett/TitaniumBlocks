/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.utils;

import java.awt.geom.Point2D;

/**
 *
 * @author tbeckett
 */
public class PointSupport
{

    public static boolean pointsEqual(final int X1, final int Y1, final int X2, final int Y2)
    {
        return (X1 == X2 && Y1 == Y2);
    }

    public static boolean pointsEqual(final float X1, final float Y1, final float X2, final float Y2)
    {
        return (Float.compare(X1, X2) == 0f) && (Float.compare(Y1, Y2) == 0f);
    }

    public static boolean pointsEquals(final double X1, final double Y1, final double X2, final double Y2)
    {
        return (Double.compare(X1, X2) == 0d) && (Double.compare(Y1, Y2) == 0);
    }

    public static boolean pointsEqual(final Point2D P1, final Point2D P2)
    {
        return P1.equals(P2);
    }

    public static void validateGradientPoints(final Point2D P1, final Point2D P2)
    {
        if (pointsEqual(P1, P2))
        {
            P2.setLocation(P2.getX(), P2.getY() + 1);
        }
    }
}
