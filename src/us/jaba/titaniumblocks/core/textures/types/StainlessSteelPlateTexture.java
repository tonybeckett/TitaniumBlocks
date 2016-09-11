/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.textures.types;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import us.jaba.titaniumblocks.core.gradients.paint.ConicalGradientPaint;
import us.jaba.titaniumblocks.core.textures.Texture;

/**
 *
 * @author tbeckett
 */
public class StainlessSteelPlateTexture extends Texture
{

    protected static final float[] FRACTIONS =
    {
        0f,
        0.03f,
        0.10f,
        0.14f,
        0.24f,
        0.33f,
        0.38f,
        0.5f,
        0.62f,
        0.67f,
        0.76f,
        0.81f,
        0.85f,
        0.97f,
        1.0f
    };

    protected static final Color[] COLORS =
    {
        new Color(0xFDFDFD),
        new Color(0xFDFDFD),
        new Color(0xB2B2B4),
        new Color(0xACACAE),
        new Color(0xFDFDFD),
        new Color(0x6E6E70),
        new Color(0x6E6E70),
        new Color(0xFDFDFD),
        new Color(0x6E6E70),
        new Color(0x6E6E70),
        new Color(0xFDFDFD),
        new Color(0xACACAE),
        new Color(0xB2B2B4),
        new Color(0xFDFDFD),
        new Color(0xFDFDFD)
    };

    public StainlessSteelPlateTexture()
    {
        
    }

    @Override
    public void paint(Graphics2D graphics2D, Dimension dimensions)
    {
    
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final Ellipse2D STEEL_CIRCLE = new Ellipse2D.Double(0, 0, dimensions.getWidth() / 2.0, dimensions.getHeight() / 2.0);
        final Point2D centerPoint = new Point2D.Double(STEEL_CIRCLE.getCenterX(), STEEL_CIRCLE.getCenterY());

        final ConicalGradientPaint GRADIENT = new ConicalGradientPaint(false, centerPoint, -0.45f, FRACTIONS, COLORS);
        int amount;
        final double TRANSLATE_STEP = dimensions.getWidth() / 4.0;
        graphics2D.translate(-TRANSLATE_STEP, -TRANSLATE_STEP);

        final AffineTransform OLD = graphics2D.getTransform();

        for (int y = 0; y < 5; y++)
        {
            if (y % 2 == 0)
            {
                amount = 3;
                graphics2D.translate(0, TRANSLATE_STEP * y);
            } else
            {
                amount = 2;
                graphics2D.translate(TRANSLATE_STEP, TRANSLATE_STEP * y);
            }

            for (int x = 0; x < amount; x++)
            {
                graphics2D.setPaint(GRADIENT);
                graphics2D.fill(STEEL_CIRCLE);
                graphics2D.translate(dimensions.getWidth() / 2.0, 0);
            }
            graphics2D.setTransform(OLD);
        }
        graphics2D.dispose();

       
    }

   
}
