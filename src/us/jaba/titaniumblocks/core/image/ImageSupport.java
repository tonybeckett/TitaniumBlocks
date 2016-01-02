/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.jaba.titaniumblocks.core.image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author tbeckett
 */
public class ImageSupport
{

    final static GraphicsConfiguration defaultGraphicsConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

    public static final BufferedImage defaultSmallImage = defaultGraphicsConfig.createCompatibleImage(1, 1, Transparency.TRANSLUCENT);

    public static boolean isValidSize(final int height, final int width)
    {
        boolean answer = false;
        if (height > 0 && width > 0)
        {
            answer = true;
        }
        return answer;
    }

    public static boolean isValidDim(final Dimension dimension)
    {
        return isValidSize(dimension.height, dimension.width);
    }

    /**
     * This method was taken from the great book "Filthy Rich Clients" from Chet
     * Haase and Romain Guy
     *
     * Convenience method that returns a scaled instance of the provided
     * BufferedImage.
     *
     * @param IMAGE the original image to be scaled
     * @param TARGET_WIDTH the desired width of the scaled instance, in pixels
     * @param TARGET_HEIGHT the desired height of the scaled instance, in pixels
     * @param HINT one of the rendering hints that corresponds to
     * RenderingHints.KEY_INTERPOLATION (e.g.
     * RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR,
     * RenderingHints.VALUE_INTERPOLATION_BILINEAR,
     * RenderingHints.VALUE_INTERPOLATION_BICUBIC)
     * @return a scaled version of the original BufferedImage
     */
    public static BufferedImage getScaledInstance(final BufferedImage IMAGE, final int TARGET_WIDTH, final int TARGET_HEIGHT, final Object HINT)
    {
        final int TYPE = (IMAGE.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = IMAGE;
        BufferedImage scratchImage = null;
        Graphics2D g2 = null;
        final int WIDTH = TARGET_WIDTH;
        final int HEIGHT = TARGET_HEIGHT;
        int previewWidth = ret.getWidth();
        int previewHeight = ret.getHeight();

        if (scratchImage == null)
        {
            scratchImage = new BufferedImage(WIDTH, HEIGHT, TYPE);
            g2 = scratchImage.createGraphics();
        }

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, HINT);
        g2.drawImage(ret, 0, 0, WIDTH, HEIGHT, 0, 0, previewWidth, previewHeight, null);

        ret = scratchImage;

        g2.dispose();

        if (TARGET_WIDTH != ret.getWidth() || TARGET_HEIGHT != ret.getHeight())
        {
            scratchImage = new BufferedImage(TARGET_WIDTH, TARGET_HEIGHT, TYPE);
            g2 = scratchImage.createGraphics();
            g2.drawImage(ret, 0, 0, null);
            g2.dispose();
            ret = scratchImage;
        }

        return ret;
    }

    /**
     * Creates a image that contains the reflection of the given sourceimage.
     * This could be useful whereever you need some eyecandy. Here we use the
     * good working standard values for opacity = 0.5f and fade out height =
     * 0.7f.
     *
     * @param SOURCE_IMAGE
     * @return a new buffered image that contains the reflection of the original
     * image
     */
    public static BufferedImage createReflectionImage(final BufferedImage SOURCE_IMAGE)
    {
        return createReflectionImage(SOURCE_IMAGE, 0.5f, 0.7f);
    }

