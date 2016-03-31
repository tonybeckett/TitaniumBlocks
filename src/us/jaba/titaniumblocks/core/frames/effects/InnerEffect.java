/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.frames.effects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import us.jaba.titaniumblocks.core.frames.BasicEffect;
import us.jaba.titaniumblocks.core.utils.PointSupport;

/**
 *
 * @author tbeckett
 */
public class InnerEffect implements BasicEffect
{

    private final float[] effectFractions = new float[]
    {
        0.0f,
        0.3f,
        0.5f,
        0.71f,
        1.0f
    };

    private final Color[] effectColors = new Color[]
    {
        new Color(0, 0, 0, 183),
        new Color(148, 148, 148, 25),
        new Color(0, 0, 0, 159),
        new Color(0, 0, 0, 81),
        new Color(255, 255, 255, 158)
    };

    public void apply(Graphics2D graphics2D, Area area, Dimension imageDim)
    {
        final Ellipse2D EFFECT_BIGINNERFRAME = new Ellipse2D.Double(imageDim.getWidth() * 0.0607476644217968, imageDim.getHeight() * 0.0607476644217968, imageDim.getWidth() * 0.8785046339035034, imageDim.getHeight() * 0.8785046339035034);
        final Point2D EFFECT_BIGINNERFRAME_START = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMinY());
        final Point2D EFFECT_BIGINNERFRAME_STOP = new Point2D.Double(0, EFFECT_BIGINNERFRAME.getBounds2D().getMaxY());

        PointSupport.validateGradientPoints(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP);
        final LinearGradientPaint EFFECT_BIGINNERFRAME_GRADIENT = new LinearGradientPaint(EFFECT_BIGINNERFRAME_START, EFFECT_BIGINNERFRAME_STOP, effectFractions, effectColors);
        graphics2D.setPaint(EFFECT_BIGINNERFRAME_GRADIENT);
        graphics2D.fill(EFFECT_BIGINNERFRAME);
    }

}
