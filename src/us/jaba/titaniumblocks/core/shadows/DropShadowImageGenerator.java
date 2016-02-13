/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.shadows;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import us.jaba.titaniumblocks.core.image.ImageSupport;
import us.jaba.titaniumblocks.core.image.ShapeImageGenerator;

/**
 *
 * @author tbeckett
 */
public class DropShadowImageGenerator
{

    public static BufferedImage create(final BufferedImage SRC_IMAGE, final int DISTANCE, final float ALPHA, final int SOFTNESS, final int ANGLE, final Color SHADOW_COLOR)
    {
        final float TRANSLATE_X = (float) (DISTANCE * Math.cos(Math.toRadians(360 - ANGLE)));
        final float TRANSLATE_Y = (float) (DISTANCE * Math.sin(Math.toRadians(360 - ANGLE)));

        final BufferedImage SHADOW_IMAGE = renderDropShadow(SRC_IMAGE, SOFTNESS, ALPHA, SHADOW_COLOR);
        final BufferedImage RESULT = new BufferedImage(SHADOW_IMAGE.getWidth(), SHADOW_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);

        final Graphics2D G2 = RESULT.createGraphics();
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        G2.translate(TRANSLATE_X, TRANSLATE_Y);
        G2.drawImage(SHADOW_IMAGE, 0, 0, null);
        G2.translate(-TRANSLATE_X, -TRANSLATE_Y);
        G2.translate(SOFTNESS, SOFTNESS);
        G2.drawImage(SRC_IMAGE, 0, 0, null);

        G2.dispose();

        return RESULT;
    }

    public static BufferedImage create(final Shape SHAPE, final Paint PAINT, final Color COLOR, final boolean FILLED, final Stroke STROKE, final Color STROKE_COLOR, final int DISTANCE, final float ALPHA, final int SOFTNESS, final int ANGLE, final Color SHADOW_COLOR)
    {
        final float TRANSLATE_X = (float) (DISTANCE * Math.cos(Math.toRadians(360 - ANGLE)));
        final float TRANSLATE_Y = (float) (DISTANCE * Math.sin(Math.toRadians(360 - ANGLE)));

        final BufferedImage SHAPE_IMAGE = ShapeImageGenerator.createImageFromShape(SHAPE, PAINT, COLOR, FILLED, STROKE, STROKE_COLOR);
        final BufferedImage SHADOW_IMAGE = renderDropShadow(SHAPE_IMAGE, SOFTNESS, ALPHA, SHADOW_COLOR);

        final BufferedImage RESULT = new BufferedImage(SHADOW_IMAGE.getWidth(), SHADOW_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);

        final Graphics2D G2 = RESULT.createGraphics();
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        G2.translate(TRANSLATE_X, TRANSLATE_Y);
        G2.drawImage(SHADOW_IMAGE, 0, 0, null);
        G2.translate(-TRANSLATE_X, -TRANSLATE_Y);
        G2.translate(SOFTNESS, SOFTNESS);
        G2.drawImage(SHAPE_IMAGE, 0, 0, null);

        G2.dispose();

        return RESULT;
    }