    /**
     * Creates a image that contains the reflection of the given sourceimage.
     * This could be useful whereever you need some eyecandy.
     *
     * @param SOURCE_IMAGE
     * @param OPACITY a good standard value is 0.5f
     * @param FADE_OUT_HEIGHT a good standard value is 0.7f
     * @return a new buffered image that contains the reflection of the original
     * image
     */
    public static BufferedImage createReflectionImage(final BufferedImage SOURCE_IMAGE, final float OPACITY, final float FADE_OUT_HEIGHT)
    {
        final BufferedImage REFLECTION_IMAGE = new BufferedImage(SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);
        final BufferedImage BLURED_REFLECTION_IMAGE = new BufferedImage(SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight(), BufferedImage.TYPE_INT_ARGB);

        final Graphics2D G2 = REFLECTION_IMAGE.createGraphics();

        G2.translate(0, SOURCE_IMAGE.getHeight());
        G2.scale(1, -1);
        G2.drawRenderedImage(SOURCE_IMAGE, null);
        G2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.DST_IN));
        G2.setPaint(new java.awt.GradientPaint(0, SOURCE_IMAGE.getHeight() * FADE_OUT_HEIGHT, new Color(0.0f, 0.0f, 0.0f, 0.0f), 0, SOURCE_IMAGE.getHeight(), new Color(0.0f, 0.0f, 0.0f, OPACITY)));
        G2.fillRect(0, 0, SOURCE_IMAGE.getWidth(), SOURCE_IMAGE.getHeight());
        G2.dispose();

        // Blur the reflection to make it look more realistic
        float[] data =
        {
            0.0625f,
            0.125f,
            0.0625f,
            0.125f,
            0.25f,
            0.125f,
            0.0625f,
            0.125f,
            0.0625f
        };
        final java.awt.image.Kernel KERNEL = new java.awt.image.Kernel(3, 3, data);
        final java.awt.image.ConvolveOp CONVOLE = new java.awt.image.ConvolveOp(KERNEL, java.awt.image.ConvolveOp.EDGE_NO_OP, null);
        CONVOLE.filter(REFLECTION_IMAGE, BLURED_REFLECTION_IMAGE);

        return BLURED_REFLECTION_IMAGE;
    }

    /**
     * Saves the given buffered image as png image
     *
     * @param IMAGE
     * @param FILE_NAME
     */
    public static void savePngImage(final BufferedImage IMAGE, final String FILE_NAME)
    {
        try
        {
            ImageIO.write(IMAGE, "png", new File(FILE_NAME));
        } catch (final java.io.IOException EXCEPTION)
        {
        }
    }

    /**
     * Returns a buffered image that contains a simple random noise
     *
     * @param WIDTH
     * @param HEIGHT
     * @param COLOR
     * @return a buffered image that contains a simple random noise
     */
    public static BufferedImage createWithNoise(final int WIDTH, final int HEIGHT, final Color COLOR)
    {
        final GraphicsConfiguration GFX_CONF = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        if (WIDTH <= 0 || HEIGHT <= 0)
        {
            return GFX_CONF.createCompatibleImage(1, 1, Transparency.TRANSLUCENT);
        }

        final BufferedImage IMAGE = GFX_CONF.createCompatibleImage(WIDTH, HEIGHT, Transparency.TRANSLUCENT);
        final Graphics2D G2 = IMAGE.createGraphics();
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        G2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        final int imageWidth = IMAGE.getWidth();
        final int imageHeight = IMAGE.getHeight();

        final Color DARK_NOISE = COLOR.darker();
        final Color BRIGHT_NOISE = COLOR.brighter();

        final Random BW_RND = new Random();
        final Random ALPHA_RND = new Random();
        Color noiseColor;
        int noiseAlpha;
        for (int y = 0; y < imageHeight; y++)
        {
            for (int x = 0; x < imageWidth; x++)
            {
                if (BW_RND.nextBoolean())
                {
                    noiseColor = BRIGHT_NOISE;
                } else
                {
                    noiseColor = DARK_NOISE;
                }
                noiseAlpha = 90 + ALPHA_RND.nextInt(90) - 45;
                G2.setColor(new Color(noiseColor.getRed(), noiseColor.getGreen(), noiseColor.getBlue(), noiseAlpha));
                G2.drawLine(x, y, x, y);
            }
        }
        G2.dispose();

        return IMAGE;
    }

    /**
     * Returns a compatible image of the given size and transparency
     *
     * @param width
     * @param height
     * @param transparentcy
     * @return a compatible image of the given size and transparency
     */
    public static BufferedImage createImage(final int width, final int height, final int transparentcy)
    {
        GraphicsConfiguration gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        if (width <= 0 || height <= 0)
        {
            return gfxConf.createCompatibleImage(1, 1, transparentcy);
        }
        return gfxConf.createCompatibleImage(width, height, transparentcy);
    }

    /**
     * Returns a compatible image of the given size and transparency
     *
     * @param dimension
     * @param transparentcy
     * @return a compatible image of the given size and transparency
     */
    public static BufferedImage createImage(final Dimension dimension, final int transparentcy)
    {
        GraphicsConfiguration gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        if (dimension.width <= 0 || dimension.height <= 0)
        {
            return gfxConf.createCompatibleImage(1, 1, transparentcy);
        }
        return gfxConf.createCompatibleImage(dimension.width, dimension.height, transparentcy);
    }

    /**
     * <p>
     * Returns an array of pixels, stored as integers, from a
     * <code>BufferedImage</code>. The pixels are grabbed from a rectangular
     * area defined by a location and two dimensions. Calling this method on an
     * image of type different from <code>BufferedImage.TYPE_INT_ARGB</code> and
     * <code>BufferedImage.TYPE_INT_RGB</code> will unmanage the image.</p>
     *
     * @param IMAGE the source image
     * @param X the x location at which to start grabbing pixels
     * @param Y the y location at which to start grabbing pixels
     * @param W the width of the rectangle of pixels to grab
     * @param H the height of the rectangle of pixels to grab
     * @param pixels a pre-allocated array of pixels of size w*h; can be null
     * @return <code>pixels</code> if non-null, a new array of integers
     * otherwise
     * @throws IllegalArgumentException is <code>pixels</code> is non-null and
     * of length &lt; w*h
     */
    public static int[] getPixels(final BufferedImage IMAGE, final int X, final int Y, final int W, final int H, int[] pixels)
    {
        if (W == 0 || H == 0)
        {
            return new int[0];
        }

        if (pixels == null)
        {
            pixels = new int[W * H];
        } else if (pixels.length < W * H)
        {
            throw new IllegalArgumentException("pixels array must have a length " + " >= w*h");
        }

        int imageType = IMAGE.getType();
        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB)
        {
            Raster raster = IMAGE.getRaster();
            return (int[]) raster.getDataElements(X, Y, W, H, pixels);
        }

        // Unmanages the image
        return IMAGE.getRGB(X, Y, W, H, pixels, 0, W);
    }

    /**
     * <p>
     * Writes a rectangular area of pixels in the destination
     * <code>BufferedImage</code>. Calling this method on an image of type
     * different from <code>BufferedImage.TYPE_INT_ARGB</code> and
     * <code>BufferedImage.TYPE_INT_RGB</code> will unmanage the image.</p>
     *
     * @param IMAGE the destination image
     * @param X the x location at which to start storing pixels
     * @param Y the y location at which to start storing pixels
     * @param W the width of the rectangle of pixels to store
     * @param H the height of the rectangle of pixels to store
     * @param pixels an array of pixels, stored as integers
     * @throws IllegalArgumentException is <code>pixels</code> is non-null and
     * of length &lt; w*h
     */
    public static void setPixels(final BufferedImage IMAGE, final int X, final int Y, final int W, final int H, int[] pixels)
    {
        if (pixels == null || W == 0 || H == 0)
        {
            return;
        } else if (pixels.length < W * H)
        {
            throw new IllegalArgumentException("pixels array must have a length" + " >= w*h");
        }

        int imageType = IMAGE.getType();
        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB)
        {
            WritableRaster raster = IMAGE.getRaster();
            raster.setDataElements(X, Y, W, H, pixels);
        } else
        {
            // Unmanages the image
            IMAGE.setRGB(X, Y, W, H, pixels, 0, W);
        }
    }

}
