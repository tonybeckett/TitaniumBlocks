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
package us.jaba.titaniumblocks.core.backdrop.types.round;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.backdrop.types.AbstractRoundBackdrop;
import us.jaba.titaniumblocks.core.image.ImageSupport;
import us.jaba.titaniumblocks.core.text.TextSupport;

public class CompassRoseBackdrop extends AbstractRoundBackdrop
{

    @Override
    protected Paint getPaint(Dimension dimensions, Ellipse2D ellipse)
    {
        return (Paint) ellipse;
    }

    private BufferedImage createBigRosePointerImage(final int WIDTH)
    {
        final BufferedImage IMAGE = ImageSupport.createImage((int) (WIDTH * 0.0546875f), (int) (WIDTH * 0.2f), java.awt.Transparency.TRANSLUCENT);
        final Graphics2D graphics = IMAGE.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = IMAGE.getWidth();
        final int imageHeight = IMAGE.getHeight();

        graphics.setStroke(new BasicStroke(0.75f));

        // Define arrow shape of pointer
        final GeneralPath whiteLeftPointer = new GeneralPath();
        final GeneralPath whiteRightPointer = new GeneralPath();

        whiteLeftPointer.moveTo(imageWidth - imageWidth * 0.95f, imageHeight);
        whiteLeftPointer.lineTo(imageWidth / 2.0f, 0);
        whiteLeftPointer.lineTo(imageWidth / 2.0f, imageHeight);
        whiteLeftPointer.closePath();

        whiteRightPointer.moveTo(imageWidth * 0.95f, imageHeight);
        whiteRightPointer.lineTo(imageWidth / 2.0f, 0);
        whiteRightPointer.lineTo(imageWidth / 2.0f, imageHeight);
        whiteRightPointer.closePath();

        final Area whitePointerFrame = new Area(whiteLeftPointer);
        whitePointerFrame.add(new Area(whiteRightPointer));

        final Color STROKE_COLOR = this.getBackgroundColor().getSymbolColor().darker();
        final Color FILL_COLOR = this.getBackgroundColor().getSymbolColor();

        graphics.setColor(STROKE_COLOR);
        graphics.fill(whiteRightPointer);
        graphics.setColor(FILL_COLOR);
        graphics.fill(whiteLeftPointer);
        graphics.setColor(STROKE_COLOR);
        graphics.draw(whitePointerFrame);

        graphics.dispose();

        return IMAGE;
    }

    private BufferedImage createSmallRosePointerImage(final int WIDTH)
    {
        final BufferedImage IMAGE = ImageSupport.createImage((int) (WIDTH * 0.0546875f), (int) (WIDTH * 0.2f), java.awt.Transparency.TRANSLUCENT);
        final Graphics2D graphics = IMAGE.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = IMAGE.getWidth();
        final int imageHeight = IMAGE.getHeight();

        graphics.setStroke(new BasicStroke(0.75f));

        // Define arrow shape of pointer
        final GeneralPath whiteLeftPointer = new GeneralPath();
        final GeneralPath whiteRightPointer = new GeneralPath();

        whiteLeftPointer.moveTo(imageWidth - imageWidth * 0.75f, imageHeight);
        whiteLeftPointer.lineTo(imageWidth / 2.0f, imageHeight / 2.0f);
        whiteLeftPointer.lineTo(imageWidth / 2.0f, imageHeight);
        whiteLeftPointer.closePath();

        whiteRightPointer.moveTo(imageWidth * 0.75f, imageHeight);
        whiteRightPointer.lineTo(imageWidth / 2.0f, imageHeight / 2.0f);
        whiteRightPointer.lineTo(imageWidth / 2.0f, imageHeight);
        whiteRightPointer.closePath();

        final Area whitePointerFrame = new Area(whiteLeftPointer);
        whitePointerFrame.add(new Area(whiteRightPointer));

        final Color STROKE_COLOR = this.getBackgroundColor().getSymbolColor().darker();
        final Color FILL_COLOR = this.getBackgroundColor().getSymbolColor();

        graphics.setColor(FILL_COLOR);
        graphics.fill(whitePointerFrame);
        graphics.setColor(STROKE_COLOR);
        graphics.draw(whitePointerFrame);

        graphics.dispose();

        return IMAGE;
    }

