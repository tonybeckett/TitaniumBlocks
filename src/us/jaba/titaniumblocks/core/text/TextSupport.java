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
package us.jaba.titaniumblocks.core.text;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tbeckett
 */
public class TextSupport
{

    
    private static final Pattern NUMBERS_ONLY = Pattern.compile("^[-+]?[0-9]+[.]?[0-9]*([eE][-+]?[0-9]+)?$");
    private static final Matcher MATCHES_NUMBERS = NUMBERS_ONLY.matcher("");
    private static final Rectangle2D TEXT_BOUNDARY = new Rectangle2D.Double(0, 0, 10, 10);

    //********************************** UI related utils **************************************************************
    /**
     * It will take the font from the given Graphics2D object and returns a
     * shape of the given TEXT that is rotated by the ROTATION_ANGLE around it's
     * center which is defined by TEXT_POSITION_X and TEXT_POSITION_Y. It will
     * take the font's descent into account so that the rotated text will be
     * centered correctly even if it doesn't contain characters with descent.
     *
     * @param graphics2D
     * @param TEXT
     * @param TEXT_POSITION_X
     * @param TEXT_POSITION_Y
     * @param ROTATION_ANGLE
     * @return Glyph that is a shape of the given string rotated around it's
     * center.
     */
    public static Shape rotateTextAroundCenter(final Graphics2D graphics2D, final String TEXT, final int TEXT_POSITION_X, final int TEXT_POSITION_Y, final double ROTATION_ANGLE)
    {
        final FontRenderContext RENDER_CONTEXT = new FontRenderContext(null, true, true);
        final TextLayout TEXT_LAYOUT = new TextLayout(TEXT, graphics2D.getFont(), RENDER_CONTEXT);

        // Check if need to take the fonts descent into account
        final float DESCENT;
        MATCHES_NUMBERS.reset(TEXT);
        if (MATCHES_NUMBERS.matches())
        {
            DESCENT = TEXT_LAYOUT.getDescent();
        } else
        {
            DESCENT = 0;
        }
        final Rectangle2D TEXT_BOUNDS = TEXT_LAYOUT.getBounds();
        TEXT_BOUNDARY.setRect(TEXT_BOUNDS.getMinX(), TEXT_BOUNDS.getMinY(), TEXT_BOUNDS.getWidth(), TEXT_BOUNDS.getHeight() + DESCENT / 2);

        final GlyphVector GLYPH_VECTOR = graphics2D.getFont().createGlyphVector(RENDER_CONTEXT, TEXT);

        final java.awt.Shape GLYPH = GLYPH_VECTOR.getOutline((int) -TEXT_BOUNDARY.getCenterX(), 2 * (int) TEXT_BOUNDARY.getCenterY());

        final AffineTransform OLD_TRANSFORM = graphics2D.getTransform();
        graphics2D.translate(TEXT_POSITION_X, TEXT_POSITION_Y + TEXT_BOUNDARY.getHeight());

        graphics2D.rotate(ROTATION_ANGLE, -TEXT_BOUNDARY.getCenterX() + TEXT_BOUNDARY.getWidth() / 2, TEXT_BOUNDARY.getCenterY() - (TEXT_BOUNDARY.getHeight() + DESCENT) / 2);
        graphics2D.fill(GLYPH);

        graphics2D.setTransform(OLD_TRANSFORM);

        return GLYPH;
    }

    /**
     * Calculates the centered position of the given text in the given boundary
     * and the given graphics2d object. This is really useful when centering
     * text on buttons or other components.
     *
     * @param G2
     * @param BOUNDARY
     * @param TEXT
     * @return a point2d that defines the position of the given text centered in
     * the given rectangle
     */
    public static Point2D getCenteredTextPosition(final Graphics2D G2, final Rectangle2D BOUNDARY, final String TEXT)
    {
        return getCenteredTextPosition(G2, BOUNDARY, G2.getFont(), TEXT);
    }

    /**
     * Calculates the centered position of the given text in the given boundary,
     * with the given font and the given graphics2d object. This is really
     * useful when centering text on buttons or other components.
     *
     * @param G2
     * @param BOUNDARY
     * @param FONT
     * @param TEXT
     * @return a point2d that defines the position of the given text centered in
     * the given rectangle
     */
    public static Point2D getCenteredTextPosition(final Graphics2D G2, final Rectangle2D BOUNDARY, final Font FONT, final String TEXT)
    {
        // Get the visual center of the component.
        final double CENTER_X = BOUNDARY.getWidth() / 2.0;
        final double CENTER_Y = BOUNDARY.getHeight() / 2.0;

        // Get the text boundary
        final FontRenderContext RENDER_CONTEXT = G2.getFontRenderContext();
        final TextLayout LAYOUT = new TextLayout(TEXT, FONT, RENDER_CONTEXT);
        final Rectangle2D TEXT_BOUNDS = LAYOUT.getBounds();

        // Calculate the text position
        final double TEXT_X = CENTER_X - TEXT_BOUNDS.getWidth() / 2.0;
        final double TEXT_Y = CENTER_Y - TEXT_BOUNDS.getHeight() / 2.0 + TEXT_BOUNDS.getHeight();

        return new Point2D.Double(TEXT_X, TEXT_Y);
    }

}