    /**
     * <p>
     * Generates the shadow for a given picture and the current properties of
     * the renderer.</p>
     * <p>
     * The generated image dimensions are computed as following</p>
     * <pre>
     * width  = imageWidth  + 2 * shadowSize
     * height = imageHeight + 2 * shadowSize
     * </pre>
     *
     * @param IMAGE image the picture from which the shadow must be cast
     * @param SOFTNESS
     * @param ALPHA
     * @param SHADOW_COLOR
     * @return the picture containing the shadow of <code>image</code>
     */
    public static BufferedImage renderDropShadow(final BufferedImage IMAGE, final int SOFTNESS, final float ALPHA, final Color SHADOW_COLOR)
    {
        // Written by Sesbastien Petrucci
        final int SHADOW_SIZE = SOFTNESS * 2;

        final int SRC_WIDTH = IMAGE.getWidth();
        final int SRC_HEIGHT = IMAGE.getHeight();

        final int DST_WIDTH = SRC_WIDTH + SHADOW_SIZE;
        final int DST_HEIGHT = SRC_HEIGHT + SHADOW_SIZE;

        final int LEFT = SOFTNESS;
        final int RIGHT = SHADOW_SIZE - LEFT;

        final int Y_STOP = DST_HEIGHT - RIGHT;

        final int SHADOW_RGB = SHADOW_COLOR.getRGB() & 0x00FFFFFF;
        int[] aHistory = new int[SHADOW_SIZE];
        int historyIdx;

        int aSum;

        final BufferedImage DST = new BufferedImage(DST_WIDTH, DST_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        int[] dstBuffer = new int[DST_WIDTH * DST_HEIGHT];
        int[] srcBuffer = new int[SRC_WIDTH * SRC_HEIGHT];

        ImageSupport.getPixels(IMAGE, 0, 0, SRC_WIDTH, SRC_HEIGHT, srcBuffer);

        final int LAST_PIXEL_OFFSET = RIGHT * DST_WIDTH;
        final float H_SUM_DIVIDER = 1.0f / SHADOW_SIZE;
        final float V_SUM_DIVIDER = ALPHA / SHADOW_SIZE;

        int max;

        int[] hSumLookup = new int[256 * SHADOW_SIZE];
        max = hSumLookup.length;

        for (int i = 0; i < max; i++)
        {
            hSumLookup[i] = (int) (i * H_SUM_DIVIDER);
        }

        int[] vSumLookup = new int[256 * SHADOW_SIZE];
        max = vSumLookup.length;
        for (int i = 0; i < max; i++)
        {
            vSumLookup[i] = (int) (i * V_SUM_DIVIDER);
        }

        int srcOffset;

        // horizontal pass  extract the alpha mask from the source picture and
        // blur it into the destination picture
        for (int srcY = 0, dstOffset = LEFT * DST_WIDTH; srcY < SRC_HEIGHT; srcY++)
        {
            // first pixels are empty
            for (historyIdx = 0; historyIdx < SHADOW_SIZE;)
            {
                aHistory[historyIdx++] = 0;
            }

            aSum = 0;
            historyIdx = 0;
            srcOffset = srcY * SRC_WIDTH;

            // compute the blur average with pixels from the source image
            for (int srcX = 0; srcX < SRC_WIDTH; srcX++)
            {
                int a = hSumLookup[aSum];
                dstBuffer[dstOffset++] = a << 24; // store the alpha value only
                // the shadow color will be added in the next pass

                aSum -= aHistory[historyIdx]; // substract the oldest pixel from the sum

                // extract the new pixel ...
                a = srcBuffer[srcOffset + srcX] >>> 24;
                aHistory[historyIdx] = a; // ... and store its value into history
                aSum += a; // ... and add its value to the sum

                if (++historyIdx >= SHADOW_SIZE)
                {
                    historyIdx -= SHADOW_SIZE;
                }
            }

            // blur the end of the row - no new pixels to grab
            for (int i = 0; i < SHADOW_SIZE; i++)
            {
                final int A = hSumLookup[aSum];
                dstBuffer[dstOffset++] = A << 24;

                // substract the oldest pixel from the sum ... and nothing new to add !
                aSum -= aHistory[historyIdx];

                if (++historyIdx >= SHADOW_SIZE)
                {
                    historyIdx -= SHADOW_SIZE;
                }
            }
        }

        // vertical pass
        int bufferOffset = 0;
        for (int x = 0; x < DST_WIDTH; x++, bufferOffset = x)
        {
            aSum = 0;

            // first pixels are empty
            for (historyIdx = 0; historyIdx < LEFT;)
            {
                aHistory[historyIdx++] = 0;
            }

            // and then they come from the dstBuffer
            for (int y = 0; y < RIGHT; y++, bufferOffset += DST_WIDTH)
            {
                final int A = dstBuffer[bufferOffset] >>> 24; // extract alpha
                aHistory[historyIdx++] = A; // store into history
                aSum += A; // and add to sum
            }

            bufferOffset = x;
            historyIdx = 0;

            // compute the blur avera`ge with pixels from the previous pass
            for (int y = 0; y < Y_STOP; y++, bufferOffset += DST_WIDTH)
            {

                int a = vSumLookup[aSum];
                dstBuffer[bufferOffset] = a << 24 | SHADOW_RGB; // store alpha value + shadow color

                aSum -= aHistory[historyIdx]; // substract the oldest pixel from the sum

                a = dstBuffer[bufferOffset + LAST_PIXEL_OFFSET] >>> 24; // extract the new pixel ...
                aHistory[historyIdx] = a; // ... and store its value into history
                aSum += a; // ... and add its value to the sum

                if (++historyIdx >= SHADOW_SIZE)
                {
                    historyIdx -= SHADOW_SIZE;
                }
            }

            // blur the end of the column - no pixels to grab anymore
            for (int y = Y_STOP; y < DST_HEIGHT; y++, bufferOffset += DST_WIDTH)
            {

                final int A = vSumLookup[aSum];
                dstBuffer[bufferOffset] = A << 24 | SHADOW_RGB;

                aSum -= aHistory[historyIdx]; // substract the oldest pixel from the sum

                if (++historyIdx >= SHADOW_SIZE)
                {
                    historyIdx -= SHADOW_SIZE;
                }
            }
        }

        ImageSupport.setPixels(DST, 0, 0, DST_WIDTH, DST_HEIGHT, dstBuffer);

        return DST;
    }

}