    private void createTickmarks(final Graphics2D graphics, final int imageWidth)
    {
        // Store former transformation
        final AffineTransform FORMER_TRANSFORM = graphics.getTransform();

        final BasicStroke MEDIUM_STROKE = new BasicStroke(0.005859375f * imageWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final BasicStroke THIN_STROKE = new BasicStroke(0.00390625f * imageWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        final java.awt.Font BIG_FONT = new java.awt.Font("Serif", java.awt.Font.PLAIN, (int) (0.12f * imageWidth));
        final java.awt.Font SMALL_FONT = new java.awt.Font("Serif", java.awt.Font.PLAIN, (int) (0.06f * imageWidth));
        
        final float TEXT_DISTANCE = 0.0750f * imageWidth;
        final float MIN_LENGTH = 0.015625f * imageWidth;
        final float MED_LENGTH = 0.0234375f * imageWidth;
        final float MAX_LENGTH = 0.03125f * imageWidth;

        final Color TEXT_COLOR = this.getBackgroundColor().getLabelColor();
        final Color TICK_COLOR = this.getBackgroundColor().getLabelColor();

        // Create the watch itself
        final float RADIUS = imageWidth * 0.485f;//0.38f;
        final Point2D centerPoint = new Point2D.Double(imageWidth / 2.0f, imageWidth / 2.0f);

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // Draw ticks
        Point2D innerPoint;
        Point2D outerPoint;
        Point2D textPoint = null;
        java.awt.geom.Line2D tick;
        int tickCounter90 = 0;
        int tickCounter15 = 0;
        int tickCounter5 = 0;
        int counter = 0;

        double sinValue = 0;
        double cosValue = 0;

        final double STEP = (2.0d * Math.PI) / (360.0d);

        for (double alpha = 2 * Math.PI; alpha >= 0; alpha -= STEP)
        {
            graphics.setStroke(THIN_STROKE);
            sinValue = Math.sin(alpha);
            cosValue = Math.cos(alpha);

            graphics.setColor(TICK_COLOR);

            if (tickCounter5 == 5)
            {
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MIN_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MIN_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);
                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter5 = 0;
            }

            // Different tickmark every 15 units
            if (tickCounter15 == 15)
            {
                graphics.setStroke(THIN_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MED_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MED_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);

                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter15 = 0;
                tickCounter90 += 15;
            }

            // Different tickmark every 90 units plus text
            if (tickCounter90 == 90)
            {
                graphics.setStroke(MEDIUM_STROKE);
                innerPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - MAX_LENGTH) * sinValue, centerPoint.getY() + (RADIUS - MAX_LENGTH) * cosValue);
                outerPoint = new Point2D.Double(centerPoint.getX() + RADIUS * sinValue, centerPoint.getY() + RADIUS * cosValue);

                // Draw ticks
                tick = new java.awt.geom.Line2D.Double(innerPoint.getX(), innerPoint.getY(), outerPoint.getX(), outerPoint.getY());
                graphics.draw(tick);

                tickCounter90 = 0;
            }

            // Draw text
            graphics.setFont(BIG_FONT);
            graphics.setColor(TEXT_COLOR);

            textPoint = new Point2D.Double(centerPoint.getX() + (RADIUS - TEXT_DISTANCE) * sinValue, centerPoint.getY() + (RADIUS - TEXT_DISTANCE) * cosValue);
            switch (counter)
            {
                case 360:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "S", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 45:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "SW", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 90:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "W", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 135:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "NW", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 180:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "N", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 225:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "NE", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 270:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "E", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
                case 315:
                    graphics.setFont(SMALL_FONT);
                    graphics.fill(TextSupport.rotateTextAroundCenter(graphics, "SE", (int) textPoint.getX(), (int) textPoint.getY(), (Math.PI - alpha)));
                    break;
            }
            graphics.setTransform(FORMER_TRANSFORM);

            tickCounter5++;
            tickCounter15++;

            counter++;
        }

