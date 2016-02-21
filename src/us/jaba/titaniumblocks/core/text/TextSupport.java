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
    private static final Matcher matchesNumbers = NUMBERS_ONLY.matcher("");
    private static final Rectangle2D textBoundary = new Rectangle2D.Double(0, 0, 10, 10);

    //********************************** UI related utils **************************************************************
    /**
     * It will take the font from the given Graphics2D object and returns a
     * shape of the given text that is rotated by the rotationAngle around it's
     * center which is defined by textPositionX and textPositionY. It will take
     * the font's descent into account so that the rotated text will be centered
     * correctly even if it doesn't contain characters with descent.
     *
     * @param graphics2D
     * @param text
     * @param textPositionX
     * @param textPositionY
     * @param rotationAngle
     * @return Glyph that is a shape of the given string rotated around it's
     * center.
     */
    public static Shape rotateTextAroundCenter(final Graphics2D graphics2D, final String text, final double textPositionX, final double textPositionY, final double rotationAngle)
    {
        final FontRenderContext renderContext = new FontRenderContext(null, true, true);
        final TextLayout textLayout = new TextLayout(text, graphics2D.getFont(), renderContext);

        // Check if need to take the fonts descent into account
        final float decent = 0.0f;
        matchesNumbers.reset(text);
//        if (matchesNumbers.matches())
//        {
//            decent = textLayout.getDescent();
//        } else
//        {
//            decent = 0;
//        }
        final Rectangle2D textBounds = textLayout.getBounds();
        textBoundary.setRect(textBounds.getMinX(), textBounds.getMinY(), textBounds.getWidth(), textBounds.getHeight() + decent / 2);

        final GlyphVector glyphVector = graphics2D.getFont().createGlyphVector(renderContext, text);

        final java.awt.Shape glyph = glyphVector.getOutline((int) -textBoundary.getCenterX(), (int) textBoundary.getCenterY());

        final AffineTransform oldTransform = graphics2D.getTransform();
        graphics2D.translate(textPositionX, textPositionY + textBoundary.getHeight());

        graphics2D.rotate(rotationAngle, -textBoundary.getCenterX() + textBoundary.getWidth() / 2, textBoundary.getCenterY() - (textBoundary.getHeight() + decent) / 2);
        graphics2D.fill(glyph);

        graphics2D.setTransform(oldTransform);

        return glyph;
    }

    /**
     * Calculates the centered position of the given text in the given boundary
     * and the given graphics2d object. This is really useful when centering
     * text on buttons or other components.
     *
     * @param G2
     * @param boundary
     * @param text
     * @return a point2d that defines the position of the given text centered in
     * the given rectangle
     */
    public static Point2D getCenteredTextPosition(final Graphics2D G2, final Rectangle2D boundary, final String text)
    {
        return getCenteredTextPosition(G2, boundary, G2.getFont(), text);
    }

    /**
     * Calculates the centered position of the given text in the given boundary,
     * with the given font and the given graphics2d object. This is really
     * useful when centering text on buttons or other components.
     *
     * @param G2
     * @param boundary
     * @param font
     * @param text
     * @return a point2d that defines the position of the given text centered in
     * the given rectangle
     */
    public static Point2D getCenteredTextPosition(final Graphics2D G2, final Rectangle2D boundary, final Font font, final String text)
    {
        // Get the visual center of the component.
        final double CENTER_X = boundary.getWidth() / 2.0;
        final double CENTER_Y = boundary.getHeight() / 2.0;

        // Get the text boundary
        final FontRenderContext renderContext = G2.getFontRenderContext();
        final TextLayout LAYOUT = new TextLayout(text, font, renderContext);
        final Rectangle2D textBounds = LAYOUT.getBounds();

        // Calculate the text position
        final double TEXT_X = CENTER_X - textBounds.getWidth() / 2.0;
        final double TEXT_Y = CENTER_Y - textBounds.getHeight() / 2.0 + textBounds.getHeight();

        return new Point2D.Double(TEXT_X, TEXT_Y);
    }

}
