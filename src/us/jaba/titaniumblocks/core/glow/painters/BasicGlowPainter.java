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
package us.jaba.titaniumblocks.core.glow.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import us.jaba.titaniumblocks.core.CoreModel;

/**
 *
 * @author tbeckett
 */
public class BasicGlowPainter extends CoreModel
{

    private Color brushColor;
    private Shape shape;
    private Paint shapePaint;
    private float alpha;
    private int softness;

    public BasicGlowPainter(Color brushColor, Shape shape, Paint shapePaint, float alpha, int softness)
    {
        this.brushColor = brushColor;
        this.shape = shape;
        this.shapePaint = shapePaint;
        this.alpha = alpha;
        this.softness = softness;
    }

    public BasicGlowPainter(Color brushColor, Shape shape)
    {
        this.brushColor = brushColor;
        this.shape = shape;
    }

    public BasicGlowPainter()
    {
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {

        /**
         * Adds a simple glow around the given shape
         *
         */
        final float COLOR_CONSTANT = 1f / 255f;
        final float RED = COLOR_CONSTANT * brushColor.getRed();
        final float GREEN = COLOR_CONSTANT * brushColor.getGreen();
        final float BLUE = COLOR_CONSTANT * brushColor.getBlue();
        final float MAX_STROKE_WIDTH = softness * 2;
        final float ALPHA_STEP = 1f / (2 * softness + 2) * alpha;

        // Enable Antialiasing
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Store existing parameters
        final Shape OLD_CLIP = graphics.getClip();
        final AffineTransform OLD_TRANSFORM = graphics.getTransform();
        final Stroke OLD_STROKE = graphics.getStroke();
        final Paint OLD_PAINT = graphics.getPaint();

        // Set the color
        graphics.setColor(new Color(RED, GREEN, BLUE, ALPHA_STEP));

        // Draw the inner shadow
        for (float strokeWidth = softness; strokeWidth >= 1; strokeWidth -= 1)
        {
            graphics.setStroke(new BasicStroke((float) (MAX_STROKE_WIDTH * Math.pow(0.85, strokeWidth))));
            graphics.draw(shape);
        }

        // Restore old parameters
        graphics.setTransform(OLD_TRANSFORM);
        graphics.setClip(OLD_CLIP);
        graphics.setStroke(OLD_STROKE);

        // Draw the original shape on top
        graphics.setPaint(shapePaint);
        graphics.fill(shape);

        graphics.setPaint(OLD_PAINT);
    }

    public Color getBrushColor()
    {
        return brushColor;
    }

    public void setBrushColor(Color brushColor)
    {
        this.brushColor = brushColor;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public Paint getShapePaint()
    {
        return shapePaint;
    }

    public void setShapePaint(Paint shapePaint)
    {
        this.shapePaint = shapePaint;
    }

    public float getAlpha()
    {
        return alpha;
    }

    public void setAlpha(float alpha)
    {
        this.alpha = alpha;
    }

    public int getSoftness()
    {
        return softness;
    }

    public void setSoftness(int softness)
    {
        this.softness = softness;
    }
}
