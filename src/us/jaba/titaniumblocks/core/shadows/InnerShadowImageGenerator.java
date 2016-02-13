/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.shadows;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.image.SoftClipImageGenerator;

/**
 *
 * @author tbeckett
 */
public class InnerShadowImageGenerator
{

    /**
     * <p>
     * Method to create a inner shadow on a given shape</p>
     *
     * @param SOFT_CLIP_IMAGE softclipimage create by method
     * createSoftClipImage()
     * @param SHAPE shape that should get the inner shadow
     * @param DISTANCE distance of the shadow
     * @param ALPHA alpha value of the shadow
     * @param SHADOW_COLOR color of the shadow
     * @param SOFTNESS softness/fuzzyness of the shadow
     * @param ANGLE angle under which the shadow should appear
     * @return IMAGE buffered image that contains the shape including the inner
     * shadow
     */
    public static BufferedImage create(final BufferedImage SOFT_CLIP_IMAGE, final Shape SHAPE, final int DISTANCE, final float ALPHA, final Color SHADOW_COLOR, final int SOFTNESS, final int ANGLE)
    {
        final float COLOR_CONSTANT = 1f / 255f;
        final float RED = COLOR_CONSTANT * SHADOW_COLOR.getRed();
        final float GREEN = COLOR_CONSTANT * SHADOW_COLOR.getGreen();
        final float BLUE = COLOR_CONSTANT * SHADOW_COLOR.getBlue();
        final float MAX_STROKE_WIDTH = SOFTNESS * 2;
        final float ALPHA_STEP = 1f / (2 * SOFTNESS + 2) * ALPHA;
        final float TRANSLATE_X = (float) (DISTANCE * Math.cos(Math.toRadians(ANGLE)));
        final float TRANSLATE_Y = (float) (DISTANCE * Math.sin(Math.toRadians(ANGLE)));

        final Graphics2D G2 = SOFT_CLIP_IMAGE.createGraphics();

        // Enable Antialiasing
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Translate the coordinate system to 0,0
        G2.translate(-SHAPE.getBounds2D().getX(), -SHAPE.getBounds2D().getY());

        // Set the color
        G2.setColor(new Color(RED, GREEN, BLUE, ALPHA_STEP));

        // Set the alpha transparency of the whole image
        G2.setComposite(AlphaComposite.SrcAtop);

        // Translate the coordinate system related to the given distance and angle
        G2.translate(TRANSLATE_X, -TRANSLATE_Y);

        // Draw the inner shadow
        for (double strokeWidth = SOFTNESS; strokeWidth >= 1; strokeWidth -= 1)
        {
            G2.setStroke(new BasicStroke((float) (MAX_STROKE_WIDTH * Math.pow(0.85, strokeWidth))));
            G2.draw(SHAPE);
        }

        G2.dispose();

        return SOFT_CLIP_IMAGE;
    }

