/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.frames.effects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.BasicEffect;

/**
 *
 * @author tbeckett
 */
public class ConeEffect extends BasicEffect
{

    private final float[] effectFractions = new float[]
    {
        0.0f,
        0.82f,
        0.8201f,
        0.96f,
        0.9601f,
        1.0f
    };

    private final Color[] effectColors = new Color[]
    {
        new Color(0, 0, 0, 0),
        new Color(0, 0, 0, 76),
        new Color(0, 0, 0, 95),
        new Color(219, 219, 219, 153),
        new Color(255, 255, 255, 151),
        new Color(0, 0, 0, 102)
    };

    public void apply(Graphics2D graphics2D, Area area, Dimension imageDim)
    {
        final Point2D center = new Point2D.Double((0.5 * imageDim.getWidth()), (0.5 * imageDim.getHeight()));
        Paint paint = new RadialGradientPaint(center, (float) (0.5f * imageDim.getWidth()), effectFractions, effectColors);
        graphics2D.setPaint(paint);
        graphics2D.fill(area);
    }

}