        // Restore former transformation
        graphics.setTransform(FORMER_TRANSFORM);
    }

    private void drawCircle(Graphics2D graphics, double x, double y, double radius)
    {
        java.awt.Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);
    }

    private void fillCircle(Graphics2D graphics, double x, double y, double radius)
    {
        java.awt.Shape circle = new Ellipse2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0);
        graphics.draw(circle);
        graphics.fill(circle);
    }

    
     private void drawArc(Graphics2D graphics, double x, double y, double radius, double s, double t)
    {
        java.awt.Shape arc = new Arc2D.Double(x - radius, y - radius, radius * 2.0, radius * 2.0, s, t, Arc2D.OPEN);
        graphics.draw(arc);
    }

    @Override
    public void paint(Graphics2D graphics, Dimension dimensions)
    {
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        final int imageWidth = (int) dimensions.getWidth();
        final int imageHeight = (int) dimensions.getHeight();

        graphics.setColor(this.getBackgroundColor().getGradientStartColor());
        fillCircle(graphics, imageWidth/2, imageHeight/2, imageHeight / 2);
        // ******************* COMPASS ROSE *************************************************
        final Point2D centerPoint = new Point2D.Double(imageWidth / 2.0f, imageHeight / 2.0f);
        AffineTransform transform = graphics.getTransform();
        graphics.setStroke(new BasicStroke(imageWidth * 0.026f/*01953125f*/, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

        graphics.setColor(this.getBackgroundColor().getSymbolColor());

        for (int i = 0; i <= 360; i += 30)
        {
            drawArc(  graphics, centerPoint.getX(), centerPoint.getY(), imageWidth * 0.344, i, 15);
//            graphics.draw(new Arc2D.Double(centerPoint.getX() - imageWidth * 0.35f/*0.263671875f*/, centerPoint.getY() - imageHeight * 0.35f/*0.263671875f*/,
//                    imageWidth * 0.7f/*0.52734375f*/, imageWidth * 0.7f/*0.52734375f*/, i, 15, Arc2D.OPEN));
        }

        graphics.setColor(this.getBackgroundColor().getSymbolColor());
        graphics.setStroke(new BasicStroke(0.5f));
        
        drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), imageHeight * 0.357);
//        java.awt.Shape outerCircle = new Ellipse2D.Double(centerPoint.getX() - imageWidth * 0.357f/*0.2734375f*/, centerPoint.getY() - imageHeight * 0.357f/*0.2734375f*/,
//               imageWidth * 0.717f/*0.546875f*/, imageWidth * 0.717f/*0.546875f*/);

//        graphics.draw(outerCircle);

        drawCircle(graphics, centerPoint.getX(), centerPoint.getY(), imageHeight * 0.332);
//        java.awt.Shape innerCircle = new Ellipse2D.Double(centerPoint.getX() - imageWidth * 0.342f/*0.25390625f*/, centerPoint.getY() - imageHeight * 0.342f/*0.25390625f*/,
//                imageWidth * 0.685f/*0.5078125f*/, imageWidth * 0.685f/*0.5078125f*/);
//        graphics.draw(innerCircle);

        final java.awt.geom.Line2D line = new java.awt.geom.Line2D.Double(centerPoint.getX(), imageWidth * 0.4018691589, centerPoint.getX(), imageWidth * 0.04);//0.1495327103);
        graphics.setColor(this.getBackgroundColor().getSymbolColor());

        graphics.setStroke(new BasicStroke(1f));
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 6, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);
        graphics.rotate(Math.PI / 12, centerPoint.getX(), centerPoint.getY());
        graphics.draw(line);

        graphics.setTransform(transform);
        final BufferedImage bigRosePointerImage = createBigRosePointerImage(imageWidth);
        final BufferedImage smallRosePointerImage = createSmallRosePointerImage(imageWidth);
        final Point2D offset = new Point2D.Double(imageWidth * 0.475f, imageWidth * 0.20f);

        graphics.translate(offset.getX(), offset.getY());

        // N
        graphics.drawImage(bigRosePointerImage, 0, 0, null);

        // NE
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(smallRosePointerImage, 0, 0, null);

        // E
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(bigRosePointerImage, 0, 0, null);

        // SE
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(smallRosePointerImage, 0, 0, null);

        // S
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(bigRosePointerImage, 0, 0, null);

        // SW
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(smallRosePointerImage, 0, 0, null);

        // W
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(bigRosePointerImage, 0, 0, null);

        // NW
        graphics.rotate(Math.PI / 4f, centerPoint.getX() - offset.getX(), centerPoint.getY() - offset.getY());
        graphics.drawImage(smallRosePointerImage, 0, 0, null);

        graphics.setTransform(transform);

        graphics.setColor(this.getBackgroundColor().getSymbolColor());
        graphics.setStroke(new BasicStroke(imageWidth * 0.00953125f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        graphics.draw(new Ellipse2D.Double(centerPoint.getX() - (imageWidth * 0.1025f), centerPoint.getY() - (imageWidth * 0.1025f), imageWidth * 0.205f, imageWidth * 0.205f));

        graphics.setStroke(new BasicStroke(0.5f));
        graphics.setColor(this.getBackgroundColor().getSymbolColor());
        final java.awt.Shape OUTER_ROSE_ELLIPSE = new Ellipse2D.Double(centerPoint.getX() - (imageWidth * 0.11f), centerPoint.getY() - (imageWidth * 0.11f), imageWidth * 0.22f, imageWidth * 0.22f);
        graphics.draw(OUTER_ROSE_ELLIPSE);
        final java.awt.Shape INNER_ROSE_ELLIPSE = new Ellipse2D.Double(centerPoint.getX() - (imageWidth * 0.095f), centerPoint.getY() - (imageWidth * 0.095f), imageWidth * 0.19f, imageWidth * 0.19f);
        graphics.draw(INNER_ROSE_ELLIPSE);

        // ******************* TICKMARKS ****************************************************
//        createTickmarks(graphics, imageWidth);

        graphics.dispose();

    }

}