    /**
     * <p>
     * Method to create a inner shadow on a given shape</p>
     *
     * @param SHAPE shape that should get the inner shadow
     * @param SHAPE_PAINT paint of the given shape
     * @param DISTANCE distance of the shadow
     * @param ALPHA alpha value of the shadow
     * @param SHADOW_COLOR color of the shadow
     * @param SOFTNESS softness/fuzzyness of the shadow
     * @param ANGLE angle under which the shadow should appear
     * @return IMAGE buffered image that contains the shape including the inner
     * shadow
     */
    public static BufferedImage create(final Shape SHAPE, final Paint SHAPE_PAINT, final int DISTANCE, final float ALPHA, final Color SHADOW_COLOR, final int SOFTNESS, final int ANGLE)
    {
        final float COLOR_CONSTANT = 1f / 255f;
        final float RED = COLOR_CONSTANT * SHADOW_COLOR.getRed();
        final float GREEN = COLOR_CONSTANT * SHADOW_COLOR.getGreen();
        final float BLUE = COLOR_CONSTANT * SHADOW_COLOR.getBlue();
        final float MAX_STROKE_WIDTH = SOFTNESS * 2;
        final float ALPHA_STEP = 1f / (2 * SOFTNESS + 2) * ALPHA;
        final float TRANSLATE_X = (float) (DISTANCE * Math.cos(Math.toRadians(ANGLE)));
        final float TRANSLATE_Y = (float) (DISTANCE * Math.sin(Math.toRadians(ANGLE)));

        final BufferedImage IMAGE = SoftClipImageGenerator.create(SHAPE, SHAPE_PAINT, 0, 0, 0);

        final Graphics2D G2 = IMAGE.createGraphics();

        // Enable Antialiasing
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Translate the coordinate system to 0,0
        G2.translate(-SHAPE.getBounds2D().getX(), -SHAPE.getBounds2D().getY());

        // Set the color
        G2.setColor(new Color(RED, GREEN, BLUE, ALPHA_STEP));

        // Set the alpha transparency of the whole image
        G2.setComposite(AlphaComposite.SrcAtop);

        // Translate the coordinate system related to the given distance and angle
        G2.translate(TRANSLATE_X, -TRANSLATE_Y);

        // Draw the inner shadow
        for (double strokeWidth = SOFTNESS; strokeWidth >= 1; strokeWidth -= 1)
        {
            G2.setStroke(new BasicStroke((float) (MAX_STROKE_WIDTH * Math.pow(0.85, strokeWidth))));
            G2.draw(SHAPE);
        }

        G2.dispose();

        return IMAGE;
    }

    /**
     * <p>
     * Method to create a inner shadow on a given shape</p>
     *
     * @param G2 graphics2d object that contains the shape which will get the
     * inner shadow
     * @param SHAPE shape that should get the inner shadow
     * @param DISTANCE distance of the shadow
     * @param ALPHA alpha value of the shadow
     * @param SHADOW_COLOR color of the shadow
     * @param SOFTNESS softness/fuzzyness of the shadow
     * @param ANGLE angle under which the shadow should appear
     */
    public static void addInnerShadow(final Graphics2D G2, final Shape SHAPE, final Color SHADOW_COLOR, final int DISTANCE, final float ALPHA, final int SOFTNESS, final int ANGLE)
    {
        final float COLOR_CONSTANT = 1f / 255f;
        final float RED = COLOR_CONSTANT * SHADOW_COLOR.getRed();
        final float GREEN = COLOR_CONSTANT * SHADOW_COLOR.getGreen();
        final float BLUE = COLOR_CONSTANT * SHADOW_COLOR.getBlue();
        final float MAX_STROKE_WIDTH = SOFTNESS * 2;
        final float ALPHA_STEP = 1f / (2 * SOFTNESS + 2) * ALPHA;
        final float TRANSLATE_X = (float) (DISTANCE * Math.cos(Math.toRadians(ANGLE)));
        final float TRANSLATE_Y = (float) (DISTANCE * Math.sin(Math.toRadians(ANGLE)));

        // Enable Antialiasing
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Store existing parameters
        final Shape OLD_CLIP = G2.getClip();
        final AffineTransform OLD_TRANSFORM = G2.getTransform();
        final Stroke OLD_STROKE = G2.getStroke();
        final Paint OLD_PAINT = G2.getPaint();

        // Set the color
        G2.setColor(new Color(RED, GREEN, BLUE, ALPHA_STEP));

        // Set the alpha transparency of the whole image
        G2.setComposite(AlphaComposite.SrcAtop);

        // Translate the coordinate system related to the given distance and angle
        G2.translate(TRANSLATE_X, -TRANSLATE_Y);

        G2.setClip(SHAPE);

        // Draw the inner shadow
        for (double strokeWidth = SOFTNESS; strokeWidth >= 1; strokeWidth -= 1)
        {
            G2.setStroke(new BasicStroke((float) (MAX_STROKE_WIDTH * Math.pow(0.85, strokeWidth))));
            G2.draw(SHAPE);
        }

        // Restore old parameters
        G2.setTransform(OLD_TRANSFORM);
        G2.setClip(OLD_CLIP);
        G2.setStroke(OLD_STROKE);
        G2.setPaint(OLD_PAINT);
    }

}
